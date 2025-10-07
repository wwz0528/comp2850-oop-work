fun anagrams(first: String, second: String): Boolean {
    if (first.length != second.length) {
        return false
    }
    val firstChars = first.lowercase().toList().sorted()
    val secondChars = second.lowercase().toList().sorted()
    return firstChars == secondChars
}

fun main() {
    print("Please enter 2 inputs: ")
    val first = readln()
    val second = readln()
    val output = anagrams(first, second)
    println("The answer is $output")
}
