fun main() {
    val ar = Array(2) {Array(3) {""} }
    for (row in 0..1)
        for (col in 0..2)
            ar[row][col] = "[$row][$col]"
    print(ar.contentDeepToString())
}