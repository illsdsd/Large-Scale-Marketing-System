package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 策略 DAO
 */
@Mapper
public interface IStrategyDao {

    List<Strategy> queryAwardList();
}
