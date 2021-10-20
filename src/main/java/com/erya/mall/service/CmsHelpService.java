package com.erya.mall.service;


import com.erya.mall.model.CmsHelp;

import java.util.List;

/**
 * PmsBrandService
 * Created by macro on 2019/4/19.
 */
public interface CmsHelpService {
    List<CmsHelp> listHelp();
    List<CmsHelp> listHelp(int pageNum, int pageSize);
    int createHelp(CmsHelp help);
    int deleteHelp(Long id);
    int updateHelp(Long id, CmsHelp help);
    CmsHelp getHelp(Long id);
}
