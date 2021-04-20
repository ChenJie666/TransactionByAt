package transaction.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import transaction.service.UserService;

import javax.annotation.Resource;

/**
 * @author CJ
 * @date 2021/4/15 10:23
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PutMapping("/points")
    public void points(Long userId, Long points){
        userService.decreasePoints(userId, points);
    }


}
