#!/bin/bash -e

test -f readable && rm readable
gcc -m32 -O readable.c -o readable
./readable
