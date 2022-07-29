package spring.cloud.sentinel.feign;

import org.springframework.stereotype.Component;

@Component
public class providerimol implements provider{
    @Override
    public String getPayment(Integer id) throws IllegalAccessException {
        return "Feign---fallback";
    }
}
