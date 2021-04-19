package transaction.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transaction.entities.User;
import transaction.mapper.UserMapper;
import transaction.service.UserService;

import java.io.IOException;

import static org.springframework.transaction.interceptor.TransactionAspectSupport.currentTransactionStatus;


/**
 * @author CJ
 * @date 2021/4/15 10:26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public Boolean decreasePoints(Long userId, Long points) {
        // TODO 扣减积分
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id", userId).setSql("points = points - " + points);
        return update(null, userUpdateWrapper);
    }

}
