package br.mattsousa.utils;

import java.text.DateFormat;

public class Utils {
    public static int getSerialNumber() {
        return (int) (Math.random() * 1000000) + 99999;
    }

    public static boolean matchDateFormat(String date) {
        DateFormat format = DateFormat.getDateInstance();
        try {
            format.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
