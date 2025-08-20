package cn.bugstack.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.security.DenyAll;

/**
 * 策略奖品库存Key标识值对象
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardStockKeyVO {
    //策略ID
    private Long strategyId;
    //奖品id
    private Integer awardId;
}
