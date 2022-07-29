package spring.cloud.nacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    @SentinelResource(value = "bbb",fallback = "fallbackgetPayment",blockHandler = "blockHandlergetPayment")
    public String getPayment(@PathVariable("id") Integer id) throws IllegalAccessException {
        if (id>4){
            throw new IllegalAccessException("违法参数请重新访问！！！！");
        }

        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }


    public String fallbackgetPayment(@PathVariable("id") Integer id,Throwable throwable) throws IllegalAccessException {


        return "提供方 sentinel--fallback";
    }
    public String blockHandlergetPayment(@PathVariable("id") Integer id, BlockException throwable) throws IllegalAccessException {


        return "提供方 sentinel--Block";
    }

}

