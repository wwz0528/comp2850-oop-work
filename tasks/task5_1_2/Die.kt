import kotlin.random.Random

fun rollDie(sides: Int){
    if (sides in setOf(4,6,,10,12,20)) {
        println("Roolling a d$sides...")
        val result = random.nextInt(1, sides + 1)
        println("You rolled $reslt")
    }
    else{
        println("Error: cannot have a $sides-sided die")
    }
}