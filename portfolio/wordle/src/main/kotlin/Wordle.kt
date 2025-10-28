// Define a constant for word length
const val WORD_LENGTH = 5

fun isValid(word: String): Boolean {
    // If length is not WORD_LENGTH, return false immediately
    if (word.length != WORD_LENGTH) return false

    // Check that all characters are letters
    val allLetters = word.all { it.isLetter() }

    // Return the result of the check
    return allLetters
}

fun readWordList(filename: String): MutableList<String> {
    val words = mutableListOf<String>()
    val lines = java.io.File(filename).readLines() // read the file

    for (line in lines) {
        val word = line.trim().uppercase() // convert to uppercase
        if (word.isNotEmpty() && isValid(word)) { // only add valid words
            words.add(word)
        }
    }

    return words
}

fun pickRandomWord(words: MutableList<String>): String {
    require(words.isNotEmpty()) { "The list is empty" } // Ensure the list is not empty

    val index = (0 until words.size).random() // Generate random index
    val word = words[index] // choose the word
    words.removeAt(index) // delete the word from the list
    return word
}

fun obtainGuess(attempt: Int): String {
    while (true) { // Loop until the user input is correct
        print("Attempt $attempt: ") // Prompt attempts
        val input = readLine()?.trim()?.uppercase() // trim and convert to uppercase

        if (input != null && isValid(input)) {
            return input
        } else {
            println("Please enter the correct five-letter word")
        }
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = MutableList(WORD_LENGTH) { 0 } // Initialize WORD_LENGTH zeros

    for (i in 0 until WORD_LENGTH) {
        if (guess[i] == target[i]) {
            result[i] = 1 // Mark 1 if the letter in the corresponding position matches
        }
    }

    return result
}

fun displayGuess(guess: String, matches: List<Int>) {
    for (i in 0 until WORD_LENGTH) {
        if (matches[i] == 1) {
            print(guess[i]) // if valid show the original word
        } else {
            print('?') // show "?" when invalid
        }
    }
    println() // Move to next line after displaying
}
