package ua.karatnyk.controller;

import java.io.IOException;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.karatnyk.constants.Constants;
import ua.karatnyk.domain.NewsRequest;
import ua.karatnyk.entity.News;
import ua.karatnyk.mapper.NewsMapper;
import ua.karatnyk.service.NewsService;
import ua.karatnyk.service.UserService;
import ua.karatnyk.service.utilities.FileManager;

@Controller
@RequestMapping("/director")
@SessionAttributes({"newsEditModel"})
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private UserService userService;
	
	private String titleFilter = new String();
	
	@GetMapping("/news/{pageNumber}")
	public String showNewsTablePage(Model model, @PathVariable("pageNumber") int pageNumber) {
		
		Page<News> page = newsService.getPagebleNews(pageNumber, 5, "DESC", "createdAt");
		if(!this.titleFilter.isEmpty() && this.titleFilter != null) {
			page = newsService.getPagebleNewsWithTitleFilter(pageNumber, 5, "DESC", "createdAt", this.titleFilter);
		} 
		int currentPage = page.getNumber()+1;
		int begin = Math.max(1, currentPage-1);
		int end = Math.min(begin+10, page.getNumber());
		
		model.addAttribute("newsList", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("newsListByPageSize", NewsMapper.newsToNewsRequest(page.getContent()));
	
		return "director/news/view_news";
	}
	
	@PostMapping("/search/news") 
	public String makeFilter(@RequestParam("titleFilter") String titleFilter) {
		this.titleFilter = titleFilter;
		return "redirect:/director/news/1";
	}
	@PostMapping("/remove_filter/news") 
	public String removeFilter() {
		this.titleFilter = "";
		return "redirect:/director/news/1";
	}
	
	@GetMapping("/add_news")
	public String showAddNewsPage(Model model) {
		
		model.addAttribute("newsRequestModel", new NewsRequest());	
		return "director/news/add_news";
	}
	
	@PostMapping("/add_news")
	public String addNewsPage(@ModelAttribute("newsRequestModel") @Valid NewsRequest newsRequest, 
			BindingResult result, Principal principal) throws IOException  {
		
		if(result.hasErrors()) {
			return "director/news/add_news";
		}
		
		News news = NewsMapper.newsRequestToNewsEntity(newsRequest);
		news.setUserEntity(userService.findByLogin(principal.getName()));
		newsService.saveNews(news);
		FileManager.saveImageInProject(newsRequest.getFile(), Constants.FOLDER_FOR_NEWS_IMAGES);
		return "redirect:/director/news/1";
	}
	
	@GetMapping("/profile/news{newsId}")
	public String showNewsProfilePage(Model model, @PathVariable("newsId") String newsId) {
		News news = newsService.findById(Integer.parseInt(newsId));
		NewsRequest newsRequest = NewsMapper.newsToNewsRequest(news);	
		model.addAttribute("newsModel", newsRequest);
		return "director/news/profile_news";
	}
	
	@GetMapping("/edit/news{newsId}")
	public String showEditNewsPage(Model model, @PathVariable("newsId") int newsId) {
		News news = newsService.findById(newsId);
		NewsRequest request = NewsMapper.newsToNewsRequest(news); 	
		model.addAttribute("newsEditModel", request);
		return "director/news/edit_news";
	}
	
	@PostMapping("/edit/news{newsId}")
	public String editNewsPage(@ModelAttribute("newsEditModel") @Valid NewsRequest request,
			BindingResult result) throws IOException{
		if(result.hasErrors()) {
			return "director/news/edit_news";
		}
		News news = NewsMapper.newsRequestToNewsEntity(request);
		newsService.saveNews(news);
		
		return "redirect:/director/profile/news"+request.getId();
	}
	
	@GetMapping("/remove/news{newsId}") 
	public String removeNewsIs(@PathVariable("newsId") String newsId) {
		//FileManager.deleteFileFromProject(newsService.findById(Integer.parseInt(newsId)).getPathToFoto());
		newsService.deleteNewsById(Integer.parseInt(newsId));
		return "redirect:/director/news/1";
	}

}
