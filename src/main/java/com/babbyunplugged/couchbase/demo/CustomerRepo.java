package com.babbyunplugged.couchbase.demo;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import com.babbyunplugged.couchbase.demo.model.Customer;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "customer",viewName = "all")
public interface CustomerRepo extends CouchbaseRepository<Customer, Integer>{

}
