package com.spark.bitrade.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import com.spark.bitrade.core.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 证件类型
 * @author Zhang Yanjun
 * @time 2019.03.19 17:13
 */
@AllArgsConstructor
@Getter
public enum CertificateType implements BaseEnum {

    IDENTITY_CARD("身份证"),//0

    PASSPORT("护照"), //1

    LICENCE("驾照")//2
    ;

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal() {
        return this.ordinal();
    }
}
