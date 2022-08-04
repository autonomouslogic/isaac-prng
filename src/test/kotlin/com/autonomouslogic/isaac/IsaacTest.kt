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

	// Generated from readable.c by setting the first integer to 0xffffffff
	val fSeedSequence: IntArray = intArrayOf(
		0xde3b3f3c.toInt(), 0x19e0629c.toInt(), 0x1fc8b783.toInt(), 0x6695d523.toInt(), 0xe7804edd.toInt(), 0x86ff7ce9.toInt(), 0xb106f52c.toInt(), 0xaebae9d9.toInt(),
		0x72f845d4.toInt(), 0x9ce17d7d.toInt(), 0xa44e49ba.toInt(), 0xe954aac0.toInt(), 0xd0b1284b.toInt(), 0x98a88eec.toInt(), 0x1524fb6b.toInt(), 0xc91a16b5.toInt(),
		0x1192ac53.toInt(), 0x34131446.toInt(), 0xac2442de.toInt(), 0x9ff3d586.toInt(), 0x7b9b9148.toInt(), 0x881ee30a.toInt(), 0x6e87dd88.toInt(), 0xe5d1f7cd.toInt(),
		0x98db31ff.toInt(), 0x36f70d98.toInt(), 0x50cfefae.toInt(), 0xf42abb00.toInt(), 0xecc39ed3.toInt(), 0x08bf4b80.toInt(), 0x30cdc2b6.toInt(), 0xb7e42f0e.toInt(),
		0x908030dd.toInt(), 0x282f96ed.toInt(), 0xacc888b3.toInt(), 0xa986e109.toInt(), 0xc129998f.toInt(), 0x89baa1b5.toInt(), 0xda8970b0.toInt(), 0x7a6ab012.toInt(),
		0xf10264f2.toInt(), 0x3c315c9c.toInt(), 0x8e0c1649.toInt(), 0x55c68517.toInt(), 0xb6a4f982.toInt(), 0xb2626db7.toInt(), 0x0787f869.toInt(), 0xac6d551b.toInt(),
		0xe3493162.toInt(), 0x7c7058e9.toInt(), 0x65c502e1.toInt(), 0x8d2cd370.toInt(), 0xe6db3b70.toInt(), 0xd947d61a.toInt(), 0xa9717cf8.toInt(), 0x394f48c6.toInt(),
		0x3c796f3a.toInt(), 0x15495084.toInt(), 0x6badb28b.toInt(), 0x70d982f2.toInt(), 0x9bc67025.toInt(), 0x4e3e5e0f.toInt(), 0x8e36b0a5.toInt(), 0xf6da0a04.toInt(),
		0x6b235ed6.toInt(), 0xa42988c0.toInt(), 0x12bde74d.toInt(), 0x879fa8eb.toInt(), 0x5d59f5f4.toInt(), 0x0ed5e766.toInt(), 0x01c9847b.toInt(), 0x3edb2690.toInt(),
		0x566e609a.toInt(), 0xca22d187.toInt(), 0xf6ad8b62.toInt(), 0x6de6b77a.toInt(), 0x1e3356dd.toInt(), 0xd24ccef7.toInt(), 0xc70fd6a8.toInt(), 0x3beeab0f.toInt(),
		0x16b3d348.toInt(), 0x5629575f.toInt(), 0xb491c00e.toInt(), 0xad2a93a8.toInt(), 0x2cec30f5.toInt(), 0xd2ce1890.toInt(), 0x63b87e64.toInt(), 0x32aef543.toInt(),
		0x562f4954.toInt(), 0xc0fa6c36.toInt(), 0x64ec9806.toInt(), 0x4631e114.toInt(), 0x4899cd09.toInt(), 0xb0e151bd.toInt(), 0x385d1abe.toInt(), 0x88cfd11e.toInt(),
		0xa8f33006.toInt(), 0xbaaba7dc.toInt(), 0xf4a4c546.toInt(), 0xc42539b5.toInt(), 0xf0774663.toInt(), 0xca3310e4.toInt(), 0xfcefead6.toInt(), 0x03cb65de.toInt(),
		0x3714e54e.toInt(), 0x074e8e41.toInt(), 0x8a36795f.toInt(), 0x9e76e028.toInt(), 0x90926fec.toInt(), 0x4bbfa452.toInt(), 0x4185075c.toInt(), 0xb42e807d.toInt(),
		0x36114bad.toInt(), 0xd334540b.toInt(), 0xc4782c0c.toInt(), 0x535e60b2.toInt(), 0x33025fff.toInt(), 0xb1970914.toInt(), 0x307c91bf.toInt(), 0x459ac490.toInt(),
		0x73324a02.toInt(), 0x670a3562.toInt(), 0xc3d19219.toInt(), 0x51cc1abe.toInt(), 0x2530426e.toInt(), 0x591ebbfb.toInt(), 0x18fbdf88.toInt(), 0x4e230da1.toInt(),
		0x72072257.toInt(), 0x4ece7904.toInt(), 0x2966b946.toInt(), 0xfe8f2de5.toInt(), 0x9ff5b3d2.toInt(), 0x3701a778.toInt(), 0x9bbe217f.toInt(), 0xe3f95fa5.toInt(),
		0x0a6721a2.toInt(), 0x3d9a3cf6.toInt(), 0xa313b77c.toInt(), 0x9ef9b79c.toInt(), 0x4df19014.toInt(), 0xd8974f51.toInt(), 0xdd0b74e9.toInt(), 0x658ae7bd.toInt(),
		0x8d90b982.toInt(), 0xc0781fe3.toInt(), 0xdbf9c781.toInt(), 0xbd92bedd.toInt(), 0x442f0c86.toInt(), 0xc56c83db.toInt(), 0xa5a6eba1.toInt(), 0xdc2ae450.toInt(),
		0xca6542f2.toInt(), 0x6c13773e.toInt(), 0xe62e6216.toInt(), 0x4e337e45.toInt(), 0xd66a66ff.toInt(), 0xa37c74b7.toInt(), 0x8330a793.toInt(), 0x0c83e0a3.toInt(),
		0xb85a2d85.toInt(), 0xdba180bb.toInt(), 0x55b67a05.toInt(), 0x4de080d4.toInt(), 0xcbcb4515.toInt(), 0xf3702e49.toInt(), 0xd4b12975.toInt(), 0x13c94bf0.toInt(),
		0x39386750.toInt(), 0x37bd6d04.toInt(), 0xa10cc73a.toInt(), 0x8dc5c389.toInt(), 0x817fe485.toInt(), 0x151b58c6.toInt(), 0x75193b68.toInt(), 0x73b7a9f3.toInt(),
		0xb6f31dc5.toInt(), 0x86b88d7c.toInt(), 0x9363e8aa.toInt(), 0xb8933729.toInt(), 0xd7e62b40.toInt(), 0xb3a8c9e0.toInt(), 0xc1ac9970.toInt(), 0xfd850ee4.toInt(),
		0xff003b47.toInt(), 0x1ac83968.toInt(), 0xefe0ecf9.toInt(), 0xbf6e5056.toInt(), 0x083c100c.toInt(), 0xbd3a67fd.toInt(), 0x68cd7ab3.toInt(), 0xa955cb2f.toInt(),
		0x4d98a2d6.toInt(), 0x80e74608.toInt(), 0x1c860551.toInt(), 0x0537c595.toInt(), 0x8c22e343.toInt(), 0xad2c8c25.toInt(), 0x288f89a3.toInt(), 0x6671f86a.toInt(),
		0x00fd3897.toInt(), 0x46f4382c.toInt(), 0xacd1943f.toInt(), 0xae747e30.toInt(), 0xd0fe604e.toInt(), 0x984b3089.toInt(), 0x00d0df2e.toInt(), 0x7becbb2e.toInt(),
		0x52705ce8.toInt(), 0xce2afffa.toInt(), 0x6db486e8.toInt(), 0xefe918f3.toInt(), 0xee918793.toInt(), 0xf0d95621.toInt(), 0x8cc1d114.toInt(), 0x7593af6d.toInt(),
		0x05ed6a31.toInt(), 0x2279eef3.toInt(), 0x23f4cd97.toInt(), 0x7508022d.toInt(), 0xfcc332c8.toInt(), 0x746d3c91.toInt(), 0x8b5fbb1d.toInt(), 0xdc323c09.toInt(),
		0x4b57e01a.toInt(), 0xef400d3d.toInt(), 0x9803d79e.toInt(), 0x4dcf1880.toInt(), 0xdf32fc6d.toInt(), 0xe10a2511.toInt(), 0xe5699041.toInt(), 0xdf5f22e3.toInt(),
		0x2f52e5c9.toInt(), 0x6d320dcc.toInt(), 0xc5341acf.toInt(), 0x32dd8d5f.toInt(), 0x54bfa3cd.toInt(), 0x2fad4c98.toInt(), 0xd792a4c4.toInt(), 0xeeebdccc.toInt(),
		0xf1818b4b.toInt(), 0x0fb9f7f4.toInt(), 0xe30459af.toInt(), 0x68ff9372.toInt(), 0xc562c4ba.toInt(), 0x23021d4c.toInt(), 0x675b098f.toInt(), 0xd82831f0.toInt(),
		0x57107940.toInt(), 0xf17e39a7.toInt(), 0xcd2f9c0c.toInt(), 0x6a547acf.toInt(), 0xf1dbd4f4.toInt(), 0x532aa68d.toInt(), 0x1936879c.toInt(), 0xcb569edb.toInt(),
		0xdcc4d839.toInt(), 0x20c03007.toInt(), 0x7e73d8eb.toInt(), 0x0855bf00.toInt(), 0x6d541ec9.toInt(), 0x8089ab2e.toInt(), 0x6b8bb4f3.toInt(), 0x3887f055.toInt(),
		0x9796b228.toInt(), 0x2608e8cd.toInt(), 0x7df4239d.toInt(), 0x7a37bbdc.toInt(), 0xa12768d2.toInt(), 0x11606581.toInt(), 0x68a18dce.toInt(), 0xcfbd3a2d.toInt(),
		0x70b10c81.toInt(), 0xc1ad8de7.toInt(), 0xd6d0a7d0.toInt(), 0x936e2264.toInt(), 0x62ffeb95.toInt(), 0x17e72485.toInt(), 0x4fedb60e.toInt(), 0x67334fc8.toInt(),
		0xd689e953.toInt(), 0x89408b24.toInt(), 0x7a332491.toInt(), 0x789695a0.toInt(), 0x2f266c15.toInt(), 0x17852983.toInt(), 0xec7c78ed.toInt(), 0x390f7e48.toInt(),
		0xcbe72752.toInt(), 0x042b69f6.toInt(), 0xaa46c01c.toInt(), 0x2b34ff89.toInt(), 0xdcf8b114.toInt(), 0x9d5b20cf.toInt(), 0xd395df7b.toInt(), 0x60f68ea3.toInt(),
		0x9b596a3b.toInt(), 0xe47c6f36.toInt(), 0x7f167c7f.toInt(), 0x934b7da3.toInt(), 0x886469b0.toInt(), 0x4f1a2c7c.toInt(), 0xa299b914.toInt(), 0xe74b2a58.toInt(),
		0xb1540dd2.toInt(), 0xa0486ec8.toInt(), 0xe4f13426.toInt(), 0x6b0f725e.toInt(), 0x9d122f59.toInt(), 0xf74c1cce.toInt(), 0xd74e210b.toInt(), 0xfa477932.toInt(),
		0x6ac97d0c.toInt(), 0xe868cbb2.toInt(), 0xdcab6bb1.toInt(), 0x256e6397.toInt(), 0x75981b9a.toInt(), 0x8e2273be.toInt(), 0x15966621.toInt(), 0x17f8fcce.toInt(),
		0xe86982d1.toInt(), 0xcb878dff.toInt(), 0xdec7a560.toInt(), 0x34e59c4d.toInt(), 0x06b48b96.toInt(), 0x6b1b8cc5.toInt(), 0x56abe4f1.toInt(), 0x2e4d8490.toInt(),
		0x4f6f4f82.toInt(), 0xc514e949.toInt(), 0x39a67d86.toInt(), 0x33e257d6.toInt(), 0xe486ccf6.toInt(), 0x40713bf8.toInt(), 0xdf888f0f.toInt(), 0xa84893ed.toInt(),
		0x9dcdafc0.toInt(), 0x52a60c11.toInt(), 0x8caee9b5.toInt(), 0x4e1e88c4.toInt(), 0xedd82a69.toInt(), 0xc637e586.toInt(), 0x203b3441.toInt(), 0xc4ac2d90.toInt(),
		0x9bbcd177.toInt(), 0x458d0021.toInt(), 0x564a1940.toInt(), 0x02fdaf82.toInt(), 0x1fcbcf18.toInt(), 0xd279b12d.toInt(), 0x208102f5.toInt(), 0xa9c77096.toInt(),
		0x3b730947.toInt(), 0x549aeaac.toInt(), 0xf794a489.toInt(), 0x96d526d6.toInt(), 0x144cb6d1.toInt(), 0x61b8db84.toInt(), 0x4d0ee369.toInt(), 0x6e296047.toInt(),
		0xb3497dd1.toInt(), 0x11ed21ea.toInt(), 0xea0b1473.toInt(), 0xf0572d65.toInt(), 0x93b21ea8.toInt(), 0x0a5b2897.toInt(), 0x03f7c435.toInt(), 0xabab57ce.toInt(),
		0x47fa42f3.toInt(), 0xba045780.toInt(), 0x287681d3.toInt(), 0x908c0604.toInt(), 0xfafccca3.toInt(), 0xe08fd0ef.toInt(), 0xfbca9146.toInt(), 0x45c3c398.toInt(),
		0xfc0d5ce9.toInt(), 0x91d1f36e.toInt(), 0xe6481a7b.toInt(), 0x9fd8d72c.toInt(), 0xbeb9a7e7.toInt(), 0x4244e28f.toInt(), 0x58ba5a2c.toInt(), 0x7a07b620.toInt(),
		0x2b2638c9.toInt(), 0xaf39ec94.toInt(), 0x77f1b988.toInt(), 0x8afaa721.toInt(), 0xb9ff8d72.toInt(), 0xe0b00fb6.toInt(), 0xbeba159b.toInt(), 0xc37eeeee.toInt(),
		0x53eeb42e.toInt(), 0xb296d655.toInt(), 0x587c502f.toInt(), 0xf9707795.toInt(), 0xdb1966ed.toInt(), 0x3dbde26a.toInt(), 0x5c8bbe0c.toInt(), 0xab8bcf97.toInt(),
		0xb2726c05.toInt(), 0xa02990b8.toInt(), 0x17531bd0.toInt(), 0x8d0d42ba.toInt(), 0xa4450bec.toInt(), 0xcb72015e.toInt(), 0x6ca43afb.toInt(), 0xe8c51066.toInt(),
		0x194fcbbe.toInt(), 0x66213910.toInt(), 0xe3e78d2b.toInt(), 0x4159244e.toInt(), 0xab25d5e5.toInt(), 0xb068b521.toInt(), 0xdf1220d5.toInt(), 0xa91d96ad.toInt(),
		0xc0a2cfef.toInt(), 0x47c66e02.toInt(), 0x2d92efce.toInt(), 0xc4991912.toInt(), 0xf22a8417.toInt(), 0x3a8a84cf.toInt(), 0x0bad2996.toInt(), 0x08b5faca.toInt(),
		0xf32dbbd0.toInt(), 0xbbfff11e.toInt(), 0x181eb340.toInt(), 0x86ffe448.toInt(), 0xb632bcd4.toInt(), 0x25744006.toInt(), 0xaf240d9b.toInt(), 0xb9d3e2a5.toInt(),
		0x5a45ba05.toInt(), 0xe1098327.toInt(), 0x0a355736.toInt(), 0x4027c8c4.toInt(), 0xda636221.toInt(), 0x1cfbebb3.toInt(), 0xdf1df8cf.toInt(), 0x963edd69.toInt(),
		0x0b08ef1d.toInt(), 0x37d9a334.toInt(), 0x9efc63c5.toInt(), 0xf6b22bb8.toInt(), 0xae860c90.toInt(), 0x9a36a526.toInt(), 0xb854720d.toInt(), 0xee435d19.toInt(),
		0xae55f2f2.toInt(), 0x54e018b4.toInt(), 0x6f65be02.toInt(), 0x2e8fc671.toInt(), 0xb5db35d4.toInt(), 0x3310d5c0.toInt(), 0x6d3708b5.toInt(), 0x946a51f8.toInt(),
		0xcb84149f.toInt(), 0xc263bfba.toInt(), 0x5248ce2a.toInt(), 0x28bbc9e3.toInt(), 0x213e83f0.toInt(), 0x557ddc5b.toInt(), 0x6382465e.toInt(), 0xaa4e5dd8.toInt(),
		0xf9831240.toInt(), 0x863e71f8.toInt(), 0x8aa09fd4.toInt(), 0xb3961704.toInt(), 0x94260367.toInt(), 0xaa72f0bd.toInt(), 0x447235a8.toInt(), 0xc868bf95.toInt(),
		0x80610a59.toInt(), 0x1dd789ed.toInt(), 0x09c1b3c6.toInt(), 0x253d9e54.toInt(), 0xbe8212fb.toInt(), 0x0426d74e.toInt(), 0x2f1acdd3.toInt(), 0x1aea9618.toInt(),
		0xfd135370.toInt(), 0x5e6f0fc1.toInt(), 0x29e62bc6.toInt(), 0x5e8b53e0.toInt(), 0x8e48f43c.toInt(), 0x59a62025.toInt(), 0x1c669ce4.toInt(), 0xa13e0455.toInt(),
		0xddff8c43.toInt(), 0xfbeb5548.toInt(), 0x9cd9929d.toInt(), 0x23e73264.toInt(), 0x6d02cdf9.toInt(), 0x1671fb2a.toInt(), 0xcfa58134.toInt(), 0xb179bccd.toInt(),
		0x98d99eb6.toInt(), 0x7dbdd07c.toInt(), 0xeecefbc1.toInt(), 0x812c1c66.toInt(), 0x01f32d37.toInt(), 0x8e195be5.toInt(), 0x46b0402f.toInt(), 0x4bdc37c8.toInt(),
		0x51327018.toInt(), 0xaa9cce33.toInt(), 0x07686458.toInt(), 0x4cc33643.toInt(), 0x091368c8.toInt(), 0xc25c9d1c.toInt(), 0xb0b60bf7.toInt(), 0x3eb7ab37.toInt()
	)

	// Randomly generated seed, used for fullSeedSequence below.
	val fullSeed = intArrayOf(
		0x5ad74d2d.toInt(), 0x22d7596f.toInt(), 0xbb46315c.toInt(), 0xa614ede3.toInt(), 0x2d89f471.toInt(), 0xb7664d4f.toInt(), 0x35e3341b.toInt(), 0xa4caa8b3.toInt(),
		0xcd452649.toInt(), 0x8d75651f.toInt(), 0x4bbbe61b.toInt(), 0xd2275245.toInt(), 0x8d520279.toInt(), 0x07ae8e27.toInt(), 0xf11df564.toInt(), 0xed0b1cad.toInt(),
		0x1c935c11.toInt(), 0x5e79e3b7.toInt(), 0x34c1d712.toInt(), 0x1e9c37e5.toInt(), 0xea8f7d86.toInt(), 0xb008dae7.toInt(), 0x7b1042cd.toInt(), 0x53e3f567.toInt(),
		0x53ad3de1.toInt(), 0x272d4e8c.toInt(), 0x600560c0.toInt(), 0xbfadcf7a.toInt(), 0xb7064243.toInt(), 0xa2a88180.toInt(), 0x42b809cc.toInt(), 0xc97c7a08.toInt(),
		0x5547dbd5.toInt(), 0x18564376.toInt(), 0xedf4e074.toInt(), 0x90c32800.toInt(), 0x731ad640.toInt(), 0x77b93464.toInt(), 0xad33844e.toInt(), 0xdde6e349.toInt(),
		0x0e1302b4.toInt(), 0xda3fb036.toInt(), 0xe76c31ec.toInt(), 0xdd095587.toInt(), 0xfa441a79.toInt(), 0x9009bbf7.toInt(), 0xb054b9b5.toInt(), 0x41a68c7f.toInt(),
		0xaeba1003.toInt(), 0xcfd75e23.toInt(), 0x5dd9f253.toInt(), 0x6e280a42.toInt(), 0x87904d50.toInt(), 0x764659af.toInt(), 0x7f7730d8.toInt(), 0xee778771.toInt(),
		0x5772bea8.toInt(), 0x444d6c69.toInt(), 0x570a0972.toInt(), 0xa81abff7.toInt(), 0xa2ec28b9.toInt(), 0x2f9694ad.toInt(), 0x572d37a6.toInt(), 0x9d57d715.toInt(),
		0xc108c282.toInt(), 0x6aa58098.toInt(), 0x32219d33.toInt(), 0xa77c3fb9.toInt(), 0xa8622923.toInt(), 0xed433208.toInt(), 0xc0cbe1bd.toInt(), 0x25823c52.toInt(),
		0x133f001b.toInt(), 0xb1563515.toInt(), 0x34776704.toInt(), 0xba7900de.toInt(), 0x9e3dc1ec.toInt(), 0xce9f8644.toInt(), 0x9373505e.toInt(), 0xac2b6232.toInt(),
		0x8c7a6e55.toInt(), 0x34888a00.toInt(), 0x2495da3b.toInt(), 0x7dfb0d98.toInt(), 0x86516ccd.toInt(), 0x1b6eb880.toInt(), 0x9fbc858d.toInt(), 0xf257194d.toInt(),
		0x6d9ca338.toInt(), 0xd00f490e.toInt(), 0x10fd1f9d.toInt(), 0x6bd5599a.toInt(), 0xc0aa532c.toInt(), 0x93222c7e.toInt(), 0xcb66c54a.toInt(), 0x84ac5008.toInt(),
		0x1366d0e2.toInt(), 0xd3a97249.toInt(), 0x42e28cf5.toInt(), 0xe978ba60.toInt(), 0xac2059e1.toInt(), 0x57d1622b.toInt(), 0xf32ca597.toInt(), 0x43d86414.toInt(),
		0xe9521a99.toInt(), 0xf63ec131.toInt(), 0xbf1e6047.toInt(), 0x41955726.toInt(), 0x6166896a.toInt(), 0xa15de72e.toInt(), 0x6cbfbf9f.toInt(), 0x83ee33cf.toInt(),
		0x2b72fc0a.toInt(), 0x10b0d1b2.toInt(), 0x492cb471.toInt(), 0xbf90800c.toInt(), 0x5cf17c64.toInt(), 0x18ca4af1.toInt(), 0x2efa691b.toInt(), 0x77a3b7b3.toInt(),
		0x5c26b51f.toInt(), 0xf609cda8.toInt(), 0x1da310e3.toInt(), 0xd136e8af.toInt(), 0xea025ea1.toInt(), 0xef779a10.toInt(), 0x4615c77a.toInt(), 0x856d309f.toInt(),
		0x7356b1b2.toInt(), 0x4c12edd6.toInt(), 0xb50f45bf.toInt(), 0x242a6f10.toInt(), 0x7ba51cea.toInt(), 0xaf626ebc.toInt(), 0x4534da3b.toInt(), 0xacb2e54b.toInt(),
		0x04d94449.toInt(), 0xd258f9c7.toInt(), 0x947430a4.toInt(), 0xf46c915b.toInt(), 0x083f869b.toInt(), 0x5c87f08b.toInt(), 0x7162ca7a.toInt(), 0xedbef5f7.toInt(),
		0x84b67ea7.toInt(), 0x60b2b596.toInt(), 0x7512e056.toInt(), 0x097c6444.toInt(), 0xf3cc902e.toInt(), 0xe8eaf6ee.toInt(), 0xaa969df0.toInt(), 0x7fe8b45e.toInt(),
		0xdce36fbb.toInt(), 0x2f161682.toInt(), 0xe858d28f.toInt(), 0x61920981.toInt(), 0xa4d715c6.toInt(), 0x84c97852.toInt(), 0x5218efaf.toInt(), 0xc9deb850.toInt(),
		0x899dddc5.toInt(), 0xab692e32.toInt(), 0x42e27687.toInt(), 0xcbfe7bd4.toInt(), 0x76de5ddf.toInt(), 0xb8654974.toInt(), 0x2ddc8309.toInt(), 0x2def1d92.toInt(),
		0x8d60c7f5.toInt(), 0xfa590114.toInt(), 0x611d8688.toInt(), 0x6e0bd2df.toInt(), 0x0b69c3d9.toInt(), 0x1cf1d4c4.toInt(), 0x5cfd5078.toInt(), 0x492fc880.toInt(),
		0xeceefdcf.toInt(), 0x136a6f90.toInt(), 0x988c6364.toInt(), 0x6f59ce5e.toInt(), 0x7acd5bda.toInt(), 0xd3688fbd.toInt(), 0x97120dd5.toInt(), 0xe42e219d.toInt(),
		0x4f635837.toInt(), 0xb73a2d17.toInt(), 0xa38b8ee3.toInt(), 0x5a30ada9.toInt(), 0x071e807c.toInt(), 0xc4a9151a.toInt(), 0xf0a010a3.toInt(), 0xc849921a.toInt(),
		0x6e84e835.toInt(), 0xf1dd85c2.toInt(), 0xb9568382.toInt(), 0xd1cad14f.toInt(), 0x23b594f6.toInt(), 0x54b461f0.toInt(), 0x23278027.toInt(), 0x932e3671.toInt(),
		0xd8905a80.toInt(), 0x13f870c7.toInt(), 0x331209c1.toInt(), 0xa5de76c2.toInt(), 0x88484eb6.toInt(), 0x791d24fd.toInt(), 0x5fa7ed42.toInt(), 0xd3b3a8ae.toInt(),
		0x50f7ef2d.toInt(), 0x77813d4a.toInt(), 0xa270db3a.toInt(), 0x1be1ccd2.toInt(), 0xe87b6bef.toInt(), 0x3be466f5.toInt(), 0x0675f192.toInt(), 0xc1304315.toInt(),
		0xac5a1291.toInt(), 0x92dd5bb2.toInt(), 0x7ec25fa0.toInt(), 0x49620e7d.toInt(), 0xca816d37.toInt(), 0xbdaf74fb.toInt(), 0xfcd5f952.toInt(), 0x085db8b9.toInt(),
		0x99dd9cad.toInt(), 0x04714387.toInt(), 0xf45fa861.toInt(), 0xab3fda19.toInt(), 0x242e3810.toInt(), 0xc650b903.toInt(), 0xdcc4bdb5.toInt(), 0x875e9c50.toInt(),
		0x202d94ab.toInt(), 0xff5d8001.toInt(), 0x26368868.toInt(), 0x5ee81d18.toInt(), 0x03e5fdd9.toInt(), 0x873b7f7c.toInt(), 0x202cc702.toInt(), 0xa49d0f25.toInt(),
		0xe77d00f7.toInt(), 0xcb559c83.toInt(), 0xe66514cc.toInt(), 0x41838889.toInt(), 0x3a505df7.toInt(), 0x5941a3c3.toInt(), 0xc28cdd47.toInt(), 0x8c099a90.toInt(),
		0xb66989e5.toInt(), 0x57d12ba7.toInt(), 0xb66ca6cb.toInt(), 0x220d1461.toInt(), 0xa720714d.toInt(), 0x059fffa6.toInt(), 0x89dc8d8a.toInt(), 0xdc145511.toInt()
	)

	// Generated by setting fullSeed in readable.c.
	val fullSeedSequence = intArrayOf(
		0xf187b7cc.toInt(), 0xf780e6d7.toInt(), 0x9e7c24f9.toInt(), 0xb3b411b7.toInt(), 0x7114b30e.toInt(), 0x37ddabc2.toInt(), 0x07ba3d82.toInt(), 0x0f06faa7.toInt(),
		0x3cab19a9.toInt(), 0x074f2971.toInt(), 0x56b1fb87.toInt(), 0xc23d100d.toInt(), 0x7f71fac5.toInt(), 0xed1ca039.toInt(), 0x9a181839.toInt(), 0x841c25f6.toInt(),
		0xfff74a49.toInt(), 0xe6e66eab.toInt(), 0x7e9f206a.toInt(), 0x66b0bc79.toInt(), 0xfc0d6813.toInt(), 0x198472a2.toInt(), 0x1f5cd7dd.toInt(), 0x340cfe6d.toInt(),
		0xe569f62e.toInt(), 0x61754642.toInt(), 0xfc5c88d6.toInt(), 0xbaa2c61d.toInt(), 0x538d579a.toInt(), 0x2c1dcdb0.toInt(), 0xb48c67cb.toInt(), 0xf0f7c345.toInt(),
		0x70529648.toInt(), 0x01380859.toInt(), 0x80ebd78f.toInt(), 0x2ee9513d.toInt(), 0x7ef21924.toInt(), 0x390d12c1.toInt(), 0xa05c1b28.toInt(), 0x2528d650.toInt(),
		0x20791f3d.toInt(), 0x57bc1002.toInt(), 0xfed52dc6.toInt(), 0xec9544b7.toInt(), 0x9862bf03.toInt(), 0xae1f8b2c.toInt(), 0x039d26a4.toInt(), 0xa08a2a86.toInt(),
		0xbcaf045e.toInt(), 0x85029e4e.toInt(), 0x6a153748.toInt(), 0x3f1dab82.toInt(), 0x17cc46d4.toInt(), 0xb5c649bc.toInt(), 0x42e6de92.toInt(), 0x2f111866.toInt(),
		0xa2545a02.toInt(), 0x01472906.toInt(), 0x45b5294b.toInt(), 0x1c9820fc.toInt(), 0xa8f9d2cc.toInt(), 0xd5f5903d.toInt(), 0xabaceb1c.toInt(), 0x9e528960.toInt(),
		0xc737949f.toInt(), 0x35cfa832.toInt(), 0xa62667e4.toInt(), 0x15123fa7.toInt(), 0x58eedc27.toInt(), 0x648f0acf.toInt(), 0x4b7e760f.toInt(), 0x1aebb2df.toInt(),
		0x1709c01e.toInt(), 0xe1f94377.toInt(), 0xb192eb62.toInt(), 0xa87958f5.toInt(), 0xb64a756e.toInt(), 0x5d33b84f.toInt(), 0x3bb8358f.toInt(), 0x3b9bc9c2.toInt(),
		0x915602e1.toInt(), 0xaa49e37a.toInt(), 0x14ebf457.toInt(), 0xd39d05bd.toInt(), 0xf371bca9.toInt(), 0x8dd564ce.toInt(), 0x6ff348d1.toInt(), 0xea142bf7.toInt(),
		0x1c57430f.toInt(), 0x597b9058.toInt(), 0x1849c307.toInt(), 0x2db29301.toInt(), 0x5e10d981.toInt(), 0xb35a8646.toInt(), 0x17d84bc9.toInt(), 0xd90a6de1.toInt(),
		0xfbc6c3ef.toInt(), 0x4f24aa94.toInt(), 0xd28a228c.toInt(), 0x134b16a1.toInt(), 0x66818196.toInt(), 0x9ff9a139.toInt(), 0xae859b66.toInt(), 0x68405953.toInt(),
		0x2f9ce807.toInt(), 0xe4e13bee.toInt(), 0xb8cd4cba.toInt(), 0x84ce3ddf.toInt(), 0xf71fd613.toInt(), 0xda01c5f7.toInt(), 0x4670e9d0.toInt(), 0xfcd47245.toInt(),
		0xb8c0d718.toInt(), 0xb4b6a838.toInt(), 0x83d3829b.toInt(), 0xa80b1735.toInt(), 0xca131172.toInt(), 0xab2cc78f.toInt(), 0x2be7a0d9.toInt(), 0xf6b0fc9f.toInt(),
		0x090879c1.toInt(), 0x24e27b41.toInt(), 0x3b70abea.toInt(), 0xa73bc045.toInt(), 0xc63dfdf9.toInt(), 0x94c88a31.toInt(), 0x33a6d0dc.toInt(), 0x5a9bc037.toInt(),
		0xa37a3061.toInt(), 0xf167cc09.toInt(), 0x584c3e60.toInt(), 0xd02e7376.toInt(), 0xf3f64f92.toInt(), 0x2daac68e.toInt(), 0x8c9ee6f6.toInt(), 0x894ef602.toInt(),
		0x19367e9b.toInt(), 0x6c725190.toInt(), 0x40d560b8.toInt(), 0xeb525732.toInt(), 0xac823f05.toInt(), 0x95007716.toInt(), 0x28acf143.toInt(), 0xee80d810.toInt(),
		0x0659d3a7.toInt(), 0x327dc2b4.toInt(), 0xb3305cfb.toInt(), 0xb3d95b94.toInt(), 0x6c4e0439.toInt(), 0x14330d71.toInt(), 0x1f76be4e.toInt(), 0xf5a1c4c9.toInt(),
		0x92f70de2.toInt(), 0xb37ab68e.toInt(), 0xa8cce749.toInt(), 0x9777e161.toInt(), 0xfd07d5f6.toInt(), 0xeed2468b.toInt(), 0xaab186fd.toInt(), 0x0a660bcf.toInt(),
		0x7209122e.toInt(), 0x7e399ac9.toInt(), 0x5b0cd391.toInt(), 0xbedacdab.toInt(), 0x01f291db.toInt(), 0xf2c87428.toInt(), 0x0d55f0b9.toInt(), 0x8c6c75e2.toInt(),
		0xdf63a98c.toInt(), 0x4418ea76.toInt(), 0xa9dff69f.toInt(), 0x4521be7a.toInt(), 0xef313f45.toInt(), 0x5781cf8f.toInt(), 0x6e00fd51.toInt(), 0xcf860de5.toInt(),
		0xce50aa2a.toInt(), 0x642921af.toInt(), 0x04850d3f.toInt(), 0x3d974cc6.toInt(), 0x228181a1.toInt(), 0x850c2d45.toInt(), 0x8fa99825.toInt(), 0xefb63d5d.toInt(),
		0xf862c7a8.toInt(), 0xb2901b4b.toInt(), 0xaef19b95.toInt(), 0x7f14c2e0.toInt(), 0x98ea9433.toInt(), 0xc374cb6b.toInt(), 0xcdf81ae3.toInt(), 0xcd76c46b.toInt(),
		0x0266df2f.toInt(), 0x6c0a776f.toInt(), 0xd301da37.toInt(), 0x89a8ce99.toInt(), 0xa79f5838.toInt(), 0x7fe41254.toInt(), 0xce6c5c35.toInt(), 0xbe213ff2.toInt(),
		0x13d45244.toInt(), 0x9eb0d018.toInt(), 0x7f4f9c53.toInt(), 0x16faa28e.toInt(), 0x4b0acd70.toInt(), 0x81a93cb5.toInt(), 0x03a030d9.toInt(), 0x07a00924.toInt(),
		0xa3d3cb99.toInt(), 0x4b07a2bd.toInt(), 0x57aa8554.toInt(), 0x9681211f.toInt(), 0xc9b5e1a3.toInt(), 0x94f33f05.toInt(), 0x15fe317f.toInt(), 0x79150892.toInt(),
		0x30c122ce.toInt(), 0x197d2051.toInt(), 0x2944e6fb.toInt(), 0x4789b6b9.toInt(), 0x4805d406.toInt(), 0x3f9506c5.toInt(), 0x389afe24.toInt(), 0x9c846e2b.toInt(),
		0x5a382608.toInt(), 0x0fb5bec0.toInt(), 0xab94d4bb.toInt(), 0xd02a7680.toInt(), 0x9523a7ec.toInt(), 0xde78e330.toInt(), 0x3697fea2.toInt(), 0xe8313379.toInt(),
		0x494464bc.toInt(), 0xa26231f6.toInt(), 0x61f9aa2c.toInt(), 0xeacdd085.toInt(), 0x036852c5.toInt(), 0x8e11e960.toInt(), 0x708b8287.toInt(), 0x242ab4ae.toInt(),
		0x4ed743cc.toInt(), 0xbcea0d7d.toInt(), 0x6c64a08f.toInt(), 0x5edb6000.toInt(), 0xa8c7bc2a.toInt(), 0x6110e543.toInt(), 0x218d3f86.toInt(), 0xabdb54cb.toInt(),
		0x64b26fac.toInt(), 0x47bc6f32.toInt(), 0xb345b704.toInt(), 0x048190c0.toInt(), 0xaa958327.toInt(), 0xd973e74c.toInt(), 0x29cd25ae.toInt(), 0x2c338dd6.toInt(),
		0x1d321841.toInt(), 0x65eab5d8.toInt(), 0x94c526b2.toInt(), 0x6cbddf02.toInt(), 0x9ebdba64.toInt(), 0x1411347e.toInt(), 0x3103fe35.toInt(), 0x4dac2247.toInt(),
		0x2fd1f10f.toInt(), 0x589279a7.toInt(), 0x68a4cb0c.toInt(), 0x34cc7751.toInt(), 0xb2cb29dc.toInt(), 0x2aededb8.toInt(), 0xf47194fc.toInt(), 0x77ce3a74.toInt(),
		0xa5450b89.toInt(), 0xed21d583.toInt(), 0x0fa6149f.toInt(), 0x81bb8348.toInt(), 0xf5c69ed8.toInt(), 0x61676d8a.toInt(), 0xea1d4188.toInt(), 0xd842661d.toInt(),
		0xa003e54b.toInt(), 0x75bcb1c2.toInt(), 0x43c6e4ba.toInt(), 0x6f0df17c.toInt(), 0x753376fd.toInt(), 0x3512008e.toInt(), 0xc6243274.toInt(), 0x92f5e1e9.toInt(),
		0x343a10e0.toInt(), 0x71362697.toInt(), 0xedc75580.toInt(), 0x59f1184e.toInt(), 0xc9a70e9a.toInt(), 0xa64f6de0.toInt(), 0x220513d0.toInt(), 0x71460292.toInt(),
		0xe292b3b2.toInt(), 0x2f959e94.toInt(), 0x4116617c.toInt(), 0x9e9e9017.toInt(), 0x2192aab6.toInt(), 0xd6e09ae2.toInt(), 0x78183ca6.toInt(), 0xf3d380d5.toInt(),
		0xd2eb5d87.toInt(), 0x970466d2.toInt(), 0x316a3a4c.toInt(), 0xf2b32905.toInt(), 0x6e506a5a.toInt(), 0xca3343d9.toInt(), 0xbc0910db.toInt(), 0x7bec85e1.toInt(),
		0xc469df8b.toInt(), 0xd949a798.toInt(), 0x69397ecd.toInt(), 0x018766d7.toInt(), 0xfb3a6708.toInt(), 0x5673de59.toInt(), 0xde3b5d06.toInt(), 0xbebf0cf1.toInt(),
		0xdcf80fd9.toInt(), 0x45ab04d8.toInt(), 0x14a652db.toInt(), 0xf54a6a81.toInt(), 0xc47612e8.toInt(), 0x2c83d9c7.toInt(), 0x1586a23a.toInt(), 0x72364318.toInt(),
		0xea6bfa68.toInt(), 0x45b6637f.toInt(), 0xb29dbbfa.toInt(), 0xd49fdc5e.toInt(), 0x3be2b8e7.toInt(), 0x173abf4d.toInt(), 0xe82f1f33.toInt(), 0x2d46305a.toInt(),
		0x3e78f02e.toInt(), 0x4d55d45f.toInt(), 0x102c8870.toInt(), 0x3bd08510.toInt(), 0x421ca41d.toInt(), 0x839f76ef.toInt(), 0x9212c8b5.toInt(), 0xeda5d062.toInt(),
		0x98924696.toInt(), 0x38115f71.toInt(), 0x3253d71f.toInt(), 0x1956eac7.toInt(), 0xc3c18da9.toInt(), 0x1df791ed.toInt(), 0xba41f384.toInt(), 0x54b9e872.toInt(),
		0xa8e82523.toInt(), 0xcd6ef363.toInt(), 0x787d363d.toInt(), 0xb74fbfba.toInt(), 0x09eb5be1.toInt(), 0x2780a53a.toInt(), 0xbd8e88f0.toInt(), 0x8f68d070.toInt(),
		0x66bbe572.toInt(), 0xb6b3505e.toInt(), 0x4e25eb3d.toInt(), 0x7cc9873f.toInt(), 0x1e8f1f0b.toInt(), 0x9a27199c.toInt(), 0x416d2708.toInt(), 0x885ad322.toInt(),
		0xc5218c97.toInt(), 0xad573522.toInt(), 0x2124e7b4.toInt(), 0x59abb010.toInt(), 0x30cb944b.toInt(), 0xcf71ba13.toInt(), 0x4f22f3a0.toInt(), 0xacc30f61.toInt(),
		0x223a84d1.toInt(), 0x81a4829f.toInt(), 0xb212c298.toInt(), 0xa2861521.toInt(), 0xfb947117.toInt(), 0x9646200c.toInt(), 0x916659cb.toInt(), 0x302730aa.toInt(),
		0xabe6a7b7.toInt(), 0xd93f2691.toInt(), 0xdf2ab74a.toInt(), 0x66b3a848.toInt(), 0x402062eb.toInt(), 0xc6ba69ab.toInt(), 0x049e58a5.toInt(), 0xd167f347.toInt(),
		0x5bf36a1d.toInt(), 0xe5bcd865.toInt(), 0x9d164ebc.toInt(), 0x86112ac2.toInt(), 0x00c80e22.toInt(), 0x17b3830e.toInt(), 0xdf4e87b9.toInt(), 0x3f11cd81.toInt(),
		0xa9d490cd.toInt(), 0xc1a3cba2.toInt(), 0x3a7e8b52.toInt(), 0x954ac24b.toInt(), 0xd0c5ca71.toInt(), 0xb2461e18.toInt(), 0x4b831c2f.toInt(), 0xa0dcc589.toInt(),
		0xfe3639cf.toInt(), 0x89b2f947.toInt(), 0xa1047935.toInt(), 0x448b7046.toInt(), 0x3ba52bb0.toInt(), 0x157ab934.toInt(), 0x240ca9e2.toInt(), 0x4e4d17e9.toInt(),
		0x39fc5fb2.toInt(), 0xa078969c.toInt(), 0xc6d937bf.toInt(), 0xd6d7f009.toInt(), 0x69e23a28.toInt(), 0xd587d6ac.toInt(), 0x43dbfb98.toInt(), 0x757a2c4d.toInt(),
		0x0bc91826.toInt(), 0x7383c955.toInt(), 0xee83f0cd.toInt(), 0x1476878f.toInt(), 0xbaee30c3.toInt(), 0x23c32333.toInt(), 0x9935e4dc.toInt(), 0x2b2f3985.toInt(),
		0xa4cdd86a.toInt(), 0xae732062.toInt(), 0xa2b09e20.toInt(), 0x0ffe49e3.toInt(), 0x7c32f94c.toInt(), 0x15ad0d17.toInt(), 0x2858a958.toInt(), 0xab8d9272.toInt(),
		0x4e9feb12.toInt(), 0x5a473f46.toInt(), 0xb37f6754.toInt(), 0x6acf066d.toInt(), 0x4ebe9614.toInt(), 0x3e262abc.toInt(), 0x2ebab381.toInt(), 0x799c1238.toInt(),
		0x93c274e1.toInt(), 0x1e5fd9fd.toInt(), 0xb1516589.toInt(), 0x66555ebd.toInt(), 0x86fc9348.toInt(), 0x40623068.toInt(), 0xfadea4b3.toInt(), 0x227e409a.toInt(),
		0xe4181a45.toInt(), 0x31adb805.toInt(), 0x6091901b.toInt(), 0xc693a08d.toInt(), 0xfb40d997.toInt(), 0x6a4e4474.toInt(), 0x1f2696e5.toInt(), 0xa18173d5.toInt(),
		0x95b174c9.toInt(), 0xb1bf18a0.toInt(), 0x37a09405.toInt(), 0x0dca1723.toInt(), 0x41437cd7.toInt(), 0x07596cd9.toInt(), 0x280eb085.toInt(), 0x14b2c993.toInt(),
		0x12d3b68d.toInt(), 0x6f8c8fca.toInt(), 0x76efdf9d.toInt(), 0xb8e02a8d.toInt(), 0xd951e6a0.toInt(), 0xbc46d380.toInt(), 0x808223fd.toInt(), 0xf5c28b32.toInt(),
		0x310792f2.toInt(), 0xcdf01e74.toInt(), 0x9ef08cbf.toInt(), 0xdff54add.toInt(), 0x0c9b3b2c.toInt(), 0x64c230d4.toInt(), 0xa1f41333.toInt(), 0xb81ea12f.toInt(),
		0x03cef400.toInt(), 0x09c84b44.toInt(), 0x3285a6bb.toInt(), 0xeff33d6c.toInt(), 0x93c5cfd6.toInt(), 0x720ce0eb.toInt(), 0x62c95c6a.toInt(), 0xfa5de645.toInt(),
		0x738e2760.toInt(), 0xd0ef704a.toInt(), 0x23d03fbc.toInt(), 0x700d18ae.toInt(), 0x2c669e51.toInt(), 0xd6fcb4c0.toInt(), 0x088badb0.toInt(), 0x08db8564.toInt(),
		0x237ae561.toInt(), 0xe5ce3ebc.toInt(), 0x3df1a083.toInt(), 0xca1fc68b.toInt(), 0x434e90eb.toInt(), 0x0f448e01.toInt(), 0x397dea6d.toInt(), 0x8e11b9d3.toInt()
	)

	@Test
	fun shouldGenerateZeroSeedReferenceSequence() {
		testSequence(IntArray(256), zeroSeedSequence)
	}

	@Test
	fun shouldGenerateFSeedSequence() {
		val seed = IntArray(256)
		seed[0] = 0xffffffff.toInt()
		testSequence(seed, fSeedSequence)
	}

	@Test
	fun shouldGenerateFSeedSequenceFromShortSeed() {
		val seed = intArrayOf(0xffffffff.toInt())
		testSequence(seed, fSeedSequence)
	}

	@Test
	fun shouldGenerateFullSeedSequence() {
		testSequence(fullSeed, fullSeedSequence)
	}

	fun testSequence(seed: IntArray, sequence: IntArray) {
		val rng = Isaac(seed)
		for (i in sequence.indices) {
			val v = sequence[i]
			assertEquals(Integer.toHexString(v), Integer.toHexString(rng.nextInt()), "i: $i")
		}
	}
}
