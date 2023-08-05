package encryptdecrypt

class EncDec(private val msg: String, private val shift: Int) {
    fun process() = msg.map { it + shift }.joinToString("")
}