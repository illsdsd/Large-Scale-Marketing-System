package cn.bugstack.domain.activity.service.armory;

/**
 * 活动装配预热
 */
public interface IActivityArmory {
    boolean assembleActivitySkuByActivityId(long activityId);

    boolean assembleActivitySku(Long sku);
}
