from setuptools import setup

setup(
    name='potigol_lexer',
    version='0.2',
    author='Potigol Team',
    py_modules=['potigol_lexer'],
    entry_points={
        'pygments.lexers': [
            'potigol = potigol_lexer:PotigolLexer',
        ],
    },
)