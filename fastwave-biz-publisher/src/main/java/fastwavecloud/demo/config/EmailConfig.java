package fastwavecloud.demo.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {


    //配置一个交换机,DirectExchange:一对一交换机
    @Bean
    DirectExchange EmailExchange(){
        return new DirectExchange("EmailExchange");
    }





}
