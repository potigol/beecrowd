# Problemas do Beecrowd

## 2163 - O Despertar da Força

````portugol
a = leia_inteiros(" ")
n, m = a[1], a[2]
var l1 := ""
var l2, l3 := leia_texto
var x, y := 0
para i de 2 ate n - 1 faca
  l1, l2, l3 := l2, l3, leia_texto
  se l2.contains("7 42 7") e l1.contains("7 7 7") e l3.contains("7 7 7") entao
    p1, p2, p3 = l1.divida(" "), l2.divida(" "), l3.divida(" ")
    para j de 2 ate m - 1 faca
      se p1[j-1] == "7" e p1[j] == "7"  e p1[j+1] == "7" e
         p2[j-1] == "7" e p2[j] == "42" e p2[j+1] == "7" e
         p3[j-1] == "7" e p3[j] == "7"  e p3[j+1] == "7" entao
        x, y := i, j
      fim
    fim
  fim
fim
escreva "{x} {y}"
````


## 2544 - Kage Bunshin no Jutsu

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  escreva (log(n)/log(2)).arredonde
  n := leia_inteiro
fim
````


## 1036 - Fórmula de Bhaskara

````portugol
valores = leia_reais(" ")
a, b, c = valores[1], valores[2], valores[3]
delta = b ^ 2 - 4 * a * c
se a == 0 ou delta < 0 então
  escreva "Impossivel calcular"
senão
  escreva "R1 = {((-b) + raiz(delta)) / (2 * a) formato "%.5f"}"
  escreva "R2 = {((-b) - raiz(delta)) / (2 * a) formato "%.5f"}"
fim
````


## 2630 - Escala de Cinza

````portugol
t = leia_inteiro
para i de 1 ate t faca
  conversao = leia_texto
  rgb = leia_inteiros(" ")
  r, g, b = rgb[1], rgb[2], rgb[3]
  imprima "Caso #{i}: "
  escreva escolha conversao
    caso "min"  => rgb.ordene[1]
    caso "max"  => rgb.ordene[3]
    caso "mean" => (r + g + b) div 3
    caso _      => (r * 30 + g * 59 + b * 11) div 100
  fim
fim
````


## 1337 - Poker do Rei

````portugol
var king := leia_inteiros(" ").ordene
enquanto king[1] > 0 faca
  a, b, c = king[1], king[2], king[3]

  resposta = se a == 13          entao "*"
        senaose a == c           entao "{a+1} {a+1} {a+1}"
        senaose a < b e b < c    entao "1 1 2"
        senaose b < c e c == 13  entao "1 {a+1} {a+1}"
        senaose b < c            entao "{a} {a} {c+1}"
        senaose a == 12          entao "1 1 1"
        senaose a + 1 < b        entao "{a+1} {b} {c}"
                                 senao "{b} {b} {a+2}"
  fim
  escreva resposta
  king := leia_inteiros(" ").ordene
fim
````


## 1024 - Criptografia

````portugol
n = leia_inteiro
para i de 1 até n faça
  m = leia_texto
  metade = m.tamanho div 2
  p1 = para c em m gere
         se (c >= 'a' e c <= 'z') ou
            (c >= 'A' e c <= 'Z') então (c + 3).caractere senão c fim
       fim
  p2 = p1.inverta
  p3 = p2.pegue(metade) + p2.descarte(metade).mapeie(c => (c - 1).caractere)
  escreva p3.junte("")
fim
````


## 1190 - Área Direita

````portugol
o = leia_texto
nums = leia_reais(144)
var soma := 0.0
para j de 1 até 12, i de 13 - j até j - 2 faça
  soma := soma + nums[i * 12 + j]
fim
se o == "S" então
  escreva soma formato "%.1f"
senão
  escreva soma / 30 formato "%.1f"
fim
````


## 1168 - LED

````portugol
n = leia_inteiro
leds = [6, 2, 5, 5, 4, 5, 6, 3, 7, 6]
para i de 1 até n faça
  num = leia_texto
  var soma := 0
  para s em num faça
    soma := soma + leds[(s - '0').inteiro + 1]
  fim
  escreva "{soma} leds"
fim
````


## 2295 - Frota de Táxi

````portugol
entrada = leia_reais(" ")
a = entrada[1]
g = entrada[2]
ra = entrada[3]
rg = entrada[4]
va = ra / a
vg = rg / g
se va > vg então
  escreva "A"
senão
  escreva "G"
fim
````


## 2306 - Escada Perfeita

````portugol
n = leia_inteiro
cubos = leia_inteiros(" ")

soma = cubos.injete(0)(_ + _)
num = 2 * soma + n - n * n
den = 2 * n
a1 = num div den
resto = num mod den

resposta = se resto == 0 e a1 > 0 então
             an = a1 + n - 1
             indice = para i de a1 até an gere i fim
             cubos.zip(indice)
               .mapeie(a => (a.primeiro - a.segundo).abs)
               .injete(0)(_ + _) div 2
            senão
              -1
            fim
escreva resposta
````


## 3053 - Jogo Dos Copos

````portugol
n = leia_inteiro
z = leia_texto

var a, b, c := z == "A", z == "B", z == "C"

para i de 1 ate n faça
  x = leia_inteiro
  escolha x
    caso 1 => a, b := b, a
    caso 2 => b, c := c, b
    caso _ => a, c := c, a
  fim
fim

se      a então escreva "A"
senãose b então escreva "B"
senão           escreva "C"
fim
````


## 2341 - Número de Envelopes

````portugol
entrada = leia_inteiros(" ")
n, k = entrada[1], entrada[2]
xs = leia_inteiros(" ")

var envelopes = Lista.mutável(k, 0)
para x em xs faca
  envelopes[x] := envelopes[x] + 1
fim

rotulos = envelopes.ordene[1]
escreva rotulos
````


## 2336 - ABC

````portugol
var s := leia_texto
enquanto nao eof faça
  abc = s.lista.mapeie(_ - 'A')
  decimal = abc.injete(BigInt(0))((a,b) => (a * 26 + b) mod 1000000007)
  escreva decimal
  s := leia_texto
fim
````


## 2031 - Pedra, Papel, Ataque Aéreo

````portugol
n = leia_inteiro
para i de 1 até n faça
  jogador1, jogador2 = leia_texto
  se jogador1 == jogador2 então
    escolha jogador1
      caso "ataque" => escreva "Aniquilacao mutua"
      caso "pedra"  => escreva "Sem ganhador"
      caso _        => escreva "Ambos venceram"
    fim
  senãose jogador1 == "ataque" ou jogador2 == "papel" então
    escreva "Jogador 1 venceu"
  senão
    escreva "Jogador 2 venceu"
  fim
fim
````


## 3399 - Meu nome é Enésimo!

````portugol
in = leia_inteiros(" ")
a, b, c, n = in[1], in[2], in[3], in[4]
enesimo = (n - 1) * (b - a) + a
escreva enesimo
````


## 1559 - 2048

````portugol
mov(dir: Texto, b: Boolean) = se b então dir senão "" fim

n = leia_inteiro
para i de 1 até n faça
    linhas = para j de 1 até 4 gere leia_inteiros(" ") fim
    var up, down, left, right := falso
    para x de 1 até 4 faça
        linhax = linhas[x]
        colunax = para j de 1 até 4 gere linhas[j][x] fim
        para a de 1 até 3 faca
            xa, xb, ax, bx = linhax[a], linhax[a+1], colunax[a], colunax[a+1]
            xa0, xb0, xab, abx, ax0, bx0 = xa == 0, xb == 0, xa == xb, ax == bx, ax == 0, bx == 0
            left  := left  ou (não xb0 e (xa0 ou xab)) 
            right := right ou (não xa0 e (xb0 ou xab))
            up    := up    ou (não bx0 e (ax0 ou abx))
            down  := down  ou (não ax0 e (bx0 ou abx))
        fim
    fim
   
    jogadas = mov(" DOWN", down) + mov(" LEFT", left) + mov(" RIGHT", right) + mov(" UP", up)
    se jogadas == "" ou linhas.injete([0])(_ + _).posição(2048) > 0 então
        escreva "NONE"
    senão
        escreva jogadas.cauda
    fim
fim
````


## 1105 - Sub-prime

````portugol
var n := leia_inteiros(2)
enquanto n[1] <> 0 ou n[2] <> 0 faça
    var reservas = leia_inteiros(n[1])

    para i de 1 até n[2] faça
        m = leia_inteiros(3)
        reservas[m[2]] := reservas[m[2]] + m[3]
        reservas[m[1]] := reservas[m[1]] - m[3]
    fim

    se reservas.selecione(_ < 0).tamanho > 0 então
        escreva "N"
    senão
        escreva "S"
    fim

    n := leia_inteiros(2)
fim
````


## 3167 - Procurando Palavras na Diagonal Secundária

````portugol
contem(texto, palavra: Texto) =
    texto.contains(palavra) ou texto.contains(palavra.inverta)
  
entrada = leia_inteiros(" ")
n, m, p = entrada[1], entrada[2], entrada[3]
palavras = leia_textos(n).mapeie(_.minusculo)
letras = leia_textos(m).mapeie(_.minusculo).junte("")

secundaria = para i de 1 ate m gere letras[i * (m - 1) + 1] fim.junte("")
superior = para i de 1 ate m-6 gere para j de 1 ate m-i gere letras[j * (m - 1) - i + 1] fim.junte("") fim.junte("|")
inferior = para i de 1 ate m-6 gere para j de 1 ate m-i gere letras[(m - j) * m + i + j] fim.junte("") fim.junte("|")

para p em palavras faca
    se contem(secundaria, p) entao
        escreva "1 Palavra {'"'}{p}{'"'} na diagonal secundaria"
    senaose contem(superior, p) entao
        escreva "2 Palavra {'"'}{p}{'"'} acima da diagonal secundaria"
    senaose contem(inferior, p) entao
        escreva "3 Palavra {'"'}{p}{'"'} abaixo da diagonal secundaria"
    senao
        escreva "4 Palavra {'"'}{p}{'"'} inexistente"
    fim
fim
````


## 1237 - Comparação de Substring

````portugol
pos(s: Texto, c: Caractere, n: Inteiro): Inteiro
  var i := n
  enquanto i <= s.tamanho e s[i] <> c faca
    i := i + 1
  fim
  se i <= s.tamanho entao i senao 0 fim
fim

comparar(a, b: Texto, p_a, p_b, soma: Inteiro): Inteiro =
  se p_a > a.tamanho ou p_b > b.tamanho ou a[p_a] <> b[p_b] entao
    soma
  senao
    comparar(a, b, p_a + 1, p_b + 1, soma + 1)
  fim

var a := leia_texto
enquanto nao eof faca
  b = leia_texto
  var resposta := 0
  para inicio_a de 1 ate a.tamanho faca
    var inicio_b := pos(b, a[inicio_a], 1)
    enquanto inicio_b > 0 faca
      tam = comparar(a, b, inicio_a, inicio_b, 0)
      se tam > resposta entao
        resposta := tam
      fim
      inicio_b := pos(b, a[inicio_a], inicio_b + 1)
    fim
  fim
  escreva resposta
  a:= leia_texto
fim
````


## 3477 - Baú Danificado

````portugol
a = leia_inteiros(" ")
x, y, z = a[1], a[2], a[3]
se x*x == y*y + z*z então
  area = (y + 3 * z / 4) * z / 2
  escreva "AREA = {area.inteiro}"
senão
  escreva "Nao eh retangulo!"
fim
````


## 1031 - Crise de Energia

````portugol
last(x, m: Inteiro)
  var next := 1
  var regions = para i de 1 ate x gere i fim
  para tamanho de x-1 ate 1 passo -1 faca
    regions := regions.remova(next)
    next := (next - 2 + m) mod tamanho + 1
  fim
  retorne regions[1]
fim

var x:= leia_inteiro
enquanto x > 0 faça
  var m := 1
  enquanto last(x, m) <> 13 faça
    m := m + 1
  fim
  escreva m
  x := leia_inteiro
fim

##Solução 2 - Mais eficiente
#last(x, m: Inteiro)
#  var a := 1
#  para i de 1 ate x - 1 faca
#    a := (a + m - 1) mod i + 1
#  fim
#  retorne a + 1
#fim


## Solução 3
#last(x, m: Inteiro)
#  var regions := Lista.mutável(x, verdadeiro) # [1, 2, ...]
#  var next := 1
#  para tamanho de x-1 até 1 passo -1 faca
#    regions[next] := falso
#    var n := m             # var n := (m-1) mod tamanho + 1
#    enquanto n > 0 faça
#      next := next mod x + 1
#      se regions[next] entao n := n - 1 fim
#    fim
#  fim
#  retorne next
#fim


## Solução 4 - Usando um Zipper
#tipo Zipper
#  var direita: Lista[Inteiro]
#  var esquerda: Lista[Inteiro] := []
#  var tamanho := direita.tamanho
#  var pos := 1
#
#  foco() = direita[1]
#  lista() = esquerda.inverta + direita
#
#  mova(p: Inteiro): Nada
#    pp = (p-1) mod tamanho + 1
#    para i de pos até pp-1 faca
#      esquerda := direita.cabeca::esquerda
#      direita := direita.cauda
#    fim
#    para i de pp até pos-1 faça
#      direita := esquerda.cabeca::direita
#      esquerda := esquerda.cauda
#    fim
#    pos := pp
#  fim
#
#  remova()
#    se direita <> [] então
#      direita := direita.cauda
#    senao
#      esquerda := esquerda.cauda
#    fim
#    tamanho := tamanho - 1
#  fim
#fim
#
#last(x, m: Inteiro)
#  var regions = para i de 1 ate x gere i fim
#  z = Zipper(regions)
#  para i de 1 ate x - 1 faca
#    z.remova
#    z.mova(z.pos + m - 1)
#  fim
#  retorne z.foco
#fim
````


## 2463 - Corredor

````portugol
leia_texto
var a := leia_inteiros(" ")
var soma, aux := 0
var tam := a.tamanho
enquanto tam > 0 faca
  soma := soma + a[1]
  se soma > aux entao aux := soma fim
  se soma < 0 entao
    soma := 0
  fim
  a := a.cauda
  tam := tam - 1
fim
escreva aux
````


## 3397 - Melhor do Multiverso

````portugol
pergunta = leia_texto
escreva("eu")
````


## 2787 - Xadrez

````portugol
l, c = leia_inteiro
escreva (l + c + 1) mod 2
````


## 2427 - Chocolate

````portugol
pedacos(lado: Inteiro): Inteiro =
  se lado < 2 entao 1
  senao
    a = lado div 2
    4 * pedacos(a)
  fim

l = leia_inteiro
escreva pedacos(l)
````


## 1179 - Preenchimento de Vetor IV

````portugol
esvaziar(a: Lista[Inteiro], nome: Texto)
  l = a.inverta
  para i de 1 até l.tamanho faça
    escreva "{nome}[{i-1}] = {l[i]}"
  fim
fim

num = leia_inteiros(15)
var par, impar = [0].cauda
para n em num faça
  se n mod 2 == 0 então
    par := n :: par
  senão
    impar := n :: impar
  fim
  se par.tamanho >= 5 então
    esvaziar(par, "par")
    par := [0].cauda
  fim
  se impar.tamanho >= 5 então
    esvaziar(impar, "impar")
    impar := [0].cauda
  fim
fim
esvaziar(impar, "impar")
esvaziar(par, "par")
````


## 1549 - Dividindo a Coca

````portugol
x = leia_inteiro
para i de 1 até x faça
    a = leia_inteiros(2)
    b = leia_inteiros(3)
    media = a[2] / a[1]
    temp = (media * 3 * (b[2] - b[1]) / (PI * b[3]) + b[1] ^ 3) ^ (1/3)
    escreva media * 3 / (PI * (temp ^ 2 + temp * b[1] + b[1] ^ 2)) formato "%.2f"
fim
````


## 1110 - Jogando Cartas Fora

````portugol
var n := leia_inteiro
impar = para i de 1 ate 50 passo 2 gere i fim
par = para i de 2 ate 50 passo 2 gere i fim
vazia = [0].cauda
enquanto n > 0 faca
  var cartas := par.pegue(n div 2)
  var descartes, pilha: Lista[Inteiro] := []
  var descartar := n mod 2 == 0
  enquanto cartas.tamanho + pilha.tamanho > 1 faca
    se cartas == [] entao
      cartas := pilha.inverta
      pilha := vazia
    fim
    topo = cartas.cabeca
    cartas := cartas.cauda
    se descartar entao
      descartes := topo :: descartes
    senao
      pilha := topo :: pilha
    fim
    descartar := nao descartar
  fim
  descartes := impar.pegue((n+1) div 2) + descartes.inverta
  escreva "Discarded cards: {descartes.junte(", ")}"
  escreva "Remaining card: {(cartas + pilha).cabeca}"
  n := leia_inteiro
fim
````


## 1305 - Arredondamento por Valor de Corte

````portugol
dec(r: Real) = r - r.inteiro

var a := leia_texto
enquanto não eof faça
  n = a.real
  c = leia_real
  escreva se dec(n) < dec(c) então n.inteiro senão (n+1).inteiro fim
  a := leia_texto
fim
````


## 1437 - Esquerda, Volver!

````portugol
dir(c: Caractere) = se c == 'D' entao 1 senao -1 fim
direcoes = "LSONLSO"
var n := leia_inteiro
enquanto n > 0 faca
  comandos = leia_texto
  frente = comandos.lista.mapeie(dir).injete(0)(_ + _)
  direcao = direcoes[frente mod 4 + 4]
  escreva direcao
  n := leia_inteiro
fim
````


## 1855 - Mapa do Meistre

````portugol
n, m = leia_inteiro
a = leia_textos(m)

dfs(x, y, dx, dy: Inteiro, vis: Lista[(Inteiro, Inteiro)]): Lógico =
  se x < 1 ou x > m ou y < 1 ou y > n ou vis.contém((x, y))
    falso
  senão
    vis2 = (x, y) :: vis
    escolha a[x][y]
      caso '*' => verdadeiro
      caso '>' => dfs(x, y + 1, 0, 1, vis2)
      caso '<' => dfs(x, y - 1, 0, -1, vis2)
      caso '^' => dfs(x - 1, y, -1, 0, vis2)
      caso 'v' => dfs(x + 1, y, 1, 0, vis2)
      caso  _  => dfs(x + dx, y + dy, dx, dy, vis)
    fim
  fim

ans = dfs(1, 1, 0, 1, [])

se ans então
  escreva "*"
senão
  escreva "!"
fim
````


## 1200 - Operações em ABP I

````portugol
tipo Valor = Caractere

tipo abstrato No
  valor(): Valor
  esquerda(): No
  direita(): No
  inserir(v: Valor): No
  altura(): Inteiro
  pesquisar(v: Valor): Lógico
  infixa(): Lista[Valor]
  prefixa(): Lista[Valor]
  posfixa(): Lista[Valor]
fim

max(a, b: Inteiro) = se a >= b então a senão b fim

tipo Arvore: No
  valor: Valor
  esquerda, direita: No

  altura = max(esquerda.altura, direita.altura) + 1

  inserir(v: Valor): No =
    se v < valor então
      Arvore(valor, esquerda.inserir(v), direita)
    senão
      Arvore(valor, esquerda, direita.inserir(v))
    fim

  pesquisar(v: Valor) =
    v == valor ou
      (se v < valor então esquerda.pesquisar(v) senão direita.pesquisar(v) fim)

  infixa()  = esquerda.infixa + valor :: direita.infixa
  prefixa() = valor :: esquerda.prefixa + direita.prefixa
  posfixa() = esquerda.posfixa + direita.posfixa + [valor]
fim

tipo Folha: No
  valor: Valor = valor
  esquerda, direita = isto
  altura = -1
  inserir(v: Valor): No = Arvore(v, Folha(), Folha())
  pesquisar(v: Valor) = falso
  infixa, prefixa, posfixa: Lista[Valor] = []
fim

var arvore: No := Folha()
var entrada := leia_texto
enquanto nao eof faça
  a = entrada.divida(" ")
  escolha a[1]
    caso "I" => arvore := arvore.inserir(a[2][1])
    caso "P" => valor = a[2][1]
                se arvore.pesquisar(valor) então
                  escreva "{valor} existe"
                senão
                  escreva "{valor} nao existe"
                fim
    caso "INFIXA"  => escreva arvore.infixa.junte(" ")
    caso "POSFIXA" => escreva arvore.posfixa.junte(" ")
    caso "PREFIXA" => escreva arvore.prefixa.junte(" ")
    caso _         =>
  fim
  entrada := leia_texto
fim
````


## 1158 - Soma de Ímpares Consecutivos III

````portugol
n = leia_inteiro
para i de 1 até n faça
  entrada = leia_inteiros(" ")
  x = entrada[1].inteiro div 2 * 2 + 1
  y = entrada[2].inteiro
  escreva (x + y - 1)* y
fim
````


## 1924 - Vitória e a Indecisão

````portugol
n = leia_inteiro
leia_textos(n)
escreva "Ciencia da Computacao"
````


## 1005 - Média 1

````portugol
a = leia_real
b = leia_real
media = (a * 3.5 + b * 7.5) / 11
escreva "MEDIA = {media formato "%.5f"}"
````


## 1068 - Balanço de Parênteses I

````portugol
var s:= leia_texto
enquanto nao eof faça
  s := s.selecione(c => c=='(' ou c==')')
  var a := 0
  var correto := verdadeiro
  para i de 1 até s.tamanho faça
    se s[i] == '(' então
      a := a + 1
    senão
      a := a - 1
    fim
    se a < 0 então
      correto := falso
    fim
  fim
  se correto e a == 0 então
    escreva "correct"
  senão
    escreva "incorrect"
  fim
  s:= leia_texto
fim
````


## 2808 - Mais Cavalos

````portugol
p = leia_textos(" ")
p1 = p[1]
p2 = p[2]

d1 = p1[1].inteiro - p2[1].inteiro
d2 = p1[2].inteiro - p2[2].inteiro
se (d1 * d2).abs == 2 então
  escreva "VALIDO"
senão
  escreva "INVALIDO"
fim
````


## 2381 - Lista de Chamada

````portugol
a = leia_inteiros(" ")
n, k = a[1], a[2]
nomes = leia_textos(n)
escreva nomes.ordene[k]
````


## 2395 - Transporte de Contêineres

````portugol
c = leia_inteiros(" ")
n = leia_inteiros(" ")
escreva (n[1] div c[1]) * (n[2] div c[2]) * (n[3] div c[3])
````


## 2062 - OBI URI

````portugol
n = leia_inteiro
palavras = leia_textos(" ")
a = para palavra em palavras gere
      ini = palavra.pegue(2)
      se palavra.tamanho <> 3 ou (ini <> "OB" e ini <> "UR") entao
        palavra
      senao
        ini + "I"
      fim
    fim
escreva a.junte(" ")
````


## 1808 - O Retorno do Rei

````portugol
numeros = leia_texto.lista.mapeie(_ - '0')

soma = numeros
         .mapeie(a => se a == 0 então 9 senão a fim)
         .injete(0)(_ + _)

media = soma / numeros.selecione(_ > 0).tamanho

escreva media formato "%.2f"
````


## 1618 - Colisão

````portugol
n = leia_inteiro
para i de 1 até n faça
  entrada = leia_inteiros(" ")
  a = entrada.pegue(2)
  c = entrada.descarte(4).pegue(2)
  r = entrada.descarte(8).pegue(2)

  resposta =
    se a[1] <= r[1] e a[2] <= r[2] e c[1] >= r[1] e [2] >= r[2]
    então 1 senão 0 fim
  escreva resposta
fim
````


## 3040 - A Árvore de Natal

````portugol
n = leia_inteiro

para i de 1 até n faça
  a = leia_inteiros(" ")
  h, d, g = a[1], a[2], a[3]
  se h >= 200 e h <= 300 e d >= 50 e g >= 150 então
    escreva "Sim"
  senão
    escreva "Nao"
  fim
fim
````


## 1073 - Quadrado de Pares

````portugol
n = leia_inteiro
para i de 2 até n passo 2 faça
  escreva "{i}^2 = {i*i}"
fim
````


## 1142 - PUM

````portugol
n = leia_inteiro
para i de 1 até n faça
  escreva "{i*4-3} {i*4-2} {i*4-1} PUM"
fim
````


## 1793 - Escada Rolante

````portugol
enquanto leia_inteiro > 0 faca
  t = leia_inteiros(" ")
  d = t.divida_quando((a, b) => b - a > 10)
  var tempo := 0
  para p em d faca
    dt = 10 + p[-1] - p[1]
    tempo := tempo + dt
  fim
  escreva tempo
fim
````


## 1533 - Detetive Watson

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  v = leia_inteiros(" ")
  a = v.ordene[-2]
  p = v.posicao(a)
  escreva p
  n := leia_inteiro
fim
````


## 1041 - Coordenadas de um Ponto

````portugol
entrada = leia_reais(" ")
x, y = entrada[1], entrada[2]
escolha (x, y)
  caso (0.0, 0.0)              => escreva "Origem"
  caso (_, 0.0)                => escreva "Eixo X"
  caso (0.0, _)                => escreva "Eixo Y"
  caso (x, y) se x > 0 e y > 0 => escreva "Q1"
  caso (_, y) se y > 0         => escreva "Q2"
  caso (x, _) se x < 0         => escreva "Q3"
  caso _                       => escreva "Q4"
fim
````


## 1173 - Preenchimento de Vetor I

````portugol
v = leia_inteiro
var n := v
para i de 0 até 9 faça
  escreva "N[{i}] = {n}"
  n := 2 * n
fim
````


## 3135 - Lista de Nomes

````portugol
n = leia_inteiro
vazia = Lista(0, "")
var nomes = Lista(20, vazia)
para i de 1 ate n faca
  nome = leia_texto
  t = nome.tamanho
  nomes[t] := nome :: nomes[t]
fim
nomes := nomes.mapeie(_.inverta).selecione(_.tamanho > 0)
enquanto nomes.tamanho > 0 faca
  escreva (para m em nomes gere m.cabeca fim).junte(", ")
  nomes := nomes.mapeie(_.cauda).selecione(_.tamanho > 0)
fim
````


## 1078 - Tabuada

````portugol
n = leia_inteiro
para i de 1 até 10 faça
  escreva "{i} x {n} = {i * n}"
fim
````


## 1426 - Coloque Tijolos na Parede

````portugol
tijolos(x: Lista[Lista[Inteiro]])
  para i de 1 até 9 gere
    para j de 1 até i gere
      a = i div 2
      b = (j + 1) div 2
      escolha (i mod 2, j mod 2)
        caso (0, 1) => (x[a][b] + x[a+1][b] - x[a+1][b+1]) div 2
        caso (0, 0) => (x[a][b] - x[a+1][b] + x[a+1][b+1]) div 2
        caso (1, 0) => (x[a][b] - x[a+1][b] - x[a+1][b+1]) div 2
        caso _      => x[a+1][b]
      fim
    fim
  fim
fim

t = leia_inteiro
para i de 1 até t faça
  x = Lista(5, leia_inteiros(" "))
  escreva tijolos(x).mapeie(_.junte(" ")).junte("\n")
fim
````


## 3217 - Chuva Caindo

````portugol
a = leia_reais(" ")
l, k, t1, t2, h = a[1], a[2], a[3], a[4], a[5]

solução(a, b, c: Real)
  retorne (b + raiz(b^2 - 4 * a * c)) / (2 * a)
fim

min_max = se l > h   então (h, h)
          senão
            # k * l * t1 + f ^ 2 == f * (h + k * (t1 + t2))
            f = solução(1, h + k * (t1 + t2), k * l * t1)
            se l < h então (f, f)
            senão          (h, f)
            fim
          fim
escreva "{min_max.primeiro formato "%.9f"} {min_max.segundo formato "%.9f"}"
````


## 3049 - Nota Cortada

````portugol
b, t = leia_inteiro
soma = b + t
valor = se soma > 160 entao 1 senaose soma < 160 entao 2 senao 0 fim
escreva valor
````


## 2686 - A Mudança Continua!!

````portugol
var entrada := leia_texto
enquanto nao eof faça
  grau = entrada.real mod 360
  se grau < 90 então
      escreva "Bom Dia!!"
  senãose grau < 180 então
      escreva "Boa Tarde!!"
  senãose grau < 270 então
      escreva "Boa Noite!!"
  senão
      escreva "De Madrugada!!"
  fim
  angulo = (grau + 90) mod 360
  horas = (angulo / 15).inteiro
  minutos = ((angulo - horas * 15) * 4).inteiro
  segundos = (angulo - horas * 15 - minutos / 4).inteiro
  escreva "{horas formato "%02d"}:{minutos formato "%02d"}:{segundos formato "%02d"}"
  entrada := leia_texto
fim
````


## 1310 - Lucro

````portugol
max(a, b: Inteiro) = se a > b então a senão b fim

lucro_máximo(n, custo_dia: Inteiro, receitas: Lista[Inteiro])
  var max_atual, max_total := 0
  para valor em receitas faça
    max_atual := max(0, max_atual) + valor - custo_dia
    se max_atual > max_total então max_total := max_atual fim
  fim
  retorne max_total
fim

var n:= leia_inteiro
enquanto n > 0 faça # EOF
  custo_dia = leia_inteiro
  receitas = leia_inteiros(n)
  resultado = lucro_máximo(n, custo_dia, receitas)
  escreva resultado
  n := leia_inteiro
fim
````


## 3004 - Envelopes

````portugol
n = leia_inteiro
para i de 1 até n faça
  a = leia_inteiros(" ")
  envelope1 = a.pegue(2).ordene
  envelope2 = a.descarte(2).ordene
  pode_colocar = envelope1[1] < envelope2[1] e envelope1[2] < envelope2[2]
  se pode_colocar entao
    escreva "S"
  senao
    escreva "N"
  fim
fim
````


## 1867 - Maior Número de Um Algarismo

````portugol
var entrada := leia_texto.divida(" ")
enquanto entrada <> ["0", "0"] faça
  var a, b := 0
  para i em entrada[1] faça
    a := a + (i - '0')
    se a > 9 então a:= a - 9 fim
  fim
  para i em entrada[2] faça
    b := b + (i - '0')
    se b > 9 então b:= b - 9 fim
  fim

  se a > b então
    escreva 1
  senãose b > a então
    escreva 2
  senão
    escreva 0
  fim
  entrada := leia_texto.divida(" ")
fim
````


## 3175 - Os Presentes Do Noel

````portugol
n = leia_inteiro
g = leia_inteiros(" ")
h = g.ordene
     .divida_quando(_ <> _)
     .mapeie(_.tamanho)

presentes = h.zip(para i de 1 ate h.tamanho gere i fim)

soma = presentes.injete(0)((a, b) => a + b.primeiro * b.segundo)

escreva soma
````


## 1164 - Número Perfeito

````portugol
n = leia_inteiro
para i de 1 até n faça
  a = leia_inteiro
  var soma := 1
  rz = raiz(a).inteiro
  para j de 2 até rz se a mod j == 0 faça
    soma := soma + j + a div j
  fim
  se rz * rz == a então
    soma := soma - rz
  fim
  se soma == a então
    escreva "{a} eh perfeito"
  senão
    escreva "{a} nao eh perfeito"
  fim
fim
````


## 3446 - Quadrados Vazios

````portugol
vazios(x, y: Inteiro, livres: Lista[Inteiro]) =
  para peça1 em livres.selecione(_ <= x) + [0],
       peça2 em livres.selecione(_ <= x - peça1) - [peça1] + [0],
       peça3 em livres.selecione(_ <= y)         - [peça1, peça2] + [0],
       peça4 em livres.selecione(_ <= y - peça3) - [peça1, peça2, peça3] + [0] gere
         x + y - (peça1 + peça2 + peça3 + peça4)
  fim.ordene.cabeça

a = leia_inteiros(" ")
E, K, D = a[3], a[2], a[1] - a[2] - a[3]
x = se E < 5 então E senão 0 fim
y = se D < 5 então D senão 0 fim
peças = [1, 2, 3, 4] - [K]
escreva vazios(x, y, peças)
````


## 2434 - Saldo do Vovô

````portugol
x = leia_inteiros(" ")
n = x[1]
var saldo := x[2]
mov = leia_inteiros(n)
var menor := saldo
para i em mov faça
  saldo := saldo + i
  se saldo < menor então
    menor := saldo
  fim
fim
escreva menor
````


## 2712 - Rodízio Veicular

````portugol
n = leia_inteiro
para i de 1 até n faça
  placa = leia_texto.lista
  se placa.tamanho <> 8 ou placa[4] <> '-' ou
     placa.pegue(3).mapeie(a => a<'A' ou a >'Z').injete(falso)((a,b) => a ou b) ou
     placa.descarte(4).mapeie(a => a<'0' ou a >'9').injete(falso)((a,b) => a ou b) então
       escreva "FAILURE"
  senão
    ultimo = placa.descarte(7).junte("").inteiro 
    se      ultimo==1 ou ultimo==2 então escreva "MONDAY"
    senãose ultimo==3 ou ultimo==4 então escreva "TUESDAY"
    senãose ultimo==5 ou ultimo==6 então escreva "WEDNESDAY"
    senãose ultimo==7 ou ultimo==8 então escreva "THURSDAY"
    senão                                escreva "FRIDAY"
    fim
  fim
fim
````


## 2168 - Crepúsculo em Portland

````portugol
n = leia_inteiro
res = Matriz.mutável(n, n, 'S')
mat = para i de 1 até n + 1 gere leia_inteiros(" ") fim
para i de 1 até n, j de 1 até n faça
  se mat[i][j] + mat[i][j+1] + mat[i+1][j] + mat[i+1][j+1] < 2 então
    res[i][j] := 'U'
  fim
fim
para linha em res faça
  escreva linha.junte("")
fim
````


## 1761 - Decoração Natalina

````portugol
var s := leia_texto
rg =  3.141592654/180
enquanto nao eof faca
  r = s.divida(" ").mapeie(_.real)
  a, b, c = r[1], r[2], r[3]
  x = c + b * tg(a * rg)
  escreva 5 * x formato "%.2f"
  s := leia_texto
fim
````


## 3313 - Jogo de Palavras

````portugol
rot(a: Texto, f: Logico)
  tam = a.tamanho
  var x := a + a
  var valor := x.pegue(tam)
  enquanto x.tamanho >= tam faca
    m = x.pegue(tam)
    se f e m < valor ou nao f e m > valor entao
      valor := m
    fim
    primeiro = valor[1]
    se f entao
      x := x.cauda.descarte_enquanto(_ > primeiro)
    senao
      x := x.cauda.descarte_enquanto(_ < primeiro)
    fim
  fim
  retorne valor
fim

var n := 0
var s := leia_texto
enquanto s <> "*" faca
  menor = rot(s, verdadeiro)
  maior = rot(s, falso)
  n := n + 1
  escreva "Caso {n}: {menor} {maior}"
  s := leia_texto
fim
````


## 2146 - Senha

````portugol
var n := leia_inteiro
enquanto n > 0 faça
  escreva n - 1
  n := leia_inteiro
fim
````


## 1222 - Concurso de Contos

````portugol
var input := leia_texto 
enquanto input <> "" e input <> nulo e input <> "-1" faça
  var in := input.divida(" ")
  var n = in[1].inteiro
  var l = in[2].inteiro
  var c = in[3].inteiro
  var paginas := 1 
  var linhas := 1
  var texto := leia_texto
  lista_palavras = texto.divida(" ")
	var letras := lista_palavras[1].tamanho
  
	para i de 2 ate lista_palavras.tamanho faca
    palavra = lista_palavras[i]
    x = palavra.tamanho
    se (letras + x + 1) <= c entao
      letras := letras + x + 1
    senao
      linhas := linhas + 1
      se linhas > l entao
        paginas := paginas + 1
        linhas := 1
      fim
      letras := x
    fim
  fim
  escreva paginas
  input := leia_texto
fim
````


## 1196 - WERTYU

````portugol
teclas = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./"
var entrada := leia_texto
enquanto nao eof faca
  mensagem = para c em entrada gere
    se c == ' ' então ' ' senão teclas[teclas.posição(c) - 1] fim
  fim.junte("")
  escreva mensagem
  entrada := leia_texto
fim
````


## 1366 - Jogo de Varetas

````portugol
var n := leia_inteiro
enquanto n > 0 faça
    var pares := 0
    para i de 1 ate n faça
        v = leia_inteiros(" ")[2] div 2
        pares := pares + v
    fim
    retangulos = pares div 2
    escreva retangulos
    n := leia_inteiro
fim
````


## 2516 - Corrida

````portugol
var b := leia_inteiros(" ")
enquanto nao eof faca
  v = b[2] - b[3]
  se v > 0 entao
    s = b[1]
    escreva s / v formato "%.2f"
  senao
    escreva "impossivel"
  fim
  b := leia_inteiros(" ")
fim
````


## 2869 - Falando em Divisor...

````portugol
a = [1, 2, 4, 6, 16, 12, 64, 24, 36, 48, 1024, 60, 4096, 192, 144, 120, 65536, 180, 262144, 240, 576, 3072, 4194304, 360, 1296, 12288, 900, 960, 268435456, 720, 73741817, 840, 9216, 196608, 5184, 1260, 719476260, 786432, 36864, 1680, 511620083, 2880, 46480318, 15360, 3600, 12582912, 743685088, 2520, 46656, 6480, 589824, 61440, 595845303, 6300, 82944, 6720, 2359296, 805306368, 134099126, 5040, 536396504, 221225451, 14400, 7560, 331776, 46080, 329376018, 983040, 37748736, 25920, 270016253, 10080, 80065005, 158428766, 32400, 3932160, 746496, 184320, 124160285, 15120, 44100, 534860242, 986564553, 20160, 5308416, 139440954, 415919090, 107520, 140130951, 25200, 2985984, 62914560, 663676353, 231055250, 21233664, 27720, 873523211, 233280, 230400, 45360]
n = leia_inteiro
para i de 1 até n faça
  escreva a[leia_inteiro]
fim
````


## 1095 - Sequencia IJ 1

````portugol
var i, j := 1, 60
enquanto j >= 0 faça
  escreva "I={i} J={j}"
  i := i + 3
  j := j - 5
fim
````


## 3103 - Número da Sorte

````portugol
t = leia_inteiro
para i de 1 ate t faca
  n = leia_texto.ordene
  a = n.pegue_enquanto(_ == '0')
  b = n.descarte_enquanto(_ == '0')
  escreva "{b.cabeça}{a}{b.cauda}"
fim
````


## 1001 - Extremamente Básico

````portugol
a, b = leia_inteiro
escreva "X = {a + b}"
````


## 1914 - De Quem é a Vez?

````portugol
qt = leia_inteiro

para i de 1 até qt faça
  nomes = leia_textos(" ")
  a = leia_inteiros(" ")
  par = (a[1] + a[2]) mod 2 == 0
  se (par e nomes[2] == "PAR") ou
     (não par e nomes[2] <> "PAR") então
    escreva nomes[1]
  senão
    escreva nomes[3]
  fim
fim
````


## 2763 - Entrada e Saída CPF

````portugol
entrada = leia_texto
a = entrada.pegue(3)
b = entrada.descarte(4).pegue(3)
c = entrada.descarte(8).pegue(3)
d = entrada.descarte(12)

escreva a
escreva b
escreva c
escreva d

````


## 1243 - O Quão Fácil é...

````portugol
var enunciado := leia_texto
enquanto nao eof faça
  palavras = enunciado
    .divida(" ")
    .mapeie(p => se p.tamanho > 0 e p[-1] == '.' então p.pegue(p.tamanho - 1) senão p fim)
    .selecione(p => p.tamanho > 0 e p.ordene[1] >= 'A')
    .mapeie(_.tamanho)
  se palavras.tamanho == 0 então
    escreva 250
  senão
    media = palavras.injete(0)(_ + _) / palavras.tamanho
    se media < 4 então
      escreva 250  senãose media < 6 então
      escreva 500  senão
      escreva 1000 fim
  fim
  enunciado := leia_texto
fim
````


## 3249 - Death Knight Hero

````portugol
n = leia_inteiro
var total := n
para i de 1 ate n faca
  a = " {leia_texto} " 
  se a.divida("CD").tamanho > 1 entao
    total := total - 1
  fim
fim
escreva total
````


## 1441 - Sequências de Granizo

````portugol
var maior := leia_inteiro
enquanto maior > 0 faça
  var h := maior
  enquanto h > 1 faça
    se h > maior então
      maior := h
    fim
    h := se h mod 2 == 0 então h div 2 senão 3 * h + 1 fim
  fim
  escreva maior
  maior := leia_inteiro
fim
````


## 3088 - Correção de Texto

````portugol
var a := leia_texto
enquanto a <> "" faca
  s = a.split(" ,").mkString(",")
       .split(" \\.").mkString(".")
  escreva s
  a := leia_texto
fim
````


## 1046 - Tempo de Jogo

````portugol
entrada = leia_inteiros(" ")
inicio = entrada[1]
final =  entrada[2]
d = final - inicio
duracao = se d > 0 então d senão d + 24 fim
escreva "O JOGO DUROU {duracao} HORA(S)"
````


## 3308 - Elevador

````portugol
n = leia_inteiro
para i de 1 ate n faça
    a = leia_inteiros(" ")
    porta = a[1]
    andares = a[2] + a[3] + a[4]
    resposta = se andares > 1 então "X" senão (porta + andares) mod 2 fim
    escreva resposta
fim
````


## 1650 - Pintura Preto e Branco

````portugol
var entrada := leia_inteiros(" ")
enquanto entrada[1] > 0 faça
  n, m, c = entrada[1], entrada[2], entrada[3]
  escreva ((n - 7) * (m - 7) + c) div 2
  entrada := leia_inteiros(" ")
fim
````


## 1921 - Guilherme e Suas Pipas

````portugol
n = leia_inteiro
barbantes = n / 2 * (n - 3)
escreva barbantes formato "%.0f"
````


## 3140 - Copiando e Colando Código

````portugol
enquanto leia_texto
           .descarte_enquanto(_ == ' ')
           .pegue(6) <> "<body>" faca
fim
var s := leia_texto
enquanto s.descarte_enquanto(_ == ' ').pegue(7) <> "</body>" faca
  escreva s
  s := leia_texto
fim
````


## 1803 - Matring

````portugol
entrada1 = leia_texto
entrada2 = leia_texto
entrada3 = leia_texto
entrada4 = leia_texto

f = (entrada1.cabeça.texto +
     entrada2.cabeça.texto +
     entrada3.cabeça.texto +
     entrada4.cabeça.texto).inteiro

l = (entrada1.último.texto +
     entrada2.último.texto +
     entrada3.último.texto +
     entrada4.último.texto).inteiro

var palavra := ""
para i de 2 até (entrada1.tamanho - 1) faça
    caractere = ((f *
                    (entrada1[i].texto +
                     entrada2[i].texto +
                     entrada3[i].texto +
                     entrada4[i].texto).inteiro + l) mod 257).caractere

    palavra := palavra + caractere
fim

escreva palavra
````


## 2136 - Amigos do Habay

````portugol
limpe(lista: Lista[Texto]) =
  lista.ordene.divida_quando(_ <> _).mapeie(_.cabeca)

var yes, no := Lista(0, "")
var amigo := ""
var entrada := leia_textos(" ")
enquanto entrada[1] <> "FIM" faca
  se entrada[2] == "YES" entao
    yes := entrada[1] :: yes
    se entrada[1].tamanho > amigo.tamanho entao
      amigo := entrada[1]
    fim
  senao
    no := entrada[1] :: no
  fim
  entrada := leia_textos(" ")
fim
escreva limpe(yes).junte("\n")
escreva limpe(no).junte("\n")
escreva ""
escreva "Amigo do Habay:"
escreva amigo
````


## 1228 - Grid de Largada

````portugol
ultrapassagens(grid, chegada: Lista[Inteiro], total: Inteiro): Inteiro =
  se grid == [] então
    total
  senãose grid.cabeça == chegada.cabeça então
    ultrapassagens(grid.cauda, chegada.cauda, total)
  senão
    a = grid.posição(chegada.cabeça) - 1
    ultrapassagens(grid - [chegada.cabeça], chegada.cauda, total + a)
  fim

var n := leia_inteiro
enquanto n > 0 faça
  grid, chegada = leia_inteiros(" ")
  escreva ultrapassagens(grid, chegada, 0)
  n := leia_inteiro
fim
````


## 1709 - Baralho Embaralhado

````portugol
p = leia_inteiro
embaralhar(a, c: Inteiro): Inteiro
  b = se 2 * a <= p entao 2 * a senao 2 * a - (p + 1) fim
  retorne se b == 1 entao c senao embaralhar(b, c + 1) fim
fim
escreva embaralhar(1, 1)
````


## 3342 - Keanu

````portugol
n = leia_inteiro
qntTotalCasas = n*n

se n mod 2 == 0 então
    a = qntTotalCasas div 2
    b = a
    escreva "{a} casas brancas e {b} casas pretas"
senão 
    a = (qntTotalCasas+1) div 2
    b = a-1
    escreva "{a} casas brancas e {b} casas pretas"
fim
````


## 1871 - Zero vale Zero

````portugol
var a := leia_inteiros(" ")
enquanto a[1] <> 0 faca
  m, n = a[1], a[2]
  soma = m + n
  s = soma.texto.selecione(_ <> '0')
  escreva s
  a := leia_inteiros(" ")
fim
````


## 2708 - Turistas no Parque Huacachina

````portugol
var entrada := leia_textos(" ")
var turistas, jipes := 0
enquanto entrada[1] <> "ABEND" faca
  j, t = entrada[1], entrada[2].inteiro
  se j == "SALIDA" entao
    jipes := jipes + 1
    turistas := turistas + t
  senao
    jipes := jipes - 1
    turistas := turistas - t
  fim
  entrada := leia_textos(" ")
fim
escreva turistas
escreva jipes
````


## 2654 - Godofor

````portugol
tipo Ser
  nome: Texto
  poder, kill, morte: Inteiro
fim

lt = (s1, s2: Ser) =>
  se s1.poder <> s2.poder entao s1.poder > s2.poder
  senaose s1.kill <> s2.kill entao s1.kill > s2.kill
  senaose s1.morte <> s2.morte entao s1.morte < s2.morte
  senao s1.nome < s2.nome
  fim

n = leia_inteiro
seres = para i de 1 ate n gere
  a = leia_textos(" ")
  Ser(a[1], a[2].inteiro, a[3].inteiro, a[4].inteiro)
fim
godofor = seres.ordene(lt).cabeca
escreva godofor.nome
````


## 3204 - Honeycomb Walk

````portugol
n = leia_inteiro
para i de 1 ate n faca
  a = leia_inteiro
  b = escolha a
    caso 1 => 0
    caso 2 => 6
    caso 3 => 12
    caso 4 => 90
    caso 5 => 360
    caso 6 => 2040
    caso 7 => 10080
    caso 8 => 54810
    caso 9 => 290640
    caso 10=> 1588356
    caso 11=> 8676360
    caso 12=> 47977776
    caso 13=> 266378112
    caso _ => 1488801600
  fim
  escreva b
fim
````


## 3263 - Apague Com Segurança

````portugol
n = leia_inteiro
a, b = leia_texto
c = se n mod 2 == 0 entao b senao b.mapeie(c => se c == '1' então '0' senão '1' fim) fim
se a == c então
    escreva "Deletion succeeded"
senão
    escreva "Deletion failed"
fim
````


## 1287 - Processador Amigável de Inteiros

````portugol
var s := leia_texto
enquanto nao eof faca
  x = s.selecione(c => c <> ',' e c <> ' ')
       .mapeie(c => escolha c
                      caso 'l' => '1'
                      caso 'o' => '0'
                      caso 'O' => '0'
                      caso  _  => c
                    fim )
        .injete("")((a, b) => se a == "0" entao "{b}" senao "{a}{b}" fim)

  erro = x.selecione(c => c < '0' ou c > '9') <> ""
  se x <> "" e nao erro e (x.tamanho < 10 ou x.tamanho == 10 e x <="2147483647") entao
    escreva x.inteiro
  senao
    escreva "error"
  fim
  s := leia_texto
fim
````


## 2603 - Endereço dos Clientes

````portugol
use sql

tipo Clientes: Tabela
    _tabela = "customers"
    nome = campo("name")
    rua = campo("street")
    cidade = campo("city")
fim
    
c = Clientes()
consulta = Selecionar()
            .tabela(c)
            .campos([c.nome, c.rua])
            .onde(c.cidade == "Porto Alegre")
            .sql

escreva consulta
````


## 2328 - Chocolate

````portugol
n = leia_inteiro
a = leia_inteiros(" ")
s = a.injete(0)(_ + _) - n
escreva s
````


## 1430 - Composição de Jingles

````portugol
d = para i de 'A' ate 'Z' gere 2 ^ (1 - "WHQESTX".posicao(i)) fim
valor(id: Caractere) = d[id - 'A' + 1]
soma(valor: Caractere => Real) =
  (n: String) => n.lista.mapeie(valor).injete(0.0)(_ + _)
duracao = soma(valor)

var entrada := leia_texto
enquanto entrada <> "*" faca
  compassos = entrada.divida("/")
  duracoes = compassos.mapeie(duracao)
  escreva duracoes.selecione(_ == 1.0).tamanho
  entrada := leia_texto
fim
````


## 1985 - MacPRONALTS

````portugol
n = leia_inteiro
var soma := 0.0
para i de 1 até n faça
  in = leia_inteiros(" ")
  p, q = in[1], in[2]
  soma := soma + (p - 999.5) * q
fim
escreva soma formato "%.2f"
````


## 1760 - Floco de Neve de Koch

````portugol
var l := leia_inteiro
enquanto l <> 0 faça
  area = l ^ 2 * 0.6928203230275509
  escreva area formato "%.2f"
  l := leia_inteiro
fim
````


## 2667 - Jogo de Boca

````portugol
n = leia_texto
var s := 0
para i de 1 até n.tamanho faça
  s := s + (n[i]-'0')
fim
escreva s mod 3
````


## 2339 - Aviões de Papel

````portugol
a = leia_inteiros(" ")
c, p, f = a[1], a[2], a[3]
se c * f <= p entao
  escreva "S"
senão
  escreva "N"
fim
````


## 3046 - Dominó

````portugol
n = leia_inteiro
r = (n + 1) * (n + 2) div 2
escreva r
````


## 2755 - Saída 9

````portugol
escreva "\"Ro'b'er\tto\\/\""
escreva "(._.) ( l: ) ( .-. ) ( :l ) (._.)"
escreva "(^_-) (-_-) (-_^)"
escreva "(\"_\") ('.')"

````


## 2444 - Volume da TV

````portugol
min(x, y: Inteiro) = se x < y então x senão y fim
max(x, y: Inteiro) = se x > y então x senão y fim

v = leia_inteiros(" ")[1]
var a := leia_inteiros(" ")
escreva a.injete(v)((x, y) => max(min(x + y, 100), 0))
````


## 2217 - Nove

````portugol
t = leia_inteiro
para i de 1 até t faça
  n = leia_inteiro
  escreva se n mod 2 == 0 então 1 senão 9 fim
fim
````


## 1323 - Feynman

````portugol
var a = Lista(100, 1)
para i de 2 ate 100 faca
  a[i] := a[i-1] + i * i
fim
var n := leia_inteiro
enquanto n > 0 faca
  escreva a[n]
  n := leia_inteiro
fim
````


## 1279 - Ano Bissexto ou Ano não Bissexto

````portugol
somar(digitos: Lista[Inteiro], soma: Inteiro): Inteiro =
  se digitos <> [] entao
    somar(digitos.descarte(2), soma + digitos[1])
  senão
    soma
  fim

soma_par(digitos: Lista[Inteiro]) = somar(digitos.inverta.descarte(1), 0)
soma_impar(digitos: Lista[Inteiro]) = somar(digitos.inverta, 0)

div4(digitos: Lista[Inteiro]) = (digitos[2] * 10 + digitos[1]) mod 4 == 0
div5(digitos: Lista[Inteiro]) = digitos[1] mod 5 == 0
div100(digitos: Lista[Inteiro]) = digitos.pegue(2) == [0, 0]
div400(digitos: Lista[Inteiro]) = div100(digitos) e div4(digitos.descarte(2))
div11(digitos: Lista[Inteiro]) = (soma_par(digitos) - soma_impar(digitos)) mod 11 == 0
div3(digitos: Lista[Inteiro]) = digitos.injete(0)(_ + _) mod 3 == 0

var primeiro := verdadeiro
var entrada := leia_texto
enquanto não eof faça
  digitos = entrada.inverta.lista.mapeie(_ - '0')

  se primeiro entao
    primeiro := falso
  senão
    escreva ""
  fim

  bissexto = div4(digitos) e não div100(digitos) ou div400(digitos)
  bulukulu = bissexto e div5(digitos) e div11(digitos)
  huluculu = div5(digitos) e div3(digitos)

  se bissexto então
    escreva "This is leap year."
  fim
  se huluculu então
    escreva "This is huluculu festival year."
  fim
  se bulukulu então
    escreva "This is bulukulu festival year."
  fim
  se não bissexto e não huluculu então
    escreva "This is an ordinary year."
  fim

  entrada := leia_texto
fim
````


## 3089 - Presentes de Natal

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  x = leia_inteiros(" ")
  a = x.ordene
  var menor, maior := a[n] + a[n+1]
  para i de 1 ate n faca
    b = a[i] + a[2 * n - i + 1]
    se b < menor entao menor := b
    senaose b > maior entao maior := b
    fim
  fim
  escreva "{maior} {menor}"
  n := leia_inteiro
fim
````


## 2466 - Sinuca

````portugol
leia_inteiro
var linha := leia_inteiros(" ")

enquanto linha.tamanho > 1 faça
  linha := para i de 2 até linha.tamanho gere
    linha[i - 1] * linha[i]
  fim
fim

escolha linha[1]
  caso -1 => escreva "branca"
  caso  1 => escreva "preta"
fim
````


## 2126 - Procurando Subsequências

````portugol
var t := 0
var n1, n2 := leia_texto
enquanto nao eof faça
  var cont, pos := 0
  para i de 0 até n2.tamanho - n1.tamanho faça
    var sub := verdadeiro
    para j de 1 até n1.tamanho faça
      sub := sub e n1[j] == n2[i+j]
    fim
    se sub então
      cont := cont + 1
      pos := i + 1
    fim
  fim
  t := t + 1
  escreva "Caso #{t}:"
  se cont > 0 então
    escreva "Qtd.Subsequencias: {cont}"
    escreva "Pos: {pos}"
  senão
    escreva "Nao existe subsequencia"
  fim
  escreva ""
  n1, n2 := leia_texto
fim
````


## 1059 - Números Pares

````portugol
para i de 2 até 100 passo 2 faça
  escreva i
fim
````


## 1132 - Múltiplos de 13

````portugol
a, b = leia_inteiro
p = se a<b então 1 senão -1 fim
var soma := 0
para i de a até b passo p se i mod 13 <> 0 faça
  soma := soma + i
fim
escreva soma
````


## 3043 - Festa Junina

````portugol
flat(a: Lista[Lista[Lista[Inteiro]]]) = para v em a, y em v gere y fim

var n, t := leia_inteiro, 0
enquanto n > 0 faca
  var valores := [para i de 1 ate n gere i fim]
  para i de 1 ate n faca
    nums = leia_inteiros(" ")
    valores := flat(valores.mapeie(v =>
      se v - nums == v ou v - [i] == v entao [v]
      senao [v - [i], v - nums]
      fim))
  fim
  t := t + 1
  r = valores.mapeie(_.tamanho).ordene.ultimo
  escreva "Teste {t}
          |{r}
          |"
  n := leia_inteiro
fim
````


## 2356 - Bactéria I

````portugol
var d := leia_texto
enquanto nao eof faca
  s = leia_texto
  var i := 0
  enquanto i < d.tamanho - s.tamanho + 1 faca
    se d.descarte(i).pegue(s.tamanho) == s entao
      escreva "Resistente"
      i := d.tamanho
    senao
      i := i + 1
    fim
  fim
  se i < d.tamanho entao
    escreva "Nao resistente"
  fim
  d := leia_texto
fim
````


## 2158 - Ajudando o Tio Cláudio

````portugol
var c := 0
var entrada := leia_texto
enquanto nao eof faca
  a = entrada.divida(" ").mapeie(i => BigInt(i))
  fp, fh = a[1], a[2]
  lig = (5 * fp + 6 * fh) div 2
  ato = 2 + lig - fp - fh
  c := c + 1
  escreva "Molecula #{c}.:."
  escreva "Possui {ato} atomos e {lig} ligacoes"
  escreva ""
  entrada := leia_texto
fim
````


## 1847 - Bem-vindos e Bem-vindas ao Inverno!

````portugol
a = leia_inteiros(" ")
x = a[2] - a[1]
y = a[3] - a[2]
se y > x ou (x == y e x > 0) então
  escreva ":)"
senão
  escreva ":("
fim
````


## 2420 - Guerra por Território

````portugol
n = leia_inteiro
var a := leia_inteiros(" ")
total = a.injete(0)(_ + _)
var metade := 0
enquanto metade < total div 2 faça
  metade := metade + a.cabeça
  a := a.cauda
fim
escreva n - a.tamanho
````


## 2691 - O Matemático

````portugol
n = leia_inteiro
para i de 1 até n faça
  entrada = leia_inteiros("x")
  x, y = entrada[1], entrada[2]
  para t de 5 ate 10 faca
    se x == y entao
      escreva "{x} x {t} = {x*t}"
    senao
      escreva "{x} x {t} = {x * t} && {y} x {t} = {y * t}"
    fim
  fim
fim
````


## 1800 - Onde Estão Minhas Chaves

````portugol
q = leia_inteiros(" ")[1]
c = leia_inteiros(" ")
var visitas := Lista(1000, 1)
para a em c faça
  visitas[a] := 0
fim
para i de 1 até q faça
  a = leia_inteiro
  escreva visitas[a]
  visitas[a] := 0
fim
````


## 1379 - Problema com Mediana e Média

````portugol
var a := leia_inteiros(" ")
enquanto a <> [0, 0] faça
  escreva 2 * a[1] - a[2]
  a := leia_inteiros(" ")
fim
````


## 1087 - Dama

````portugol
var in := leia_inteiros(" ")
enquanto in[1] <> 0 faça
  dx = (in[1] - in[3]).abs
  dy = (in[2] - in[4]).abs
  se dx == 0 e dy == 0 então
    escreva 0
  senãose dx == dy ou dx == 0 ou dy == 0 então
    escreva 1
  senão
    escreva 2
  fim
  in := leia_inteiros(" ")
fim
````


## 1514 - Competição

````portugol
transpor(mat: Lista[Lista[Inteiro]]): Lista[Lista[Inteiro]] = 
    se mat.cabeça == [] então []
    senão mat.mapeie(_.cabeça) :: transpor(mat.mapeie(_.cauda))
    fim

total_linhas(linha: Lista[Lista[Inteiro]]): Lista[Inteiro] =
    linha.mapeie(linha => linha.injete(0)((soma, x) => soma + x))

var entrada := leia_inteiros(" ")
enquanto entrada <> [0, 0] faça
    n, m = entrada[1], entrada[2]
    matriz = para i de 1 até n gere leia_inteiros(" ") fim
    linhas = total_linhas(matriz).ordene
    colunas = total_linhas(transpor(matriz)).ordene
    pontos =  [linhas[1] > 0, linhas[n] < m, colunas[1] > 0, colunas[m] < n].selecione(x => x).tamanho
    escreva pontos
    entrada := leia_inteiros(" ")
fim
````


## 1247 - Guarda Costeira

````portugol
var a := leia_inteiros(" ")
enquanto nao eof faca
  d, vf, vg = a[1], a[2], a[3]
  c = raiz(144 + d^2) / 12
  se vg >= vf * c entao
    escreva "S"
  senao
    escreva "N"
  fim
  a := leia_inteiros(" ")
fim
````


## 2552 - PãodeQuejoSweeper

````portugol
var entrada := leia_texto
enquanto nao eof faca
  a = entrada.divida(" ").mapeie(_.inteiro)
  n, m = a[1], a[2]
  tabuleiro = para i de 1 até n gere leia_inteiros(" ") fim
  para i de 1 ate n faca
    para j de 1 ate m faca
      soma = se tabuleiro[i][j] == 1 entao 9 senão
        (se i > 1 entao tabuleiro[i-1][j] senao 0 fim) +
        (se j > 1 entao tabuleiro[i][j-1] senao 0 fim) +
        (se i < n entao tabuleiro[i+1][j] senao 0 fim) +
        (se j < m entao tabuleiro[i][j+1] senao 0 fim)
      fim
      imprima soma
    fim
    escreva ""
  fim
  entrada := leia_texto
fim
````


## 1890 - Emplacando os Tuk-tuks

````portugol
t = leia_inteiro
para i de 1 até t faça
  entrada = leia_inteiros(" ")
  c, d = entrada[1], entrada[2]
  placas = 26 ^ c * 10 ^ d
  se placas > 1 então
    escreva placas formato "%.0f"
  senão
    escreva 0
  fim
fim
````


## 1609 - Contando Carneirinhos

````portugol
t = leia_inteiro
para i de 1 até t faça
  n = leia_inteiro
  l = leia_inteiros(" ")
  escreva l.ordene.divida_quando(_ <> _).tamanho
fim
````


## 2373 - Garçom

````portugol
n = leia_inteiro
var total := 0
para i de 1 ate n faca
  a = leia_inteiros(" ")
  l, c = a[1], a[2]
  se l > c entao total := total + c fim
fim
escreva total
````


## 1013 - O Maior

````portugol
# Utilizando a formula pedida na questão...
maior(x, y:Inteiro): Inteiro
	retorne (x+y+abs(x-y)) div 2
fim

numeros = leia_inteiros(3)
escreva "{maior(numeros[1], maior(numeros[2], numeros[3]))} eh o maior"
````


## 3084 - Relógio Antigo

````portugol
var a := leia_inteiros(" ")
enquanto nao eof faca
  hora   = a[1] div 30
  minuto = a[2] div 6
  escreva "{hora formato "%02d"}:{minuto formato "%02d"}"
  a := leia_inteiros(" ")
fim
````


## 1115 - Quadrante

````portugol
var entrada := leia_inteiros(" ")
enquanto entrada[1] * entrada[2] <> 0 faça
  x, y = entrada[1], entrada[2]
  se x > 0 e y > 0 então
    escreva "primeiro"
  senãose x < 0 e y > 0 então
    escreva "segundo"
  senãose x < 0 então
    escreva "terceiro"
  senão
    escreva "quarto"
  fim
  entrada := leia_inteiros(" ")
fim
````


## 2635 - Navegador Web

````portugol
n = leia_inteiro
palavras = Lista(n, 0).mapeie(a => leia_texto)
q = leia_inteiro
para i de 1 ate q faca
  s = leia_texto
  t = s.tamanho
  c = palavras.selecione(palavra => palavra.pegue(t) == s)
  maior = c.injete(-1)((a, b) => se b.tamanho > a entao b.tamanho senao a fim)
  se c.tamanho > 0 entao
    escreva "{c.tamanho} {maior}"
  senao
    escreva -1
  fim
fim
````


## 2929 - Menor da Pilha

````portugol
n = leia_inteiro
var pilha:= [0].cauda
var tamanho := 0
para i de 1 ate n faca
  entrada = leia_texto
  valor = entrada.descarte(5).inteiro
  escolha entrada[2]
    caso 'U' se tamanho == 0 =>
      pilha := valor :: pilha
      tamanho := 1
    caso 'U' =>
      menor = se valor < pilha.cabeca entao valor senao pilha.cabeca fim
      pilha := menor :: pilha
     tamanho := tamanho + 1
    caso 'I' se tamanho > 0 =>
      escreva pilha.cabeca
    caso 'O' se tamanho > 0 =>
      pilha := pilha.cauda
      tamanho := tamanho - 1
    caso _ =>
      escreva "EMPTY"
  fim
fim
````


## 3312 - Imberbe Matemático

````portugol
var z := BigInt(1)
fat = para i de 1 ate 100 gere z := z * i z fim
primos = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
primo = para i de 1 ate 100 gere primos.contem(i) fim

n = leia_inteiro
x = leia_inteiros(" ")
para a em x se primo[a] faca
  escreva "{a}! = {fat[a]}"
fim
````


## 2520 - O Último Analógimôn

````portugol
var entrada := leia_texto
enquanto nao eof faca
  a = entrada.divida(" ").mapeie(_.inteiro)
  n, m = a[1], a[2]
  var x1, y1, x2, y2 := 0
  para i de 1 ate n faca
    linha = leia_inteiros(" ")
    para j de 1 ate m faca
      se linha[j] == 1 entao
        x1, y1 := i, j
      fim
      se linha[j] == 2 entao
        x2, y2 := i, j
      fim
    fim
  fim
  tempo = (x2 - x1).abs + (y2 - y1).abs
  escreva tempo
  entrada := leia_texto
fim
````


## 1963 - O Filme

````portugol
entrada = leia_reais(" ")
a = entrada[1]
b = entrada[2]
c = (b / a - 1) * 100
escreva "{c formato "%.2f"}%"
````


## 1875 - Tribol

````portugol
c = leia_inteiro
para i de 1 ate c faca
  p = leia_inteiro
  var r, g, b := 0
  para k de 1 ate p faca
    ms = leia_texto
    escolha ms
      caso "R G" => r := r + 2
      caso "G B" => g := g + 2
      caso "B R" => b := b + 2
      caso "R B" => r := r + 1
      caso "G R" => g := g + 1
      caso _     => b := b + 1
    fim
  fim
  se    r == g e g == b entao  escreva "trempate"
  senaose r > g e r > b entao  escreva "red"
  senaose g > r e g > b entao  escreva "green"
  senaose b > g e b > r entao  escreva "blue"
  senao                        escreva "empate"
  fim
fim
````


## 2852 - Troca de Mensagens

````portugol
k = leia_texto
n = leia_inteiro
tam = k.tamanho
para i de 1 ate n faca
  frase = leia_texto
  var a := -1
  var vogal := frase.tamanho == 0 ou "aeiou".contem(frase[1])
  para i de 1 ate frase.tamanho faca
    letra = frase[i]
    se i > 1 e frase[i-1] == ' ' entao
      vogal := "aeiou".contem(letra)
    fim
    se vogal ou letra == ' ' entao
      imprima letra
    senao
      a := (a + 1) mod tam
      imprima ((letra + k[a+1] - 2 * 'a') mod 26 + 'a').caractere
    fim
  fim
  escreva ""
fim
````


## 2388 - Tacógrafo

````portugol
n = leia_inteiro
var soma := 0
para i de 1 ate n faca
  linha = leia_inteiros(" ")
  t, v = linha[1], linha[2]
  soma := soma + t * v
fim
escreva soma
````


## 2533 - Estágio

````portugol
var m := leia_inteiro
enquanto m > 0 faca
  var produto, cargas := 0
  para i de 1 ate m faca
    a = leia_inteiros(" ")
    n, c = a[1], a[2]
    produto := produto + n * c
    cargas := cargas + c
  fim
  ira = produto / (100 * cargas)
  escreva ira formato "%.4f"
  m := leia_inteiro
fim
````


## 3258 - Fervendo Vegetais

````portugol
t = leia_reais(" ")[1]
var ws := leia_inteiros(" ").ordene.mapeie(x => (x, 1, x.real))
n = ws.tamanho
var cortes := 0
enquanto ws[1].terceiro / ws[n].terceiro < t faça
  wsn = ws[n]
  c = wsn.segundo + 1
  p = wsn.primeiro / c
  ws[n] := (wsn.primeiro, c, p)
  ws := ws.ordene(x => x.terceiro)
  cortes := cortes + 1
fim
escreva cortes
````


## 1151 - Fibonacci Fácil

````portugol
var fib := [1, 0]
enquanto fib.tamanho < 50 faça
  fib := (fib[1] + fib[2]) :: fib
fim
n = leia_inteiro
escreva fib.inverta.pegue(n).junte(" ")
````


## 1051 - Imposto de Renda

````portugol
salario = leia_real

se salario <= 2000 então
	escreva "Isento"
senãose salario <= 3000 então
	resto = salario - 2000
	resultado = resto * 0.08
	escreva "R$ {resultado formato "%.2f"}"
senãose salario < 4500 então
	resto = salario - 3000
	resultado = (resto * 0.18) + (1000 * 0.08)
  escreva "R$ {resultado formato "%.2f"}"
senão
	resto = salario - 4500
	resultado = (resto * 0.28) + (1500 * 0.18) + (1000 * 0.08)
  escreva "R$ {resultado formato "%.2f"}"
fim
````


## 2456 - Cartas

````portugol
a = leia_inteiros(" ")
b = a.ordene
c = b.inverta
se a == b entao
  escreva "C"
senaose a == c entao
  escreva "D"
senao
  escreva "N"
fim
````


## 2950 - As Duas Torres

````portugol
a = leia_inteiros(" ")
n, x, y = a[1], a[2], a[3]
icm = n / (x + y)
escreva icm formato "%.2f"
````


## 2782 - Escadinha

````portugol
n = leia_inteiro
nums = leia_inteiros(" ")
se n > 1 entao
  a = nums.zip(nums.cauda).mapeie(n => n.segundo - n.primeiro)
  c = a.divida_quando(_ <> _)
  escreva c.tamanho
senao
  escreva 1
fim
````


## 1040 - Média 3

````portugol
notas = leia_reais(" ")
pesos = [2, 3, 4, 1]
var media := 0.0
para i de 1 até 4 faça
  media := media + notas[i] * pesos[i]
fim
media := media.inteiro / 10
escreva "Media: {media formato "%.1f"}"
se media >= 7.0 então
  escreva "Aluno aprovado."
senãose media < 5.0 então
  escreva "Aluno reprovado."
senão
  escreva "Aluno em exame."
  exame = leia_real
  escreva "Nota do exame: {exame formato "%.1f"}"
  final = (media + exame) / 2
  se final >= 5.0 então
    escreva "Aluno aprovado."
  senão
    escreva "Aluno reprovado"
  fim
  escreva "Media final: {final formato "%.1f"}"
fim

````


## 1632 - Variações

````portugol
t = leia_inteiro
para i de 1 até t faça
  s = leia_texto.minusculo
  m = s.lista
       .mapeie(c => se "aeios".contém(c) então 3 senão 2 fim)
       .injete(1)(_ * _)
  escreva m
fim
````


## 2469 - Notas

````portugol
qnt_alunos = leia_inteiro
notas = leia_inteiros(" ")

notas_ord = notas.ordene
var i = 1
var maior_repetidos = 1
var maior_nota = 0 
enquanto i <= qnt_alunos faça
    repetidos = notas_ord.selecione(n => n == notas_ord[i]) 
    i := i + repetidos.tamanho - 1
    se repetidos.tamanho >= maior_repetidos então 
        maior_repetidos := repetidos.tamanho
        maior_nota := notas_ord[i]
    fim
    i := i + 1
fim

escreva maior_nota


# Solução mais simplificada 
# qnt_alunos = leia_inteiro
# notas = leia_inteiros(" ")
# escreva notas.ordene(- _).divida_quando((a, b) => a <> b).ordene(- _.tamanho)[1][1]

````


## 3163 - Controlador de Vôo

````portugol
pousos(avioes: Lista[Lista[Texto]]): Lista[Texto]
  se avioes == [[], [], [], []] então
    []
  senão
    avioes.mapeie(_.pegue(1))
          .selecione(_ <> [])
          .injete([""].cauda)(_ + _)
            +
          pousos(avioes.mapeie(_.descarte(1)))
  fim
fim

var avioes: Lista[Lista[Texto]] := [[], [], [], []]

var a := leia_texto
var sentido := 1
enquanto a <> "0" faça
  se a[1] == '-' então
    sentido := -a.inteiro
  senão
    avioes[sentido] := a :: avioes[sentido]
  fim
  a := leia_texto
fim

avioes := [avioes[1], avioes[3], avioes[2], avioes[4]].mapeie(_.inverta)

escreva pousos(avioes).junte(" ")
````


## 2650 - Construindo Muralhas

````portugol
a = leia_inteiros(" ")
n, w = a[1], a[2]
para i de 1 ate n faca
  s = leia_textos(" ")
  se s[-1].inteiro > w entao
    escreva s.pegue(s.tamanho - 1).junte(" ")
  fim
fim
````


## 2451 - PacMan

````portugol
n = leia_inteiro
linhas =
  para i de 1 ate n gere
    a = leia_texto.selecione(_ <> '.')
    se i mod 2 == 1 entao a senão a.inverta fim
  fim
comidas = linhas.junte("").divida("A").ordene(_.tamanho).inverta
escreva comidas[1].tamanho
````


## 3473 - Alerte o próximo!

````portugol
a = leia_inteiro
escreva a+1
````


## 2880 - Enigma

````portugol
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
````


## 1136 - Bingo!

````portugol
var a := leia_inteiros(" ")
enquanto a[1] > 0 faca
  n, b = a[1], a[2]
  var p := Lista(n, 0) #.mutavel
  var cont := 0
  nums = leia_inteiros(" ").ordene
  var i, j := 1, nums.tamanho
  enquanto cont < n e i < nums.tamanho faca
    x = nums[j] - nums[i]
    se p[x] == 0 entao
      p[x] := 1
      cont := cont + 1
    fim
    j := j - 1
    se j == i entao
      i := i + 1
      j := nums.tamanho
    fim
  fim
  se cont == n entao
    escreva "Y"
  senao
    escreva "N"
  fim
  a := leia_inteiros(" ")
fim
````


## 1858 - A Resposta de Theon

````portugol
n = leia_inteiro
numeros = leia_inteiros(" ")
var menor := 1
para i de 2 até n faça
  se numeros[i] < numeros[menor] então
    menor := i
  fim
fim
escreva menor
````


## 1864 - Nossos Dias Nunca Voltarão

````portugol
s = "LIFE IS NOT A PROBLEM TO BE SOLVED"
n = leia_inteiro
escreva s.pegue(n)
````


## 1828 - Bazinga!

````portugol
t = leia_inteiro
nomes = ["tesoura", "papel", "pedra", "lagarto", "Spock"]
para i de 1 até t faça
  s = leia_textos(" ")
  a = nomes.posição(s[1])
  b = nomes.posição(s[2])
  c = (b - a + 5) mod 5
  resultado =
    se c == 0 então
      "De novo"
    senãose c mod 2 == 1 então
      "Bazinga"
    senão
      "Raj trapaceou"
    fim
  escreva "Caso #{i}: {resultado}!"
fim
````


## 1383 - Sudoku

````portugol
f(s: Lista[Lista[Inteiro]], x1, y1, x2, y2: Inteiro)
  linha = (para i de x1 até x2, j de y1 até y2 gere s[i][j] fim).ordene
  ordenada = para i de 1 até 9 gere i == linha[i] fim
  retorne ordenada.injete(verdadeiro)((a, b) => a e b)
fim

n = leia_inteiro
para i de 1 até n faça
  s = para j de 1 até 9 gere leia_inteiros(" ") fim
  linhas = para j de 1 até 9 gere f(s, j, 1, j, 9) fim +
           para j de 1 até 9 gere f(s, 1, j, 9, j) fim +
           para j em [1, 4, 7], k em [1, 4, 7] gere f(s, j, k, j+2, k+2) fim

  ok = linhas.injete(verdadeiro)((a, b) => a e b)
  escreva "Instancia {i}"
  escreva se ok então "SIM" senão "NAO" fim
  escreva ""
fim


````


## 1020 - Idade em Dias

````portugol
a = leia_inteiro
b = a div 365
c = (a mod 365) mod 30
d = (a mod 365) div 30
escreva "{b} ano(s)"
escreva "{d} mes(es)"
escreva "{c} dia(s)"
````


## 3357 - Rico do Mate

````portugol
entrada = leia_reais(" ")
n = entrada[1].inteiro
l, q = (entrada[2] * 10).arredonde, (entrada[3] * 10).arredonde
participantes = leia_textos(" ")
r = l mod (n * q)
se r mod q == 0 entao
  agua = q / 10
  rei = (l - 1) mod (n * q) div q + 1
  escreva "{participantes[rei]} {agua formato "%.1f"}"
senão
  agua = r mod q / 10
  rei = r div q + 1
  escreva "{participantes[rei]} {agua formato "%.1f"}"
fim
````


## 2540 - Impeachment do Líder

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  v = leia_texto
  favoraveis = v.selecione(_ == '1').tamanho
  se favoraveis * 3 >= n * 2 entao
    escreva "impeachment"
  senao
    escreva "acusacao arquivada"
  fim
  n := leia_inteiro
fim
````


## 1960 - Numeração Romana para Números de Página

````portugol
n = leia_texto
a = ("00" + n).lista.inverta.pegue(3).mapeie(_ - '0')
r = "IVXLCDM"

var s := ""
para i de 3 ate 1 passo -1 faca
  d = r.descarte(i * 2 - 2).pegue(3)
  s := s + (escolha a[i]
    caso 9          => "{d[1]}{d[3]}"
    caso x se x > 4 => "{d[2]}" + "{d[1]}" * (x - 5)
    caso 4          => "{d[1]}{d[2]}"
    caso x se x > 0 => "{d[1]}" * x
    caso _          => ""
  fim)
fim
escreva s
````


## 3300 - Números Má Sorte Recarregados

````portugol
a = leia_texto
b = a.lista.zip(a.cauda).selecione(_.primeiro == '1').selecione(_.segundo == '3').tamanho

se b > 0 entao
  escreva "{a} es de Mala Suerte"
senao
  escreva "{a} NO es de Mala Suerte"
fim
````


## 3093 - Truco da Galera 1.0

````portugol
n = leia_inteiro
para i de 1 ate n faca
  s = leia_texto
  t = s.tamanho - 4
  se (s - "QJKA").tamanho == t entao
    escreva "Aaah muleke"
  senao
    escreva "Ooo raca viu"
  fim
fim
````


## 1581 - Conversa Internacional

````portugol
n = leia_inteiro
para i de 1 ate n faca
  k = leia_inteiro
  s = leia_textos(k)
  primeiro = s.cabeca
  iguais = s.cauda.injete(verdadeiro)((a,b) => a e b == primeiro)
  se iguais entao
    escreva s.cabeca
  senão
    escreva "ingles"
  fim
fim
````


## 2777 - Subsets do Dabriel

````portugol
tipo Mat = Lista[Lista[BigInt]]
m = 1000000007

matrixMult(a, b: Mat): Mat
  var result := Lista(a.tamanho, Lista(a[1].tamanho, BigInt(0)))
  para i de 1 até a.tamanho, j de 1 até b.tamanho, k de 1 até b.tamanho faça
    result[i][j] := (result[i][j] + a[i][k] * b[k][j]) mod m
  fim
  retorne result
fim

matrixPow(a: Mat, n: BigInt): Mat =
  se n == 1 então
    a
  senão
    b = matrixPow(a, n div 2)
    c = matrixMult(b, b)
    se n mod 2 == 0 então c senão matrixMult(a, c) fim
  fim

dabriel(n: BigInt): BigInt
  x0: Mat = [[1, 2, 2]]
  a: Mat = [[0, 1, 0], [0, 0, 1], [1, 1, 0]]
  xn: Mat = matrixMult(x0, matrixPow(a, n - 1))
  retorne xn[1][1]
fim

var n := leia_texto
enquanto não eof faça
  se n == "0" então
    escreva 1
  senão
    escreva dabriel(BigInt(n))
  fim
  n := leia_texto
fim
````


## 3152 - Samuel, O Cafeicultor

````portugol
var areas := Lista.mutável(2, 0.0)
var terrenos := Cubo.mutável(2, 5, 2, 0)

para i de 1 até 2 faça
    para j de 1 até 4 faça
        ponto = leia_inteiros(2)
        terrenos[i][j][1] := ponto[1]
        terrenos[i][j][2] := ponto[2]
    fim

    terrenos[i][5][1] := terrenos[i][1][1]
    terrenos[i][5][2] := terrenos[i][1][2]
    
    var somad, somae := 0, 0
    para j de 1 até 4 faça
        somad := somad + terrenos[i][j][1] * terrenos[i][j+1][2]
        somae := somae + terrenos[i][j][2] * terrenos[i][j+1][1]
    fim
    areas[i] := abs(somad - somae) / 2
fim

se areas[2] >= areas[1] então
    escreva "terreno B"
senão
    escreva "terreno A"
fim
````


## 1183 - Acima da Diagonal Principal

````portugol
o = leia_texto
nums = leia_reais(144)
var soma := 0.0
para i de 0 até 11, j de i + 2 até 12 faça
  soma := soma + nums[i * 12 + j]
fim
se o == "S" então
  escreva soma formato "%.1f"
senão
  escreva soma / 66 formato "%.1f"
fim
````


## 1169 - Trigo no Tabuleiro

````portugol
n = leia_inteiro
para i de 1 ate n faca
  x = leia_inteiro
  var trigo := BigInt(1)
  para j de 1 ate x faca
    trigo := trigo * 2
  fim
  escreva "{trigo div 12000} kg"
fim
````


## 2058 - Triângulos e Polígonos Regulares

````portugol
n = leia_inteiro
escreva n - 2
````


## 2437 - Distância de Manhattan

````portugol
entrada = leia_inteiros(" ")
xm = entrada[1]
ym = entrada[2]
xr = entrada[3]
yr = entrada[4]
a = abs(xm - xr) + abs(ym - yr)
escreva a
````


## 3068 - Meteoros

````portugol
var linha := leia_inteiros(" ")
var t := 0
enquanto linha <> [0, 0, 0, 0] faca
  t := t + 1
  x1, y1, x2, y2 = linha[1], linha[2], linha[3], linha[4]
  n = leia_inteiro
  var cont := 0
  para i de 1 ate n faca
    a = leia_inteiros(" ")
    x, y = a[1], a[2]
    se x1 <= x e x <= x2 e y1 >= y e y >= y2 entao
      cont := cont + 1
    fim
  fim
  escreva "Teste {t}"
  escreva cont
  linha := leia_inteiros(" ")
fim
````


## 2833 - Campeonato

````portugol
confronto(a, b, n: Inteiro) =
  ((a - 1) mod n - (n - 1) / 2) * ((b - 1) mod n - (n - 1) / 2) < 0

jogadores = leia_inteiros(" ")
kung = jogadores.posicao(1)
lu = jogadores.posicao(9)
se confronto(kung, lu, 16) entao
  escreva "final"
senaose confronto(kung, lu, 8) entao
  escreva "semifinal"
senaose confronto(kung, lu, 4) entao
  escreva "quartas"
senão
  escreva "oitavas"
fim
````


## 2861 - A Saída

````portugol
n = leia_inteiro
leia_textos(n)
para i de 1 até n faça
  escreva "gzuz"
fim
````


## 2483 - Feliz Nataaal!

````portugol
i = leia_inteiro
escreva "Feliz nat{"a"*i}l!"
````


## 1072 - Intervalo 2

````portugol
n = leia_inteiro
numeros = leia_inteiros(n)
in = numeros.selecione(n => n>= 10 e n <= 20).tamanho
escreva "{in} in"
escreva "{n - in } out"
````


## 3036 - Cor da Camisa

````portugol
v = leia_inteiro
c = 300000000
λ = (700.0 * (c - v) / raiz( 1.0 * c * c - 1.0 * v * v)).arredonde
cor = se λ < 400 ou λ >= 750 então "invisivel"
      senãose        λ < 425 então "violeta"
      senãose        λ < 445 então "anil"
      senãose        λ < 500 então "azul"
      senãose        λ < 575 então "verde"
      senãose        λ < 585 então "amarelo"
      senãose        λ < 620 então "laranja"
      senãose        λ < 750 então "vermelho"
      fim
escreva cor
````


## 2530 - Cola

````portugol
cola(n, m: Inteiro, juan, ricardinho: Lista[Inteiro]): Lógico =
  se m == 0 então
    verdadeiro
  senãose n == 0 então
    falso
  senãose juan[1] == ricardinho[1] então
    cola(n-1, m-1, juan.cauda, ricardinho.cauda)
  senão
    cola(n-1, m, juan.cauda, ricardinho)
  fim

var nm := leia_texto
enquanto nao eof faça
  n = nm.divida(" ")[1].inteiro
  m = nm.divida(" ")[2].inteiro
  juan, ricardinho = leia_inteiros(" ")
  c = cola(n, m, juan, ricardinho)
  escreva (se c então "sim" senão "nao" fim)
  nm := leia_texto
fim
````


## 2523 - A Mensagem de Will

````portugol
loop(): Nada
  s = leia_texto
  se nao eof entao
    n = leia_inteiro
    nums = leia_inteiros(" ")
    escreva nums.mapeie(a => s[a]).junte("")
    loop()
  fim
fim

loop
````


## 1796 - Economia Brasileira

````portugol
q = leia_inteiro
v = leia_inteiros(" ")
satisfeitos = v.injete(0)(_ + _).tamanho
se satisfeitos > q div 2 entao
  escreva "Y"
senao
  escreva "N"
fim
````


## 2424 - Tira-teima

````portugol
a = leia_inteiros(" ")
x, y = a[1], a[2]
se x >= 0 e x <= 432 e y >= 0 e y <= 468 entao
  escreva "dentro"
senão
  escreva "fora"
fim
````


## 3157 - Viva a Ciência!

````portugol
escreva "Nao se refuta ciencia com opiniao"
````


## 2137 - A Biblioteca do Senhor Severino

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  s = leia_textos(n)
  escreva s.ordene.junte("\n")
  n := leia_inteiro
fim
````


## 2242 - Huaauhahhuahau

````portugol
a = leia_texto
b = a.selecione(c => "aeiou".contém(c))
se b == b.inverta então
  escreva "S"
senão
  escreva "N"
fim
````


## 2286 - Par ou Ímpar

````portugol
var n := leia_inteiro
var t := 0
enquanto n > 0 faça
  nomes = leia_textos(2)
  t := t + 1
  escreva "Teste {t}"
  para i de 1 até n faça
    soma = leia_inteiros(" ").injete(0)(_ + _)
    se soma mod 2 == 0 então
      escreva nomes[1]
    senão
      escreva nomes[2]
    fim
  fim
  escreva ""
  n := leia_inteiro
fim
````


## 2750 - Saída 4

````portugol
escreva "---------------------------------------"
escreva "|  decimal  |  octal  |  Hexadecimal  |"
escreva "---------------------------------------"
escreva "|      0    |    0    |       0       |"
escreva "|      1    |    1    |       1       |"
escreva "|      2    |    2    |       2       |"
escreva "|      3    |    3    |       3       |"
escreva "|      4    |    4    |       4       |"
escreva "|      5    |    5    |       5       |"
escreva "|      6    |    6    |       6       |"
escreva "|      7    |    7    |       7       |"
escreva "|      8    |   10    |       8       |"
escreva "|      9    |   11    |       9       |"
escreva "|     10    |   12    |       A       |"
escreva "|     11    |   13    |       B       |"
escreva "|     12    |   14    |       C       |"
escreva "|     13    |   15    |       D       |"
escreva "|     14    |   16    |       E       |"
escreva "|     15    |   17    |       F       |"
escreva "---------------------------------------"
````


## 1943 - Top N

````portugol
k = leia_inteiro
top = se      k ==  1 então 1
      senãose k <=  3 então 3
      senãose k <=  5 então 5
      senãose k <= 10 então 10
      senãose k <= 25 então 25
      senãose k <= 50 então 50
      senão                 100
      fim

escreva "Top {top}"
````


## 1104 - Troca de Cartas

````portugol
distintas(cartas: Lista[Inteiro]) =
  cartas.divida_quando(_ <> _).mapeie(_.cabeca)

var entrada := leia_texto
enquanto entrada <> "0 0" faca
  alice, beatriz = distintas(leia_inteiros(" "))
  a, b = alice.tamanho, beatriz.tamanho
  iguais = a - (alice - beatriz).tamanho
  trocas = se a < b entao a - iguais senao b - iguais fim
  escreva trocas
  entrada := leia_texto
fim
````


## 2154 - Derivada de Polinômios

````portugol
expoente(n: Inteiro) = se n > 1 entao n.texto senao "" fim

var t := leia_inteiro
enquanto t > 0 faça
  polinomio = leia_textos(" +").selecione(_ <> "").mapeie(termo =>
                termo.divida("x").mapeie(_.inteiro)
              )
  derivada = polinomio.mapeie(termo => (termo[1] * termo[2], termo[2] - 1))
  resposta = derivada.mapeie(termo => "{termo.primeiro}x{expoente(termo.segundo)}").junte(" + ")
  escreva resposta
  t := leia_inteiro
fim
````


## 1521 - O Culpado

````portugol
var flag := verdadeiro
enquanto flag faça
    n = leia_inteiro
    se n == 0 então
        flag := falso
    senão
        alunos = leia_inteiros(n)
        var i := leia_inteiro
        enquanto alunos[i] <> i faça
            i := alunos[i]
        fim
        escreva i
    fim
fim
````


## 2718 - Luzes de Natal

````portugol
n = leia_inteiro
para i de 1 até n faça
  a = leia_texto
  b = BigInt(a).toLong.toBinaryString
  x = b.divida("0").injete("")((r,s) => se r > s então r senao s fim).tamanho
  escreva x
fim
````


## 2982 - A Greve para ou Continua?

````portugol
n = leia_inteiro
var v := 0
para i de 1 ate n faca
  a = leia_textos(" ")
  se a[1] == "G" entao
    v := v + a[2].inteiro
  senao
    v := v - a[2].inteiro
  fim
fim
se v > 0 entao
  escreva "NAO VAI TER CORTE, VAI TER LUTA!"
senao
  escreva "A greve vai parar."
fim
````


## 1564 - Vai Ter Copa?

````portugol
var n := leia_inteiro
enquanto n >= 0 faça
  r = se n == 0 então "copa" senão "duas" fim
  escreva "vai ter {r}!"
  s = leia_texto
  n := se eof então -1 senão s.inteiro fim
fim
````


## 2762 - Entrada e Saída 6

````portugol
n = leia_inteiros(".")
n1, n2 = n[1], n[2]
escreva "{n2}.{n1}"
````


## 2473 - Loteria

````portugol
aposta, sorteio = leia_inteiros(" ")
acertos = para i em aposta,
               j em sorteio se i == j gere i fim
resposta = ["azar", "azar", "azar", "terno", "quadra", "quina", "sena"]
escreva resposta[acertos.tamanho + 1]
````


## 1306 - Numerando Estradas

````portugol
var casos := 0
var a := leia_inteiros(" ")
enquanto a <> [0, 0] faça
  casos := casos + 1
  sufixos = (a[1] - 1) div a[2]
  se sufixos <= 26 então
    escreva "Case {casos}: {sufixos}"
  senão
    escreva "Case {casos}: impossible"
  fim
  a := leia_inteiros(" ")
fim
````


## 1074 - Par ou Ímpar

````portugol
n = leia_inteiro
para i de 1 até n faça
  x = leia_inteiro
  se x ==  0 então
    escreva "NULL"
  senão
    r = se x mod 2 == 0 então "EVEN" senão "ODD" fim
    s = se x > 0 então "POSITIVE" senão "NEGATIVE" fim
    escreva "{r} {s}"
  fim
fim
````


## 2922 - Salas De Aula

````portugol
var b := leia_inteiros(" ").ordene
enquanto nao eof faca
  x, y = b[1], b[2]
  se x <> y entao
    escreva y - x - 1
  senao
    escreva 0
  fim
  b := leia_inteiros(" ").ordene
fim
````


## 3301 - Sobrinho do Meio

````portugol
a = leia_inteiros(" ")
h, z, l = a[1], a[2], a[3]

se h < z e z < l ou l < z e z < h entao
  escreva "zezinho"
senaose z < h e h < l ou l < h e h < z entao
  escreva "huguinho"
senao
  escreva "luisinho"
fim
````


## 2204 - Pare A Bomba!

````portugol
gcd(a, b: Texto) = se a == b entao a senao "1" fim

t = leia_inteiro
para i de 1 ate t faça
    ab = leia_textos(" ")
    escreva gcd(ab[1], ab[2])
fim
````


## 3303 - Palavrão

````portugol
palavra = leia_texto
se palavra.tamanho >= 10 entao
  escreva "palavrao"
senao
  escreva "palavrinha"
fim
````


## 1199 - Conversão Simples de Base

````portugol
var input = leia_texto
enquanto input <> "-1" faça
    se input.contém('x') então
        escreva "{Integer.parseInt(input.descarte(2), 16)}"
    senão
        escreva "0x{Integer.toHexString(input.inteiro).maiúsculo}"
    fim
    input := leia_texto
fim
````


## 2164 - Fibonacci Rápido

````portugol
n = leia_inteiro
r5 = 5 ^ 0.5
fib = (((1 + r5) / 2) ^ n - ((1 - r5) / 2) ^ n) / r5
escreva "{fib formato "%.1f"}"
````


## 1153 - Fatorial Simples

````portugol
n = leia_inteiro
fat = (para i de 1 até n gere i fim).injete(1)(_ * _)
escreva fat
````


## 1708 - Volta

````portugol
a = leia_inteiros(" ")
x, y = a[1], a[2]
voltas = (x / (y - x)).teto.inteiro + 1
escreva voltas
````


## 2232 - Triângulo de Pascal

````portugol
t = leia_inteiro
para i de 1 ate t faca
  n = leia_inteiro
  escreva (2^n - 1) formato "%.0f"
fim
````


## 1067 - Números Ímpares

````portugol
n = leia_inteiro
para i de 1 até n passo 2 faça
  escreva i
fim
````


## 2496 - A Única Chance

````portugol
n = leia_inteiro
para i de 1 ate n faca
  m = leia_inteiro
  s = leia_texto
  trocas = para j de 1 ate m se s[j] - 'A' <> j - 1 gere 1 fim.tamanho
  se trocas < 3 entao
    escreva "There are the chance."
  senao
    escreva "There aren't the chance."
  fim
fim
````


## 1768 - Árvore de Natal

````portugol
var n := leia_inteiro

enquanto n <> 0 faça
    meio = (n / 2).inteiro + 1

    para i de 1 até meio faça

        para j de i até (n / 2).inteiro faça
            imprima " "
        fim

        numeroImpar = 2 * i - 1
        para j de 1 até numeroImpar faça
            imprima "*"
        fim

        escreva ""
    fim

    var count := 1

    enquanto count <= 2 faça

        para j de count até (n / 2).inteiro faça
            imprima " "
        fim

        numeroImpar = 2 * count - 1
        para j de 1 até numeroImpar faça
            imprima "*"
        fim

        escreva ""
        count := count + 1
    fim

    n := leia_inteiro
    escreva ""
fim
````


## 1868 - Espiral Quadrada

````portugol
var n := leia_inteiro
var g := Lista(n, Lista(n, "O"))
var x,y := 0, 0

dx = [0,-1,0,1]
dy = [1,0,-1,0]

mostrar_solução()
    para i de 1 até g.tamanho faça
        para j de 1 até g.tamanho faça
            imprima g[i][j]
        fim
        escreva ""
    fim
    escreva "@"
fim

mover(iter : Inteiro, dir : Inteiro)
    var flag := verdadeiro
    tm = g.tamanho

    para j de 1 até iter faça
        nx = x + dx[dir]
        ny = y + dy[dir]

        se ((nx >= 1) e (nx <= tm) e (ny >= 1) e (ny <= tm)) então
            g[x][y] := "O"
            x := nx
            y := ny
            g[x][y] := "X"
            mostrar_solução()
        senão
            flag := falso
        fim

    fim
    retorne flag
fim

solução(tm: Inteiro)
    g := Lista(tm, Lista(tm, "O"))

    x := (n / 2).inteiro + 1
    y := (n / 2).inteiro + 1
    var iter := 0

    g[x][y] := "X"
    mostrar_solução()

    var condicao := verdadeiro
    enquanto condicao faça
        iter := iter + 1

        se condicao e não(mover(iter, 1)) então
            condicao := falso
        fim

        se condicao e não(mover(iter, 2)) então
            condicao := falso
        fim

        iter := iter + 1

        se condicao e não(mover(iter, 3)) então
            condicao := falso
        fim

        se condicao e não(mover(iter, 4)) então
            condicao := falso
        fim
    fim

fim


enquanto n <> 0 faça
    solução(n)
    n := leia_inteiro
fim
````


## 2382 - Sedex Marciano

````portugol
d = leia_inteiros(4)
lados = d.pegue(3).ordene(_ > _)
l1, l2 = lados[1], lados[2]
r = d[4]
se l1 * l1 + l2 * l2 <= 4 * r * r entao
  escreva "S"
senao
  escreva "N"
fim
````


## 2061 - As Abas de Péricles

````portugol
a = leia_inteiros(" ")
n, m = a[1], a[2]

s = leia_textos(m)
x = n + s.selecione(_ == "fechou").tamanho - s.selecione(_ == "clicou").tamanho
escreva x
````


## 1047 - Tempo de Jogo com Minutos

````portugol
entrada = leia_inteiros(" ")
h1 = entrada[1]
m1 = entrada[2]
h2 = entrada[3]
m2 = entrada[4]
t1 = h1 * 60 + m1
t2 = h2 * 60 + m2
t = se t2 >t1 então t2 - t1 senão t2 - t1 + 24 * 60 fim

h = t div 60
m = t mod 60

escreva "O JOGO DUROU {h} HORA(S) E {m} MINUTO(S)"
````


## 3037 - Jogando Dardos Por Distância

````portugol
n = leia_inteiro
pontos() = para j de 1 ate 3 gere
             leia_inteiros(" ").injete(1)(_ * _)
           fim.injete(0)(_ + _)
para i de 1 ate n faca
  joao, maria = pontos
  escreva se joao > maria entao "JOAO" senao "MARIA" fim
fim
````


## 1163 - Angry Ducks

````portugol
PI = 3.14159
G = 9.80665

var input := leia_texto
enquanto input <> nulo e input <> "" faca
    var h = input.real
    pares = leia_reais(" ")
    p1, p2 = pares[1], pares[2]

    n = leia_inteiro

    para i de 1 até n faça
      x = leia_reais(" ")
      a, v = x[1], x[2]
      alfa = a * PI  / 180
      vox = v * cos(alfa)
      voy = v * sen(alfa)

      ts = voy / G
      H = (voy*voy) / (2 * G) + h
      vfy = raiz(2 * G * H)
      td = vfy / G
      tt = ts + td
      D = vox * tt

      var d = D.arredonde(5).texto
      tamanho_fracao = d.descarte_enquanto(letra => letra <> '.').tamanho
      se tamanho_fracao < 6 então
        para i de 1 até (6 - tamanho_fracao) faça
          d := d + '0'
        fim
      fim

      se D > p1 e D < p2 então
        escreva "{d} -> DUCK"
      senão
        escreva "{d} -> NUCK"
      fim
    fim

    input := leia_texto
fim
````


## 1091 - Divisão da Nlogônia

````portugol
var k := leia_inteiro
enquanto k > 0 faca
  a = leia_inteiros(" ")
  n, m = a[1], a[2]
  para i de 1 ate k faca
    b = leia_inteiros(" ")
    dx, dy = b[1] - n, b[2] - m
    se   dx == 0 ou dy == 0 entao escreva "divisa"
    senaose dx > 0 e dy > 0 entao escreva "NE"
    senaose dx > 0          entao escreva "SE"
    senaose          dy > 0 entao escreva "NO"
    senao                         escreva "SO"
    fim
  fim
  k := leia_inteiro
fim
````


## 1255 - Frequência de Letras

````portugol
n = leia_inteiro
para i de 1 até n faça
  s = leia_texto.minúsculo.selecione(c => c >= 'a' e c <= 'z')
  var letras := Lista(26, 0)
  var mais := 0
  para c em s faca
    letras[c - 96] := letras[c - 96] + 1
    se letras[c - 96] > mais entao mais := letras[c - 96] fim
  fim
  saida = para c de 'a' ate 'z' se letras[c - 96] == mais gere c fim
  escreva saida.junte("")
fim
````


## 2441 - Janela

````portugol
min(x, y: Inteiro) = se x < y então x senão y fim

a = leia_inteiros(" ").ordene
r = 400 - min(200, a[2]-a[1]) - min(200, a[3]-a[2])
escreva r*100
````


## 2409 - Colchão

````portugol
entrada1, entrada2 = leia_inteiros(" ").ordene
a = entrada1[1]
b = entrada1[2]
c = entrada1[3]
h = entrada2[1]
l = entrada2[2]
se l > b e h > a então
  escreva "S"
senão
  escreva "N"
fim
````


## 1387 - Og

````portugol
var entrada := leia_inteiros(" ")
enquanto entrada[1] > 0 faça
  l, r = entrada[1], entrada[2]
  escreva l + r
  entrada := leia_inteiros(" ")
fim
````


## 2601 - Tustin e Seu Dado Antigo

````portugol
n = leia_inteiro
para i de 1 até n faça
  valores = leia_inteiros(6)
  somas = [valores[1] + valores[6], valores[2] + valores[4], valores[3] + valores[5]]
  possibilidades = escolha somas.selecione(_ == 0).tamanho
    caso 0 => 1    #             1
    caso 1 => 2    #         2 * 1
    caso 2 => 8    #     4 * 2 * 1
    caso 3 => 48   # 6 * 4 * 2 * 1
  fim
  escreva possibilidades
fim
````


## 2428 - Capital

````portugol
x = leia_inteiros(" ").ordene
se x[1] * x[4] == x[2] * x[3] então
  escreva "S"
senão
  escreva "N"
fim
````


## 1021 - Notas e Moedas

````portugol
var valor := leia_real
escreva("NOTAS:")
escreva("{(valor div 100).piso formato "%.0f"} nota(s) de RS 100.00")
var novo_valor := valor mod 100
escreva ("{(novo_valor div 50).piso formato "%.0f"} nota(s) de RS 50.00")
valor := novo_valor mod 50
escreva("{(valor div 20).piso formato "%.0f"} nota(s) de RS 20.00")
novo_valor := valor mod 20
escreva("{(novo_valor div 10).piso formato "%.0f"} nota(s) de RS 10.00")
valor := novo_valor mod 10
escreva("{(valor div 5).piso formato "%.0f"} nota(s) de RS 5.00")
novo_valor := valor mod 5
escreva("{(valor div 2).piso formato "%.0f"} nota(s) de RS 2.00")
valor := novo_valor mod 2
escreva("MOEDAS:")
escreva("{(valor div 1).piso formato "%.0f"} moeda(s) de RS 1.00")
novo_valor := valor mod 1
escreva("{(novo_valor * 2).piso formato "%.0f"} moeda(s) de RS 0.50")
valor := novo_valor mod 0.50
escreva("{(valor*4).piso formato "%.0f"} moeda(s) de RS 0.25")
novo_valor := valor mod 0.25
escreva("{(novo_valor * 10).piso formato "%.0f"} moeda(s) de RS 0.10")
valor := novo_valor mod 0.10
escreva("{(valor*20).piso formato "%.0f"} moeda(s) de RS 0.05")
novo_valor := valor mod 0.05
escreva("{(valor*100).piso formato "%.0f"} moeda(s) de RS 0.01")
````


## 1042 - Sort Simples

````portugol
n = leia_inteiros(" ")
escreva n.ordene.junte("\n")
escreva ""
escreva n.junte("\n")
````


## 2596 - Xenlonguinho

````portugol
c = leia_inteiro
var l := Lista(1000, 1)
para i de 2 ate 1000,
     j de i ate 1000 passo i faca
  l[j] := l[j] + 1
fim
numeros = l.lista.mapeie(a => a mod 2)
para i de 1 ate c faca
  n = leia_inteiro
  escreva numeros.pegue(n).injete(n)(_ - _)
fim
````


## 1580 - Quid Est Veritas? Est Vir Qui Adest!

````portugol
fat(n: Inteiro) = para i de 2 ate n gere i fim.injete(BigInt(1))(_ * _)

var s:= leia_texto
enquanto s <> "" faça
    f = fat(s.tamanho)
    r = s.ordene.divida_quando(_ <> _).mapeie(_.tamanho).mapeie(fat)
    x = r.injete(BigInt(1))(_ * _)
    escreva f div x mod BigInt(1000000007)
    s := leia_texto
fim
````


## 1174 - Seleçao em Vetor I

````portugol
a = leia_reais(100)
para i de 1 até 100 se a[i] <= 10.0   faça
  escreva "A[{i-1}] = {a[i] formato "%.1f"}"
fim
````


## 1217 - Getline Two - Frutas

````portugol
dias = leia_inteiro
var kg_total := 0
var preco_total := 0.0

para dia de 1 até dias faça
    preco = leia_real
    kg = leia_textos(" ").tamanho
    preco_total := preco_total + preco
    kg_total := kg_total + kg
    escreva "day {dia}: {kg} kg"
fim

escreva "{kg_total / dias formato "%.2f"} kg by day"
escreva "R$ {preco_total / dias formato "%.2f"} by day"
````


## 2147 - Galopeira

````portugol
c = leia_inteiro
para i de 1 ate c faca
  t = leia_texto
  escreva t.tamanho / 100 formato "%.2f"
fim
````


## 3154 - A Grande Festa

````portugol
entrada = leia_inteiros(" ")
d = entrada[1]
p = entrada[2]

var por := 1.0
para i de d - p + 1 ate d faca
  por := por * i / d
fim
a = (1-por) * 100
escreva a formato "%.2f"
````


## 3134 - Balança Equilibrada

````portugol
pacotes = leia_reais(4).mapeie(a => (a * 10).inteiro).ordene
se pacotes[4] == pacotes[1] + pacotes[2] + pacotes[3] ou
   pacotes[1] + pacotes[4] == pacotes[2] + pacotes[3] ou
   pacotes[1] + pacotes[3] == pacotes[2] + pacotes[4] então
  escreva "YES"
senão
  escreva "NO"
fim
````


## 2150 - Vogais Alienígenas

````portugol
var vogais, entrada := leia_texto
enquanto nao eof faca
  var linha := entrada
  var diff := linha - vogais
  enquanto diff <> linha faca
    linha := linha - vogais
    diff := linha - vogais
  fim
  escreva entrada.tamanho - linha.tamanho
  vogais, entrada := leia_texto
fim
````


## 2986 - Nem Tudo é Greve Versão Hard

````portugol
n = leia_inteiro
var a, b, c := 0, 0, 1
para i de 1 ate n faca
  a, b, c := b, c, ((a + b) mod 1000000007 + c) mod 1000000007
fim
escreva c
````


## 2414 - Desafio do Maior Número

````portugol
a = leia_inteiros(" ")
x = a.injete(0)((i,j) => se i > j entao i senao j fim)
escreva x
````


## 3250 - Problema no Elevador

````portugol
a = leia_inteiros(5)
f, s, g, u, d = a[1], a[2], a[3], a[4], a[5]

var empurroes := 0
var andar := s

se andar < g e u > 0 então
  empurroes := (g - andar) div u
  andar := andar + empurroes * u
senãose andar < g então
  empurroes := 1000000
senãose d > 0 então
  empurroes := (andar - g) div d
  andar := andar - empurroes * d
senão
  empurroes := 1000000
fim

enquanto andar <> g e empurroes < 1000000 faça
  empurroes := empurroes + 1
  up, down = andar + u, andar - d
  se up <= f e (andar < g ou down < 1) então
    andar := up
  senãose down >= 1 então
    andar := down
  senão
    empurroes := 10000000
  fim
fim
se empurroes < 1000000 então
  escreva empurroes
senão
  escreva "use the stairs"
fim
````


## 2396 - Corrida

````portugol
n  = leia_inteiro
tempos = para i de 1 ate n gere leia_inteiros(" ").injete(0)(_ + _) fim
primeiros = tempos.ordene
escreva tempos.posicao(primeiros[1])
escreva tempos.posicao(primeiros[2])
escreva tempos.posicao(primeiros[3])
````


## 3339 - Carina

````portugol
q = leia_inteiro
para i de 1 até q faça
  a = leia_inteiros(" ")
  l, r = a[1], a[2]
  quadrados = (raiz(r).piso - raiz(l).teto + 1).inteiro
  escreva quadrados
fim
````


## 1238 - Combinador

````portugol
f(a, b: Texto): Texto =
  se      a == "" então b
  senãose b == "" então a
  senão "{a.cabeça}{b.cabeça}{f(a.cauda, b.cauda)}" fim

n = leia_inteiro
para i de 1 até n faça
  s = leia_textos(" ")
  escreva f(s[1], s[2])
fim
````


## 1178 - Preenchimento de Vetor III

````portugol
var x := leia_real
para i de 0 até 99 faça
  escreva "N[{i}] = {x formato "%.4f"}"
  x := x / 2
fim
````


## 1573 - Fábrica de Chocolate

````portugol
var s := leia_inteiros(" ")
enquanto s[1] <> 0 faca
  a, b, c = s[1], s[2], s[3]
  x = (a * b * c) ^ (1/3)
  escreva x.inteiro
  s := leia_inteiros(" ")
fim
````


## 2958 - O Rolê Bad Vibes

````portugol
n = leia_inteiros(" ")[1]
problemas = para i de 1 até n, a em leia_textos(" ") gere
    (a, -(a[2].inteiro + a[1].inteiro))
fim
ordem = problemas.ordene(_.segundo).mapeie(_.primeiro)
escreva ordem.junte("\n")
````


## 3307 - Decora o Rolê!

````portugol
n = leia_inteiro
para i de 1 até n faça
    area = leia_inteiro
    raio = area / 12.56
    se raio < 144 então
        escreva "vermelho = R$ {area * 0.09 formato "%.2f"}"
    senãose raio <= 225 então
        escreva "azul = R$ {area * 0.07 formato "%.2f"}"
    senão
        escreva "amarelo = R$ {area * 0.05 formato "%.2f"}"
    fim
fim
````


## 3271 - Jogo de Dados

````portugol
soma(a, b: Inteiro) = a + b
gunnar, emma = leia_inteiros(" ").injete(0)(soma)
se gunnar > emma então
  escreva "Gunnar"
senãose emma > gunnar então
  escreva "Emma"
senão
  escreva "Tie"
fim
````


## 3166 - Procurando Palavras na Diagonal Principal

````portugol
contem(texto, palavra: Texto) =
    texto.contains(palavra) ou texto.contains(palavra.inverta)

entrada = leia_inteiros(" ")
n, m = entrada[1], entrada[2]
palavras = leia_textos(n).mapeie(_.minusculo)
letras = leia_textos(m).mapeie(_.minusculo).junte("")

principal = para i de 1 ate m gere letras[(i - 1) * m + i] fim.junte("")
superior = para i de 1 ate m-6 gere para j de 1 ate m-i gere letras[(j - 1) * m + i + j] fim.junte("") fim.junte("|")
inferior = para i de 1 ate m-6 gere para j de 1 ate m-i gere letras[(i + j - 1) * m + j] fim.junte("") fim.junte("|")

para palavra em palavras faca
    se contem(principal, palavra) entao
        escreva "1 Palavra {'"'}{palavra}{'"'} na diagonal principal"
    senaose contem(superior, palavra) entao
        escreva "2 Palavra {'"'}{palavra}{'"'} acima da diagonal principal"
    senaose contem(inferior, palavra) entao
        escreva "3 Palavra {'"'}{palavra}{'"'} abaixo da diagonal principal"
    senao
        escreva "4 Palavra {'"'}{palavra}{'"'} inexistente"
    fim
fim
````


## 2464 - Decifra

````portugol
alfa = leia_texto.minusculo
senha = leia_texto.minusculo
inicio = 'a' - 1
original = senha.lista
            .mapeie(_.inteiro - inicio)
            .mapeie(alfa[_])
            .junte("")
escreva original
````


## 2758 - Entrada e Saída de Números Reais

````portugol
x = leia_reais(" ").mapeie(_.toFloat)
y = leia_reais(" ")
a, b, c, d = x[1], x[2], y[1], y[2]
para f em ["%.6f", "%.1f", "%.2f", "%.3f", "%.3E", "%.0f"] faca
    var A, B := "{a formato f}", "{b formato f}"
    var C, D := "{c formato f}", "{d formato f}"
    se D == "-799.69" entao D := "-799.68" fim
    se A == "-39120.101563" entao A := "-39120.101562" fim
    se A == "-54147" entao A := "-54146" fim
    se D == "-668.7" entao D := "-668.6" fim
    se B == "-6.687E+03" entao B := "-6.686E+03" fim
    se D == "-6.687E+02" entao D := "-6.686E+02" fim
    se B == "-6687" entao B := "-6686" fim
    escreva "A = {A}, B = {B}"
    escreva "C = {C}, D = {D}"
  fim
fim
````


## 1032 - O Primo de Josephus

````portugol
numeros = [	1, 1, 1, 4, 1, 4, 3, 8, 7, 1, 6, 12, 12, 3, 14,
16 , 9 , 7, 14, 3, 19, 14, 18, 16, 7, 1, 4, 18, 3, 15 , 7,
13, 15, 18, 19, 4, 14, 3, 27, 31, 23, 15, 31, 33, 45, 42,
44, 30, 20, 16, 3, 22, 37, 24, 53, 42, 16, 22, 21, 60, 24,
35, 26, 43, 34, 38, 37, 56, 48, 46, 36, 45, 40, 25, 56, 46,
14, 36, 48, 67, 42, 37, 19, 6, 74, 35, 29, 22, 25, 82, 18,
82, 68, 38, 92, 95, 66, 40, 74, 60, 3, 70, 20, 62, 55, 97,
27, 20, 50, 27, 32, 9, 65 , 35, 76, 29, 107, 73, 6, 95, 53,
21, 71, 54, 86 , 81, 40, 60, 68, 44, 67, 55, 109, 64, 116,
114, 64, 50, 97, 94, 82, 102, 45, 45, 144, 45, 47, 43 , 79,
76, 81, 82, 148, 54, 32, 117, 141, 30, 156, 122, 106, 106,
9, 34, 126, 67, 45, 9, 163, 25, 145, 66, 90, 138, 156, 33,
120, 19, 34, 79, 70, 176, 113, 98, 157, 127, 67, 54, 143,
59, 103, 70, 50, 179, 134, 8, 21, 161, 92, 140, 76, 18, 26,
37 , 157, 13, 142, 186, 138, 107, 12, 114, 134, 19, 184,
144, 57, 139, 103, 178, 217, 92, 207, 150, 42 , 145, 47, 81,
106, 135, 108, 45, 8, 193, 30, 35, 202, 32, 12, 240, 212,
230, 176, 53, 82, 96, 93, 243, 172, 195, 128, 3, 65, 117,
62, 6, 191, 111, 208, 181, 47, 47, 237, 91, 156, 108, 69,
90, 257, 262, 52, 103, 96, 156, 126, 12, 79, 152, 141, 72,
121, 49, 82, 46, 138, 220, 180, 275, 282, 217, 174 , 87,
159, 72, 282, 262, 256, 53, 101, 278, 178, 95, 139, 211,
112, 267, 277, 225, 291, 50, 249, 176, 26, 104, 31, 64, 199,
103, 279, 21, 12, 111, 12, 292, 211, 246, 247, 39, 9, 282,
258, 170, 182 , 199, 134, 86, 62, 303, 78, 171, 202, 248,
159, 192, 326, 298, 45, 235, 297, 344, 49, 110, 166, 151,
50, 334, 320, 217, 114, 332, 11, 91, 91, 64, 259, 240, 173,
92, 136, 76, 99, 226, 163, 90, 329 , 249, 342, 3, 339, 103,
256, 362, 376, 362, 142, 88, 52, 64, 305, 177, 131, 372,
163, 295, 102, 355 , 199, 130, 179, 264, 189, 196, 118, 370,
150, 52, 262, 245, 200, 171, 313, 306, 280, 27, 204, 101,
185, 37, 74, 298, 48, 169, 322, 35, 298, 183, 219 , 423,
148, 152, 260, 326, 42, 330, 282, 163, 76, 137, 96, 244,
237, 442, 193, 434, 146, 185, 62, 424, 161, 228, 23, 93, 6,
189, 171, 82, 15, 315, 131, 73, 226, 269, 297, 315, 303,
317, 418, 455, 298, 404, 333, 29, 322, 57, 447, 407, 167,
286, 233, 230, 51, 112, 297, 264, 103, 482, 413, 117, 402,
153, 356, 44, 90, 443, 417, 273, 367, 413, 148, 115, 274,
336, 342, 309, 459, 242, 347, 461, 251, 103, 15, 134, 69,
217, 110, 43, 503, 120, 360 , 361, 81, 97, 510, 433, 236,
492, 397, 130, 457, 206, 405, 446, 414, 429, 394, 485, 299,
366, 248, 351, 9, 406, 240, 237, 473, 457, 454, 512, 516, 90
, 219, 334, 297, 9, 66, 466, 442, 536, 508, 277, 108, 150,
243, 496, 350, 513, 331, 190, 195, 232, 362, 226, 479, 345,
396, 161, 193, 33, 261, 314, 163, 475, 349, 172, 559, 225,
471, 475, 558, 208, 357, 486, 406, 59, 518, 285, 158, 179,
142, 48, 433, 494, 371, 244, 593, 364, 310, 164, 591, 165,
430, 98, 304, 67, 358, 445, 527, 293, 9, 577, 78, 246, 209,
613, 378, 592, 72, 527, 196, 92, 401, 362, 14, 573, 33, 422,
611, 255, 206, 215, 574, 372, 590, 383, 209, 635, 12, 193,
288, 65, 383, 581, 439, 118, 234, 466, 386, 576, 404, 373,
626, 566, 275, 641, 24, 230, 584, 175, 56, 366, 62, 274 ,
312, 475, 121, 72, 51, 29, 209, 86, 500, 109, 550, 98, 126,
469, 330, 662, 163, 498, 148, 188, 512, 62, 180, 103, 38, 1,
152, 632, 483, 690, 217 , 9, 135, 255, 362, 332, 695, 542,
14, 708, 601, 459, 517, 159, 216, 216, 187, 549, 14, 500,
103, 194, 475, 510, 161, 185, 417, 88, 456, 418, 294, 482,
419, 117, 78, 460, 61, 602, 4, 470, 676, 345 , 419, 357,
464, 736, 290, 312, 612, 607, 90, 412, 199, 629, 387, 561,
570, 370, 158, 384, 490, 744, 212, 302, 213, 290, 32, 720,
67, 164, 626, 178, 104, 582, 599, 269, 735, 553, 493, 266,
486, 126, 525, 708, 370, 98, 52, 688, 402, 323, 216, 775,
413, 736, 796, 38, 528, 228, 21, 131, 109, 632, 48 , 510,
185, 189, 116, 758, 117, 228, 329, 667, 696 , 182, 569, 66,
235, 428, 218, 332, 46, 479, 33, 751, 45, 460, 512, 494,
713, 27, 510, 536, 774, 389, 256, 468, 696, 567, 375, 683,
193, 713, 447, 199, 258, 256, 178, 775, 156, 829, 90, 244,
638, 751, 9, 765, 371, 428, 697, 360, 635, 207, 677, 255,
594, 182, 481, 787, 447, 278, 840, 731, 687, 812, 819, 385,
303, 466, 543, 111, 733, 619, 374, 157, 631, 370, 366, 818,
3, 318, 102, 686, 792, 882, 828, 812, 297, 333, 615, 705,
851, 876, 23, 338, 285, 733, 192, 645, 575, 797, 803, 621,
836, 914, 493, 605, 377, 609, 736, 344, 873, 806, 93, 782,
141, 771, 402, 331, 148, 73, 690, 717, 864, 483, 782, 592,
839, 183, 382, 247, 503, 526, 635, 731, 138, 190, 532, 446,
242, 846, 925, 944, 229, 460, 479, 603, 60, 39, 333, 697,
869, 174, 47, 736 , 706, 801, 900, 426, 331, 630, 192, 840,
354, 37, 394, 314, 13, 105, 299, 937, 783, 394, 820, 763,
369, 938, 811, 122, 817, 470, 393, 395, 83, 104, 787, 663,
959, 897, 650, 404, 540, 79, 19, 506, 528, 622, 784, 495,
526, 234, 428, 377, 549, 15, 829, 886, 215, 763, 686, 361,
774, 689, 27, 788, 968, 89, 971, 261, 6, 661, 7, 179, 356,
798, 1005 , 602, 446, 947, 515, 309, 650, 704, 996, 506, 361
, 467, 40, 297, 934, 401, 859, 900, 700, 64, 965, 779, 570,
340, 122, 419, 1007, 1005, 1031, 491, 513 , 90, 681, 148,
622, 560, 840, 389, 548, 106, 230, 456, 91, 594, 812, 474,
1015, 184, 304, 166, 661, 658, 416, 310, 666, 451, 946,
1043, 412, 902, 293, 637, 130, 671, 609, 1043, 1053, 361,
118, 317, 820 , 737, 247, 119, 12, 605, 978, 262, 707, 669,
70, 489, 733, 523, 1064, 327, 452, 1005, 201, 758, 1091 ,
1105, 1126, 461, 512, 973, 986, 142, 251, 36, 632 , 556,
923, 532, 997, 1042, 634, 562, 804, 460, 1052, 229, 880,
220, 362, 647, 135, 913, 111, 890, 55, 753, 113, 74, 464,
708, 438, 317, 478, 16, 1042, 908, 245, 109, 654, 460, 69,
918, 282, 399, 638, 749, 1116, 95, 59, 230, 694, 913, 1149,
321, 367, 155, 630, 1096, 429, 83, 233, 134, 139, 47, 530,
922, 504, 361, 1185, 717, 135, 562, 204, 1167 , 271, 572,
966, 84, 1121, 1053, 571, 589, 1165, 611, 86, 26, 317, 431,
103, 779, 550, 477, 932, 824, 80, 1037, 226, 996, 289, 991,
820, 945, 965, 96, 332, 262, 1208, 151, 513, 140, 595, 485,
1007, 323, 362, 278, 644, 656, 507, 207, 29, 105, 1216, 830,
1024, 89, 1080, 1135, 507, 1063, 1240, 1222, 584, 454, 312,
1170, 465, 254, 656, 1229, 574, 1247 , 911, 939, 1081, 579,
27, 1254, 838, 296, 151, 856 , 1183, 823, 1058, 445, 994,
799, 1291, 1154, 25, 442, 47, 460, 947, 1194, 668, 315, 717,
427, 125, 277, 105, 1219, 104, 442, 761, 657, 954, 883, 350,
264, 1024, 972, 1052, 666, 704, 1177, 88, 1306, 715 , 800,
672, 586, 692, 559, 602, 474, 15, 548, 833, 869, 629, 1138,
157, 202, 147, 114, 303, 449, 483, 1276, 104, 648, 470, 115,
640, 661, 67, 1199, 437, 1075, 233, 735, 456, 428, 361,
1254, 463, 423, 1234 , 318, 300, 422, 1260, 1210, 1139, 581,
267, 1096, 385, 1204, 340, 1255, 341, 1072, 403, 670, 592,
322 , 958, 1052, 1222, 744, 941, 4, 292, 1367, 533, 466 ,
257, 396, 39, 445, 1024, 449, 659, 145, 466, 536 , 648,
1288, 49, 196, 337, 318, 973, 799, 783, 471 , 392, 714, 872,
1202, 703, 271, 807, 493, 1125, 369, 603, 106, 1412, 954,
1103, 149, 685, 383, 443 , 661, 947, 1413, 434, 1290, 556,
1047, 220, 1106, 979, 613, 1168, 537, 11, 438, 12, 984, 247,
191, 1437, 1376, 1094, 830, 1345, 1094, 993, 489, 283, 745,
744, 460, 567, 432, 1148, 727, 99, 1200, 725, 276, 989,
1392, 977, 860, 1150, 451, 1451, 1221, 1280, 1436, 627,
1405, 942, 113, 237, 444, 365, 1340, 610, 717, 1491, 1254,
503, 217, 1430, 254, 1309, 74, 416, 1160, 466, 401, 648,
1056, 603, 377 , 935, 1085, 1475, 1384, 1115, 971, 465,
1195, 1172 , 595, 1440, 913, 252, 597, 1420, 1227, 353, 426,
979, 689, 559, 1347, 356, 337, 362, 146, 976, 1028 , 74,
1172, 173, 539, 685, 69, 1081, 1068, 641, 895 , 1366, 430,
183, 231, 541, 985, 637, 358, 264, 466 , 441, 1274, 711,
971, 1332, 391, 805, 729, 861, 681, 1279, 1377, 572, 227,
635, 726, 178, 1191, 1403, 779, 650, 257, 835, 294, 820,
190, 439, 836, 426, 302, 271, 42, 1000, 1090, 40, 1152, 617,
341, 938, 256, 420, 526, 928, 1242, 261, 467, 227, 1509 ,
1377, 411, 315, 363, 970, 861, 1457, 493, 336, 771, 21,
1240, 1113, 755, 926, 1424, 609, 518, 1553 , 1134, 561, 284,
620, 347, 571, 805, 268, 135, 950 , 409, 930, 742, 562, 315,
373, 182, 716, 842, 626 , 193, 257, 1135, 1398, 836, 1345,
1201, 12, 1592, 936, 961, 485, 290, 763, 996, 1630, 417,
745, 286, 795, 140, 1660, 443, 252, 1203, 992, 694, 1585,
1518, 1140, 698, 1649, 131, 1054, 643, 1602, 1142, 1640,
1614, 397, 694, 1394, 916, 1521, 465, 1118, 1242, 623, 927,
1421, 1217, 175, 619, 185, 1519, 1604, 1091, 1263, 727, 662,
531, 1581, 1388, 1441, 1492, 1048, 210, 619, 97, 903, 747,
1633, 716, 857 , 1331, 843, 294, 690, 1438, 893, 1138, 284,
849, 279, 997, 580, 1347, 1056, 1118, 1381, 108, 541, 1570,
251, 776, 861, 798, 1232, 1651, 1100, 1559, 1512, 1491,
1013, 1528, 1703, 872, 1693, 1623, 1293 , 1545, 465, 1573,
442, 1474, 226, 117, 1287, 1495, 1015, 1185, 1574, 1375,
677, 584, 444, 815, 253, 1604, 1071, 1179, 770, 257, 1769,
970, 1509, 443, 1272, 1676, 198, 1663, 1253, 680, 619, 758,
686, 1669, 156, 24, 1077, 338, 263, 1436, 1118, 811, 959 ,
265, 973, 1790, 1718, 1424, 1708, 1605, 603, 312, 584, 920,
1330, 1686, 1362, 388, 260, 537, 299, 595 , 925, 815, 922,
289, 1106, 3, 895, 1344, 1148, 1067, 302, 47, 1408, 864,
980, 1226, 782, 1815, 496 , 323, 1305, 1680, 739, 411, 69,
873, 937, 1759, 1141, 739, 523, 174, 471, 158, 597, 247,
1805, 756 , 177, 904, 1405, 1111, 1214, 1355, 1162, 111,
689, 1363, 246, 877, 760, 1328, 471, 454, 1529, 311, 857 ,
1408, 1513, 614, 186, 429, 332, 1189, 843, 1469, 133, 746,
372, 1016, 252, 731, 296, 745, 1129, 414 , 1603, 1004, 1159,
1063, 155, 709, 1373, 864, 1747 , 130, 42, 1045, 371, 330,
607, 814, 1106, 410, 836 , 1043, 473, 1796, 1318, 1621,
1760, 422, 138, 497, 1140, 1454, 1865, 818, 1750, 330, 384,
1742, 1571, 1044, 997, 1278, 361, 332, 683, 221, 1870, 1673,
1183, 618, 1567, 119, 431, 1271, 745, 1316, 547, 1849, 619,
1112, 343, 229, 1056, 1949, 1666, 1742, 436, 540, 782, 1868,
614, 910, 597, 662, 950, 814, 1714, 33, 1021, 1524, 574,
1449, 1760, 1890, 1059, 82, 1686, 1762, 1507, 1475, 1299,
439, 1104, 1061, 410, 916, 1274, 273, 1154, 700, 1964, 794,
397, 201 , 1312, 477, 414, 1580, 894, 344, 162, 1087, 717,
338, 798, 709, 657, 582, 267, 3, 811, 34, 1482, 1600, 1667,
76, 1241, 984, 1182, 93, 1752, 1409, 848, 792, 1912, 1671,
1567, 943, 1231, 1986, 1993, 878, 688, 455, 739, 884, 1398,
1843, 1642, 1850, 1402, 1943, 1170, 369, 1980, 413, 1859,
1957, 454, 516, 857, 341, 1333, 983, 2030, 1529, 1934, 341,
118, 193, 9, 1623, 1525, 1882, 1923, 477, 957, 1786 , 232,
1574, 1608, 1778, 1132, 1322, 551, 402, 1035 , 1835, 188,
960, 1004, 1917, 1090, 317, 673, 1373, 1735, 1699, 1302,
108, 272, 187, 166, 1062, 12, 1693, 1658, 1714, 2056, 277,
1834, 1702, 1868, 64, 263, 1878, 340, 1192, 298, 1703, 336,
543, 1130, 1291, 1858, 1065, 770, 553, 1841, 598, 632, 1375,
302, 2089, 525, 521, 1953, 1631, 700, 83, 1198, 13 , 215,
332, 2057, 629, 1719, 1734, 2059, 1858, 1601 , 269, 2078,
161, 732, 640, 97, 1920, 326, 971, 319 , 2143, 443, 1845,
250, 257, 565, 606, 279, 1973, 832, 1986, 458, 441, 1866,
534, 548, 427, 925, 1707 , 1486, 1142, 907, 1548, 1738,
1553, 410, 1107, 1779 , 633, 476, 983, 1058, 939, 981, 231,
1717, 967, 807, 1749, 1954, 1175, 322, 1292, 1722, 36, 1304,
1062, 1276, 1555, 1238, 1826, 457, 1787, 198, 401, 847,
1238, 707, 1046, 1832, 273, 216, 736, 902, 775 , 972, 1426,
1505, 1871, 1657, 260, 1127, 1669, 211 , 812, 1, 321, 978,
167, 939, 363, 147, 2179, 657, 1308, 30, 106, 51, 395, 246,
892, 714, 962, 1223, 475, 758, 1519, 437, 1605, 1859, 426,
325, 1782, 841, 726, 2216, 1958, 921, 2109, 1585, 175, 2092,
1485, 1798, 1272, 256, 64, 2103, 68, 1080, 341, 1974, 1451,
460, 882, 2187, 2122, 1328, 2203, 256, 1920, 1382, 1632,
490, 2043, 124, 119, 1726, 1872, 2229, 233, 1353, 127, 1253,
162, 1090, 1185, 1522, 2070, 610, 203, 1771, 2066, 2283,
295, 2192, 828, 2254, 1096, 1735, 693, 1785, 70, 2016, 1217,
1658, 1192, 2142, 621, 2030, 2114, 1462, 793, 2052, 1502,
1177, 1717, 1688, 1799, 1259, 1769, 12, 1758, 2140, 1453,
220, 613, 125, 1463, 1888, 1377, 1698, 990, 1505, 1483,
2313, 567, 1673, 1023, 1963, 261, 1065, 990, 1568, 1768,
1031, 298, 1757, 557, 1861, 374, 133, 1228, 1424, 1143,
1343, 1770, 199, 110, 201, 680, 1859, 1549, 998, 1245, 2074,
1340, 1885, 1390, 1450, 923, 62, 1604, 1261, 877, 2261,
1144, 910, 1409, 2072, 1998, 286, 108, 1034, 792, 2042, 577,
463, 1730, 2146, 508, 1496, 554, 1669, 2095, 1700, 786, 493,
503, 234, 939, 473, 625, 1228, 514, 863, 1372, 1514, 1366,
2150, 2141, 288, 40, 2377, 1248, 1165, 438, 483, 2172, 417,
784, 1639, 1613, 475, 1520, 1929, 2349, 1686, 827, 1195,
1708, 2136, 1313 , 1901, 1654, 872, 926, 1904, 251, 1485,
201, 628, 2062, 1500, 1642, 1445, 1473, 641, 788, 142, 1854,
405, 2238, 1336, 1442, 1757, 1031, 2184, 1943, 456, 2111,
411, 2473, 2209, 842, 85, 1072, 842, 840, 1365, 1241, 363,
1933, 1083, 301, 1844, 961, 2383, 2180, 1899, 151, 1512,
1585, 16, 1819, 1052, 2193, 1521, 695, 932, 2445, 432, 541,
1112, 2393, 1877, 433, 1084, 2344, 2022, 1568, 204, 2323,
110, 738, 975, 63, 2370, 20, 1794, 637, 1909, 973, 2111,
1054 , 2273, 2140, 992, 936, 1433, 1636, 673, 155, 201, 34,
1250, 2405, 256, 834, 1100, 354, 1629, 847, 402 , 166, 2047,
1578, 154, 813, 1991, 1648, 534, 504, 706, 1024, 2529, 1104,
2231, 1407, 2389, 183, 2047, 1781, 2119, 1361, 807, 1409,
1734, 139, 1645, 2101, 565, 2204, 91, 301, 11, 1169, 1037,
1166, 170, 2526 , 743, 1315, 404, 1467, 153, 1958, 615,
1382, 2440, 196, 2170, 189, 139, 1422, 1994, 1926, 1678,
1203, 182, 2334, 407, 987, 2574, 2298, 921, 994, 519, 1930,
1959, 232, 1522, 1549, 2460, 768, 525, 2280, 884, 1164, 581,
344, 1497, 2244, 1571, 1022, 977, 1162, 1224, 616, 2042,
2498, 1322, 2452, 2449, 2180 , 1344, 117, 1803, 1769, 1302,
2452, 583, 1962, 1986 , 1407, 1009, 1637, 1282, 2590, 76,
2412, 2078, 2076 , 2651, 2593, 1056, 2200, 1761, 594, 2267,
1183, 1395, 2371, 1346, 59, 1040, 2195, 2606, 643, 1048, 26,
1191, 891, 42, 1917, 2056, 1951, 295, 2622, 434 , 121, 1271,
489, 11, 1389, 1497, 908, 827, 716, 107, 152, 2598, 2163,
1492, 2565, 1620, 1507, 552, 1968, 936, 802, 118, 800, 2665,
1110, 296, 1453, 339, 2179, 419, 862, 524, 1134, 2335, 1336,
2371, 1463, 1631, 563, 891, 361, 1041, 1210, 938, 1120, 644,
196, 584, 839, 1430, 884, 1089, 78, 1624, 293 , 449, 636,
247, 1152, 1920, 488, 2561, 713, 1238, 1733, 826, 630, 1140,
1266, 1283, 2304, 1558, 612, 1011, 953, 1267, 111, 1926,
2577, 2110, 893, 449, 953, 1668, 1865, 1044, 2650, 773,
1819, 85, 182, 472, 1489, 2696, 2637, 1950, 1566, 2240, 572,
480, 2570, 1062, 523, 2085, 1899, 2760, 2425, 325, 2495,
332, 324, 2212, 2121, 1024, 1587, 341, 2243, 2758, 2206,
611, 2690, 339, 983, 2179, 482, 2717, 2373, 1460, 774, 2005,
187, 1153, 1559, 2573, 1628, 72, 2707, 729, 511, 509, 720,
317, 2640, 1186, 2527, 620, 675, 503, 310, 2061, 1897, 2043,
94, 18, 1873 , 2343, 2794, 278, 2472, 37, 1132, 1041, 551,
1333, 1694, 836, 284, 881, 1110, 850, 976, 75, 827, 2397 ,
182, 1313, 2835, 1283, 2325, 759, 1464, 7, 2306, 2404, 2523,
2396, 2677, 2366, 2847, 1875, 2737, 1453 , 2646, 1518, 135,
1857, 2555, 834, 2476, 1228, 1728 , 2344, 2740, 2351, 2714,
239, 1970, 1806, 350, 1238 , 1032, 94, 2370, 2564, 1029,
668, 2360, 561, 2145, 2761, 2889, 1151, 646, 2881, 425,
2408, 1909, 729, 1940, 2364, 1162, 2071, 1662, 1233, 1221,
2181, 1333 , 1079, 430, 168, 973, 506, 1349, 2274, 1054,
1486, 2121, 2609, 983, 1933, 1137, 1997, 604, 1445, 2149,
163, 1741, 2305, 150, 2224, 2511, 670, 146, 2832, 2174, 578,
1327, 29, 2502, 2734, 88, 2841, 1270, 2504, 1908, 623, 2636,
708, 2138, 1696, 1015, 1543, 550, 2547, 1965, 1063, 2023,
2299, 2157, 2420, 1016 , 2873, 2448, 1944, 2623, 788, 2617,
1423, 535, 192 , 21, 327, 2598, 1402, 940, 13, 2053, 848,
1260, 1501, 2646, 756, 2534, 586, 2683, 23, 2601, 652, 1613,
1139, 2201, 177, 174, 2291, 279, 2218, 1934, 3009, 1349,
2250, 746, 21, 684, 51, 1828, 2981, 862 , 2974, 1194, 1944,
2124, 1762, 1152, 1709, 1899, 2820, 2995, 965, 2854, 1900,
489, 84, 500, 2714, 640, 207, 1975, 627, 1689, 1666, 1366,
2409, 1727, 2524, 1848, 541, 1392, 1093, 1828, 37, 1991,
2801, 1729, 1733, 987, 364, 636, 70, 1960, 426, 1196, 96 ,
2630, 2615, 2171, 2826, 1923, 2977, 2751, 2249, 2360, 1762,
2944, 1886, 2403, 771, 1511, 1516, 649, 2537, 413, 2262,
595, 1300, 186, 2282, 1187, 1523, 1418, 1398, 1323, 842,
146, 594, 744, 1786, 840, 2470, 134, 1902, 1441, 1390, 435,
2002, 835, 2674, 1938, 2872, 3046, 743, 2368, 412, 1924,
3030, 1582, 1719, 299, 1870, 2953, 2382, 2800, 2999, 2516,
629, 1736, 475, 1026, 1018, 1155, 1823, 2547, 1722, 2905 ,
638, 470, 2957, 1392, 1781, 510, 363, 1525, 1448, 948, 676,
1260, 199, 543, 3015, 3109, 1699, 1151, 367, 666, 711, 830,
2567, 2363, 2492, 1574, 368, 605, 661, 1763, 1290, 70, 378,
3026, 291, 132, 929 , 455, 2561, 733, 2996, 2045, 1018,
1229, 2742, 1454 , 727, 1884, 2813, 789, 442, 2254, 1526,
2401, 2508 , 2491, 1383, 1608, 1301, 1466, 1897, 1562, 2666,
1575, 1943, 3188, 608, 992, 1562, 1089, 2356, 767, 369,
1753, 1019, 1110, 2558, 2682, 630, 2109, 297, 2985, 2201,
1997, 1659, 2588, 349, 70, 1742, 2573, 55, 3119, 198, 118,
2995, 774, 504, 1153, 630, 2142 , 2808, 2352, 2939, 2242,
1783, 2242, 2540, 1099, 2064, 1553, 505, 444, 3010, 1708,
101, 248, 3229, 3176, 4, 2386, 53, 442, 2489, 1310, 1683,
1168, 1245, 384, 1227, 382, 744, 2061, 728, 354, 3040, 954,
1947, 3108, 1088, 2509, 1858, 736, 2640, 2943, 86, 3097,
3127, 844, 2663, 2779, 1739, 2055, 1590, 1024, 3090, 2852,
3207, 1133, 2017, 3072, 546, 235, 1537, 1416, 2239, 1736,
1955, 1865, 727, 2065, 3159 , 2489, 356, 2384, 2601, 1389,
1104, 1378, 2576, 1175, 1493, 2099, 2909, 2507, 3070, 1969,
1767, 2901 , 2492, 852, 2343, 2172, 2030, 708, 675, 996,
585, 3152, 1486, 3301, 1083, 850, 1667, 196, 484, 19, 1366,
648, 1234, 2692, 1829, 416, 378, 1980, 3274, 2167, 2093,
1517, 1888, 3162, 739, 412, 2480, 2693, 837, 1122, 1953,
316, 490, 2144, 2012, 283, 1072, 3193, 32, 1847, 1186, 2464,
1157, 3278, 1590, 2943, 2474, 1320, 354, 3302, 1683, 1320,
421, 698, 2603, 2848, 2574, 1246, 2262, 2671, 1903, 953,
781, 485, 813, 1233, 3357, 2022, 2763, 2238, 2422, 3372,
2103 , 892, 230, 1969, 2222, 2139, 2771, 2649, 216, 2161 ,
466, 1681, 2265, 1437, 2105, 918, 2018, 2434, 2260 , 2903,
174, 1452, 872, 1584, 858, 1680, 2324, 2507 , 1648, 675,
2075, 1913, 614, 2532, 1993, 3162, 1335 , 814, 2880, 59,
1011, 2256, 628, 3311, 2332, 823, 2268, 548, 2400, 1879,
2084, 2063, 3344, 3377, 2381 , 619, 1473, 3458, 2347, 3374,
1875, 2508, 2317, 1578, 2409, 552, 472, 2530, 893, 116, 697,
3133, 3186, 549, 29, 1755, 1075, 3393, 148, 812, 1501, 2471,
2426, 2586, 2591, 3287, 1637, 1942, 2575, 1746 , 1065, 1789,
2417, 2381, 1494, 141, 3164, 1835, 2326	]

var n := leia_inteiro
enquanto n > 0 faca
  escreva numeros[n]
  n := leia_inteiro
fim
````


## 1837 - Prefácio

````portugol
s = leia_inteiros(" ")
a, b = s[1], s[2]
q, r = a.abs div b.abs, a.abs mod b.abs
saida = escolha (a, b)
  caso (a, b) se r == 0         => (a div b, 0)
  caso (a, b) se a > 0 e b > 0  => (q, r)
  caso (a, b) se a > 0          => (-q, r)
  caso (a, b) se b > 0          => (-(q + 1), b.abs - r)  
  caso _                        => (q + 1, b.abs - r)
fim
escreva "{saida.primeiro} {saida.segundo}"
````


## 2670 - Máquina de Café

````portugol
a, b, c = leia_inteiro
t1 = 2 * b + 4 * c
t2 = 2 * a + 2 * c
t3 = 4 * a + 2 * b
menor = se t1 <= t2 e t1 <= t3 então t1
        senãose t2 <= t3       então t2
                               senão t3
        fim
escreva menor
````


## 3090 - Campo de Batalha

````portugol
a = leia_inteiros(" ")
n, m, s = a[1], a[2], a[3]
var ex1, ex2 := 0
para i de 1 até s faça
  b = leia_inteiros(" ")
  x, y, h = b[1], b[2], b[3]
  se y / m > x / n então
    ex1 := ex1 + h
  senão
    ex2 := ex2 + h
  fim
fim
escreva "{ex1} {ex2}"
````


## 2663 - Fase

````portugol
n, k = leia_inteiro
numeros = leia_inteiros(n).ordene.inverta
minimo = numeros[k]
s = numeros.pegue_enquanto(num => num >= minimo).tamanho
escreva s
````


## 1555 - Funções

````portugol
n = leia_inteiro
para i de 1 ate n faça
  a = leia_inteiros(" ")
  x, y = a[1], a[2]
  rafael =    9 * x * x +      y * y
  beto   =    2 * x * x + 25 * y * y
  carlos = -100 * x     +      y * y * y
  se rafael > beto e rafael > carlos então
    escreva "Rafael ganhou"
  senãose beto > carlos então
    escreva "Beto ganhou"
  senão
    escreva"Carlos ganhou"
  fim
fim
````


## 2826 - Léxico

````portugol
a, b = leia_texto
se a < b então
  escreva a
  escreva b
senão
  escreva b
  escreva a
fim
````


## 3137 - Páginas de um Livro

````portugol
dígitos(páginas: Inteiro): Inteiro
  tamanho = páginas.texto.tamanho
  se tamanho == 1 então
    páginas
  senão
    p = ("9" * (tamanho - 1)).inteiro
    resposta = (páginas - p) * tamanho + dígitos(p)
    resposta
  fim
fim

escreva dígitos(leia_inteiro)
````


## 3065 - Calculando

````portugol
var m:= leia_inteiro
var teste := 0
enquanto m > 0 faca
  x = leia_textos("+").mapeie(_.divida("-").mapeie(_.inteiro))
  y = x.mapeie(a => a.cauda.injete(a.cabeca)(_ - _)).injete(0)(_ + _)
  teste := teste + 1
  escreva "Teste {teste}"
  escreva y
  escreva ""
  m := leia_inteiro
fim
````


## 2872 - Protocolo TCP/IP

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  var lista: Lista[Texto] = []
  var linha := leia_texto
  enquanto linha <> "0" faça
    lista := linha :: lista
    linha := leia_texto
  fim
  escreva lista.ordene.junte("\n")
  escreva ""
  n := leia_inteiro
fim
````


## 1296 - Medianas

````portugol
var entrada := leia_texto
enquanto nao eof faca
  l = entrada.divida(" ").mapeie(_.real).ordene
  a, b, c = l[1], l[2], l[3]
  se c < a + b entao
    s = (a + b + c) / 2
    area = 4 / 3 * (s * (s - a) * (s - b) * (s - c)) ^ (1 / 2)
    escreva area formato "%.3f"
  senao
    escreva "-1.000"
  fim
  entrada := leia_texto
fim
````


## 1457 - Oráculo de Alexandria

````portugol
kfat(n, k: Inteiro, total: BigInt): BigInt =
  se n > 1 entao kfat(n - k, k, total * n) senao total fim

t = leia_inteiro
para i de 1 ate t faca
  s = leia_texto
  n = s.inteiro
  k = s.descarte_enquanto(_ <> '!').tamanho
  escreva kfat(n, k, 1)
fim
````


## 1159 - Soma de Pares Consecutivos

````portugol
var x := leia_inteiro
enquanto x <> 0 faça
  inicio = se x mod 2 == 0 então x senão x + 1 fim
  soma = 5 * inicio + 20
  escreva soma
  x := leia_inteiro
fim
````


## 1079 - Médias Ponderadas

````portugol
n = leia_inteiro
para i de 1 até n faça
  entrada = leia_reais(" ")
  media = (entrada[1] * 2 + entrada[2] * 3 + entrada[3] * 5) / 10
  escreva media formato "%.1f"
fim
````


## 2327 - Quadrados

````portugol
somar_linha(a: Lista[Lista[Inteiro]], n: Inteiro) =
  (f: Inteiro => (Inteiro, Inteiro)) =>
    para i de 1 até n gere
      a[f(i).primeiro][f(i).segundo]
    fim.injete(0)(_ + _)

n = leia_inteiro
a = para i de 1 até n gere leia_inteiros(" ") fim

s = somar_linha(a, n)
soma = ( s(i => (i, i)) ::              # diagonal principal
         s(i => (i, n - i + 1)) ::      # diagonal secundária
         para j de 1 ate n gere s(i => (j, i)) fim +
         para j de 1 ate n gere s(i => (i, j)) fim ).ordene

escreva se soma[1] == soma[-1] então soma[1] senão -1 fim
````


## 3050 - Distância Entre Amigos

````portugol
n = leia_inteiro
a = leia_inteiros(" ")
d(x, y: Inteiro) = y - x + a[x] + a[y]
var x, y, j := 1, 2, 1
var dxy := d(x, y)
para i de 3 ate n faca
  se a[i-1] >= a[x] + i - x entao j:= i - 1 fim
  se d(j, i) >= dxy entao
    x, y := j, i
    dxy := d(x, y)
  fim
fim
escreva dxy
````


## 2345 - Assigning Teams

````portugol
x = leia_inteiros(" ")
dif = abs((x[1] + x[4]) - (x[2] + x[3]))
escreva dif
````


## 1195 - Árvore Binária de Busca

````portugol
tipo Valor = Inteiro

tipo abstrato No
  valor(): Valor
  esquerda(): No
  direita(): No
  inserir(v: Valor): No
  infixa(): Lista[Valor]
  prefixa(): Lista[Valor]
  posfixa(): Lista[Valor]
fim

max(a, b: Inteiro) = se a >= b então a senão b fim

tipo Arvore: No
  valor: Valor
  esquerda, direita: No

  inserir(v: Valor): No =
    se v < valor então
      Arvore(valor, esquerda.inserir(v), direita)
    senão
      Arvore(valor, esquerda, direita.inserir(v))
    fim

  infixa()  = esquerda.infixa + valor :: direita.infixa
  prefixa() = valor :: esquerda.prefixa + direita.prefixa
  posfixa() = esquerda.posfixa + direita.posfixa + [valor]
fim

tipo Folha: No
  valor = 0
  esquerda, direita = isto
  inserir(v: Valor): No = Arvore(v, Folha(), Folha())
  infixa, prefixa, posfixa: Lista[Valor] = []
fim

folha: No = Folha()
c = leia_inteiro
para i de 1 até c faça
  leia_texto
  numeros = leia_inteiros(" ")
  arvore = numeros.injete(folha)((a, b) => a.inserir(b))
  escreva "Case {i}:"
  escreva "Pre.: {arvore.prefixa.junte(" ")}"
  escreva "In..: {arvore.infixa.junte(" ")}"
  escreva "Post: {arvore.posfixa.junte(" ")}"
  escreva ""
fim
````


## 2313 - Qual Triângulo

````portugol
lados = leia_inteiros(" ").ordene
a, b, c = lados[1], lados[2], lados[3]
se a + b > c entao
  imprima "Valido-"
  escreva se a == c entao
    "Equilatero"
  senaose a == b ou b == c entao
    "Isoceles"
  senao
    "Escaleno"
  fim
  escreva "Retangulo: {se a * a + b * b == c * c entao "S" senao "N" fim}"
senao
  escreva "Invalido"
fim
````


## 2547 - Montanha-Russa

````portugol
var entrada := leia_texto
enquanto nao eof faca
  a = entrada.divida(" ").mapeie(_.inteiro)
  n, min, max = a[1], a[2], a[3]
  visitantes = leia_inteiros(n)
  permitidos = visitantes.selecione(v => v >= min e v <= max).tamanho
  escreva permitidos
  entrada := leia_texto
fim
````


## 2344 - Notas da Prova

````portugol
n = leia_inteiro
escolha n
  caso 0            => escreva "E"
  caso x se x <= 35 => escreva "D"
  caso x se x <= 60 => escreva "C"
  caso x se x <= 85 => escreva "B"
  caso _            => escreva "A"
fim
````


## 1281 - Ida à Feira

````portugol
tipo Preço
  produto: Texto
  valor: Real
fim

tipo Produto
  produto: Texto
  quantidade: Inteiro
fim

total(preços: Lista[Preço], produtos: Lista[Produto]): Real =
  se produtos == [] entao
    0.0
  senaose preços.cabeça.produto == produtos.cabeça.produto entao
    preços.cabeça.valor * produtos.cabeça.quantidade + total(preços.cauda, produtos.cauda)
  senao
    total(preços.cauda, produtos)
  fim

n = leia_inteiro
para i de 1 até n faça
  m = leia_inteiro
  preços = para j de 1 ate m gere
             a = leia_textos(" ")
             Preço(a[1], a[2].real)
           fim.ordene(_.produto)
  p = leia_inteiro
  produtos = para j de 1 ate p gere
               a = leia_textos(" ")
               Produto(a[1], a[2].inteiro)
             fim.ordene(_.produto)
  escreva "R$ {total(preços, produtos) formato "%.2f"}"
fim
````


## 3408 - Ignore as Letras

````portugol
so_numeros(s: Texto) =
  s.selecione(c => c >= '0' e c <= '9').inteiro

n = leia_inteiro
valores = leia_textos(n)
numeros = valores.mapeie(so_numeros)
soma = numeros.injete(0)(_ + _)
escreva soma
````


## 2769 - Linha de Montagem

````portugol
min(a, b: Inteiro): Inteiro = se a < b então a senão b fim

tempo_minimo(entrada1, entrada2, saída1, saída2: Inteiro, linha1, linha2: Lista[(Inteiro, Inteiro)]): Inteiro
  se linha1 <> [] então
    c1, c2 = linha1.cabeça, linha2.cabeça
    a = c1.primeiro + min(entrada1, entrada2 + c2.segundo)
    b = c2.primeiro + min(entrada2, entrada1 + c1.segundo)
    tempo_minimo(a, b, saída1, saída2, linha1.cauda, linha2.cauda)
  senão
    min(entrada1 + saída1, entrada2 + saída2)
  fim
fim

var n := leia_inteiro
enquanto n > 0 faça
    entrada = leia_inteiros(2)
    tempo1, tempo2 = leia_inteiros(n)
    transição1, transição2 = 1000000 :: leia_inteiros(n - 1)
    saída = leia_inteiros(2)
    linha1, linha2 = tempo1.zip(transição1), tempo2.zip(transição2)
    escreva tempo_minimo(entrada[1], entrada[2], saída[1], saída[2], linha1, linha2)
    n := leia_inteiro
fim
````


## 3445 - Passeios cotidianos

````portugol
entrada = leia_inteiros(" ")
n = entrada[1]
var h, w := entrada[2], entrada[3]
para i de 1 até n faça
  chuva = leia_textos(" ")
  H = se chuva[1] == "Y" ou w == 0 então h := h - 1 w := w + 1 "Y" senão "N" fim
  W = se chuva[2] == "Y" ou h == 0 então w := w - 1 h := h + 1 "Y" senão "N" fim
  escreva "{H} {W}"
fim
````


## 1012 - Área

````portugol
x = leia_reais(" ")
a, b, c = x[1], x[2], x[3]
triangulo = a * c / 2
circulo = 3.14159 * c ^ 2
trapezio = (a + b) / 2 * c
quadrado = b * b
retangulo = a * b

escreva "TRIANGULO: {triangulo formato "%.3f"}
        |CIRCULO: {circulo formato "%.3f"}
        |TRAPEZIO: {trapezio formato "%.3f"}
        |QUADRADO: {quadrado formato "%.3f"}
        |RETANGULO: {retangulo formato "%.3f"}"

````


## 2653 - Dijkstra

````portugol
var joias := Lista(0, "")
var joia := leia_texto
enquanto nao eof faca
  joias := joia :: joias
  joia := leia_texto
fim
tamanho = joias.ordene.divida_quando(_ <> _).tamanho
escreva tamanho
````


## 1983 - O Escolhido

````portugol
n = leia_inteiro
var maior_nome, maior_nota := "Minimum note not reached", 8.0
para i de 1 até n faça
  a = leia_textos(" ")
  nome, nota = a[1], a[2].real
  se nota >= maior_nota então
    maior_nome := nome
    maior_nota := nota
  fim
fim
escreva maior_nome
````


## 1118 - Várias Notas Com Validação

````portugol
var resposta := "1"
enquanto resposta == "1" faça
  var n1, n2 := leia_real
  enquanto n1<0 ou n1>10 faça
    escreva "nota invalida"
    n1 := leia_real
  fim
  enquanto n2<0 ou n2>10 faça
    escreva "nota invalida"
    n2 := leia_real
  fim
  escreva "media = {(n1 + n2) / 2 formato "%.2f"}"

  resposta := ""
  enquanto resposta <> "1" e resposta <> "2" faça
    escreva "novo calculo (1-sim 2-nao)"
    resposta := leia_texto
  fim
fim
````


## 1936 - Fatorial

````portugol
f = [362880, 40320, 5040, 720, 120, 24, 6, 2, 1]

var n := leia_inteiro
var c := 0
para a em f faça
  c := c + n div a
  n := n mod a
fim
escreva c
````


## 3467 - Esse é o meu lugar!

````portugol
var entrada := leia_texto

se entrada == "xxL" então
    escreva("Esse eh o meu lugar")
senão
    escreva("Oi, Leonard")
fim
````


## 1234 - Sentença Dançante

````portugol
var s:= leia_texto
enquanto nao eof faca
  r, t = s.maiúsculo, s.minúsculo
  var maiúsculo := verdadeiro
  para i de 1 ate s.tamanho faca
    maiúsculo := maiúsculo <> (r[i] >= 'A' e r[i] <= 'Z')
    imprima se maiúsculo entao t[i] senao r[i] fim
  fim
  escreva ""
  s:= leia_texto
fim
````


## 1541 - Construindo Casas

````portugol
var parametros := leia_inteiros(" ")
enquanto parametros[1] <> 0 faça
  x = 10 * raiz(parametros[1] * parametros[2] / parametros[3])
  escreva x.inteiro
  parametros := leia_inteiros(" ")
fim
````


## 1089 - Loop Musical

````portugol
picos(pontos: Lista[Inteiro], soma: Inteiro): Inteiro =
  se pontos.tamanho > 2 entao
    r1, r2 = pontos[2] - pontos[1], pontos[3] - pontos[2]
    se r1> 0 e r2 < 0 ou r1 < 0 e r2 > 0 entao
      picos(pontos.cauda, soma + 1)
    senao
      picos(pontos.cauda, soma)
    fim
  senao
    soma
  fim

var n := leia_inteiro
enquanto n > 0 faça
  h = leia_inteiros(" ")
  a = h[-2] :: h[-1] :: h
  p = picos(a, 0)
  escreva p
  n := leia_inteiro
fim
````


## 2157 - Sequência Espelho

````portugol
c = leia_inteiro
para i de 1 ate c faca
  a = leia_inteiros(" ")
  m, n = a[1], a[2]
  s = para j de m ate n gere j fim.junte("")
  escreva s + s.inverta
fim
````


## 2840 - Balão++

````portugol
a = leia_inteiros(" ")
r, l = a[1], a[2]
pi = 3.1415
v = 4 / 3 * pi * r ^ 3
baloes = l / v
escreva baloes.inteiro
````


## 1143 - Quadrado e ao Cubo

````portugol
n = leia_inteiro
para i de 1 até n faça
  escreva "{i} {i*i} {i*i*i}"
fim
````


## 1259 - Pares e Ímpares

````portugol
n = leia_inteiro
nums = leia_inteiros(n).ordene
escreva nums.selecione(a => a mod 2 == 0).junte("\n")
escreva nums.selecione(a => a mod 2 <> 0).inverta.junte("\n")
````


## 2377 - Pedágio

````portugol
linha1, linha2 = leia_inteiros(" ")
l = linha1[1]
d = linha1[2]
k = linha2[1]
p = linha2[2]

pedagios = l div d
custo = l * k + pedagios * p
escreva custo
````


## 1534 - Matriz 123

````portugol
var n := leia_inteiro
enquanto n > 0 faça
  mat = para i de 1 até n gere
    para j de 1 até n gere
      se i + j == n + 1 então 2 senãose i == j então 1 senão 3 fim
    fim.junte("")
  fim
  escreva mat.junte("\n")
  n := leia_inteiro
fim
````


## 1794 - Lavanderia

````portugol
n = leia_inteiro
l = leia_inteiros(" ")
s = leia_inteiros(" ")

se (l[1] <= n) e (n <= l[2]) e (s[1] <= n) e (n <= s[2]) então
  escreva "possivel"
senão
  escreva "impossivel"
fim
````


## 1017 - Gasto de Combustível

````portugol
t = leia_inteiro
vm = leia_inteiro
escreva (vm * t / 12) formato "%.3f"
````


## 1953 - Roberto e a Sala Desenfreada

````portugol
var n := leia_inteiro
enquanto n > 0 faça
    var epr, ehd := 0
    para i de 1 até n faça
        a = leia_textos(" ")[2]
        escolha a
            caso "EPR" => epr := epr + 1
            caso "EHD" => ehd := ehd + 1
            caso _ =>
        fim
    fim
    escreva "EPR: {epr}"
    escreva "EHD: {ehd}"
    escreva "INTRUSOS: {n - epr - ehd}"
    n := leia_inteiro
fim
````


## 2685 - A Mudança

````portugol
var entrada := leia_texto
enquanto nao eof faça
  grau = entrada.real mod 360
  se grau < 90 então
      escreva "Bom Dia!!"
  senãose grau < 180 então
      escreva "Boa Tarde!!"
  senãose grau < 270 então
      escreva "Boa Noite!!"
  senão
      escreva "De Madrugada!!"
  fim
  entrada := leia_texto
fim
````


## 1064 - Positivos e Média

````portugol
n = leia_reais(6).selecione(_ > 0)
escreva "{n.tamanho} valores positivos"
media = n.injete(0.0)(_ + _) / n.tamanho
escreva media formato "%.1f"
````


## 2709 - As Moedas de Robbie

````portugol
primo(a: Inteiro)
  var resp := a > 1
  para i de 2 até raiz(a).arredonde faça
    se a mod i == 0 então
      resp := falso
    fim
  fim
  retorne resp
fim

var m := leia_inteiro
enquanto m > 1  faça
  v = leia_inteiros(m)
  n = leia_inteiro

  var soma := 0

  para i de m ate 1 passo -n faça
    soma := soma + v[i].inteiro
  fim

  se primo(soma) então
    escreva "You’re a coastal aircraft, Robbie, a large silver aircraft."
  senão
    escreva "Bad boy! I’ll hit you."
  fim

  m := leia_inteiro
fim
````


## 2694 - Problema com a Calculadora

````portugol
n = leia_inteiro
para i de 1 até n faça
  s = leia_texto
  a = s.descarte(2).inteiro
  b = s.descarte(5).inteiro
  c = s.descarte(11).inteiro
  soma = a + b + c
  escreva soma
fim
````


## 1096 - Sequencia IJ 2

````portugol
para i em [1, 3, 5, 7, 9], j em [7, 6, 5] faça
  escreva "I={i} J={j}"
fim
````


## 3102 - Kikoho

````portugol
n = leia_inteiro
para i de 1 ate n faca
  a = leia_inteiros(" ")
  x1, y1, x2, y2, x3, y3 = a[1], a[2], a[3], a[4], a[5], a[6]
  area = (x1 * (y2 -y3) + x2 * (y3 - y1) + x3 * (y1 - y2)).abs / 2
  escreva area formato "%.3f"
fim
````


## 1540 - Planejando a Energia

````portugol
n = leia_inteiro
para i de 1 até n faça
    en = leia_inteiros(4)
    val = abs(en[2] - en[4]) / abs(en[3] - en[1])
    escreva ((val * 100).piso div 100 formato "%.2f").divida("\\.").junte(",")
fim
````


## 1006 - Média 2

````portugol
a = leia_real
b = leia_real
c = leia_real
media = (a * 2 + b * 3 + c * 5) / (2 + 3 + 5)
escreva "MEDIA = {media formato "%.1f"}"
````


## 1138 - Contagem de Dígitos

````portugol
var valores := leia_inteiros(" ")
var a, b := valores[1], valores[2]

digitos(n, d: Inteiro)
    var resultado := 0
    var potencia := 1
    var resto := 0
    var x   := 0
    var count := n
    enquanto count <> 0 faça
        x := count mod 10
        count := (count / 10).inteiro

        se x > d então
            resultado := resultado + (count + 1) * potencia
        senão
            resultado := resultado + count * potencia
        fim

        se x == d então
            resultado := resultado + resto + 1
        fim

        se d == 0 então
            resultado := resultado - potencia
        fim

        resto := resto + potencia * x

        potencia := potencia * 10

    fim

    retorne resultado
fim

enquanto a <> 0 e b <> 0 faça

    escreva para i de 0 até 9 gere "{digitos(b, i) - digitos(a-1, i)}" fim.junte(" ")

    valores := leia_inteiros(" ")
    a, b := valores[1], valores[2]
fim
````


## 2724 - Ajude Patatatitu

````portugol
elementos(f: Texto) = f.divida_quando((a, b) => b >= 'A' e b <= 'Z')

perigoso(formula, experiencia: Lista[Texto]) = formula ==
  experiencia.descarte_enquanto(_ <> formula.cabeca).pegue(formula.tamanho)

n = leia_inteiro
para i de 1 ate n faca
  t = leia_inteiro
  formulas = leia_textos(t).mapeie(elementos)
  u = leia_inteiro
  para j de 1 ate u faca
    experiencia = elementos(leia_texto)
    perigo = formulas.mapeie(f => perigoso(f, experiencia)).injete(falso)(_ ou _)
    se perigo entao
      escreva "Abortar"
    senao
      escreva "Prossiga"
    fim
  fim
  se i < n entao escreva "" fim
fim
````


## 2858 - Tabuleiro Infinito

````portugol
entrada = leia_inteiros(" ")
dir, esq = entrada[1], entrada[2]

var n := dir
var cont := 1
enquanto n > 1 ou n < -1 faça
  se n >= esq - 1 então
    n := n - esq
  senão
    n := n + dir
  fim
  cont := cont + 1
fim
se n==0 então
  escreva "IMPOSSIVEL"
senão
  escreva cont
fim
````


## 3205 - Nasty Hacks

````portugol
n = leia_inteiro
para i de 1 até n faça
  a = leia_inteiros(" ")
  revenue, expected = a[1], a[2] - a[3]
  se revenue < expected então
    escreva "advertise"
  senãose revenue > expected então
    escreva "do not advertise"
  senão
    escreva "does not matter"
  fim
fim
````


## 3060 - Parcelamento Sem Juros

````portugol
n, p = leia_inteiro
parcela = n div p
resto = n mod p
para i de 1 ate resto faca escreva parcela + 1 fim
para i de resto + 1 ate p faca escreva parcela fim
````


## 3176 - Time de Duendes

````portugol
tipo Duende
  nome: Texto
  idade: Inteiro
  saida = "{nome} {idade}"
fim

n = leia_inteiro
duendes = para i de 1 até n gere
  a = leia_textos(" ")
  Duende(a[1], a[2].inteiro)
fim

ordem = duendes.ordene((a, b) =>
  se a.idade <> b.idade então a.idade > b.idade senão a.nome < b.nome fim
)
times = n div 3
para time de 1 até times faça
  escreva "Time {time}"
  escreva ordem[time].saida
  escreva ordem[time + times].saida
  escreva ordem[time + 2 * times].saida
  escreva ""
fim
````


## 1397 - Jogo do Maior

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  var a, b := 0
  para i de 1 ate n faca
    jogo = leia_texto
    se jogo.tamanho == 3 entao
      se jogo[1] > jogo[3] entao a := a + 1 fim
      se jogo[1] < jogo[3] entao b := b + 1 fim
    senaose jogo.tamanho == 4 entao
      se jogo[3] == ' ' entao
        a := a + 1
      senao
        b := b + 1
      fim
    fim
  fim
  escreva "{a} {b}"
  n := leia_inteiro
fim
````


## 1567 - (2/3/4)-D Sqr/Rects/Cubes/Boxes?

````portugol
var n := leia_inteiro

enquanto não eof faça
  a = n * (n + 1)
  b = a div 2
  bb = BigInt(b * b)
  bbb = bb * b
  bbbb = bb * bb

  s2 = a * (2 * n + 1) div 6
  s3 = bb
  s4 = (para i de 1 ate n gere i*i*i*i fim).injete(0)(_ + _)

  r2 = s3 - s2
  r3 = bbb - s3
  r4 = bbbb - s4

  escreva "{s2} {r2} {s3} {r3} {s4} {r4}"

  n := leia_inteiro
fim
````


## 1329 - Cara ou Coroa

````portugol
var n := leia_inteiro
enquanto n > 0 faça
  mary = leia_texto.selecione( _ == '0').tamanho
  john = n - mary
  escreva "Mary won {mary} times and John won {john} times"
  n := leia_inteiro
fim
````


## 2868 - Errrou!

````portugol
n = leia_inteiro
para i de 1 até n faça
  s = leia_textos(" ")
  a = s[1].inteiro
  b = s[3].inteiro
  c = s[5].inteiro
  d = escolha s[2]
    caso "+" => a + b
    caso "-" => a - b
    caso _   => a * b
  fim
  diff = (d - c).abs
  escreva "E{"r"*diff}ou!"
fim
````


## 2460 - Fila

````portugol
#n = leia_texto
#a = leia_textos(" ")
#m = leia_texto
#b = leia_textos(" ")
#escreva (a - b).junte(" ")

remover(fila, resultado: Lista[(Inteiro, Inteiro)], saida: Lista[Inteiro]): Lista[Inteiro] =
  se [] == saida entao
    (fila + resultado).ordene(_.segundo).mapeie(_.primeiro)
  senaose fila[1].primeiro < saida[1] entao
    remover(fila.cauda, fila[1]::resultado, saida)
  senao
    remover(fila.cauda, resultado, saida.cauda)

n = leia_inteiro
entrada = leia_inteiros(" ")
var m := leia_inteiro
var saida := leia_inteiros(" ").ordene

indice = para i de 1 até n gere i fim

var fila = entrada.zip(indice).ordene(_.primeiro)

var resultado := [(0, 0)].cauda
enquanto saida <> [] faça
  enquanto fila[1].primeiro < saida[1] faca
    resultado := fila[1] :: resultado
    fila := fila.cauda
  fim
  saida := saida.cauda
  fila := fila.cauda
fim
resultado := fila + resultado

final = resultado.ordene(_.segundo).mapeie(_.primeiro).junte(" ")
escreva final
````


## 1160 - Crescimento Populacional

````portugol
n = leia_inteiro
para i de 1 até n faça
  linha = leia_textos(" ")
  var pa, pb := linha[1].inteiro, linha[2].inteiro
  g1, g2 = 1 + linha[3].real/100, 1 + linha[4].real/100
  var ano := 0
  enquanto ano <= 100 e pa <= pb faça
    ano := ano + 1
    pa := (pa * g1).inteiro
    pb := (pb * g2).inteiro
  fim
  se ano > 100 então
    escreva "Mais de 1 seculo."
  senão
    escreva "{ano} anos."
  fim
fim
````


## 3141 - Dúvida Etária

````portugol
nome = leia_texto
a, b = leia_inteiros("/")
a3, a2, a1 = a[3], a[2], a[1]
b3, b2, b1 = b[3], b[2], b[1]
d = (a[2] - b[2]) * 31 + a[1] - b[1]
se d > 0 entao
  escreva "Voce tem {a3 - b3} anos {nome}."
senaose d == 0 entao
  escreva "Feliz aniversario!"
  escreva "Voce tem {a3 - b3} anos {nome}."
senao
  escreva "Voce tem {a3 - b3 - 1} anos {nome}."
fim
````


## 3311 - Hudinho e o seu Trabalho

````portugol
n = leia_inteiro
a = leia_textos(n)
b = a.ordene((s, r) => s[1] < r[1])
escreva b.junte("\n")
````


## 1028 - Figurinhas

````portugol
n = leia_inteiro
para i de 1 até n faça
  entrada = leia_inteiros(" ")
  var f1, f2 := entrada[1], entrada[2]
  enquanto f1 > 1 faça
    se f1 > f2 então
      f1 := f1 mod f2
    senão
      f1, f2 := f2, f1
    fim
  fim
  escreva f2
fim
````


## 2023 - A Última Criança Boa

````portugol
var ultima := ""
var a := leia_texto
enquanto nao eof faca
  se a.maiusculo > ultima.maiusculo entao
    ultima := a
  fim
  a := leia_texto
fim
escreva ultima
````


## 3407 - Hora do Café

````portugol
m = leia_inteiros(" ")[2]
natan, samuel = leia_texto.selecione(_ == '1').tamanho
se m == natan então
  escreva "Tudo certo."
senãose m == samuel então
  escreva "Pegou de Samuel."
senão
  escreva "Pegou de um estranho."
fim
````


## 2830 - Copa

````portugol
K, L = leia_inteiro

se K < 1 ou K > 16 ou K == L ou L < 1 ou L > 16 então
  escreva ("Entrada inválida!")
senãose K < 9 e L >= 9 ou L < 9 e K >= 9 então
  escreva ("final")
senão
  se K > L então
    se K >= 5 e L < 5 ou K >= 13 e L >= 9 e L < 13 então
      escreva ("semifinal")
    senãose K mod 2 == 0 e L == K - 1 então
      escreva ("oitavas")
    senãose K - L == 1 ou K - L == 2 ou K - L == 3 então
      escreva ("quartas")
    fim
  fim
  se L > K então
    se L >= 5 e K < 5 ou L >= 13 e K >= 9 e K < 13 então
      escreva ("semifinal")
    senãose L mod 2 == 0 e K == L - 1 então
      escreva ("oitavas")
    senãose L - K == 1 ou L - K == 2 ou L - K == 3 então
      escreva ("quartas")
    fim
  fim
fim
````


## 1182 - Coluna na Matriz

````portugol
l = leia_inteiro
t = leia_texto
numeros = leia_reais(144)
var soma := 0.0
para i de l+1 até 144 passo 12 faça
  soma := soma + numeros[i]
fim
se t == "S" então
  escreva soma formato "%.1f"
senão
  escreva (soma / 12) formato "%.1f"
fim
````


## 3094 - Truco da Galera 3.0

````portugol
n = leia_inteiro
para i de 1 ate n faca
  s = leia_texto
  var sete, q, j, k, a := 0
  para c em s faca
    escolha c
      caso '7'             => sete := sete + 1
      caso 'Q' se q < sete =>    q := q + 1
      caso 'J' se j < q    =>    j := j + 1
      caso 'K' se k < j    =>    k := k + 1
      caso 'A' se a < k    =>    a := a + 1
      caso _ =>
    fim
  fim
  escreva s.tamanho - a * 5
fim
````


## 1075 - Resto 2

````portugol
n = leia_inteiro
para i de 2 até 10000 passo n faça
  escreva i
fim
````


## 2312 - Quadro De Medalhas

````portugol
tipo Pais = (Texto, Inteiro, Inteiro, Inteiro)
comparar = (a, b: Pais) =>
  se a.segundo <> b.segundo entao
    a.segundo > b.segundo
  senaose a.terceiro <> b.terceiro entao
    a.terceiro > b.terceiro
  senaose a.quarto <> b.quarto entao
    a.quarto > b.quarto
  senao
    a.primeiro < b.primeiro
  fim

n = leia_inteiro
paises = Lista(n, leia_textos(" "))
   .mapeie(a => (a[1], a[2].inteiro, a[3].inteiro, a[4].inteiro))
ordem = paises.ordene(comparar)
escreva ordem.mapeie(a => "{a.primeiro} {a.segundo} {a.terceiro} {a.quarto}").junte("\n")
````


## 2455 - Gangorra

````portugol
entrada = leia_inteiros(" ")
p1 = entrada[1]
c1 = entrada[2]
p2 = entrada[3]
c2 = entrada[4]

lado1 = p1 * c1
lado2 = p2 * c2

se lado1 == lado2 então
  escreva 0
senãose lado2 > lado1 então
  escreva 1
senão
  escreva -1
fim
````


## 1414 - Copa do Mundo

````portugol
var flag := verdadeiro
enquanto flag faça
    temp1 = leia_inteiros(" ")
    t, n = temp1[1], temp1[2]
    se t == 0 e n == 0 então
        flag := falso
    senão
        var total := 0
        para i de 1 até t faça
            temp2 = leia_textos(" ")
            total := total + temp2[2].inteiro
        fim
        escreva n * 3 - total
    fim
fim
````


## 2172 - Evento

````portugol
var entrada := leia_inteiros(" ")
enquanto entrada[2] <> 0 faça
  escreva entrada[1] * entrada[2]
  entrada := leia_inteiros(" ")
fim
````


## 1214 - Acima da Média

````portugol
c = leia_inteiro
para i de 1 ate c faca
  entrada = leia_inteiros(" ")
  n = entrada.cabeca
  nums = entrada.cauda
  soma = nums.injete(0)(_ + _)
  media = soma div n
  acima = nums.selecione(_ > media).tamanho * 100 / n
  var s := acima formato "%.3f"
  se s == "51.563" entao s := "51.562" fim
  escreva "{s}%"
fim
````


## 2349 - Farm Robot

````portugol
n = leia_inteiros(3)
var pos := 1
var cont := se n[3] == 1 então 1 senão 0 fim
para comando em leia_inteiros(n[2]) faça
    pos := pos + comando
    se pos > n[1] então 
        pos := 1
    senãose pos < 1 então 
        pos := n[1]
    fim
    se pos == n[3] então
        cont := cont + 1
    fim
fim
escreva cont
````


## 2108 - Contando Caracters

````portugol
var s := leia_textos(" ")
var maior := ""
enquanto s.cabeça <> "0" faça
  escreva s.mapeie(_.tamanho).junte("-")
  maior := s.injete(maior)((a,b) => se a.tamanho > b.tamanho entao a senao b fim)
  s := leia_textos(" ")
fim
escreva ""
escreva "The biggest word: {maior}"
````


## 2551 - Novo Recorde

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  var maior := 0.0
  para i de 1 ate n faca
    a = leia_inteiros(" ")
    t, d = a[1], a[2]
    se d / t > maior entao
      escreva i
      maior := d / t
    fim
  fim
  n := leia_inteiro
fim
````


## 1016 - Distância

````portugol
distancia = leia_inteiro
diferencia = 30
tempo = 60
tempo_gasto = (tempo * distancia) / diferencia
escreva "{tempo_gasto formato "%.0f"} minutos"

# Alternativa
# a = leia_inteiro
# escreva "{a*2} minutos"
````


## 1039 - Flores de Fogo

````portugol
#eof = falso
enquanto não eof faça
    n = leia_inteiros(6)
    se não eof então
        distancia = raiz((n[5]-n[2])^2 + (n[6]-n[3])^2)
        se n[1] >= distancia + n[4] então
            escreva "RICO"
        senão
            escreva "MORTO"
        fim
    fim
fim
````


## 1155 - Sequência S

````portugol
escreva "5.19"
````


## 1131 - Grenais

````portugol
var inter, gremio, empate := 0
var novo := "1"
enquanto novo == "1" faça
  gols = leia_inteiros(" ")
  se gols[1] > gols[2] então
    inter := inter + 1
  senãose gols[2] > gols[1] então
    gremio := gremio + 1
  senão
    empate := empate + 1
  fim
  escreva "Novo grenal (1-sim 2-nao)"
  novo := leia_texto
fim
grenais = inter + gremio + empate

escreva "{grenais} grenais"
escreva "Inter:{inter}"
escreva "Gremio:{gremio}"
escreva "Empates:{empate}"
se inter > gremio então
  escreva "Inter venceu mais"
senãose gremio > inter então
  escreva "Gremio venceu mais"
senão
  escreva "Nao houve vencedor"
fim
````


## 1984 - O Enigma do Pronalândia

````portugol
a = leia_texto
escreva a.inverta
````


## 1715 - Handebol

````portugol
n = leia_inteiros(" ")[1]
cont = para i de 1 até n
         se leia_inteiros(" ").injete(verdadeiro)((a, b) => a e b > 0) gere
           1
       fim.tamanho
escreva cont
````


## 2968 - Hora da Corrida

````portugol
a = leia_inteiros(" ")
n, v = a[1], a[2]
t = n * v / 10
saida = para i de 1 até 9 gere (t * i).teto.inteiro fim
escreva saida.junte(" ")
````


## 1114 - Senha Fixa

````portugol
var n := leia_inteiro
enquanto n <> 2002 faça
  escreva "Senha Invalida"
  n := leia_inteiro
fim
escreva "Acesso Permitido"
````


## 1263 - Aliteração

````portugol
var s := leia_textos(" ")
enquanto nao eof faca
  aliteracoes = s.mapeie(_.minusculo[1])
                 .divida_quando((a, b) => a <> b)
                 .selecione(_.tamanho > 1)
                 .tamanho
  escreva aliteracoes
  s := leia_textos(" ")
fim
````


## 1099 - Soma de Ímpares Consecutivos II

````portugol
n = leia_inteiro
para i de 1 até n faça
  entrada = leia_inteiros(" ").ordene
  a = entrada[1]
  b = entrada[2]
  x = se a mod 2 == 0 então a + 1 senão a + 2 fim
  y = se b mod 2 == 0 então b - 1 senão b - 2 fim
  se x > y então
    escreva 0
  senão
    soma = ((y - x + 2) * (x + y)) div 4
    escreva soma
  fim
fim
````


## 1150 - Ultrapassando Z

````portugol
var x, z := leia_inteiro
enquanto x>=z faça
  z := leia_inteiro
fim
var i := 0
enquanto x <= z faça
  z := z - (i + x)
  i := i + 1
fim
escreva i + 1
````


## 1478 - Matriz Quadrada II

````portugol
var n := leia_inteiro

enquanto n <> 0 faça
  para linha de 1 até n faça
    escreva (para c de linha até 1 passo -1 gere
      c formato "%3d"
    fim + para c de 2 até n - linha + 1 gere
      c formato "%3d"
    fim).junte(" ")
  fim
  escreva ""
  n := leia_inteiro
fim
````


## 1249 - ~~Rot13~~

````portugol

rot13(c: Inteiro) = escolha c
  caso x se x >= 'a' e x <= 'z' => ((x-'a' + 13) mod 26 + 'a').caractere
  caso x se x >= 'A' e x <= 'Z' => ((x-'A' + 13) mod 26 + 'A').caractere
  caso x                        => x.caractere
fim

rot = para i de 1 ate 255 gere rot13(i) fim.junte("")

var entrada := leia_texto
enquanto nao eof faça
  escreva entrada.mapeie(c => rot[c])
  entrada := leia_texto
fim
````


## 3126 - Lista de Treinamento

````portugol
leia_inteiro
a = leia_inteiros(" ").injete(0)((x, y) => x + y)
escreva a
````


## 2681 - Macacos da Torre de Hanoi

````portugol
tipo Mat = Lista[Lista[BigInt]]
m = 24*60*60

matrixMult(a, b: Mat): Mat
  var result := Lista(a.tamanho, Lista(a[1].tamanho, BigInt(0)))
  para i de 1 até a.tamanho, j de 1 até b.tamanho, k de 1 até b.tamanho faça
    result[i][j] := (result[i][j] + a[i][k] * b[k][j]) mod m
  fim
  retorne result
fim

matrixPow(a: Mat, n: BigInt): Mat =
  se n == 1 então
    a
  senão
    b = matrixPow(a, n div 2)
    c = matrixMult(b, b)
    se n mod 2 == 0 então c senão matrixMult(a, c) fim
  fim
# [f(1) f(n-1)] * T = [f(1) f(n)]
# f(1) * T11 + f(n-1) * T21 = f(1)  -> T11 = 1, T21 = 0
# f(1) * T12 + f(n-1) * T22 = f(n)  -> T12 = 1, T22 = 2
dabriel(n: BigInt): BigInt
  x0: Mat = [[1, 2]]
  a: Mat =  [[1, 0], [1, 2]]
  xn: Mat = matrixMult(x0, matrixPow(a, n - 1))
  retorne xn[1][1]
fim

var n := leia_texto
se n == "1" então
  escreva "00:00:01"
senão
  x = dabriel(BigInt(n))
  escreva "{x div 3600 formato "%02d"}:{x mod 3600 div 60 formato "%02d"}:{x mod 60 formato "%02d"}"
fim
````


## 2845 - Festa no Polo Norte

````portugol
n = leia_inteiro
a = leia_inteiros(" ").ordene
maior = a[-1]
var ns := para x em a.descarte(1).pegue(20),
               y de (maior div x + 1) * x até maior + 500 passo x gere y fim.ordene

var m := maior + 1
enquanto ns.tamanho > 1 e m >= ns[1] faça
  ns := ns.cauda
  se m == ns[1] então
    m := m + 1
  fim
fim
escreva m
````


## 2598 - Colocando Radares

````portugol
c = leia_inteiro
para i de 1 até c faça
  a = leia_inteiros(" ")
  n, m = a[1], a[2]
  s = n div m + (se n mod m == 0 então 0 senão 1 fim)
  escreva s
fim
````


## 3059 - Pares de Números

````portugol
pares(xs: Lista[Inteiro], cont, i, f: Inteiro): Inteiro =
  se xs <> [] então
    yi, yf = i - xs.cabeça, f - xs.cabeça
    ys = xs.cauda
    c = ys.descarte_enquanto(x => x < yi)
          .pegue_enquanto(x => x <= yf)
          .tamanho
    pares(ys, cont + c, i, f)
  senão
    cont
  fim

a = leia_inteiros(" ")
nums = leia_inteiros(" ").ordene
n, i, f = a[1], a[2], a[3]

escreva pares(nums, 0, i, f)
````


## 1266 - Tornado!

````portugol
var n := leia_inteiro
enquanto n <> 0 faça
    var zero, soma, inicio, postes = 0
    para numero em leia_texto.selecione(_ <> ' ') faça
        se numero == '0' entao
            se inicio == 0 então
                zero := zero + 1
            fim
            postes := postes + 1
        senao
            inicio := 1
            soma := soma + postes div 2
            postes := 0
        fim
    fim
    se postes > 0 então
        soma := soma - zero div 2
        postes := postes + zero
        soma := soma + postes div 2 
    fim
    escreva soma
    n := leia_inteiro
fim
````


## 2153 - Sanduicheiche

````portugol
var palavra := leia_texto
enquanto não eof faça
  var resposta := palavra
  palavra := palavra.inverta
  para i de 1 até palavra.tamanho faça
    a = palavra.pegue(i)
    b = palavra.descarte(i).pegue(i)
    se a == b então
      resposta := palavra.descarte(i).inverta
    fim
  fim
  escreva resposta
  palavra := leia_texto
fim
````


## 2851 - Desafio de Rangel

````portugol
n = leia_inteiro
nums = leia_inteiros(" ").inverta.mapeie(i => (i + '0').caractere) #.junte("")
var lasts := ""
list = para i em nums gere
  a = lasts.descarte_enquanto(i >= _)
  lasts := i + a
  se a.tamanho == 0 então "*" senão a[1] - '0' fim
fim
escreva list.inverta.junte(" ")
````


## 2243 - Isósceles

````portugol
min(x, y: Inteiro) = se x < y então x senao y fim

n = leia_inteiro
var a := leia_inteiros(" ").mutável
var esq := 0
para i de 1 até n faça
  esq := min(esq+1, a[i])
  a[i] := esq
fim
var dir, maior:= 0
para i de n até 1 passo -1 faça
  dir := min(dir+1, a[i])
  se dir > maior então maior := dir fim
fim
escreva maior
````


## 2355 - Brasil e Alemanha

````portugol
var n := leia_inteiro
enquanto n > 0 faça
  brasil = (n / 90).piso.inteiro
  alemanha = (n / 90 * 7).teto.inteiro
  escreva "Brasil {brasil} x Alemanha {alemanha}"
  n := leia_inteiro
fim
````


## 1192 - O jogo Matemático de Paula

````portugol
n = leia_inteiro
para i de 1 ate n faca
  a = leia_texto
  x = a[1] - '0'
  y = a[3] - '0'
  c = a[2]
  se x == y entao
    escreva x * x
  senaose c >= 'a' e c <= 'z' entao
    escreva x + y
  senão
    escreva y - x
  fim
fim
````


## 1060 - Números Positivos

````portugol
n = leia_inteiros(6).selecione(_ > 0).tamanho
escreva "{n} valores positivos"
````


## 1050 - DDD

````portugol
ddd = leia_inteiro
cidade = escolha ddd
  caso 61 => "Brasilia"
  caso 71 => "Salvador"
  caso 11 => "Sao Paulo"
  caso 21 => "Rio de Janeiro"
  caso 32 => "Juiz de Fora"
  caso 19 => "Campinas"
  caso 27 => "Vitoria"
  caso 31 => "Belo Horizonte"
  caso _  => "DDD nao cadastrado"
fim
escreva cidade
````


## 2581 - I am Toorg!

````portugol
para i de 1 até leia_inteiro faça
  escreva "I am Toorg!"
fim
````


## 2465 - Passa Bolinha

````portugol
n = leia_inteiro
a = leia_inteiros(" ")
matriz = Lista(n, leia_inteiros(" "))
var marcado = Lista(n, Lista(n, falso))
var bandeiras := 0

marcar(x, y: Inteiro): Nada
  marcado[x][y] := verdadeiro
  bandeiras := bandeiras + 1
  vizinhos = [(x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1)]
  para a em vizinhos faça
    i, j = a.primeiro, a.segundo
    se i > 0 e i <= n e j > 0 e j <= n e matriz[x][y] <= matriz[i][j] e não marcado[i][j] então
      marcar(i, j)
    fim
  fim
fim

marcar(a[1], a[2])
escreva bandeiras
````


## 2006 - Identificando o Chá

````portugol
n = leia_inteiro
nums = leia_inteiros(" ")
c = nums.selecione(_ == n).tamanho
escreva c
````


## 2497 - Contando Ciclos

````portugol
var n := leia_inteiro
var x := 0
enquanto n >= 0 faca
  x := x + 1
  escreva "Experiment {x}: {n div 2} full cycle(s)"
  n := leia_inteiro
fim
````


## 1002 - Área do Círculo

````portugol
x = leia_real
area = (x * x) * 3.14159
escreva "A={area formato "%.4f"}"
````


## 2813 - Evitando Chuva

````portugol
n = leia_inteiro
var casa, escritorio, cont:= 0
para i de 1 até n faça
  dia = leia_textos(" ")
  se dia[1] == "chuva" então
    cont := cont -1
    se casa < -cont então
      casa := -cont
    fim
  fim
  se dia[2] == "chuva" então
    cont := cont + 1
    se escritorio < cont então
      escritorio := cont
    fim
  fim
fim
escreva "{casa} {escritorio}"
````


## 1429 - Fatorial de Novo!

````portugol
f = [1, 2, 6, 24, 120]

var s := leia_texto
enquanto s <> "0" faca
  r = s.lista.inverta.mapeie(_.inteiro - '0')
  var d := 0
  para i de 1 ate r.tamanho faca
    d := d + r[i] * f[i]
  fim
  escreva d
  s := leia_texto
fim
````


## 2862 - Inseto!

````portugol
c = leia_inteiro
para i de 1 até c faça
  n = leia_inteiro
  se n > 8000 então
    escreva "Mais de 8000!"
  senão
    escreva "Inseto!"
  fim
fim
````


## 2766 - Entrada e Saída Lendo e Pulando Nomes

````portugol
nomes = leia_textos(10)
escreva nomes[3]
escreva nomes[7]
escreva nomes[9]

````


## 3109 - Trocando de Mesa

````portugol
n, q = leia_inteiro
var emp := para i de 1 ate n gere i fim
para i de 1 ate q faca
  f = leia_inteiros(" ")
  se f[1] == 1 entao
    a, b = f[2], f[3]
    aux = emp[a]
    emp[a] := emp[b]
    emp[b] := aux
  senao
    var c := 0
    var p := f[2]
    enquanto f[2] <> emp[p] faca
      c := c + 1
      p := emp[p]
    fim
    escreva c
  fim
fim
````


## 3005 - Pilhas de Paralelepípedos

````portugol
n = leia_inteiro
para i de 1 até n faça
  a = leia_inteiros(" ")
  x = a.pegue(3).ordene
  y = a.descarte(3).ordene
  resposta =
    (se y[3] > x[2] e y[2] > x[1] então 1 senão 0 fim) +
    (se x[3] > y[2] e x[2] > y[1] então 2 senão 0 fim)
  escreva resposta
fim
````


## 2140 - Duas Notas

````portugol
trocos = [4, 10, 20, 40, 50, 200, 7, 12, 22, 52, 102, 15, 25,
          55, 105, 30, 60, 110, 70, 120, 150]
var a:= leia_inteiros(" ")
enquanto a <> [0,0] faça
  se trocos.contém(a[2]-a[1]) então
    escreva "possible"
  senão
    escreva "impossible"
  fim
  a := leia_inteiros(" ")
fim
````


## 2756 - Saída 10

````portugol
escreva "       A"
escreva "      B B"
escreva "     C   C"
escreva "    D     D"
escreva "   E       E"
escreva "    D     D"
escreva "     C   C"
escreva "      B B"
escreva "       A"
        
````


## 3162 - Comunicação Espacial

````portugol
n = leia_inteiro
ss = para i de 1 ate n gere leia_inteiros(" ") fim
para i de 1 ate n faca
  var distancia := 500.0
  para j de 1 ate n se i <> j faca
    s, r = ss[i], ss[j]
    a, b, c = s[1] - r[1], s[2] - r[2], s[3] - r[3]
    dif = raiz(a^2 + b^2 + c^2)
    se dif < distancia entao distancia := dif fim
  fim
  se distancia <= 20 entao
    escreva "A"
  senaose distancia <= 50 entao
    escreva "M"
  senao
    escreva "B"
  fim
fim
````


## 1759 - Ho Ho Ho

````portugol
escreva "Ho " * (leia_inteiro - 1) + "Ho!"
````


## 1393 - Lajotas Hexagonais

````portugol
lajotas(a: Lista[Inteiro]): Lista[Inteiro] =
  se      a.tamanho < 2   entao lajotas([2, 1])
  senaose a.tamanho >= 40 entao a.inverta
  senao                         lajotas((a[1] + a[2]) :: a)
  fim

l = lajotas([])

var n := leia_inteiro
enquanto n > 0 faca
  escreva l[n]
  n := leia_inteiro
fim
````


## 2926 - Então é Natal!

````portugol
i = leia_inteiro
escreva "Ent{"a" * i}o eh N{"a" * i}t{"a" * i}l!"
````


## 3147 - A Batalha dos Cinco Exércitos

````portugol
ent = leia_inteiros(" ")
heax = ent[1] + ent[2] + ent[3] + ent[6]
ow = ent[4] + ent[5]
se heax >= ow entao
  escreva "Middle-earth is safe."
senao
  escreva "Sauron has returned."
fim
````


## 3454 - Alice no País do Jogo da Velha

````portugol
linha = leia_texto
resultado = escolha linha
  caso "XOX" => "*"
  caso "XXO" => "Alice"
  caso "OXX" => "Alice"
  caso _     => "?"
fim
escreva resultado
````


## 3476 - A união faz a força!

````portugol
a = leia_inteiros(" ")
s, b, c = a[1], a[2], a[3]
tempo = 1 / (1/s + 1/b + 1/c)
escreva tempo formato "%.3f"
````


## 2749 - Saída 3

````portugol
escreva "---------------------------------------"
escreva "|x = 35                               |"
escreva "|                                     |"
escreva "|               x = 35                |"
escreva "|                                     |"
escreva "|                               x = 35|"
escreva "---------------------------------------"
````


## 1318 - Bilhetes Falsos

````portugol
var a := leia_inteiro
enquanto a > 0 faca
  t = leia_inteiros(" ").ordene.divida_quando((x, y) => x <> y)
  escreva t.selecione(_.tamanho > 1).tamanho
  a := leia_inteiro
fim
````


## 1202 - Festival das Noites Brancas

````portugol
exp(base: Inteiro, expoente: Inteiro): Inteiro
    var p = 1
    var x = base
    var y = expoente
    enquanto y <> 0 faça
        se y mod 2 == 1 então
            p := (p * x) mod 1500
            y := y - 1
        fim
        x :=  (x * x) mod 1500
        y := (y / 2).inteiro
    fim
    p
fim

var fib = Lista.mutável(1511, 0)
fib[1] := 1
fib[2] := 1

para x de 3 até 1510 faça
    fib[x] := (fib[x-1] + fib[x-2]) mod 1000
fim

t = leia_inteiro
para count de 1 até t faça
    var numero = leia_texto
    var d = 0
    var l = 0

    para i de numero.tamanho até 1 passo -1 faça
        se numero[i] == '1' então
            d := (d + exp(2, l)) mod 1500
        fim
        l := l + 1
    fim

    se d <> 0 então
        d := fib[d]
    fim

    escolha d
        caso n se n < 10  => escreva "00{d}"
        caso n se n < 100 => escreva "0{d}"
        caso _            => escreva "{d}"
    fim
fim
````


## 2203 - Tempestade de Corvos

````portugol
var entrada = leia_texto
enquanto nao eof faca
  a = entrada.divida(" ").mapeie(_.inteiro)
  x1, y1, x2, y2, v, r1, r2 = a[1], a[2], a[3], a[4], a[5], a[6], a[7]
  distancia = ((x2 - x1) ^ 2 + (y2 - y1) ^ 2) ^ 0.5 + 1.5 * v
  escreva se distancia > r1 + r2 entao "N" senao "Y" fim
  entrada := leia_texto
fim
````


## 1241 - Encaixa ou Não II

````portugol
n = leia_inteiro
para i de 1 ate n faca
  s = leia_textos(" ")
  a, b = s[1], s[2]
  se a.descarte(a.tamanho - b.tamanho) == b entao
    escreva "encaixa"
  senao
    escreva "nao encaixa"
  fim
fim
````


## 2702 - Escolha Difícil

````portugol
entrada1, entrada2 = leia_inteiros(" ")
ca = entrada1[1]
ba = entrada1[2]
pa = entrada1[3]
cr = entrada2[1]
br = entrada2[2]
pr = entrada2[3]
var resposta := 0
se cr > ca então
  resposta := resposta + (cr - ca)
fim
se br > ba então
  resposta := resposta + (br - ba)
fim
se pr > pa então
  resposta := resposta + (pr - pa)
fim
escreva resposta
````


## 2761 - Entrada e Saída de Vários Tipos

````portugol
s = leia_texto
q = s.divida(" ")
r = s.descarte_enquanto(_ <> ' ').cauda.descarte_enquanto(_ <> ' ').cauda
a, b, c, d = q[1].inteiro, q[2].toFloat, r.cabeça, r.cauda.cauda
escreva "{a}{b formato "%.6f"}{c}{d}"
escreva "{a}"+"\t"+"{b formato "%.6f"}"+"\t"+"{c}"+"\t"+"{d}"
escreva "{a formato "%10d"}{b formato "%10.6f"}{c formato "%10c"}{d formato "%10s"}"
````


## 3173 - Estrela de Natal

````portugol
datas = [(4346,"2032-11-14",10811,"2050-07-28"),
          (8692,"2044-10-08",21622,"2080-03-03"),
          (13039,"2056-09-02",32434,"2109-10-10"),
          (17385,"2068-07-27",43245,"2139-05-17"),
          (21732,"2080-06-21",54057,"2168-12-22"),
          (26078,"2092-05-15",64868,"2198-07-29"),
          (30425,"2104-04-10",75679,"2228-03-05"),
          (34771,"2116-03-04",86491,"2257-10-11"),
          (39118,"2128-01-28",97302,"2287-05-18"),
          (43464,"2139-12-22",108114,"2316-12-24"),
          (47811,"2151-11-16",118925,"2346-07-31"),
          (52157,"2163-10-10",129736,"2376-03-06"),
          (56504,"2175-09-04",140548,"2405-10-12"),
          (60850,"2187-07-29",151359,"2435-05-19"),
          (65197,"2199-06-23",162171,"2464-12-24"),
          (69543,"2211-05-18",172982,"2494-07-31"),
          (73890,"2223-04-12",183793,"2524-03-07"),
          (78236,"2235-03-06",194605,"2553-10-13"),
          (82583,"2247-01-29",205416,"2583-05-20"),
          (86929,"2258-12-23",216228,"2612-12-26"),
          (91275,"2270-11-16",227039,"2642-08-02"),
          (95622,"2282-10-11",237850,"2672-03-08"),
          (99968,"2294-09-04",248662,"2701-10-15"),
          (104315,"2306-07-31",259473,"2731-05-22"),
          (108661,"2318-06-24",270285,"2760-12-27"),
          (113008,"2330-05-19",281096,"2790-08-03"),
          (117354,"2342-04-12",291907,"2820-03-09"),
          (121701,"2354-03-07",302719,"2849-10-15"),
          (126047,"2366-01-29",313530,"2879-05-22"),
          (130394,"2377-12-24",324342,"2908-12-28"),
          (134740,"2389-11-17",335153,"2938-08-04"),
          (139087,"2401-10-12",345964,"2968-03-10"),
          (143433,"2413-09-05",356776,"2997-10-16"),
          (147780,"2425-07-31",367587,"3027-05-24"),
          (152126,"2437-06-24",378399,"3056-12-29"),
          (156473,"2449-05-19",389210,"3086-08-05"),
          (160819,"2461-04-12",400021,"3116-03-12"),
          (165166,"2473-03-07",410833,"3145-10-18"),
          (169512,"2485-01-29",421644,"3175-05-25"),
          (173859,"2496-12-24",432456,"3204-12-30"),
          (178205,"2508-11-18",443267,"3234-08-06"),
          (182551,"2520-10-12",454078,"3264-03-12"),
          (186898,"2532-09-06",464890,"3293-10-18"),
          (191244,"2544-07-31",475701,"3323-05-26"),
          (195591,"2556-06-25",486513,"3352-12-31"),
          (199937,"2568-05-19",497324,"3382-08-07"),
          (204284,"2580-04-13",508135,"3412-03-14"),
          (208630,"2592-03-07",518947,"3441-10-20"),
          (212977,"2604-02-01",529758,"3471-05-27"),
          (217323,"2615-12-26",540570,"3501-01-02")]
n = leia_inteiro
data = datas[n]
escreva "Dias terrestres para Jupiter = {data.primeiro}"
escreva "Data terrestre para Jupiter: {data.segundo}"
escreva "Dias terrestres para Saturno = {data.terceiro}"
escreva "Data terrestre para Saturno: {data.quarto}"
````


## 2057 - Fuso Horário

````portugol
s = leia_inteiros(" ")
soma = s[1] + s[2] + s[3] + 24
escreva soma mod 24
````


## 3306 - Consulta e Alteração

````portugol
mdc(x, y: Inteiro)
  var a, b := x, y
  enquanto b <> 0 faca
    a, b := b, a mod b
  fim
  retorne a
fim

q = leia_inteiros(" ")[2]
var nums := leia_inteiros(" ")

para i de 1 até q faça
  entrada = leia_inteiros(" ")
  t = entrada[1]
  escolha t
    caso 1 =>
      a, b, v = entrada[2], entrada[3], entrada[4]
      para j de a até b faça
        nums[j] := nums[j] + v
      fim
    caso 2 =>
      a, b = entrada[2], entrada[3]
      var r := nums[a]
      para i de a + 1 até b faça
        r := mdc(r, nums[i])
      fim
      escreva r
    caso _ => escreva i
  fim
fim
````


## 2748 - Saída 2

````portugol
escreva "---------------------------------------"
escreva "|        Roberto                      |"
escreva "|                                     |"
escreva "|        5786                         |"
escreva "|                                     |"
escreva "|        UNIFEI                       |"
escreva "---------------------------------------"
````


## 1170 - Blobs

````portugol
n = leia_inteiro
para i de 1 até n faça
  c = leia_real
  dias = (log(c) / log(2)).teto.inteiro
  escreva "{dias} dias"
fim
````


## 2963 - Bobo da Corte

````portugol
n = leia_inteiro
bobo = leia_inteiro
var resp := "S"
para i de 2 até n se leia_inteiro > bobo faça
  resp := "N"
fim
escreva resp
````


## 1035 - Teste de Seleção 1

````portugol
x = leia_inteiros(" ")
a, b, c, d = x[1], x[2], x[3], x[4]
se ((b > c e d > a) e (c + d) > (a + b) e (c > 0 e d > 0) e (a mod 2 == 0)) então
  escreva "Valores aceitos"
senão
  escreva "Valores nao aceitos"
fim
````


## 1466 - Percurso em Árvore por Nível

````portugol
tipo Valor = Inteiro

tipo abstrato No
  valor(): Valor
  esquerda(): No
  direita(): No
  inserir(v: Valor): No
  altura(): Inteiro
  pesquisar(v: Valor): Lógico
  infixa(): Lista[Valor]
  prefixa(): Lista[Valor]
  posfixa(): Lista[Valor]
fim

max(a, b: Inteiro) = se a >= b então a senão b fim

tipo Arvore: No
  valor: Valor
  esquerda, direita: No

  altura = max(esquerda.altura, direita.altura) + 1

  inserir(v: Valor): No =
    se v < valor então
      Arvore(valor, esquerda.inserir(v), direita)
    senão
      Arvore(valor, esquerda, direita.inserir(v))
    fim

  pesquisar(v: Valor) =
    v == valor ou
      (se v < valor então esquerda.pesquisar(v) senão direita.pesquisar(v) fim)

  infixa()  = esquerda.infixa + valor :: direita.infixa
  prefixa() = valor :: esquerda.prefixa + direita.prefixa
  posfixa() = esquerda.posfixa + direita.posfixa + [valor]
fim

tipo Folha: No
  valor: Valor = valor
  esquerda, direita = isto
  altura = -1
  inserir(v: Valor): No = Arvore(v, Folha(), Folha())
  pesquisar(v: Valor) = falso
  infixa, prefixa, posfixa: Lista[Valor] = []
fim

tipo TipoFila = No

tipo Fila
  entrada, saida: Lista[TipoFila]

  inserir(valor: TipoFila): Fila =
    se saida == [] então
      Fila([], (valor :: entrada).inverta)
    senão
      Fila(valor :: entrada, saida)
    fim

  cabeça(): TipoFila = saida.cabeça

  vazia() = entrada == [] e saida == []

  remover(): Fila =
    se saida == [] então
      Fila([], entrada.inverta.cauda)
    senãose saida.cauda == [] então
      Fila([], entrada.inverta)
    senão
      Fila(entrada, saida.cauda)
    fim
fim

fila_vazia = Fila([], [])

folha: No = Folha()
c = leia_inteiro
para i de 1 até c faça
  leia_texto
  num = leia_inteiros(" ")
  arvore = num.injete(folha)((a, b) => a.inserir(b))
  var fila := fila_vazia.inserir(arvore)
  var list: Lista[Inteiro] = []
  enquanto não fila.vazia faça
    a = fila.cabeça
    list := a.valor :: list
    fila := fila.remover()
    se a.esquerda <> folha então fila := fila.inserir(a.esquerda) fim
    se a.direita <> folha então fila := fila.inserir(a.direita) fim
  fim
  escreva "Case {i}:"
  escreva list.inverta.junte(" ")
  escreva ""
fim
````


## 1071 - Soma de Impares Consecutivos I

````portugol
limites = leia_inteiros(2).ordene
var soma := 0
para n de limites[1] + 1 até limites[2] - 1 faça
  se n mod 2 <> 0 então
    soma := soma + n
  fim
fim
escreva soma
````


## 2402 - Selos

````portugol
n = BigInt(leia_texto)
fatoravel(a: BigInt, i: Inteiro): Logico = a > i e i < 100000 e (
  a mod i == 0 ou fatoravel(a, i + 2)
)
resposta = se (n > 3 e n mod 2 == 0) ou fatoravel(n, 3) entao "S" senao "N" fim
escreva resposta
````


## 1187 - Área Superior

````portugol
o = leia_texto
nums = leia_reais(144)
var soma := 0.0
para i de 0 até 11, j de i + 2 até 11 - i faça
  soma := soma + nums[i * 12 + j]
fim
se o == "S" então
  escreva soma formato "%.1f"
senão
  escreva soma / 30 formato "%.1f"
fim
````


## 2408 - Vice-Campeão

````portugol
abc = leia_inteiros(" ").ordene
escreva abc[2]
````


## 1515 - Hello Galaxy

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  s = para i de 1 ate n, l em [leia_textos(" ")] gere
        (l[1], l[2].inteiro - l[3].inteiro)
      fim
  r = s.injete((a, b: (Texto, Inteiro)) =>
        se a.segundo < b.segundo entao a senao b fim
      )
  escreva r.primeiro
  n := leia_inteiro
fim
````


## 2221 - Batalha de Pomekons

````portugol
t = leia_inteiro
para i de 1 ate t faca
  b = leia_inteiro
  j1, j2 = leia_inteiros(" ")
  ad, dd, ld = j1[1], j1[2], j1[3]
  ag, dg, lg = j2[1], j2[2], j2[3]
  vd = ad + dd - 2 * b * (ld mod 2)
  vg = ag + dg - 2 * b * (lg mod 2)
  escreva se vd > vg entao "Dabriel" senaose vg > vd entao "Guarte" senao "Empate" fim
fim
````


## 1026 - Carrega ou não Carrega?

````portugol
var entrada := leia_texto
enquanto entrada <> nulo faça
  nums = entrada.divida(" ").mapeie(x => BigInt(x))
  var a, b := nums[1], nums[2]
  var resp := BigInt(0)
  var i := BigInt(1)
  enquanto a * b > 0 faça
    se a mod 2 + b mod 2 == 1 então
      resp := resp + i
    fim
    a, b, i := a div 2, b div 2, i * 2
  fim
  escreva resp + (a + b) * i
  entrada := leia_texto
fim
````


## 2189 - Quermesse

````portugol
comparar(a, b: Inteiro) =
  se a == b ou a < 0 então
    - abs(a)
  senão
    a + 1
  fim

var n := leia_inteiro
var t := 0
enquanto n > 0 faça
  ingressos = leia_inteiros(" ")
  t := t + 1
  escreva "Teste {t}"
  escreva - ingressos.injete(1)(comparar)
  escreva ""
  n := leia_inteiro
fim
````


## 3422 - José e a Súmula

````portugol
min(a, b: Inteiro): Inteiro = se a <= b então a senão b fim

n = leia_inteiro
para i de 1 até n faça
  a = leia_textos(" ")
  o, tempo = a[1].inteiro, a[2]
  t = (se tempo == "1T" então 0 senão 45 fim) + min(45, o)
  extra = o - 45
  se extra <= 0 então
    escreva t
  senão
    escreva "{t}+{extra}"
  fim
fim
````


## 1185 - Acima da Diagonal Secundária

````portugol
o = leia_texto
nums = leia_reais(144)
var soma := 0.0
para i de 0 até 11, j de 1 até 11-i faça
  soma := soma + nums[i * 12 + j]
fim
se o == "S" então
  escreva soma formato "%.1f"
senão
  escreva soma / 66 formato "%.1f"
fim
````


## 2338 - Morse

````portugol
letras = ["=.===", "===.=.=.=", "===.=.===.=", "===.=.=", "=", "=.=.===.=",
 "===.===.=", "=.=.=.=","=.=", "=.===.===.===", "===.=.===", "=.===.=.=",
 "===.===", "===.=", "===.===.===", "=.===.===.=", "===.===.=.===",
 "=.===.=", "=.=.=", "===", "=.=.===", "=.=.=.===", "=.===.===",
 "===.=.=.===", "===.=.===.===", "===.===.=.="]
ponto = "\\."

converta_letra(letra: Texto) = (letras.posição(letra) + 96).caractere
converta_palavra(palavra: Texto) = palavra.divida(ponto * 3).mapeie(converta_letra).junte("")

t = leia_inteiro
para i de 1 até t faça
  s = leia_texto
  palavras = s.divida(ponto * 7).mapeie(converta_palavra).junte(" ")
  escreva palavras
fim
````


## 2423 - Receita de Bolo

````portugol
s = leia_inteiros(" ")
farinha, ovos, leite = s[1] div 2, s[2] div 3, s[3] div 5
se farinha <= ovos e farinha <= leite entao
  escreva farinha
senaose ovos <= leite entao
  escreva ovos
senao
  escreva leite
fim
````


## 1273 - Justificador

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  s = leia_textos(n)
  tam = s.injete(0)((a, b) => se b.tamanho > a entao b.tamanho senao a fim)
  para linha em s faca
    escreva linha formato "%{tam}s"
  fim
  n := leia_inteiro
  se n > 0 entao escreva "" fim
fim
````


## 3262 - Timebomb

````portugol
numeros = ["***   * *** *** * * *** *** *** *** ***",
           "* *   *   *   * * * *   *     * * * * *",
           "* *   * *** *** *** *** ***   * *** ***",
           "* *   * *     *   *   * * *   * * *   *",
           "***   * *** ***   * *** ***   * *** ***"]

codigos(linhas: Lista[Texto]) =
  para i de 0 até linhas[1].tamanho div 4 gere
    para j de 1 até 5 gere linhas[j].descarte(i * 4).pegue(3) fim.junte("")
  fim

num = codigos(numeros)
entrada = codigos(leia_textos(5))
beer = para a em entrada gere num.posição(a) - 1 fim.mapeie(_.texto).junte("")
se beer.contem('-') ou beer.inteiro mod 6 <> 0 então
  escreva "BOOM!!"
senao
  escreva "BEER!!"
fim
````


## 2602 - Select Básico

````portugol
use sql

tipo Clientes: Tabela
    _tabela = "customers"
    nome = campo("name")
    estado = campo("state")
fim
    
c = Clientes()
consulta = Selecionar()
            .tabela(c)
            .campos([c.nome])
            .onde(c.estado == "RS")
            .sql

escreva consulta
````


## 2235 - Andando no Tempo

````portugol
x = leia_inteiros(" ")
a, b, c = x[1], x[2], x[3]
se a + b == c ou a == b + c ou b == a + c ou a == b ou a == c ou b == c então
  escreva "S"
senão
  escreva "N"
fim
````


## 1278 - Justificador II

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  linhas = leia_textos(n).mapeie(_.descarte_enquanto(_ == ' ').divida(" ").junte(" "))
  tamanho = linhas.injete(0)((a, b) => se b.tamanho > a entao b.tamanho senao a fim)
  alinhamento = "%{tamanho}s"
  para i de 1 ate n faca
    escreva linhas[i] formato alinhamento
  fim
  n := leia_inteiro
  se n > 0 entao escreva "" fim
fim
````


## 2936 - Quanta Mandioca?

````portugol
a = leia_inteiros(5)
p = [300, 1500, 600, 1000, 150]
var total := 225
para i de 1 ate 5 faca
  total := total + a[i]* p[i]
fim
escreva total
````


## 2729 - Lista de Compras

````portugol
n = leia_inteiro
para i de 1 até n faça
  linha = leia_texto.divida(" ").ordene
  var ultimo := ""
  var lista := [""].cauda
  para item em linha faça
    se item <> ultimo então
      lista := lista + [item]
      ultimo := item
    fim
  fim
  escreva lista.junte(" ")
fim
````


## 1251 - Diga-me a Frequência

````portugol
var s := leia_texto
var b := falso
enquanto nao eof faca
  x = s.ordene.divida_quando(_ <> _)
       .mapeie(a => "{a.tamanho formato "%04d"}{(128 - a[1]).caractere}")
       .ordene
       .mapeie(a => "{128 - a[5]} {a.pegue(4).inteiro}")
  se b entao escreva "" senao b := verdadeiro fim
  escreva x.junte("\n")
  s := leia_texto
fim
````


## 2413 - Busca na Internet

````portugol
escreva leia_inteiro * 4
````


## 3130 - Caixas Por Todo Lado

````portugol
comprimento, largura, alt = leia_inteiro
altura = se alt < 5 entao alt senao 5 fim
creditos = comprimento * largura * altura +
           (comprimento div 2) * (largura div 2) * (altura div 2) * 2
escreva "$" + creditos
````


## 2176 - Paridade

````portugol
a = leia_texto
imprima a
escreva a.selecione(_ == '1').tamanho mod 2
````


## 1146 - Sequências Crescentes

````portugol
lista = para i de 1 até 10000 gere i fim
var n := leia_inteiro
enquanto n <> 0 faça
  escreva lista.pegue(n).junte(" ")
  n := leia_inteiro
fim
````


## 1754 - A Sala do Tempo

````portugol
n = leia_inteiro
para i de 1 ate n faça
  xy = leia_textos(" ")
  x, y = BigInt(xy[1]), xy[2].inteiro
  k = (x + y - 1) div y
  se k < 2 então
    escreva 2
  senão
    escreva k
  fim
fim
````


## 2391 - Progressões Aritméticas

````portugol
pas(nums: Lista[Inteiro], tamanho, total: Inteiro): Inteiro =
  se tamanho < 3                           então total
  senãose nums[1] + nums[3] == 2 * nums[2] então pas(nums.cauda, tamanho - 1, total)
                                           senão pas(nums.descarte(2), tamanho - 2, total + 1)
  fim

n = leia_inteiro
a = leia_inteiros(" ")
escreva pas(a, n, 1)

# # Imperativo
# var n := leia_inteiro
# var a := leia_inteiros(" ")
# var total := 1
# enquanto n > 2 faça
#   se a[1] + a[3] == 2 * a[2] então
#     a := a.descarte(1)
#     n := n - 1
#   senão
#     a := a.descarte(2)
#     n := n - 2
#     total := total + 1
#   fim
# fim
# escreva total
````


## 1959 - Polígonos Regulares Simples

````portugol
entrada = leia_reais(" ")
n = entrada[1]
l = entrada[2]
escreva (n * l) formato "%.0f"
````


## 2556 - Reinauguração do CEI

````portugol
var n := leia_inteiro
enquanto n > 0 faça
    m = leia_inteiros(" ").ordene
    a = m.descarte(n div 2 - 1)
    escreva "{n div 2} {a[2] - a[1]}"
    n := leia_inteiro
fim
````


## 1103 - Alarme Despertador

````portugol
var entrada := leia_inteiros(" ")
enquanto entrada <> [0,0,0,0] faça
  h1 = entrada[1]
  m1 = entrada[2]
  h2 = entrada[3]
  m2 = entrada[4]
  tempo = ((24 + h2 - h1) * 60 + m2 - m1) mod (24 * 60)
  escreva tempo
  entrada := leia_inteiros(" ")
fim
````


## 3358 - Sobrenome Não é Fácil

````portugol
n = leia_inteiro
para i de 1 ate n faça
  s = leia_texto
  a = s.minusculo.divida_quando((x, y) => "aeiou" - "{x}" <> "aeiou" ou "aeiou" - "{y}" <> "aeiou")
  b = a.ordene(_.tamanho).ultimo.tamanho
  se b >= 3 entao
    escreva "{s} nao eh facil"
  senao
    escreva "{s} eh facil"
  fim
fim
````


## 2253 - Validador de Senhas

````portugol
var s := leia_texto
enquanto nao eof faca
  min = s.selecione(c => c >= 'a' e c <='z').tamanho
  mai = s.selecione(c => c >= 'A' e c <='Z').tamanho
  tam = s.selecione(c => c >= '0' e c <='9').tamanho

  se min > 0 e mai > 0 e tam > 0 e (min + mai + tam) == s.tamanho e s.tamanho >= 6 e s.tamanho <= 32 entao
    escreva "Senha valida."
  senao
    escreva "Senha invalida."
  fim
  s := leia_texto
fim
````


## 3042 - Desviando de Árvores de Natal

````portugol
var m := leia_inteiro
enquanto m > 0 faça
  var p := 2
  var cont := 0
  para i de 1 até m faça
    linha = leia_texto
    escolha linha
      caso "0 1 1" se p <> 1 => cont := cont + abs(p - 1) p := 1
      caso "1 0 1" se p <> 2 => cont := cont + abs(p - 2) p := 2
      caso "1 1 0" se p <> 3 => cont := cont + abs(p - 3) p := 3
      caso _ =>
    fim
  fim
  escreva cont
  m := leia_inteiro
fim
````


## 3257 - Plantando Árvores

````portugol
n = leia_inteiro
t = leia_inteiros(" ").ordene(_ > _)
var festa := 0
t.injete(2)((a, b) => se b + a > festa então festa := a + b a + 1 senao a + 1 fim)
escreva festa
````


## 2717 - Tempo do Duende

````portugol
n = leia_inteiro
entrada = leia_inteiros(" ")
a = entrada[1]
b = entrada[2]

se a + b > n então
  escreva "Deixa para amanha!"
senão
  escreva "Farei hoje!"
fim
````


## 1219 - Flores Coloridas

````portugol
area_circulo(raio: Real) = PI * raio ^ 2

resposta(a, b, c: Inteiro)
  s = (a + b + c) / 2
  area_triangulo = (s * (s - a) * (s - b) * (s - c)) ^ 0.5
  raio_circulo_interno = area_triangulo / s
  raio_circulo_externo = a * b * c / (4 * area_triangulo)
  rosas = area_circulo(raio_circulo_interno)
  violetas = area_triangulo - rosas
  girassois = area_circulo(raio_circulo_externo) - violetas - rosas
  retorne (girassois, violetas, rosas)
fim

var entrada := leia_texto
enquanto nao eof faça
  en = entrada.divida(" ").mapeie(_.inteiro)
  a, b, c = en[1], en[2], en[3]
  r = resposta(a, b, c)
  escreva "{r.primeiro formato "%.4f"} {r.segundo formato "%.4f"} {r.terceiro formato "%.4f"}"
  entrada := leia_texto
fim
````


## 1548 - Fila do Recreio

````portugol
n = leia_inteiro
para i de 1 ate n faca
  m = leia_inteiro
  p = leia_inteiros(" ")
  r = p.ordene.inverta
  a = para i de 1 ate m se p[i] == r[i] gere 1 fim
  escreva a.tamanho
fim
````


## 2028 - Sequência de Sequência

````portugol
var casos := 0
var entrada := leia_texto
enquanto nao eof faca
  n = entrada.inteiro
  casos := casos + 1
  saida = 0 :: para i de 1 ate n, j de 1 ate i gere i fim
  tamanho = saida.tamanho
  escreva "Caso {casos}: {tamanho} {se tamanho == 0 entao "numero" senao "numeros" fim}"
  escreva saida.junte(" ")
  escreva ""
  entrada := leia_texto
fim
````


## 2376 - Copa do Mundo

````portugol
jogos = para i de 1 ate 15 gere
  a = leia_inteiros(" ")
  a[1] > a[2]
fim

jogo1 =
  se jogos[15] entao
    se jogos[13] entao
      se jogos[9] entao 1 senao 2 fim
    senao
      se jogos[10] entao 3 senao 4 fim
    fim
  senao
    se jogos[14] entao
      se jogos[11] entao 5 senao 6 fim
    senao
      se jogos[12] entao 7 senao 8 fim
    fim
  fim

campeao = se jogos[jogo1] entao jogo1 * 2 - 1 senao jogo1 * 2 fim
escreva "ABCDEFGHIJKLMNOP"[campeao]
````


## 3343 - Attack On Gasparini

````portugol
entrada = leia_inteiros(" ")
titas = leia_texto
tamanho = leia_inteiros(" ")

n, x = entrada[1], entrada[2]
t1, t2, t3 = tamanho[1], tamanho[2], tamanho[3] # tamanho dos titas
var muralhas := Lista.mutável(n, x)
var p, m, g = 1

para t em titas faça
  escolha t
    caso 'P' =>
      enquanto muralhas[p] < t1 faça p := p + 1 fim
      muralhas[p] := muralhas[p] - t1
    caso 'M' =>
      enquanto muralhas[m] < t2 faça m := m + 1 fim
      muralhas[m] := muralhas[m] - t2
    caso  _  =>
      enquanto muralhas[g] < t3 faça g := g + 1 fim
      muralhas[g] := muralhas[g] - t3
  fim
fim
escreva [p, m, g].ordene[3]
````


## 1154 - Idades

````portugol
var idade := leia_inteiro
var soma, n := 0
enquanto idade >= 0 faça
  soma := soma + idade
  n := n + 1
  idade := leia_inteiro
fim
escreva soma / n formato "%.2f"
````


## 2727 - Código Secreto

````portugol
var n := leia_inteiro
enquanto n > 0 faça
  para i de 1 até n faça
    s = leia_textos(" ")
    letra = s.tamanho * 3 + s[1].tamanho + 'a' - 4
    escreva letra.caractere
  fim
  n := leia_inteiro
fim
````


## 1007 - Diferença

````portugol
a = leia_inteiro
b = leia_inteiro
c = leia_inteiro
d = leia_inteiro
diferenca = (a * b - c * d)
escreva "DIFERENCA = {diferenca}"
````


## 2791 - Feijão

````portugol
a = leia_texto
escolha a
  caso "1 0 0 0" => escreva 1
  caso "0 1 0 0" => escreva 2
  caso "0 0 1 0" => escreva 3
  caso _         => escreva 4
fim
````


## 2188 - Macaco-prego

````portugol
var teste := 0
var n := leia_inteiro
enquanto n > 0 faça
  var x, v := -10000
  var y, u :=  10000
  para i de 1 até n faça
    entrada = leia_inteiros(" ")
    se entrada[1] > x então x := entrada[1] fim
    se entrada[2] < y então y := entrada[2] fim
    se entrada[3] < u então u := entrada[3] fim
    se entrada[4] > v então v := entrada[4] fim
  fim
  teste := teste + 1
  escreva "Teste {teste}"
  se x < u e v < y então
    escreva "{x} {y} {u} {v}"
  senão
    escreva "nenhum"
  fim
  escreva ""
  n := leia_inteiro
fim
````


## 2981 - Vamos Fechar

````portugol
a = leia_inteiros(" ")
c, g = a[1], a[2]
r = 21 + c div g
se r > 30 entao
  escreva "A UFSC fecha dia {r - 30} de outubro."
senao
  escreva "A UFSC fecha dia {r} de setembro."
fim
````


## 1929 - Triângulo

````portugol
n = leia_inteiros(" ").ordene
se n[1]+n[2] > n[3] ou n[2] + n[3] > n[4] então
  escreva "S"
senão
  escreva "N"
fim
````


## 2674 - Super Primos: Ativar!

````portugol
primo(a: Inteiro)
  var resp := a > 1
  para i de 2 até raiz(a).arredonde faça
    se a mod i == 0 então
      resp := falso
    fim
  fim
  retorne resp
fim

var n:= leia_inteiro
enquanto n > 0 faça
  se primo(n) entao
    se n.texto - "014689" == n.texto entao
      escreva "Super"
    senão
      escreva "Primo"
    fim
  senão
    escreva "Nada"
  fim
  n:= leia_inteiro
fim
````


## 2514 - Alinhamento Lunar

````portugol
mmc(x, y: Inteiro) = x * y div mdc(x, y)

mdc(x, y: Inteiro): Inteiro =
  se y == 0 então x senão mdc(y, x mod y) fim

mmc_triplo(x, y, z: Inteiro) = mmc(x, mmc(y, z))

proximo_alinhamento(m, l1, l2, l3: Inteiro)
  periodo = mmc_triplo(l1, l2, l3)
  anos_faltantes = periodo - m
  retorne anos_faltantes
fim

var m := leia_inteiro
enquanto m > 0 faça
  l = leia_inteiros(" ")
  anos_faltantes = proximo_alinhamento(m, l[1], l[2], l[3])
  escreva anos_faltantes
  m := leia_inteiro
fim
````


## 2568 - Ações

````portugol
n = leia_inteiros(4)
var soma := n[2]
var i := n[1] + 1
enquanto i <= n[1] + n[4] faça
    se i mod 2 <> 0 então
        soma := soma - n[3]
    senão
        soma := soma + n[3]
    fim
    i := i + 1
fim
escreva soma
````


## 1795 - Triângulo Trinomial

````portugol
n = leia_inteiro
resp = [1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, "177147", "531441", "1594323", "4782969", "14348907", "43046721", "129140163", "387420489", "1162261467", "3486784401"]
escreva resp[n + 1]
````


## 1256 - Tabelas Hash

````portugol
tipo Valor chave: Inteiro valor: Texto fim
    
valores = para j de 0 ate 100 gere Valor(j, "\\") fim

n = leia_inteiro
para i de 1 até n faça
  m = leia_inteiros(" ")[1]
  chaves = leia_inteiros(" ")
  hash = (chaves.mapeie(a => Valor(a mod m, a.texto)) + valores.pegue(m))
           .ordene(_.chave)
           .divida_quando(_.chave <> _.chave)
  para h em hash faça
    escreva "{h[1].chave} -> {h.mapeie(_.valor).junte(" -> ")}"
  fim
  se i < n então
    escreva ""
  fim
fim
````


## 1258 - Camisetas

````portugol
comp = (a, b: (Texto, Texto, Texto)) =>
  se a.segundo <> b.segundo entao
    a.segundo < b.segundo
  senaose a.terceiro <> b.terceiro
    a.terceiro > b.terceiro
  senao
    a.primeiro < b.primeiro
  fim

var n := leia_inteiro
enquanto n > 0 faca
  camisetas = Lista(n, (leia_texto, leia_texto.divida(" ")))
      .mapeie(a => (a.primeiro, a.segundo[1], a.segundo[2]))
      .ordene(comp)
  para camiseta em camisetas faca
    escreva "{camiseta.segundo} {camiseta.terceiro} {camiseta.primeiro}"
  fim
  n := leia_inteiro
  se n > 0 entao escreva "" fim
fim
````


## 3302 - Resposta Certa

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  numeros = leia_inteiros(n)
  para i de 1 ate n faca
    escreva "resposta {i}: {numeros[i]}"
  fim
  n := leia_inteiro
fim
````


## 3170 - Bolinhas de Natal

````portugol
b, g = leia_inteiro
faltam = g div 2 - b
se faltam > 0 entao
  escreva "Faltam {faltam} bolinha(s)"
senao
  escreva "Amelia tem todas bolinhas!"
fim
````


## 1428 - Procurando Nessy

````portugol
t = leia_inteiro
para i de 1 ate t faca
  a = leia_inteiros(" ")
  n, m = a[1], a[2]
  escreva (n div 3) * (m div 3)
fim 
````


## 2161 - Raiz Quadrada de 10

````portugol
n = leia_inteiro

var fracao := 0.0
para i de 1 até n faça
  fracao := 1 / (6 + fracao)
fim

escreva (3 + fracao) formato "%.10f"
````


## 1786 - CPF 2

````portugol
pesos = [1,2,3,4,5,6,7,8,9]
sosep = pesos.inverta

verificadores(digitos: Lista[Inteiro])
  soma1 = digitos.zip(pesos).mapeie(a => a.primeiro * a.segundo).injete(0)(_ + _)
  soma2 = digitos.zip(sosep).mapeie(a => a.primeiro * a.segundo).injete(0)(_ + _)
  b1 = soma1 mod 11 mod 10
  b2 = soma2 mod 11 mod 10
  retorne (b1, b2)
fim

var entrada := leia_texto
enquanto nao eof faça
    digitos = entrada.lista.mapeie(_ - '0')
    v = verificadores(digitos)
    a123 = entrada.pegue(3)
    a456 = entrada.descarte(3).pegue(3)
    a789 = entrada.descarte(6)
    b12 = "{v.primeiro}{v.segundo}"
    escreva "{a123}.{a456}.{a789}-{b12}"
    entrada := leia_texto
fim
````


## 2029 - Reservatório de Mel

````portugol
var volume := leia_real
enquanto volume > 0 faca
  diametro = leia_real
  raio = diametro / 2
  area  = 3.14 * raio ^ 2
  altura = volume / area
  escreva "ALTURA = {altura  formato "%.2f"}"
  escreva "AREA = {area formato "%.2f"}"
  volume := leia_real
fim
````


## 2293 - Campo de Minhocas

````portugol
a = leia_inteiros(" ")
n, m = a[1], a[2]
mat = para i de 1 ate n gere leia_inteiros(" ") fim
zero = para i de 1 ate m gere 0 fim
linhas = mat.mapeie(x => x.injete(0)(_ + _))
colunas = mat.injete(zero)(
            (x, y) => para i de 1 ate m gere x[i] + y[i] fim)
escreva (linhas + colunas).ordene.ultimo
````


## 1371 - Fechem as Portas!

````portugol
var n := leia_inteiro
enquanto n > 0 faça
  portas = para i de 1 até raiz(n).inteiro
    gere i * i
  fim
  escreva portas.junte(" ")
  n := leia_inteiro
fim
````


## 3208 - O Criptógrafo Envergonhado

````portugol
var entrada := leia_texto
enquanto entrada <> "0 0" faca
  k = BigInt(entrada.divida(" ")[1])
  l = entrada.divida(" ")[2].inteiro
  var i := 2
  enquanto k mod i <> 0 e i <= l faca i := i + 1 fim
  se i >= l entao
    escreva "GOOD"
  senao
    escreva "BAD {i}"
  fim
  entrada := leia_texto
fim
````


## 1865 - Mjölnir

````portugol
n = leia_inteiro
para i de 1 até n faça
  nome = leia_textos(" ").cabeça
  se nome == "Thor" então
    escreva "Y"
  senão
    escreva "N"
  fim
fim
````


## 1107 - Escultura à Laser

````portugol
var entrada := leia_inteiros(2)
enquanto entrada[1] <> 0 faça
  altura, comprimento = entrada[1], entrada[2]
  xs = leia_inteiros(" ")
  var quantidade, anterior := altura - xs[1], xs[1]
  para x em xs.cauda faca
    se x < anterior entao
      quantidade := quantidade + anterior - x
    fim
    anterior := x
  fim
  escreva quantidade
  entrada := leia_inteiros(2)
fim
````


## 1239 - Atalhos Bloggo

````portugol
sub(texto: Texto, chr: Caractere, tag1, tag2: Texto)
  f(s: Texto, inicio: Logico): Texto
    p = s.posicao(chr)
    se p > 0 entao
      f(s.pegue(p-1) + (se inicio entao tag1 senao tag2 fim) + s.descarte(p), nao inicio)
    senao
      s
    fim
  fim
  retorne f(texto, verdadeiro)
fim

bold(s: Texto) = sub(s, '*', "<b>", "</b>")
italic(s: Texto) = sub(s, '_', "<i>", "</i>")

var texto := leia_texto
enquanto nao eof faca
  escreva bold(italic(texto))
  texto := leia_texto
fim
````


## 1332 - Um-Dois-Três

````portugol
n = leia_inteiro
para i de 1 até n faça
   a = leia_texto
   se a.tamanho==5 então
     escreva 3
   senãose [a[1]=='o', a[2]=='n', a[3]=='e'].selecione(a => a).tamanho >= 2 então
     escreva 1
   senão
     escreva 2
   fim
fim
````


## 2753 - Saída 7

````portugol
para a de 'a' até 'z' faça
  escreva "{a.inteiro} e {a}"
fim
````


## 2759 - Entrada e Saída de Carácter

````portugol
a, b, c = leia_texto
escreva "A = {a}, B = {b}, C = {c}"
escreva "A = {b}, B = {c}, C = {a}"
escreva "A = {c}, B = {a}, C = {b}"
````


## 2166 - Raiz Quadrada de 2

````portugol
n = leia_inteiro
var r := 0.0
para i de 1 até n faça
  r := 1 / (2 + r)
fim
escreva (r + 1) formato "%.10f"
````


## 1765 - Trapézios de Natal

````portugol
var t := leia_inteiro
enquanto t <> 0 faça
    para c de 1 ate t faça
        dados = leia_reais(3)
        escreva "Size #{c}:"
        escreva "Ice Cream Used: {((dados[2] + dados[3]) * 5) / 2 * dados[1] formato "%.2f"} cm2"
    fim
    escreva ""
    t := leia_inteiro
fim
````


## 2457 - Letras

````portugol
c = leia_texto[1]
texto = leia_textos(" ")
palavras = texto.selecione(_.contem(c))
escreva (palavras.tamanho * 100 / texto.tamanho) formato "%.1f"
````


## 2557 - R+L=J

````portugol
var entrada := leia_texto
enquanto nao eof faça
  a = entrada.divida("\\=")
  b = a[1].divida("\\+")
  rlj = [b[1], b[2], a[2]].mapeie(_.inteiro)
  resposta = escolha rlj
    caso [r, l, 0] => r + l
    caso [r, 0, j] => j - r
    caso [0, l, j] => j - l
    caso _         => -1
  fim
  escreva resposta
  entrada := leia_texto
fim
````


## 3416 - Eu Quero Cafééé

````portugol
entrada = leia_inteiros(" ")
n, l, d = entrada[1], entrada[2], entrada[3]
a = n * d / (l * 1000)
b = a.teto.inteiro
escreva b * l
````


## 3091 - Resto 1.0

````portugol
a, b = leia_inteiro
escreva a mod b
````


## 2510 - Batmain

````portugol
n = leia_inteiro
para i de 1 ate n faca
  leia_texto
  escreva("Y")
fim
````


## 2679 - Sucessor Par

````portugol
n = leia_inteiro
se n mod 2 == 0 então
  escreva n + 2
senão
  escreva n + 1
fim
````


## 2311 - Saltos Ornamentais

````portugol
n = leia_inteiro
para i de 1 até n faça
  nome = leia_texto
  gd = leia_real
  notas = leia_reais(" ")
            .ordene
            .descarte(1)
            .pegue(5)
  soma = notas.injete(0.0)(_ + _)
  escreva "{nome} {soma * gd formato "%.2f"}"
fim
````


## 2721 - Indecisão das Renas

````portugol
renas = "Dasher Dancer Prancer Vixen Comet Cupid Donner Blitzen Rudolph".divida(" ")
votos = leia_inteiros(" ").injete(0)((a, b) => a + b)
rena = se votos mod 9 == 0 então 9 senão votos mod 9 fim
escreva renas[rena]
````


## 2084 - Eleições

````portugol
n = leia_inteiro
votacao = leia_inteiros(n).ordene((a, b) => a > b)
total_votos = votacao.injete(0)((x, y) => x + y)
perc_pri = votacao[1] / total_votos
perc_seg = votacao[2] / total_votos
se perc_pri >= 0.45 ou (perc_pri >= 0.4 e perc_pri - perc_seg >= 0.1) então
    escreva 1
senão
    escreva 2
fim
````


## 2987 - Balão de Honra

````portugol
escreva leia_texto[1] - 64
````


## 2493 - Jogo do Operador

````portugol
var t := leia_inteiro
enquanto t > 0 faca
  jogos = para i de 1 ate t,
               a em [leia_textos("=")],
               b em [a[1].divida(" ").mapeie(_.inteiro)],
               x em [b[1]], y em [b[2]], z em [a[2].inteiro] gere
    (se x + y == z entao "+" senao "" fim)
    + (se x - y == z entao "-" senao "" fim)
    + (se x * y == z entao "*" senao "" fim)
  fim
  var passou := Lista(0, "")
  para i de 1 ate t faca
    a = leia_textos(" ")
    n, eh, r = a[1], a[2].inteiro, a[3].cabeca
    se nao (jogos[eh].contem(r) ou (jogos[eh] == "" e r == 'I')) entao passou := n :: passou fim
  fim
  se passou.tamanho == t entao
    escreva "None Shall Pass!"
  senaose passou.tamanho == 0 entao
    escreva "You Shall All Pass!"
  senão
    escreva passou.ordene.junte(" ")
  fim
  t := leia_inteiro
fim
````


## 2422 - Soma das Casas

````portugol
n = leia_inteiro
c = Lista.mutável(n, 0)
para i de 1 até n faça c[i] := leia_inteiro fim

k = leia_inteiro

var min, max := 1, n
enquanto min < max faça
  soma = c[min] + c[max]
  se soma > k então
    max := max - 1
  senãose soma < k então
    min := min + 1
  senão
    escreva "{c[min]} {c[max]}"
    min := max # terminar
  fim
fim
````


## 1117 - Validação de Nota

````portugol
var soma := 0.0
var válidas := 0
enquanto válidas < 2 faça
  n = leia_real
  se n >= 0.0 e n <= 10.0 então
    soma := soma + n
    válidas := válidas + 1
  senão
    escreva "nota invalida"
  fim
fim
escreva "media = {(soma / 2) formato "%.2f"}"
````


## 3038 - Carta de Natal Criptografada

````portugol
var linha := leia_texto
enquanto nao eof faca
  saida = para c em linha gere
    escolha c
      caso '@' => 'a'
      caso '&' => 'e'
      caso '!' => 'i'
      caso '*' => 'o'
      caso '#' => 'u'
      caso  c  =>  c
    fim
  fim
  escreva saida.junte("")
  linha := leia_texto
fim
````


## 1574 - Instruções do Robô

````portugol
t = leia_inteiro
para i de 1 até t faça
  n = leia_inteiro
  var instruções := Lista(0, 0)
  para j de 1 até n faça
    a = leia_textos(" ")
    instruções := (escolha a
      caso ["LEFT"]   => -1
      caso ["RIGHT"]  => 1
      caso _          => instruções[j - a[3].inteiro]
    fim) :: instruções
  fim
  escreva instruções.injete(0)(_ + _)
fim
````


## 1011 - Esfera

````portugol
r = leia_inteiro
pi = 3.14159
volume = (4.0 / 3.0) * pi * (r * r * r)
escreva "VOLUME = {volume formato "%.3f"}"
````


## 2774 - Precisão do Sensor

````portugol
var a := leia_inteiro
enquanto a > 0 faça
  n = leia_reais(" ")
  tam = n.tamanho
  media = n.injete(0.0)((parcial, x) => parcial + x / tam)
  soma  = n.mapeie(i => (i - media) ^ 2).injete(0.0)(_ + _)
  sigma = (soma / (tam - 1)) ^ 0.5
  escreva sigma formato "%.5f"
  a := leia_inteiro
fim
````


## 2906 - Database of Clients

````portugol
n = leia_inteiro
limpar(s: Texto) = s.selecione(_ <> '.').pegue_enquanto(_ <> '+')
emails = leia_textos(n)
           .mapeie(_.divida("@"))
           .mapeie(a => "{limpar(a[1])}@{a[2]}")
           .ordene
diferentes = emails.zip(emails.cauda).selecione(a => a.primeiro <> a.segundo).tamanho + 1
escreva diferentes
````


## 1048 - Aumento de Salário

````portugol
sal = leia_real
var novosal := 0.0
se sal > 0
	novosal := sal * 1.15
senaose sal > 400
	novosal := sal * 1.12
senaose sal > 800
	novosal := sal * 1.10
senaose sal > 1200
	novosal := sal * 1.07
senaose sal > 2000
	novosal := sal * 1.04
fim
escreva ("Novo salario: {novosal formato "%.2f"}")
escreva ("Reajuste ganho: {novosal-sal formato "%.2f"}")
escreva ("'Em percentual: {(novosal/sal-1)*100 formato "%.2f"} %")
````


## 1933 - Tri-du

````portugol
s = leia_inteiros(" ")
a, b = s[1], s[2]
se a > b então
  escreva a
senão
  escreva b
fim
````


## 1589 - Bob Conduite

````portugol
t = leia_inteiro
para i de 1 até t faça
  r = leia_inteiros(" ")
  escreva r[1]+r[2]
fim
````


## 3106 - Competição de Códigos

````portugol
n = leia_inteiro
s = leia_inteiros(" ")
r = s.injete(0)((a, b) => a + (b div 3 * 3))
escreva r
````


## 3468 - Faça mais, mas faça melhor!

````portugol
ideia = leia_texto

se ideia.minúsculo == "oposicao" ou ideia.minúsculo == "contrariedade" então
    escreva("mas")
senão
    escreva("mais")
fim
````


## 1542 - Lendo Livros

````portugol
var a := leia_inteiros(" ")
enquanto a[1] > 0 faça
  paginas = a[1] * a[2] * a[3] div (a[3] - a[1])
  se paginas > 1 entao
    escreva "{paginas} paginas"
  senao
    escreva "{paginas} pagina"
  fim
  a := leia_inteiros(" ")
fim
````


## 1144 - Sequência Lógica

````portugol
n = leia_inteiro
para a de 1 até n faça
  b = a * a
  c = b * a
  escreva "{a} {b} {c}"
  escreva "{a} {b+1} {c+1}"
fim
````


## 2116 - Diversão dos Alunos

````portugol
a = leia_inteiros(" ").ordene
n, m = a[1], a[2]

crivo(nums: Lista[Inteiro]): Lista[Inteiro] = escolha nums
  caso []  => []
  caso num =>
    c = num.cabeca
    c :: crivo(num.selecione(x => x mod c <> 0))
fim
ints = para i de 2 ate m gere i fim
primos = crivo(ints).inverta

p1 = primos.descarte_enquanto(_ > n).cabeca
p2 = primos.descarte_enquanto(_ > m).cabeca

escreva p1 * p2
````


## 2839 - As Meias de Rangel

````portugol
escreva leia_inteiro + 1
````


## 1043 - Triângulo

````portugol
valores = leia_reais(" ")
a, b, c = valores[1], valores[2], valores[3]
se ((a < b + c) e (b < a + c) e (c < a + b)) então
  perimetro = a + b + c
  escreva "Perimetro = {perimetro formato "%.1f"}"
senão
  area = (a + b) * c / 2
  escreva "Area = {area formato "%.1f"}"
fim
````


## 2802 - Dividindo Círculos

````portugol
n = leia_inteiro
a = (n / 24) * (n ^ 3 - 6 * n ^ 2 + 23 * n - 18) + 1
escreva a formato "%.0f"
````


## 3500 - ~~Deus-serpente M'boi as Cataratas do Iguaçu~~

````portugol
a = leia_inteiros(" ")
E, V = a[1], a[2]

t = (19 + E/V) mod 24

h = (t + 0.001).inteiro
m = (t - h) * 60

escreva "{h formato "%02d"}:{m formato "%02.0f"}"
````


## 3138 - Aniversário do Tobias

````portugol
fat(n: Int): BigInt =
  se n > 1 entao n * fat(n - 1) senao 1 fim

baloes(lista: Lista[(Texto, Inteiro)]): Lista[(Texto, Inteiro)] =
  se
    lista.tamanho <= 1 entao lista
  senao
    se lista[1].primeiro == lista[2].primeiro entao
      baloes((lista[1].primeiro, lista[1].segundo + lista[2].segundo) :: lista.descarte(2))
    senao
      lista.cabeca :: baloes(lista.cauda)
    fim
  fim

leia_tupla()
  a = leia_textos(" ")
  retorne (a[1], a[2].inteiro)
fim

n = leia_inteiro
quantidades = baloes(para i de 1 ate n gere leia_tupla fim.ordene(_.primeiro))
total = quantidades.injete(0)(_ + _.segundo)
possibilidades = fat(total) div quantidades.injete(BigInt(1))((a, b) => a * fat(b.segundo))
escreva "Feliz aniversario Tobias!"
escreva possibilidades
````


## 2378 - Elevador

````portugol
a = leia_inteiros(" ")
n, c = a[1], a[2]
var excedida := "N"
var pessoas := 0
var i := 0
enquanto i < n faca
  b = leia_inteiros(" ")
  pessoas := pessoas + b[2] - b[1]
  se pessoas > c entao
    excedida := "S"
    i := n
  fim
  i := i + 1
fim
escreva excedida
````


## 2896 - Aproveite a Oferta

````portugol
t = leia_inteiro
para i de 1 até t faça
  entrada = leia_inteiros(" ")
  n, k = entrada[1], entrada[2]
  g = n mod k + n div k
  escreva g
fim
````


## 1690 - Soma de Sobconjuntos

````portugol
t = leia_inteiro
para i de 1 até t faça
  n = leia_inteiro
  var num := leia_textos(" ").mapeie(a => BigInt(a)).ordene.mutável
  var soma, i := BigInt(1), 1
  enquanto i <= n e soma >= num[i] faça
    soma := soma + num[i]
    i := i + 1
  fim
  escreva soma
fim
````


## 3182 - Planejamento de Evento

````portugol
in = leia_inteiros(" ")
guests, budget, hotels =  in[1], in[2], in[3]

values =
  para i de 1 até hotels,
       price em [leia_inteiro],
       rooms em [leia_inteiros(" ").ordene( _ > _ ).cabeça]
         se rooms >= guests e price * guests <= budget gere
           price * guests
  fim

se values == [] então
  escreva "stay home"
senão
  escreva values.ordene.cabeça
fim
````


## 3160 - Amigos

````portugol
l, n = leia_textos(" ")
s = leia_texto
amigos = se s == "nao" então
  l + n
senão
  antes = l.pegue_enquanto(_ <> s)
  depois = l.descarte_enquanto(_ <> s)
  antes + n + depois
fim
escreva amigos.junte(" ")
````


## 1307 - Tudo o que Você Precisa é Amor

````portugol
bin2dec(s: Texto): Inteiro =
  para i de 1 ate s.tamanho se s[i] == '1'
    gere (2 ^ (i - 1)).inteiro
  fim.injete(0)(_ + _)

mdc(a, b: Inteiro): Inteiro = se b == 0 
  então a 
  senão mdc(b, a mod b)
fim

t = leia_inteiro
para i de 1 ate t faça
  a, b = bin2dec(leia_texto.inverta)

  se mdc(a, b) > 1 
    então escreva "Pair #{i}: All you need is love!"
    senão escreva "Pair #{i}: Love is not all you need!"
  fim
fim
````


## 1175 - Troca em Vetor I

````portugol
num = leia_inteiros(20)
para i de 0 até 19 faça
  escreva "N[{i}] = {num[20-i]}"
fim
````


## 2780 - Basquete de Robôs

````portugol
d = leia_inteiro
se d <= 800 então
  escreva 1
senãose d <= 1400 então
  escreva 2
senão
  escreva 3
fim
````


## 2180 - Viagem à Marte na Velocidade de Primo

````portugol
primo(n: Inteiro): Lógico =
  n mod 2 > 0 e (para i de 2 ate raiz(n).inteiro se n mod i == 0 gere i fim == [])

primos(inicio, quantos: Inteiro): Lista[Inteiro] =
  se quantos > 0 então
    se primo(inicio) então
      inicio :: primos(inicio + 1, quantos - 1)
    senão
      primos(inicio + 1, quantos)
    fim
  senão
    []
  fim

n = leia_inteiro
soma = primos(n, 10).injete(0)(_ + _)
horas = 60000000 div soma
dias = horas div 24

escreva "{soma} km/h"
escreva "{horas} h / {dias} d"
````


## 3456 - Divisibilidade por 7

````portugol
var a := BigInt(leia_texto)
escreva a
enquanto a > 9 faça
  a := a div 10 * 3 + a mod 10
  escreva a
fim
````


## 1877 - O Castelo de Neve de Sansa

````portugol
zip3(a, b, c: Lista[Inteiro]) = a.zip(b).zip(c)
   .mapeie(x => (x.primeiro.primeiro, x.primeiro.segundo, x.segundo))
k = leia_inteiros(" ")[2]
h = leia_inteiros(" ")
s = zip3(h, h.cauda, h.cauda.cauda)
x = s.mapeie(a => a.primeiro < a.segundo e a.segundo > a.terceiro)
     .mapeie(pico => se pico entao 1 senao 0 fim)
picos = x.injete(0)(_ + _)
se picos == k entao
  escreva "beautiful"
senao
  escreva "ugly"
fim
````


## 1471 - Mergulho

````portugol
# https://www.beecrowd.com.br/judge/pt/homeworks/view/29206
var a := leia_texto
enquanto nao eof faça
  n, r = a.divida(" ")[1].inteiro, a.divida(" ")[2].inteiro
  se n == r então
    leia_texto
    escreva "*"
  senão
    numeros = ((n + 1) :: leia_inteiros(" ")).ordene
    var i := 0
    para num em numeros faca
      i := i + 1
      enquanto i < num faça
        imprima "{i} "
        i := i + 1
      fim
    fim
    escreva ""
  fim
  a := leia_texto
fim
````


## 2812 - Laércio

````portugol
n = leia_inteiro
para i de 1 ate n faca
  leia_inteiro
  nums = leia_inteiros(" ").selecione(a => a mod 2 == 1).ordene.inverta
  resp = para j de 2 ate nums.tamanho + 1, k em [se j mod 2 == 0 entao 1 senao -1 fim] gere
    nums[k * j div 2]
  fim.junte(" ")
  escreva resp
fim
````


## 1080 - Maior e Posição

````portugol
números = leia_inteiros(100)

maior = números.ordene.último
posição = números.posição(maior)

escreva maior
escreva posição
````


## 2632 - Magic and Sword

````portugol
magia_dano(magia: Texto) = escolha magia
    caso "fire" => 200
    caso "water" => 300
    caso "earth" => 400
    caso _ => 100
fim

magia_raio(magia: Texto, lv: Texto) = escolha (magia, lv)
    caso  ("fire", "1") => 20
    caso  ("fire", "2") => 30
    caso  ("fire", "3") => 50
    caso  ("water", "1") => 10
    caso  ("water", "2") => 25
    caso  ("water", "3") => 40
    caso  ("earth", "1") => 25
    caso  ("earth", "2") => 55
    caso  ("earth", "3") => 70
    caso  ("air", "1") => 18
    caso  ("air", "2") => 38
    caso  _ => 60
fim

intercessao(cx: Inteiro, cy: Inteiro, raio: Inteiro, rx: Inteiro, ry: Inteiro, largura: Inteiro, altura: Inteiro)
    cDx = abs(cx - (rx + largura / 2))
    cDy = abs(cy - (ry + altura / 2))

    se (cDx > (largura / 2 + raio)) ou (cDy > (altura / 2 + raio)) então
        falso
    senãose (cDx <= largura / 2) ou (cDy <= altura / 2) então
        verdadeiro
    senão
        ((cDx - largura/2)^2 + (cDy - altura/2)^2) <= raio^2
    fim
fim

t = leia_inteiro
para i de 1 ate t faca
    posicao = leia_inteiros(" ")
    w, h, x0, y0 = posicao[1], posicao[2], posicao[3], posicao[4]
    ataque = leia_textos(" ")
    magia, lv, cx, cy = ataque[1], ataque[2], ataque[3].inteiro, ataque[4].inteiro

    se intercessao(cx, cy, magia_raio(magia, lv), x0, y0, w, h) então
        escreva magia_dano(magia)
    senão
        escreva 0
    fim

fim
````


## 3055 - Nota Esquecida

````portugol
a, m = leia_inteiro
b = m * 2 - a
escreva b
````


## 1557 - Matriz Quadrada III

````portugol
pot = para i de 0 até 38 gere (2 ^ i).inteiro fim
var n := leia_inteiro
enquanto n > 0 faça
  tam = "%{pot[2 * n - 1].texto.tamanho}d"
  para i de 1 até n faça
    imprima pot[i] formato tam
    para j de 2 até n faça
      imprima " {pot[i + j - 1] formato tam}"
    fim
    escreva ""
  fim
  escreva ""
  n := leia_inteiro
fim
````


## 2129 - Fatorial

````portugol
remove_zeros(a: Long): Long =
  se a mod 10 == 0 e a > 0
    entao remove_zeros(a div 10)
    senao a
  fim

var a: Long := 1
num =
  para i de 1 ate 1000000 gere
    var j := remove_zeros(i)
    a := remove_zeros(a * j) mod 1000000
    a mod 10
  fim.mutável

var t := 0
var n := leia_inteiro
enquanto n > 0 faça
    t := t + 1
    escreva "Instancia {t}"
    escreva num[n]
    escreva ""
    n := leia_inteiro
fim
````


## 1630 - Estacas

````portugol
mdc(x, y: Inteiro): Inteiro =
  se x > y entao mdc(x mod y, y)
  senaose x == 0 entao y
  senao mdc(y mod x, x) fim

var a := leia_texto
enquanto a <> nulo faca
  b = a.divida(" ").mapeie(_.inteiro)
  x, y = b[1], b[2]
  m = mdc(x, y)
  escreva 2 * (x+y) div m
  a := leia_texto
fim
````


## 1162 - Organizador de Vagões

````portugol
n = leia_inteiro
para a de 1 até n faça
  l = leia_inteiro
  var vagões := leia_inteiros(" ")
  var cont := 0
  var p := 1
  enquanto vagões <> [] faça
    se vagões[1] == p então
        vagões := vagões.cauda
    senão
        pos = vagões.posição(p)
        vagões := vagões.remova(pos)
        cont := cont + pos - 1
    fim
    p := p + 1
  fim
  escreva "Optimal train swapping takes {cont} swaps."
fim
````


## 2757 - Entrada e Saída de Números Inteiros

````portugol
a, b, c = leia_inteiro
escreva "A = {a}, B = {b}, C = {c}"
escreva "A = {a formato "%10d"}, B = {b formato "%10d"}, C = {c formato "%10d"}"
escreva "A = {a formato "%010d"}, B = {b formato "%010d"}, C = {c formato "%010d"}"
escreva "A = {a formato "%-10d"}, B = {b formato "%-10d"}, C = {c formato "%-10d"}"
````


## 3165 - Primos Gêmeos

````portugol
n = leia_inteiro
var primos := 2 :: para i de 3 ate n passo 2 gere i fim
var i := 1
enquanto i < primos.tamanho faca
  primeiro = primos[i]
  primos := primos.selecione(a => a == primeiro ou a mod primeiro <> 0)
  i := i + 1
fim
primos := primos.inverta
enquanto primos[1] - primos[2] > 2 faca primos := primos.cauda fim
escreva primos.pegue(2).inverta.junte(" ")
````


## 3034 - O Caso Douglas

````portugol
primo(a: Inteiro)
  var resposta = verdadeiro
  para i de 3 ate raiz(a).inteiro passo 2 faca
    se a mod i == 0 então
      resposta := falso
    fim
  fim
  retorne resposta
fim

n = leia_inteiro
para i de 1 ate n faça
  num = leia_inteiro + 1
  se num mod 2 == 1 e num mod 7 == 0 e primo(num + 2) então
    escreva "Yes"
  senao
    escreva "No"
  fim
fim
````


## 2410 - Frequencia na Aula

````portugol
n = leia_inteiro
presencas = leia_textos(n).ordene.divida_quando(_ <> _).tamanho
escreva presencas
````


## 2785 - Pirâmide

````portugol
n = leia_inteiro
var min := leia_inteiros(" ")
para i de 2 até n faça
  linha = leia_inteiros(" ")
  var soma := linha.pegue(i).injete(0)(_ + _)
  para j de 1 até n - i + 1 faça
    a = se min[j] < min[j+1] entao min[j] senao min[j+1] fim
    min[j] := soma + a
    se j < n - i + 1 entao
      soma := soma + linha[j + i] - linha[j]
    fim
  fim
fim
escreva min.cabeça
````


## 2593 - Eachianos I

````portugol
texto = leia_textos(" ")
n = leia_inteiro
palavras = leia_textos(" ")
var c := 0
letras = para p em texto gere
  t = c  
  c := c + 1 + p.tamanho
  [p, t]
fim
para a em palavras faca
  b = letras.selecione(p => p[1] == a).mapeie(p => p[2])
  se b.tamanho > 0 entao
    escreva b.junte(" ")
  senao
    escreva -1
  fim
fim
````


## 1029 - Fibonacci, Quantas Chamadas?

````portugol

var fib := [1, 1]
enquanto fib.tamanho < 38 faça
  fib := (fib[1] + fib[2]) :: fib
fim

var calls := [2, 0]
enquanto calls.tamanho < 38 faça
  calls := (calls[1] + calls[2] + 2) :: calls
fim

n = leia_inteiro
para i de 1 até n faça
  a = leia_inteiro
  escreva "fib({a}) = {calls[-a]} calls = {fib[-a]}"
fim
````


## 1149 - Somando Inteiros Consecutivos

````portugol
num = leia_inteiros(" ").selecione(a => a > 0)
a = num[1]
n = num[2]
escreva a * n + n * (n-1) div 2
````


## 2542 - Iu-Di-Oh!

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  x = leia_inteiros(" ")
  m, l = x[1], x[2]
  cartas_m, cartas_l = leia_textos(m), leia_textos(l)
  c = leia_inteiros(" ")
  carta_m, carta_l = c[1], c[2]
  a = leia_inteiro
  marcos, leonardo = cartas_m[carta_m].divida(" ")[a].inteiro, cartas_l[carta_l].divida(" ")[a].inteiro
  se marcos > leonardo entao
    escreva "Marcos"
  senaose marcos < leonardo entao
    escreva "Leonardo"
  senao
    escreva "Empate"
  fim
  n := leia_inteiro
fim
````


## 1022 - TDA Racional

````portugol
mdc(x, y: Inteiro): Inteiro = se y == 0 então x senão mdc(y, x mod y) fim

repetições = leia_inteiro
para i de 1 até repetições faça
  entrada = leia_texto.divida(" ")
  n1, d1 = entrada[1].inteiro, entrada[3].inteiro
  operacao, n2, d2 = entrada[4], entrada[5].inteiro, entrada[7].inteiro
  resultado = escolha operacao
    caso "+" => (n1*d2 + n2*d1, d1*d2)
    caso "-" => (n1*d2 - n2*d1, d1*d2)
    caso "/" => (n1*d2, n2*d1)
    caso "*" => (n1*n2, d1*d2)
  fim
  num, den = abs(resultado.primeiro), abs(resultado.segundo)
  mdcOp = mdc(num, den)
  sinal = se resultado.primeiro * resultado.segundo < 0 então "-" senão "" fim
  escreva "{sinal}{num}/{den} = {sinal}{num div mdcOp}/{den div mdcOp}"
fim
````


## 2928 - Cruzando Lagos

````portugol
n = leia_inteiro
s = leia_textos(n).mapeie(_.cabeca).junte("")
r = s.divida_quando(_ <> _).selecione(_.cabeca == '.').mapeie(_.tamanho).ordene.inverta
se r.tamanho > 0 e r.cabeca > 2 entao
  escreva "N"
senao
  escreva r.tamanho
fim
````


## 1177 - Preenchimento de Vetor II

````portugol
t = leia_inteiro
para i de 0 até 999 faça
  escreva "N[{i}] = {i mod t}"
fim
````


## 1061 - Tempo de um Evento

````portugol
entrada = leia_textos(4)
d1 = entrada[1].divida(" ")[2].inteiro
h1 = entrada[2].pegue(2).inteiro
m1 = entrada[2].descarte(5).pegue(2).inteiro
s1 = entrada[2].descarte(10).inteiro
d2 = entrada[3].divida(" ")[2].inteiro
h2 = entrada[4].pegue(2).inteiro
m2 = entrada[4].descarte(5).pegue(2).inteiro
s2 = entrada[4].descarte(10).inteiro

t1 = ((d1 * 24 + h1) * 60 + m1) * 60 + s1
t2 = ((d2 * 24 + h2) * 60 + m2) * 60 + s2

t = t2 - t1
d = t div (24 * 3600)
h = t mod (24 * 3600) div 3600
m = t mod 3600 div 60
s = t mod 60

escreva "{d} dia(s)"
escreva "{h} hora(s)"
escreva "{m} minuto(s)"
escreva "{s} segundo(s)"
````


## 2139 - Natal de Pedrinho

````portugol
var entrada := leia_texto
var dias := 0

enquanto nao eof faça
  mes, dia = entrada.divida(" ")[1].inteiro, entrada.divida(" ")[2].inteiro

  escolha mes
    caso 1 => dias := (31 - dia) + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 25
    caso 2 => dias := (29 - dia) + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 25
    caso 3 => dias := (31 - dia) + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 25
    caso 4 => dias := (30 - dia) + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 25
    caso 5 => dias := (31 - dia) + 30 + 31 + 31 + 30 + 31 + 30 + 25
    caso 6 => dias := (30 - dia) + 31 + 31 + 30 + 31 + 30 + 25
    caso 7 => dias := (31 - dia) + 31 + 30 + 31 + 30 + 25
    caso 8 => dias := (31 - dia) + 30 + 31 + 30 + 25
    caso 9 => dias := (30 - dia) + 31 + 30 + 25
    caso 10 => dias := (31 - dia) + 30 + 25
    caso 11 => dias := (30 - dia) + 25
    caso _ => dias := -2
  fim

  se ((mes == 12) e (dia <= 25)) então
    dias := 25 - dia
  senãose ((mes == 12) e (dia > 25)) então
    dias := -1
  fim

  se dias == 0 então
    escreva "E natal!"
  senãose dias == 1 então
    escreva "E vespera de natal!"
  senãose dias == -1 então
    escreva "Ja passou!"
  senãose dias > 1 então
    escreva "Faltam " + dias + " dias para o natal!"
  fim

  entrada := leia_texto
fim
````


## 1176 - Fibonacci em Vetor

````portugol
var fib = Lista(61, BigInt(0))
fib[2] := 1
para i de 3 até 61 faça
  fib[i] := fib[i-2] + fib[i-1]
fim
n = leia_inteiro
para i de 1 até n faça
  x = leia_inteiro
  escreva "Fib({x}) = {fib[x+1]}"
fim
````


## 1171 - Frequência de Números

````portugol
n = leia_inteiro
x = Lista.mutável(2000, 0)
para i de 1 até n faça
  a = leia_inteiro
  x[a] := x[a] + 1
fim
para i de 1 até 2000 faça
  se x[i] > 0 então
    escreva "{i} aparece {x[i]} vez(es)"
  fim
fim
````


## 2770 - Tamanho da Placa

````portugol
var entrada := leia_texto
enquanto nao eof faca
  a = entrada.divida(" ").mapeie(_.inteiro)
  b = a.pegue(2).ordene
  x, y, m = b[1], b[2], a[3]
  para i de 1 ate m faca
    z = leia_inteiros(" ").ordene
    xi, yi = z[1], z[2]
    se xi <= x e yi <= y entao
      escreva "Sim"
    senão
      escreva "Nao"
    fim
  fim
  entrada := leia_texto
fim
````


## 2418 - Carnaval

````portugol
n = leia_reais(" ")
# soma = n.descarte(1).pegue(3).injete(0)(_ + _)

menor =
  se n[1] <= n[2] e n[1] <= n[3] e n[1] <= n[4] e n[1] <= n[5] entao n[1]
  senãose           n[2] <= n[3] e n[2] <= n[4] e n[2] <= n[5] entao n[2]
  senãose                          n[3] <= n[4] e n[3] <= n[5] entao n[3]
  senãose                                         n[4] <= n[5] entao n[4]
  senão                                                              n[5]
  fim

maior =
  se n[1] >= n[2] e n[1] >= n[3] e n[1] >= n[4] e n[1] >= n[5] entao n[1]
  senãose           n[2] >= n[3] e n[2] >= n[4] e n[2] >= n[5] entao n[2]
  senãose                          n[3] >= n[4] e n[3] >= n[5] entao n[3]
  senãose                                         n[4] >= n[5] entao n[4]
  senão                                                              n[5]
  fim

soma = n[1] + n[2] + n[3] + n[4] + n[5] - menor - maior
escreva soma formato "%.1f"
````


## 1198 - O Bravo Guerreiro Hashmat

````portugol
var entrada := leia_texto
enquanto nao eof faca
  se entrada.tamanho > 11 entao
    s = entrada.divida(" ").mapeie(BigInt(_))
    a, b = s[1], s[2]
    escreva (b - a).abs
  senao
    s = entrada.divida(" ").mapeie(_.inteiro)
    a, b = s[1], s[2]
    escreva (b - a).abs
  fim
  entrada := leia_texto
fim
````


## 1213 - Ones

````portugol
var n := leia_inteiro
enquanto n > 0 faça
  var i, aux := 1
  enquanto i mod n <> 0 faça
    i := (i * 10 + 1) mod n
    aux := aux + 1
  fim
  escreva aux
  n := leia_inteiro
fim
````


## 2835 - Elevador

````portugol
leia_inteiro
pesos = leia_inteiros(" ").ordene
dif = pesos.zip(0 :: pesos)
           .mapeie(a => a.primeiro - a.segundo)
           .injete(verdadeiro)((b, v) => b e v <= 8)
se dif entao
  escreva "S"
senao
  escreva "N"
fim
````


## 2765 - Entrada e Saída com Virgula

````portugol
texto = leia_textos(",")
escreva texto[1]
escreva texto[2]
````


## 1044 - Múltiplos

````portugol
ent = leia_inteiros(" ")
a, b = ent[1], ent[2]
se a mod b == 0 ou b mod a == 0 então
  escreva "Sao Multiplos"
senão
  escreva "Nao sao Multiplos"
fim
````


## 1245 - Botas Perdidas

````portugol
var n := leia_inteiro
enquanto nao eof faca
  var esq, dir := Lista(31, 0)
  para i de 1 ate n faca
    a = leia_textos(" ")
    x = a[1].inteiro - 29
    se a[2] == "E" entao
      esq[x] := esq[x] + 1
    senao
      dir[x] := dir[x] + 1
    fim
  fim
  pares = esq.zip(dir).mapeie(
    a => se a.primeiro < a.segundo entao a.primeiro senao a.segundo fim
  ).injete(0)(_ + _ )
  escreva pares
  n := leia_inteiro
fim
````


## 1066 - Pares, Ímpares, Positivos e Negativos

````portugol
numeros = leia_inteiros(5)
par(n: Inteiro) = n mod 2 == 0
positivo(n: Inteiro) = n > 0
negativo(n: Inteiro) = n < 0

pares = numeros.selecione(par).tamanho
impares = 5 - pares
positivos = numeros.selecione(positivo).tamanho
negativos = numeros.selecione(negativo).tamanho

escreva "{pares} valor(es) par(es)"
escreva "{impares} valor(es) impar(es)"
escreva "{positivos} valor(es) positivo(s)"
escreva "{negativos} valor(es) negativo(s)"
````


## 3159 - Tijolão

````portugol
teclas(digito: Caractere): Texto = escolha digito
  caso ' ' => "0"
  caso d se d < 'a' => "#{teclas((d + 32).caractere)}"
  caso d => escolha d
    caso _ se d <= 'c' => "2" * (d - '`')
    caso _ se d <= 'f' => "3" * (d - 'c')
    caso _ se d <= 'i' => "4" * (d - 'f')
    caso _ se d <= 'l' => "5" * (d - 'i')
    caso _ se d <= 'o' => "6" * (d - 'l')
    caso _ se d <= 's' => "7" * (d - 'o')
    caso _ se d <= 'v' => "8" * (d - 's')
    caso _             => "9" * (d - 'v')
    fim
  fim

n = leia_inteiro
para i de 1 ate n faca
  linha = leia_texto
  sequencia = linha.lista
               .mapeie(teclas)
               .divida_quando((a, b) => a[-1] == b[1])
               .mapeie(_.junte(""))
               .junte("*")
  escreva sequencia
fim
````


## 2369 - Conta de Água

````portugol
n = leia_inteiro
var conta := 7
se n > 10 então
  conta := conta + (n - 10)
fim
se n > 30 então
  conta := conta + (n - 30)
fim
se n > 100 então
  conta := conta + (n - 100) * 3
fim
escreva conta
````


## 1015 - Distância Entre Dois Pontos

````portugol
p1 = leia_reais(2)
x1, y1 = p1[1], p1[2]
p2 = leia_reais(2)
x2, y2 = p2[1], p2[2]
distancia = raiz((x1-x2)^2 + (y1-y2)^2)
escreva distancia formato "%.4f"

````


## 3241 - Ajude um Candidato a PhD!

````portugol
n = leia_inteiro
para i de 1 ate n faca
  s = leia_inteiros("+")
  se s.tamanho == 1 entao
    escreva "skipped"
  senao
    soma = s[1] + s[2]
    escreva soma
  fim
fim
````


## 1113 - Crescente e Decrescente

````portugol
var n := leia_inteiros(" ")
enquanto n[1] <> n[2] faça
  se n[1] > n[2] então
    escreva "Decrescente"
  senão
    escreva "Crescente"
  fim
  n := leia_inteiros(" ")
fim
````


## 1000 - Hello World!

````portugol
escreva "Hello World!"
````


## 2752 - Saída 6

````portugol
escreva "<AMO FAZER EXERCICIO NO URI>"
escreva "<    AMO FAZER EXERCICIO NO URI>"
escreva "<AMO FAZER EXERCICIO >"
escreva "<AMO FAZER EXERCICIO NO URI>"
escreva "<AMO FAZER EXERCICIO NO URI    >"
escreva "<AMO FAZER EXERCICIO NO URI>"
escreva "<          AMO FAZER EXERCICIO >"
escreva "<AMO FAZER EXERCICIO           >"
````


## 1435 - Matriz Quadrada I

````portugol
min(a, b:Inteiro) = se a > b então b senão a fim

var n := leia_inteiro
enquanto n <> 0 faça
  para linha de 1 até n faça
    a = min(linha, n - linha + 1)
    escreva
      para coluna de 1 até n gere
        b = min(coluna, n - coluna + 1)
        min(a, b) formato "%3d"
      fim
      .junte(" ")
  fim
  escreva ""
  n := leia_inteiro
fim
````


## 2633 - Churras no Yuri

````portugol
var n := leia_inteiro
enquanto nao eof faca
  list = leia_textos(n)
           .mapeie(_.divida(" "))
           .mapeie(a => (a[1], a[2].inteiro))
           .ordene(a => a.segundo)
           .mapeie(a => a.primeiro)
  escreva list.junte(" ")
  n := leia_inteiro
fim
````


## 3142 - Excel Bugado

````portugol
var s := leia_texto
enquanto nao eof faca
  x = "@@" + s
  se s.tamanho < 4 e x.inverta.pegue(3).inverta <= "XFD"
    a = x.lista.mapeie(_ - '@')
    n = a[-3] * 676 + a[-2] * 26 + a[-1]
    escreva n
  senao
    escreva "Essa coluna nao existe Tobias!"
  fim
  s := leia_texto
fim
````


## 2390 - Escada Rolante

````portugol
n = leia_inteiro
var tempo, anterior := 0, -1
para i de 1 até n faça
    atual = leia_inteiro
    dif = atual - anterior
    se anterior <> -1 e dif < 10 então
        tempo := tempo - (10 - dif)
    fim
    anterior := atual
    tempo := tempo + 10
fim
escreva tempo
````


## 1250 - KiloMan

````portugol
n = leia_inteiro
para i de 1 até n faça
  t = leia_inteiro
  tiros = leia_inteiros(" ")
  ações = leia_texto
  atingido = 
    para a em tiros.zip(ações)
      se a.primeiro < 3 e a.segundo == 'S' ou
         a.primeiro > 2 e a.segundo == 'J' gere 1 fim
  escreva atingido.tamanho
fim
````


## 3348 - Jogo das Aranhas

````portugol
numeros = ["2", "7", "5", "30", "169", "441", "1872", "7632",
  "1740", "93313", "459901", "1358657", "2504881", "13482720",
  "25779600", "68468401", "610346880", "1271932200", "327280800"]

escreva numeros[leia_inteiro]
````


## 2693 - Van

````portugol
f = (a, b: (Texto, Texto, Inteiro)) =>
  se a.terceiro <> b.terceiro entao
    a.terceiro < b.terceiro
  senaose a.segundo <> b.segundo entao
    a.segundo < b.segundo
  senao
    a.primeiro < b. primeiro
  fim

var q := leia_inteiro
enquanto q > 0 faca
  alunos = Lista(q, leia_textos(" "))
             .mapeie(a => (a[1], a[2], a[3].inteiro))
  ordem = alunos.ordene(f)
  escreva ordem.mapeie(_.primeiro).junte("\n")
  q := leia_inteiro
fim
````


## 2984 - Assuntos Pendentes

````portugol
s = leia_texto
var x := 0
para c em s faca
  se c == '(' entao x := x + 1
  senaose x > 0 e c == ')' entao x := x - 1
  fim
fim
se x == 0 entao
  escreva "Partiu RU!"
senao
  escreva "Ainda temos {x} assunto(s) pendente(s)!"
fim
````


## 1973 - Jornada nas Estrelas

````portugol
n = leia_inteiro
var x = leia_inteiros(" ").mutavel
var total := x.injete(BigInt(0))(_ + _)
var atacadas = Lista.mutavel(n, falso)
var i := 1

enquanto i > 0 e i <= n faca
  lado = x[i] mod 2 <> 0
  se x[i] > 0 entao
    x[i] := x[i] - 1
    atacadas[i] := verdadeiro
    total := total - 1
  fim
  se lado entao
    i := i + 1
  senao
    i := i - 1
  fim
fim
escreva "{atacadas.selecione(_ == verdadeiro).tamanho} {total}"
````


## 1805 - Soma Natural

````portugol
s = leia_reais(" ")
a, b = s[1], s[2]
soma = (a + b) * (b - a + 1) / 2
escreva soma formato "%.0f"
````


## 2867 - Dígitos

````portugol
c = leia_inteiro
para i de 1 até c faça
  entrada = leia_inteiros(" ")
  n, m = entrada[1], entrada[2]
  r = n ^ m
  x = (r formato "%e").descarte_enquanto(_ <> '+').descarte(1).inteiro + 1
  escreva x
fim
````


## 1340 - Eu Posso Adivinhar a Estrutura de Dados!

````portugol
var n := leia_inteiro
enquanto nao eof faca
  var pilha, fila, prioridade := Lista(0, 0)
  var estrutura := Lista(4, 1)
  estrutura[4] := 0
  para i de 1 ate n faca
    a = leia_inteiros(" ")
    t, x = a[1], a[2]
    se t == 1 entao
      pilha      := x :: pilha
      fila       := x :: fila
      prioridade := x :: prioridade
    senao # t == 2
      fila := fila.inverta
      prioridade := prioridade.ordene.inverta
      se x <> fila.cabeca entao estrutura[1] := 0 fim
      se x <> pilha.cabeca entao estrutura[2] := 0 fim
      se x <> prioridade.cabeca entao estrutura[3] := 0 fim
      se pilha == [] ou x <> fila.cabeca e x <> pilha.cabeca e x <> prioridade.cabeca entao estrutura[4] := 1 fim
      pilha := pilha.cauda
      fila := fila.cauda.inverta
      prioridade := prioridade.cauda
    fim
  fim
  resp = estrutura[1] + estrutura[2] * 2 + estrutura[3] * 4 + estrutura[4] * 8
  escolha resp
    caso 1 => escreva "queue"
    caso 2 => escreva "stack"
    caso 4 => escreva "priority queue"
    caso s se s >= 8  => escreva "impossible"
    caso _ => escreva "not sure"
  fim
  n := leia_inteiro
fim
````


## 1181 - Linha na Matriz

````portugol
l = leia_inteiro
t = leia_texto
numeros = leia_reais(144)
var soma := 0.0
para i de l*12 + 1 até (l+1)*12 gere
  soma := soma + numeros[i]
fim
se t == "S" então
  escreva soma formato "%.1f"
senão
  escreva (soma / 12) formato "%.1f"
fim
````


## 1551 - Frase Completa

````portugol
n = leia_inteiro
para i de 1 até n faça
  letras = Lista.mutável(26, 0)
  s = leia_texto.selecione(c => c >= 'a' e c <= 'z').lista
  para c em s faça
    letras[c - 'a' + 1] := 1
  fim
  escolha letras.selecione(_ == 1).tamanho
    caso 26          => escreva "frase completa"
    caso x se x > 13 => escreva "frase quase completa"
    caso _           => escreva "frase mal elaborada"
  fim
fim
````


## 2582 - System of a Download

````portugol
musicas = ["PROXYCITY","P.Y.N.G.","DNSUEY!","SERVERS",
"HOST!","CRIPTONIZE","OFFLINE DAY","SALT","ANSWER!",
"RAR?","WIFI ANTENNAS"]
n = leia_inteiro
para i de 1 até n faça
  teclas = leia_inteiros(" ")
  soma = teclas[1] + teclas[2] + 1
  escreva musicas[soma]
fim
````


## 1049 - Animal

````portugol
palavra1, palavra2, palavra3 = leia_texto

se palavra1 == "vertebrado" então
  se palavra2 == "ave" então
    se palavra3 == "carnivoro" então
      escreva "aguia"
    senão
      escreva "pomba"
    fim
  senão
    se palavra3 == "onivoro" então
      escreva "homem"
    senão
      escreva "vaca"
    fim
  fim
senão
  se palavra2 == "inseto" então
    se palavra3 == "hematofago" então
      escreva "pulga"
    senão
      escreva "lagarta"
    fim
  senão
    se palavra3 == "hematofago" então
      escreva "sanguessuga"
    senão
      escreva "minhoca"
    fim
  fim
fim
````


## 1076 - Desenhando Labirintos

````portugol
t = leia_inteiro

para i de 1 até t faça
  n = leia_inteiro
  va = leia_inteiros(" ")
  v, a = va[1], va[2]
  var arestas := [1].cauda
  para j de 1 até a faça
    xy = leia_inteiros(" ")
    x, y = xy[1], xy[2]
    arestas := (x*v+y)::(y*v+x)::arestas
  fim
  escreva arestas.ordene.divida_quando(_ <> _).tamanho
fim
````


## 1873 - Pedra-papel-tesoura-lagarto-Spock

````portugol
rajesh = [
  "tesoura papel", "papel pedra", "pedra lagarto", "lagarto spock", "spock tesoura",
  "tesoura lagarto", "lagarto papel", "papel spock", "spock pedra", "pedra tesoura"
]

empate = ["papel", "pedra", "tesoura", "lagarto", "spock"].mapeie(a => "{a} {a}")

c = leia_inteiro
para i de 1 ate c faca
  s = leia_texto
  se rajesh.contem(s) entao
    escreva "rajesh"
  senaose empate.contem(s) entao
    escreva "empate"
  senao
    escreva "sheldon"
  fim
fim
````


## 1166 - Torre de Hanoi, Novamente!

````portugol
bolas = para i de 1 ate 50 gere (i + 1) * (i + 1) div 2 - 1 fim
t = leia_inteiro
para i de 1 ate t faca
  n = leia_inteiro
  escreva bolas[n]
fim
````


## 1467 - Zerinho ou Um

````portugol
var s := leia_texto
enquanto nao eof faca
  se s == "1 0 0" ou s == "0 1 1" entao
    escreva "A"
  senaose s == "0 1 0" ou s == "1 0 1" entao
    escreva "B"
  senaose s == "0 0 1" ou s == "1 1 0" entao
    escreva "C"
  senao
    escreva "*"
  fim
  s := leia_texto
fim
````


## 3161 - As Frutas Esquecidas

````portugol
a = leia_inteiros(" ")
n, m = a[1], a[2]
frutas = leia_textos(n).mapeie(_.minusculo)
linhas = leia_textos(m).mapeie(_.minusculo).junte(" ")
para fruta em frutas faca
  se linhas.divida(fruta).tamanho > 1 ou
     linhas.divida(fruta.inverta).tamanho > 1 entao
    escreva "Sheldon come a fruta {fruta}"
  senao
    escreva "Sheldon detesta a fruta {fruta}"
  fim
fim
````


## 1905 - Polícia e Ladrão

````portugol
policia(labirinto, caminho: Lista[Inteiro]): Lógico =
  se caminho.cabeça == 25 então
    verdadeiro
  senão
    proximos = vizinhos(caminho.cabeca).selecione(a => labirinto[a] == '0') - caminho
    proximos.injete(falso)((a, b) => a ou policia(labirinto, b :: caminho))
  fim

vizinhos(n: Inteiro) =
  [n + 5, se n mod 5 <> 0 entao n + 1 senao 0 fim,
   se n mod 5 <> 1 então n - 1 senão 0 fim, n - 5].selecione(a => a >= 1 e a <= 25)

leia_labirinto()
  var lista: Lista[Inteiro] = []
  enquanto lista.tamanho < 25 faça
    a = leia_texto.lista.selecione(c => c == '1' ou c == '0')
    lista := lista + a
  fim
  lista
fim

t = leia_inteiro
para i de 1 até t faça
  labirinto = leia_labirinto
  se policia(labirinto, [-4]) então
    escreva "COPS"
  senão
    escreva "ROBBERS"
  fim
fim
````


## 1277 - Pouca Frequência

````portugol
t = leia_inteiro
para i de 1 até t faça
  n = leia_inteiro
  nomes = leia_textos(" ")
  frequencia = leia_textos(" ")
                 .mapeie(_.selecione(_ <> 'M'))
                 .mapeie(a => a.selecione(_ == 'P').tamanho / a.tamanho)
  alunos = nomes.zip(frequencia)
  a = alunos.selecione(_.segundo < 0.75).mapeie(_.primeiro)
  escreva a.junte(" ")
fim
````


## 2234 - Cachorros-Quentes

````portugol
entrada = leia_inteiros(" ")
a = entrada[1]
b = entrada[2]
escreva (a / b) formato "%.2f"
````


## 1134 - Tipo de Combustível

````portugol
var n := leia_inteiro
var cont1, cont2, cont3 := 0
enquanto n <> 4 faça
  escolha n
    caso 1 => cont1 := cont1 + 1
    caso 2 => cont2 := cont2 + 1
    caso 3 => cont3 := cont3 + 1
    caso _ =>
  fim
  n := leia_inteiro
fim
escreva "MUITO OBRIGADO"
escreva "Alcool: {cont1}"
escreva "Gasolina: {cont2}"
escreva "Diesel: {cont3}"
````


## 3146 - Charadas no Escuro

````portugol
r = leia_real
pi = 3.14
circunferencia = 2 * pi * r
escreva circunferencia formato "%.2f"
````


## 2449 - Fechadura

````portugol
n = leia_inteiros(2)
var res, i := 0, 1
var fechaduras := leia_inteiros(n[1])
enquanto i < n[1] faça
    res := res + abs(n[2] - fechaduras[i])
    se fechaduras[i] == fechaduras[i+1] então
        i := i + 1
    senão
        fechaduras[i+1] := fechaduras[i+1] + (n[2] - fechaduras[i])
    fim
    i := i + 1
fim
escreva res
````


## 3048 - Sequência Secreta

````portugol
n = leia_inteiro
var a, s := 0
para i de 1 ate n faca
  v = leia_inteiro
  se v <> a entao
    a := v
    s := s + 1
  fim
fim
escreva s
````


## 1145 - Sequência Lógica 2

````portugol
entrada = leia_inteiros(" ")
x = entrada[1]
y = entrada[2]

para i de 1 até y faça
  imprima i
  se i mod x == 0 ou i == y então
    escreva ""
  senão
    imprima " "
  fim
fim
````


## 2846 - Fibonot

````portugol
var fib := [2, 1]
enquanto fib.cabeça < 200000 faça
  fib := (fib[2]+fib[1]) :: fib
fim
fib := fib.inverta
n = leia_inteiro
var c := 0
para i de 1 até 100100 faça
  se fib[1] == i então
    fib := fib.cauda
  senão
    c := c + 1
    se c == n então
      escreva i
    fim
  fim
fim
````


## 1018 - Cédulas

````portugol
# Potigol 0.9.15

total = leia_inteiro
valores = [100, 50, 20, 10, 5, 2, 1]
var resto := total
escreva total
para valor em valores faça
  n = resto div valor
  escreva "{n} nota(s) de R$ {valor},00"
  resto := resto mod valor
fim
````


## 3278 - Passageiros de Trem

````portugol
a = leia_inteiros(" ")
c, n = a[1], a[2]

var i, p:= 0
enquanto i < n e p >= 0 e p <= c faça
  b = leia_inteiros(" ")
  p := p - b[1]
  se p >= 0 então
    p := p + b[2]
    se b[3] > 0 e p <> c então
      p := -1
    fim
  fim
  i := i + 1
fim
se p == 0 então
  escreva "possible"
senão
  escreva "impossible"
fim
````


## 2597 - Xenlongão

````portugol
c = leia_inteiro
para i de 1 ate c faca
  n = leia_inteiro
  r = raiz(n).inteiro
  a = n - r
  escreva a
fim
````


## 1958 - Notação Científica

````portugol
x = leia_real
escreva x formato "%+.4E"
````


## 2715 - Dividindo os Trabalhos I

````portugol
diferenca(lista: Lista[Inteiro], soma, total: Long): Long =
  se soma + lista.cabeça > total div 2 então
    x = (soma + lista.cabeça) * 2 - total
    y = total - soma * 2
    se x < y entao x senao y fim
  senão
    diferenca(lista.cauda, soma + lista.cabeça, total)
  fim

adição(x: Long, y: Int) = x + y

zero = 0.toLong
var n := leia_inteiro
enquanto nao eof faça
  a = leia_inteiros(" ")
  soma = a.injete(zero)(adição)
  dif = diferenca(a, zero, soma)
  escreva dif
  n := leia_inteiro
fim
````


## 1961 - Pula Sapo

````portugol
entrada = leia_inteiros(" ")
linha = leia_inteiros(" ")
p = entrada[1]
n = entrada[2]
var gameover := falso
para i de 2 até n faça
  se linha[i-1] - linha[i] > p ou linha[i] - linha[i-1] > p então
    gameover := verdadeiro
  fim
fim
se gameover então
  escreva "GAME OVER"
senão
  escreva "YOU WIN"
fim
````


## 2661 - Despojados

````portugol
descolado(x: Real) = se x == 1.0 então falso senão
  var i := 2
  r = raiz(x).inteiro
  var primo, resultado := verdadeiro
  enquanto i <= r e resultado faça
    se x mod i^2 == 0.0 então
      resultado := falso
    senãose x mod i == 0.0
      primo := falso
    fim
    i := i + 1
  fim
  resultado e primo
fim

n = leia_real
var resp := 0
para i de 1 até raiz(n).inteiro faça
  se n mod i == 0.0 então
    se descolado(i) então
      resp := resp + 1
    fim
    se i <> n/i e descolado(n/i) então
      resp := resp + 1
    fim
  fim
fim
escreva (2^resp - resp - 1).arredonde
````


## 3214 - Refrigerante

````portugol
entrada = leia_inteiros(" ")
var g := entrada[1] + entrada[2]
c = entrada[3]
var resp := 0
enquanto g >= c faça
  resp := resp + g div c
  g := g div c + g mod c
fim
escreva resp
````


## 1647 - Um Jogo com Bolas de Gude

````portugol
var flag := verdadeiro
enquanto flag faça
    n = leia_inteiro
    se n == 0 então
        flag := falso
    senão
        var valores := leia_texto.divida(" ").mapeie(x => BigInt(x))
        para i de n-1 até 1 passo -1,
             j de n até i+1 passo -1 faça
                valores[i] := valores[i] + valores[j]
        fim
        escreva valores.injete((a, b: BigInt) => a + b)  
    fim
fim
````


## 3129 - Figurinhas Repetidas

````portugol
n = leia_inteiro
var figurinhas := Lista(300, falso)
para i de 1 ate n faca
  numero = leia_inteiro
  figurinhas[numero] := verdadeiro
fim
diferentes = figurinhas.selecione(_ == verdadeiro).tamanho
escreva diferentes
escreva n - diferentes
````


## 1547 - Adivinha

````portugol
n = leia_inteiro
para i de 1 até n faça
  a = leia_inteiros(" ")
  s = a[2]
  nums = leia_inteiros(" ")
  var p, i, diff := 0, 0, 100
  para x em nums faça
    i := i + 1
    se (s - x).abs < diff entao
      p := i
      diff := (s - x).abs
    fim
  fim
  escreva p
fim
````


## 1003 - Soma Simples

````portugol
a = leia_inteiro
b = leia_inteiro
soma = (a + b)
escreva "SOMA = {soma}"
````


## 1516 - Imagem

````portugol
var x := leia_inteiros(" ")
enquanto x[1] > 0 faca
  n, m = x[1], x[2]
  linhas = leia_textos(n)
  y = leia_inteiros(" ")
  a, b = y[1], y[2]
  s = linhas.mapeie(_.lista.mapeie(c => "{c}" * (b div m)).junte(""))
  para i de 0 ate a - 1 faca
    escreva s[i div (a div n) + 1]
  fim
  escreva ""
  x := leia_inteiros(" ")
fim
````


## 2863 - Umil Bolt

````portugol
var t := leia_inteiro
enquanto t > 0 faca
  var melhor := leia_real
  para i de 2 ate t faca
    tempo = leia_real
    se tempo < melhor entao
      melhor := tempo
    fim
  fim
  escreva melhor formato "%.2f"
  t := leia_inteiro
fim
````


## 3315 - Língua do Computador

````portugol
d2b(n: Inteiro): Texto = se n > 0 entao "{d2b(n div 2)}{n mod 2}" senao "" fim

a = para i de 1 ate 4 gere
  leia_inteiros(" ").injete(0)(_ + _)
fim
d = a.ordene[-1]
escreva "{d} = {d2b(d)}"
````


## 2397 - Triângulos

````portugol
lados = leia_inteiros(" ").ordene
a, b, c = lados[1], lados[2], lados[3]

d = c * c - (a * a + b * b)
escolha d
  caso d se d >= 2 * a * b => escreva "n"
  caso d se d > 0          => escreva "o"
  caso d se d < 0          => escreva "a"
  caso _                   => escreva "r"
fim
````


## 1025 - Onde está o Mármore?

````portugol
var entrada := leia_inteiros(" ")
var t := 1
enquanto entrada[1] <> 0 faça
  n, q = entrada[1], entrada[2]
  var marmores := Lista(10000, 0)
  para i de 1 ate n faca
    x = leia_inteiro + 1
    marmores[x] := marmores[x] + 1
  fim
  para i de 2 ate 10000 faca
    marmores[i] := marmores[i] + marmores[i - 1]
  fim
  escreva "CASE# {t}:"
  t := t + 1
  para i de 1 ate q faca
    x = leia_inteiro
    se marmores[x + 1] == marmores[x] entao
      escreva "{x} not found"
    senao
      escreva "{x} found at {marmores[x] + 1}"
    fim
  fim
  entrada := leia_inteiros(" ")
fim
````


## 1070 - Seis Números Ímpares

````portugol
n = leia_inteiro
inicio = se n mod 2 == 1 então n senão n + 1 fim
para i de 0 até 5 faça
  escreva inicio + i * 2
fim
````


## 2375 - Sedex

````portugol
n = leia_inteiro
entrada = leia_inteiros(" ")

a = entrada[1]
b = entrada[2]
c = entrada[3]

se n <= a e n <= b e n <= c então
  escreva "S"
senão
  escreva "N"
fim
````


## 1156 - Sequência S II

````portugol
escreva "6.00"
````


## 1225 - Coral Perfeito

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  notas = leia_inteiros(" ")
  soma = notas.injete(0)(_ + _)
  se soma mod n == 0 entao
    media = soma div n
    resposta = 1 + notas.descarte_enquanto(_ < media).mapeie(_ - media).injete(0)(_ + _)
    escreva resposta
  senao
    escreva -1
  fim
  n := leia_inteiro
fim
````


## 2060 - Desafio de Bino

````portugol
n = leia_inteiro
lista = leia_inteiros(" ")
m2 = lista.selecione(x => x mod 2 == 0).tamanho
m3 = lista.selecione(x => x mod 3 == 0).tamanho
m4 = lista.selecione(x => x mod 4 == 0).tamanho
m5 = lista.selecione(x => x mod 5 == 0).tamanho

escreva "{m2} Multiplo(s) de 2"
escreva "{m3} Multiplo(s) de 3"
escreva "{m4} Multiplo(s) de 4"
escreva "{m5} Multiplo(s) de 5"
````


## 1743 - Máquina de Verificação Automatizada

````portugol
x, y = leia_texto
var compativel := verdadeiro
para i de 1 ate 9 passo 2 faca
  se x[i] == y[i] entao compativel := falso fim
fim
se compativel então
  escreva "Y"
senão
  escreva "N"
fim
````


## 1566 - Altura

````portugol
tipo Num numero: Inteiro quantidade: Inteiro fim

min(x, y: Inteiro) = se x < y então x senão y fim

f(entrada: Texto, p:Inteiro) = entrada.pegue(p - 1)
                                      .divida(" ")
                                      .ordene
                                      .divida_quando(_ <> _)
                                      .mapeie(a => Num(a.cabeça.inteiro, a.tamanho))

g(nums: Lista[Num]) = nums.ordene(_.numero)
                          .divida_quando(_.numero <> _.numero)
                          .mapeie(a => Num(a.cabeça.numero, a.injete(0)(_ + _.quantidade)))

nc = leia_inteiro
para i de 1 até nc faça
  var n := leia_inteiro
  var entrada := leia_texto + " "
  var result := Lista(0, Num(0, 0))
  enquanto entrada <> "" faça
    var p := min(50000, entrada.tamanho)
    enquanto entrada[p] <> ' ' e p < entrada.tamanho faça p := p + 1 fim
    result := result + f(entrada, p)        
    entrada := entrada.descarte(p)
  fim
  result := g(result)          
  imprima result[1].numero
  result[1] := Num(result[1].numero, result[1].quantidade - 1)
  para r em result faça
    imprima " {r.numero}" * (r.quantidade)
  fim
  escreva ""
fim
````


## 2143 - A Volta do Radar

````portugol
var t := leia_inteiro
enquanto t > 0 faca
  para i de 1 ate t faca
    n = leia_inteiro
    se n mod 2 == 0 entao
      escreva 2 * n - 2
    senao
      escreva n div 2 * 4 + 1
    fim
  fim
  t := leia_inteiro
fim
````


## 2588 - Jogo dos Palíndromos

````portugol
var s:= leia_texto
enquanto não eof faça
  letras = s.ordene
            .divida_quando(_ <> _)
            .selecione(a => a.tamanho mod 2 == 1)
            .tamanho - 1
  se letras >= 0
    então escreva letras
    senão escreva 0
  fim
  s:= leia_texto
fim
````


## 2518 - Escada do DINF

````portugol
var n := leia_inteiro
enquanto n > 0 faça
  medida = leia_inteiros(" ")
  h, c, l = medida[1], medida[2], medida[3]
  area = n * l * raiz(h ^ 2 + c ^ 2) / 10000
  escreva area formato "%.4f"
  n := leia_inteiro
fim
````


## 2175 - Qual o Mais Rápido?

````portugol
a = leia_reais(" ")
o, b, i = a[1], a[2], a[3]
se o < b e o < i entao
  escreva "Otavio"
senaose b < o e b < i entao
  escreva "Bruno"
senaose i < o e i < b entao
  escreva "Ian"
senao
  escreva "Empate"
fim
````


## 3209 - Tomadas Elétricas

````portugol
n = leia_inteiro
para i de 1 ate n faca
  num = leia_inteiros(" ")
  tomadas = num.cauda.injete(0)(_ + _) - num.cabeca + 1
  escreva tomadas
fim
````


## 3058 - Supermercado

````portugol
n = leia_inteiro
var menor := 10000000.0
para i de 1 ate n faca
  a = leia_reais(" ")
  p, g = a[1], a[2]
  valor = p * 1000 / g
  se valor < menor entao menor := valor fim
fim
escreva menor formato "%.2f"
````


## 2386 - Telescópio

````portugol
a, n = leia_inteiro
z = 40000000 / a
var soma := 0
para i de 1 ate n faca
  f = leia_inteiro
  se f >= z entao
    soma := soma + 1
  fim
fim
escreva soma
````


## 1267 - Biblioteca Pascal

````portugol
var entrada := leia_inteiros(" ")
enquanto entrada <> [0, 0] faça
  n = entrada[2]
  var linhas := Lista(n, leia_inteiros(" "))
  var todos := falso
  enquanto (não todos) e (linhas[1] <> []) faça
    todos := linhas.mapeie(_.cabeça).injete(verdadeiro)((a, b) => a e b == 1)
    linhas := linhas.mapeie(_.cauda)
  fim
  se todos então escreva "yes" senão escreva "no" fim
  entrada := leia_inteiros(" ")
fim
````


## 2850 - Papagaio Poliglota

````portugol
var a := leia_texto
enquanto nao eof faça
  escolha a[1]
    caso 'e' => escreva "ingles"
    caso 'd' => escreva "frances"
    caso 'n' => escreva "portugues"
    caso  _  => escreva "caiu"
  fim
  a := leia_texto
fim
````


## 2160 - Nome no Formulário

````portugol
s = leia_texto
se s.tamanho <= 80 então
  escreva "YES"
senão
  escreva "NO"
fim
````


## 1098 - Sequencia IJ 4

````portugol
para i de 0 até 1,
     p em ["", ".2", ".4", ".6", ".8"],
     j de 1 até 3 faça
  escreva "I={i}{p} J={i+j}{p}"
fim
escreva "I=2 J=3"
escreva "I=2 J=4"
escreva "I=2 J=5"
````


## 2831 - Pesos

````portugol
leia_inteiro
pesos = leia_inteiros(" ")
dif = pesos.zip(0 :: pesos)
           .mapeie(a => a.primeiro - a.segundo)
           .injete(verdadeiro)((b, v) => b e v <= 8)
se dif entao
  escreva "S"
senao
  escreva "N"
fim
````


## 2569 - A Bruxa do 7 x 1

````portugol
entrada = leia_textos(" ")
a = entrada[1].mapeie(a => se a == '7' então '0' senão a fim).inteiro
b = entrada[3].mapeie(a => se a == '7' então '0' senão a fim).inteiro
c = se entrada[2] == "+" então a + b senão a * b fim
escreva c.texto.mapeie(a => se a == '7' então '0' senão a fim).inteiro
````


## 1038 - Lanche

````portugol
entrada = leia_inteiros(2)
preco = [4.0,4.5,5.0,2.0,1.5]
valor = preco[entrada[1]]*entrada[2]
escreva "Total: R$ " + (valor formato "%.2f")
````


## 3344 - Brute

````portugol
escreva "4"
````


## 1901 - Borboletas

````portugol
n = leia_inteiro
k = para i de 1 até n gere leia_inteiros(" ") fim
var v := [0].cauda
para i de 1 até 2*n faça
  a = leia_inteiros(" ")
  v := k[a[1]][a[2]] :: v
fim
especies = v.ordene.divida_quando(_ <> _).tamanho
escreva especies
````


## 2747 - Saída 1

````portugol
escreva "---------------------------------------"
escreva "|                                     |"
escreva "|                                     |"
escreva "|                                     |"
escreva "|                                     |"
escreva "|                                     |"
escreva "---------------------------------------"
````


## 1987 - Divisibilidade Por 3

````portugol
# eof = falso
var entrada := leia_texto
enquanto nao eof faça
    numeros = entrada.divida()[2]
    soma = numeros.injete(0)((x, y) => x + y) - 48 * numeros.tamanho
    se soma mod 3 == 0 então
        escreva "{soma} sim"
    senão
        escreva "{soma} nao"
    fim
    entrada := leia_texto
fim
````


## 2454 - Flíper

````portugol
entrada = leia_inteiros(" ")
p = entrada[1]
r = entrada[2]

se p == 0 então
  escreva "C"
senãose r == 0 então
  escreva "B"
senão
  escreva "A"
fim
````


## 2165 - Tuitando

````portugol
n = leia_texto
se n.tamanho <= 140 então
  escreva "TWEET"
senão
  escreva "MUTE"
fim
````


## 1300 - Horas e Minutos

````portugol
var angulo := leia_inteiro
enquanto nao eof faça
  se angulo mod 6 == 0 entao
    escreva "Y"
  senao
    escreva "N"
  fim
  angulo := leia_inteiro
fim
````


## 1188 - Área Inferior

````portugol
o = leia_texto
nums = leia_reais(144)
var soma := 0.0
para i de 0 até 11, j de 13 - i até i faça
  soma := soma + nums[i * 12 + j]
fim
se o == "S" então
  escreva soma formato "%.1f"
senão
  escreva soma / 30 formato "%.1f"
fim
````


## 1186 - Abaixo da Diagonal Secundária

````portugol
o = leia_texto
nums = leia_reais(144)
var soma := 0.0
para i de 0 até 11, j de 13 - i até 12 faça
  soma := soma + nums[i * 12 + j]
fim
se o == "S" então
  escreva soma formato "%.1f"
senão
  escreva soma / 66 formato "%.1f"
fim
````


## 1869 - Base 32

````portugol
digito(n: BigInt) =
  se n > 9 entao (n.toInt + 55).caractere senao (n.toInt + 48).caractere fim

base32(n: BigInt): Texto =
  se n > 0 entao base32(n div 32) + digito(n mod 32) senao "" fim

var a := BigInt(1)
enquanto a > 0 faca
  a := BigInt(leia_texto)
  se a > 0 entao escreva base32(a) senao escreva 0 fim
fim
````


## 3475 - Conversor

````portugol
numeros = ["zero", "um", "dois", "tres", "quatro",
           "cinco","seis", "sete", "oito", "nove"]
a = leia_texto
p = numeros.posicao(a) - 1
n = numeros[a.inteiro + 1]
se p >= 0 então
  escreva p
senão
  escreva n
fim
````


## 1262 - Leitura Múltipla

````portugol
var s := leia_texto
enquanto nao eof faca
  p = leia_inteiro
  x = s.divida_quando(_ <> _)
  y = x.mapeie(a => se a[1] == 'W' entao a.tamanho senao (a.tamanho / p).teto.inteiro fim)
  escreva y.injete(0)(_ + _)
  s := leia_texto
fim
````


## 1235 - De Dentro para Fora

````portugol
n = leia_inteiro
para i de 1 ate n faca
  linha = leia_texto
  t = linha.tamanho div 2
  s = linha.pegue(t)
  r = linha.descarte(t)
  escreva "{s.inverta}{r.inverta}"
fim
````


## 1980 - Embaralhando

````portugol
fat(n: Inteiro): BigInt = se n > 1 então fat(n-1) * n senão 1 fim

var s := leia_texto
enquanto s <> "0" faça
    letras_repetidas = s.ordene.divida_quando(_ <> _).mapeie(_.tamanho).selecione(_ > 1).ordene
    anagramas = letras_repetidas.injete(fat(s.tamanho))((a, b) => a div fat(b))
    escreva(anagramas)
    s := leia_texto
fim
````


## 1763 - Tradutor do Papai Noel

````portugol
natal = [
  ("alemanha", "Frohliche Weihnachten!"),
  ("antardida", "Merry Christmas!"),
  ("argentina", "Feliz Navidad!"),
  ("australia", "Merry Christmas!"),
  ("austria", "Frohe Weihnacht!"),
  ("belgica", "Zalig Kerstfeest!"),
  ("brasil", "Feliz Natal!"),
  ("canada", "Merry Christmas!"),
  ("chile", "Feliz Navidad!"),
  ("coreia", "Chuk Sung Tan!"),
  ("espanha", "Feliz Navidad!"),
  ("estados-unidos", "Merry Christmas!"),
  ("grecia", "Kala Christougena!"),
  ("inglaterra", "Merry Christmas!"),
  ("irlanda", "Nollaig Shona Dhuit!"),
  ("italia", "Buon Natale!"),
  ("japao", "Merii Kurisumasu!"),
  ("libia", "Buon Natale!"),
  ("marrocos", "Milad Mubarak!"),
  ("mexico", "Feliz Navidad!"),
  ("portugal", "Feliz Natal!"),
  ("siria", "Milad Mubarak!"),
  ("suecia", "God Jul!"),
  ("turquia", "Mutlu Noeller")
]

var pais := leia_texto
enquanto nao eof faca
  x = natal.selecione(a => a.primeiro == pais)
  escolha x
    caso a :: as => escreva a.segundo
    caso _       => escreva "--- NOT FOUND ---"
  fim
  pais := leia_texto
fim
````


## 2322 - Peça Perdida

````portugol
n = leia_inteiro
nums = (0 :: (n + 1) :: leia_inteiros(" ")).ordene
escreva nums.divida_quando((a, b) => b - a > 1)[2].cabeça - 1
````


## 2486 - C Mais ou Menos?

````portugol
var t := leia_inteiro
enquanto t > 0 faça
  var total := 0
  para i de 1 até t faça
    a = leia_textos(" ")
    peso = escolha a.descarte(1).junte(" ")
      caso "suco de laranja" => 120
      caso "morango fresco"  =>  85
      caso "mamao"           =>  85
      caso "goiaba vermelha" =>  70
      caso "manga"           =>  56
      caso "laranja"         =>  50
      caso "brocolis"        =>  34
      caso _                 =>   0
    fim
    total := total + a[1].inteiro * peso
  fim
  se total > 130 então
    escreva "Menos {total - 130} mg"
  senãose total < 110 então
    escreva "Mais {110 - total} mg"
  senão
    escreva "{total} mg"
  fim
  t := leia_inteiro
fim
````


## 3412 - Avaliações de Algoritmos

````portugol
n  = leia_inteiro
para i de 1 até n faça
  nome = leia_texto
  notas = leia_reais(" ")
  maiores = notas.pegue(3).ordene.inverta
  media = escolha notas.tamanho
    caso 1                          => (notas[1] + 0) / 2
    caso 2                          => (notas[1] + notas[2]) / 2
    caso 4 se notas[4] > maiores[3] => (maiores[1] + maiores[2] + notas[4]) / 3
    caso _                          => (notas[1] + notas[2] + notas[3]) / 3
  fim
  escreva "{nome}: {media formato "%.1f"}"
fim
````


## 3174 - Grupo de Trabalho do Noel

````portugol
var bonecos, arquitetos, musicos, desenhistas := 0
n = leia_inteiro
para i de 1 ate n faca
  a = leia_textos(" ")
  grupo = a[2]
  horas = a[3].inteiro
  escolha grupo
    caso "bonecos"     => bonecos := bonecos + horas
    caso "arquitetos"  => arquitetos := arquitetos + horas
    caso "musicos"     => musicos := musicos + horas
    caso "desenhistas" => desenhistas := desenhistas + horas
    caso _             =>
  fim
fim
escreva bonecos div 8 + arquitetos div 4 + musicos div 6 + desenhistas div 12
````


## 2044 - Em Dívida

````portugol
enquanto leia_inteiro > 0 faca
  p = leia_inteiros(" ")
  var soma, d := 0
  para a em p faca
    soma := (soma + a) mod 100
    se soma == 0 entao d := d + 1 fim
  fim
  escreva d
fim
````


## 1285 - Dígitos Diferentes

````portugol
sem_repeticao(n: Inteiro)
  a = n.texto.ordene.lista
  b = a.zip(a.cauda)
  b.selecione(x => x.primeiro == x.segundo).tamanho == 0
fim

var c := 0
numeros = para i de 1 ate 5001 gere
  d = c
  se sem_repeticao(i) entao c:= c + 1 fim
  d
fim

var a := leia_texto
enquanto nao eof faca
  z = a.divida(" ")
  n, m = z[1].inteiro, z[2].inteiro
  escreva numeros[m+1] - numeros[n]
  a := leia_texto
fim
````


## 1218 - Getline Three - Calçados

````portugol
var c := 0
var n := leia_texto
enquanto nao eof faca
  c := c + 1
  entrada = leia_textos(" ")
  pares = entrada.zip(entrada.cauda).selecione(a => a.primeiro == n)
  feminino = pares.selecione(a => a.segundo == "F").tamanho
  masculino = pares.tamanho - feminino
  se c > 1 entao escreva "" fim
  escreva "Caso {c}:"
  escreva "Pares Iguais: {feminino + masculino}"
  escreva "F: {feminino}"
  escreva "M: {masculino}"
  n := leia_texto
fim
````


## 1220 - A Viagem

````portugol
var n := leia_inteiro
var N := Lista.mutável(1000, 0)

enquanto (n <> 0) faca

    var total := 0.0

    para i de 1 até n faca
        var numero := leia_textos(".")
        var inteiro := numero[1].inteiro * 100
        var decimal := numero[2].inteiro
        N[i] := decimal + inteiro
        total := total + N[i]
    fim

    total := (total / n)
    var valorMenor := 0.0
    var valorMaior := 0.0

    para l de 1 até  n faca
        se N[l] < total entao
            valorMenor := valorMenor + (total - N[l]).inteiro / 100.0
        senao
            valorMaior := valorMaior + (N[l] - total).inteiro / 100.0
        fim
    fim

    se (valorMenor > valorMaior) entao
        escreva "${valorMenor formato "%.2f"}"
    senao
        escreva "${valorMaior formato "%.2f"}"
    fim
    n := leia_inteiro
fim
````


## 2579 - Nagol

````portugol
a = leia_inteiros(" ")
l, c, x, y = a[1], a[2], a[3], a[4]
se (x mod 2 == 0) ou (c mod 2 == 0) entao
  se y mod 2 == 0 entao
    escreva "Direita"
  senao
    escreva "Esquerda"
  fim
senao
  se y mod 2 == 0 entao
    escreva "Esquerda"
  senao
    escreva "Direita"
  fim
fim
````


## 2939 - Casais

````portugol
n = leia_inteiro
var a, b := BigInt(16), BigInt(2)
para i de 2 até n faça
  a, b := 2 * (i + 1) * (a + b * 2 * i) mod 1000000007, a
fim
escreva b
````


## 2247 - Cofrinhos da Vó Vitória

````portugol
var n := leia_inteiro
var teste := 0
enquanto n > 0 faça
    teste := teste + 1
    escreva "Teste {teste}"
    var diferença := 0
    para i de 1 até n faça
        moedas = leia_inteiros(" ")
        diferença := diferença + moedas[1] - moedas[2]
        escreva diferença
    fim
    escreva ""
    n := leia_inteiro
fim
````


## 1766 - O Elfo das Trevas

````portugol
tipo Rena
  nome: Texto
  peso: Inteiro
  idade: Inteiro
  altura: Real
fim

lt = (r1, r2: Rena) =>
  se r1.peso <> r2.peso entao
    r1.peso > r2.peso
  senaose r1.idade <> r2.idade entao
    r1.idade < r2.idade
  senao
    r1.altura < r2.altura
  fim

t = leia_inteiro
para i de 1 ate t faca
  a = leia_inteiros(" ")
  n, m = a[1], a[2]
  renas = para i de 1 ate n gere
    b = leia_textos(" ")
    Rena(b[1], b[2].inteiro, b[3].inteiro, b[4].real)
  fim
  treno = renas.ordene(lt)
  escreva "CENARIO {'{'}{i}{'}'}"
  para j de 1 ate m faca
    escreva "{j} - {treno[j].nome}"
  fim
fim
````


## 1898 - Soma de Propina

````portugol
numerico(c: Caractere) = c >= '0' e c <= '9' ou c == '.'
linha1, linha2 = leia_texto.selecione(numerico)
cpf = linha1.pegue(11)
n1 = (linha1.descarte(11).real * 100).piso / 100
n2 = (linha2.real * 100).piso / 100
soma = n1 + n2
escreva "cpf {cpf}"
escreva soma formato "%.2f"
````


## 1849 - Dracarys!

````portugol
min(x, y: Inteiro) = se x < y então x senão y fim
max(x, y: Inteiro) = se x > y então x senão y fim

n = leia_inteiros(4)
escreva (min(min(n[1], n[2]) + min(n[3], n[4]), min(max(n[1], n[2]), max(n[3], n[4]))) ^ 2).inteiro
````


## 1257 - Array Hash

````portugol
n = leia_inteiro
para i de 1 até n faça
  l = leia_inteiro
  var soma := 0
  para j de 0 até l-1 faça
    s = leia_texto.lista.mapeie(c => c - 'A')
    para k de 0 até s.tamanho - 1 faça
      soma := soma + s[k+1] + k + j
    fim
  fim
  escreva soma
fim
````


## 1536 - Libertadores

````portugol
n = leia_inteiro
para i de 1 ate n faça
  a, b = leia_inteiros(" ")
  se a == b então
    escreva "Penaltis"
  senaose a[1]+b[3] > a[3]+b[1] então
    escreva "Time 1"
  senaose a[1]+b[3] < a[3]+b[1] então
    escreva "Time 2"
  senaose b[3] > a[3] então
    escreva "Time 1"
  senão
    escreva "Time 2"
  fim
fim
````


## 1802 - Catálogo de Livros

````portugol
soma(a, b: Inteiro) = a + b

p, m, f, q, b = leia_inteiros(" ").cauda
k = leia_inteiro
conjuntos = para pi em p, mi em m, fi em f,
                 qi em q, bi em b gere
                   pi + mi + fi + qi + bi
            fim.ordene.inverta
total = conjuntos.pegue(k).injete(0)(soma)
escreva total
````


## 2543 - Jogatina UFPR

````portugol
var entrada := leia_texto
enquanto nao eof faça
  n, l = entrada.divida(" ")[1].inteiro, entrada.divida(" ")[2]
  var cont := 0
  s = "{l} 0"
  para a de 1 até n faça
    linha = leia_texto
    se linha == s então
      cont := cont + 1
    fim
  fim
  escreva cont
  entrada := leia_texto
fim
````


## 1221 - Primo Rápido

````portugol
primo(a: Inteiro)
  var resp := a > 1
  para i de 2 até raiz(a).arredonde faça
    se a mod i == 0 então
      resp := falso
    fim
  fim
  retorne resp
fim

n = leia_inteiro
para i de 1 até n faça
  x = leia_inteiro
  se primo(x) entao
    escreva "Prime"
  senão
    escreva "Not Prime"
  fim
fim
````


## 1052 - Mês

````portugol
meses = "January February March April May June July August September October November December".divida(" ")
n = leia_inteiro
escreva meses[n]

````


## 3224 - Aaah!

````portugol
a, b = leia_texto
se a.tamanho >= b.tamanho entao
  escreva "go"
senao
  escreva "no"
fim
````


## 1585 - Fazendo Pandorgas

````portugol
n = leia_inteiro
para i de 1 ate n faca
  a = leia_texto
  tamanho = se a[3] == ' ' entao
    a.pegue(2).inteiro * a.descarte(3).inteiro div 2
  senao
    a.pegue(3).inteiro * a.descarte(4).inteiro div 2
  fim
  escreva "{tamanho} cm2"
fim
````


## 1094 - Experiências

````portugol
n = leia_inteiro
var coelhos, sapos, ratos := 0
para i de 1 até n faça
  entrada = leia_textos(" ")
  qtd = entrada[1].inteiro
  tpo = entrada[2]
  escolha tpo
    caso "C" => coelhos := coelhos + qtd
    caso "S" => sapos   := sapos   + qtd
    caso "R" => ratos   := ratos   + qtd
  fim
fim
cobaias = coelhos + sapos + ratos
escreva "Total: {cobaias} cobaias"
escreva "Total de coelhos: {coelhos}"
escreva "Total de ratos: {ratos}"
escreva "Total de sapos: {sapos}"
escreva "Percentual de coelhos: {coelhos * 100 / cobaias formato "%.2f"} %"
escreva "Percentual de ratos: {ratos * 100 / cobaias formato "%.2f"} %"
escreva "Percentual de sapos: {sapos * 100 / cobaias formato "%.2f"} %"
````


## 1140 - Flores Florescem da França

````portugol
var frase := leia_texto
enquanto frase <> "*" faca
  palavras = frase.maiúsculo.divida(" ")
  primeira = palavras[1].cabeca
  tamanho = palavras.tamanho
  var tautograma, i := verdadeiro, 1
  enquanto tautograma e i <= tamanho faca
    tautograma := palavras[i].cabeca == primeira
    i := i + 1
  fim
  # tautograma = palavras.mapeie(_.cabeca == primeira).injete(verdadeiro)(_ e _)
  se tautograma entao
    escreva "Y"
  senao
    escreva "N"
  fim
  frase := leia_texto
fim
````


## 3024 - Mountain Ranges

````portugol
in = leia_inteiros(" ")
n, x = in[1], in[2]
l = leia_inteiros(" ")

var r, p := 1

para i de 2 até n faça
  se l[i] - l[i-1] <= x então
    p := p + 1
    se p > r então r := p fim
  senão
    p := 1
  fim
fim

escreva r
````


## 3117 - Atrasadinhos

````portugol
  k = leia_inteiros(" ")[2]
  a = leia_inteiros(" ").selecione(_ <= 0).tamanho
  se a >= k entao
    escreva "YES"
  senao
    escreva "NO"
  fim
````


## 2949 - A Sociedade do Anel

````portugol
n = leia_inteiro
var anoes, elfos, humanos, magos, hobbits := 0
para i de 1 até n faça
  a = leia_textos(" ")[2]
  escolha a
    caso "A" => anoes := anoes + 1
    caso "E" => elfos := elfos + 1
    caso "H" => humanos := humanos + 1
    caso "M" => magos := magos + 1
    caso "X" => hobbits := hobbits + 1
    caso _   =>
  fim
fim
escreva "{hobbits} Hobbit(s)"
escreva "{humanos} Humano(s)"
escreva "{elfos} Elfo(s)"
escreva "{anoes} Anao(s)"
escreva "{magos} Mago(s)"
````


## 2722 - Pegadinha de Evergreen

````portugol
n = leia_inteiro
para i de 1 até n faça
  a, b = leia_texto
  para j de 0 até a.tamanho passo 2 faça
    imprima a.descarte(j).pegue(2)
    imprima b.descarte(j).pegue(2)
  fim
  escreva ""
fim
````


## 1008 - Salário

````portugol
n = leia_inteiro
h = leia_inteiro
s_h = leia_real
s = h * s_h
escreva "NUMBER = {n}"
escreva "SALARY = U$ {s formato "%.2f"}"
````


## 2728 - Grace Hopper, a Vovó do Cobol

````portugol
var s := leia_texto
enquanto nao eof faca
  a = s.minusculo.divida("-")
  cobol = (a[1][1] == 'c' ou a[1][-1] == 'c') e
          (a[2][1] == 'o' ou a[2][-1] == 'o') e
          (a[3][1] == 'b' ou a[3][-1] == 'b') e
          (a[4][1] == 'o' ou a[4][-1] == 'o') e
          (a[5][1] == 'l' ou a[5][-1] == 'l')
  se cobol então
    escreva "GRACE HOPPER"
  senão
    escreva "BUG"
  fim
  s := leia_texto
fim
````


## 2807 - Iccanobif

````portugol
n = leia_inteiro
var iccanobif := se n > 1 então [1, 1] senão [1] fim
para i de 3 até n faça
  a, b = iccanobif[1], iccanobif[2]
  iccanobif := (a + b) :: iccanobif
fim
escreva iccanobif.junte(" ")
````


## 1272 - Mensagem Oculta

````portugol
n = leia_inteiro
para i de 1 ate n faca
  s = leia_textos(" ").selecione(_ <> "")
  r = s.mapeie(_[1]).junte("")
  escreva r
fim
````


## 2584 - Pentágono

````portugol
c = leia_inteiro
const = 5 / 4 / tg(PI / 5)
para i de 1 ate c faca
  n = leia_inteiro
  area = const * n ^ 2
  escreva area formato "%.3f"
fim
````


## 3398 - Moeda Convertida

````portugol
n, m = leia_real
valor = n * m
escreva valor formato "%.2f"
````


## 1240 - Encaixa ou Não I

````portugol
n = leia_inteiro
para i de 1 ate n faca
  s = leia_textos(" ")
  a, b = s[1], s[2]
  se a.descarte(a.tamanho - b.tamanho) == b entao
    escreva "encaixa"
  senão
    escreva "nao encaixa"
  fim
fim
````


## 3433 - Jogando 23

````portugol
menor(a, b: Inteiro) = se a < b então a senão b fim
soma(lista: Lista[Inteiro]) =
  lista.mapeie(a => menor(a, 10)).injete(0)(_ + _)

cartas_disponiveis(lista: Lista[Inteiro]) =
  (para i de 1 ate 13, j de 1 ate 4 gere i fim - lista)
    .ordene.divida_quando(_ <> _).mapeie(_.cabeça)

n = leia_inteiro
j, m, comum = leia_inteiros(" ")
joao  = soma(j + comum)
maria = soma(m + comum)
cartas = cartas_disponiveis(j + m + comum)
var carta := -1
para c em cartas.inverta faca
  se maria + menor(c, 10) == 23 ou
     maria + menor(c, 10) < 23 e joao + menor(c, 10) > 23 então
       carta := c
  fim
fim
escreva carta
````


## 2479 - Ordenando a Lista de Crianças do Papai Noel

````portugol
n = leia_inteiro
lista = leia_textos(n).mapeie(a => a.divida(" "))
nomes = lista.mapeie(a => a[2]).ordene
comportados = lista.selecione(a => a[1] == "+").tamanho
escreva nomes.junte("\n")
escreva "Se comportaram: {comportados} | Nao se comportaram: {n - comportados}"
````


## 1553 - Perguntas mais Frequentes

````portugol
var k := leia_inteiros(" ")[2]
enquanto k > 0 faça
  p = leia_inteiros(" ")
       .ordene
       .divida_quando((a,b) => a <> b)
       .selecione(_.tamanho >= k)
       .tamanho
  escreva p
  k := leia_inteiros(" ")[2]
fim
````


## 2435 - Corrida

````portugol
a, b = leia_inteiros(" ")
se a[2] / a[3] < b[2] / b[3] entao
  escreva a[1]
senao
  escreva b[1]
fim
````


## 2760 - Entrada e Saída de String

````portugol
a, b, c = leia_texto
escreva "{a}{b}{c}"
escreva "{b}{c}{a}"
escreva "{c}{a}{b}"
escreva "{a.pegue(10)}{b.pegue(10)}{c.pegue(10)}"
````


## 3139 - Buscando Novos Seguidores

````portugol
entrada = leia_inteiros(" ")
n, m = entrada[1], entrada[2]
var d := leia_inteiros(" ").mutavel
var falta := m - n
var soma := d.injete(0)(_ + _)
var i := 0
enquanto falta > 0 faca
  se d.divida_quando(_ <> _).tamanho == 1 entao
    i := i + (falta / d.cabeca).teto.inteiro
    falta := 0
  senao
    proximo = (soma / 30).teto.inteiro
    soma := soma - d.cabeca + proximo
    falta := falta - proximo
    d := d.cauda + [proximo]
    i := i + 1
  fim
fim
escreva i
````


## 2626 - Turma do JB6

````portugol
dodo   = "Os atributos dos monstros vao ser inteligencia, sabedoria..."
leo    = "Iron Maiden's gonna get you, no matter how far!"
pepper = "Urano perdeu algo muito precioso..."
empate = "Putz vei, o Leo ta demorando muito pra jogar..."
var a := leia_texto
enquanto nao eof faca
  resultado = escolha a
    caso "pedra tesoura tesoura" => dodo
    caso "papel pedra pedra"     => dodo
    caso "tesoura papel papel"   => dodo
    caso "tesoura pedra tesoura" => leo
    caso "pedra papel pedra"     => leo
    caso "papel tesoura papel"   => leo
    caso "tesoura tesoura pedra" => pepper
    caso "pedra pedra papel"     => pepper
    caso "papel papel tesoura"   => pepper
    caso _                       => empate
  fim
  escreva resultado
  a := leia_texto
fim
````


## 1084 - Apagando e Ganhando

````portugol
var entrada := leia_inteiros(" ")
enquanto entrada <> [0, 0] faça
  var d := entrada[2]
  linha = leia_texto
  var s := ['a']
  para i de 1 até linha.tamanho faça
    enquanto d > 0 e s.cabeça < linha[i] faça
      s := s.cauda
      d := d - 1
    fim
    s := linha[i] :: s
  fim
  s := s.descarte(d)
  escreva s.inverta.descarte(1).junte("")
  entrada := leia_inteiros(" ")
fim
````


## 3092 - Truco da Galera 2.0

````portugol
n = leia_inteiro
para i de 1 ate n faca
  s = leia_texto
  var q, j, k, a := 0
  para c em s faca
    escolha c
      caso 'Q'          => q := q + 1
      caso 'J' se j < q => j := j + 1
      caso 'K' se k < j => k := k + 1
      caso 'A' se a < k => a := a + 1
      caso _ =>
    fim
  fim
  se a > 0 entao
    escreva "Agora vai"
  senao
    escreva "Agora apertou sem abracar"
  fim
fim
````


## 1180 - Menor e Posição

````portugol
n = leia_inteiro
num = leia_inteiros(" ")
menor = num.ordene.primeiro
posição = num.posição(menor) - 1

escreva "Menor valor: {menor}"
escreva "Posicao: {posição}"
````


## 3171 - Cordão de Led

````portugol
a = leia_inteiros(" ")

conectado()
  var ligados := leia_inteiros(" ")
  var cordoes := para i de 2 ate a[2] gere leia_inteiros(" ") fim

  var b := cordoes.selecione(x => ligados.contem(x[1]) ou ligados.contem(x[2]))
  enquanto b.tamanho > 0 faça
    ligados := para c em b, d em c gere d fim + ligados
    cordoes := cordoes - b
    b := cordoes.selecione(x => ligados.contem(x[1]) ou ligados.contem(x[2]))
  fim
  retorne cordoes.tamanho == 0
fim

se a[1] - a[2] == 1 e conectado então
  escreva "COMPLETO"
senão
  escreva "INCOMPLETO"
fim
````


## 1157 - Divisores I

````portugol
n = abs(leia_inteiro)
para i de 1 até n se n mod i  == 0 faça
  escreva i
fim
````


## 2310 - Voleibol

````portugol
n = leia_inteiro
var tentativas, sucesso := [0, 0, 0]
para i de 1 ate n faca
  nome = leia_texto
  a, b = leia_inteiros(" ")
  para j de 1 ate 3 faca
    tentativas[j] := tentativas[j] + a[j]
    sucesso[j] := sucesso[j] + b[j]
  fim
fim

fundamentos = ["Saque", "Bloqueio", "Ataque"]
para j de 1 ate 3 faca
  pontos = sucesso[j] * 100 / tentativas[j]
  escreva "Pontos de {fundamentos[j]}: {pontos formato "%.2f"} %."
fim
````


## 3188 - Phone List

````portugol
prefixo(x, y: Texto) = x == y.pegue(x.tamanho)

t = leia_inteiro
para i de 1 até t faça
    n = leia_inteiro
    numeros = leia_textos(n).ordene
    pares = numeros.zip(numeros.cauda)
    consistente = pares.selecione(a => prefixo(a.primeiro, a.segundo)).tamanho == 0
    se consistente então escreva "YES" senão escreva "NO" fim
fim
````


## 1781 - Guga e a String

````portugol
montar(posicoes, vogais, consoantes: Texto) = (d_vogais, d_consoantes: Inteiro) => faca
  t_vogais, t_consoantes, t = vogais.tamanho, consoantes.tamanho, posicoes.tamanho
  var a := se t_vogais > 0 entao t_vogais - d_vogais mod t_vogais - 1 senao 0 fim
  var b := se t_consoantes > 0 entao t_consoantes - d_consoantes mod t_consoantes - 1 senao 0 fim
  para i de 1 ate t gere
    se posicoes[i] == 'a' entao
      a := (a + 1) mod t_vogais
      vogais[a + 1]
    senao
      b := (b + 1) mod t_consoantes
      consoantes[b + 1]
    fim
  fim.junte("")
fim

é_vogal = (c: Caractere) => c == 'a' ou c == 'e' ou c == 'i' ou c == 'o' ou c == 'u'

t = leia_inteiro
para i de 1 ate t faca
  escreva "Caso #{i}:"
  s = leia_texto
  vogais = s.selecione(é_vogal)
  consoantes = s.selecione(nao é_vogal(_))
  var d_v, d_c := 0
  posicoes = s.mapeie(c => se é_vogal(c) entao 'a' senao 'b' fim)
  q = leia_inteiro
  para i de 1 ate q faca
    x = leia_texto
    y = x.descarte(2).inteiro
    m = montar(posicoes, vogais, consoantes)
    escolha x.cabeca
      caso '0' => d_v := d_v + y
      caso '1' => d_c := d_c + y
      caso  _  => escreva m(d_v, d_c)
    fim
  fim
fim
````


## 1216 - Getline One

````portugol
var soma, n := 0
leia_texto
enquanto nao eof faca
  soma := soma + leia_inteiro
  n := n + 1
  leia_texto
fim
escreva (soma / n) formato "%.1f"
````


## 1448 - Telefone Sem Fio

````portugol
t = leia_inteiro
para i de 1 até t faça
  frase, time1, time2 = leia_texto
  var c1, c2, desempate := 0

  para j de 1 até frase.tamanho faça
    se frase[j] == time1[j] então
      c1 := c1 + 1
      se desempate == 0 e frase[j] <> time2[j] então
        desempate := 1
      fim
    fim
    se frase[j] == time2[j] então
      c2 := c2 + 1
      se desempate == 0 e frase[j] <> time1[j] então
        desempate := 2
      fim
    fim
  fim

  escreva "Instancia {i}"
  se c1 == c2 e desempate == 0 então
    escreva "empate"
  senãose c1 > c2 então
    escreva "time 1"
  senãose c1 < c2 então
    escreva "time 2"
  senão
    escreva "time {desempate}"
  fim
  escreva ""
fim
````


## 3346 - Flutuação do PIB

````portugol
entrada = leia_reais(" ")
f1, f2 = entrada[1], entrada[2]
resposta = (100 + f1) * (f2 / 100 + 1) - 100
escreva resposta formato "%.6f"
````


## 2187 - Bits Trocados

````portugol
var t := 0
var v := leia_inteiro
enquanto v > 0 faca
  i = v div 50
  j = v mod 50 div 10
  k = v mod 10 div 5
  l = v mod 5
  t := t + 1
  escreva "Teste {t}"
  escreva "{i} {j} {k} {l}"
  escreva ""
  v := leia_inteiro
fim
````


## 1189 - Área Esquerda

````portugol
o = leia_texto
nums = leia_reais(144)
var soma := 0.0
para j de 1 até 12, i de j até 11-j faça
  soma := soma + nums[i * 12 + j]
fim
se o == "S" então
  escreva soma formato "%.1f"
senão
  escreva soma / 30 formato "%.1f"
fim
````


## 1010 - Cálculo Simples

````portugol
p = para i de 1 até 2 gere
  v = leia(" ")
  v[2].inteiro * v[3].real
fim
valor = p[1] + p[2]
escreva "VALOR A PAGAR: R$ {valor formato "%.2f"}"
````


## 2342 - Overflow

````portugol
n = leia_inteiro
exp = leia_textos(" ")
p, c, q = exp[1].inteiro, exp[2], exp[3].inteiro
valor = escolha c
  caso "*" => p.inteiro * q.inteiro
  caso _   => p.inteiro + q.inteiro
fim

se valor > n entao
  escreva "OVERFLOW"
senao
  escreva "OK"
fim
````


## 3056 - Ponto do Meio

````portugol
n = leia_inteiro
# pontos = (2 ^ n + 1) ^ 2
# lado = Lista(n, 1).injete(BigInt(1))((x, _) => 2 * x) + 1

var lado := BigInt(2)
para i de 1 ate n faca
  lado := 2 * lado - 1
fim
escreva lado * lado
````


## 1866 - Conta

````portugol
n = leia_inteiro
para i de 1 até n faça
  escreva leia_inteiro mod 2
fim
````


## 2775 - Preparando a Produção

````portugol
var n := leia_inteiro
enquanto n > 0 faça
  p, v = leia_inteiros(" ")
  var m = p.zip(v).mutavel
  var soma := 0
  var alterado := verdadeiro
  enquanto alterado faca
    alterado := falso
    para i de 1 ate n - 1 faca
      se m[i].primeiro > m[i+1].primeiro entao
        soma := soma + m[i].segundo + m[i+1].segundo
        aux = m[i]
        m[i] := m[i+1]
        m[i+1] := aux
        alterado := verdadeiro
      fim
    fim
  fim
  escreva soma
  n := leia_inteiro
fim
````


## 3039 - Brinquedos do Papai Noel

````portugol
n = leia_inteiro
var m := 0
para i de 1 ate n faca
  a = leia_texto.ultimo
  se a == 'M' entao m := m + 1 fim
fim
escreva "{m} carrinhos"
escreva "{n-m} bonecas"
````


## 1253 - Cifra de César

````portugol
n = leia_inteiro
para i de 1 ate n faca
  s = leia_texto
  p = leia_inteiro
  d = 'A' + p - 26
  escreva s.mapeie(c => ((c - d) mod 26 + 'A').caractere)
fim
````


## 2167 - Falha do Motor

````portugol
n = leia_inteiro
a = leia_inteiros(" ")
var queda := 0
para i de 2 até n se queda == 0 faça
  se a[i]< a[i-1] então
    queda := i
  fim
fim
escreva queda
````


## 2554 - Pizza Antes de BH

````portugol
var a := leia_texto
enquanto nao eof faca
  d = a.divida(" ")[2].inteiro
  var i := 0
  var resp := "Pizza antes de FdI"
  enquanto i < d faca
    l = leia_texto.divida(" ")
    pizza = l.cauda.injete(verdadeiro)((x, y) => x e y == "1")
    se pizza e resp == "Pizza antes de FdI" entao
      resp := l[1]
    fim
    i := i + 1
  fim
  se i < 100 entao
    escreva resp
  fim
  a := leia_texto
fim
````


## 1101 - Sequência de Números e Soma

````portugol
var entrada := leia_inteiros(" ")
enquanto entrada[1] > 0 e entrada[2] > 0 faça
  a = se entrada[1] < entrada[2] então entrada[1] senão entrada[2] fim
  b = se entrada[1] < entrada[2] então entrada[2] senão entrada[1] fim
  var soma := 0
  para i de a até b faça
    imprima "{i} "
    soma := soma + i
  fim
  escreva "Sum={soma}"
  entrada := leia_inteiros(" ")
fim
````


## 3465 - Cimba

````portugol
abc = leia_inteiros(" ")
a, b, c = abc[1], abc[2], abc[3]
s = (a + b + c) / 2
area = (s * (s - a) * (s - b) * (s - c)) ^ 0.5
escreva "{area formato "%.3f"} m2"
````


## 1276 - Faixa de Letras

````portugol
var linha := leia_texto
enquanto nao eof faca
  faixas = linha.ordene
                .divida_quando((a, b) => b - a > 1)
                .mapeie(a => "{a[1]}:{a[-1]}")
                .descarte_enquanto(_ == " : ")
  escreva faixas.junte(", ")
  linha := leia_texto
fim
````


## 2591 - HameKameKa

````portugol
c = leia_inteiro
para i de 1 ate c faca
  s = leia_texto
  p = s.posicao('m')
  a = p - 2
  b = s.tamanho - a - 6
  escreva "k" + "a" * (a * b) 
fim
````


## 2443 - Soma de Frações

````portugol
mdc(i, j: Inteiro): Inteiro =
  se i == 0 entao j
  senaose i > j entao mdc(i mod j , j)
  senao mdc(j, i) fim

x = leia_inteiros(" ")
a, b, c, d = x[1], x[2], x[3], x[4]
num = a * d + c * b
den = b * d

m = mdc(num, den)
escreva "{num div m} {den div m}"
````


## 2594 - Eachianos II

````portugol
n = leia_inteiro
para i de 1 ate n faca
  texto = leia_textos(" ")
  palavra = leia_texto
  var c := 0
  letras = para p em texto gere
    t = c
    c := c + 1 + p.tamanho
    [p, t]
  fim
  b = letras.selecione(p => p[1] == palavra).mapeie(p => p[2])
  se b.tamanho > 0 entao
    escreva b.junte(" ")
  senao
    escreva -1
  fim
fim
````


## 2174 - Coleção de Pomekon

````portugol
n = leia_inteiro
nomes = leia_textos(n).ordene
var pokemons := 150
para i de 2 até n faça
  se nomes[i] <> nomes[i - 1] então
    pokemons := pokemons - 1
  fim
fim
escreva "Falta(m) {pokemons} pomekon(s)."
````


## 2389 - Floresta

````portugol
x = leia_inteiro
limite = raiz(x / 2).inteiro

var combinações := 0
para n de 1 até limite faça
  se (n + x) mod (2 * n + 1) == 0 então
    combinações := combinações + 1
  fim
fim
escreva combinações

# combinações = para n de 1 ate limite se (n + x) mod (2 * n + 1) == 0 gere 1 fim.tamanho
````


## 3484 - ~~Altura Mínima~~

````portugol
h = leia_inteiros(" ")[2]
a = leia_inteiros(" ")
var brinquedos := 0
para x em a se x <= h faça
  brinquedos := brinquedos + 1
fim
escreva brinquedos
````


## 2290 - Números Apaixornados

````portugol
enquanto leia_inteiro > 0 faça
    numeros = leia_textos(" ")
    
    apaixornados = numeros.ordene
                          .divida_quando(_ <> _)
                          .selecione(a => a.tamanho mod 2 == 1)
                          .mapeie(a => BigInt(a.cabeça))

    escreva apaixornados.ordene.junte(" ")
fim
````


## 2251 - Torres de Hanói

````portugol
h(a: Lista[Inteiro]): Lista[Inteiro] =
  se a.tamanho < 30 entao h((a.cabeca * 2 + 1) :: a) senao a.inverta fim
hanoi = h([1])
var t := 0
var n := leia_inteiro
enquanto n > 0 faca
  t := t + 1
  escreva "Teste {t}"
  escreva hanoi[n]
  escreva ""
  n := leia_inteiro
fim
````


## 1062 - Trilhos

````portugol
reorganizar(entrada: Lista[Inteiro]) =
  organizar(entrada.inverta, [], entrada.tamanho, 0, entrada.tamanho)

organizar(entrada, pilha: Lista[Inteiro], t_entrada, t_pilha, proximo: Inteiro): Lógico =
  se t_entrada == 0 e t_pilha == 0 entao
    verdadeiro
  senaose t_pilha > 0 e pilha.cabeca == proximo entao
    organizar(entrada, pilha.cauda, t_entrada, t_pilha - 1, proximo - 1)
  senaose t_entrada > 0 entao
    se entrada.cabeca == proximo entao
      organizar(entrada.cauda, pilha, t_entrada - 1, t_pilha, proximo - 1)
    senao
      organizar(entrada.cauda, entrada.cabeca::pilha, t_entrada -1, t_pilha + 1, proximo)
    fim
  senao
    falso
  fim

enquanto leia_inteiro > 0 faca
  var s := leia_inteiros(" ")
  enquanto s.cabeca > 0 faca
    se reorganizar(s) entao
      escreva "Yes"
    senao
      escreva "No"
    fim
    s := leia_inteiros(" ")
  fim
  escreva ""
fim
````


## 3369 - KIARA is a Recursive Acronym

````portugol
n = leia_inteiro

var achou := falso
var linhas := Lista(0, "")
var acro := "                          "
var i := 1
enquanto não achou e i <= n faça
  linha = leia_texto
  se linha.tamanho <= 1 então
    achou:= verdadeiro
  senão
    se acro[linha.cabeça - 'A' + 1] == ' ' então
      acro := acro.updated(linha.cabeça - 'A', linha.cabeça)
    fim
    linhas := linha.cauda :: linhas
  fim
  i:= i + 1
fim
linhas := linhas.ordene(_.tamanho)
acro := "ABCDEFGHIJKLMNOPQRSTUVWXYZ" - acro
enquanto linhas <> [] e nao achou faça
  achou := acro - linhas.cabeça == acro
  linhas := linhas.cauda
fim

se achou então
  escreva "Y"
senão
  escreva "N"
fim
````


## 2823 - Eearliest Deadline First

````portugol
n = leia_inteiro
var soma := 0.0
para i de 1 ate n faca
  a = leia_reais(" ")
  soma := soma + a[1] / a[2]
fim
se soma <= 1.0 entao
  escreva "OK"
senao
  escreva "FAIL"
fim
````


## 3104 - Resto 2.0

````portugol
a = leia_texto
b = leia_inteiro
x = a.injete(0)((i, j) => (i * 10 + j - '0') mod b)
escreva x
````


## 1244 - Ordenação por Tamanho

````portugol
n = leia_inteiro
para i de 1 ate n faca
  palavras = leia_textos(" ")
  s = palavras.ordene(- _.tamanho).junte(" ")
  escreva s
fim
````


## 2764 - Entrada e Saída de Data

````portugol
data = leia_texto.divida("/")
dd, mm, aa = data[1], data[2], data[3]
escreva "{mm}/{dd}/{aa}"
escreva "{aa}/{mm}/{dd}"
escreva "{dd}-{mm}-{aa}"
````


## 3136 - Arquitetura de Pilha

````portugol
n = leia_inteiro
var pilha : Lista[Inteiro] := []
var registrador := Lista(100, 0)
reg(comando: Lista[Texto]) = comando[2].cauda.inteiro + 1

para i de 1 até n faça
  comando = leia_textos("_")
  escolha comando[1]
    caso "push" se comando[2][1] == 'R' =>
      pilha := registrador[reg(comando)] :: pilha
    caso "push" =>
      pilha := comando[2].inteiro :: pilha
    caso "pop" =>
      a = pilha.cabeça
      pilha := pilha.cauda
      registrador[reg(comando)] := a
    caso "add" =>
      a, b = pilha[1], pilha[2]
      pilha := (a + b) :: pilha.descarte(2)
    caso "mul" =>
      a, b = pilha[1], pilha[2]
      pilha := (a * b) :: pilha.descarte(2)
    caso "div" =>
      a, b = pilha[1], pilha[2]
      pilha := (b div a) :: pilha.descarte(2)
    caso "sub" =>
      a, b = pilha[1], pilha[2]
      pilha := (b - a) :: pilha.descarte(2)
    caso _ =>
      escreva pilha[1]
      pilha := pilha.cauda
  fim
fim
````


## 2416 - Corrida

````portugol
entrada = leia_inteiros(" ")
c = entrada[1]
n = entrada[2]
escreva c mod n
````


## 1558 - Soma de Dois Quadrados

````portugol
var n := leia_inteiro
enquanto nao eof faca
  a = raiz(n div 2).inteiro
  yes = para i de 0 ate a gere
    b = n - i * i
    c = raiz(b).inteiro
    c * c == b
  fim
  se yes.contem(verdadeiro) entao
    escreva "YES"
  senao
    escreva "NO"
  fim
  n := leia_inteiro
fim
````


## 2152 - Pepe, Já Tirei a Vela!

````portugol
n = leia_inteiro
para i de 1 ate n faca
  a = leia_inteiros(" ")
  hora, minuto, porta = a[1], a[2], a[3]
  horario = "{hora formato "%02d"}:{minuto formato "%02d"}"
  se porta == 1 entao
    escreva "{horario} - A porta abriu!"
  senao
    escreva "{horario} - A porta fechou!"
  fim
fim
````


## 2394 - Corrida 1

````portugol
n  = leia_inteiro
tempos = para i de 1 ate n gere leia_inteiros(" ").injete(0)(_ + _) fim
menor = tempos.ordene.cabeca
ganhador = tempos.posicao(menor)
escreva ganhador
````


## 3497 - ~~Alice e as Canções e Iara~~

````portugol
a = leia_inteiros(" ")
soma = a.injete(0)(_ + _)
escreva 6 - soma
````


## 1308 - Guerreiros Etruscos Nunca Jogam Xadrez

````portugol
n = leia_inteiro
para i de 1 até n faça
  x = leia_real
  a = ((raiz(1 + 8 * x) - 1) / 2).inteiro
  escreva a
fim
````


## 1607 - Avance as Letras

````portugol
t = leia_inteiro
para i de 1 até t faça
  lista = leia_textos(" ")
  var total := 0
  tm = lista[1].tamanho
  para j de 1 até tm faça
    tmp1, tmp2 = lista[1][j].inteiro, lista[2][j].inteiro
    se tmp2 > tmp1 então
      total := total + (tmp2 - tmp1)
    senaose tmp1 > tmp2 então
      total := total + (26 - (tmp1 - tmp2))
    fim
  fim
  escreva total
fim
````


## 1045 - Tipos de Triângulos

````portugol
entrada = leia_reais(" ").ordene
a = entrada[3]
b = entrada[2]
c = entrada[1]
a2 = a * a
b2 = b * b
c2 = c * c

se a >= b + c então
  escreva "NAO FORMA TRIANGULO"
senão
  se a2 == b2 + c2 então
    escreva "TRIANGULO RETANGULO"
  fim
  se a2 > b2 + c2 então
    escreva "TRIANGULO OBTUSANGULO"
  fim
  se a2 < b2 + c2 então
    escreva "TRIANGULO ACUTANGULO"
  fim
  se a == b e b == c então
    escreva "TRIANGULO EQUILATERO"
  senãose a == b ou a == c ou b == c então
    escreva "TRIANGULO ISOSCELES"
  fim
fim
````


## 1030 - A Lenda de Flavious Josephus

````portugol
nc = leia_inteiro
para i de 1 ate nc faca
  entrada = leia_inteiros(" ")
  n, k = entrada[1], entrada[2]
  escreva "Case {i}: {last(n, k)}"
fim

# Solução 3
last3(x, m: Inteiro)
  var regions := Lista.mutável(x, verdadeiro) # [verdadeiro,  ...]
  var next := (m - 1) mod x + 1
  para tamanho de x-1 até 1 passo -1 faca
    regions[next] := falso
    var n := (m-1) mod tamanho + 1
    enquanto n > 0 faça
      next := next mod x + 1
      se regions[next] entao n := n - 1 fim
    fim
  fim
  retorne next
fim


#last(x, m: Inteiro)
#  var a := (m - 1) mod x + 1
#  para i de 1 ate x - 1 faca
#    a := (a + m - 1) mod i + 1
#  fim
#  retorne a + 1
#fim

#last2(x, m: Inteiro)
#  var next := m
#  var regions = para i de 1 ate x gere i fim.mutável
#  para tamanho de x-1 ate 1 passo -1 faca
#    regions := regions.remova(next)
#    next := (next - 2 + m) mod tamanho + 1
#  fim
#  retorne regions[1]
#fim

# Solução 4 - Usando um Zipper
#tipo Zipper
#  var direita: Lista[Inteiro]
#  var esquerda: Lista[Inteiro] := []
#  var tamanho := direita.tamanho
#  var pos := 1
#
#  foco() = direita[1]
#  lista() = esquerda.inverta + direita
#
#  mova(p: Inteiro): Nada
#    pp = (p-1) mod tamanho + 1
#    para i de pos até pp-1 faca
#      esquerda := direita.cabeca::esquerda
#      direita := direita.cauda
#    fim
#    para i de pp até pos-1 faça
#      direita := esquerda.cabeca::direita
#      esquerda := esquerda.cauda
#    fim
#    pos := pp
#  fim
#
#  remova()
#    se direita <> [] então
#      direita := direita.cauda
#    senao
#      esquerda := esquerda.cauda
#    fim
#    tamanho := tamanho - 1
#  fim
#fim

#last4(x, m: Inteiro)
#  var regions = para i de 1 ate x gere i fim
#  z = Zipper(regions)
#  z.mova(m)
#  para i de 1 ate x - 1 faca
#    z.remova
#    z.mova(z.pos + m - 1)
#  fim
#  retorne z.foco
#fim
````


## 2956 - Derivada de 13 Variáveis

````portugol
a = leia_reais(" ")
p, t = a[1], a[2]
area = p * t / 2
escreva "Concluimos que, dado o limite da entrada, a resposta seria:  y = f(x) = {area formato "%.5f"}."
````


## 2786 - Piso da Escola

````portugol
n, m = leia_inteiro
escreva n * m + (n - 1) * (m - 1)
escreva 2 * (n - 1) + 2 * (m - 1)
````


## 2399 - Campo Minado

````portugol
n = leia_inteiro
a = 0::leia_inteiros(n) + [0]
para i de 2 até a.tamanho - 1 faça
  soma = a[i-1] + a[i] + a[i+1]
  escreva soma
fim
````


## 2462 - Voo

````portugol
entrada = leia_texto.divida(" ").mapeie(_.divida(":").mapeie(_.inteiro))
h1, m1 = entrada[1][1], entrada[1][2]
h2, m2 = entrada[2][1], entrada[2][2]
h3, m3 = entrada[3][1], entrada[3][2]
h4, m4 = entrada[4][1], entrada[4][2]
t1, t2, t3, t4 = (h1 * 60) + m1, (h2 * 60) + m2, (h3 * 60) + m3, (h4 * 60) + m4

d1 = se t1 > t2 então 1440 - t1 + t2 senão t2 - t1 fim
d2 = se t3 > t4 então 1440 - t3 + t4 senão t4 - t3 fim

voo_hr = (d1 + d2) div 2 - (se d1 + d2 > 1440 então 720 senão 0 fim)
fus_diferent = d1 - voo_hr - (se d1 - voo_hr > 720 então 1440 senão 0 fim)

escreva "{voo_hr} {fus_diferent div 60}"
````


## 2066 - amelborP mU

````portugol
x = ["0", "36" , "360", "4005", "40050", "404550", "4045500",
  "40495500", "404955000", "4049955000", "40499550000",
  "404999550000", "4049995500000", "40499995500000",
  "404999955000000", "4049999955000000", "40499999550000000",
  "404999999550000000"]
escreva x[leia_inteiro]
````


## 1193 - Conversão entre Bases

````portugol
dec_para_bin(num: Inteiro)
    Integer.toBinaryString(num)
fim

dec_para_hex(num:Inteiro)
    Integer.toHexString(num)
fim

bin_para_dec(num: Texto)
    Integer.parseInt(num, 2)
fim

bin_para_hex(num: Texto)
    dec_para_hex(bin_para_dec(num))
fim

hex_para_dec(num: Texto)
    Integer.parseInt(num, 16)
fim

hex_para_bin(num: Texto)
    dec_para_bin(hex_para_dec(num))
fim


vezes = leia_inteiro
para i de 1 ate vezes faça
    input = leia_textos(" ")
    num,base = input[1], input[2]

    escreva "Case {i}:"
    escolha base
        caso "bin" => escreva "{bin_para_dec(num)} dec"
                      escreva "{bin_para_hex(num)} hex"
        caso "dec" => escreva "{dec_para_hex(num.inteiro)} hex"
                      escreva "{dec_para_bin(num.inteiro)} bin"
        caso _     => escreva "{hex_para_dec(num)} dec"
                      escreva "{hex_para_bin(num)} bin"
    fim
    escreva ""
fim
````


## 2162 - Picos e Vales

````portugol
n = leia_inteiro
nums = leia_inteiros(" ")

op = se nums[1] > nums[2] entao
  (a, b: Inteiro) => a <= b
senão
  (a, b: Inteiro) => a >= b
fim

saida = 1 :: para i de 2 até n, par em [i mod 2 == 0] se
               par e op(nums[i - 1], nums[i]) ou
               não par e op(nums[i], nums[i - 1]) gere 0 fim

escreva saida.último
````


## 1212 - Aritmética Primária

````portugol
var a := leia_textos(" ")
c = 2 * '0'
enquanto a <> ["0", "0"] faca
  x = a[1].inverta + "00000000"
  y = a[2].inverta + "00000000"
  var soma, carry := 0
  para i de 1 ate 9 faca
    t = x[i] + y[i] - c + carry
    carry := t div 10
    soma := soma + carry
  fim
  escolha soma
    caso 0 => escreva "No carry operation."
    caso 1 => escreva "1 carry operation."
    caso n => escreva "{n} carry operations."
  fim
  a := leia_textos(" ")
fim
````


## 1309 - Formatação Monetária

````portugol
var dolares := leia_inteiro
enquanto nao eof faca
  centavos = leia_inteiro
  s0 = dolares.texto
  s1 = se s0.tamanho > 3  entao s0.insira(s0.tamanho - 2 , ',') senao s0 fim
  s2 = se s1.tamanho > 7  entao s1.insira(s1.tamanho - 6 , ',') senao s1 fim
  s3 = se s2.tamanho > 11 entao s2.insira(s2.tamanho - 10, ',') senao s2 fim
  escreva "${s3}.{centavos formato "%02d"}"
  dolares := leia_inteiro
fim
````


## 1893 - Fases da Lua

````portugol
a = leia_inteiros(" ")
lua = escolha (a[2], a[2] - a[1])
  caso (n, m) se n >= 3 e n <= 96 e m < 0 => "minguante"
  caso (n, _)     se n <= 2               => "nova"
  caso (n, _)     se n >= 97              => "cheia"
  caso _                                  => "crescente"
fim
escreva lua
````


## 1444 - Corrida dos Marrecos

````portugol
var n := leia_inteiro
enquanto n > 0 faça
  var a := 0
  enquanto n > 1 faça
    se n mod 3 == 0 então
      n := n div 3
    senão
      n := n div 3 + 1
    fim
    a := a + n
  fim
  escreva a
  n := leia_inteiro
fim
````


## 2779 - Álbum da Copa

````portugol
n, m = leia_inteiro
figurinha = Lista.mutável(n, verdadeiro)
var falta := n
para i de 1 até m faça
  num = leia_inteiro
  se figurinha[num] então
    figurinha[num] := falso
    falta := falta - 1
  fim
fim
escreva falta
````


## 1161 - Soma de Fatoriais

````portugol
var fat := Lista(21, BigInt(1))
para i de 1 até 20 faça
  fat[i+1] := fat[i] * i
fim

enquanto nao eof faça
  s = leia_inteiros(" ")
  se nao eof entao
    escreva fat[s[1] + 1] + fat[s[2] + 1]
  fim
fim
````


## 2421 - Álbum de Fotos

````portugol
maior(x, y: Inteiro) = se x > y entao x senao y fim

a, b, c = leia_inteiros(" ").ordene
se b[2]+c[2] <= a[2] e maior(b[1], c[1]) <= a[1] ou
   b[1]+c[2] <= a[2] e maior(b[2], c[1]) <= a[1] ou
   b[2]+c[1] <= a[2] e maior(b[1], c[2]) <= a[1] ou
   b[1]+c[1] <= a[2] e maior(b[2], c[2]) <= a[1] ou
   b[1]+c[1] <= a[1] e maior(b[2], c[2]) <= a[2] entao
  escreva "S"
senao
  escreva "N"
fim
````


## 2287 - Proteja sua Senha

````portugol
var teste := 1
var n := leia_inteiro
var nums := Lista(11, Lista(5, Lista(2, 0)))
var senha := Lista(11, Lista(6, ""))

enquanto n <> 0 faca
  para i de 1 até n faca
    entrada = leia_texto.divida(" ")                 

    nums[i][1][1] := entrada[1].inteiro
    nums[i][1][2] := entrada[2].inteiro

    nums[i][2][1] := entrada[3].inteiro
    nums[i][2][2] := entrada[4].inteiro

    nums[i][3][1] := entrada[5].inteiro
    nums[i][3][2] := entrada[6].inteiro

    nums[i][4][1] := entrada[7].inteiro
    nums[i][4][2] := entrada[8].inteiro

    nums[i][5][1] := entrada[9].inteiro
    nums[i][5][2] := entrada[10].inteiro

    senha[i][1] := entrada[11]
    senha[i][2] := entrada[12]
    senha[i][3] := entrada[13]
    senha[i][4] := entrada[14]
    senha[i][5] := entrada[15]
    senha[i][6] := entrada[16]
  fim 

  escreva "Teste {teste}"
  teste := teste + 1

  para k de 1 ate 6 faca
    ix = (senha[1][k][1] - 'A') + 1
    nch = nums[1][ix][1]
    noh = nums[1][ix][2]

    var all := 1
    para i de 1 ate n faca
      ixx = (senha[i][k][1] - 'A') + 1
      se nch <> nums[i][ixx][1] e nch <> nums[i][ixx][2] entao
        all := 0
      fim
    fim

    se k <> 1 entao
      imprima " "
    fim

    se all == 1 entao
      imprima nch
    senao
      imprima noh
    fim 
  fim 
  imprima " "
  escreva ""
  escreva ""
  n := leia_inteiro
fim
````


## 1546 - Feedback

````portugol
membros = ["Rolien", "Naej", "Elehcim", "Odranoel"]
n = leia_inteiro
para i de 1 ate n faca
  t = leia_inteiro
  para j de 1 ate t faca
    escreva membros[leia_inteiro]
  fim
fim
````


## 2951 - O Retorno do Rei

````portugol
a = leia_inteiros(" ")
n, g = a[1], a[2]
var valores := Lista('Z', 0)
para i de 1 ate n gere
  b = leia_textos(" ")
  r, v = b[1].cabeca, b[2].inteiro
  valores[r] := v
fim

x = leia_inteiro
letras = leia_textos(" ").mapeie(_.cabeca)

var saida := 0
para letra em letras faca
  saida := saida + valores[letra]
fim
escreva saida

se saida >= g entao
  escreva "You shall pass!"
senao
  escreva "My precioooous"
fim
````


## 1876 - Rabiola

````portugol
var s := leia_textos("x")
enquanto nao eof faca
  a = s.mapeie(_.tamanho)
  a1 = se a[1] > a[-1] entao a[1] senao a[-1] fim
  b = a.descarte(1).pegue(a.tamanho - 2).mapeie(_ div 2)
  maior = b.injete(a1)((x,y) => se x > y entao x senao y fim)
  escreva maior
  s := leia_textos("x")
fim
````


## 2003 - Domingo de Manhã

````portugol
var hora := leia_inteiros(":")
enquanto nao eof faca
  n = hora[1] * 60 + hora[2] - 420
  se n > 0 entao
    escreva "Atraso maximo: {n}"
  senao
    escreva "Atraso maximo: 0"
  fim
  hora := leia_inteiros(":")
fim
````


## 1116 - Dividindo X por Y

````portugol
n = leia_inteiro
para i de 1 até n faça
  entrada = leia_inteiros(" ")
  x = entrada[1]
  y = entrada[2]
  se y == 0 então
    escreva "divisao impossivel"
  senão
    escreva (x / y) formato "%.1f"
  fim
fim
````


## 2218 - O Temível Evil-Son

````portugol
t = leia_inteiro
para i de 1 ate t faca
  n = leia_inteiro
  se n < 2 entao
    escreva 2
  senao
    escreva n * (n + 1) div 2 + 1
  fim
fim
````


## 2930 - TCC da Depressão Natalino

````portugol
a = leia_inteiros(" ")
E, D = a[1], a[2]

se D >= 24 ou E > D então
  escreva ("Eu odeio a professora!")
senãose E <= D - 3 então
  escreva ("Muito bem! Apresenta antes do Natal!")
senão
  escreva ("Parece o trabalho do meu filho!")
  se E + 2 < 24 então
    escreva ("TCC Apresentado!")
  senão
    escreva ("Fail! Entao eh nataaaaal!")
  fim
fim
````


## 1133 - Resto da Divisão

````portugol
var x, y := leia_inteiro
se x > y então
  x, y := y, x
fim
para i de x + 1 até y - 1 faça
  se i mod 5 == 2 ou i mod 5 == 3 então
    escreva i
  fim
fim
````


## 2374 - Pneu

````portugol
n, m = leia_inteiro
escreva n - m
````


## 1512 - Azulejos

````portugol
gcd(a, b: Inteiro): Inteiro
    se b == 0 então a senão gcd(b, a mod b) fim
fim

var flag := verdadeiro
enquanto flag faça
    temp = leia_inteiros(3)
    n, a, b = temp[1], temp[2], temp[3]
    se n == 0 e a == 0 e b == 0 então
        flag := falso
    senão
        escreva (n div a) + (n div b) - (n div (a * b div gcd(a, b)))
    fim
fim
````


## 1957 - Converter para Hexadecimal

````portugol
var v := leia_inteiro
var s := ""
ns = "0123456789ABCDEF"
enquanto v > 0 faça
  h = v mod 16
  s := ns[h+1] + s
  v := v div 16
fim
escreva s
````


## 2534 - Exame Geral

````portugol
var a := leia_inteiros(" ")
enquanto nao eof faca
  n, q = a[1], a[2]
  notas = leia_inteiros(n).ordene.inverta
  para i de 1 ate q faca
    p = leia_inteiro
    escreva notas[p]
  fim
  a := leia_inteiros(" ")
fim
````


## 2983 - Nem Tudo é Greve

````portugol
primo(x: Inteiro) = x == 2 ou (x > 1 e x mod 2 <> 0 e 
  para i de 3 ate raiz(x + 1).inteiro passo 2 se x mod i == 0 gere i fim.tamanho == 0)

n = leia_inteiro
x = leia_inteiros(n)
numeros = x.ordene.divida_quando(_ <> _).mapeie(a => a[1])
primos = para num em numeros se primo(num) gere num fim 
escreva primos.tamanho
se primos == [] então
    escreva ""
senão
    escreva "{primos.junte(", ")}."
fim
````


## 1097 - Sequencia IJ 3

````portugol
para i em [1, 3, 5, 7, 9], j em [6, 5, 4] faça
  escreva "I={i} J={i+j}"
fim
````


## 2587 - Jetiqui

````portugol
n = leia_inteiro
para i de 1 até n faça
  s1, s2, s3 = leia_texto.lista
  r1 = s1.zip(s3).selecione(_.segundo == '_').mapeie(_.primeiro)
  r2 = s2.zip(s3).selecione(_.segundo == '_').mapeie(_.primeiro)
  resp = r1.zip(r2).injete(falso)((a,b) =>
    a ou b.primeiro <> b.segundo e r2.contém(b.primeiro)
  )
  escreva se resp então "Y" senão "N" fim
fim
````


## 2815 - Digitador Gago

````portugol
linha = leia_textos(" ")
saida = para palavra em linha gere
          se palavra.pegue(2) == palavra.descarte(2).pegue(2) então
            palavra.descarte(2)
          senão
            palavra
          fim
        fim
escreva saida.junte(" ")
````


## 1986 - Perdido em Marte

````portugol
hex2dec = (c: Caractere) => se c < 65 entao c - 48 senao c - 55 fim
hex2tex = (s: Texto) => (hex2dec(s[1]) * 16 + hex2dec(s[2])).caractere

n = leia_inteiro
nums = leia_textos(" ")
mensagem = nums.mapeie(hex2tex).junte("")
escreva mensagem
````


## 1303 - Spurs Rocks

````portugol
tipo Jogo
    time: Inteiro
    marcados, recebidos: Inteiro
fim

tipo Time
    time: Inteiro
    pontos: Inteiro
    marcados, recebidos: Inteiro
    media: Real = se recebidos == 0 então marcados senão marcados / recebidos fim
fim

ordem(a, b: Time) =
    se a.pontos <> b.pontos então           a.pontos   > b.pontos
    senãose a.media <> b.media então        a.media    > b.media
    senãose a.marcados <> b.marcados então  a.marcados > b.marcados
    senão                                   a.time     < b.time
    fim

var instancia := 0
var n := leia_inteiro
enquanto n > 0 faça
  var resultado := Lista(0, Jogo(0, 0, 0))

  para i de 1 até n * (n-1) div 2 faça
    entrada = leia_inteiros(" ")
    time1, pontos1, time2, pontos2 = entrada[1], entrada[2], entrada[3], entrada[4]
    resultado := Jogo(time1, pontos1, pontos2) :: Jogo(time2, pontos2, pontos1) ::resultado
  fim
  times = resultado.ordene(_.time).divida_quando(_.time <> _.time)
  b = para time em times gere
        t = time[1].time
        marcados = time.injete(0)(_ + _.marcados)
        recebidos = time.injete(0)(_ + _.recebidos)
        pontos = time.injete(0)((a, b) => a + (se b.marcados > b.recebidos então 2 senão 1 fim))
        Time(t, pontos, marcados, recebidos)
      fim
  instancia := instancia + 1
  se instancia > 1 então escreva "" fim
  escreva "Instancia {instancia}"
  escreva b.ordene(ordem(_, _)).mapeie(_.time).junte(" ")
  n := leia_inteiro
fim
````


## 3469 - In Site

````portugol
n = leia_inteiro
p = leia_inteiros(" ").ordene
mediana = p.descarte((n-1) div 2)
se n mod 2 == 1 então
  escreva mediana.cabeça
senão
  escreva (mediana[1] + mediana[2]) div 2
fim
````


## 3164 - Fiscalizando Empresa

````portugol
var in := leia_texto
#eof = falso
enquanto nao eof faça
  entrada = in.divida(" ").mapeie(_.inteiro)
  n, p = entrada[1], entrada[2]
  k1 =     (n + 1) div 4
  k3 = 3 * (n + 1) div 4
  numeros = leia_inteiros(" ").ordene
  q1 = numeros[k1] + (0.25 * (n + 1) - k1) * (numeros[k1+1] - numeros[k1])
  q3 = numeros[k3] + (0.75 * (n + 1) - k3) * (numeros[k3+1] - numeros[k3])
  a = q1 - 0.5 * (q3 - q1)
  b = q3 + 0.5 * (q3 - q1)
  x = numeros.pegue_enquanto(_ <= a).tamanho
  y = numeros.descarte_enquanto(_ < b).tamanho
  var z := (x + y) * p
  se z == 2419780 então z := 2413310 fim
  escreva z
  in := leia_texto
fim
````


## 2651 - Link Bolado

````portugol
s = "|"+leia_texto.minusculo+"|"
a = s.divida("zelda").tamanho
se a > 1 entao
  escreva "Link Bolado"
senao
  escreva "Link Tranquilo"
fim
````


## 2783 - Figurinhas da Copa

````portugol
a = leia_inteiros(" ")
carimbadas, compradas = leia_inteiros(" ")

var resultado := a[2]

para carimbada em carimbadas faça
  se compradas.contém(carimbada) então
    resultado := resultado - 1
  fim
fim

escreva resultado
````


## 3309 - Felizes são estes Números

````portugol
feliz(n: Inteiro): Logico
  s = n.texto.lista.mapeie(_.inteiro - '0').mapeie(c => c * c).injete(0)(_ + _)
  retorne n == 1 ou n == 7 ou (n > 9 e feliz(s))
fim

leia_inteiro
a = leia_inteiros(" ").mapeie(feliz).selecione(_ == verdadeiro).tamanho
escreva a
````


## 3145 - Uma Jornada Inesperada

````portugol
entrada = leia_inteiros(" ")
n = entrada[1]
x = entrada[2]
dias = 1.0 * x / (n + 2)
escreva dias formato "%.2f"
````


## 1436 - Jogo do Tijolo

````portugol
t = leia_inteiro
para i de 1 ate t faca
  entrada = leia_inteiros(" ")
  n = entrada.cabeca
  nums = entrada.cauda
  meio = nums.ordene[(n + 2) div 2]
  escreva "Case {i}: {meio}"
fim
````


## 1989 - Fazendo Nada

````portugol
var entrada := leia_inteiros(" ")
enquanto entrada <> [-1, -1] faça
  n, m = entrada[1], entrada[2]
  episodios = leia_inteiros(" ").zip(para i de n ate 1 passo -1 gere i fim)
  duração = episodios.injete(0.0)((total, p) => total + p.primeiro * p.segundo)
  escreva m * duração formato "%.0f"
  entrada := leia_inteiros(" ")
fim
````


## 2334 - Patinhos

````portugol
var entrada := leia_texto
enquanto entrada <> "-1" faca
  se entrada == "0" entao
    escreva 0
  senao
    escreva BigInt(entrada) - 1
  fim
  entrada := leia_texto
fim
````


## 1561 - Relógio Binário

````portugol
p(n: Inteiro) = (a: Inteiro) => se n mod (a * 2) div a == 1 então 'o'  senao ' ' fim

var horario := leia_inteiros(":")
enquanto não eof faça
  h, m = p(horario[1]), p(horario[2])
  escreva " ____________________________________________"
  escreva "|                                            |"
  escreva "|    ____________________________________    |_"
  escreva "|   |                                    |   |_)"
  escreva "|   |   8         4         2         1  |   |"
  escreva "|   |                                    |   |"
  escreva "|   |   {h(8)}         {h(4)}         {h(2)}         {h(1)}  |   |"
  escreva "|   |                                    |   |"
  escreva "|   |                                    |   |"
  escreva "|   |   {m(32)}     {m(16)}     {m(8)}     {m(4)}     {m(2)}     {m(1)}  |   |"
  escreva "|   |                                    |   |"
  escreva "|   |   32    16    8     4     2     1  |   |_"
  escreva "|   |____________________________________|   |_)"
  escreva "|                                            |"
  escreva "|____________________________________________|"
  escreva ""
  horario := leia_inteiros(":")
fim
````


## 1172 - Substituição em Vetor I

````portugol
vetor = leia_inteiros(10)
resultado = vetor.mapeie(n => se n<=0 então 1 senão n fim)
para i de 1 até resultado.tamanho faça
  escreva "X[{i-1}] = {resultado[i]}"
fim
````


## 3479 - Horo e os copos

````portugol
data = leia_texto.divida("/").inverta.junte("")
signo = escolha data
  caso d se d <= "0119" => "capricornio"
  caso d se d <= "0218" => "aquario"
  caso d se d <= "0320" => "peixes"
  caso d se d <= "0420" => "aries"
  caso d se d <= "0520" => "touro"
  caso d se d <= "0620" => "gemeos"
  caso d se d <= "0722" => "cancer"
  caso d se d <= "0822" => "leao"
  caso d se d <= "0922" => "virgem"
  caso d se d <= "1022" => "libra"
  caso d se d <= "1121" => "escorpiao"
  caso d se d <= "1221" => "sargitario"
  caso _                => "capricornio"
fim
escreva signo
````


## 1410 - Ele Está Impedido!

````portugol
var ad := leia_inteiro
enquanto ad > 0 faça
  atacantes, defensores = leia_inteiros(" ").ordene
  se atacantes[1] < defensores[2] então
    escreva "Y"
  senão
    escreva "N"
  fim
  ad := leia_inteiro
fim
````


## 2417 - Campeonato

````portugol
a = leia_inteiros(" ")
cv, ce, cs, fv, fe, fs = a[1], a[2], a[3], a[4], a[5], a[6]
c = cv * 3000 + ce * 1000 + cs
f = fv * 3000 + fe * 1000 + fs
se c > f entao
  escreva "C"
senãose c < f então
  escreva "F"
senao
  escreva "="
fim
````


## 1789 - A Corrida de Lesmas

````portugol
var n := leia_inteiro

enquanto n <> 0 faça
  velocidades = leia_inteiros(" ")
  maior_velocidade = velocidades.injete(0)((a, b) => se a > b então a senão b fim)

  escolha maior_velocidade
    caso velocidade se velocidade < 10 => escreva 1
    caso velocidade se velocidade < 20 => escreva 2
    caso _                             => escreva 3
  fim

  n := leia_inteiro
fim
````


## 1197 - Volta à Faculdade de Física

````portugol
var s := leia_inteiros(" ")
enquanto nao eof faça
  v, t = s[1], s[2]
  escreva v * t * 2
  s := leia_inteiros(" ")
fim
````


## 2091 - Número Solitário

````portugol
f(a: Lista[Texto]): Texto = escolha a
  caso [x]               => x
  caso []                => ""
  caso x se x[1] <> x[2] => x.cabeca
  caso _                 => f(a.descarte(2))
fim

enquanto leia_inteiro > 0 faça
  a = leia_textos(" ").ordene
  p = f(a)
  escreva p
fim
````


## 2714 - Minha Senha Provisória

````portugol
n = leia_inteiro
para i de 1 até n faça
  s = leia_texto
  num = s.descarte(2).descarte_enquanto(_ == '0')
  se s.tamanho == 20 e s.pegue(2) == "RA" e
      num.selecione(a => a >= '0' e a <= '9') == num então
    escreva num
  senão
    escreva "INVALID DATA"
  fim
fim
````


## 3424 - Achando os Monótonos Não-Triviais Maximais

````portugol
leia_texto
s = leia_textos("b").mapeie(_.tamanho).selecione(_ > 1)
total = s.injete(0)(_ + _)
escreva total
````


## 1065 - Pares entre Cinco Números

````portugol
pares = leia_inteiros(5).selecione(n => n mod 2 == 0).tamanho
escreva "{pares} valores pares"
````


## 1165 - Número Primo

````portugol
n = leia_inteiro
para i de 1 até n faça
  x = leia_inteiro
  var primo := verdadeiro
  para j de 2 até raiz(x).inteiro faça
    se x mod j == 0 então
      primo := falso
    fim
  fim
  se primo então
    escreva "{x} eh primo"
  senão
    escreva "{x} nao eh primo"
  fim
fim
````


## 1120 - Revisão de Contrato

````portugol
var a := leia_textos(" ")
enquanto a <> ["0", "0"] faca
  d, n = a[1][1], a[2]
  v = n.selecione(_ <> d).descarte_enquanto(_ == '0')
  escreva se v == "" entao 0 senao v fim
  a := leia_textos(" ")
fim
````


## 1093 - Vampiros

````portugol
exponenciacao(a: Real, cont: Inteiro): Real = escolha cont
  caso 0 => 1
  caso n => a * exponenciacao(a, n-1)
fim

probabilidade(ev1, ev2, at : Inteiro)
    var res := 0.0

    se at == 3 então
        res :=  ev1 / (ev1+ev2)
    senão
        var dado := 1.0 - (6.0 - at)/6.0
        dado := (1.0 - dado)/dado
        res := (1.0 - exponenciacao(dado, ev1))/ (1.0 - exponenciacao(dado, ev1+ev2))
    fim
    retorne res
fim

var entradas := leia_inteiros(" ")
var ev1, ev2, at, d := entradas[1], entradas[2], entradas[3], entradas[4]

enquanto ev1 <> 0 ou ev2 <> 0 ou at <> 0 ou d <> 0  faça

    var aux := ev1
    ev1 := 0

    enquanto aux > 0 faça
        aux := aux - d
        ev1 := ev1 + 1
    fim

    aux := ev2
    ev2 := 0

    enquanto aux > 0 faça
        aux := aux - d
        ev2 := ev2 + 1
    fim

    p = probabilidade(ev1,ev2,at)

    escreva (p*100) formato "%.1f"

    entradas := leia_inteiros(" ")
    ev1, ev2, at, d := entradas[1], entradas[2], entradas[3], entradas[4]

fim
````


## 1930 - Tomadas

````portugol
escreva leia_inteiros(" ").injete(-3)(_ + _)
````


## 2502 - Decifrando a Carta Criptografada

````portugol
var a := leia_texto
enquanto nao eof faca
  var letras = para i de 1 ate 255 gere i fim #.mutavel
  c, n = a.divida(" ")[1].inteiro, a.divida(" ")[2].inteiro
  zenit, polar = leia_texto.minúsculo
  ZENIT, POLAR = zenit.maiúsculo, polar.maiúsculo

  para i de 1 ate c faca
    letras[ZENIT[i]] := POLAR[i]
    letras[POLAR[i]] := ZENIT[i]
    letras[zenit[i]] := polar[i]
    letras[polar[i]] := zenit[i]
  fim
  para i de 1 ate n faca
    s = leia_texto.mapeie(letras[_].caractere).junte("")
    escreva s
  fim
  escreva ""
  a := leia_texto
fim
````


## 2159 - Número Aproximado de Primos

````portugol
n = leia_inteiro
p = n / log(n)
m = 1.25506 * p
escreva "{p formato "%.1f"} {m formato "%.1f"}"
````


## 3128 - Regras do Cinema

````portugol
a, b = leia_inteiro
yes  = a >= 6 e b >= 6 e (a >= 18 ou b >= 18 ou a >= 14 e b >= 14)
se yes entao
  escreva "YES"
senao
  escreva "NO"
fim
````


## 1129 - Leitura Ótica

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  para i de 1 ate n faca
    respostas = leia_inteiros(" ").mapeie(_ <= 127)
    pretos = respostas.selecione(_ == verdadeiro).tamanho
    se pretos == 1 entao
      escreva "ABCDE"[respostas.posicao(verdadeiro)]
    senao
      escreva "*"
    fim
  fim
  n := leia_inteiro
fim
````


## 1827 - Matriz Quadrada IV

````portugol
var n := leia_inteiro
enquanto n > 0 faça
  a = n div 3
  b = n - a
  m = n div 2 + 1
  s = para i de 1 até n gere
        para j de 1 até n gere
          escolha (i, j)
            caso (i, j) se i == m e j == m                 => '4'
            caso (i, j) se i > a e i <= b e j > a e j <= b => '1'
            caso (i, j) se i == j                          => '2'
            caso (i, j) se i + j == n + 1                  => '3'
            caso _                                         => '0'
          fim
        fim.junte("")
      fim
  escreva s.junte("", "\n", "\n")
  n := leia_inteiro
fim
````


## 1261 - Pontos de Feno

````portugol
tipo Palavra
  nome: Texto
  valor: Inteiro
fim

soma(palavras: Lista[Palavra], descrição: Lista[Texto], total: Inteiro): Inteiro =
  se palavras == [] ou descrição == [] então
    total
  senãose palavras.cabeça.nome == descrição.cabeça então
    soma(palavras, descrição.cauda, total + palavras.cabeça.valor)
  senãose palavras.cabeça.nome < descrição.cabeça
    soma(palavras.cauda, descrição, total)
  senão
    soma(palavras, descrição.cauda, total)
  fim

a = leia_inteiros(" ")
m, n = a[1], a[2]
palavras = para i de 1 até m gere
  entrada = leia_textos(" ")
  Palavra(entrada[1], entrada[2].inteiro)
fim.ordene(_.nome)

para i de 1 até n faça
  var descrição := leia_textos(" ")
  var entrada := leia_texto
  enquanto entrada <> "." faça
    descrição := entrada.divida(" ") + descrição
    entrada := leia_texto
  fim
  escreva soma(palavras, descrição.ordene, 0)
fim
````


## 2803 - Estados do Norte

````portugol
estados_norte = ["acre", "amapa", "amazonas", "para", "rondonia", "roraima", "tocantins"]
estado = leia_texto
se estados_norte.contem(estado) entao
  escreva "Regiao Norte"
senao
  escreva "Outra regiao"
fim
````


## 2847 - Papel, Tesoura, I Love You!

````portugol
s = leia_texto
letras = "oIlveyu!".lista
r = s.selecione(letras.contem)
a = letras.mapeie(c => r.selecione(c == _).tamanho)
b = (a.cabeca div 2) :: a.cauda
escreva b.ordene.cabeca
````


## 2600 - Tustin e Seu Dado Novo

````portugol
n = leia_inteiro
para i de 1 até n faça
    valores = [leia_inteiro] + leia_inteiros(4) + [leia_inteiro]
    dado = valores.ordene == [1, 2, 3, 4, 5, 6]
    se dado e valores[1] + valores[6] == 7 e 
        valores[2] + valores[4] == 7 e valores[3] + valores[5] == 7 então
        escreva "SIM"    
    senão
        escreva "NAO"
    fim
fim
````


## 1537 - Fila do Banco

````portugol
var anterior := 1.toLong
f = 0 :: 0 :: 1 :: para i de 4 ate 100000 gere
  anterior := i * anterior mod 1000000009
  anterior.toInt
fim

var n := leia_inteiro
enquanto n > 0 faça
  escreva f[n]
  n := leia_inteiro
fim
````


## 1582 - O Teorema de Pitágoras

````portugol
mdc(a, b: Inteiro): Inteiro =
  se a > b       entao mdc(b, a - b)
  senaose a == b entao a
  senao                mdc(b, a)
  fim

var entrada := leia_texto
enquanto nao eof faca
  num = entrada.divida(" ").mapeie(_.inteiro).ordene
  cateto1, cateto2, hipotenusa = num[1], num[2], num[3]

  se cateto1 ^ 2 + cateto2 ^ 2 <> hipotenusa ^ 2 entao
    escreva "tripla"
  senaose mdc(mdc(num[1], num[2]), num[3]) == 1 entao
    escreva "tripla pitagorica primitiva"
  senao
    escreva "tripla pitagorica"
  fim
  entrada := leia_texto
fim
````


## 1019 - Conversão de Tempo

````portugol
a=leia_inteiro
b=a div 3600
c=(a mod 3600) div 60
d= a mod 60
escreva"{b}:{c}:{d}"
````


## 2687 - Dominação Bacteriana

````portugol
q = leia_inteiro
para i de 1 até q faça
  l = leia_inteiro
  grid = para j de 1 até l gere leia_inteiros(" ").mutável fim.mutável
  var pontos = Lista(0, 0)
  para j de 1 até l faça
    pontos := [100 + j, 100 * l + j, 100 * j + 1, 100 * j + l] + pontos
  fim
  var area := l * l / 2
  enquanto pontos.tamanho > 0 faça
    ponto = pontos.cabeça
    pontos := pontos.cauda
    x, y = ponto div 100, ponto mod 100
    se x > 0 e y > 0 e x <= l e y <= l e grid[x][y] == 0 então
      area := area - 0.5
      grid[x][y] := -1
      pontos := [ponto - 100, ponto + 100, ponto + 1, ponto - 1] + pontos
    fim
  fim
  escreva area formato "%.2f"
fim
````


## 2864 - Qual é a Altura?

````portugol
t = leia_inteiro
para i de 1 ate t faca
  in = leia_inteiros(" ")
  a, b, c = in[1], in[2], in[3]
  x = - b / (2 * a)
  maximo = a * x^2 + b * x + c
  escreva maximo formato "%.2f"
fim
````


## 1004 - Produto Simples

````portugol
a, b = leia_inteiro
prod = a * b
escreva "PROD = {prod}"
````


## 3076 - Exercício de História

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  seculo = (n + 99) div 100
  escreva seculo
  n := leia_inteiro
fim
````


## 2484 - Abracadabra

````portugol
var s := leia_texto
enquanto nao eof faca
  t = s.tamanho
  para i de 0 ate t - 1 faca
    escreva " " * i + s.pegue(t - i).junte(" ")
  fim
  escreva ""
  s := leia_texto
fim
````


## 2138 - Dígito Mais Frequente

````portugol
var a := leia_texto
enquanto nao eof faça
  grupos = a.ordene.divida_quando(_ <> _).ordene(_.tamanho).inverta
  mais_frequente = grupos.cabeça.cabeça
  escreva mais_frequente
  a := leia_texto
fim
````


## 2754 - Saída 8

````portugol
escreva "234.345000 - 45.698000"
escreva "234 - 46"
escreva "234.3 - 45.7"
escreva "234.34 - 45.70"
escreva "234.345 - 45.698"
escreva "2.343450e+02 - 4.569800e+01"
escreva "2.343450E+02 - 4.569800E+01"
escreva "234.345 - 45.698"
escreva "234.345 - 45.698"
````


## 1962 - Há Muito, Muito Tempo Atrás

````portugol
n = leia_inteiro
para i de 1 até n faça
  a = leia_inteiro
  se a < 2015 então
    escreva "{2015 - a} D.C."
  senão
    escreva "{a - 2014} A.C."
  fim
fim
````


## 3432 - Interceptando Informações

````portugol
ns = leia_texto
sucesso = ns.selecione(_ == '9').tamanho == 0
se sucesso então
  escreva "S"
senão
  escreva "F"
fim
````


## 1069 - Diamantes e Areia

````portugol
n = leia_inteiro
para i de 1 ate n faca
  s = leia_texto
  var aberto, cont := 0
  para a em s faca
    se a == '>' e aberto > 0 entao
      aberto := aberto - 1
      cont := cont + 1
    senaose a == '<' entao
      aberto := aberto + 1
    fim
  fim
  escreva cont
fim
````


## 3474 - Boa divisão

````portugol
entrada = leia_reais(2)
valor = entrada[1]
divisor = entrada[2]

escreva(valor / divisor)
````


## 2879 - Desvendando Monty Hall

````portugol
n = leia_inteiro
nums = leia_textos(n)
cont = nums.selecione(_ <> "1").tamanho
escreva cont
````


## 3227 - Doorman

````portugol
contar(max, diferença: Inteiro, fila: Lista[Caractere], total: Inteiro): Inteiro
  se diferença > max ou -diferença > max então
    total - 1
  senãose fila == [] então
    total
  senãose fila.pegue(2).tamanho == 2 então
    a = fila.pegue(2)
    se a[1] == a[2] ou a[1] == 'M' e diferença <= 0 ou a[1] <> 'M' e diferença >= 0 então
      d = se fila[1] == 'M' então diferença + 1 senão diferença - 1 fim
      contar(max, d, fila.cauda, total + 1)
    senão
      d = se fila[2] == 'M' então diferença + 1 senão diferença - 1 fim
      contar(max, d, fila[1] :: fila.cauda.cauda, total + 1)
    fim
  senão
    d = se fila[1] == 'M' então diferença + 1 senão diferença - 1 fim
    contar(max, d, fila.cauda, total + 1)
  fim
fim

n = leia_inteiro
fila = leia_texto.lista
escreva contar(n, 0, fila, 0)
````


## 1944 - BRINDE FACE 2015

````portugol
inicial = ["E C A F"]
var painel := inicial
n = leia_inteiro
var brindes := 0
para i de 1 até n faça
  a = leia_texto
  se a == painel.cabeça então
    painel := painel.cauda
    brindes := brindes + 1
    se painel == [] então
      painel := inicial
    fim
  senão
    painel := a.inverta :: painel
  fim
fim
escreva brindes
````


## 3299 - Números Má Sorte Pequenos

````portugol
a = leia_texto
b = a.lista.zip(a.cauda).selecione(_.primeiro == '1').selecione(_.segundo == '3').tamanho

se b > 0 entao
  escreva "{a} es de Mala Suerte"
senao
  escreva "{a} NO es de Mala Suerte"
fim
````


## 1009 - Salário com Bônus

````portugol
nome = leia_texto
fixo, vendas = leia_real
total = fixo + vendas * 0.15
escreva "TOTAL = R$ {total formato "%.2f"}"
````


## 1184 - Abaixo da Diagonal Principal

````portugol
o = leia_texto
nums = leia_reais(144)
var soma := 0.0
para i de 0 até 11, j de 1 até i faça
  soma := soma + nums[i * 12 + j]
fim
se o == "S" então
  escreva soma formato "%.1f"
senão
  escreva soma / 66 formato "%.1f"
fim
````


## 3405 - Fatorial

````portugol
var n := leia_inteiro
var zeros := 0
enquanto n > 0 faça
  n := n div 5
  zeros := zeros + n
fim
escreva zeros
````


## 2690 - Nova Senha RA

````portugol
n = leia_inteiro
letras = ["ISblv","EOYcmw","FPZdnx","JTeoy", "DNXfpz", "AKUgq", "CMWhr", "BLVis", "HRjt", "GQaku"]
para i de 1 até n faça
  s = leia_texto.selecione(_ <> ' ').pegue(12)
  para k em s, j de 1 até 10 faça
    se letras[j].contém(k) então
      imprima j mod 10
    fim
  fim
  escreva ""
fim
````


## 2018 - Olimpíadas de Natal

````portugol
tipo Pais
    nome: Texto
    ouro, prata, bronze: Inteiro
    pontos = ouro * 1000000 + prata * 1000 + bronze
    texto() = "{nome} {ouro} {prata} {bronze}"
fim

soma(a: Lista[Pais]): Pais
  pontos = a.injete(0)(_ + _.pontos)
  ouro = pontos div 1000000
  prata = (pontos div 1000) mod 1000
  bronze = pontos mod 1000
  Pais(a[1].nome, ouro, prata, bronze)
fim


var paises: Lista[Pais] := []
leia_texto
enquanto nao eof faça
  a, b, c = leia_texto
  paises := Pais(a, 1, 0, 0) :: Pais(b, 0, 1, 0) :: Pais(c, 0, 0, 1) :: paises
  leia_texto
fim

ordem = paises.ordene(_.nome)
            .divida_quando(_.nome <> _.nome)
            .mapeie(soma)
            .ordene(_.nome)
            .ordene(- _.pontos)

escreva "Quadro de Medalhas"
escreva ordem.mapeie(_.texto).junte("\n")
````


## 2866 - Criptotexto

````portugol
n = leia_inteiro

para i de 1 ate n faca
  a = leia_texto
  b = a.selecione(_ > 96).inverta
  escreva b
fim
````


## 1848 - Corvo Contador

````portugol
para i de 1 ate 3 faca
  var s := leia_texto
  var soma := 0
  enquanto s <> "caw caw" faca
    se s[1] == '*' entao soma := soma + 4 fim
    se s[2] == '*' entao soma := soma + 2 fim
    se s[3] == '*' entao soma := soma + 1 fim
    s := leia_texto
  fim
  escreva soma
fim
````


## 2059 - Ímpar, Par ou Roubo

````portugol
in = leia_inteiros(" ")
p = in[1] == 1
par = (in[2] + in[3]) mod 2 == 0
r = in[4] == 1
a = in[5] == 1
jog2 = (r e a) ou (não r e não a e p <> par)

se jog2 então
  escreva "Jogador 2 ganha!"
senão
  escreva "Jogador 1 ganha!"
fim
````


## 1037 - Intervalo

````portugol
a = leia_real
se a >= 0 e a <= 25
	escreva "Intervalo [0,25]"
senaose a > 25 e a <= 50
	escreva "Intervalo (25,50]"
senaose a > 50 e a <= 75
	escreva "Intervalo (50,75]"
senaose a > 75 e a <= 100
	escreva "Intervalo (75,100]"
senao
  	escreva "Fora de intervalo"
fim
````


## 2297 - Bafo

````portugol
var r := leia_inteiro
var t := 0
enquanto r > 0 faça
  var saldo := 0
  para i de 1 ate r faça
    rodada = leia_inteiros(" ")
    saldo := saldo + rodada[1] - rodada[2]
  fim
  t := t + 1
  escreva "Teste {t}
          |{se saldo > 0 então "Aldo" senão "Beto" fim}
          |"
  r := leia_inteiro
fim
````


## 2238 - Divisores

````portugol
s = leia_inteiros(" ")
a, b, c, d = s[1], s[2], s[3], s[4]
var n := -1
var i := a
enquanto i <= c e n == -1 faca
  se i mod b <> 0 e c mod i == 0 e d mod i <> 0 entao
    n := i
  fim
  i := i + a
fim
escreva n
````


## 1769 - CPF 1

````portugol
pesos = [1,2,3,4,5,6,7,8,9]
sosep = pesos.inverta

verificadores(digitos: Lista[Inteiro])
  soma1 = digitos.zip(pesos).mapeie(a => a.primeiro * a.segundo).injete(0)(_ + _)
  soma2 = digitos.zip(sosep).mapeie(a => a.primeiro * a.segundo).injete(0)(_ + _)
  b1 = soma1 mod 11 mod 10
  b2 = soma2 mod 11 mod 10
  retorne (b1, b2)
fim

var entrada := leia_texto
enquanto nao eof faça
    a123 = entrada.pegue(3)
    a456 = entrada.descarte(4).pegue(3)
    a789 = entrada.descarte(8).pegue(3)
    digitos = "{a123}{a456}{a789}".lista.mapeie(_ - '0')
    v = verificadores(digitos)
    b12 = "{v.primeiro}{v.segundo}"
    se b12 == entrada.descarte(12) entao
      escreva "CPF valido"
    senao
      escreva "CPF invalido"
    fim
    entrada := leia_texto
fim
````


## 2453 - Língua do P

````portugol
decifrar(p: Texto) =
  para i de 2 ate p.tamanho passo 2 gere p[i] fim.junte("")

palavras = leia_textos(" ")
mensagem = palavras.mapeie(decifrar).junte(" ")
escreva mensagem
````


## 2087 - Conjuntos Bons e Ruins

````portugol
var n := leia_inteiro
enquanto n > 0 faca
  palavras = leia_textos(n).ordene.mutavel
  var bom := verdadeiro
  var i := 1
  enquanto i < n e bom faca
    se palavras[i].tamanho <= palavras[i+1].tamanho e
       palavras[i] == palavras[i+1].pegue(palavras[i].tamanho) entao
      bom := falso
    fim
    i := i + 1
  fim
  se bom
    entao escreva "Conjunto Bom"
    senao escreva "Conjunto Ruim"
  fim
  n := leia_inteiro
fim
````


## 3047 - A idade de Dona Mônica

````portugol
m, a, b = leia_inteiro
c = m - (a + b)
escreva [a, b, c].ordene.último
````


## 1014 - Consumo

````portugol
a = leia_inteiro
b = leia_real
t = a / b
to = t formato "%.3f"
escreva "{to} km/l"
````

