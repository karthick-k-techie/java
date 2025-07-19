package com.kk.decorator.pattern;

public class CreamDecorator extends CoffeeDecorator {

	public CreamDecorator(ICoffee iCoffee) {
		super(iCoffee);
	}

	@Override
	public String getDescription() {
		return iCoffee.getDescription() + ", Cream";
	}

	@Override
	public double getCost() {
		return iCoffee.getCost() + 3.5; // adding cream cost = 3.5
	}
}
