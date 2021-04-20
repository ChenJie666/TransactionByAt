package transaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transaction.entities.TbOrder;
import transaction.feign.CommodityFeign;
import transaction.feign.UserFeign;
import transaction.mapper.OrderMapper;
import transaction.service.OrderService;

import javax.annotation.Resource;

/**
 * @author CJ
 * @date 2021/4/15 10:26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, TbOrder> implements OrderService {

    @Resource
    private UserFeign userFeign;

    @Resource
    private CommodityFeign commodityFeign;

    @Override
    @GlobalTransactional(name = "seata_group", rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public String order(TbOrder tbOrder) {
        // TODO 创建订单并发送消息
        // 1. 存储订单
        save(tbOrder);

        userFeign.points(tbOrder.getUserId(),tbOrder.getPoints());

        commodityFeign.stock(tbOrder.getCommodityId(),tbOrder.getNum());

        return "ok";
    }

}
