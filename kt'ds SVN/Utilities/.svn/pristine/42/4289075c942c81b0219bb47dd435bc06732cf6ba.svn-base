package kr.co.hucloud.utilities.excel.option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Minchang Jang (mc.jang@hucloud.co.kr)
 *
 */
public class WriteOption {

	private String filePath;
	private String fileName;
	private String sheetName;
	private List<String> titles;
	private List<String[]> contents;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public List<String> getTitles() {
		
		List<String> temp = new ArrayList<String>();
		temp.addAll(this.titles);
		
		return temp;
	}
	public void setTitles(List<String> titles) {
		
		List<String> temp = new ArrayList<String>();
		temp.addAll(titles);
		
		this.titles = temp;
	}
	public void setTitles(String ... titles) {
		List<String> temp = Arrays.asList(titles);
		this.titles = temp;
	}
	public List<String[]> getContents() {
		
		List<String[]> temp = new ArrayList<String[]>();
		temp.addAll(this.contents);
		
		return temp;
	}
	public void setContents(List<String[]> contents) {
		List<String[]> temp = new ArrayList<String[]>();
		temp.addAll(contents);
		
		this.contents = temp;
	}
	public void setContents(String ... contents) {
		List<String[]> temp = new ArrayList<String[]>();
		temp.add(contents);
		
		if ( this.contents == null ) {
			this.contents = new ArrayList<String[]>();
		}
		
		this.contents.addAll(temp);
	}
	
}
