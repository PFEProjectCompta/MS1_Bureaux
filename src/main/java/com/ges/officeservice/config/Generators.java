package com.ges.officeservice.config;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class Generators {
    public static Date generateRandomDate() {
        Random random = new Random();


        long startDate = new Date(2009, 1, 1).getTime();
        long endDate = new Date(2022, 11, 31).getTime();

        long randomDateInMillis = startDate + (long) (random.nextDouble() * (endDate - startDate));

        return new Date(randomDateInMillis);
    }
    }
