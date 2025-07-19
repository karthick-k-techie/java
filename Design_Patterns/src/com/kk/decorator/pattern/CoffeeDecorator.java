package com.kk.decorator.pattern;

public class CoffeeDecorator implements ICoffee {

	protected ICoffee iCoffee;

	public CoffeeDecorator(ICoffee iCoffee) {
		this.iCoffee=iCoffee;
	}

	@Override
	public String getDescription() {
		return iCoffee.getDescription();
	}

	@Override
	public double getCost() {
		return iCoffee.getCost();
	}

}
