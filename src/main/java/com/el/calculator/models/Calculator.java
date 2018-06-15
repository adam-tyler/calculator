package com.el.calculator.models;

public class Calculator {

	public String firstNumber;
	public String secondNumber;
	public String operator;
	
	public Calculator(String firstNumber, String secondNumber, String operator) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.operator = operator;
	}
	
	public String calculate() {
		double firstInt;
		double secondInt;
		double result;
		boolean twoNumOp = true;
		
		if (this.firstNumber.length() == 0) {
			this.firstNumber = "0";
		}
		if (this.secondNumber.length() == 0) {
			this.secondNumber = "0";
		}
		
		try {
			firstInt = Double.parseDouble(this.firstNumber);
			secondInt = Double.parseDouble(this.secondNumber);
		} catch (NumberFormatException e) {
			return "Error: unable to parse numbers";
		}
		
		switch (operator) {
		case "+":
			result = firstInt + secondInt;
			break;
		case "-":
			result = firstInt - secondInt;
			break;
		case "*":
			result = firstInt * secondInt;
			break;
		case "/":
			result = firstInt / secondInt;
			break;
		case "^":
			result = Math.pow(firstInt, secondInt);
			break;
		case "root":
			if (secondInt == 0){
	            result = 1;
			} else{
				result = Math.pow(secondInt,(1.0/firstInt));
			}
			break;
		case "log":
			result = (Math.log(secondInt) / Math.log(firstInt));
			break;
		case "sin":
			result = Math.sin(secondInt);
			twoNumOp = false;
			break;
		case "cos":
			result = Math.cos(secondInt);
			twoNumOp = false;
			break;
		case "tan":
			result = Math.tan(secondInt);
			twoNumOp = false;
			break;
		default:
			return "Unknown operator: " + this.operator; 
		}
		
		if (!twoNumOp) {
			return operator + " " + secondNumber + " = " + Double.toString(result);
		}
		return firstNumber + " " + operator + " " + secondNumber + " = " + Double.toString(result);
	}
}
