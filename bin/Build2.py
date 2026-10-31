from dataclasses import dataclass, field
from pathlib import Path


@dataclass
class Problem:
    number: int
    name: str
    category: str


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


class Text:
    @staticmethod
    def unsolved(problem: Problem, show_category: bool = True) -> str:
        category = f" *{problem.category}*" if show_category else ""
        return (
            f"- [ ] [{problem.number}]({CONFIG['prefix']}{problem.number}.html) - "
            f"{problem.name}{category}"
        )

    @staticmethod
    def solved(problem: Problem, show_category: bool = True) -> str:
        category = f" *{problem.category}*" if show_category else ""
        return (
            f"- [x] [{problem.number}]({CONFIG['prefix']}{problem.number}.html) - "
            f"[{problem.name}]({CONFIG['code']}/{dir(problem.number)}/"
            f"{problem.number}.{CONFIG['extension']}){category}"
        )

    absent = "- [ ] ~~xxxx~~"


def clean(value: str) -> str:
    return "".join(char for char in value.lower() if char.isalpha())


def problem_exists(problem: int, extension: str, path: str = "../src") -> bool:
    return (Path(path) / dir(problem) / f"{problem}.{extension}").exists()


def dir(problem: int) -> str:
    return str(problem // 100 * 100)


def save_to_file(name: str, title: str, content: str) -> None:
    output = Path(name)
    output.parent.mkdir(parents=True, exist_ok=True)
    output.write_text(f"# {title}\n\n{content}", encoding="utf-8")


def get_contest(file: str) -> dict[int, list[int]]:
    contests: dict[int, list[int]] = {}
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
    pagina_final: int, problems: dict[int, Problem], path: str = "../src/"
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


def save(problems: dict[int, Problem], *files: str) -> dict[int, Problem]:
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
    problems: dict[int, Problem], path: str = "../docs/categorias/"
) -> None:
    grouped_by_category: dict[str, list[Problem]] = {}
    for problem in problems.values():
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
            ["\n\n## Problemas resolvidos\n", *resolved_lines]
        ) + "\n".join(
            ["\n\n## Problemas não resolvidos\n", *unresolved_lines]
        )
        save_to_file(
            f"{path}{clean(category)}.md",
            f"{category} ({len(resolved_lines)} / {len(problem_list)})",
            content,
        )


def duasfases(
    problems: dict[int, Problem], c1: str, c2: str, file: str, title: str
) -> None:
    contest1 = get_contest(c1)
    contest2 = get_contest(c2)
    sections = []
    for year in sorted(contest2, reverse=True):
        phase1 = (
            f"\n### 1ª Fase\n\n{list_contest(contest1, year, problems)}"
            if year in contest1
            else ""
        )
        sections.append(
            f"\n## {year}\n{phase1}\n\n### 2ª Fase\n\n"
            f"{list_contest(contest2, year, problems)}\n       "
        )
    content = "\n".join(sections)
    solved = content.count("[x]")
    total = content.count("[ ]") + solved
    save_to_file(file, f"{title} ({solved} / {total})", content)


def umafase(problems: dict[int, Problem], c1: str, file: str, title: str) -> None:
    contest = get_contest(c1)
    sections = []
    for year in sorted(contest, reverse=True):
        entries = "\n".join(
            line(problems.get(number)) for number in contest.get(year, [])
        )
        sections.append(f"\n\n## {year}\n\n{entries}")
    content = "".join(sections)
    solved = content.count("[x]")
    total = content.count("[ ]") + solved
    save_to_file(file, f"{title} ({solved} / {total})", content)


def problem_list(file: str) -> dict[int, Problem]:
    problems = {}
    for line_text in get_lines(file):
        parts = line_text.split("\t")
        problem = Problem(int(parts[0]), parts[1], parts[2] if len(parts) > 2 else "")
        problems[problem.number] = problem
    return problems


def get_lines(file: str) -> list[str]:
    with open(file, encoding="utf-8") as source:
        return source.read().splitlines()


def main() -> None:
    global CONFIG
    CONFIG = read_config("config.txt")
    problems = problem_list("problems.txt")

    # Per-folder lists (src/xx00/README.md)
    lista_geral(40, problems)

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
