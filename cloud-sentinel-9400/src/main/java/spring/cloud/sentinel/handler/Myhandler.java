package spring.cloud.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import spring.cloud.sentinel.feign.provider;

public class Myhandler {



    public  static String testHotKey1(@PathVariable Integer id,BlockException exception) {
        //int age = 10/0;
        System.out.println("===============");
        return "sertinel ---block";
    }


    public static String getPaymentfallback(@PathVariable Integer id,Throwable e) throws IllegalAccessException {

        return "sertinel ---fallback" ;
    }
}
