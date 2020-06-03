package fastwave.colud.demo.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//Component 扫描这个类
@Component
public class BlogReceiver {

    //监听EmailQueue,接收信息,进行消费
    @RabbitListener(queues = "BlogJavaQueue")
    public void receiverJava(String msg) {
        System.out.println("收到的JAVA:" + msg);
    }

    //监听EmailQueue,接收信息,进行消费
    @RabbitListener(queues = "BlogDotNetQueue")
    public void receiverDotNet(String msg) {
        System.out.println("收到的DotNet:" + msg);
    }

    //监听EmailQueue,接收信息,进行消费
    @RabbitListener(queues = "BlogAllQueue")
    public void receiverAll(String msg) {
        System.out.println("收到的All:" + msg);
    }
}
