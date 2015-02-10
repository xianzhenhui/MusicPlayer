package com.tim.rename.impl;

import java.sql.Timestamp;

import com.tim.rename.interfaces.IRename;

public class RenameImpl implements IRename{

    @Override
    public String getRenameValue(String fileName, Object object) {
        if (fileName != null && fileName != "") {
            long time =System.currentTimeMillis();
            System.out.println("1.time:"+time);
            long random = Math.round(Math.random()*(10000)+3600000);
            System.out.println("2.random:"+random);
            time += (random + Thread.currentThread().getId()*60000)<<12;
            System.out.println("3.time:"+time);
//            System.out.println("time:"+time);
//            Timestamp tsTemp = new Timestamp(time);
//            System.out.println("timetamp:"+tsTemp);
//            String ts = tsTemp.toString();
            if (fileName.contains(".")) {
                fileName = fileName.substring(fileName.lastIndexOf('.'));
                fileName = Long.toString(time)+ fileName;
            }else {
                fileName = Long.toString(time);
            }
            return fileName;
        } else {
            return fileName;
        }
    }

}
