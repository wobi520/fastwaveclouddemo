package fastwave.colud.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {

    //配置一个交换机
    @Bean
    DirectExchange EmailExchange() {
        return new DirectExchange("EmailExchange");
    }

    //消费方需要队列,创建一个队列
    @Bean
    Queue EmailQueue() {
        return new Queue("EmailQueue");
    }

    //队列和交换机绑定,参数1:队列,2:交换机,3:路由key(交换机路由到队列的key)
    @Bean
    Binding BindEmail(){
        return BindingBuilder.bind(EmailQueue()).to(EmailExchange()).with("EmailRouting");
    }
}
