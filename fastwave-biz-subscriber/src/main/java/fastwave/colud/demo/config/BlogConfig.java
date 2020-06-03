package fastwave.colud.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogConfig {


    //配置一个交换机 TopicExchange:模糊交换机
    @Bean
    TopicExchange BlogExchange() {
        return new TopicExchange("BlogExchange");
    }

    //消费方需要队列,创建一个队列,参数1:队列名,2:持久化
    @Bean
    Queue BlogJavaQueue() {
        return new Queue("BlogJavaQueue", true);
    }


    @Bean
    Queue BlogDotNetQueue() {
        return new Queue("BlogDotNetQueue", true);
    }

    @Bean
    Queue BlogAllQueue() {
        return new Queue("BlogAllQueue", true);
    }

    @Bean
    Binding BindingToJavaQueue(){
        return BindingBuilder.bind(BlogJavaQueue()).to(BlogExchange()).with("blog.java");
    }

    @Bean
    Binding BindingToDotNetQueue(){
        return BindingBuilder.bind(BlogDotNetQueue()).to(BlogExchange()).with("blog.dotNet");
    }

    @Bean
    Binding BindingToAllQueue(){
        return BindingBuilder.bind(BlogAllQueue()).to(BlogExchange()).with("blog.#");//blog.# 可以匹配多个单词
    }
}
