package com.aj.DataJpaJpaRepositoryApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aj.DataJpaJpaRepositoryApp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	//Pagination And Sorting
	//findAll()
	//findAll(Sort sort)
	//findAll(Pageable pageable)
	
}
