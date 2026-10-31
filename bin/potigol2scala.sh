#!/bin/bash

SCRIPT_DIR="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
INPUT="$1"
OUTPUT="${INPUT}.scala"

echo "/* Traducao de Potigol para Scala usando http://github.com/potigol/potigol2scala" > "$OUTPUT"
cat "$INPUT" >> "$OUTPUT"
echo "*/" >> "$OUTPUT"
cat "$SCRIPT_DIR/potigolutil.scala" >> "$OUTPUT"
echo "object Main extends App{" >> "$OUTPUT"
java -jar "$SCRIPT_DIR/potigol.jar" -d "$INPUT" | tail -n +6 >> "$OUTPUT"
echo "}" >> "$OUTPUT"
