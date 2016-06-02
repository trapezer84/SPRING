package com.ktds.leina.mongo.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;


public class AggregationTest {

	private MongoTemplate mongoTemplate;

	public AggregationTest() {
		String mongoContextPath = "/mongoContext.xml";
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(mongoContextPath);

		mongoTemplate = (MongoTemplate) ctx.getBean("mongoTemplate");
	}

	public static void main(String[] args) {
		AggregationTest mongoTest = new AggregationTest();
//		mongoTest.findData("name", "둘리");
//		mongoTest.pagingData("name", "둘리", 1);
		mongoTest.groupData();

	}
	
	/**
	 * find One 
	 */
	public void findData(String key, String value) {
		Criteria criteria = new Criteria(key);
		criteria.is(value);
		
		// 검색하기
		MatchOperation match = Aggregation.match(criteria);
		
		// 정렬하기
		SortOperation sort = Aggregation.sort(Sort.Direction.DESC, "_id");
		
		// 건너띄기
		SkipOperation skip = Aggregation.skip(0);
		
		// 지정한 수 만큼 가져오기 
		LimitOperation limit = Aggregation.limit(1);
		
		// Operation들은 Aggregation이라는 곳에 한데 모아 넣어줘야 한다.  
		Aggregation aggregation = Aggregation.newAggregation(match, sort, skip, limit);
		
		// 위의 결과 출력
		AggregationResults<MongoTestVO> result = 
				mongoTemplate.aggregate(aggregation, "person", MongoTestVO.class);
		
		List<MongoTestVO> dataList = result.getMappedResults();
		for (MongoTestVO mongoTestVO : dataList) {
			System.out.println(mongoTestVO.getName());
			System.out.println(mongoTestVO.getAddress());
			System.out.println(mongoTestVO.getId());
		}
	}
	
	/**
	 * 페이징 방법 
	 * 검색 + 정렬 + 건너띄기를 이용하여
	 */
	public void pagingData(String key, String value, int pageNo) {
		Criteria criteria = new Criteria(key);
		criteria.regex(value);
		
		// 검색하기
		MatchOperation match = Aggregation.match(criteria);
		
		// 정렬하기
		SortOperation sort = Aggregation.sort(Sort.Direction.DESC, "_id");
		
		// 건너띄기
		SkipOperation skip = Aggregation.skip( (pageNo-1) * 10 );
		
		// 지정한 수 만큼 가져오기 
		LimitOperation limit = Aggregation.limit(10);
		
		// Operation들은 Aggregation이라는 곳에 한데 모아 넣어줘야 한다.  
		Aggregation aggregation = Aggregation.newAggregation(match, sort, skip, limit);
		
		// 위의 결과 출력
		AggregationResults<MongoTestVO> result = 
				mongoTemplate.aggregate(aggregation, "person", MongoTestVO.class);
		
		List<MongoTestVO> dataList = result.getMappedResults();
		for (MongoTestVO mongoTestVO : dataList) {
			System.out.println(mongoTestVO.getName());
			System.out.println(mongoTestVO.getAddress());
			System.out.println(mongoTestVO.getId());
		}
	}
	
	/**
	 * group
	 */
	private void groupData() {
		Criteria criteria = new Criteria("name");
		criteria.is("도우너");
		MatchOperation match = Aggregation.match(criteria);
		
		// count를 보는 것 
		// count.as() = 카운트 이름의 alia를 붙이는 것 
		GroupOperation group = Aggregation.group("name").count().as("cnt");
		Aggregation aggregation = Aggregation.newAggregation(match, group);
		
		AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, "person", Map.class);
		List<Map> list = results.getMappedResults();
		
		for (Map map : list) {
			System.out.println(map);
		}
		
	}
	
	// 이렇게 적어주면 collection이 자동으로 person과 mapping된다.
	@Document(collection = "person")
	private static class MongoTestVO {

		@Id
		private String id;

		private String name;
		private String address;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

	}
}
