package springcloudeurekaclient.springcloudeurekaclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springcloudeurekaclient.springcloudeurekaclient.server.FeignClientService;

@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PayController {
    @Autowired
    private FeignClientService feignClientService;//现在在使用的feign方式,,

    //现在在使用的feign方式,
    @RequestMapping(value = "payfeign",method = RequestMethod.GET)
    @HystrixCommand()
    public String query( Integer id){
        return feignClientService.add2(id);
    }

    //现在在使用的feign方式,,
    @RequestMapping(value = "payfeign2",method = RequestMethod.GET)
    @HystrixCommand()
    public String query2( Integer id){
        return feignClientService.add3(id);
    }

    //下面是全局fallback兜底方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
}
