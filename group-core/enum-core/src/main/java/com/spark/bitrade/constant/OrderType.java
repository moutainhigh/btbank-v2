package com.spark.bitrade.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import com.spark.bitrade.core.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 广告类型
 *
 * @author daring5920
 * @date 2017年12月07日
 */
@AllArgsConstructor
@Getter
public enum OrderType implements BaseEnum {

    /**
     * 购买
     */
    BUY("购买"),

    /**
     * 出售
     */
    SELL("出售");

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal(){
        return this.ordinal();
    }

}
