package com.cos.controllerdemo.web;

import com.cos.controllerdemo.domain.User;
import org.slf4j.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpBodyController {

    private static final Logger log = LoggerFactory.getLogger(HttpBodyController.class);

    @PostMapping("/body1")
    public String xWwwFormUrlencoded(String username) {
        log.info(username);
        return "key=value 요청됨";
    }

    @PostMapping("/body2")
    public String plainText(@RequestBody String data) {
        log.info(data);
        return "plain/text 전송 옴";
    }

    @PostMapping("/body3")
    public String applicationJson(@RequestBody String data) {
        log.info(data);
        return "json 전송 옴";
    }

    @PostMapping("/body4")
    public String applicationJson2(@RequestBody User user) {
        log.info(user.getUsername());
        return "json 전송 옴";
    }
}
