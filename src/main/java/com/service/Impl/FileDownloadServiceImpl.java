package com.service.Impl;

import com.service.FileDownloadService;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileDownloadServiceImpl implements FileDownloadService {
    @Override
    public InputStream getInputStream(String target) {
        InputStream inputStream=null;
        String path=ServletActionContext.getServletContext().getRealPath("userResource");
        try {
             inputStream=new FileInputStream(new File(path+"\\"+target));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
}
