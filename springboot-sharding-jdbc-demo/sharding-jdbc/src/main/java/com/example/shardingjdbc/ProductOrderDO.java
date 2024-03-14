package com.example.shardingjdbc;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author zbm
 * @date 2024/3/1410:08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("product_order")
public class ProductOrderDO {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String outTradeNo;

    private String state;

    private Date createTime;

    private Double payAmount;

    private String nickName;

    private Long userId;

}

