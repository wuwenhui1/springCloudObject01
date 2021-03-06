package springcloudeureka.provider2.server;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHabdler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    } )
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 4;
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHabdler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    } )
    public String paymentInfo_TimeOut2(Integer id) {
        //异常错误的演示代码
        int age = 10/0;
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +"O(∩_∩)O哈哈~  耗时(秒)" ;
    }
    /**
     * 超时访问到这里兜底
     *
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHabdler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOutHabdler,id:" + id + "\t" +
                "系统繁忙，请稍后再试****o(╥﹏╥)o" ;
    }
}
