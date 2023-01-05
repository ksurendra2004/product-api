package com.productapi.utils;

import com.productapi.model.Inventory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DateUtility {

    public static LocalDate localDateFormatter(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }

    public static String localDateToStringFormatter(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static Date dateFormat(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        /*
        Date date1 = formatter.parse(date);
        System.out.println(date1);
        System.out.println(formatter.format(date1)); // print in string format
         */
        return formatter.parse(date);
    }

    public static String getDateInStringFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static boolean isValidDate(Inventory inventoryList, List<Inventory> invList) {
        //LocalDate iDate = inventoryList.stream().map(Inventory::getAvailDate).findFirst().get();
        LocalDate iDate = inventoryList.getAvailDate();
        List<LocalDate> list = invList.stream().map(Inventory::getAvailDate).collect(Collectors.toList());
        if(iDate.isBefore(list.stream().min(LocalDate::compareTo).get()))
            return true;
        return iDate.isAfter(list.stream().max(LocalDate::compareTo).get());
    }
}
