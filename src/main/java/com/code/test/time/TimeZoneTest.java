package com.code.test.time;


import com.code.utils.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @date 2019/10/29下午9:55
 */
public class TimeZoneTest {

    public static void main(String[] args) {

        Date date = new Date();
        Locale locale = Locale.CHINA;
        DateFormat shortDf = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);
        shortDf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));//Asia/Chongqing
        System.out.println(TimeZone.getDefault().getID());
        System.out.println("中国当前日期时间：" + shortDf.format(date));

        locale = Locale.ENGLISH;
        shortDf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
        shortDf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println("英国当前日期时间：" + shortDf.format(date));

        TimeZone timeZone = TimeZone.getTimeZone("CCT");
        System.out.println(true);
    }

    /**
     * UTC时间是1970-01-01 00:00:00时，北京时间是1970-01-01 08:00:00
     *
     * @throws ParseException
     */
    public static void t() throws ParseException {
        //UTC时间是1970-01-01 00:00:00
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")));
        Date date = dateFormat.parse("1970-01-01 00:00:00");
        System.out.println(date.getTime());

        //UTC时间是1970-01-01 00:00:00时，北京时间是1970-01-01 08:00:00
        dateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC+8")));
        date = dateFormat.parse("1970-01-01 00:00:00");
        System.out.println(DateUtils.getNewFormatDateString(date));

        //0
        //1970-01-01 08:00:00
    }

    /**
     * 将字符串表示的时间转换成另一个时区的时间字符串
     */
    public static void getTimeStrByAnothorTimeStrAndTimeZone() throws ParseException {
        String timeStr = "2017-8-24 11:17:10"; // 字面时间
        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = bjSdf.parse(timeStr);  // 将字符串时间按北京时间解析成Date对象

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));  // 设置东京时区
        System.out.println("北京时间: " + timeStr + "对应的东京时间为:" + tokyoSdf.format(date));
    }

    /**
     * 将一个时间字符串按不同时区来解释，得到的Date对象的值是不同的
     *
     * @throws ParseException
     */
    public static void getTimeByTimeZoneAndDate() throws ParseException {
        String timeStr = "2017-8-24 11:17:10"; // 字面时间
        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date bjDate = bjSdf.parse(timeStr);  // 解析
        System.out.println("字面时间: " + timeStr + ",按北京时间来解释:" + bjSdf.format(bjDate) + ", " + bjDate.getTime());

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));  // 设置东京时区
        Date tokyoDate = tokyoSdf.parse(timeStr); // 解析
        System.out.println("字面时间: " + timeStr + ",按东京时间来解释:" + tokyoSdf.format(tokyoDate) + ", " + tokyoDate.getTime());
    }

    /**
     * 根据时区和时间字符串获取毫秒数
     */
    public static void getMillSecondsByTimeStrAndTimeZone() {
        Date date = new Date(1503544630000L);  // 对应的北京时间是2017-08-24 11:17:10

        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // 北京
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));  // 设置北京时区

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));  // 设置东京时区

        SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 伦敦
        londonSdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));  // 设置伦敦时区

        System.out.println("毫秒数:" + date.getTime() + ", 北京时间:" + bjSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 东京时间:" + tokyoSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 伦敦时间:" + londonSdf.format(date));

        // 毫秒数:1503544630000, 北京时间:2017-08-24 11:17:10
        // 毫秒数:1503544630000, 东京时间:2017-08-24 12:17:10
        // 毫秒数:1503544630000, 伦敦时间:2017-08-24 04:17:10
    }

    /**
     * 根据毫秒数和时区获取当地时间
     */
    public static void getTimeByMillSecondsAndTimeZone() {
        Date date = new Date(1503544630000L);  // 对应的北京时间是2017-08-24 11:17:10

        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // 北京
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));  // 设置北京时区

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));  // 设置东京时区

        SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 伦敦
        londonSdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));  // 设置伦敦时区

        System.out.println("毫秒数:" + date.getTime() + ", 北京时间:" + bjSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 东京时间:" + tokyoSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 伦敦时间:" + londonSdf.format(date));

        // 毫秒数:1503544630000, 北京时间:2017-08-24 11:17:10
        // 毫秒数:1503544630000, 东京时间:2017-08-24 12:17:10
        // 毫秒数:1503544630000, 伦敦时间:2017-08-24 04:17:10
    }

    public static void java8print() {
        //Java 8将给定的时间和时区转换为UTC时间 http://www.cocoachina.com/cms/wap.php?action=article&id=69276
        ZoneId australia = ZoneId.of("Australia/Sydney");
        String str = "2015-01-05 17:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localtDateAndTime = LocalDateTime.parse(str, formatter);

        ZonedDateTime dateAndTimeInSydney = ZonedDateTime.of(localtDateAndTime, australia);
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInSydney);

        ZonedDateTime utcDate = dateAndTimeInSydney.withZoneSameInstant(ZoneOffset.UTC);
        System.out.println("Current date and time in UTC : " + utcDate);
    }
}
