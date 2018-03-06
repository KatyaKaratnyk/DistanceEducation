package ua.karatnyk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.karatnyk.entity.News;
import ua.karatnyk.repository.NewsRepository;
import ua.karatnyk.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsRepository newsRepository;

	@Override
	public void saveNews(News news) {
		newsRepository.save(news);
		
	}

	@Override
	public News findById(int id) {
		return newsRepository.findOne(id);
	}

	@Override
	public Page<News> getPagebleNews(int pageNumber, int pageSize, String sort, String sortByField) {
		PageRequest request = new PageRequest(pageNumber-1, pageSize, sort.toUpperCase().equals("ASC")?Sort.Direction.ASC:Sort.Direction.DESC, sortByField);
		return newsRepository.findAllNewsNotActived(request);
	}

	@Override
	public void deleteNewsById(int id) {
		News news = newsRepository.findOne(id);
		news.setDeleted(true);
		newsRepository.save(news);
		
	}

	@Override
	public List<News> findAllNewsNotDeleted() {
		return newsRepository.findAllNewsNotActived();
	}

	@Override
	public Page<News> getPagebleNewsWithTitleFilter(int pageNumber, int pageSize, String sort, String sortByField,
			String titleFilter) {
		PageRequest request = new PageRequest(pageNumber-1, pageSize, sort.toUpperCase().equals("ASC")?Sort.Direction.ASC:Sort.Direction.DESC, sortByField);
		return newsRepository.findAllNewsNotActivedWithTitleFilter(request, titleFilter);
	}

	

	

}
