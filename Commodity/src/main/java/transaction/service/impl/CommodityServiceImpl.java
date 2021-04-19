package transaction.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import transaction.entities.Commodity;
import transaction.mapper.CommodityMapper;
import transaction.service.CommodityService;


/**
 * @author CJ
 * @date 2021/4/15 10:26
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {


    @Override
    public Boolean decreaseStock(Long commodityId, Long num) {
        // TODO 扣减库存
        UpdateWrapper<Commodity> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id", commodityId).setSql("stock = stock - " + num);
        return update(null, userUpdateWrapper);
    }

}
