package cn.bugstack.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 规则物料实体对象，用于过滤规则的必要参数信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RuleMatterEntity {
    private String userId;

    private Long strategyId;

    private Integer awardId;

    private String ruleModel;
}
