package transaction.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import transaction.service.CommodityService;

import javax.annotation.Resource;

/**
 * @author CJ
 * @date 2021/4/15 10:23
 */
@RestController
public class CommodityController {

    @Resource
    private CommodityService commodityService;

    @PutMapping("stock")
    public void stock(Long commodityId, Long stock){
        commodityService.decreaseStock(commodityId, stock);
    }

}
