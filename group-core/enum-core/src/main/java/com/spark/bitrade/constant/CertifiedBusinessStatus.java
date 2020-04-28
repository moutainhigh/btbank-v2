package com.spark.bitrade.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import com.spark.bitrade.core.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author daring5920
 * @date 2018年02月26日
 */
@AllArgsConstructor
@Getter
public enum CertifiedBusinessStatus implements BaseEnum {

    NOT_CERTIFIED("未认证"),

    AUDITING("认证-待审核"), //1

    VERIFIED("认证-审核成功"),//2

    FAILED("认证-审核失败"),  //3

    DEPOSIT_LESS("保证金不足"), //4

    CANCEL_AUTH("退保-待审核"), //5

    RETURN_FAILED("退保-审核失败"), //6

    RETURN_SUCCESS("退保-审核成功"), //7

    CANCEL_FORCE("强制取消")//8
    ;

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal() {
        return this.ordinal();
    }
}
