package cn.bugstack.domain.activity.service.armory;

import cn.bugstack.domain.activity.model.entity.ActivitySkuEntity;
import cn.bugstack.domain.activity.repository.IActivityRepository;
import cn.bugstack.types.common.Constants;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ActivityArmory implements IActivityArmory,IActivityDispatch {
    @Resource
    private IActivityRepository activityRepository;


    @Override
    public boolean assembleActivitySkuByActivityId(long activityId) {
        //获取sku对待过
        List<ActivitySkuEntity> activitySkuEntities = activityRepository.queryActivitySkuListByactivityId(activityId);
        for (ActivitySkuEntity activitySkuEntity : activitySkuEntities) {
            //将活动库存预热到缓存中
            cacheActivitySkuStockCount(activitySkuEntity.getSku(),activitySkuEntity.getStockCountSurplus());

            // 预热活动次数【查询时预热到缓存】
            activityRepository.queryRaffleActivityCountByActivityCountId(activitySkuEntity.getActivityCountId());
        }
        // 预热活动【查询时预热到缓存】
        activityRepository.queryRaffleActivityByActivityId(activityId);

        return false;
    }

    @Override
    public boolean assembleActivitySku(Long sku) {
        //获取sku对象
        ActivitySkuEntity activitySkuEntity = activityRepository.queryActivitySku(sku);
        //将活动库存预热到缓存中
        cacheActivitySkuStockCount(sku,activitySkuEntity.getStockCountSurplus());

        // 预热活动【查询时预热到缓存】
        activityRepository.queryRaffleActivityByActivityId(activitySkuEntity.getActivityId());

        // 预热活动次数【查询时预热到缓存】
        activityRepository.queryRaffleActivityCountByActivityCountId(activitySkuEntity.getActivityCountId());

        return true;
    }

    private void cacheActivitySkuStockCount(Long sku, Integer stockCountSurplus) {
        String cacheKey = Constants.RedisKey.ACTIVITY_SKU_STOCK_COUNT_KEY + sku;
        activityRepository.cacheActivitySkuStockCount(cacheKey, stockCountSurplus);
    }

    @Override
    public boolean subtractionActivitySkuStock(Long sku, Date endDateTime) {
        String cacheKey = Constants.RedisKey.ACTIVITY_SKU_STOCK_COUNT_KEY + sku;
        return activityRepository.subtractionActivitySkuStock(sku, cacheKey, endDateTime);
    }
}
