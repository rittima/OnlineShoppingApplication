package com.shopping.app.repository;


import org.springframework.stereotype.Repository;
import com.shopping.app.exception.SequenceException;

@Repository
public interface SequenceDao{
	long getNextSequenceId(String key) throws SequenceException;
}
