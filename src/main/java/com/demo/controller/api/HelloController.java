/**
 * 
 */
package com.demo.controller.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.component.constant.ResultStatus;
import com.demo.component.data.ResultObject;
import com.demo.dto.EmployeeDto;
import com.demo.entity.Employee;
import com.demo.service.EmployService;
import com.demo.service.FilesStorageService;

/**
 * @author T21013
 *
 */
@RestController
public class HelloController {
	@Value("${my.profile}")
	private String myProfile;

	@Autowired
	private EmployService employService;

	@Autowired
	private ModelMapper modelmapper;

	@Autowired
	FilesStorageService storageService;

	@GetMapping("hello")
	public ResponseEntity<ResultObject<ArrayList<EmployeeDto>>> hello(@RequestParam Map<String, String> allParams) {
		List<String> idList = (allParams.containsKey("id") && allParams.get("id").isEmpty() ? new ArrayList<String>()
				: Arrays.asList(allParams.get("id").split(",")));

		List<Employee> result = employService.findById(idList);
		ArrayList<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
		result.forEach(item -> {
			employeeDtoList.add(modelmapper.map(item, EmployeeDto.class));
		});

		return new ResponseEntity<>(
				new ResultObject<ArrayList<EmployeeDto>>(ResultStatus.OK, employeeDtoList, ResultStatus.OK.toString()),
				HttpStatus.OK);
	}

	@PutMapping("hello")
	public ResponseEntity<ResultObject<ArrayList<EmployeeDto>>> addHello(@RequestBody EmployeeDto em) {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(modelmapper.map(em, Employee.class));
		List<Employee> result = employService.maintainEmployee(employeeList);

		ArrayList<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
		result.forEach(item -> {
			employeeDtoList.add(modelmapper.map(item, EmployeeDto.class));
		});

		return new ResponseEntity<>(
				new ResultObject<ArrayList<EmployeeDto>>(ResultStatus.OK, employeeDtoList, ResultStatus.OK.toString()),
				HttpStatus.OK);
	}

	@PostMapping("uploadFile")
	public ResponseEntity<ResultObject<String>> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			storageService.save(file);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return new ResponseEntity<>(new ResultObject<String>(ResultStatus.OK, message, ResultStatus.OK.toString()),
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
			return new ResponseEntity<>(
					new ResultObject<String>(ResultStatus.ERROR, e.toString(), ResultStatus.ERROR.toString()),
					HttpStatus.OK);
		}
	}

	@PostMapping(value = "/back/login")
	public String loginCheck(@RequestParam Map<String, String> allParams) {
		System.out.print(allParams);
		return "/back/index";
	}
}
