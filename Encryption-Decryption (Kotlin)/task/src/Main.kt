package encryptdecrypt

import java.io.File

fun main(args: Array<String>) {
    val parser = Parser(args)

    encDec(
        parser.data,
        parser.modeDir * parser.key,
        parser.alg
    ).run { output(parser.out, this) }
}

fun output(out: String, text: String) {
    if (out.isEmpty()) println(text)
    else File(out).writeText(text)
}
