package mai.dep810.noslq

import com.mongodb.MongoException
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import mai.dep810.noslq.model.Data
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File
import java.io.FileInputStream

@SpringBootApplication
class NoslqApplication
	fun main(args: Array<String>) {
		runApplication<NoslqApplication>(*args)

	val inputStream = FileInputStream(File("C:\\Users\\Varvara\\Desktop\\noslq-master\\noslq-master\\src\\main\\kotlin\\mai\\dep810\\noslq\\database\\users.csv"))
		val clients= Data.readCsv(inputStream)
		clients.forEach{
		/*	println(it)*/

		}

		var mongoClient: MongoClient?=null
		val database: MongoDatabase
		val mongourl="mongodb://localhost:27017/"
		try{
			mongoClient= MongoClients.create(mongourl)
			database= mongoClient.getDatabase("airbnb")

		} catch (e: MongoException) {
			e.printStackTrace()
		} finally {
			mongoClient!!.close()
		}
	/*	val inputStr = FileInputStream(File("D:\\download\\data\\books.csv"))
		val books= Data.readC((inputStr))
		books.forEach {
			println(it)
		}*/
	}
