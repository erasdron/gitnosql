package mai.dep810.noslq.api

import mai.dep810.noslq.model.Data.Client
import mai.dep810.noslq.rep.Clientrepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController

class ClientController (val clientrepository: Clientrepository){
    @GetMapping("/api/client/find")
    fun findClients(): List<Client> =clientrepository.findAll();

    @GetMapping("api/client/{id}")
    fun findClientsid(@PathVariable id:String): Client?=clientrepository.findById(id);

    @PostMapping("api/client/add")
    fun addClients(@RequestBody client: Client) = clientrepository.addClient(client);

    @DeleteMapping("api/client/delete/{id}")
    fun deleteClient(@PathVariable id: String)=clientrepository.deleteClient(id);

}
