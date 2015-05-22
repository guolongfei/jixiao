package com.hoyotech.prison.util;

import org.apache.log4j.Logger;

public class StringHelper {
	private static Logger logger = Logger.getLogger(StringHelper.class);

	public StringHelper() {

	}

	/**
	 * 字符串的长度是否大于0
	 * @param str
	 * @return
	 */
	public static boolean hasLength(String str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * 判断字符串是否为null 或者 空白
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input){
		return (input == null || "".equals(input.trim()));
	}

	/**
	 * xml保留字符轉義
	 *
	 * @param s
	 * @return
	 */
	public static String tranXMLChars(String s) {
		return s.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
				">", "&gt;").replaceAll("'", "&apos;").replaceAll("\"",
				"&quot;");
	}

	public static String convertFromXMLChars(String s) {
		return s.replaceAll("&amp;", "&").replaceAll("&lt;", "<").replaceAll(
				"&gt;", ">").replaceAll("&apos;", "'").replaceAll("&quot;",
				"\"");
	}

	/**
	 * input的value轉義,（xml保留字符除'轉義)
	 * @param s
	 * @return
	 */
	public static String tranVALUEChars(String s) {
		return s.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
				">", "&gt;").replaceAll("\"", "&quot;");
	}

	/**
	 * 处理Oracle 的转义字符，使like 查询可以正确匹配
	 * ' ——> ''
	 * & ——> '||char(38)||'	（10g中ms 不用转义）
	 * % ——> \% 'escape'\
	 * _ ——> \_ 'escape'\
	 *
	 */
	public static String transformLikeSql(String s) {

		boolean isContain = false;
		String result = (s == null) ? "" : s;
		if (result.indexOf("%") != -1) {
			isContain = true;
		} else if (result.indexOf("_") != -1) {
			isContain = true;
		}
		result = result.replaceAll("'", "''");
		if (!isContain) {
			return "%" + result + "%";
		}

		result = "%" + result.replaceAll("%", "\\\\%").replaceAll("_", "\\\\_")
				+ "%";
		result += "'escape'\\";
		return result;
	}

	/**
	 * 处理普通的sql，解决条件中'的问题，用于非like SQL条件 的拼装
	 * @param s
	 * @return
	 */
	public static String transformSql(String s) {
		String result = (s == null) ? "" : s;
		return result.replaceAll("'", "''");
	}
	
	/**
	 * html标签属性中引号转义，防止读取时遇引号截断
	 * @param s
	 * @return
	 */
	public static String tranSafeAttribute(String s) {
		String result = (s == null) ? "" : s;
		return result.replaceAll("\"","&#34").replaceAll("'","&#39");
	}
	
	public static String convertLongArrayIdToString(long[] longArray){
		String result = "";
		for(long input : longArray){
			result += input+ ",";
		}
		if(result.length() == 0){
			return result;
		}else{
			return result.substring(0,result.length()-1);
		}
	}

	public static String convertStringArrayIdToString(String[] strArray){
		String result = "";
		for(String input : strArray){
			result += input+ ",";
		}
		return result;
	}

	public static String joinStringArray(Object[] strArray, String joinStr) {
		String result = "";
		for(Object str : strArray) {
			result += str.toString() + joinStr;
		}
		return result;
	}
	/**
	 * 截断字符串
	 * 如果字符串长度小于需要长度，则返回字符串本身
	 * @param src
	 * @param length
	 * @param suffix
	 * @return
	 */
	public static String truncate(String src, int length, String suffix){
		if(src == null)
			return src;
		src = src.trim();
		if(src.length() <= length)
			return src;
		return src.substring(0, length) + suffix;
	}

	/**
	 * 对html中符号进行转义
	 * @param s
	 * @param replacement
	 * @return
	 */
	public static String escapeHtmlNotation(String s, String replacement){
		return s.replaceAll("<.+?>", replacement);
	}
	public static String shortenURI(String uri){
		return StringHelper.shortenURI(uri, 30, 10);
	}
	public static String shortenURI(String uri,int totalLength,int subfixLength){
		int urlLength = uri.length();
		String subfix = urlLength<totalLength?"":(" ... "+uri.substring(urlLength-subfixLength, urlLength));
		return "".equals(subfix)?uri:(uri.substring(0,totalLength - subfixLength) + subfix);
	}

	/**
	 * 判断当前数组中是否存在传递过来的字符串
	 * @param data 数组
	 * @param str 字符串
	 * @return
	 */
	public static boolean isExistStr(String [] data,String str){
		boolean flag = false;
		if(data != null){
			for(String element : data ){
				if(element.equals(str)){
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public String convertArray(String data[]){
		String str = "";
		if(data != null){
			for(String element : data){
				str += (str.length()==0?"":",")+element;
			}
		}
		return str;
	}
	
	/**
	 * 翻页起止
	 * @param pageNo
	 * @param totalPage
	 * @param maxLen
	 * @return
	 */
	public static int[] getPager(int pageNo, int totalPage, int maxLen) {
		int startPos = 1, endPos = 1;
		int midPos = (maxLen%2 == 0) ? maxLen/2 : maxLen/2+1;
		if(totalPage <= maxLen) {
			endPos = totalPage;
		} else {
			if(pageNo <= midPos) {
				endPos = maxLen;
			} else {
				startPos = (pageNo - midPos +1) > (totalPage - maxLen) ? (totalPage - maxLen + 1) : (pageNo - midPos +1);
				endPos = (pageNo + midPos) > totalPage ? totalPage : (pageNo + midPos - 1);
			}
		}
		return new int[]{startPos, endPos};
	}
	
	public static void main(String[] args) {
		StringHelper  service = new StringHelper();
		String [] data = new String[]{"aaaaaa","bbbb","cccccc","d"};
//		System.out.println(service.isExistStr(data, "dddd"));
//		convertArray
	}
}
