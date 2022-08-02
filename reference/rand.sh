#!/bin/bash -e

test -f rand && rm rand
gcc -m32 -O -DNEVER rand.c -o rand
./rand
