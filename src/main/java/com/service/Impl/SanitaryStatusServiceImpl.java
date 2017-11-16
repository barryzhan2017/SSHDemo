package com.service.Impl;

import com.dao.SanitaryStatusDao;
import com.pojo.SanitaryStatus;
import com.service.SanitaryStatusService;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/16/2017.
 */
public class SanitaryStatusServiceImpl implements SanitaryStatusService {
    SanitaryStatusDao sanitaryStatusDao;

    public SanitaryStatusDao getSanitaryStatusDao() {
        return sanitaryStatusDao;
    }

    public void setSanitaryStatusDao(SanitaryStatusDao sanitaryStatusDao) {
        this.sanitaryStatusDao = sanitaryStatusDao;
    }

    @Override
    public List<SanitaryStatus> getAllSanitaryStatus(Integer id) {
        return sanitaryStatusDao.getAllSanitaryStatus(id);
    }
}
