package com.saral.reporting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.saral.reporting.model.HavingFunctions;
import com.saral.reporting.service.HavingFunctionsService;

@Controller
public class HavingController {

	@Autowired
	HavingFunctionsService havingFunctionsService;

	@RequestMapping(value = "/havingfunctionslist", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("havingfunctionslist");
		List<HavingFunctions> havingList = havingFunctionsService.getAllHavingFunctions();
		model.addObject("havingList", havingList);

		return model;
	}

	@RequestMapping(value = "/addHavingFunction" , method = RequestMethod.GET)
	public String addArticle(ModelMap model) {
		

		HavingFunctions havingFunctions = new HavingFunctions();
		model.put("havingFunctions", havingFunctions);
		
		return "havingfunctionsform";
	}

	@RequestMapping(value = "/updateHavingFunctons", method = RequestMethod.GET)
	public String editArticle(ModelMap model, @RequestParam("id") long id) {

		HavingFunctions havingFunctions = havingFunctionsService.getHavingFunctionsById(id);
		model.put("havingFunctions", havingFunctions);

		return "havingfunctionsform";
	}

	@RequestMapping(value = "/saveHavingFunctons", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("havingFunctions") HavingFunctions havingFunctions) {
		System.out.println("here"+havingFunctions);
		havingFunctionsService.save(havingFunctions);

		return new ModelAndView("redirect:/havingfunctionslist");
	}

	@RequestMapping(value = "/deleteHavingFunctons", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") long id) {
		havingFunctionsService.deleteHavingFunctions(id);

		return new ModelAndView("redirect:/havingfunctionslist");
	}
}