package db_union.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 接受一个日期
	 * 时间格式化yyyy-MM-dd
	 * 返回时间减少一年
	 */
	public static String yearless(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date resultDate = new Date();
		try {
			Date daystart = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(daystart);
			calendar.add(Calendar.YEAR, -1); // 年份减1  
			resultDate = calendar.getTime(); // 结果  
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sdf.format(resultDate);  
	}
	
	/**
	 * 接受一个日期
	 * 接收一个格式化好时间yyyy-MM-dd
	 * 时间增加一个月
	 */
	public static String monthadd(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date resultDate = new Date();
		try {
			Date daystart = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(daystart);
			calendar.add(Calendar.MONTH, 1); // 年份减1  
			resultDate = calendar.getTime(); // 结果  
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sdf.format(resultDate);  
	}
}