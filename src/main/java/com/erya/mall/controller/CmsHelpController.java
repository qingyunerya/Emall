package com.erya.mall.controller;

import com.erya.mall.common.api.CommonPage;
import com.erya.mall.common.api.CommonResult;
import com.erya.mall.model.CmsHelp;
import com.erya.mall.service.CmsHelpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 帮助管理Controller
 * Created by macro on 2019/4/19.
 */
@Api(tags = "CmsHelpController", description = "帮助管理")
@Controller
@RequestMapping("/help")
public class CmsHelpController {

    @Autowired
    private CmsHelpService cmsHelpService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsHelpController.class);

    @ApiOperation("查询所有帮助")
    @GetMapping("/listAll")
    @ResponseBody
    public CommonResult<List<CmsHelp>> listHelp() {
        List<CmsHelp> cmsHelps = cmsHelpService.listHelp();
        return CommonResult.success(cmsHelps, "操作成功");
    }

    @ApiOperation("分页条件查询")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CmsHelp>> list(@RequestParam(value = "pageNum", defaultValue = "1") @ApiParam("页码")
                                                              Integer pageNum,
                                                  @RequestParam(value = "pageSize", defaultValue = "3") @ApiParam("每页数量") Integer pageSize) {
        List<CmsHelp> cmsHelps = cmsHelpService.listHelp(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(cmsHelps));
    }

    @ApiOperation("创建帮助")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createHelp(@RequestBody CmsHelp help) {
        int count = cmsHelpService.createHelp(help);
        CommonResult commonResult;
        if (count == 1) {
            commonResult = CommonResult.success(help);
            LOGGER.debug("createHelp success {}", help);
        } else {
            commonResult = CommonResult.failed("操作失败");
           LOGGER.debug("create Help failed {}", help);
        }
        return commonResult;
    }

    @ApiOperation("根据id更新帮助")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult updateHelp(@PathVariable("id") Long id, @RequestBody CmsHelp helpDto, BindingResult result) {
        int count = cmsHelpService.updateHelp(id, helpDto);
        CommonResult commonResult;
        if (count == 1) {
            commonResult = CommonResult.success(helpDto);
            LOGGER.debug("update help by id success {}", helpDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("update help failed {}", helpDto);
        }
        return commonResult;
    }

    @ApiOperation("根据id删除帮助")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult deleteHelp(@PathVariable("id") Long id) {
        int count = cmsHelpService.deleteHelp(id);
        if (count == 1) {
            LOGGER.debug("delete Help :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("delete Help failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("根据id获取指定帮助")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CmsHelp> help(@PathVariable("id") Long id) {
        return CommonResult.success(cmsHelpService.getHelp(id));
    }

}
