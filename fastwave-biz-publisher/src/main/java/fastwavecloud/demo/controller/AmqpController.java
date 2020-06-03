package fastwavecloud.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/amqp")
public class AmqpController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/direct")  //一对一direct
    public String sendEmail(@RequestParam Map<String, Object> params) {
        String msg = params.get("msg").toString();//获取一个信息
        //发送,参数1:交换机,2.交换机很队列绑定的key,3发送的内容
        rabbitTemplate.convertAndSend("EmailExchange", "EmailRouting", msg);
        return "ok";


    }

    @RequestMapping("/topic")  //topic 模糊匹配
    public String sendBlog(@RequestParam Map<String, Object> params) {
        String msg = params.get("msg").toString();//获取一个信息
        //发送,参数1:交换机,2.交换机很队列绑定的key,3发送的内容
        rabbitTemplate.convertAndSend("BlogExchange", "blog.java", msg);
        return "ok";


    }

}
