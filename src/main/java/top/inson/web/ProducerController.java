package top.inson.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@RestController
public class ProducerController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;


    @PostMapping("/sendQueue")
    public String sendQueue(@RequestBody String msg){
        sendMessage(queue, msg);
        return "push queue success";
    }

    @PostMapping("/sendTopic")
    public String sendTopic(@RequestBody String msg){
        sendMessage(topic, msg);
        return "push topic success";
    }


    //发送消息，destination是发送到的队列，message是待发送的消息
    private void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
