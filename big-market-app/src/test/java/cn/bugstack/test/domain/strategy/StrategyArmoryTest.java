package cn.bugstack.test.domain.strategy;


import cn.bugstack.domain.strategy.service.armory.IStrategyArmory;
import cn.bugstack.domain.strategy.service.armory.IStrategyDispatch;
import cn.bugstack.domain.strategy.service.armory.StrategyArmoryDispatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 策略装配策略操作
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {
    @Resource
    private StrategyArmoryDispatch strategyArmoryDispatch;
    @Resource
    private IStrategyArmory strategyArmory;
    @Resource
    private IStrategyDispatch strategyDispatch;

    /**
     * 创建策略表写入Redis中
     */
    @Test
    public void test_strategyArmory(){
      boolean success = strategyArmory.assembleLotteryStrategy(100001L);
      log.info("测试结果：{}",success);

    }

    /**
     * 从策略表中随机获取奖品id
     */
    @Test
    public void test_getRandomAwardId() {
      strategyDispatch.getRandomAwardId(100001L);
    }
    /**
     * 根据策略id+权重值，从装配的策略中随机获取奖品ID值
     */
    @Test
    public void test_getRandomAwardID_ruleWeightValue()
    {
        log.info("测试结果奖品值：{} -4000策略配置",strategyArmoryDispatch.getRandomAwardId(100001L,"4000:102,103,104,105"));
        log.info("测试结果奖品值：{} -5000策略配置",strategyArmoryDispatch.getRandomAwardId(100001L,"5000:102,103,104,105,106,107"));
        log.info("测试结果奖品值：{} -6000策略配置",strategyArmoryDispatch.getRandomAwardId(100001L,"6000:102,103,104,105,106,107,108,109"));
    }


}
