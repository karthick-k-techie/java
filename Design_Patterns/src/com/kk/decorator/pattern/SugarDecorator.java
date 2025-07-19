package com.kk.decorator.pattern;

public class SugarDecorator extends CoffeeDecorator {

	public SugarDecorator(ICoffee iCoffee) {
		super(iCoffee);
	}
	
	@Override
	public String getDescription() {
		return iCoffee.getDescription() + ", Sugar";
	}

	@Override
	public double getCost() {
		return iCoffee.getCost() + 0.5; // adding sugar cost = 0.5
	}

}
