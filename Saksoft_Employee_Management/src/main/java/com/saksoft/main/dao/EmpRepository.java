package com.saksoft.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saksoft.main.model.Employee;

@Repository
public interface EmpRepository extends CrudRepository<Employee, Long>
{


}
