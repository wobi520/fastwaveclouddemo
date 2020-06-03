package fastwave.colud.demo.services;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

//Component 扫描这个类
@Component
public class EmailReceiver {

    //监听EmailQueue,接收信息,进行消费
    @RabbitListener(queues = "EmailQueue")
    public void receiver(String msg) {
        System.out.println(msg);
    }
}
