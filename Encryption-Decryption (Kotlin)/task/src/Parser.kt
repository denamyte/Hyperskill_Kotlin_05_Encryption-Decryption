package encryptdecrypt

import java.io.File

class Parser(args: Array<String>) {

    private val paramMap = mutableMapOf<String, String>()

    init {
        for (i in 0..args.lastIndex step 2) paramMap[args[i]] = args[i + 1]
    }

    val modeDir = paramMap.getOrDefault("-mode", "enc")
        .run { if (this == "enc") 1 else -1 }

    val key = paramMap.getOrDefault("-key", "0")
        .toInt()

    val data: String
        get() {
            val text = paramMap.getOrDefault("-data", "")
            if (text.isNotEmpty()) return text

            val name = paramMap.getOrDefault("-in", "")
            if (name.isEmpty()) return ""

            return File(name).readText()
        }
    
    val out = paramMap.getOrDefault("-out", "")
}