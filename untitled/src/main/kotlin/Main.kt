import java.io.File
import java.io.FileInputStream

fun main(args: Array<String>) {
val inputStream = FileInputStream(File("D:\\download\\data\\clients.csv"))
    val clients=Data.readCsv(inputStream)
    clients.forEach{
        println(it)
    }
}