package spring.cloud.sentinel.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloudalibaba-provider-payment9100",fallback = providerimol.class)
public interface provider {

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) throws IllegalAccessException;
}
