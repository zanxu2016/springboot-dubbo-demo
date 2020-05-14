package info.luckydog.democonsumer;

import com.alibaba.dubbo.config.annotation.Reference;
import info.luckydog.demoapi.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConsumerController {
    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://192.168.3.49:12345")
    private HelloService helloService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam("name") String name) {
        return helloService.sayHello(name);
    }
}
