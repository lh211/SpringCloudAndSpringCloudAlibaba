package spring.cloud.stream.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.stream.Service.send;

import javax.annotation.Resource;

@RestController
public class SendMessageController
{
    @Resource
    private send messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProvider.sent();
    }

}
