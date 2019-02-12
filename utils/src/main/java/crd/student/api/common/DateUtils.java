package crd.student.api.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 返回需要的日期形式
     * </p>
     * 如：style=“yyyy年MM月dd日 HH时mm分ss秒SSS毫秒”。 返回“xxxx年xx月xx日xx时xx分xx秒xxx毫秒”
     * </p>
     *
     * @param date
     * @param style
     * @return
     */
    public static String getNeededDateStyle(Date date, String style) {
        if (date == null) {
            date = new Date();
        }
        if (style == null) {
            style = "yyyy年MM月dd日";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(style);
        return sdf.format(date);
    }
}
