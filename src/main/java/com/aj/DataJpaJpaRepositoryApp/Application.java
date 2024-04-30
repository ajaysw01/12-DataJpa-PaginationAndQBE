package com.aj.DataJpaJpaRepositoryApp;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort; // Correct import

import com.aj.DataJpaJpaRepositoryApp.entity.Employee;
import com.aj.DataJpaJpaRepositoryApp.repo.EmployeeRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        EmployeeRepository repository = ctx.getBean(EmployeeRepository.class);
        
        //Pagination

        Sort sort = Sort.by(Sort.Direction.DESC, "empName", "empSalary"); // Correct way to create Sort

        int pageNo = 3;
        PageRequest page = PageRequest.of(pageNo - 1, 3, sort); // Pass the sort object here

        Page<Employee> findAll = repository.findAll(page);
        List<Employee> emps = findAll.getContent();

        emps.forEach(System.out::println);
        
        
        //QueryByExample

		Employee emp = new Employee();
		
		
		Example<Employee> exmp = Example.of(emp);
		List<Employee> empList = repository.findAll(exmp);
		
		empList.forEach(System.out::println);
    }
    

}
