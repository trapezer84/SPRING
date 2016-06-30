package kr.co.hucloud.xquery.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 
 * @author mcjang
 */
public class XqyLoader {

	/**
	 * *.xqy 파일을 로드함.
	 * @param xqyPath
	 * <pre>
	 * src 폴더 아래에서 xqy 파일이 위치한 경로와 xqy 파일명을 확장자를 포함해 작성한다.
	 * 예 > "kr/co/hucloud/xquery/xqy/books.xqy"
	 * </pre>
	 * @return xqy 파일의 Stream
	 */
	public static InputStream loadFromProjectToInputStream(String xqyPath) {
		try {
			return XqyLoader.class.getClassLoader().getResource(xqyPath).openStream();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * *.xqy 파일을 로드함.
	 * @param xqyPath
	 * <pre>
	 * 외부에 위치해 있는 *.xqy 파일을 로드함.
	 * </pre>
	 * @return xqy 파일의 Stream
	 */
	public static InputStream loadFromExternalStorageToInputStream(String xqyPath) {
		try {
			return new FileInputStream(new File(xqyPath));
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * *.xqy 파일을 로드함.
	 * @param xqyPath
	 * <pre>
	 * src 폴더 아래에서 xqy 파일이 위치한 경로와 xqy 파일명을 확장자를 포함해 작성한다.
	 * 예 > "kr/co/hucloud/xquery/xqy/books.xqy"
	 * </pre>
	 * @return xqy 파일의 URL
	 */
	public static URL loadFromProjectToURL(String xqyPath) {
		return XqyLoader.class.getClassLoader().getResource(xqyPath);
	}
	
}
