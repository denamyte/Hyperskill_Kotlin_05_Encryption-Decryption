package encryptdecrypt

private const val AB_LEN = 26

val UPPER = Array(AB_LEN) { 'A' + it}
val LOWER = Array(AB_LEN) { 'a' + it}

fun encDec(msg: String, key: Int, alg: String) =
    (if (alg == "unicode") {
        msg.map { it + key }
    } else msg.map {
        when (it) {
            in UPPER -> shift(key, it, UPPER)
            in LOWER -> shift(key, it, LOWER)
            else -> it
        }
    }).joinToString("")

fun shift(key: Int, char: Char, chars: Array<Char>) =
    chars[(chars.indexOf(char) + key % AB_LEN + AB_LEN) % AB_LEN]
