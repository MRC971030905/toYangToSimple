package com.byxy.util;

import java.io.UnsupportedEncodingException;

public class Conversion {

	/**
	 * UrlEncode编码
	 * 
	 * @param str
	 *            内容
	 * @return
	 */
	public static String UrlEncode(String str) {
		try {
			str = str.replace("+", "%2B");
			str = str.replace("%2B", "+");
			return java.net.URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/** 
	 * UrlDecode解码
	 * 
	 * @param str
	 *            内容
	 * @return
	 */
	public static String UrlDecode(String str) {
		try {
			str = str.replace("+", "%2B");
			return java.net.URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 中文 转换 Unicode
	 * 
	 * @param str
	 * @return
	 */
	public static String chineseToUnicode(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			int chr1 = (char) str.charAt(i);
			if (chr1 >= 913 && chr1 <= 65509) {// 汉字范围 \u0391-\uffe5 (中文)
				result += "\\u" + Integer.toHexString(chr1);
			} else {
				result += str.charAt(i);
			}
		}

		result = result.replace("¥", "\\u00a5");
		result = result.replace("·", "\\u00b7");
		return result;
	}

	/**
	 * Unicode 转换 中文
	 * 
	 * @param Unicode
	 *            Unicode内容
	 * @return
	 */
	public static String unicodeToChinese(String unicode) {
		char aChar;
		int len = unicode.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = unicode.charAt(x++);
			if (aChar == '\\') {
				aChar = unicode.charAt(x++);
				if (aChar == 'u') {
					// 阅读XXX
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = unicode.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException("格式错误的 \\uxxxx 编码。");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);

		}
		return outBuffer.toString();
	}
}
