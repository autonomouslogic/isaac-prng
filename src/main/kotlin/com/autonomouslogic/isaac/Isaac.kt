import java.util.Collections.min
import java.util.GregorianCalendar

class Isaac {
	val randrsl: IntArray
	var randcnt: Int = 0
	val mm: IntArray = IntArray(256)
	var aa: Int = 0
	var bb: Int = 0
	var cc: Int = 0

	constructor(seed: IntArray) {
		randrsl = createSeed(seed)
		randinit()
	}

	fun nextInt(): Int {
		if (randcnt == 256) {
			isaac()
			randcnt = 0
		}
		return randrsl[randcnt++]
	}

	private fun isaac() {
		var x: Int
		var y: Int

		// cc just gets incremented once per 256 results
		cc = cc + 1
		// then combined with bb
		bb = bb + cc;

		for (i in 0..255) {
			x = mm[i];

			when (i%4) {
				0 -> aa = aa xor (aa shl 13)
				1 -> aa = aa xor (aa ushr 6)
				2 -> aa = aa xor (aa shl 2)
				3 -> aa = aa xor (aa ushr 16)
			}
			aa = mm[(i + 128) % 256] + aa
			y  = mm[(x ushr 2).mod(256)] + aa + bb
			mm[i] = y
			bb = mm[(y ushr 10).mod(256)] + x
			randrsl[i] = bb

			/* Note that bits 2..9 are chosen from x but 10..17 are chosen
			   from y.  The only important thing here is that 2..9 and 10..17
			   don't overlap.  2..9 and 10..17 were then chosen for speed in
			   the optimized version (rand.c) */
			/* See http://burtleburtle.net/bob/rand/isaac.html
			   for further explanations and analysis. */
		}
	}

	private fun mix(s: IntArray) {
		s[0] = s[0] xor ( s[1] shl 11 )
		s[3] += s[0]
		s[1] += s[2]

		s[1] = s[1] xor ( s[2] ushr 2 )
		s[4] += s[1]
		s[2] += s[3]

		s[2] = s[2] xor ( s[3] shl 8 )
		s[5] += s[2]
		s[3] += s[4]

		s[3] = s[3] xor ( s[4] ushr 16 )
		s[6] += s[3]
		s[4] += s[5]

		s[4] = s[4] xor ( s[5] shl 10 )
		s[7] += s[4]
		s[5] += s[6]

		s[5] = s[5] xor ( s[6] ushr 4 )
		s[0] += s[5]
		s[6] += s[7]

		s[6] = s[6] xor ( s[7] shl 8 )
		s[1] += s[6]
		s[7] += s[0]

		s[7] = s[7] xor ( s[0] ushr 9 )
		s[2] += s[7]
		s[0] += s[1]
	}

	private fun randinit() {
		val s = IntArray(8)
		for (i in s.indices) {
			s[i] = GOLDEN_RATIO
		}

		// Scramble it.
		for (i in 1..4) {
			mix(s)
		}

		// fill in mm[] with messy stuff
		for (i in 0 .. 255 step 8) {
			s[0] += randrsl[i]
			s[1] += randrsl[i+1]
			s[2] += randrsl[i+2]
			s[3] += randrsl[i+3]
			s[4] += randrsl[i+4]
			s[5] += randrsl[i+5]
			s[6] += randrsl[i+6]
			s[7] += randrsl[i+7]

			mix(s)

			mm[i  ] = s[0]
			mm[i+1] = s[1]
			mm[i+2] = s[2]
			mm[i+3] = s[3]
			mm[i+4] = s[4]
			mm[i+5] = s[5]
			mm[i+6] = s[6]
			mm[i+7] = s[7]
		}

		// do a second pass to make all of the seed affect all of mm
		for (i in 0 .. 255 step 8) {
			s[0] += mm[i  ]
			s[1] += mm[i+1]
			s[2] += mm[i+2]
			s[3] += mm[i+3]
			s[4] += mm[i+4]
			s[5] += mm[i+5]
			s[6] += mm[i+6]
			s[7] += mm[i+7]

			mix(s);

			mm[i  ] = s[0]
			mm[i+1] = s[1]
			mm[i+2] = s[2]
			mm[i+3] = s[3]
			mm[i+4] = s[4]
			mm[i+5] = s[5]
			mm[i+6] = s[6]
			mm[i+7] = s[7]
		}

		// fill in the first set of results
		isaac()
		// prepare to use the first set of results
		randcnt = 256
	}

	companion object {
		val SEED_SIZE: Int = 256
		val GOLDEN_RATIO: Int = 0x9e3779b9.toInt()

		fun createSeed(seed: IntArray): IntArray {
			if (seed.size == SEED_SIZE) {
				return seed
			}
			val newSeed = IntArray(SEED_SIZE)
			val n = minOf(seed.size, SEED_SIZE)
			for (i in 0..n-1) {
				newSeed[i] = seed[i]
			}
			return newSeed
		}
	}
}
