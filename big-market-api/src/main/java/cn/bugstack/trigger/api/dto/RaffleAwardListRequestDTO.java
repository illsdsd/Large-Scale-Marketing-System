package cn.bugstack.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RaffleAwardListRequestDTO {
    //抽奖id
    @Deprecated
    private Long strategyId;

    private Long activityId;

    private String userId;
}
