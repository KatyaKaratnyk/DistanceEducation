package ua.karatnyk.service;

import java.util.List;

import org.springframework.data.domain.Page;

import ua.karatnyk.domain.NewsTitleFilter;
import ua.karatnyk.entity.News;

public interface NewsService {
	
	List<News> findAllNewsNotDeleted();
	
	void saveNews(News news);
	
	News findById(int id);
	
	Page<News> getPagebleNews(int pageNumber, int pageSize, String sort, String sortByField);
	
	Page<News> getPagebleNewsWithTitleFilter(int pageNumber, int pageSize, String sort, String sortByField, String titleFilter);
	
	Page<News> getPagebleNewsWithTitleFilter(int pageNumber, int pageSize, String sort, String sortByField, NewsTitleFilter titleFilter);
	
	void deleteNewsById(int id);
	
	

}
