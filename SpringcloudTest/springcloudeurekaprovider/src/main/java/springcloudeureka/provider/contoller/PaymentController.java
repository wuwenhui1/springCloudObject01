package springcloudeureka.provider.contoller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springcloudeureka.provider.server.PaymentService;

@RestController
public class PaymentController {

    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "payment/ok",method = RequestMethod.GET)
    public String paymentInfo_OK(@RequestParam Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        logger.info("*******************result:" + result);
        return result;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "timeOut",method = RequestMethod.GET)
    public String paymentInfo_TimeOut(@RequestParam Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        logger.info("*********************result:" + result);
        return result;

    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "timeOut2",method = RequestMethod.GET)
    public String paymentInfo_TimeOut2(@RequestParam Integer id) {
        String result = paymentService.paymentInfo_TimeOut2(id);
        logger.info("*********************result:" + result);
        return result;

    }
}
