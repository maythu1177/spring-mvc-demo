package com.sp.tech.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sp.tech.model.Article;
import com.sp.tech.repo.ArticleRepo;

@Controller
public class ArticleController {

	 @Autowired
	 private ArticleRepo articleRepo;
	 
	 @GetMapping("/")
	 public String getArticle(Model model) {
		 model.addAttribute("articles", articleRepo.findAll());
		 model.addAttribute("newArticle",new Article());
		 return "index";
	 }
	 
	 @PostMapping("/save-article")
	 public String saveArticle(@ModelAttribute Article article) {
		 articleRepo.save(article);
		 return "redirect:/";
	 }
	 
	 @PostMapping("/delete-article")
	 public String deleteArticle(@PathParam("id") int id) {
		 articleRepo.deleteById(id);
		 return "redirect:/";
	 }
}
