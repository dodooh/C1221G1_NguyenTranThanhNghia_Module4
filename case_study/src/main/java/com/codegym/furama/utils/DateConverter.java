package com.codegym.furama.utils;

public class DateConverter {

    /* from / to - */
    public static String fromFormToDB(String date) {

        String d = date.split("/")[0];
        String m = date.split("/")[1];
        String y = date.split("/")[2];

        return y + "-" + m + "-" + d;
    }

    public static String fromDBToForm(String date) {
        System.out.println(date);
        String y = date.split("-")[0];
        String m = date.split("-")[1];
        String d = date.split("-")[2];

        return d + "/" + m + "/" + y;
    }
}
