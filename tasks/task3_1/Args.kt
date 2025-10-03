fun main(args: Array<String>){
    if (args.size <2 ) {
        println("Error: Two command line arguments are required.")
        exitProcess(1)  
    }
    println(args[0])
    println(args[1])
}