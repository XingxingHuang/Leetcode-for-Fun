Using grep:

grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt
Using sed:

sed -n -r '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/p' file.txt
Using awk:

awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt