package top.inson;


import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringApplicationTest {
    @Autowired
    private DruidDataSource druidDataSource;
    @Autowired
    private ConnectionFactory connectionFactory;



    @Test
    public void testDataSource(){
        log.info("数据源dataSource：" + druidDataSource);

    }

    @Test
    public void testProducer(){
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            //创建session，第一个参数是否使用事务，第二个参数是确认机制
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //创建目的地，参数是queue名字
            Destination destination = session.createQueue("pushOrder");
            //创建生产者，第一个参数是目的地，此时创建的生产者要与目的地进行绑定
            MessageProducer producer = session.createProducer(destination);
            //使用session创建信息
            TextMessage textMessage = session.createTextMessage("hello");
            //生产者发送消息
            producer.send(textMessage);
            //提交事务
            session.commit();
            //关闭资源
            session.close();
            connection.close();
        } catch (JMSException e) {
            log.info("activemq连接异常", e);
        }
    }

    @Test
    public void testConsumer(){

        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            //使用connection创建session
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //创建目的地
            Destination destination = session.createQueue("pushOrder");
            //创建消费者
            MessageConsumer consumer = session.createConsumer(destination);
            //使用消费者接口消息
            TextMessage message = (TextMessage) consumer.receive();
            log.info("consumer接收到消息" + message.getText());
            //提交事务
            session.commit();
            //关闭资源
            session.close();
            connection.close();
        } catch (JMSException e) {
            log.info("activemq连接异常", e);
        }
    }


}
