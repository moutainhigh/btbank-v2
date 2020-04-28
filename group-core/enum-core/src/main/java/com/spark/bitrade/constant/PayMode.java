package com.spark.bitrade.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import com.spark.bitrade.core.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author daring5920
 * @date 2018年01月20日
 */
@AllArgsConstructor
@Getter
public enum PayMode implements BaseEnum {
    ALI("支付宝"), WECHAT("微信"), BANK("银联"), EPAY("Epay");

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal() {
        return ordinal();
    }

    public static PayMode of(int ordinal) {
        for (PayMode value : PayMode.values()) {
            if (value.ordinal() == ordinal) {
                return value;
            }
        }
        return null;
    }
}
