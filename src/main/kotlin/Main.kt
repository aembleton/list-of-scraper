import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File

//val wikiFile = "/media/arthur/Big Drive/Projects/Lists-of/enwiki-20190101-pages-articles-multistream.xml"
val wikiFile = "/media/arthur/Big Drive/Projects/Lists-of/wiki/wiki-ca"

fun main() {

    val starttime = System.currentTimeMillis()

    val br = File(wikiFile).bufferedReader()
    var line = br.readLine()
    while (line != null) {
        printTitle(line)
        line = br.readLine()
    }

    val timeTaken = (System.currentTimeMillis() - starttime)/1_000

    println("That took $timeTaken seconds")
}

fun printTitle(line:String) {
    if (line.trim().startsWith("<title>List of")) {
        println(line.trim().substringAfter(">").substringBefore("<"))
    }
}