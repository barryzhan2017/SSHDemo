package com.action;

import com.service.FileDownloadService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.InputStream;

public class FileDownloadAction extends ActionSupport {
    private String fileName;
    private String downloadFileName;
    private InputStream inputStream;
    private FileDownloadService fileDownloadService;

    public String getFileName()throws Exception {
        return  fileName;
    }
    public void setFileName(String fileName) throws Exception{
        this.fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getInputStream() throws Exception{
        return inputStream;
    }

    public String getDownloadFileName() throws Exception{
        downloadFileName=fileName.substring(fileName.lastIndexOf("\\",fileName.length()));
        downloadFileName=new String(this.downloadFileName.getBytes(),"ISO-8859-1");
        return downloadFileName;
    }

    public void setDownloadFileName(String downloadFileName) {
        this.downloadFileName = downloadFileName;
    }

    public FileDownloadService getFileDownloadService() {
        return fileDownloadService;
    }

    public void setFileDownloadService(FileDownloadService fileDownloadService) {
        this.fileDownloadService = fileDownloadService;
    }

    public String fileDownload()throws Exception{
        String re="success";
        inputStream=fileDownloadService.getInputStream(fileName) ;
        return re;
    }
}
