package mai.dep810.noslq.rep

import mai.dep810.noslq.model.Data.Client
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping

@Repository("clientRepository")
class Clientrepository {
    private val clients: MutableList<Client> = mutableListOf(

    )

    fun findAll(): List<Client> = clients;

    fun findById(client_id : String): Client?=clients.singleOrNull{it.client_id==client_id}

    fun addClient(client: Client){
        if(!clients.contains(client)){
            clients.add(client)
        }
    }
    fun deleteClient(client_id: String)=clients.removeIf{it.client_id==client_id}

    }
