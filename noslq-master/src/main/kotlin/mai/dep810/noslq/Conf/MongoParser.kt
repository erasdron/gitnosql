package mai.dep810.noslq.Conf

import mai.dep810.noslq.model.Data
import java.io.File
import java.io.FileInputStream

class MongoParser {}
   fun inp(){
       val inputStream =
           FileInputStream(File("C:\\Users\\Varvara\\Desktop\\noslq-master\\noslq-master\\src\\main\\kotlin\\mai\\dep810\\noslq\\database\\users.csv"))
       val clients = Data.readCsv(inputStream)
       clients.forEach {
           println(it)
       }
           /*	val inputStr = FileInputStream(File("D:\\download\\data\\books.csv"))
                   val books= Data.readC((inputStr))
                   books.forEach {
                       println(it)
                   }*/

   }