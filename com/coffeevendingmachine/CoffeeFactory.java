package com.coffeevendingmachine;

public class CoffeeFactory {

    public Coffee createCoffee(CoffeeType type){
        switch(type){
            case ESPRESSO:
                return new Espresso();
            case CAPPUCCINO:
                return new Cappuccino();
            case LATTE:
                return new Latte();
            default:
                throw new IllegalArgumentException("Unknown Coffee Type" + type);
        }
    }
}
