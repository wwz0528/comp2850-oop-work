// Implement the six required functions here
fun isValid(word: String): Boolean {
    // Check the length
    if (word.length != 5) {
        return false
    }

    // check the every character
    for (ch in word) {
        if (!ch.isLetter()) {
            return false
        }
    }

    // if passed that is valid word
    return true
}

fun readWordList(): MutableList<String> {
    val words = mutableListOf<String>()

    val lines = java.io.File("data/words.txt").readLines()  // read the cured path

    for (line in lines) {
        val word = line.trim()
        if (word.isNotEmpty()) {
            words.add(word)
        }
    }

    return words
}

fun pickRandomWord(words: MutableList<String>): String {
    if (words.isEmpty()) {
        throw IllegalArgumentException("The list is empty")
    }

    val index = (0 until words.size).random()  // Generate random index
    val word = words[index]                    // choose the word
    words.removeAt(index)                      // delete the word from the list
    return word                                
}

fun obtainGuess(attempt: Int): String {
    while (true) {  // Loop until the user input is correct
        print("Attempt $attempt: ")       // Prompt attempts
        val input = readLine()?.trim()    // trim remove spaces

        if (input != null && isValid(input)) {
            return input                  
        } else {
            println("Please enter the correct five-letter word") 
        }
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = MutableList(5) { 0 }  // Initialize 5 zeros

    for (i in 0 until 5) {
        if (guess[i] == target[i]) {
            result[i] = 1                // Mark 1 if the letter in the corresponding position matches
        }
    }

    return result
}

fun displayGuess(guess: String, matches: List<Int>) {
    for (i in 0 until 5) {
        if (matches[i] == 1) {
            print(guess[i])   // if valid show the original word
        } else {
            print('?')        // show"?""when invalid
        }
    }
    println()  
}


