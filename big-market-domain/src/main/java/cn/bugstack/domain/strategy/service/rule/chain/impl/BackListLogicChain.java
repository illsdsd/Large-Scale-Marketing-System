package cn.bugstack.domain.strategy.service.rule.chain.impl;

import cn.bugstack.domain.strategy.repository.IStrategyRepository;
import cn.bugstack.domain.strategy.service.rule.chain.AbstractLogicChain;
import cn.bugstack.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import cn.bugstack.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 黑名单方法
 */
@Slf4j
@Component("rule_blacklist")
public class BackListLogicChain extends AbstractLogicChain {
    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId) {
        log.info("抽奖责任链-黑名单开始 userId:{} strategyId:{} ruleModel:{}", userId, strategyId,ruleModel());
        String ruleValue=strategyRepository.queryStrategyRuleValue(strategyId,ruleModel());
        String[] splitRuleValue = ruleValue.split(Constants.COLON);
        Integer awardId = Integer.parseInt(splitRuleValue[0]);
        //过滤其他规则
        String[] userBlackIds=splitRuleValue[1].split(Constants.SPLIT);
        for (String userBlackId : userBlackIds) {
              if(userId.equals(userBlackId)){
                  log.info("抽奖责任链-黑名单接管  userId:{} strategyId:{} ruleModel:{}", userId, strategyId,ruleModel());
                  return DefaultChainFactory.StrategyAwardVO.builder()
                          .awardId(awardId)
                          .logicModel(ruleModel())
                          .awardRuleValue("0.01,1")
                          .build();
              }
        }
        log.info("抽奖责任链-黑名单放行  userId:{} strategyId:{} ruleModel:{}", userId, strategyId,ruleModel());
        return next().logic(userId,strategyId);
    }

    @Override
    protected String ruleModel() {
        return DefaultChainFactory.LogicModel.RULE_BLACKLIST.getCode();
    }
}
