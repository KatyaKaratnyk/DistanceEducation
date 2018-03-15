package ua.karatnyk.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.karatnyk.constants.Constants;
import ua.karatnyk.domain.NewsRequest;
import ua.karatnyk.entity.News;
import ua.karatnyk.service.utilities.FileManager;

public interface NewsMapper {
	
	public static News newsRequestToNewsEntity(NewsRequest request) throws IOException {
		News news = new News();
		news.setDescription(request.getDescription());
		news.setTitle(request.getTitle());
		news.setId(request.getId());
		news.setUserEntity(request.getUserEntity());
		if(!request.getFile().isEmpty()) {
			news.setPathToFoto(FileManager.pathToImageInProject(request.getFile(), Constants.FOLDER_FOR_NEWS_IMAGES));
			FileManager.saveImageInProject(request.getFile(), Constants.FOLDER_FOR_NEWS_IMAGES);
		}
		else {
			news.setPathToFoto(request.getPathToImage());
		}
		return news;
	}
	
	public static List<NewsRequest> newsToNewsRequest(List<News> listNews) {
		List<NewsRequest> newsRequests = new ArrayList<>();
		for(News n: listNews) {
			NewsRequest newsRequest = new NewsRequest();
			newsRequest.setId(n.getId());
			newsRequest.setDescription(n.getDescription());
			newsRequest.setTitle(n.getTitle());
			if(n.getUserEntity() != null)
				newsRequest.setUserEntity(n.getUserEntity());
			if(n.getPathToFoto() != null)
				newsRequest.setEncodedFileToByte(FileManager.encodedFileToByteFromProject(n.getPathToFoto()));
			newsRequests.add(newsRequest);
		}
		return newsRequests;
	}
	public static NewsRequest newsToNewsRequest(News news) {
		NewsRequest newsRequest = new NewsRequest();
		newsRequest.setId(news.getId());
		newsRequest.setDescription(news.getDescription());
		newsRequest.setTitle(news.getTitle());
		newsRequest.setPathToImage(news.getPathToFoto());
		newsRequest.setEncodedFileToByte(FileManager.encodedFileToByteFromProject(news.getPathToFoto()));
		if(news.getUserEntity() != null)
			newsRequest.setUserEntity(news.getUserEntity());
		return newsRequest;
	}
}
