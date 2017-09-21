package uisee;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.IntStream;

public class Solution {
     Date firstMonday(int year, int month){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1); //从0开始
        int day = 1;
        cal.set(Calendar.DAY_OF_MONTH, day);    //从第一天开始找第一个星期一
        while(cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY){
            cal.set(Calendar.DAY_OF_MONTH, ++day);
        }
        Date firstMonday = cal.getTime();
        String dtStr = new SimpleDateFormat("yyyy-MM-dd").format(firstMonday);
        System.out.println(dtStr);

        return firstMonday;
    }


     Date lastSunday(int year, int month){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);  //防止getInstance()返回今天是2月29号，被认为是3月了
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  //每个月的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        while(cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
            cal.set(Calendar.DAY_OF_MONTH, --lastDay);
        }
        Date lastSunday = cal.getTime();
        String dtStr = new SimpleDateFormat("yyyy-MM-dd").format(lastSunday);
        System.out.println(dtStr);

        return lastSunday;
    }

    public int solution(int Year, String A, String B, String W) {
        int month1 = getMon(A);
        int month2 = getMon(B);

        Date firstMonday = firstMonday(Year, month1);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(firstMonday);

        Date lastSunday = lastSunday(Year, month2);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(lastSunday);

        int weeks = (int)((calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / (24 * 60 * 60 * 1000) + 1) / 7;

        System.out.println(weeks);

        return weeks;
    }

    public int getMon(String A) {

        int month = 0;

        switch (A){
            case "January":
                month = 1;
                break;
            case "February":
                month = 2;
                break;
            case "March":
                month = 3;
                break;
            case "April":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "June":
                month = 6;
                break;
            case "July":
                month = 7;
                break;
            case "August":
                month = 8;
                break;
            case "September":
                month = 9;
                break;
            case "October":
                month = 10;
                break;
            case "November":
                month = 11;
                break;
            case "December":
                month = 12;
                break;
        }

        return month;
    }

    public static void main(String[] args) {

//        Date firstMonday = firstMonday(2014, 4);
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.setTime(firstMonday);
//
//        Date lastSunday = lastSunday(2014, 5);
//        Calendar calendar2 = Calendar.getInstance();
//        calendar2.setTime(lastSunday);
//
//        long weeks = ((calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / (24 * 60 * 60 * 1000) + 1) / 7;
//
//        System.out.println(weeks);

        Solution solution = new Solution();
        int weeks = solution.solution(2014,"April", "May", "w");
        System.out.println(weeks);
    }
}
