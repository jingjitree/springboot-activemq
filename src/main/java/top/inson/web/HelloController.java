package top.inson.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        log.info("欢迎页面日志");
        return "ARE YOU OK?";
    }

}
