package transaction.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author CJ
 * @date 2021/4/20 16:27
 */
@FeignClient("commodity")
public interface CommodityFeign {

    /**
     * 增加或减少库存
     *
     * @param commodityId 商品id
     * @param stock       增加或减少的库存
     */
    @PutMapping("/stock")
    void stock(@RequestParam("commodityId") Long commodityId, @RequestParam("stock") Long stock);

}
