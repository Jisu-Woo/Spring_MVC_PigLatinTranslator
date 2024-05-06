package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	// end point
	@GetMapping(value="/form")
	public String home(Model model) {
		
		
		//return name of the view that will show the data (model)
		return "home";
	}
	
	//Get - 1(Path variable)
	@GetMapping("/{word}")
	public ModelAndView func1(@PathVariable String word) {
		
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("word", word);
		
		String output = pigLatin(word);
		mv.addObject("output", output);
		
		return mv;
	}
	
	//Get - 2(Query parameter)
	@GetMapping(value="/translate")
	public String greeting(@RequestParam(name="word", required=false, defaultValue="default") String word, Model model) {
		
		model.addAttribute("word", word);
		
		String output = pigLatin(word);
		model.addAttribute("output", output);
		
		
		return "hello";
	}
	
	//Post
	@PostMapping(value="/form_input1")
	public ModelAndView input1(String word) {
		
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("word", word);
		
		String output = pigLatin(word);
		mv.addObject("output", output);

		return mv;
	}
	
	//pig latin function
	public String pigLatin(String input) {
		String res = "";

		
		//non-error case

		char c = input.charAt(0);
			//start with vowel
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				
			String add = "hay";
			res = input + add;
		}
			//start with consonant
		else { 
				
			String add = "ay";
			res = input.substring(1) + c + add;
				
		}
		//return String

		
		return res;
	}
}
