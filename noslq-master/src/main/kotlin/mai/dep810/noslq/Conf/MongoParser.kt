package mai.dep810.noslq.Conf

import mai.dep810.noslq.model.Data

fun inp() {
    val usersStream = {}.javaClass.classLoader.getResourceAsStream("users.csv")
    val clients = Data.readCsv(usersStream)
    clients.forEach {
        println(it)
    }
    /*	val inputStr = FileInputStream(File("D:\\download\\data\\books.csv"))
            val books= Data.readC((inputStr))
            books.forEach {
                println(it)
            }*/

}
