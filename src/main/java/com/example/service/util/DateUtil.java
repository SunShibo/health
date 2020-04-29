package com.example.service.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getNow(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
        return  format;
    }

    public static void main(String[] args) {
        System.out.println(getNow());
    }
}
