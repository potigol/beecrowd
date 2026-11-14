import re
import json
import unicodedata
from dataclasses import dataclass, field
from pathlib import Path


@dataclass
class Problem:
    number: int | str
    name: str
    category: str
    url: str | None = None
    levels: list[str] = field(default_factory=list)


@dataclass
class Category:
    name: str
    problems: list[Problem] = field(default_factory=list)


@dataclass
class Competition:
    name: str
    years: list["Year"] = field(default_factory=list)


@dataclass
class Year:
    year: int
    rounds: list["Round"] = field(default_factory=list)


@dataclass
class Round:
    name: str
    problems: list[Problem] = field(default_factory=list)


CONFIG: dict[str, str] = {}

LEVEL_ORDER = "mj12su"
LEVEL_ICONS = {
    "m": "alpha-m-circle-outline",
    "j": "alpha-j-circle-outline",
    "1": "numeric-1-circle-outline",
    "2": "numeric-2-circle-outline",
    "s": "alpha-s-circle-outline",
    "u": "alpha-u-circle-outline",
    "x": "circle-outline",
}


def normalize_level(value: str) -> str:
    cleaned = unicodedata.normalize("NFKD", value).encode("ascii", "ignore").decode("ascii")
    cleaned = cleaned.strip().lower().replace("-", " ")
    aliases = {
        "mirim": "m",
        "junior": "j",
        "senior": "s",
        "universitario": "u",
        "universitário": "u",
        "não especificado": "x",
        "nao especificado": "x",
    }
    return aliases.get(cleaned, cleaned)


def problem_levels(problem: Problem) -> str:
    seen: set[str] = set()
    for level in problem.levels:
        key = normalize_level(str(level))
        if key in LEVEL_ICONS:
            seen.add(key)

    ordered = []
    for key in LEVEL_ORDER:
        if key in seen:
            ordered.append(f":material-{LEVEL_ICONS[key]}:")
    return " ".join(ordered)


class Text:
    @staticmethod
    def unsolved(problem: Problem, show_category: bool = True) -> str:
        category = (
            f" *{problem.category}*"
            if show_category and not is_excluded_category(problem.category)
            else ""
        )
        level_icons = problem_levels(problem)
        # Use URL from problem if available, otherwise construct default link
        link = problem.url if problem.url else f"{CONFIG['prefix']}{problem.number}.html"
        return (
            f"- [ ] [{problem.number}]({link}) - "
            f"{problem.name}{category}{f' {level_icons}' if level_icons else ''}"
        )

    @staticmethod
    def solved(problem: Problem, show_category: bool = True) -> str:
        category = (
            f" *{problem.category}*"
            if show_category and not is_excluded_category(problem.category)
            else ""
        )
        level_icons = problem_levels(problem)
        # Use URL from problem if available, otherwise construct default link
        link = problem.url if problem.url else f"{CONFIG['site']}/{dir(problem.number)}/#{anchor(problem)}"
        return (
            f"- [x] [{problem.number}]({link}) - "
            f"[{problem.name}]({CONFIG['site']}/{dir(problem.number)}/"
            f"#{anchor(problem)}){category}{f' {level_icons}' if level_icons else ''}"
        )

    absent = "" # "- [ ] ~~xxxx~~"


def slugify(value: str) -> str:
    # Mesmo algoritmo do slugify padrão do toc (Python-Markdown/MkDocs)
    value = unicodedata.normalize("NFKD", value).encode("ascii", "ignore").decode("ascii")
    value = re.sub(r"[^\w\s-]", "", value).strip().lower()
    return re.sub(r"[-\s]+", "-", value)


def is_excluded_category(category: str) -> bool:
    return slugify(category) == "excluido"


def anchor(problem: Problem) -> str:
    return slugify(f"{problem.number} - {problem.name}")


def clean(value: str) -> str:
    return "".join(char for char in value.lower() if char.isalpha())


def problem_exists(problem: int | str, extension: str, path: str = "../src") -> bool:
    problem_id = str(problem)
    
    # For numeric IDs, check in src/xx00/
    if problem_id.isdigit():
        folder = str(int(problem_id) // 100 * 100)
        return (Path(path) / folder / f"{problem_id}.{extension}").exists()
    
    # For string IDs (like sbc23f1a), check in src/externos/
    # Determine the competition type from ID
    if problem_id.startswith("sbc"):
        # Extract year and phase from ID (e.g., "sbc23f1a" -> year 2023, phase f1)
        year = int("20" + problem_id[3:5])
        comp_path = Path(path) / "externos" / "sbc" / str(year) / f"{problem_id}.{extension}"
        if comp_path.exists():
            return True
        # Also check if it's fase zero (sbc24f0a)
        if problem_id[5:7] == "f0":
            comp_path = Path(path) / "externos" / "zero" / str(year) / f"{problem_id}.{extension}"
            return comp_path.exists()
    elif problem_id.startswith("obi"):
        year = int("20" + problem_id[3:5])
        return (Path(path) / "externos" / "obi" / str(year) / f"{problem_id}.{extension}").exists()
    
    return False


def dir(problem: int | str) -> str:
    """Return the directory path for a problem."""
    problem_id = str(problem)
    
    if problem_id.isdigit():
        # Numeric IDs: return xx00 format
        folder_num = int(problem_id) // 100 * 100
        return str(folder_num)
    else:
        # String IDs: return externos/competition/year
        if problem_id.startswith("sbc"):
            year = int("20" + problem_id[3:5])
            if problem_id[5:7] == "f0":
                return f"externos/zero/{year}"
            else:
                return f"externos/sbc/{year}"
        elif problem_id.startswith("obi"):
            year = int("20" + problem_id[3:5])
            return f"externos/obi/{year}"
    
    return "externos"


def save_to_file(name: str, title: str, content: str) -> None:
    output = Path(name)
    output.parent.mkdir(parents=True, exist_ok=True)
    output.write_text(f"# {title}\n\n{content}", encoding="utf-8")


def get_contest_from_json(file: str, competition_name: str, phase_filter: str | None = None) -> dict[int, list[int | str]]:
    """Extract problems from JSON grouped by year for a specific competition and optional phase."""
    contests: dict[int, list[int | str]] = {}
    
    with open(file, encoding="utf-8") as source:
        data = json.load(source)
    
    for item in data:
        try:
            origins = item.get('origins', [])
            if not origins:
                continue
            
            origin = origins[0]
            if origin.get('name') != competition_name:
                continue
            
            # Filter by phase if specified
            if phase_filter is not None:
                stage = origin.get('stage')
                phase = origin.get('phase')
                # For Maratona, look for "stage"
                if stage and phase_filter not in stage:
                    continue
                # For OBI, look for "phase"
                if not stage and phase and phase_filter not in phase:
                    continue
            
            year = origin.get('year')
            if year is not None:
                problem_id = item['id']
                # Try to convert to int if numeric, otherwise keep as string
                try:
                    problem_id = int(problem_id)
                except (ValueError, TypeError):
                    pass
                contests.setdefault(year, []).append(problem_id)
        except (KeyError, TypeError):
            continue
    
    # Sort problems by ID within each year (numeric IDs first, then string IDs)
    for year in contests:
        contests[year].sort(key=lambda x: (isinstance(x, str), x))
    
    return contests


def get_contest(file: str) -> dict[int, list[int | str]]:
    """Legacy function - now reads from JSON instead of text files."""
    # Map old file names to new extraction parameters
    file_mapping = {
        "obi.txt": ("OBI", None),
        "olip.txt": ("OLIP", None),
        "maratona0.txt": ("Maratona SBC", "Fase Zero"),
        "maratona1.txt": ("Maratona SBC", "Primeira Fase"),
        "maratona2.txt": ("Maratona SBC", "Segunda Fase"),
    }
    
    if file in file_mapping:
        comp_name, phase = file_mapping[file]
        return get_contest_from_json("problems.json", comp_name, phase)
    
    # Fallback to old behavior if file is not in mapping
    contests: dict[int, list[int | str]] = {}
    for line in get_lines(file):
        parts = line.split(" ")
        year = int(parts[0])
        problems = []
        for problem_range in parts[1].split(","):
            start = int(problem_range[:4])
            end = int(problem_range[-4:])
            problems.extend(range(start, end + 1))
        contests[year] = problems
    return contests


def list_contest(
    contest: dict[int, list[int]], year: int, problems: dict[int, Problem]
) -> str:
    return "\n".join(line(problems.get(number)) for number in contest.get(year, []))


def line(problem: Problem | None, show_category: bool = True) -> str:
    if problem is None:
        return Text.absent
    if problem_exists(problem.number, CONFIG["extension"]):
        return Text.solved(problem, show_category)
    return Text.unsolved(problem, show_category)


def read_config(file: str) -> dict[str, str]:
    config = {}
    for line_text in get_lines(file):
        key, value = line_text.split("=")
        config[key.strip()] = value.strip()
    return config


def lista_geral(
    pagina_final: int, problems: dict[int | str, Problem], path: str = "../src/"
) -> None:
    for page in range(10, pagina_final + 1):
        content = "\n".join(
            line(problems.get(page * 100 + offset)) for offset in range(100)
        )
        solved = content.count("[x]")
        absent = content.count(" ~~")
        total = content.count("[ ]") + solved - absent
        save_to_file(
            f"{path}{dir(page * 100)}/README.md",
            f"Problemas {dir(page * 100)} ({solved}/{total})",
            content,
        )


def save(problems: dict[int | str, Problem], *files: str) -> dict[int | str, Problem]:
    contest_numbers = []
    contests_by_year: dict[int, list[int]] = {}
    for file in files:
        for year, numbers in get_contest(file).items():
            contests_by_year.setdefault(year, []).extend(numbers)
    for numbers in contests_by_year.values():
        contest_numbers.extend(numbers)
    return {
        number: problems[number]
        for number in contest_numbers
        if number in problems
    }


def lista_categoria(
    problems: dict[int | str, Problem], path: str = "../docs/categorias/"
) -> None:
    grouped_by_category: dict[str, list[Problem]] = {}
    for problem in problems.values():
        if is_excluded_category(problem.category):
            continue
        grouped_by_category.setdefault(problem.category, []).append(problem)

    for category, problem_list in grouped_by_category.items():
        solved = []
        unsolved = []
        for problem in problem_list:
            target = (
                solved
                if problem_exists(problem.number, CONFIG["extension"])
                else unsolved
            )
            target.append(problem)
        resolved_lines = sorted(
            Text.solved(problem, show_category=False) for problem in solved
        )
        unresolved_lines = sorted(
            Text.unsolved(problem, show_category=False) for problem in unsolved
        )
        content = "\n".join(
            ["## Problemas resolvidos\n", *resolved_lines]
        ) + "\n".join(
            ["\n\n## Problemas não resolvidos\n", *unresolved_lines]
        ) + "\n"
        save_to_file(
            f"{path}{clean(category)}.md",
            f"{category} ({len(resolved_lines)} / {len(problem_list)})",
            content,
        )


def get_categories_block() -> str:
    """Return the categories navigation block for competition README files."""
    return """## Categorias

[Iniciante](iniciante.md) ·
[Ad-hoc](adhoc.md) ·
[Strings](strings.md) ·
[Estruturas e Bibliotecas](estruturasebibliotecas.md) ·
[Matemática](matemática.md) ·
[Paradigmas](paradigmas.md) ·
[Grafos](grafos.md) ·
[Geometria Computacional](geometriacomputacional.md)
"""


def duasfases(
    problems: dict[int | str, Problem], c1: str, c2: str, file: str, title: str
) -> None:
    contest1 = get_contest(c1)
    contest2 = get_contest(c2)
    sections = []
    for year in sorted(contest2, reverse=True):
        phase1 = (
            f"\n### {year} 1ª Fase\n\n{list_contest(contest1, year, problems)}\n"
            if year in contest1
            else ""
        )
        sections.append(
            f"## {year}\n{phase1}\n\n### {year} 2ª Fase\n\n"
            f"{list_contest(contest2, year, problems)}\n       "
        )
    content = get_categories_block() + "\n" + "\n".join(sections)
    solved = content.count("[x]")
    total = content.count("[ ]") + solved
    save_to_file(file, f"{title} ({solved} / {total})", content)


def umafase(problems: dict[int | str, Problem], c1: str, file: str, title: str) -> None:
    contest = get_contest(c1)
    sections = []
    for year in sorted(contest, reverse=True):
        entries = "\n".join(
            line(problems.get(number)) for number in contest.get(year, [])
        )
        sections.append(f"\n\n## {year}\n\n{entries}")
    content = get_categories_block() + "".join(sections)
    solved = content.count("[x]")
    total = content.count("[ ]") + solved
    save_to_file(file, f"{title} ({solved} / {total})", content)


def problem_list(file: str) -> dict[int | str, Problem]:
    problems = {}
    with open(file, encoding="utf-8") as source:
        data = json.load(source)
    
    for item in data:
        try:
            problem_id = item['id']
            title = item.get('title', '')
            category = item.get('category', '')
            levels: list[str] = []
            for origin in item.get('origins', []):
                for level in origin.get('levels', []):
                    if level and level not in levels:
                        levels.append(str(level))

            # Extract URL from statements, preferring URLs with requires_login=false
            url = None
            statements = item.get('statements', [])
            if statements:
                # First, try to find a URL with requires_login=false
                for statement in statements:
                    if statement.get('requires_login') == False:
                        url = statement.get('url')
                        break
                
                # If no URL with requires_login=false, use first available URL
                if url is None and len(statements) > 0:
                    url = statements[0].get('url')
            
            # Try to convert to int if it's numeric, otherwise keep as string
            try:
                problem_id = int(problem_id)
            except ValueError:
                pass
            
            problem = Problem(problem_id, title, category, url, levels)
            problems[problem.number] = problem
        except KeyError:
            continue
    
    return problems


def get_lines(file: str) -> list[str]:
    with open(file, encoding="utf-8") as source:
        return source.read().splitlines()


def main() -> None:
    global CONFIG
    CONFIG = read_config("config.txt")
    problems = problem_list("problems.json")

    # Per-folder lists (src/xx00/README.md)
    lista_geral(35, problems)

    # Per-category lists
    lista_categoria(problems)
    lista_categoria(save(problems, "obi.txt"), "../docs/competicoes/obi/")
    lista_categoria(
        save(problems, "maratona1.txt", "maratona2.txt"),
        "../docs/competicoes/maratona/",
    )
    lista_categoria(save(problems, "olip.txt"), "../docs/competicoes/outras/olip/")
    lista_categoria(
        save(problems, "maratona0.txt"), "../docs/competicoes/outras/fasezero/"
    )

    # Per-competition chronological lists
    duasfases(
        problems,
        "maratona1.txt",
        "maratona2.txt",
        "../docs/competicoes/maratona/README.md",
        "Maratona de Programação",
    )
    umafase(
        problems,
        "obi.txt",
        "../docs/competicoes/obi/README.md",
        "Olimpíada Brasileira de Informática",
    )
    umafase(
        problems,
        "olip.txt",
        "../docs/competicoes/outras/olip/README.md",
        "Olimpíada IFSULDEMINAS",
    )
    umafase(
        problems,
        "maratona0.txt",
        "../docs/competicoes/outras/fasezero/README.md",
        "Fase Zero - Maratona SBC",
    )

if __name__ == "__main__":
    main()
