#!/bin/bash -e

test -f randport && rm randport
gcc -O -DNEVER randport.c -o randport
./randport
