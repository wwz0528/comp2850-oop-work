fun main() {
    val myAge = 29u
    val universeAge = 13_800_000_000L
    val status = 'M'
    val name = "Sarah"
    val height = 1.78f
    val root2 = Math.sqrt(2.0)

    println(myAge::class)        // UInt（无符号整数）
    println(universeAge::class)  // Long（长整型）
    println(status::class)       // Char（字符）
    println(name::class)         // String（字符串）
    println(height::class)       // Float（单精度浮点数）
    println(root2::class)        // Double（双精度浮点数）
}