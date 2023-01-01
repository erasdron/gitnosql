package mai.dep810.noslq.Conf
import com.hazelcast.config.Config
import com.hazelcast.core.Hazelcast
import com.hazelcast.core.HazelcastInstance
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HazelCast {

    @Bean(destroyMethod = "shutdown")
    fun hazelcastInstance(config: Config): HazelcastInstance =
        Hazelcast.getOrCreateHazelcastInstance(config)
    @Bean("hazelcastConf")
    fun hazelcastConfig(): Config =
        Config("rooms")

}