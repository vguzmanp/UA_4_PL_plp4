#!/bin/bash
die () {
    echo >&2 "$@"
    exit 1
}

[ "$#" -eq 1 ] || die "Hay que meter la ruta del fuente"

echo "Borrando $1.il y $1.exe"
rm -f $1.il $1.exe *.class

echo "===Compilando==="
./compilar-plp4.sh
echo "===Traduciendo==="
./ejecutar-plp4.sh $1 > $1.il
echo "===Ensamblando==="
ilasm $1.il 
echo "===Ejecutando==="
mono $1.exe
