package cn.itcast.multi.thread.utils;

/**
 * ClassName: ExceptionUtils  
 * (异常工具类)
 * @author zhangtian  
 * @version
 */
public class ExceptionUtils {
	
	public static String getFullStackTrace(Throwable t) {
		return t.getMessage() ;
	}
}
