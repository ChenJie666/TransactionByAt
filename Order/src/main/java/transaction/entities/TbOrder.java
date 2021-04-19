package transaction.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author CJ
 * @date 2021/4/15 10:14
 */
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbOrder implements Serializable {
    private static final long serialVersionUID = Long.MIN_VALUE;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 购买的商品id
     */
    private Long commodityId;

    /**
     * 购买的数量
     */
    private Long num;

    /**
     * 使用的积分数
     */
    private Long points;

}
