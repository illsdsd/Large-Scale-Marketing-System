package cn.bugstack.domain.strategy.service.rule.chain;

/**
 * 装配
 */
public interface ILogicChainArmory {
    ILogicChain appendNext(ILogicChain next);

    ILogicChain next();
}
