fun main() {    
    val numbers = readln().split(' ').map { it.toInt() }.toIntArray()
    val tmp = numbers.first()
    numbers[0] = numbers.last()
    numbers[numbers.lastIndex] = tmp

    // Do not touch lines above
    // Write only exchange actions here.

    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}