package com.assignment.springdata2;

import com.assignment.springdata2.service.ComponentMappingService;
import com.assignment.springdata2.service.JpqlEmployeeService;
import com.assignment.springdata2.service.InterfaceMappingPaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springdata2Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Springdata2Application.class, args);
		//JPQL and SQL
		JpqlEmployeeService EmployeeService = applicationContext.getBean(JpqlEmployeeService.class);
		EmployeeService.findAllBelowAvg();
		EmployeeService.updateBelowAvgEmpSalary(2000);
		EmployeeService.deleteEmployeeMinSalary();
		EmployeeService.getAllEmployeeNameEndsWith();
		EmployeeService.deleteEmployeeAgeGreaterThan(45);

		//InheritanceMapping
		InterfaceMappingPaymentService interfaceMappingPaymentService = applicationContext.getBean(InterfaceMappingPaymentService.class);
		interfaceMappingPaymentService.paymentSingle();
		interfaceMappingPaymentService.paymentJoined();
		interfaceMappingPaymentService.paymentPerClass();

		//ComponentMapping
		ComponentMappingService componentMappingService = applicationContext.getBean(ComponentMappingService.class);
		componentMappingService.createComponentMappedEmployee();

	}
}
