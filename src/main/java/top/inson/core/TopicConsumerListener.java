package top.inson.core;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TopicConsumerListener {

    //topic模式的消费者
    @JmsListener(destination = "${spring.activemq.topic-name}", containerFactory = "topicListener")
    public void readActiveQueue(String message){
        log.info("topic接收到：" + message);
    }


}
