package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployService {

	@Autowired
	private final EmployeeRepository employeeRepository;

	public List<Employee> findById(List<String> idList) {
		return this.employeeRepository.findAll(idList);
	}

	public List<Employee> maintainEmployee(List<Employee> employeeList) {

		employeeList.forEach(item -> {
			this.employeeRepository.saveAndFlush(item);
		});

		return employeeList;
	}
}
