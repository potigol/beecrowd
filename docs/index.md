# Soluções da Beecrowd em Potigol

[![Execute no GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/potigol/beecrowd?quickstart=1)

> Mais de 800 problemas da plataforma [Beecrowd](https://beecrowd.com) resolvidos na linguagem [Potigol](https://potigol.github.io/beecrowd).

[![Problemas Resolvidos](https://img.shields.io/badge/Problemas%20Resolvidos-886-blue)](https://github.com/potigol/beecrowd/commits/master)
[![Follow us](https://img.shields.io/twitter/follow/potigol.svg?style=social)](http://twitter.com/potigol)

## Problemas por categoria

- [Iniciante](categorias/iniciante.md): fundamentos de entrada, saída e lógica.
- [Ad-hoc](categorias/adhoc.md): simulação, datas e problemas gerais.
- [Strings](categorias/strings.md): palíndromos, frequência, LCS e manipulação de texto.
- [Estruturas e Bibliotecas](categorias/estruturasebibliotecas.md): filas, pilhas, ordenação e mapas.
- [Matemática](categorias/matemática.md): sistemas numéricos, primos e BigInteger.
- [Paradigmas](categorias/paradigmas.md): programação dinâmica, busca binária, gulosos e backtracking.
- [Grafos](categorias/grafos.md): flood fill, MST, SSSP, DAG, fluxo máximo e árvores.
- [Geometria Computacional](categorias/geometriacomputacional.md): pontos, linhas e polígonos.

## Competições de programação

- [Maratona de Programação da SBC/ACM](competicoes/maratona/)
- [Olimpíada Brasileira de Informática (OBI)](competicoes/obi/)
- [Olimpíada Interna de Programação do IFSULDEMINAS (OLIP)](competicoes/outras/olip/)
- [Fase Zero da Mratona de Programação da SBC](competicoes/outras/fasezero/)

## Problemas por faixa

[1000](problemas/1000/), [1100](problemas/1100/), [1200](problemas/1200/),
[1300](problemas/1300/), [1400](problemas/1400/), [1500](problemas/1500/),
[1600](problemas/1600/), [1700](problemas/1700/), [1800](problemas/1800/),
[1900](problemas/1900/), [2000](problemas/2000/), [2100](problemas/2100/),
[2200](problemas/2200/), [2300](problemas/2300/), [2400](problemas/2400/),
[2500](problemas/2500/), [2600](problemas/2600/), [2700](problemas/2700/),
[2800](problemas/2800/), [2900](problemas/2900/), [3000](problemas/3000/),
[3100](problemas/3100/), [3200](problemas/3200/), [3300](problemas/3300/),
[3400](problemas/3400/), [3500](problemas/3500/), [4000](problemas/4000/)

## Verificação das soluções

Todas as soluções apresentadas neste repositório foram aceitas na plataforma Beecrowd. Embora originalmente escritas em Potigol, elas foram traduzidas automaticamente para Scala por meio do transpilador [Potigol2Scala](https://github.com/potigol/potigol2scala). A submissão e a validação das soluções na plataforma foram realizadas utilizando o código Scala gerado pelo transpilador.

## Codespace

No GitHub Codespaces, execute um arquivo Potigol pelo terminal com:

```sh
potigol 1234.poti
potigol2scala 1234.poti
```

O comando `potigol2scala` gera o arquivo Scala ao lado do arquivo Potigol informado e pode ser executado de qualquer diretório.
Por exemplo, `potigol2scala 1234.poti` gera `1234.poti.scala`. Esse arquivo pode ser enviado ao Beecrowd para testar a solução.

Para executar o arquivo `.poti` aberto no editor, use o botão **Run Code** (ícone de execução no canto superior direito). O editor salva o arquivo antes de executar e abre o terminal integrado.

Para executar todos os casos de teste em `src/*/exemplos`, use:

```sh
test_potigol
# Ou teste apenas um problema:
test_potigol 1001
```

## Como contribuir

1. Use o [editor online de Potigol](https://codespaces.new/potigol/beecrowd?quickstart=1) ou faça um fork de [potigol/beecrowd](https://github.com/potigol/beecrowd).
2. Escolha um problema ainda não resolvido.
3. Adicione sua solução em src/xx00/xxxx.poti.
4. Opcional: teste localmente com potigol xxxx.poti.
5. Abra um pull request.
