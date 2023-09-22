//import na spracovavanie suborov
import java.io.File

val hangman = listOf("""
      _______
     |      |
     |      0
     |     /|\
     |     / \
     |
     |________

""".trimIndent(),
"""
      _______
     |      |
     |      0
     |     /|\
     |     / 
     |
     |________

""".trimIndent(),
"""
      _______
     |      |
     |      0
     |     /|\
     |     
     |
     |________

""".trimIndent(),
"""
      _______
     |      |
     |      0
     |     /|
     |     
     |
     |________

""".trimIndent(),
"""
      _______
     |      |
     |      0
     |     /
     |     
     |
     |________

""".trimIndent(),
"""
      _______
     |      |
     |      0
     |     
     |     
     |
     |________

""".trimIndent(),
"""
      _______
     |      |
     |      
     |     
     |     
     |
     |________

""".trimIndent(),
"""
      _______
     |      
     |      
     |     
     |     
     |
     |________

""".trimIndent(),
"""
      
     |      
     |      
     |     
     |    
     |
     |________

""".trimIndent(),
"""
     
     
     
     
          
     
     _________

""".trimIndent())

fun main(){
    val word = File("words.txt").readLines().random()
    var status = ".".repeat(word.length).toCharArray()
    var life = hangman.lastIndex
    println(word)
    println(status)
    println(life)

    while(life>0 && String(status) != word){
        println(hangman[life])
        println(status)

        var input = readLine()!!
        println(input)

        if(input.length > 1){
            if(input == word){
                status = input.toCharArray()
            }
        }else if(input in word){
            word.forEachIndexed{ index, c ->
                if(c in input){
                    status[index] = c
                }
            }
        } else life --

    }
    if(life > 0) println("Hra Ukončená! Vyhral si")

    else println("""
       _______
     |      |
     |      0
     |     /|\
     |     / \
     |
     |________
    Hra Ukončená! Prehral Si! Slovo bolo: $word""")
}

/*import java.io.File

val hangmanParts = listOf(
    """
      _______
     |      |
     |      
     |     
     |     
     |
     |________
    """.trimIndent(),
    """
      _______
     |      |
     |      0
     |     
     |     
     |
     |________
    """.trimIndent(),
    """
      _______
     |      |
     |      0
     |      |
     |     
     |
     |________
    """.trimIndent(),
    """
      _______
     |      |
     |      0
     |     /|
     |     
     |
     |________
    """.trimIndent(),
    """
      _______
     |      |
     |      0
     |     /|\
     |     
     |
     |________
    """.trimIndent(),
    """
      _______
     |      |
     |      0
     |     /|\
     |     /
     |
     |________
    """.trimIndent(),
    """
      _______
     |      |
     |      0
     |     /|\
     |     / \
     |
     |________
    """.trimIndent(),
    """
      _______
     |      |
     |      0
     |     /|\
     |    _/ \
     |
     |________
    """.trimIndent(),
    """
      _______
     |      |
     |      0
     |     /|\
     |    _/ \_
     |
     |________
    """.trimIndent(),
    """
      _______
     |      |
     |     \0
     |     /|\
     |    _/ \_
     |
     |________
    """.trimIndent()
)

fun main() {
    val wordList = File("words.txt").readLines()
    val word = wordList.random().uppercase() // Upravené na uppercase()
    var status = CharArray(word.length) { '_' }
    var attempts = 0

    println("Vitajte v hre Hangman!")
    println("Hádajte slovo: ${String(status)}")

    while (attempts < 10) { // Hráč má 10 pokusov
        println(hangmanParts[attempts])
        println("Hádajte písmeno alebo celé slovo:")
        val guess = readLine()?.uppercase() ?: "" // Upravené na uppercase()

        if (guess == word) {
            println("Gratulujem, uhádli ste slovo: $word")
            break
        } else if (guess.length == 1 && guess in word) {
            for (i in word.indices) {
                if (word[i] == guess[0]) {
                    status[i] = guess[0]
                }
            }
        } else {
            println("Nesprávny pokus!")
            attempts++
        }

        println("Hádajte slovo: ${String(status)}")
    }

    if (attempts == 10) {
        println("Prehrali ste! Hádané slovo bolo: $word")
        println(hangmanParts[9]) // Zobraziť kompletný hangman
    }
}*/