import os
from pathlib import Path
import yaml  # Requer PyYAML (pip install pyyaml)

def carregar_titulos_problemas(caminho='bin/problems.txt'):
    """Carrega os títulos e metadados dos problemas."""
    titulos = {}
    dificuldades = {}
    try:
        with open(caminho, 'r', encoding='utf-8') as f:
            for linha in f:
                partes = linha.strip().split('\t')
                if len(partes) >= 2:
                    numero = partes[0].strip()
                    titulos[numero] = partes[1].strip()
                    if len(partes) >= 3:
                        dificuldades[numero] = partes[2].strip()
    except FileNotFoundError:
        print(f"⚠️ Arquivo {caminho} não encontrado. Nomes de problemas não serão adicionados.")
    return titulos, dificuldades

def gerar_nav_item(grupo, arquivos):
    """Gera um item de navegação para o mkdocs.yml."""
    if grupo == '.':
        return {'Geral': 'problemas/geral.md'}
    
    try:
        faixa = f"{grupo}-{int(grupo)+99}"
        return {f"Problemas {faixa}": f"problemas/{grupo}.md"}
    except ValueError:
        return {grupo: f"problemas/{grupo}.md"}

def agrupar_arquivos_poti(src_dir='src', dest_dir='docs/problemas'):
    """Agrupa arquivos .poti em arquivos Markdown otimizados para MkDocs Material."""
    titulos, dificuldades = carregar_titulos_problemas()
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
                        'conteudo': conteudo
                    })
                except Exception as e:
                    print(f"❌ Erro em {file}: {str(e)}")

    # Geração dos arquivos
    for grupo, problemas in conteudos_por_pasta.items():
        nav_items.append(gerar_nav_item(grupo, problemas))
        
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
                    f.write(f"    Total: {len(problemas)} problemas\n\n")
                
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