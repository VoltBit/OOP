#!/bin/bash

make clean
make build

no_tests=5

grade=0
for i in `seq 0 $(($no_tests - 1))`; do
	cp "input/test"$i".in" input.txt
	cp "ref/output"$i".txt" ref.txt
	make run 
	diff output.txt ref.txt
	if [  $? -eq 0 ]
 	then 
		grade=$(($grade+10));
		echo "test"$i".............10"
	else
		echo "test"$i"............. 0"
		# diff "output/test"$i".out" "ref/test"$i".ref"
	fi
	
	rm -rf ref.txt
done

echo ""
echo "GRADE.................................$grade";

