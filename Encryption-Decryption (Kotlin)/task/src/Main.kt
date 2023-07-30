package encryptdecrypt

const val AB_LENGTH = 26
const val A = 'a'

fun main() {
    val msg = readln()
    val offset = readln().toInt()
    println(encryptSentence(msg, offset))
}

fun shift(ch: Char, offset: Int): Char {
    return if (ch in A until A + AB_LENGTH) 
        A + (ch - A + offset) % AB_LENGTH 
    else ch
}

fun encryptSentence(s: String, offset: Int): String {
    return s.map { shift(it, offset) }.joinToString("")
}
