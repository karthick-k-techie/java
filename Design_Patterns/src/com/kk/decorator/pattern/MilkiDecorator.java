package com.kk.decorator.pattern;

public class MilkiDecorator extends CoffeeDecorator{

	public MilkiDecorator(ICoffee iCoffee) {
		super(iCoffee);
	}
	
	@Override
	public String getDescription() {
		return iCoffee.getDescription() + ", Milk";
	}

	@Override
	public double getCost() {
		return iCoffee.getCost() + 1.5; // adding milk cost 1.5
	}

}
