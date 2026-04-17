# Beecrowd em Potigol

> Mais de 800 problemas do Beecrowd resolvidos em Potigol, com navegação por faixa, categoria e competições.

[![Problemas Resolvidos](https://img.shields.io/badge/Problemas%20Resolvidos-849-blue)](https://github.com/potigol/beecrowd/commits/master)
[![Follow us](https://img.shields.io/twitter/follow/potigol.svg?style=social)](http://twitter.com/potigol)

[![Execute no GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/potigol/beecrowd?quickstart=1)

[Explorar problemas](src) • [Ver categorias](categorias) • [Contribuir agora](#como-contribuir)

## Navegação rápida

| Quero... | Ir para |
| --- | --- |
| Resolver problemas básicos | [Iniciante](categorias/iniciante.md) |
| Praticar grafos e algoritmos clássicos | [Grafos](categorias/grafos.md) |
| Treinar com histórico de provas | [Maratona SBC/ACM](competicoes/maratona) |
| Ver toda a base de soluções | [Pasta src](src) |

## Índice

- [Por que este repositório](#por-que-este-repositório)
- [Problemas por categoria](#problemas-por-categoria)
- [Competições de programação](#competições-de-programação)
- [Problemas por faixa](#problemas-por-faixa)
- [Como contribuir](#como-contribuir)

## Por que este repositório

- Soluções reais e aceitas no Beecrowd.
- Estrutura simples para estudar e localizar exemplos rapidamente.
- Organização por categoria, faixa e competição.
- Geração automática dos índices com scripts em Scala.

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

- [Maratona de Programação da SBC/ACM](competicoes/maratona)
- [Olimpíada Brasileira de Informática (OBI)](competicoes/obi)

## Problemas por faixa

| Faixa | Pastas |
| --- | --- |
| 1000-1499 | [src/1000](src/1000), [src/1100](src/1100), [src/1200](src/1200), [src/1300](src/1300), [src/1400](src/1400) |
| 1500-1999 | [src/1500](src/1500), [src/1600](src/1600), [src/1700](src/1700), [src/1800](src/1800), [src/1900](src/1900) |
| 2000-2499 | [src/2000](src/2000), [src/2100](src/2100), [src/2200](src/2200), [src/2300](src/2300), [src/2400](src/2400) |
| 2500-2999 | [src/2500](src/2500), [src/2600](src/2600), [src/2700](src/2700), [src/2800](src/2800), [src/2900](src/2900) |
| 3000-3599 | [src/3000](src/3000), [src/3100](src/3100), [src/3200](src/3200), [src/3300](src/3300), [src/3400](src/3400) |

## Verificação das soluções

As soluções deste repositório foram submetidas e aceitas no Beecrowd com o script [Potigol2Scala](https://github.com/potigol/potigol2scala).

## Como contribuir

1. Faça um fork de https://github.com/potigol/beecrowd.
2. Escolha um problema ainda não resolvido.
3. Adicione sua solução em src/xx00/xxxx.poti.
4. Opcional: teste localmente com ./potigol2scala.sh ../src/1000/1000.poti.
5. Opcional: atualize os índices com scala Build.scala na pasta bin.
6. Abra um pull request.
