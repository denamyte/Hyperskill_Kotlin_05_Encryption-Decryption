const val DIM = 3

fun main() = Array(DIM) { Array(DIM) { IntArray(DIM) } }
    .run { print(this.contentDeepToString()) }