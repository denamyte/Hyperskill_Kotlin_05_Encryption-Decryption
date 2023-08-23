// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
    IntArray(readln().toInt()) { readln().toInt() }
        .reversed().forEach { print("$it ") }
}
