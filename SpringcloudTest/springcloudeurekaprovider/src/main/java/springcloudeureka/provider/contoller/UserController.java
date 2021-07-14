package springcloudeureka.provider.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloudeureka.provider.utils.UserExceptionCommand;
import springcloudeureka.provider.utils.UserTimeOutCommand;


@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/command/timeout")
    public String commandTimeout() {
        return new UserTimeOutCommand().execute();
    }

    @RequestMapping("/command/exception")
    public String commandException() {
        return new UserExceptionCommand().execute();
    }
}
