package fastwavecloud.demo.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogConfig {


    //配置一个交换机 TopicExchange:模糊交换机
    @Bean
    TopicExchange BlogExchange(){
        return new TopicExchange("BlogExchange");
    }


    


}
