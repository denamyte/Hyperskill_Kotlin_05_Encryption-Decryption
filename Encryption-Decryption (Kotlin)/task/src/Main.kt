package encryptdecrypt

fun main() {
    val dir = if (readln() == "enc") 1 else -1
    val msg = readln()
    val shift = readln().toInt()

    val converted = EncDec(msg, dir * shift).process()
    println(converted)
}
