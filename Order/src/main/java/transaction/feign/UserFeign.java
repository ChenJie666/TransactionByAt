package transaction.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author CJ
 * @date 2021/4/20 16:27
 */
@FeignClient("user")
public interface UserFeign {

    /**
     * 增加或减少用户积分
     * @param userId 用户id
     * @param points 用户积分
     */
    @PutMapping("/points")
    void points(Long userId, Long points);

}
