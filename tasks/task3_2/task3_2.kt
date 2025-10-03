fun main() {
    print("insert your name: ")  
    try {
        val name = readln()
        println("the length of your name: ${name.length}")  
    } catch (e: NoSuchElementException) {  
        println("no insert")
    }
}
