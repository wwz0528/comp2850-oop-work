fun main() {
    println("Welcome to Wordle!")

    // read the words list
    val wordList = readWordList()
    if (wordList.isEmpty()) {
        println("the words list is empty")
        return
    }

    // Randomly select a word
    val target = pickRandomWord(wordList)

    val maxAttempts = 6  // Max times is 6

    // game cycle
    for (attempt in 1..maxAttempts) {
        val guess = obtainGuess(attempt)            
        val matches = evaluateGuess(guess, target)  
        displayGuess(guess, matches)                

        if (matches.all { it == 1 }) {             
            println("you are right the word is: $target")
            return
        }
    }

    // the situation of lose
    println("you lost, The answer is: $target")
}
