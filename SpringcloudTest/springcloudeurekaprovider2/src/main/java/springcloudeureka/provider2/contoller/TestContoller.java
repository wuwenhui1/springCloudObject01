package springcloudeureka.provider2.contoller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {
//    @Autowired
//    private DiscoveryClient client;  //在2个server上加上这个就会让feign的负载生效..

    private final Logger logger = Logger.getLogger(getClass());

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String service(@RequestParam String userId){
        logger.info("执行了这里2.");
        return  userId;
    }
    @RequestMapping(value = "addfeign",method = RequestMethod.GET)
    public String service(@RequestParam String userId,@RequestParam String userName){
        logger.info("执行了这里2.");
        return  userId+":"+userName;
    }
}
