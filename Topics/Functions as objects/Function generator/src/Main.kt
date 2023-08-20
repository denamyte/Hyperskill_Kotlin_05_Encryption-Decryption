fun generate(functionName: String): (Int) -> Int =
    when (functionName) {
        "identity" -> fun(v: Int) = v
        "half" -> fun(v: Int) = v / 2
        else -> fun(_: Int) = 0
    }