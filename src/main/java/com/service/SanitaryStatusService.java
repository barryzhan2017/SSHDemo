package com.service;

import com.pojo.SanitaryStatus;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/16/2017.
 */
public interface SanitaryStatusService {
    List<SanitaryStatus> getAllSanitaryStatus(Integer id);
}
