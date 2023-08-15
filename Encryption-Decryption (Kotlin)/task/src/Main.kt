package encryptdecrypt

fun main(args: Array<String>) {
    val parser = Parser(args)
    
    encDec(parser.data, parser.modeDir * parser.key)
        .run { println(this) }
}
