package top.inson;


import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringApplicationTest {
    @Autowired
    private DruidDataSource druidDataSource;

    @Test
    public void testDataSource(){
        log.info("数据源dataSource：" + druidDataSource);

    }

}
