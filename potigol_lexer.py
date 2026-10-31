# potigol_lexer.py
from pygments.lexer import RegexLexer, include, words, bygroups
from pygments.token import *

class PotigolLexer(RegexLexer):
    name = 'Potigol'
    aliases = ['potigol', 'poti']
    filenames = ['*.poti', '*.potigol']
    mimetypes = ['text/x-potigol']

    tokens = {
        'root': [
            (r'\s+', Text),
            (r'#.*$', Comment.Single),
            (r'"', String.Double, 'string'),

            # Instanciação de objetos (novo)
            (r'\b([A-Z]\w*)(\s*)(\()', bygroups(Name.Class, Text, Punctuation)),

            # Definição de tipos/classes abstratas
            (r'\b(tipo)\b(\s+)(abstrato)\b(\s+)(\w+)', bygroups(Keyword, Text, Keyword, Text, Name.Class)),
            (r'\b(fim)\b', Keyword),

            # Definição de tipos/classes
            (r'\b(tipo)\b(\s+)(\w+)', bygroups(Keyword, Text, Name.Class)),
            (r'\b(fim)\b', Keyword),
            
            # Membros da classe
            (r'^\s+(\w+)\s*:', bygroups(Name.Attribute)),

            # Palavras-chave (controle de fluxo, declarações, etc.)
            (words((
                'se', 'então', 'entao', 'senão', 'senao', 'senaose', 'senãose',
                'escolha', 'caso', 'para', 'em', 'enquanto', 'fim', 'faca', 'faça',
                'gere', 'ate', 'até', 'de', 'passo', 'retorne', 'use', 'tipo',
                'abstrato', 'var', 'def', 'val', 'modulo', 'módulo', 'isto',
            ), prefix=r'\b', suffix=r'\b'), Keyword),

                        # Funções embutidas
            (words((
                'leia_texto', 'leia_numero', 'leia_inteiro', 'leia_real', 
                'leia_inteiros', 'leia_textos', 'leia_reais', 'inteiro', 
                'arredonde', 'texto', 'formato', 'real', 'tamanho',
                'posição', 'posicão', 'posiçao', 'posicao',
                'contém', 'maiúsculo','minúsculo', 'contem', 'maiusculo','minusculo', 
                'inverta', 'divida', 'cabeça', 'cabeca', 
                'primeiro', 'cauda', 'último', 'ultimo', 'pegue', 'descarte', 'selecione', 
                'descarte_enquanto', 'pegue_enquanto', 'ordene', 'junte', 
                'remova', 'insira', 'imutável', 'mutável', 'imutavel', 'mutavel','mapeie', 'injete', 
                'PI', 'sen', 'cos', 'tg', 'arcsen', 'arccos', 'arctg', 'abs', 
                'raiz', 'log', 'log10', 'segundo', 'terceiro', 'quarto', 'quinto', 'sexto',
                'sétimo', 'setimo', 'oitavo', 'nono', 'décimo', 'decimo',
            ), suffix=r'\b'), Name.Function),

            # Tipos da linguagem
            (words((
                'Inteiro', 'Real', 'Texto', 'Lógico', 'Logico', 'Caractere', 'Lista',
            ), prefix=r'\b', suffix=r'\b'), Keyword.Type),
            # Funções predefinidas (built-ins)
            (words(('escreva', 'imprima'), prefix=r'\b', suffix=r'\b'), Name.Builtin),
            # Valores booleanos
            (words(('verdadeiro', 'falso'), prefix=r'\b', suffix=r'\b'), Keyword.Constant),
            # Operadores lógicos e matemáticos
            (words(('e', 'ou', 'nao', 'não', 'div', 'mod', 'formato'), prefix=r'\b', suffix=r'\b'), Operator.Word),
            # Identificadores (nomes de variáveis, funções, etc.)
            (r'(?u)\b[a-zA-Z_À-ÿ][a-zA-Z0-9_À-ÿ]*\b', Name),
            # Números (inteiros e reais)
            (r'[-+]?[0-9]+\.[0-9]+([eE][-+]?[0-9]+)?', Number.Float),
            (r'[-+]?[0-9]+', Number.Integer),
            # Caracteres
            (r"'(\\.|.)'", String.Char),
            # Operadores e símbolos
            (r'::|=>|:=|[=!<>]=?|\+|-|\*|/|\^|\.', Operator),
            (r'[\[\](){}.,;:]', Punctuation),

        ],
        'string': [
            (r'"', String.Double, '#pop'),
            (r'\{', String.Interpol, 'interpolation'),
            (r'[^"{]+', String.Double),
        ],
        'interpolation': [
            (r'\}', String.Interpol, '#pop'),
            include('root'),
        ],
    }

__all__ = ['PotigolLexer', 'Potigol']

def setup(app):
    app.add_lexer('potigol', PotigolLexer())
