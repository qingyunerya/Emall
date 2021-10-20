package com.erya.mall.service.impl;


import com.erya.mall.mapper.CmsHelpMapper;
import com.erya.mall.model.CmsHelp;
import com.erya.mall.model.CmsHelpExample;
import com.erya.mall.service.CmsHelpService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * PmsBrandService
 * Created by macro on 2019/4/19.
 */
@Service
public class CmsHelpServiceImpl implements CmsHelpService {

    @Resource
    private CmsHelpMapper cmsHelpMapper;

    @Override
    public List<CmsHelp> listHelp() {
        return cmsHelpMapper.selectByExample(new CmsHelpExample());
    }

    @Override
    public List<CmsHelp> listHelp(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return cmsHelpMapper.selectByExample(new CmsHelpExample());
    }

    @Override
    public int createHelp(CmsHelp help) {
        return cmsHelpMapper.insertSelective(help);
    }

    @Override
    public int deleteHelp(Long id) {
        return cmsHelpMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateHelp(Long id, CmsHelp help) {
        help.setId(id);
        return cmsHelpMapper.updateByPrimaryKeySelective(help);
    }

    @Override
    public CmsHelp getHelp(Long id) {
        return cmsHelpMapper.selectByPrimaryKey(id);
    }
}
