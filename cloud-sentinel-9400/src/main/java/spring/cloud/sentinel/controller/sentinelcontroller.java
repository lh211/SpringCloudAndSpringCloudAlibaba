package spring.cloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.sentinel.feign.provider;
import spring.cloud.sentinel.handler.Myhandler;

import javax.annotation.Resource;

@RestController
@Slf4j
public class sentinelcontroller {

    @Resource
    provider provider;


    @GetMapping("/testA")
    public String testA() throws InterruptedException {
//        Thread.sleep(3000);
        log.info("testA================");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() throws InterruptedException {

//        Thread.sleep(3000);
//        int a = 10/0;
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

    @GetMapping("/testHotKey")
//    @SentinelResource(value = "test",blockHandlerClass = {Myhandler.class},blockHandler = "testHotKey1")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        //int age = 10/0;
        System.out.println("===============");
        return "------testHotKey";
    }



    /*兜底方法*/
    public String deal_testHotKey (String p1, String p2, BlockException exception) {
        return "------deal_testHotKey,o(╥﹏╥)o";  //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }

    @GetMapping("/c/payment/nacos/{id}")
    @SentinelResource(value = "aaaa" ,fallbackClass ={Myhandler.class} ,fallback = "getPaymentfallback",
            blockHandlerClass = {Myhandler.class},blockHandler = "testHotKey1")
    public String getPayment(@PathVariable Integer id) throws IllegalAccessException {

        int a = 10/0;
        String payment = provider.getPayment(id);
        return payment;
    }




}

