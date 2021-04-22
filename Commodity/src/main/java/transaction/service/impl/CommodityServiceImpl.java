package transaction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
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
    @Transactional(rollbackFor = Exception.class)
    public Boolean decreaseStock(Long commodityId, Long num) {
        QueryWrapper<Commodity> commodityQueryWrapper = new QueryWrapper<>();
        commodityQueryWrapper.eq("id", commodityId);
        Commodity commodity = getBaseMapper().selectOne(commodityQueryWrapper);
        Assert.isTrue(num.compareTo(commodity.getStock()) <= 0, "库存不足");
        // TODO 扣减库存
        UpdateWrapper<Commodity> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id", commodityId).setSql("stock = stock - " + num);
        return update(null, userUpdateWrapper);
    }

}
