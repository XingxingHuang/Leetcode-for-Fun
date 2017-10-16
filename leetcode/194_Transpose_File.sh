# Read from the file file.txt and print its transposed content to stdout.
# awk
awk '
{
    for (i = 1; i <= NF; i++) {
        if(NR == 1) {
            s[i] = $i;
        } else {
            s[i] = s[i] " " $i;
        }
    }
}
END {
    for (i = 1; s[i] != ""; i++) {
        print s[i];
    }
}' file.txt



#BASH
ncol=`head -n1 file.txt | wc -w`

for i in `seq 1 $ncol`
do
    echo `cut -d' ' -f$i file.txt`
done


# 
#!/bin/bash

declare -A matrix
col=1
row=1

while read line; do
    col=1
    for word in $line; do
            matrix[$row,$col]=$word
            ((col++))
    done
    ((row++))
done < file.txt

for ((i=1;i<col;i++)) do
    echo -n ${matrix[1,$i]} 
    for((j=2;j<row;j++)) do
            echo -n ' '${matrix[$j,$i]}
    done
    echo
done