package com.kk.decorator.pattern;

public class DecoratorExample1 {

	// https://www.youtube.com/watch?v=1XVslZ33Hgo

	/*
	 * The Decorator Design Pattern is a structural design pattern that allow to add
	 * functionality to a object at runtime. At the same time, other object of the
	 * same class will not be affected.
	 * 
	 * In other words, the decorator pattern allows you to add or remove behavior
	 * from an object at runtime by wrapping it in one or more decorator objects.
	 */

	public static void main(String[] args) {

		// Simple Coffee:
		ICoffee iCoffee = new SimpleCoffee();
		System.out.println(iCoffee.getDescription() + " $" + iCoffee.getCost());

		// add extra milk:
		iCoffee = new MilkiDecorator(iCoffee);
		System.out.println(iCoffee.getDescription() + " $" + iCoffee.getCost());

		// add extra Sugar
		iCoffee = new SugarDecorator(iCoffee);
		System.out.println(iCoffee.getDescription() + " $" + iCoffee.getCost());

		// add cream Sugar
		iCoffee = new CreamDecorator(iCoffee);
		System.out.println(iCoffee.getDescription() + " $" + iCoffee.getCost());

		System.out.println("Final Cost: $" + iCoffee.getCost());

	}

}
