import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({

    "word with 5 letters should be valid" {
        withClue("apple should be valid") {
            isValid("tanks") shouldBe true
        }
    }

    "word shorter than 5 letters should be invalid" {
        withClue("cat should be invalid") {
            isValid("cat") shouldBe false
        }
    }

    "word with digits should be invalid" {
        withClue("tiger1 should be invalid") {
            isValid("tiger1") shouldBe false
        }
    }

    "word with symbols should be invalid" {
        withClue("watch! should be invalid") {
            isValid("watch!") shouldBe false
        }
    }

    "uppercase word should still be valid" {
        withClue("TANKS should be valid") {
            isValid("TANKS") shouldBe true
        }
    }
})
