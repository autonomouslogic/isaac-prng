#!/bin/bash -e

test -f isaac64 && rm isaac64
gcc -m32 -O isaac64.c -o isaac64
./isaac64
