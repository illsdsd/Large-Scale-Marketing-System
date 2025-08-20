package cn.bugstack.domain.strategy.model.entity;

import cn.bugstack.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import lombok.*;

/**
 * 规则动作实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleActionEntity< T extends RuleActionEntity.RaffleEntity> {

    private String code = RuleLogicCheckTypeVO.ALLOW.getCode();
    private String info = RuleLogicCheckTypeVO.ALLOW.getInfo();
    private String ruleModel;
    private T data;


    static public class RaffleEntity{

    }
    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static public class RaffleBeforeEntity extends RaffleEntity{
        private Long strategyId;

        private String ruleWeightValueKey;

        private Integer awardId;
    }
    static public class RaffleAfterEntity extends RaffleEntity{

    }
    static public class RaffleCenterEntity extends RaffleEntity{

    }

}
