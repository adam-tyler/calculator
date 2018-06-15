package com.el.calculator.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.el.calculator.models.Calculator;

@Controller
public class CalculatorController {

	public static ArrayList<String> history = new ArrayList<String>();
	
	@GetMapping("/")
	public ModelAndView getCalculator() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("calculator");
		if (history.size() > 0) {
			mv.addObject("result", history);
		}
		return mv;
	}
	
	@PostMapping("/")
	public ModelAndView postCalculator(String firstNumber, String secondNumber, String operator) {
		ModelAndView mv = new ModelAndView();
		Calculator c = new Calculator(firstNumber, secondNumber, operator);
		String result = c.calculate();
		history.add(0, result);
		mv.addObject("result", history);
		mv.setViewName("calculator");
		return mv;
	}
}
