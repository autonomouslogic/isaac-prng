package com.autonomouslogic.isaac

import Isaac
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsaacTest {
	@Test
	fun shouldGenerateNumbers() {
		val rng = Isaac(uintArrayOf(1u, 2u, 3u))
		assertEquals(1u, rng.nextInt())
		assertEquals(2u, rng.nextInt())
		assertEquals(3u, rng.nextInt())
	}
}
