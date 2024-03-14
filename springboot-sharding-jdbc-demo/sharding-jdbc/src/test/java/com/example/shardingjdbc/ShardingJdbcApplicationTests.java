package com.example.shardingjdbc;

import com.example.shardingjdbc.mapper.ProductOrderMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
class ShardingJdbcApplicationTests {

    @Autowired
    private ProductOrderMapper productOrderMapper;

    @Test
    public void testSaveProductOrder(){
        for(int i=1;i<=10;i++){
            ProductOrderDO productOrder = new ProductOrderDO();
            productOrder.setCreateTime(new Date());
            productOrder.setNickName("小苏="+i);
            productOrder.setPayAmount(100.00);
            productOrder.setState("PAY");
            productOrder.setId(Long.valueOf(i+""));
            productOrderMapper.insert(productOrder);
        }
    }

    public static void main(String[] args) {
        System.out.println(7%2);
    }

}
