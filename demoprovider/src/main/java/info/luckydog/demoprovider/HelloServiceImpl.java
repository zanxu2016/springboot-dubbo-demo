package info.luckydog.demoprovider;

import com.alibaba.dubbo.config.annotation.Service;
import info.luckydog.demoapi.HelloService;

@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class HelloServiceImpl implements HelloService {

    private static int i = 0;

    @Override
    public String sayHello(String name) {
        i++;
        if (i % 3 == 0) {
            throw new RuntimeException("ex");
        }
        return "Hello " + name + "!";
    }
}
