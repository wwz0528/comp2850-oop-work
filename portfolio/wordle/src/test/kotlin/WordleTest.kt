import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.File

class WordleTest : StringSpec({

    // isValid test
    "word with exactly 5 letters should be valid" {
        isValid("tiger") shouldBe true
    }

    "word shorter than 5 letters should be invalid" {
        isValid("cat") shouldBe false
    }

    "word longer than 5 letters should be invalid" {
        isValid("tigerr") shouldBe false
    }

    "word containing digits should be invalid" {
        isValid("tiger1") shouldBe false
    }

    "word containing symbols should be invalid" {
        isValid("tige!") shouldBe false
    }

    "uppercase word should still be valid" {
        isValid("Tiger") shouldBe true
    }

    // readWordList test
    "readWordList should read valid words from file" {
        // create a temporary test file
        val tempFile = File.createTempFile("testwords", ".txt")
        tempFile.writeText(
            """
            tiger
            cat
            tige!
            apple
            """.trimIndent(),
        )

        val words = readWordList(tempFile.absolutePath)
        words.contains("TIGER") shouldBe true
        words.contains("TIGERR") shouldBe false // the length is too long
        words.contains("cat") shouldBe false // invalid length
        words.contains("tige!") shouldBe false // invalid characters

        tempFile.deleteOnExit() // delete the file automatically
    }

    // pickRandomWord test
    "pickRandomWord should return a word from the list and remove it" {
        val list = mutableListOf("apple", "tiger", "melon")
        val picked = pickRandomWord(list) // remove the random word
        list.contains(picked) shouldBe false // the word has been removed
        ("apple" == picked || "tiger" == picked || "melon" == picked) shouldBe true
    }

    // evaluateGuess test
    "evaluateGuess should return correct matches" {
        val target = "melon"
        val guess1 = "meerk" // m, e match
        val result1 = evaluateGuess(guess1, target)
        result1 shouldBe listOf(1, 1, 0, 0, 0)

        val guess2 = "melon" // exact match
        val result2 = evaluateGuess(guess2, target)
        result2 shouldBe listOf(1, 1, 1, 1, 1)

        val guess3 = "zzzzz" // no matches
        val result3 = evaluateGuess(guess3, target)
        result3 shouldBe listOf(0, 0, 0, 0, 0)
    }
})
