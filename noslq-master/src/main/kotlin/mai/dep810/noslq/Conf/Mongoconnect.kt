package mai.dep810.noslq.Conf

import com.mongodb.MongoException
import com.mongodb.client.MongoClient


object Mongoconnect {
    @JvmStatic
    fun mongo() {
        var mongoClient: MongoClient? = null
        try {
            //ошибка Interface MongoClient does not have constructors
            mongoClient = MongoClient("127.0.0.1", 27017)
            println("Connected to MongoDB!")
        } catch (e: MongoException) {
            e.printStackTrace()
        } finally {
            mongoClient!!.close()
        }
    }
}