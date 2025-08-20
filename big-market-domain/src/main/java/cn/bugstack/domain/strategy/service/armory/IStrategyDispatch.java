package cn.bugstack.domain.strategy.service.armory;

import cn.bugstack.domain.strategy.model.valobj.StrategyAwardStockKeyVO;

import java.util.Date;

/**
 *策略抽奖调度
 */
public interface IStrategyDispatch {

    /**
     * 获取抽奖策略装配的随机结果
     */
    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(Long strategyId,String ruleWeightValue);
    /**
     * 库存扣减
     */
    Boolean subtractAwardStock(Long strategyId, Integer awardId, Date endDateTime);

}
