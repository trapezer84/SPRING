package com.ktds.leina.mongo.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class MongoTest {

	private MongoTemplate mongoTemplate;

	public MongoTest() {
		String mongoContextPath = "/mongoContext.xml";
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(mongoContextPath);

		mongoTemplate = (MongoTemplate) ctx.getBean("mongoTemplate");
	}

	public static void main(String[] args) {
		MongoTest mongoTest = new MongoTest();
		System.out.println(mongoTest.mongoTemplate);

		MongoTestVO mongoTestVO = new MongoTestVO();
		String key = "name";
		String value = "둘리";

		// insert**
		// mongoTest.insertTestData();
//		mongoTest.insertAllTestData();

		// mongoTestVO.setName("둘리");
		// mongoTestVO.setAddress("고길동집");
		// this.insertTestData(mongoTestVO);
		// this.insertTestData(mongoTestVO);

		// Update**
//		mongoTestVO.setName("도우너");
//		mongoTestVO.setAddress("깐따삐야");
//		mongoTest.updateData(key, value, mongoTestVO);

//		 mongoTestVO.setName("마이콜");
//		 mongoTestVO.setAddress("후루룩 짭짭 후루룩 짭짭 맛좋은 라면 ~");
//		 mongoTest.updateDataOne("name", "도우너", mongoTestVO);

		// remove**
//		 mongoTest.removeAllData();
		// mongoTest.removeData(key, value);

		// find** 
//		 mongoTest.findDataOne(key, "마이콜");
		mongoTest.findData(key, "마이콜");

	}

	/**
	 * insert Data
	 */
	private void insertTestData() {
		MongoTestVO testVO = new MongoTestVO();
		testVO.setName("둘리");
		testVO.setAddress("고길동 집 1억년전 어딘가...2");

		mongoTemplate.insert(testVO);
		// mongoTemplate.insert(testVO, "person");

	}

	/**
	 * insert All Data
	 */
	private void insertAllTestData() {
		List<MongoTestVO> testVOList = new ArrayList<MongoTestVO>();
		MongoTestVO testVO = null;

		for (int i = 0; i < 10000; i++) {
			testVO = new MongoTestVO();
			testVO.setName("둘리");
			testVO.setAddress("고길동 집 " + i + "번지");
			testVOList.add(testVO);
		}

		mongoTemplate.insertAll(testVOList);
	}

	/**
	 * remove All Data
	 */
	private void removeAllData() {
		// 전체 삭제
		mongoTemplate.remove(new Query(), "person");

	}

	/**
	 * remove 특정 Data
	 */
	private void removeData(String key, String value) {
		Criteria criteria = new Criteria(key);
		criteria.is(value);

		// criteria = criteria.and("address");
		// criteria.is("지구");

		Query query = new Query(criteria);
		mongoTemplate.remove(query, "person");
	}

	/**
	 * update 모든 Data
	 */
	public void updateData(String key, String value, MongoTestVO mongoTestVO) {
		Criteria criteria = new Criteria(key);
		criteria.is(value);
		Query query = new Query(criteria);

		Update update = new Update();
		update.set("name", mongoTestVO.getName());
		update.set("address", mongoTestVO.getAddress());

		mongoTemplate.updateMulti(query, update, "person");
	}

	/**
	 * update 특정 Data
	 */
	private void updateDataOne(String key, String value, MongoTestVO mongoTestVO) {
		Criteria criteria = new Criteria(key);
		criteria.is(value);

		Query query = new Query(criteria);

		Update update = new Update();
		// update.set("name", "마이클");
		// update.set("address", "후루룩 후루룩 짭짭");
		update.set("name", mongoTestVO.getName());
		update.set("address", mongoTestVO.getAddress());

		mongoTemplate.updateFirst(query, update, "person");
	}

	/**
	 * find 특정 One Data
	 */
	private void findDataOne(String key, String value) {
		// findOne인 경우
		Criteria criteria = new Criteria(key);
		criteria.is(value);

		// query : 검색 조건 , MongoTestVO : 리턴 타입 , person : 검색할 컬렉션
		Query query = new Query(criteria);
		MongoTestVO mongoTestVO = mongoTemplate.findOne(query, MongoTestVO.class, "person");
		System.out.println("ID : " + mongoTestVO.getId());
		System.out.println("Name : " + mongoTestVO.getName());
		System.out.println("Address : " + mongoTestVO.getAddress());
	}

	/**
	 * find All Data
	 */
	private void findData(String key, String value) {
		Criteria criteria = new Criteria(key);

		// 해당 value에 맞는 것만 찾을 수 있다.
		// criteria.is(value);

		// 둘리로 시작하는 것을 찾을 수 있다.
		criteria.regex("^둘리");

		Query query = new Query(criteria);
		List<MongoTestVO> data = mongoTemplate.find(query, MongoTestVO.class, "person");

		for (MongoTestVO mongoTestVO : data) {
			System.out.println(mongoTestVO.getName());
			System.out.println(mongoTestVO.getAddress());
			System.out.println(mongoTestVO.getId());
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
