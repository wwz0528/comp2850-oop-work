const val MAX_ATTEMPTS = 10 // top-level constant for maximum attempts

fun main() {
    println("Welcome to Wordle!")

    // read the words list
    val wordList = readWordList("data/words.txt")
    if (wordList.isEmpty()) {
        println("The words list is empty")
        return
    }

    // Randomly select a word
    val target = pickRandomWord(wordList)

    // game cycle
    for (attempt in 1..MAX_ATTEMPTS) {
        val guess = obtainGuess(attempt)
        val matches = evaluateGuess(guess, target)
        displayGuess(guess, matches)

        if (matches.all { it == 1 }) {
            println("You guessed the word! The word is: $target")
            return
        }
    }

    println("You lost. The answer is: $target")
}
