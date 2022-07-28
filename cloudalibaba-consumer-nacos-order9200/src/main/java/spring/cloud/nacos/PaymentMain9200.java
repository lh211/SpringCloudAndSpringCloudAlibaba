package spring.cloud.nacos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9200 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9200.class, args);
    }
}
