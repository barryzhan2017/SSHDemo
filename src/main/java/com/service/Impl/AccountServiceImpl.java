package com.service.Impl;


import com.dao.AccountDao;
import com.pojo.Account;
import com.service.AccountService;
import org.apache.struts2.ServletActionContext;

import java.io.*;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    public AccountDao getAccountDao() {
        return accountDao;
    }
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public Account login(Account account) {
        String path=ServletActionContext.getServletContext().getRealPath("userResource");
        File headport=new File(path+"/"+"default.png");
        System.out.println(headport.getAbsolutePath());
        System.out.println(headport.length());
        Account ac=accountDao.findUserByIdAndPassword(account);
      return ac;
    }
    @Override
    public void register(Account account, File headPortrait) {
        account.setPortrait(getBytes(headPortrait));
        String path=ServletActionContext.getServletContext().getRealPath("userResource");
        File headport =new File(path+"/"+"default.png");
        account.setPortrait(getBytes(headport));
        accountDao.register(account);
        File dir =new File(path+"/"+account.getId());
        if(!dir.exists())
        {
            dir.mkdir();
        }

    }
    public byte[]getBytes(File file){
        if(file==null)
            return null;
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
     public File getFile(byte[] bfile, String target) {
        if(bfile==null)
            return null;
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
         String path=ServletActionContext.getServletContext().getRealPath("userResource");
        try {
            file = new File(path+"\\"+target);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file;
    }
    @Override
    public Account findById(Integer id) {
       Account ac=accountDao.findById(id);
        return ac;
    }
    @Override
    public void update(Account account, File headPortrait) {
        if(headPortrait==null)
            accountDao.update(account);
        if(headPortrait!=null&&headPortrait.exists())
        {
            account.setPortrait(getBytes(headPortrait));
            accountDao.update(account);

        }

    }
    @Override
    public InputStream getInputSream(File file){
        InputStream input= null;
        if(file==null)
            return null;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }
    public InputStream getInputStream (Account account) {
        if(account.getPortrait()==null)
            return null;
        InputStream input=new ByteArrayInputStream(account.getPortrait());
        return input;
    }
}
