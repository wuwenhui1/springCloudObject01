package springcloudeurekaclient.springcloudeurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@ResponseBody
public class ConfigController {
    @Value("${name}")
    private String name;

    @GetMapping("/name")
    public String config(){return name;}
}
