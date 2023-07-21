package encryptdecrypt

const val ALPHABET_SHIFT = 25
const val START_CODE = 'a'.code
val ALPHABET_RANGE = START_CODE..START_CODE + ALPHABET_SHIFT
const val msg = "we found a treasure!"

fun main() {
    println(encryptSentence(msg))
}


fun encryptSentence(s: String): String {
    val sb = StringBuilder(s.length)
    s.forEach { sb.append(getOppositeLetter(it)) }
    return sb.toString()
}

fun getOppositeLetter(char: Char): Char {
    return if (char.code !in ALPHABET_RANGE) char
    else Char(2 * START_CODE + ALPHABET_SHIFT - char.code)
}

