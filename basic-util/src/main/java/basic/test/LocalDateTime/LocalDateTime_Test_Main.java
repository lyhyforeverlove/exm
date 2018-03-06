package basic.test.LocalDateTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Arrays;
import java.util.Date;

public class LocalDateTime_Test_Main {

    static LocalDateTime toLocalDateTime(Date date){
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
    static Date toDate(LocalDateTime localDateTime){
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime_Test_Main.toLocalDateTime(new Date());
//        System.out.println("--->: " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//
//        Date date = LocalDateTime_Test_Main.toDate(LocalDateTime.now());
//        System.out.println("--->: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
//
//        System.out.println(LocalDateTime.parse("2018-01-04 14:23:30",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//
//        System.out.println(LocalDate.parse("2018-01-04",DateTimeFormatter.ofPattern("yyyy-MM-dd"))
//                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//
        System.out.println("Duration-->: " + Duration.between(LocalDateTime.parse("1949-10-01 12:00:00"
                ,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),LocalDateTime.now()).toDays());
//
        System.out.println("ChronoUnit--->：" + ChronoUnit.DAYS.between(LocalDateTime.parse("1949-10-01 12:00:00"
                ,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),LocalDateTime.now()));
        System.out.println("ChronoUnit--->：" + ChronoUnit.WEEKS.between(LocalDateTime.parse("1949-10-01 12:00:00"
                ,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),LocalDateTime.now()));
        System.out.println("ChronoUnit--->：" + ChronoUnit.MONTHS.between(LocalDateTime.parse("1949-10-01 12:00:00"
                ,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),LocalDateTime.now()));
        System.out.println("ChronoUnit--->：" + ChronoUnit.YEARS.between(LocalDateTime.parse("1949-10-01 12:00:00"
                ,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),LocalDateTime.now()));


    }


}