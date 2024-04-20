package com.shopping.app.service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.shopping.app.exception.SequenceException;
import com.shopping.app.model.SequenceId;
import com.shopping.app.repository.SequenceDao;
@Repository
public class SequenceDeoImpl implements SequenceDao{
	@Autowired
	private MongoOperations mongoOperations;

@Override
	public long getNextSequenceId(String key) throws SequenceException{
	SequenceId counter = mongoOperations.findAndModify(query(((Criteria) where("_id")).is(key)),
            new Update().inc("seq",1), options().returnNew(true).upsert(true),
            SequenceId.class);
    return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}

}
