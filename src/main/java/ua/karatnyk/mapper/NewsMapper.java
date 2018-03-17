package ua.karatnyk.mapper;

import java.util.ArrayList;
import java.util.List;

import ua.karatnyk.domain.NewsAddRequest;
import ua.karatnyk.domain.NewsEditRequest;
import ua.karatnyk.domain.NewsViewRequest;
import ua.karatnyk.entity.News;
import ua.karatnyk.service.utilities.FileManager;

public interface NewsMapper {
	
	public static List<NewsViewRequest> listNewsToListNewsViewRequest(List<News> newsList) {
		
		List<NewsViewRequest> requests = new ArrayList<>();
		
		for(News n: newsList) {
			NewsViewRequest request = NewsMapper.newsToViewRequest(n);
			
			requests.add(request);
		}
		
		return requests;
		
	}
	
	public static News addRequestToNews(NewsAddRequest request) {
		News news = new News();
		news.setDescription(request.getDescription());
		news.setTitle(request.getTitle());
		if(!request.getFile().isEmpty())
			news.setNameFoto(FileManager.nameFile(request.getFile()));
		else 
			news.setNameFoto("noImage.png");
		return news;
	}
	
	public static NewsViewRequest newsToViewRequest(News news) {
		NewsViewRequest request = new NewsViewRequest();
		request.setId(news.getId());
		request.setDescription(news.getDescription());
		request.setTitle(news.getTitle());
		request.setFullNameUser(news.getCreatedByUser().getFirstName()+" "+news.getCreatedByUser().getLastName());
		request.setIdUser(news.getCreatedByUser().getId());
		if(news.getNameFoto().equals("noImage.png")) {
			request.setEncodedToByte(FileManager.encodedFileToByteFromProject(FileManager.pathToDefaultImage("noImage.png")));
		} else
			request.setEncodedToByte(FileManager.encodedFileToByteFromProject(FileManager.fullPathToImage(request.getIdUser(), news.getNameFoto())));
		
		return request;
	}
	
	public static News editNewsRequestToNews(NewsEditRequest request) {
		
		News news = new News();
		news.setId(request.getId());
		news.setTitle(request.getTitle());
		news.setDescription(request.getDescription());
		if(!request.getFile().isEmpty()) {
			news.setNameFoto(FileManager.nameFile(request.getFile()));
		} else {
			news.setNameFoto(request.getNameImage());
		}
		
		return news;
	}
	
	public static NewsEditRequest newsToNewsEditRequest(News news) {
		NewsEditRequest request = new NewsEditRequest();
		request.setDescription(news.getDescription());
		request.setId(news.getId());
		request.setNameImage(news.getNameFoto());
		request.setTitle(news.getTitle());
		request.setUserId(news.getCreatedByUser().getId());
		return request;
	}
}
