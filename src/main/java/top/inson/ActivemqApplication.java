package top.inson;


import com.yomahub.tlog.core.enhance.AspectLogEnhance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActivemqApplication {

    static {
        AspectLogEnhance.enhance();
    }

    public static void main(String[] args) {
        SpringApplication.run(ActivemqApplication.class, args);
    }

}
