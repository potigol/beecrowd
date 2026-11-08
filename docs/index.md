# Soluções da Beecrowd em Potigol

[![Execute no GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/potigol/beecrowd?quickstart=1)

> Mais de 800 problemas da plataforma [Beecrowd](https://beecrowd.com) resolvidos na linguagem [Potigol](https://potigol.github.io/beecrowd).

[![Follow us](https://img.shields.io/twitter/follow/potigol.svg?style=social)](http://twitter.com/potigol)
[![Problemas Resolvidos](https://img.shields.io/badge/Problemas%20Resolvidos-878-blue)](https://github.com/potigol/beecrowd/commits/master)

## Soluções

[1000–1099](problemas/1000.md), [1100–1199](problemas/1100.md), [1200–1299](problemas/1200.md),
[1300–1399](problemas/1300.md), [1400–1499](problemas/1400.md), [1500–1599](problemas/1500.md),
[1600–1699](problemas/1600.md), [1700–1799](problemas/1700.md), [1800–1899](problemas/1800.md),
[1900–1999](problemas/1900.md), [2000–2099](problemas/2000.md), [2100–2199](problemas/2100.md),
[2200–2299](problemas/2200.md), [2300–2399](problemas/2300.md), [2400–2499](problemas/2400.md),
[2500–2599](problemas/2500.md), [2600–2699](problemas/2600.md), [2700–2799](problemas/2700.md),
[2800–2899](problemas/2800.md), [2900–2999](problemas/2900.md), [3000–3099](problemas/3000.md),
[3100–3199](problemas/3100.md), [3200–3299](problemas/3200.md), [3300–3399](problemas/3300.md),
[3400–3499](problemas/3400.md), [3500–3599](problemas/3500.md), [4000-4099](problemas/4000.md)

## Problemas por categoria

- [Iniciante](categorias/iniciante.md): fundamentos de entrada, saída e lógica.
- [Ad-hoc](categorias/adhoc.md): simulação, datas e problemas gerais.
- [Strings](categorias/strings.md): palíndromos, frequência, LCS e manipulação de texto.
- [Estruturas e Bibliotecas](categorias/estruturasebibliotecas.md): filas, pilhas, ordenação e mapas.
- [Matemática](categorias/matemática.md): sistemas numéricos, primos e BigInteger.
- [Paradigmas](categorias/paradigmas.md): programação dinâmica, busca binária, gulosos e backtracking.
- [Grafos](categorias/grafos.md): flood fill, MST, SSSP, DAG, fluxo máximo e árvores.
- [Geometria Computacional](categorias/geometriacomputacional.md): pontos, linhas e polígonos.

## Problemas de Competições de Programação

- [Maratona de Programação da SBC/ACM](competicoes/maratona/README.md)
- [Olimpíada Brasileira de Informática (OBI)](competicoes/obi/README.md)
- [Olimpíada Interna de Programação do IFSULDEMINAS (OLIP)](competicoes/outras/olip/README.md)
- [Fase Zero da Mratona de Programação da SBC](competicoes/outras/fasezero/README.md)

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
