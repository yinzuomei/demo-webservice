package com.yinzuomei.demowebservice.test;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yinzuomei
 * @Date: 2019/10/17 13:44
 * @Description:
 */
public class Test {

	private static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {
		Date firstDate=getFirstDayDateOfMonth(new Date());
		System.out.println(dateFormat.format(firstDate));
		Date lastDate=getLastDayOfMonth(new Date());
		System.out.println(dateFormat.format(lastDate));
	}

	public static void testDate() {
		try {
			String m = getLastMonth("2019-01");
			System.out.println("上个月：" + m);
			List<String> monthList = getDateList("month", "2019-09");
			System.out.println("按月统计：");
			for (String month : monthList) {
				System.out.println(month);
			}
			List<String> yearList = getDateList("year", "2019");
			System.out.println("按年统计：");
			for (String year : yearList) {
				System.out.println(year);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param type year||month
	 * @param date year:yyyy month:yyyy-MM
	 * @return java.util.List<java.lang.String>
	 * @Author yinzuomei
	 * @Description 获取某月的所有日期，或者某年的所有月
	 * @Date 2020/1/15 14:15
	 **/
	private static List<String> getDateList(String type, String date) throws ParseException {
		List<String> dateList = new ArrayList<>();
		try {
			if ("month".equals(type)) {
				int totalDays = getDayOfMonth(date);
				System.out.println("totalDays=" + totalDays);
				dateList = getDaysBetween(date + "-01", date + "-" + totalDays);
			} else if ("year".equals(type)) {
				dateList = getMonthBetween(date + "-01", date + "-12");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateList;
	}

	/**
	 * @param dateStr yyyy-MM
	 * @return int
	 * @Author yinzuomei
	 * @Description 某月有多少天
	 * @Date 2020/1/15 14:15
	 **/
	public static int getDayOfMonth(String dateStr) {
		int year = Integer.parseInt(dateStr.substring(0, 4));
		int month = Integer.parseInt(dateStr.substring(5, 7));
		Calendar c = Calendar.getInstance();
		c.set(year, month, 0); //输入类型为int类型
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * @param minDate
	 * @param maxDate
	 * @return java.util.List<java.lang.String>
	 * @Author yinzuomei
	 * @Description 获取两个日期之间所有的月份
	 * @Date 2020/1/15 14:17
	 **/
	public static List<String> getMonthBetween(String minDate, String maxDate) {
		ArrayList<String> result = new ArrayList<String>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

			Calendar min = Calendar.getInstance();
			Calendar max = Calendar.getInstance();

			min.setTime(sdf.parse(minDate));
			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

			max.setTime(sdf.parse(maxDate));
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

			Calendar curr = min;
			while (curr.before(max)) {
				result.add(sdf.format(curr.getTime()));
				curr.add(Calendar.MONTH, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param startTime
	 * @param endTime
	 * @return java.util.List<java.lang.String>
	 * @Author yinzuomei
	 * @Description 两日期之间的日期
	 * @Date 2020/1/15 14:04
	 **/
	public static List<String> getDaysBetween(String startTime, String endTime) {
		// 返回的日期集合
		List<String> days = new ArrayList<String>();
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date start = dateFormat.parse(startTime);
			Date end = dateFormat.parse(endTime);

			Calendar tempStart = Calendar.getInstance();
			tempStart.setTime(start);

			Calendar tempEnd = Calendar.getInstance();
			tempEnd.setTime(end);
			tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
			while (tempStart.before(tempEnd)) {
				days.add(dateFormat.format(tempStart.getTime()));
				tempStart.add(Calendar.DAY_OF_YEAR, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return days;
	}

	/**
	 * @param dateStr
	 * @return java.lang.String
	 * @Author yinzuomei
	 * @Description 获取上个月
	 * @Date 2020/1/15 13:59
	 **/
	public static String getLastMonth(String dateStr) {
		String accDate = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(format.parse(dateStr)); // 设置为当前时间
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
			Date lastMonth = calendar.getTime();
			accDate = format.format(lastMonth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accDate;
	}

	/**
	 * @param handleTime
	 * @param queueCount
	 * @return void
	 * @Author yinzuomei
	 * @Description 除法测试
	 * @Date 2020/1/15 13:58
	 **/
	public static void divisionTest(Long handleTime, Integer queueCount) {
		DecimalFormat df = new DecimalFormat("0.00");
		Double result = handleTime / (double) queueCount;
		System.out.println(result);//1046.317073170731
		Double minResult = Double.valueOf(df.format(result / 60));
		System.out.println(minResult);
	}

	/**
	 * @param dateStr
	 * @return void
	 * @Author yinzuomei
	 * @Description 测试cron表达式
	 * @Date 2020/1/15 13:49
	 **/
	public static void cronTest(String dateStr) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(dateStr);
			String cron = "";
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DATE);
			int hours = calendar.get(Calendar.HOUR_OF_DAY);
			int minutes = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			cron = second + " " + minutes + " " + hours + " " + day + " " + month + " ? " + year + "-" + year;
			System.out.println("cron表达式=" + cron);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param str
	 * @return void
	 * @Author yinzuomei
	 * @Description 测试switch用法
	 * @Date 2020/1/15 13:47
	 **/
	public static void switchTest(String str) {
		switch (str) {
			case "1":
				System.out.println("str=1");
				break;
			case "2":
			case "3":
			case "4":
				System.out.println("str=2||3||4");
				break;
			case "5":
				System.out.println("str=5");
		}
	}

	/**
	 * @return java.util.Date
	 * @param date
	 * @Author yinzuomei
	 * @Description 获取传入日期所在月的第一天
	 * @Date 2020/1/15 14:21
	 **/
	public static Date  getFirstDayDateOfMonth(final Date date) {

		final Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);

		cal.set(Calendar.DAY_OF_MONTH, last);

		return cal.getTime();

	}

	/**
	 * @return java.util.Date
	 * @param date
	 * @Author yinzuomei
	 * @Description 获取传入日期所在月的最后一天
	 * @Date 2020/1/15 14:22
	 **/
	public static Date getLastDayOfMonth(final Date date) {

		final Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		cal.set(Calendar.DAY_OF_MONTH, last);

		return cal.getTime();

	}

}
