package org.alphacat.leetcode.solution.favorite;

public class No1185 {

    final static int SUNDAY = 0;
    final static int Monday = 1;
    final static int Tuesday = 2;
    final static int Wednesday = 3;
    final static int Thursday = 4;
    final static int Friday = 5;
    final static int Saturday = 6;

    final static int FEBRUARY = 2;

    final static int START_YEAR = 1971;

    final static int FEBRUARY_LEAP_YEAR_DAYS = 29;

    final static int DAY_SUM_LEAP_YEAR = 366;
    final static int DAY_SUM_COMMON_YEAR = 365;


    static int[] DAYS_OF_MONTH = getDaysOfMonthArr();
    static String[] dayOfWeek = dayOfWeek();

    public String dayOfTheWeek(int day, int month, int year) {
        int days = Thursday;//1970-1-1为星期五，因此1970年1月“0”号为星期四
        for (int i = START_YEAR; i < year; i++) {
            days += getDays(i);
        }
        for (int i = 1; i < month; i++) {
            days += getDaysOfMonth(i, year);
        }
        days += day;
        return dayOfWeek[days % 7];
    }


    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        }
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return true;
    }

    private static int getDays(int year) {
        return isLeapYear(year) ? DAY_SUM_LEAP_YEAR : DAY_SUM_COMMON_YEAR;
    }

    private static String[] dayOfWeek() {
        final int DAY_SUM = 7;
        String[] dayOfWeek = new String[DAY_SUM];
        dayOfWeek[SUNDAY] = "Sunday";
        dayOfWeek[Monday] = "Monday";
        dayOfWeek[Tuesday] = "Tuesday";
        dayOfWeek[Wednesday] = "Wednesday";
        dayOfWeek[Thursday] = "Thursday";
        dayOfWeek[Friday] = "Friday";
        dayOfWeek[Saturday] = "Saturday";
        return dayOfWeek;
    }

    private static int getDaysOfMonth(int month, int year) {
        if (month == FEBRUARY && isLeapYear(year)) {
            return FEBRUARY_LEAP_YEAR_DAYS;
        }
        return DAYS_OF_MONTH[month];
    }

    private static int[] getDaysOfMonthArr() {
        final int MONTH_COUNT = 13;
        final int JANUARY = 1;
        final int MARCH = 3;
        final int APRIL = 4;
        final int MAY = 5;
        final int JUNE = 6;
        final int JULY = 7;
        final int AUGUST = 8;
        final int SEPTEMBER = 9;
        final int OCTOBER = 10;
        final int NOVEMBER = 11;
        final int DECEMBER = 12;

        final int JANUARY_DAYS = 31;
        final int FEBRUARY_DAYS = 28;
        final int MARCH_DAYS = 31;
        final int APRIL_DAYS = 30;
        final int MAY_DAYS = 31;
        final int JUNE_DAYS = 30;
        final int JULY_DAYS = 31;
        final int AUGUST_DAYS = 31;
        final int SEPTEMBER_DAYS = 30;
        final int OCTOBER_DAYS = 31;
        final int NOVEMBER_DAYS = 30;
        final int DECEMBER_DAYS = 31;

        int[] days = new int[MONTH_COUNT];
        days[JANUARY] = JANUARY_DAYS;
        days[FEBRUARY] = FEBRUARY_DAYS;
        days[MARCH] = MARCH_DAYS;
        days[APRIL] = APRIL_DAYS;
        days[MAY] = MAY_DAYS;
        days[JUNE] = JUNE_DAYS;
        days[JULY] = JULY_DAYS;
        days[AUGUST] = AUGUST_DAYS;
        days[SEPTEMBER] = SEPTEMBER_DAYS;
        days[OCTOBER] = OCTOBER_DAYS;
        days[NOVEMBER] = NOVEMBER_DAYS;
        days[DECEMBER] = DECEMBER_DAYS;
        return days;
    }

    public String dayOfTheWeek_magic(int day, int month, int year) {
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int iWeek = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100
                + year / 400) % 7;//基姆拉尔森计算公式
        String result[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return result[iWeek];
    }
}
