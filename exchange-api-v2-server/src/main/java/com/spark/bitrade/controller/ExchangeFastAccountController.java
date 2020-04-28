package com.spark.bitrade.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spark.bitrade.entity.ExchangeFastAccount;
import com.spark.bitrade.service.ExchangeFastAccountService;
import com.spark.bitrade.util.MessageRespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * exchange_fast_account(ExchangeFastAccount)控制层
 *
 * @author yangch
 * @since 2019-06-24 17:06:30
 */
@RestController
@RequestMapping("api/v2/exchangeFastAccount")
@Api(tags = "exchange_fast_account控制层")
public class ExchangeFastAccountController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ExchangeFastAccountService exchangeFastAccountService;

    /**
     * 分页查询所有数据
     *
     * @param size                分页.每页数量
     * @param current             分页.当前页码
     * @param exchangeFastAccount 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据接口", notes = "分页查询所有数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "分页.每页数量。eg：10", defaultValue = "10", name = "size", dataTypeClass = Integer.class, required = true),
            @ApiImplicitParam(value = "分页.当前页码.eg：从1开始", name = "current", defaultValue = "1", dataTypeClass = Integer.class, required = true),
            @ApiImplicitParam(value = "实体对象", name = "exchangeFastAccount", dataTypeClass = ExchangeFastAccount.class)
    })
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public MessageRespResult<IPage<ExchangeFastAccount>> list(Integer size, Integer current, ExchangeFastAccount exchangeFastAccount) {
        return success(this.exchangeFastAccountService.page(new Page<>(current, size), new QueryWrapper<>(exchangeFastAccount)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据接口", notes = "通过主键查询单条数据接口")
    @ApiImplicitParam(value = "主键", name = "id", dataTypeClass = Serializable.class, required = true)
    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST})
    public MessageRespResult<ExchangeFastAccount> get(@RequestParam("id") Serializable id) {
        return success(this.exchangeFastAccountService.getById(id));
    }

//    /**
//     * 新增数据
//     *
//     * @param exchangeFastAccount 实体对象
//     * @return 新增结果
//     */
//    @ApiOperation(value = "新增数据接口", notes = "新增数据接口")
//    @ApiImplicitParam(value = "实体对象", name = "exchangeFastAccount", dataTypeClass =ExchangeFastAccount.class )
//    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
//    public MessageRespResult add(ExchangeFastAccount exchangeFastAccount) {
//        return success(this.exchangeFastAccountService.save(exchangeFastAccount));
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param exchangeFastAccount 实体对象
//     * @return 修改结果
//     */
//    @ApiOperation(value = "修改数据接口", notes = "修改数据接口")
//    @ApiImplicitParam(value = "实体对象", name = "exchangeFastAccount", dataTypeClass =ExchangeFastAccount.class )
//    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
//    public MessageRespResult update(ExchangeFastAccount exchangeFastAccount) {
//        return success(this.exchangeFastAccountService.updateById(exchangeFastAccount));
//    }
//
//    /**
//     * 删除数据
//     *
//     * @param idList 主键集合
//     * @return 删除结果
//     */
//    @DeleteMapping
//    @ApiOperation(value = "删除数据接口", notes = "删除数据接口")
//    @ApiImplicitParam(value = "主键集合", name = "idList", dataTypeClass = List.class, required = true)
//    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
//    public MessageRespResult delete(@RequestParam("idList") List<Serializable> idList) {
//        return success(this.exchangeFastAccountService.removeByIds(idList));
//    }
}