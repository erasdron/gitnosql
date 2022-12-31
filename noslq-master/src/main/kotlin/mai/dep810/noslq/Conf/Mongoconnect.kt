package mai.dep810.noslq.Conf

import com.mongodb.MongoException
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients



object Mongoconnect {
    @JvmStatic
    fun mongo() {
        var mongoClient: MongoClient? = null
        try {
            mongoClient = MongoClients.create("mongodb://localhost")
        } catch (e: MongoException) {
            e.printStackTrace()
        } finally {
            mongoClient!!.close()
        }
    }
}