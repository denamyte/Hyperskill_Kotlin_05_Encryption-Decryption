import kotlin.random.Random

fun generatePredictablePassword(seed: Int) =
    Random(seed).run {
        (1..10)
            .map { this.nextInt(33, 127) }
            .map { it.toChar() }
            .joinToString("")
    }
