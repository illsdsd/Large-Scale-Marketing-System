package cn.bugstack.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RaffleStrategyResponseDTO {

    //奖品id
    private Integer awardId;
    //排序编号【策略奖品配置的顺序编号】
    private Integer awardIndex;

}
