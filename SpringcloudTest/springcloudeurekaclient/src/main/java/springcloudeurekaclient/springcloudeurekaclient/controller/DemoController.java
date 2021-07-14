package springcloudeurekaclient.springcloudeurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloudeurekaclient.springcloudeurekaclient.server.FeignClientService;

@RestController
public class DemoController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private FeignClientService feignClientService;//现在在使用的feign方式,,

    //ribbon的调用方式
    @RequestMapping(value = "select",method = RequestMethod.GET)
    public String query( String userId){
        //下面这个地址就是2个服务端的   服务名称+新建的controller的开放接口...
        return restTemplate.getForObject("http://eureka-provider/add?userId="+userId,String.class);
    }

    //现在在使用的feign方式,,
    @RequestMapping(value = "selectfeign",method = RequestMethod.GET)
    public String query( String userId,String userName ){
        return feignClientService.add(userId,userName);
    }
}
