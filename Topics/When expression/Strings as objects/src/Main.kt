fun main() {
    val s = readln().ifEmpty { "s" }
    println(
        when (s.first()) {
            'i' -> s.drop(1).toInt() + 1
            's' -> s.drop(1).reversed()
            else -> s
        }
    )
}