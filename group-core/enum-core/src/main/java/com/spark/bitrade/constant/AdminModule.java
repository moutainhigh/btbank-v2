package com.spark.bitrade.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Zhang Jinwei
 * @date 2017年12月19日
 */
@AllArgsConstructor
@Getter
public enum AdminModule {
	CMS("CMS"),
	COMMON("COMMON"),
	EXCHANGE("EXCHANGE"),
	FINANCE("FINANCE"),
	MEMBER("MEMBER"),
	OTC("OTC"),
	SYSTEM("SYSTEM"),
	PROMOTION("PROMOTION"),
	PAY("PAY");
	@Setter
	private String title;
}