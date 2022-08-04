package com.autonomouslogic.isaac

import Isaac
import kotlin.test.Test
import kotlin.test.assertEquals

internal class IsaacTest {
	// From randvect.txt
	val zeroSeedSequence: IntArray = intArrayOf(
		0xf650e4c8.toInt(), 0xe448e96d.toInt(), 0x98db2fb4.toInt(), 0xf5fad54f.toInt(), 0x433f1afb.toInt(), 0xedec154a.toInt(), 0xd8370487.toInt(), 0x46ca4f9a.toInt(),
		0x5de3743e.toInt(), 0x88381097.toInt(), 0xf1d444eb.toInt(), 0x823cedb6.toInt(), 0x6a83e1e0.toInt(), 0x4a5f6355.toInt(), 0xc7442433.toInt(), 0x25890e2e.toInt(),
		0x7452e319.toInt(), 0x57161df6.toInt(), 0x38a824f3.toInt(), 0x002ed713.toInt(), 0x29f55449.toInt(), 0x51c08d83.toInt(), 0xd78cb99e.toInt(), 0xa0cc74f3.toInt(),
		0x8f651659.toInt(), 0xcbc8b7c2.toInt(), 0xf5f71c69.toInt(), 0x12ad6419.toInt(), 0xe5792e1b.toInt(), 0x860536b8.toInt(), 0x09b3ce98.toInt(), 0xd45d6d81.toInt(),
		0xf3b26129.toInt(), 0x17e38f85.toInt(), 0x29cf72ce.toInt(), 0x349947b0.toInt(), 0xc998f9ff.toInt(), 0xb5e13dae.toInt(), 0x32ae2a2b.toInt(), 0xf7cf814c.toInt(),
		0x8ebfa303.toInt(), 0xcf22e064.toInt(), 0x0b923200.toInt(), 0xeca4d58a.toInt(), 0xef53cec4.toInt(), 0xd0f7b37d.toInt(), 0x9c411a2a.toInt(), 0xffdf8a80.toInt(),
		0xb40e27bc.toInt(), 0xb4d2f976.toInt(), 0x44b89b08.toInt(), 0xf37c71d5.toInt(), 0x1a70e7e9.toInt(), 0x0bdb9c30.toInt(), 0x60dc5207.toInt(), 0xb3c3f24b.toInt(),
		0xd7386806.toInt(), 0x229749b5.toInt(), 0x4e232cd0.toInt(), 0x91dabc65.toInt(), 0xa70e1101.toInt(), 0x8b87437e.toInt(), 0x5781414f.toInt(), 0xcdbc62e2.toInt(),
		0x8107c9ff.toInt(), 0x69d2e4ae.toInt(), 0x3b18e752.toInt(), 0xb143b688.toInt(), 0x6f4e0772.toInt(), 0x95138769.toInt(), 0x943c3c74.toInt(), 0xafc17a97.toInt(),
		0x0fd43963.toInt(), 0x6a529b0b.toInt(), 0xd8c58a6a.toInt(), 0xa8bcc22d.toInt(), 0x2db35dfe.toInt(), 0xa7a2f402.toInt(), 0x6cb167db.toInt(), 0x538e1f4e.toInt(),
		0x7275e277.toInt(), 0x1d3b8e97.toInt(), 0xecc5dc91.toInt(), 0x15e3a5b9.toInt(), 0x03696614.toInt(), 0x30ab93ec.toInt(), 0xac9fe69d.toInt(), 0x7bc76811.toInt(),
		0x60eda8da.toInt(), 0x28833522.toInt(), 0xd5295ebc.toInt(), 0x5adb60e7.toInt(), 0xf7e1cdd0.toInt(), 0x97166d14.toInt(), 0xb67ec13a.toInt(), 0x210f3925.toInt(),
		0x64af0fef.toInt(), 0x0d028684.toInt(), 0x3aea3dec.toInt(), 0xb058bafb.toInt(), 0xb8b0ccfc.toInt(), 0xf2b5cc05.toInt(), 0xe3a662d9.toInt(), 0x814bc24c.toInt(),
		0x2364a1aa.toInt(), 0x37c0ed05.toInt(), 0x2b36505c.toInt(), 0x451e7ec8.toInt(), 0x5d2a542f.toInt(), 0xe43d0fbb.toInt(), 0x91c8d925.toInt(), 0x60d4d5f8.toInt(),
		0x12a0594b.toInt(), 0x9e8a51da.toInt(), 0xcd49ebdb.toInt(), 0x1b0dcdc1.toInt(), 0xcd57c7f7.toInt(), 0xe6344451.toInt(), 0x7ded386f.toInt(), 0x2f36fa86.toInt(),
		0xa6d12101.toInt(), 0x33bc405d.toInt(), 0xb388d96c.toInt(), 0xdb6dbe96.toInt(), 0xfe29661c.toInt(), 0x13edc0cb.toInt(), 0xcb0eee4a.toInt(), 0x70cc94ae.toInt(),
		0xde11ed34.toInt(), 0x0606cf9f.toInt(), 0x3a6ce389.toInt(), 0x23d74f4e.toInt(), 0xa37f63ff.toInt(), 0x917bdec2.toInt(), 0xd73f72d4.toInt(), 0x0e7e0e67.toInt(),
		0x3d77d9a2.toInt(), 0x13add922.toInt(), 0x8891b3db.toInt(), 0x01a9bd70.toInt(), 0x56a001e3.toInt(), 0xd51f093d.toInt(), 0xcc033ce3.toInt(), 0x5ad0d3b0.toInt(),
		0x34105a8c.toInt(), 0x6a123f57.toInt(), 0xbd2e5024.toInt(), 0x7364944b.toInt(), 0xe89b1a3b.toInt(), 0x21835c4d.toInt(), 0x9f39e2d9.toInt(), 0xd405ded8.toInt(),
		0x294d37e5.toInt(), 0xbccaaeed.toInt(), 0x35a124b5.toInt(), 0x6708a2bc.toInt(), 0xb00960ba.toInt(), 0x2a98121a.toInt(), 0x4d8fae82.toInt(), 0x0bb3263f.toInt(),
		0x12595a19.toInt(), 0x6a107589.toInt(), 0x0809e494.toInt(), 0x21c171ec.toInt(), 0x884d6825.toInt(), 0x14c8009b.toInt(), 0xb0b84e7b.toInt(), 0x03fb88f4.toInt(),
		0x28e7cb78.toInt(), 0x9388b13b.toInt(), 0xdd2dc1d5.toInt(), 0x848f520a.toInt(), 0x07c28cd1.toInt(), 0x68a39358.toInt(), 0x72c9137d.toInt(), 0x127dd430.toInt(),
		0xc613f157.toInt(), 0x8c2f0d55.toInt(), 0xf7d3f39f.toInt(), 0x309bfb78.toInt(), 0x8406b137.toInt(), 0x46c0a6f5.toInt(), 0x3718d597.toInt(), 0x08607f04.toInt(),
		0x76904b6d.toInt(), 0x04db4e13.toInt(), 0xcd7411a7.toInt(), 0xb510ce0e.toInt(), 0xbfc7f7cc.toInt(), 0xb83f957a.toInt(), 0xfdfef62d.toInt(), 0xc35e4580.toInt(),
		0x3ff1e524.toInt(), 0x4112d96c.toInt(), 0x02c9b944.toInt(), 0xd5990dfb.toInt(), 0xe7e26581.toInt(), 0x0d9c7e7e.toInt(), 0x826dfa89.toInt(), 0x66f1e0ab.toInt(),
		0x30bcc764.toInt(), 0xeadebeac.toInt(), 0xed35e5ee.toInt(), 0x0c571a7d.toInt(), 0xe4f3a26a.toInt(), 0xf7f58f7b.toInt(), 0xadf6bc23.toInt(), 0x5d023e65.toInt(),
		0x1ed3ff4e.toInt(), 0xec46b0b6.toInt(), 0xd2a93b51.toInt(), 0xe75b41c9.toInt(), 0x7e315aeb.toInt(), 0x61119a5a.toInt(), 0x53245b79.toInt(), 0x33f6d7b1.toInt(),
		0xcae8deba.toInt(), 0x50fc8194.toInt(), 0xafa92a6d.toInt(), 0xc87c8006.toInt(), 0x4188bfcd.toInt(), 0x8bace62e.toInt(), 0x78ffa568.toInt(), 0x5597ec0f.toInt(),
		0xb4415f7d.toInt(), 0x08294766.toInt(), 0xad567643.toInt(), 0x09c36f90.toInt(), 0x3dde9f39.toInt(), 0x4a0a283c.toInt(), 0x18080c8e.toInt(), 0x080c79ec.toInt(),
		0x79ae4c10.toInt(), 0xcb9e1563.toInt(), 0x7cdd662f.toInt(), 0x62d31911.toInt(), 0xa4ca0cf1.toInt(), 0x5cf824cd.toInt(), 0x3b708f99.toInt(), 0x1e16614c.toInt(),
		0xb6b9d766.toInt(), 0x5de87abb.toInt(), 0x7229ea81.toInt(), 0xd5b2d750.toInt(), 0x56e6cd21.toInt(), 0xfe1e42d5.toInt(), 0x96da2655.toInt(), 0xc2b9aa36.toInt(),
		0xb8f6fd4a.toInt(), 0x6a158d10.toInt(), 0x01913fd3.toInt(), 0xaf7d1fb8.toInt(), 0x0b5e435f.toInt(), 0x90c10757.toInt(), 0x6554abda.toInt(), 0x7a68710f.toInt(),
		0x82ac484f.toInt(), 0xd7e1c7be.toInt(), 0x95c85eaa.toInt(), 0x94a302f4.toInt(), 0x4d3cfbda.toInt(), 0x786b2908.toInt(), 0x1010b275.toInt(), 0x82d53d12.toInt(),
		0x21e2a51c.toInt(), 0x3d1e9150.toInt(), 0xb059261d.toInt(), 0xd0638e1a.toInt(), 0x31860f05.toInt(), 0x81f2864d.toInt(), 0xff4cfc35.toInt(), 0x0451516d.toInt(),
		0xbd086f26.toInt(), 0xbc5654c1.toInt(), 0x65dfa427.toInt(), 0xa82427f5.toInt(), 0x582e3014.toInt(), 0xb8d2486d.toInt(), 0xc79a1749.toInt(), 0x9a1d7745.toInt(),
		0x8766bb54.toInt(), 0x1e04a7f7.toInt(), 0x3d3dff8a.toInt(), 0xd5ec6bf4.toInt(), 0xdbef7d9f.toInt(), 0x36ec0ea3.toInt(), 0x1feb2e4f.toInt(), 0x15cfcc5c.toInt(),
		0xd8c423fb.toInt(), 0xd0ef3cc9.toInt(), 0xeb244925.toInt(), 0xba5590c8.toInt(), 0xa5f48ac4.toInt(), 0x33c5321c.toInt(), 0x613b67b2.toInt(), 0x479c3a22.toInt(),
		0xe21339cc.toInt(), 0x10d210aa.toInt(), 0x931dd7e2.toInt(), 0xef05ee06.toInt(), 0xb82f2703.toInt(), 0xa385cb2c.toInt(), 0x5d67133c.toInt(), 0x877eb7b4.toInt(),
		0x1e3437f7.toInt(), 0x5afb43ae.toInt(), 0x53c078f3.toInt(), 0x94d90481.toInt(), 0x1d964589.toInt(), 0x08063a85.toInt(), 0xe1322228.toInt(), 0x1956b1e5.toInt(),
		0x31860f13.toInt(), 0x2e7b022f.toInt(), 0x21182ca3.toInt(), 0x96f703ac.toInt(), 0x46819e2e.toInt(), 0x0d28fe52.toInt(), 0x3724d4dc.toInt(), 0xa0eabe6b.toInt(),
		0xc66699fd.toInt(), 0xc6112fdd.toInt(), 0x19c1e69c.toInt(), 0x04d3658a.toInt(), 0x4b55dd99.toInt(), 0x31907d62.toInt(), 0xf854b522.toInt(), 0x4d678f26.toInt(),
		0x22ae0582.toInt(), 0xeafed133.toInt(), 0xe4a51d21.toInt(), 0x84bd6dd6.toInt(), 0xc1a51375.toInt(), 0x3f28ee63.toInt(), 0xfb737b1a.toInt(), 0x70a1660e.toInt(),
		0x8a8dfaa3.toInt(), 0x1be79937.toInt(), 0xf7476978.toInt(), 0x513c1764.toInt(), 0x531ac6bf.toInt(), 0x12c06908.toInt(), 0x001cdb95.toInt(), 0x1a4b6a53.toInt(),
		0xd067fce5.toInt(), 0x12b2cfb6.toInt(), 0x9ddb477f.toInt(), 0x740e0066.toInt(), 0x39ddf25a.toInt(), 0xcc8bfa2d.toInt(), 0xf1b20eaf.toInt(), 0x64f2632c.toInt(),
		0x9783cdee.toInt(), 0x63bfd4d8.toInt(), 0x0084cfe5.toInt(), 0x75f4e9e2.toInt(), 0x19b48fd0.toInt(), 0x6c48ddd8.toInt(), 0x7a36af93.toInt(), 0x71865c4c.toInt(),
		0x9ce0199d.toInt(), 0x867027d7.toInt(), 0x2cb7b77f.toInt(), 0x84ef01da.toInt(), 0x72f5972f.toInt(), 0x040f7074.toInt(), 0xdf9afa29.toInt(), 0xc921f94e.toInt(),
		0x75c08a36.toInt(), 0x18c1ef9a.toInt(), 0xd649a428.toInt(), 0xc5b71937.toInt(), 0x8a30738a.toInt(), 0xd97cd348.toInt(), 0x858129a6.toInt(), 0x239e3b0a.toInt(),
		0xbbb8abc4.toInt(), 0x80fac4c2.toInt(), 0xecfcf20b.toInt(), 0xd9d711f9.toInt(), 0xe2a4ef71.toInt(), 0xb5fe87c0.toInt(), 0xbe8b06b2.toInt(), 0xaafef5a7.toInt(),
		0x9c15db3b.toInt(), 0x0aeb8165.toInt(), 0x4389a84a.toInt(), 0x253b1d7a.toInt(), 0x19047c79.toInt(), 0x7cdc78a2.toInt(), 0xd20adf03.toInt(), 0x56f55a71.toInt(),
		0x3e730fa8.toInt(), 0xfd8650d8.toInt(), 0x959e234e.toInt(), 0xb7546681.toInt(), 0xdad1b22a.toInt(), 0x142a6e85.toInt(), 0x8ef4bce6.toInt(), 0x68235b9d.toInt(),
		0x85a13f85.toInt(), 0x74096ae7.toInt(), 0xa949bea2.toInt(), 0x29322d0d.toInt(), 0xd5683858.toInt(), 0x82846526.toInt(), 0x403dae08.toInt(), 0x6dd1943a.toInt(),
		0xe1279bff.toInt(), 0x9e7e4f04.toInt(), 0x1c3a4524.toInt(), 0x484525e4.toInt(), 0x81d4cc5f.toInt(), 0xe24124c0.toInt(), 0x037464c0.toInt(), 0xbf1bd691.toInt(),
		0x26ceb003.toInt(), 0x275ead3a.toInt(), 0xc5bde908.toInt(), 0x26414ff3.toInt(), 0xa30519ad.toInt(), 0xd7b43abe.toInt(), 0x2ce5d3d5.toInt(), 0x88412761.toInt(),
		0x97ca2070.toInt(), 0xe5fbb9c7.toInt(), 0x276df0b4.toInt(), 0x308f751f.toInt(), 0x37a97df6.toInt(), 0xc9cd808c.toInt(), 0xfe4cb380.toInt(), 0x3d469303.toInt(),
		0xaee19096.toInt(), 0xc0d5d42a.toInt(), 0x4e823ad3.toInt(), 0xf5f9cc3b.toInt(), 0x4286619c.toInt(), 0x9ca45e1c.toInt(), 0x66c97340.toInt(), 0x891aec49.toInt(),
		0x45bae606.toInt(), 0xc798f047.toInt(), 0x52649d6c.toInt(), 0xce86fdfc.toInt(), 0x80c6e402.toInt(), 0xd6ec2f2b.toInt(), 0x27c82282.toInt(), 0x1fe26ce0.toInt(),
		0x92f57ea7.toInt(), 0xde462f4d.toInt(), 0x07497cae.toInt(), 0x5a48755c.toInt(), 0x721502dd.toInt(), 0x6cbe7935.toInt(), 0x836d8003.toInt(), 0x9ead7f70.toInt(),
		0x9ab3a42f.toInt(), 0x4c8652d6.toInt(), 0x32e39273.toInt(), 0xe8fa3860.toInt(), 0x1da4f25a.toInt(), 0x0cd6ef81.toInt(), 0x02503f7d.toInt(), 0x8854a0a1.toInt(),
		0x9a30c4e8.toInt(), 0x88157153.toInt(), 0x05efe294.toInt(), 0x57c4c925.toInt(), 0x2887d96f.toInt(), 0xc1a71e3c.toInt(), 0xe9f84163.toInt(), 0x2d0985de.toInt(),
		0xd21e796c.toInt(), 0x6fb5ce56.toInt(), 0x02614abf.toInt(), 0xc3c7be2c.toInt(), 0xb54fed6f.toInt(), 0xa617a083.toInt(), 0xc3142d8f.toInt(), 0x6079e4ce.toInt(),
		0xceffc147.toInt(), 0x1d0cb81b.toInt(), 0xdc153e5f.toInt(), 0xe36ef5bb.toInt(), 0xd531161a.toInt(), 0x165b1015.toInt(), 0x7aa114ed.toInt(), 0x3f7579b3.toInt(),
		0xf7f395f1.toInt(), 0xbc6172c7.toInt(), 0xa86f875e.toInt(), 0x0e6c51b3.toInt(), 0xcdfec2af.toInt(), 0x73c0e762.toInt(), 0x824c2009.toInt(), 0xc5a87748.toInt(),
		0x94d40125.toInt(), 0x8aba3ffb.toInt(), 0xd32be060.toInt(), 0x8c17eff0.toInt(), 0x21e2547e.toInt(), 0x07cffad9.toInt(), 0x05340e15.toInt(), 0xf3310c92.toInt(),
		0x9d8d1908.toInt(), 0x86ba527f.toInt(), 0xf943f672.toInt(), 0xef73fbf0.toInt(), 0x46d95ca5.toInt(), 0xc54cd95b.toInt(), 0x9d855e89.toInt(), 0x4bb5af29.toInt()
	)

	@Test
	fun shouldGenerateZeroSeedReferenceSequence() {
		val rng = Isaac(IntArray(256))
		for (i in zeroSeedSequence.indices) {
			val v = zeroSeedSequence[i]
			assertEquals(Integer.toHexString(v), Integer.toHexString(rng.nextInt()), "i: $i")
		}
	}
}
