class Isaac {
	val state: UIntArray
	var i: Int = 0

	constructor(seed: UIntArray) {
		state = seed
	}

	fun nextInt(): UInt {
		return state[i++];
	}
}
