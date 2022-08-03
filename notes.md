# Notes

## Reference Implementation

* `randport` is the only one which produces an output that matches `randvect.txt`, which is probably due to a 64-bit processor.
* Installing `gcc-multilib` and compiling the non-64-bit versions with `-m32` produced the correct outputs.
  * I'm not sure if isaac64 is supposed to be compiled in this way, but adding the 32-bit option does make the output cleaner.

## Other Implementations

### Commons Math ISAACRandom

* https://github.com/apache/commons-math/blob/MATH_3_6_1/src/main/java/org/apache/commons/math3/random/ISAACRandom.java
* https://github.com/apache/commons-math/blob/MATH_3_6_1/src/test/java/org/apache/commons/math3/random/ISAACTest.java
* https://github.com/apache/commons-rng/blob/RNG_1_3/commons-rng-core/src/main/java/org/apache/commons/rng/core/source32/ISAACRandom.java
* https://github.com/apache/commons-rng/blob/RNG_1_3/commons-rng-core/src/test/java/org/apache/commons/rng/core/source32/ISAACRandomTest.java
* [Added by Eldar Agalarov in 2011](https://issues.apache.org/jira/browse/MATH-710)
* Includes an extra initialisation step not included in the reference implementation for when the provided seed is less than 256 integers:\
  `(int) (0x6c078965L * (k ^ k >> 30) + j & 0xffffffffL)`\
  This is the seed init from [Mersenne Twister](http://en.wikipedia.org/wiki/Mersenne_twister).
