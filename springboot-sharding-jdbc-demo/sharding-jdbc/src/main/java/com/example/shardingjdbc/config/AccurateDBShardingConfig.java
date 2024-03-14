package com.example.shardingjdbc.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * 数据库精准分片
 * @author zbm
 * @date 2024/3/1417:08
 */
public class AccurateDBShardingConfig implements PreciseShardingAlgorithm<Long> {

    /**
     *
     * @param dataSourceNames 数据源集合
     *                      在分库时值为所有分片库的集合 databaseNames
     *                      分表时为对应分片库中所有分片表的集合 tablesNames
     *
     * @param shardingValue  分片属性，
     *                       logicTableName 为逻辑表，
     *                       columnName 分片健（字段），
     *                       value 为从 SQL 中解析出的分片健的值
     * @return
     */
    @Override
    public String doSharding(Collection<String> dataSourceNames, PreciseShardingValue<Long> shardingValue) {
        for (String databaseName : dataSourceNames) {

            String value = shardingValue.getValue().hashCode()%2+"";
            //value是0，则进入0库表，1则进入1库表
            if (databaseName.endsWith(value)) {
                return databaseName;
            }

        }
        throw new IllegalArgumentException();
    }

}
