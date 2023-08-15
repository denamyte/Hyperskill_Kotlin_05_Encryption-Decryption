package encryptdecrypt

fun encDec(msg: String, shift: Int) = msg.map { it + shift }.joinToString("")
