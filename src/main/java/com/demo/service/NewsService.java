package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.News;
import com.demo.repository.NewsRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class NewsService {

	@Autowired
	private final NewsRepository newsRepository;

	public List<News> getNewsList() {
		return new ArrayList<News>();
	}

	public News maintainEntity(News entity) {

		this.newsRepository.save(entity);

		return entity;
	}
}
