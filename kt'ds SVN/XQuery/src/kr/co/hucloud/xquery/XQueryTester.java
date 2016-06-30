package kr.co.hucloud.xquery;

import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import com.saxonica.xqj.SaxonXQDataSource;

import kr.co.hucloud.xquery.util.XqyLoader;

public class XQueryTester {

	public static void main(String[] args) {
		execute();
	}

	private static void execute() {
		InputStream inputStream = null;

		try {
			inputStream = XqyLoader.loadFromProjectToInputStream("kr/co/hucloud/xquery/xqy/1_books_2.xqy");
			
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQPreparedExpression exp = conn.prepareExpression(inputStream);
			XQResultSequence result = exp.executeQuery();

			while (result.next()) {
				System.out.println(result.getItemAsString(null));
			}
		} catch (XQException e) {
			e.printStackTrace();
		}
		
	}

}
