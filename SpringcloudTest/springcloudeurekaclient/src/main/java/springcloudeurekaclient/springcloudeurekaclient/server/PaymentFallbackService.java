package springcloudeurekaclient.springcloudeurekaclient.server;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements FeignClientService{

    @Override
    public String add(String userId, String userName) {
        return "PaymentFallbackService fall  add 服务器出现故障,o(╥﹏╥)o";
    }

    @Override
    public String add2(Integer id) {
        return "PaymentFallbackService fall  add2 服务器出现故障,o(╥﹏╥)o";
    }

    @Override
    public String add3(Integer id) {
        return "PaymentFallbackService fall  add3 服务器出现故障,o(╥﹏╥)o";
    }
}
