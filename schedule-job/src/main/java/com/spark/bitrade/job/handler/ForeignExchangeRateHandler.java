package com.spark.bitrade.job.handler;

import com.spark.bitrade.service.IBtbankServerService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 换汇汇率和图片更新
 *
 * @author mahao
 * @since 2020/02/10 18:11
 */
@JobHandler(value = "foreignExchangeRateHandler")
@Component
public class ForeignExchangeRateHandler  extends IJobHandler {
    @Autowired
    private IBtbankServerService btbankServerService;
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        btbankServerService.foreignupdateimage();
        return ReturnT.SUCCESS;
    }
}
