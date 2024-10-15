package src.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Date;


public class DateUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Chuyển từ chuỗi sang LocalDate.
     *
     * @param dateString chuỗi ngày theo định dạng yyyy-MM-dd
     * @return LocalDate
     */
    public static LocalDate stringToDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDate.parse(dateString, formatter);
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

    /**
     * Chuyển đổi LocalDateTime thành Date.
     *
     * @param localDateTime đối tượng LocalDateTime cần chuyển đổi
     * @return đối tượng Date tương ứng
     */
    public static Date convertToDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}