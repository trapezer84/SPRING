package kr.co.hucloud.xquery;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import com.saxonica.xqj.SaxonXQDataSource;

public class XQueryTester2 {

	public static void main(String[] args) {
		execute();
	}

	private static void execute() {

		try {
			String es = "declare variable $ppp external; doc('src/kr/co/hucloud/xquery/xml/books.xml')/books/book[price>$ppp]";
			
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQPreparedExpression exp = conn.prepareExpression(es);
			exp.bindInt(new QName("ppp"), 30, null);
			XQResultSequence result = exp.executeQuery();

			while (result.next()) {
				System.out.println(result.getItemAsString(null));
			}
		} catch (XQException e) {
			e.printStackTrace();
		}
		
	}

}
