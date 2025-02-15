package com.comparator;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

// AnonymousClass.class AnonymousClass$1.class AnonymousClass$2.class
public class AnonymousClass {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running Thread");
            }
        });
        thread.start();

        // two thread - 1 thread print odd numbers, 1 thread print even number
        //

        List<String> names = Arrays.asList("abc", "def", "ghi");
        names.forEach(System.out::println);

        //joda-time
        LocalDate now = LocalDate.now();
        LocalDate birthDate = LocalDate.of(2000, Month.JANUARY, 1);
        Period age = Period.between(birthDate, now);
        System.out.println(age.getYears());

    }
}
