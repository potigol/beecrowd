import os
import json
import re
from pathlib import Path
import yaml  # Requer PyYAML (pip install pyyaml)

def carregar_problemas_json(caminho='bin/problems.json'):
    """Carrega os problemas do JSON com títulos e categorias."""
    titulos = {}
    dificuldades = {}
    competicoes = {}
    
    try:
        with open(caminho, 'r', encoding='utf-8') as f:
            data = json.load(f)
        
        for problema in data:
            numero = problema.get('id', '')
            titulo = problema.get('title', '')
            categoria = problema.get('category', '')
            origins = problema.get('origins', [])
            
            if numero:
                titulos[numero] = titulo
                if categoria != 'Excluído':
                    dificuldades[numero] = categoria
                
                # Extrair competições
                for origin in origins:
                    if origin.get('type') == 'competition':
                        nome_comp = origin.get('name', '')
                        ano = origin.get('year', '')
                        stage = origin.get('stage', '')
                        
                        # Mapear nome da competição
                        if 'Maratona' in nome_comp:
                            if stage == 'Primeira Fase':
                                comp_nome = 'Maratona SBC (1ª fase)'
                            elif stage == 'Segunda Fase':
                                comp_nome = 'Maratona SBC (2ª fase)'
                            else:
                                comp_nome = nome_comp
                            icone = ':material-trophy:'
                        elif 'OBI' in nome_comp:
                            comp_nome = 'OBI'
                            icone = ':material-medal:'
                        elif 'OLIP' in nome_comp or 'IFSULDEMINAS' in nome_comp:
                            comp_nome = 'Olimpíada IFSULDEMINAS'
                            icone = ':material-school:'
                        else:
                            comp_nome = nome_comp
                            icone = ':material-star:'
                        
                        caminho = 'competicoes/maratona' if 'Maratona' in nome_comp else f'competicoes/{nome_comp.lower()}'
                        
                        competicoes.setdefault(numero, []).append((comp_nome, icone, caminho, str(ano)))
    
    except FileNotFoundError:
        print(f"⚠️ Arquivo {caminho} não encontrado. Nomes de problemas não serão adicionados.")
    except json.JSONDecodeError:
        print(f"⚠️ Erro ao decodificar JSON em {caminho}.")
    
    return titulos, dificuldades, competicoes

SITE = 'https://potigol.github.io/beecrowd'

def limpar_categoria(categoria):
    """Nome do arquivo/URL da categoria (apenas letras minúsculas)."""
    return ''.join(c for c in categoria.lower() if c.isalpha())

def linha_classificacao(categoria, competicoes):
    """Linha em Markdown com a categoria e as competições do problema."""
    partes = []
    if categoria:
        partes.append(f"Categoria: [{categoria}]({SITE}/categorias/{limpar_categoria(categoria)}/)")
    for nome, icone, caminho, ano in competicoes:
        partes.append(f"{icone} [{nome} {ano}]({SITE}/{caminho}/)")
    return ' · '.join(partes)

def agrupar_arquivos_poti(src_dir='src', dest_dir='docs/problemas'):
    """Agrupa arquivos .poti em arquivos Markdown otimizados para MkDocs Material."""
    titulos, dificuldades, competicoes = carregar_problemas_json()
    nav_items = []
    
    Path(dest_dir).mkdir(parents=True, exist_ok=True)
    conteudos_por_pasta = {}

    # Processamento dos arquivos
    for root, _, files in os.walk(src_dir):
        for file in sorted(files):
            if file.endswith('.poti'):
                numero = os.path.splitext(file)[0]
                rel_path = os.path.relpath(root, src_dir)
                
                if rel_path not in conteudos_por_pasta:
                    conteudos_por_pasta[rel_path] = []
                
                try:
                    with open(os.path.join(root, file), 'r', encoding='utf-8') as f:
                        conteudo = f.read().strip()
                    
                    titulo = titulos.get(numero, "")
                    dificuldade = dificuldades.get(numero, "")
                    
                    conteudos_por_pasta[rel_path].append({
                        'numero': numero,
                        'arquivo': file,
                        'titulo': titulo,
                        'dificuldade': dificuldade,
                        'competicoes': competicoes.get(numero, []),
                        'conteudo': conteudo
                    })
                except Exception as e:
                    print(f"❌ Erro em {file}: {str(e)}")

    # Encontrar problemas não resolvidos por faixa
    problemas_nao_resolvidos = {}
    for rel_path in conteudos_por_pasta.keys():
        if rel_path != '.' and rel_path.isdigit():
            inicio = int(rel_path)
            fim = inicio + 99
            numeros_resolvidos = set(p['numero'] for p in conteudos_por_pasta[rel_path])
            nao_resolvidos = [n for n in range(inicio, fim + 1) if str(n) not in numeros_resolvidos]
            problemas_nao_resolvidos[rel_path] = nao_resolvidos

    # Geração dos arquivos
    for grupo, problemas in conteudos_por_pasta.items():
        # Gerar item de navegação
        if grupo == '.':
            nav_items.append({'Geral': 'problemas/geral.md'})
        else:
            try:
                faixa = f"{grupo}-{int(grupo)+99}"
                nav_items.append({f"Problemas {faixa}": f"problemas/{grupo}.md"})
            except ValueError:
                nav_items.append({grupo: f"problemas/{grupo}.md"})
        
        md_file = 'geral.md' if grupo == '.' else f"{grupo}.md"
        md_path = os.path.join(dest_dir, md_file)
        
        try:
            with open(md_path, 'w', encoding='utf-8') as f:
                # Front Matter otimizado para Material
                front_matter = {
                    'title': f"{grupo}" if grupo != '.' else 'Problemas Gerais',
                    'description': f"{grupo}-{int(grupo)+99}" if grupo != '.' and grupo.isdigit() else grupo,
                 #   'hide': ['toc'],  # Oculta o TOC automático
                    'tags': ['problemas', 'poti'],
                }
                
#                if grupo.isdigit():
#                    front_matter['icon'] = ':material-numeric:'
                
                f.write("---\n")
                f.write(yaml.dump(front_matter, allow_unicode=True, sort_keys=False))
                f.write("---\n\n")
                
                f.write(f"# {front_matter['title']}\n\n")
                
                if grupo != '.' and grupo.isdigit():
                    f.write(f"!!! info \"Faixa de problemas: {grupo}-{int(grupo)+99}\"\n")
                    f.write(f"    Total resolvido: {len(problemas)} de 100 problemas\n\n")

                    # Adicionar lista de problemas não resolvidos
                    nao_resolvidos = problemas_nao_resolvidos.get(grupo, [])
                    if nao_resolvidos:
                        f.write(f"!!! warning \"Problemas não resolvidos ({len(nao_resolvidos)})\"\n")
                        links = ', '.join(
                            f"[{n}](https://judge.beecrowd.com/pt/problems/view/{n})"
                            for n in nao_resolvidos
                        )
                        f.write(f"    {links}\n\n")
                
                # Tabs container para alternar entre visualizações
            #    f.write("=== \"Lista de Problemas\"\n")
            #    f.write("    ```markdown\n")
            #    f.write("    Tabela gerada automaticamente:\n    \n")
            #    f.write("    | Número | Título | Dificuldade |\n")
            #    f.write("    |--------|--------|-------------|\n")
            #    for p in sorted(problemas, key=lambda x: x['numero']):
            #        f.write(f"    | [{p['numero']}](#{p['numero'].lower()}) | {p['titulo']} | {p['dificuldade']} |\n")
            #    f.write("    ```\n\n")
                
            #    f.write("=== \"Conteúdos\"\n")
                for p in sorted(problemas, key=lambda x: x['numero']):
                    # Seção do problema com âncora
                    f.write(f"## {p['numero']} - {p['titulo']}\n\n")
                    f.write(f"Descrição do Problema: [{p['numero']} - {p['titulo']}](https://resources.beecrowd.com/repository/UOJ_{p['numero']}.html)\n\n")

                    classificacao = linha_classificacao(p['dificuldade'], p['competicoes'])
                    if classificacao:
                        f.write(f"{classificacao}\n\n")
                    
                    # Admonition com metadados
                #    if p['dificuldade']:
                #        f.write(f"!!! info \"Metadados\"\n")
                #        f.write(f"    **Dificuldade:** {p['dificuldade']}\n\n")
                    
                    # Bloco de código com cópia habilitada
                    f.write("```poti title=\"{} - {}\" linenums=\"1\"\n".format(
                        os.path.splitext(p['arquivo'])[0], p['titulo']))
                    f.write(f"{p['conteudo']}\n")
                    f.write("```\n\n")
            
            print(f"✅ {md_path} ({len(problemas)} problemas)")
        except Exception as e:
            print(f"❌ Erro ao criar {md_path}: {str(e)}")

    # Atualiza o mkdocs.yml
  #  atualizar_mkdocs(nav_items)

def atualizar_mkdocs(nav_items):
    """Atualiza o arquivo mkdocs.yml com a navegação gerada."""
    try:
        with open('mkdocs.yml', 'r+', encoding='utf-8') as f:
            config = yaml.safe_load(f) or {}
            
            # Cria a seção de navegação se não existir
            if 'nav' not in config:
                config['nav'] = []
            
            # Adiciona a seção de problemas se não existir
            problemas_nav = next((item for item in config['nav'] if 'Problemas' in item), None)
            
            if not problemas_nav:
                config['nav'].append({'Problemas': nav_items})
            else:
                problemas_nav['Problemas'] = nav_items
            
            # Escreve de volta o arquivo
            f.seek(0)
            yaml.dump(config, f, allow_unicode=True, sort_keys=False)
            f.truncate()
            
        print("🔄 mkdocs.yml atualizado com sucesso!")
    except Exception as e:
        print(f"⚠️ Não foi possível atualizar mkdocs.yml: {str(e)}")

if __name__ == "__main__":
    agrupar_arquivos_poti()