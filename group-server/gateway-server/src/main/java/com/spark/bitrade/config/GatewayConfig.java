package com.spark.bitrade.config;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitUtils;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.support.DefaultRateLimitKeyGenerator;
import com.spark.bitrade.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
  * 
  * @author young
  * @time 2018.07.04 13:47
  */

@Configuration
public class GatewayConfig {
    //特殊URL（rest风格的URL）合并处理
    private static Map<String, List<String>> mergeUrlMap = new HashMap<>();

    static {
        List<String> exchangeList = new ArrayList<>();
//        exchangeList.add("/order/cancel/");
//        exchangeList.add("/order/detail/");

        mergeUrlMap.put("exchange", exchangeList);

        //List<String> ucList = new ArrayList<>();
        //ucList.add("/ancillary/system/advertise/");
        //mergeUrlMap.put("uc", ucList);
    }

    //重写限流key的生成规则
    @Bean
    public RateLimitKeyGenerator ratelimitKeyGenerator(RateLimitProperties properties, RateLimitUtils rateLimitUtils) {
        return new DefaultRateLimitKeyGenerator(properties, rateLimitUtils) {
            @Override
            public String key(HttpServletRequest request, Route route, RateLimitProperties.Policy policy) {
                //System.out.println("url=="+request.getRequestURI()+",sessionId=="+request.getSession().+getId()",method="+request.getMethod()+",ip="+request.getRemoteHost());
                ///AuthMember user = (AuthMember)  request.getSession().getAttribute(SysConstant.SESSION_MEMBER);

                String prefix = super.key(request, route, policy);
                //处理特殊的url地址，防止生成过多无效的key
//                List<String> fitlerList = mergeUrlMap.get(route.getId());
//                if (fitlerList != null) {
//                    String mergeUrl;
//                    for (String fitlerUrl : fitlerList) {
//                        mergeUrl = new StringBuilder("/").append(route.getId()).append(fitlerUrl).toString();
//                        if (route.getPath().startsWith(mergeUrl)) {
//                            prefix = prefix.replace(route.getPath(), mergeUrl);
//                            break;
//                        }
//                    }
//                }

                //根据IP或token作为限流的重要参考依据
                //pc端token
                String token = request.getHeader("apiKey");
                if (StringUtils.isBlank(token)) {
                    //token = request.getSession().getId(); //sessionId
                    if (request == null || request.getSession() == null
                            || request.getSession().getId() == null) {
                        return prefix;
                    } else {
                        return prefix + ":" + request.getSession().getId();
                    }
                } else {
                    //处理限流的key
                    return prefix + ":" + MD5Util.md5Encode(token.concat("apiKey"));
                }
            }
        };
    }

}
