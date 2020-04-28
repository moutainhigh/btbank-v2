package com.spark.bitrade.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import com.spark.bitrade.constant.BooleanEnum;
import com.spark.bitrade.constant.ExchangeCoinDisplayArea;
import lombok.Data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 交易币种配置表实体类
 *
 * @author yangch
 * @since 2019-09-03 13:44:40
 */
@SuppressWarnings("serial")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "交易币种配置实体")
public class ExchangeCoin {

    /**
     * 交易对
     */
    @TableId
    @ApiModelProperty(value = "交易对", example = "")
    private String symbol;

    /**
     * 基币精度
     */
    @ApiModelProperty(value = "基币精度", example = "")
    private Integer baseCoinScale;

    /**
     * 基币
     */
    @ApiModelProperty(value = "基币", example = "")
    private String baseSymbol;

    /**
     * 交易币精度
     */
    @ApiModelProperty(value = "交易币精度", example = "")
    private Integer coinScale;

    /**
     * 交易币
     */
    @ApiModelProperty(value = "交易币", example = "")
    private String coinSymbol;

    /**
     * 状态，1：启用，2：禁止
     */
    @ApiModelProperty(value = "是否启用", example = "")
    private Integer enable;

    /**
     * 交易手续费
     */
    @ApiModelProperty(value = "交易手续费", example = "")
    private BigDecimal fee;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", example = "")
    private Integer sort;

    /**
     * 是否启用市价买
     */
    @ApiModelProperty(value = "是否启用市价买", example = "")
    private BooleanEnum enableMarketBuy = BooleanEnum.IS_TRUE;

    /**
     * 是否启用市价卖
     */
    @ApiModelProperty(value = "是否启用市价卖", example = "")
    private BooleanEnum enableMarketSell = BooleanEnum.IS_TRUE;

    /**
     * 最低挂单卖价
     */
    @ApiModelProperty(value = "最低挂单卖价", example = "")
    private BigDecimal minSellPrice;

    /**
     * 
     */
    @ApiModelProperty(value = "", example = "")
    private Integer flag;

    /**
     * 最大允许同时交易的订单数，0表示不限制
     */
    @ApiModelProperty(value = "最大允许同时交易的订单数，0表示不限制", example = "")
    private Integer maxTradingOrder;

    /**
     * 委托超时自动下架时间，单位为秒，0表示不过期
     */
    @ApiModelProperty(value = "委托超时自动下架时间，单位为秒，0表示不过期", example = "")
    private Integer maxTradingTime;

    /**
     * 最小挂单成交额
     */
    @ApiModelProperty(value = "最小挂单成交额", example = "")
    private BigDecimal minTurnover;

    /**
     * 最小挂单数量
     */
    @ApiModelProperty(value = "最小挂单数量", example = "")
    private BigDecimal minAmount;

    /**
     * 买币手续费的折扣率
     */
    @ApiModelProperty(value = "买币手续费的折扣率", example = "")
    private BigDecimal feeBuyDiscount;

    /**
     * 卖币手续费的折扣率
     */
    @ApiModelProperty(value = "卖币手续费的折扣率", example = "")
    private BigDecimal feeSellDiscount;

    /**
     * 币种区域
     */
    @ApiModelProperty(value = "币种区域", example = "")
    private ExchangeCoinDisplayArea displayArea;

}