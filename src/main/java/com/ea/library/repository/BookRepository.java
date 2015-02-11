package com.ea.library.repository;


import org.springframework.data.mongodb.repository.MongoRepository;


import org.springframework.stereotype.Repository;

import com.ea.library.model.db.DBBook;

@Repository
public interface BookRepository extends MongoRepository<DBBook, String> {

    

}
