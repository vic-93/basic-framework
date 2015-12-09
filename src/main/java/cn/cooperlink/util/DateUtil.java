/* **************************************************************
 *
 * 文件名称：DateUtil.java
 *
 * 包含类名：com.cloudpower.util.DateUtil
 * 创建日期：2013-7-19
 * 创建作者：潘云峰
 * 版权声明：Copyright 2013 北京酷博灵科信息科技有限公司 保留所有权利。
 *
 * **************************************************************/
package cn.cooperlink.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理工具类。
 * <p>处理日期</p>
 * 
 * 创建日期：2013-7-19
 * 创建作者：潘云峰
 */
public class DateUtil {

	private static final SimpleDateFormat SIMPLE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private static final SimpleDateFormat FULL_FORMAR = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 通用日期格式化方法，将日期格式化为yyyy-MM-dd形式。
	 * 例：1900-01-01
	 * @param date
	 * @return 格式化后的日期字符串。
	 */
	public static String toSimpleFormat(Date date) {
		return SIMPLE_FORMAT.format(date);
	}
	
	/**
	 * 通用日期格式化方法，将给定时间毫秒值格式化为yyyy-MM-dd形式。
	 * 例：1900-01-01
	 * @param date
	 * @return 格式化后的日期字符串。
	 */
	public static String toSimpleFormat(long timeMillis) {
		Timestamp ts = new Timestamp(timeMillis);
		return SIMPLE_FORMAT.format(ts);
	}
	
	/**
	 * 通用时间格式化方法，将日期格式化为yyyy-MM-dd hh:mm:ss形式。
	 * 例：1900-01-01 13:00:00
	 * @param date
	 * @return 格式化后的时间字符串。
	 */
	public static String toFullTimeFormat(Date date) {
		return FULL_FORMAR.format(date);
	}
	
	/**
	 * 通用时间格式化方法，将给定时间毫秒值格式化为yyyy-MM-dd hh:mm:ss形式。
	 * 例：1900-01-01 13:00:00
	 * @param date
	 * @return 格式化后的时间字符串。
	 */
	public static String toFullTimeFormat(long timeMillis) {
		Timestamp ts = new Timestamp(timeMillis);
		return FULL_FORMAR.format(ts);
	}
	
	/**
	 * 将Date按指定格式进行格式化处理。
	 * @param date
	 * @param format
	 * @return 格式化后的date字符串。
	 */
	public static String format(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 将 yyyy-MM-dd格式转换为java.util.Date 日期对象
	 *
	 * @param dateValue
	 * @param defaultVal
	 * @return
	 */
	public static Date parse4SimpleFormat(String dateValue, Date defaultVal) {
		try {
			return SIMPLE_FORMAT.parse(dateValue);
		} catch (ParseException e) {
			return defaultVal;
		}
	}
	
	/**
	 * 将yyyy-MM-dd HH:mm:ss 格式转换为java.util.Date 日期对象
	 *
	 * @param source
	 * @param defaultVal
	 * @return
	 */
	public static Date parse4FullFormat(String dateValue, Date defaultVal) {
		try {
			return FULL_FORMAR.parse(dateValue);
		} catch (ParseException e) {
			return defaultVal;
		}
	}
	
	/**
	 * 计算某天处于一年中的第几周
	 * 一周起始为星期一，截止为星期日。
	 * @param date 天
	 * @return 周数 最小返回1（第一周）
	 */
	public static int weekOfYear(Calendar date) {
		Calendar firstDayOfFirstWeekOnyear = 
				firstDayOfFirstWeekOnyear(date.get(Calendar.YEAR));
		// 本年度第一周起始时间 大于 要计算的天，则将该天归入上一年度最后一周
		if (firstDayOfFirstWeekOnyear.getTimeInMillis() > date.getTimeInMillis()) {
			firstDayOfFirstWeekOnyear = 
					firstDayOfFirstWeekOnyear(date.get(Calendar.YEAR) - 1);
		}
	    long diff = date.getTimeInMillis() 
	    		- firstDayOfFirstWeekOnyear.getTimeInMillis();
	    int d = (int) (diff / 86400000) + 1;
	    return (int) Math.ceil((double)d / 7);
	}
	
	private static Calendar firstDayOfFirstWeekOnyear(int year) {
		Timestamp firstDayOfYear = Timestamp.valueOf(year + "-01-01 00:00:00");
		Calendar firstDayOfFirstWeek = Calendar.getInstance();
		firstDayOfFirstWeek.setTime(firstDayOfYear);
		int diffD = 0; // 每年的 1月1号 与星期一的便宜，如果1月1日就是星期一，则本年起始周为本周，否则以下周一为第一周起始
		switch (firstDayOfFirstWeek.get(Calendar.DAY_OF_WEEK)) {
			case 1 : // 周天 编译一天 到周一
				diffD = 1;
				break;
			case 2 : // 周一 一年的第一周
				diffD = 0;
				break;
			case 3 : // 周二  编译 4天 到下周一
				diffD = 6;
				break;
			case 4 :
				diffD = 5;
				break;
			case 5 :
				diffD = 4;
				break;
			case 6 :
				diffD = 3;
				break;
			case 7 :
				diffD = 2;
				break;
		}
		firstDayOfFirstWeek.setTimeInMillis(firstDayOfFirstWeek.getTimeInMillis() 
				+ diffD * 24 * 60 * 60 * 1000);
		return firstDayOfFirstWeek;
	}
	
	/**
	 * 计算某天处于一年中的第几周
	 * @param year 	年
	 * @param month 月   1-12
	 * @param day 	日   1-31
	 * @return 周数 最小返回1（第一周）
	 */
	public static int weekOfYear(int year, int month, int day) {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, year);
		date.set(Calendar.MONTH, month - 1);
		date.set(Calendar.DAY_OF_MONTH, day);
		return weekOfYear(date);
	}
	
	/**
	 * 计算某天处于一年中的第几周
	 * @param date 要计算的日期
	 * @return 周数 最小返回1（第一周）
	 */
	public static int weekOfYear(Date date) {
		Calendar d = Calendar.getInstance();
		d.setTime(date);
		return weekOfYear(d);
	}
	
	/**
	 * 计算某天处于一年中的第几周
	 * @param millis 时期的毫秒值
	 * @return 周数 最小返回1（第一周）
	 */
	public static int weekOfYear(long millis) {
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(millis);
		return weekOfYear(date);
	}
	
	/**
	 * 根据年和周数，计算出给定年指定周的第一天日期（仅精确到天，小时后不准确）
	 * 周一 ~ 周日 为一周。
	 * @param year 年
	 * @param week 周 1 - 53
	 * @return 某年第n周的 第一天。
	 */
	public static Date firstDayOfWeek(int year, int week) {
		Calendar firstDayOfFirstWeekOnyear = 
				firstDayOfFirstWeekOnyear(year);
		long diff = (long) (week - 1) * 7 * 86400000;
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(diff + firstDayOfFirstWeekOnyear.getTimeInMillis());
		return date.getTime();
	}
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println(sdf.format(getDaysByWeek(2013, 34)));
		// 11  - 17                             2013-01-01 00:00:00
		//Timestamp firstDay = Timestamp.valueOf("2014-01-06 12:00:00");
		//System.out.println(DateUtil.weekOfYear(firstDay));
		System.out.println(sdf.format(firstDayOfWeek(2013,52)));
	}
}
