package com.dao;

import com.pojo.SanitaryStatus;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/16/2017.
 */
public interface SanitaryStatusDao {
    List<SanitaryStatus> getAllSanitaryStatus(Integer id);
    boolean addSanitaryStatus(SanitaryStatus sanitaryStatus);
}
