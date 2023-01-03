package mai.dep810.noslq

import com.mongodb.MongoException
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import mai.dep810.noslq.Conf.Mongoconnect.mongo
import mai.dep810.noslq.model.Data
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File
import java.io.FileInputStream

@SpringBootApplication
class NoslqApplication

		fun main(args: Array<String>) {
			runApplication<NoslqApplication>(*args)
			mongo()
	}
