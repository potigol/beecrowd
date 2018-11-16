mensagem, crip = leia_texto
letras = Lista(26, Lista(0,0)).mutável
para i de 1 até crip.tamanho faça
  letras[crip[i] - 64] := (i-1) :: letras[crip[i] - 64]
fim
posicoes = Lista(mensagem.tamanho, 1).mutável
para i de 1 até mensagem.tamanho,
     j em letras[mensagem[i] - 64] se i > j faça
            posicoes[i - j] := 0
fim
tam = mensagem.tamanho - crip.tamanho + 1
escreva posicoes.pegue(tam).injete(0)(_ + _)
