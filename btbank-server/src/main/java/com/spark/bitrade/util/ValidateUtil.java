package com.spark.bitrade.util;

//import org.apache.commons.lang.StringUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 常用验证工具类
 * @author yanqizheng
 *
 */
public class ValidateUtil {
	
	/**
	 * 验证手机号格式是否正确
	 * @param phone
	 * @return
	 */
	public static boolean isMobilePhone(String phone){
		if (StringUtils.isBlank(phone)) {
			return false;
		}
		if (isChinaPhoneLegal(phone)){
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 验证身份证号码格式
	 * @return
	 */
	public static boolean isCard(String idNo){
		Pattern p2 = Pattern.compile("(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)");
		System.out.println(p2.matcher(idNo).matches());
		return p2.matcher(idNo).matches();
	}

	public static boolean isnull(String str){
		if(str==null){
			return true;
		}
		if(str=="" || str.length()==0){
			return true;
		}
		return false;
	}
	/**
	 * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
	 * 此方法中前三位格式有：
	 * 13+任意数
	 * 15+除4的任意数
	 * 18+任意数
	 * 17+任意数
	 * 147+任意数
	 * 16+任意数
	 */
	public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
		//add|edit|del by tansitao 时间： 2018/5/5 原因：增加16手机号码段
		String regExp = "^((13[0-9])|(15[^4])|(16[0-9])|(18[0-9])|(17[0-9])|(19[0-9])|(147))\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * 通用号码验证
	 * 规则：包含，数字和“-”号，可以是“+”开头
	 * @param str
	 */
	public static boolean isGeneralPhoneLegal(String str) throws PatternSyntaxException{
		String regExp = "\\+?\\d+(-?\\d+)*$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static boolean isUrl(String url){
		String regExp = "^(http|https|ftp)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(url);
		return m.matches();
	}

	public static boolean isEmail(String email){
		String regExp = "^([a-z0-9A-Z]+[_-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isChineseName(String name){
		String regExp = "^[\\u4e00-\\u9fa5]+(·[\\u4e00-\\u9fa5]+)*$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(name);
		return m.matches();
	}
}
