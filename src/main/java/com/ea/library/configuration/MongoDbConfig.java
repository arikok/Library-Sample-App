package com.ea.library.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
 



import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
 
@Configuration
public class MongoDbConfig {
	
	@Value("${spring.data.mongodb.uri}")
	private String mongoURI;
 
	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		System.out.println(mongoURI);
		
		return new SimpleMongoDbFactory(new MongoClient(new MongoClientURI(mongoURI)), "library");
	}
 
	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
 
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
 
		return mongoTemplate;
 
	}
 
}
