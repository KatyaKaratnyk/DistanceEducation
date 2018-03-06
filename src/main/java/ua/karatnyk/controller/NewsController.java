package ua.karatnyk.controller;

import java.io.IOException;

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
import org.springframework.web.multipart.MultipartFile;

import ua.karatnyk.entity.News;
import ua.karatnyk.service.NewsService;
import ua.karatnyk.service.utilities.FileManager;

@Controller
@RequestMapping("/admin")
@SessionAttributes({"newsEditModel", "newsId"})
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	private String titleFilter = new String();
	
	@GetMapping("/news/{pageNumber}")
	public String showNewsAdminPage(Model model, @PathVariable("pageNumber") int pageNumber) {
		
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
		for(News n: page.getContent()) {
			n.setPathToFoto(FileManager.encodedFileToByteFromProject(n.getPathToFoto()));
		}
		model.addAttribute("newsListByPageSize", page.getContent());
	
		return "admin/news/view_news";
	}
	
	@PostMapping("/news/search") 
	public String makeFilter(@RequestParam("titleFilter") String titleFilter) {
		this.titleFilter = titleFilter;
		return "redirect:/admin/news/1";
	}
	@PostMapping("/news/remove_filter") 
	public String removeFilter() {
		this.titleFilter = "";
		return "redirect:/admin/news/1";
	}
	
	@GetMapping("/addNews")
	public String showAddNewsPage(Model model) {
		
		model.addAttribute("newsModel", new News());	
		return "admin/news/add_news";
	}
	
	@PostMapping("/addNews")
	public String addNewsPage(@ModelAttribute("newsModel") @Valid News news, BindingResult result, @RequestParam("uploadFile") MultipartFile file) throws IOException {
		
		if(result.hasErrors()) {
			return "admin/news/add_news";
		}
		
		FileManager.saveImageInProject(file, "newsPhoto");
		news.setPathToFoto(FileManager.pathToImageInProject(file, "newsPhoto"));
		newsService.saveNews(news);
		return "redirect:/admin/news/1";
	}
	
	@GetMapping("/profile/news{newsId}")
	public String showNewsPage(Model model, @PathVariable("newsId") String newsId) {
		News news = newsService.findById(Integer.parseInt(newsId));
		
		model.addAttribute("foto", FileManager.encodedFileToByteFromProject(news.getPathToFoto()));
		model.addAttribute("newsModel", news);
		
		return "admin/news/profile_news";
	}
	
	@GetMapping("/edit/news{newsId}")
	public String showEditNewsPage(Model model, @PathVariable("newsId") String newsId) {
		News news = newsService.findById(Integer.parseInt(newsId));
		model.addAttribute("newsEditModel", news);
		model.addAttribute("newsId", newsId);
		
		return "admin/news/edit_news";
	}
	
	@PostMapping("/edit/news{newsId}")
	public String editNewsPage(@ModelAttribute("newsEditModel") @Valid News news, BindingResult result, @RequestParam("uploadFile") MultipartFile file,
			@ModelAttribute("newsId") String newsId) throws IOException {
		if(result.hasErrors()) {
			return "admin/news/edit_news";
		}
		
		if(news.getPathToFoto() != null && file.isEmpty()) {
			newsService.saveNews(news);
			return "redirect:/admin/profile/news{newsId}";
		}
		
		FileManager.saveImageInProject(file, "newsPhoto");
		news.setPathToFoto(FileManager.pathToImageInProject(file, "newsPhoto"));
		newsService.saveNews(news);
		return "redirect:/admin/profile/news{newsId}";
	}
	
	@GetMapping("/remove/news{newsId}") 
	public String removeNewsIs(@PathVariable("newsId") String newsId) {
		newsService.deleteNewsById(Integer.parseInt(newsId));
		return "redirect:/admin/news/1";
	}

}
