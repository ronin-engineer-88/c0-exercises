package src.untils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Chuyển từ chuỗi sang Date.
     *
     * @param date chuỗi ngày theo định dạng yyyy-MM-dd
     * @return Date
     */
    public static Date stringToDate(String date) {
        if (date == null || date.trim().isEmpty()) return null;

        SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
            return null;
        }
    }

    public static String formatDate(Date date) {
        if (date == null) return null;

        SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
        return formatter.format(date);
    }


    /**
     * Chuyển từ LocalDate sang chuỗi theo định dạng yyyy-MM-dd.
     *
     * @param date LocalDate
     * @return chuỗi ngày theo định dạng yyyy-MM-dd
     */
    public static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return date.format(formatter);
    }

    /**
     * Chuyển từ chuỗi sang LocalDateTime.
     *
     * @param dateTimeString chuỗi ngày và giờ theo định dạng yyyy-MM-dd HH:mm:ss
     * @return LocalDateTime
     */
    public static LocalDateTime stringToDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    /**
     * Chuyển từ LocalDateTime sang chuỗi theo định dạng yyyy-MM-dd HH:mm:ss.
     *
     * @param dateTime LocalDateTime
     * @return chuỗi ngày và giờ theo định dạng yyyy-MM-dd HH:mm:ss
     */
    public static String dateTimeToString(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        return dateTime.format(formatter);
    }

    /**
     * Tính khoảng cách giữa hai LocalDate theo ngày.
     *
     * @param startDate ngày bắt đầu
     * @param endDate   ngày kết thúc
     * @return số ngày giữa hai ngày
     */
    public static long daysBetween(LocalDate startDate, LocalDate endDate) {
       return endDate.toEpochDay() - startDate.toEpochDay();
    }

    /**
     * Lấy ngày hiện tại dưới dạng LocalDate.
     *
     * @return LocalDate của ngày hiện tại
     */
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    /**
     * Lấy ngày giờ hiện tại dưới dạng LocalDateTime.
     *
     * @return LocalDateTime của ngày giờ hiện tại
     */
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * Kiểm tra xem một năm có phải năm nhuận hay không.
     *
     * @param year năm cần kiểm tra
     * @return true nếu là năm nhuận, ngược lại false
     */
    public static boolean isLeapYear(int year) {
        return LocalDate.of(year, 1, 1).isLeapYear();
    }

    /**
     * Thêm số ngày vào một LocalDate.
     *
     * @param date LocalDate ban đầu
     * @param days số ngày cần thêm
     * @return LocalDate sau khi thêm số ngày
     */
    public static LocalDate addDays(LocalDate date, long days) {
        return date.plusDays(days);
    }

    /**
     * Trừ số ngày từ một LocalDate.
     *
     * @param date LocalDate ban đầu
     * @param days số ngày cần trừ
     * @return LocalDate sau khi trừ số ngày
     */
    public static LocalDate subtractDays(LocalDate date, long days) {
        return date.minusDays(days);
    }
}