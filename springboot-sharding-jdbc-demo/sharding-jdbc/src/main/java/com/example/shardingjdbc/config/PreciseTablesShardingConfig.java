package com.example.shardingjdbc.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author zbm
 * @date 2024/3/1417:20
 */
public class PreciseTablesShardingConfig implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<Long> preciseShardingValue) {
        // 获取分片键的值
        Long shardingValue = preciseShardingValue.getValue();
        // 取模分表(取模都是从0到collection.size())
        long index = shardingValue.hashCode() % tableNames.size();
        // 判断逻辑表名
        String logicTableName = preciseShardingValue.getLogicTableName();
        // 物理表名
        String PhysicalTableName = logicTableName + "_" + (index);
        // 判断是否存在该表
        if (tableNames.contains(PhysicalTableName)) {
            return PhysicalTableName;
        }
        // 不存在则抛出异常
        throw new UnsupportedOperationException();

    }
}
