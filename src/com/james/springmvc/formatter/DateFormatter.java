package com.james.springmvc.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter  implements Formatter<Date>{

    private String datePattern;
    private SimpleDateFormat dateFormat;

    public DateFormatter(String datePattern) {
        this.datePattern = datePattern;
        dateFormat=new SimpleDateFormat(datePattern);
       /* dateFormat.setLenient(false);*/
    }

    @Override
    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        try{

            return dateFormat.parse(s);

        }catch (ParseException pe){
            //使用<form:errors>标签时会显示如下语句
            throw new IllegalArgumentException("invalid date format,please use this pattern"+datePattern);
        }


    }
}
