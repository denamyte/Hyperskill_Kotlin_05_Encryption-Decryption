fun main() {
    val numbers = IntArray(100)
    intArrayOf(1, 10, 100).forEach { numbers[it - 1] = it }

    // do not touch the lines below
    println(numbers.joinToString())
}