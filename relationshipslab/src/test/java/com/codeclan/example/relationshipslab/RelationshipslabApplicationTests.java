package com.codeclan.example.relationshipslab;

import com.codeclan.example.relationshipslab.models.Department;
import com.codeclan.example.relationshipslab.models.Employee;
import com.codeclan.example.relationshipslab.models.Project;
import com.codeclan.example.relationshipslab.repositories.DepartmentRepository;
import com.codeclan.example.relationshipslab.repositories.EmployeeRepository;
import com.codeclan.example.relationshipslab.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RelationshipslabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartmentAndProject() {
		Department department = new Department("Assasination");
		departmentRepository.save(department);

		Employee employee = new Employee("John", "Wick", department );
		employeeRepository.save(employee);


		Project project = new Project("Kill Bad Guy", 3);
		projectRepository.save(project);
		project.addEmployee(employee);
		projectRepository.save(project);
	}

}
