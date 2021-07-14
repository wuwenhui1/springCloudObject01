package springcloudeurekaclient.springcloudeurekaclient.server;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient("eureka-provider")
@Component
@FeignClient(value = "eureka-provider")
public interface FeignClientService {
    @RequestMapping(value = "/addfeign",method = RequestMethod.GET)
    String add(@RequestParam(value = "userId")String userId, @RequestParam("userName")String userName);

    @RequestMapping(value = "/timeOut",method = RequestMethod.GET)
    String add2(@RequestParam(value = "id")Integer id);

    @RequestMapping(value = "/timeOut2",method = RequestMethod.GET)
    String add3(@RequestParam(value = "id")Integer id);
}
