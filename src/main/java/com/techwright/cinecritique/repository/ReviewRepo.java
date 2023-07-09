package com.techwright.cinecritique.repository;

import com.techwright.cinecritique.pojo.Reviews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends MongoRepository<Reviews, ObjectId> {
}
