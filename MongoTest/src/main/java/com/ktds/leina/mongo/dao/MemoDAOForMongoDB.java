package com.ktds.leina.mongo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.mongo.util.Paging;
import com.ktds.leina.mongo.vo.MemoSearchVO;

public class MemoDAOForMongoDB implements MemoDAO {

	private MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void insertMemo(String memo) {
		Map<String, String> memoMap = new HashMap<String, String>();
		memoMap.put("memo", memo);

		mongoTemplate.insert(memoMap, "memo");
	}

	@Override
	public void updateMemo(String id, String memo) {
		Criteria criteria = new Criteria("_id");
		criteria.is(id);

		Query query = new Query(criteria);

		Update update = new Update();
		update.set("memo", memo);

		mongoTemplate.updateMulti(query, update, "memo");
	}

	@Override
	public void removeMemo(String id) {
		Criteria criteria = new Criteria("_id");
		criteria.is(id);

		Query query = new Query(criteria);
		mongoTemplate.remove(query, "memo");
	}

	@Override
	public ModelAndView getMemoList(MemoSearchVO memoSearchVO) {
		
		if(memoSearchVO == null) {
			memoSearchVO = new MemoSearchVO();
			memoSearchVO.setPageNo(0);
		}
		
		Paging paging = new Paging(false);
		paging.setPageNumber(memoSearchVO.getPageNo() + "");
		
		Criteria criteria = new Criteria("memo");
		Query query = new Query();
		criteria.regex("^" + memoSearchVO.getSearchKeyword());

		// 검색 X
		if (memoSearchVO.getSearchKeyword() == null) {
		} else {
			query = new Query(criteria);
		}


		int count = (int) mongoTemplate.count(query, "memo");
		paging.setTotalArticleCount(count);
		
		// 검색 O
		MatchOperation match = Aggregation.match(criteria);
		
		// 건너띄기
		SkipOperation skip = Aggregation.skip(paging.getStartArticleNumber());
		
		// 정렬하기
		SortOperation sort = Aggregation.sort(Sort.Direction.DESC, "_id");
		
		// 지정한 수 만큼 가져오기
		LimitOperation limit = Aggregation.limit(paging.getEndArticleNumber());

		Aggregation aggregation = Aggregation.newAggregation(match, sort, skip, limit);

		AggregationResults<Map> result = mongoTemplate.aggregate(aggregation, "memo", Map.class);
		List<Map> memoList = result.getMappedResults();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("list");
		view.addObject("memoList", memoList);
		view.addObject("paging", paging);
		view.addObject("memoSearchVO", memoSearchVO);
		
		
		return view;
	}

	@Override
	public Map getMemo(String id) {
		Criteria criteria = new Criteria("_id");
		criteria.is(id);

		Query query = new Query(criteria);

		return mongoTemplate.findOne(query, Map.class, "memo");
	}

}
