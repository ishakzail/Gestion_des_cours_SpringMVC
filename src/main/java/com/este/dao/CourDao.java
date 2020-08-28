package com.este.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.este.models.Cour;

@Repository("courRepository")
public interface CourDao extends CrudRepository<Cour, Integer>{

}
