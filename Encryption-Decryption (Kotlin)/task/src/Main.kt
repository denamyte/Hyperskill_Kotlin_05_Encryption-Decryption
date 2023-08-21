package encryptdecrypt

import java.io.File

fun main(args: Array<String>) {
    val parser = Parser(args)
    
    encDec(parser.data, parser.modeDir * parser.key)
        .run { output(parser, this) }
}

fun output(parser: Parser, text: String) {
    val out = parser.out
    if (out.isEmpty()) println(text)
    else File(out).writeText(text)
}
