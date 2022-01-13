#!/bin/bash -li

echo "/* Traducao de Potigol para Scala usando http://github.com/potigol/potigol2scala" > $1.scala
cat $1 >> $1.scala
echo "*/" >> $1.scala
cat potigolutil.scala >> $1.scala
echo "object Main extends App{" >> $1.scala
potigol -d $1 | tail -n +6 >> $1.scala
echo "}" >> $1.scala
cat $1.scala | clip.exe
