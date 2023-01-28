package com.demo.controller.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.component.constant.ResultStatus;
import com.demo.component.data.ResultObject;

@Controller
public class WebController {

	@RequestMapping(value = "/back/index", method = RequestMethod.GET)
	public String index() {
		return "/index";
	}

	@RequestMapping(value = "/back/login", method = RequestMethod.GET)
	public ResponseEntity<ResultObject<Map<String, String>>> login(Model model) {

		HashMap<String, String> result = new HashMap<String, String>();
		result.put("nextPage", "/login");
		result.put("token", "1qaz2wsx");
		ResultObject<Map<String, String>> resultObj = new ResultObject<Map<String, String>>(ResultStatus.OK, result,
				ResultStatus.OK.toString());

		return new ResponseEntity<ResultObject<Map<String, String>>>(resultObj, HttpStatus.OK);
	}

}
