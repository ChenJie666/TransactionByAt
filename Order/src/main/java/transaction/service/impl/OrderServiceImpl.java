package transaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transaction.entities.TbOrder;
import transaction.mapper.OrderMapper;
import transaction.service.OrderService;

/**
 * @author CJ
 * @date 2021/4/15 10:26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, TbOrder> implements OrderService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String order(TbOrder tbOrder) {
        // TODO 创建订单并发送消息
        // 1. 存储订单
        boolean save = save(tbOrder);


        return "ok";
    }

}
