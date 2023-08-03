package com.design.strategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * @author Prasenjit Kumar Das
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {

        final int SMS_VERSION_NUMERIC = 2;

        Context context1 = new Context(new Add());
        System.out.println(context1.executeStrategy(2, 5));

        context1 = new Context(new Substract());
        System.out.println(context1.executeStrategy(10, 4));

        context1 = new Context(new Multiply());
        System.out.println(context1.executeStrategy(2, 3));

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd")));
        System.out.println(now.getDayOfMonth());
        System.out.println(now.format(DateTimeFormatter.ofPattern("yy")));
        System.out.println(now.getYear());
        System.out.println(now.format(DateTimeFormatter.ofPattern("MM")));
        System.out.println(now.getMonthValue());
        System.out.println(Integer.parseInt(now.format(DateTimeFormatter.ofPattern("yy"))));
        System.out.println(Integer.parseInt(now.format(DateTimeFormatter.ofPattern("yyyy")).substring(0, 2)));
        System.out.println(now.format(DateTimeFormatter.ofPattern("MMM")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("MMMM")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("EEE")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("EEEE")));
        System.out.println(now.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault()));
        System.out.println(now.getDayOfWeek().getValue());
        System.out.println(now.format(DateTimeFormatter.ofPattern("hh:mm:ssa")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("hh")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("h")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("HH")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("mm")));
        System.out.println(now.getMinute());
        System.out.println(now.format(DateTimeFormatter.ofPattern("ss")));
        System.out.println(now.getSecond());
        System.out.println(now.format(DateTimeFormatter.ofPattern("a")).toLowerCase());
        System.out.println(now.getHour() < 12 ? 0 : 1);
        System.out.println(String.valueOf(SMS_VERSION_NUMERIC));


    }
}
