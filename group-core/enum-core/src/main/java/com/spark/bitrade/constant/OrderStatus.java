package com.spark.bitrade.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import com.spark.bitrade.core.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 场外订单状态
 *
 * @author Zhang Jinwei
 * @date 2017年12月11日
 */
@AllArgsConstructor
@Getter
public enum OrderStatus implements BaseEnum {

    /**
     * 0 已取消
     */
    CANCELLED("已取消"),
    /**
     * 1 未付款
     */
    NONPAYMENT("未付款"),
    /**
     * 2 已付款
     */
    PAID("已付款"),
    /**
     * 3 已完成
     */
    COMPLETED("已完成"),
    /**
     * 4 申诉中
     */
    APPEAL("申诉中"),
    /**
     * 5 已关闭
     */
    CLOSE("已关闭");

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal(){
        return this.ordinal();
    }
}
