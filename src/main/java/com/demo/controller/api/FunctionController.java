package com.demo.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.component.constant.ResultStatus;
import com.demo.component.data.ResultObject;
import com.demo.dto.NewsDto;
import com.demo.entity.News;
import com.demo.service.NewsService;

@RestController
public class FunctionController {

	@Autowired
	private NewsService newsService;

	@Autowired
	private ModelMapper modelmapper;

	@GetMapping("/api/function-1")
	public ResponseEntity<ResultObject<ArrayList<NewsDto>>> getNews(@RequestParam Map<String, String> allParams) {

		List<News> result = this.newsService.getNewsList();
		ArrayList<NewsDto> newsDtoList = new ArrayList<NewsDto>();
		result.forEach(item -> {
			newsDtoList.add(modelmapper.map(item, NewsDto.class));
		});

		return new ResponseEntity<>(
				new ResultObject<ArrayList<NewsDto>>(ResultStatus.OK, newsDtoList, ResultStatus.OK.toString()),
				HttpStatus.OK);
	}

	@PostMapping("/api/function-1")
	public ResponseEntity<ResultObject<NewsDto>> maintainNews(@RequestBody NewsDto entity) {

		News maintainData = modelmapper.map(entity, News.class);

		News result = this.newsService.maintainEntity(maintainData);

		NewsDto respon = modelmapper.map(result, NewsDto.class);

		return new ResponseEntity<>(new ResultObject<NewsDto>(ResultStatus.OK, respon, ResultStatus.OK.toString()),
				HttpStatus.OK);
	}

	@GetMapping("/api/function-2")
	public ResponseEntity<ResultObject<ArrayList<NewsDto>>> getCompanyNews(
			@RequestParam Map<String, String> allParams) {

		List<News> result = this.newsService.getNewsList();
		ArrayList<NewsDto> newsDtoList = new ArrayList<NewsDto>();
		result.forEach(item -> {
			newsDtoList.add(modelmapper.map(item, NewsDto.class));
		});

		return new ResponseEntity<>(
				new ResultObject<ArrayList<NewsDto>>(ResultStatus.OK, newsDtoList, ResultStatus.OK.toString()),
				HttpStatus.OK);
	}

}
