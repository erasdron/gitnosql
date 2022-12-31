package mai.dep810.noslq

import mai.dep810.noslq.Conf.Mongoconnect.mongo
import mai.dep810.noslq.Conf.inp
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class NoslqApplication

fun main(args: Array<String>) {
    runApplication<NoslqApplication>(*args)
    mongo()

//		var mongoClient: MongoClient?=null
//		val database: MongoDatabase
//		val mongourl="mongodb://localhost:27017/"
//		try{
//			mongoClient= MongoClients.create(mongourl)
//			database= mongoClient.getDatabase("airbnb")
//
//		} catch (e: MongoException) {
//			e.printStackTrace()
//		} finally {
//			mongoClient!!.close()
//		}

}

