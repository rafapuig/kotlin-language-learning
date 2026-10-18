package poo.delegation;

import static poo.delegation.Beverages.*;

interface Beverage {
    double getCost();
    String getDescription();

    default void printInfo() {
        IO.println("Un " + getDescription() + " cuesta " + getCost());
    }
}

class Decaf implements Beverage {
    @Override
    public double getCost() {
        return 2.0;
    }

    @Override
    public String getDescription() {
        return "Cafe descafeinado";
    }
}

class Beverages {

    public static final Beverage Espresso = new Beverage() {
        @Override
        public double getCost() {
            return 3.0;
        }

        @Override
        public String getDescription() {
            return "Café Expreso";
        }
    };

    public static final Beverage LongCoffee = new Beverage() {
        @Override
        public double getCost() {
            return 3.5;
        }
        @Override
        public String getDescription() {
            return "Café largo";
        }
    };

}

/* Condiments */

class Milk implements Beverage {

    private final Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 1.0;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " con leche";
    }
}

class Chocolate implements Beverage {

    private final Beverage beverage;

    public Chocolate(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " con chocolate";
    }
}

abstract class Condiment implements Beverage {

    private final Beverage beverage;

    public Condiment(Beverage beverage) {
        this.beverage = beverage;
    }

    protected String name;

    @Override
    public double getCost() {
        return beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " con " + name;
    }
}

class Whip extends Condiment {

    public Whip(Beverage beverage) {
        super(beverage);
        super.name = "nata";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }
}


class Demo {

    static void main(String[] args) {

        Beverage milkedDecaf = new Milk(new Decaf());
        milkedDecaf.printInfo();

        Beverage chocolatedEspreso = new Chocolate(Espresso);
        chocolatedEspreso.printInfo();

        Beverage milkedChocolatedLongCoffee = new Chocolate(new Milk(LongCoffee));
        milkedChocolatedLongCoffee.printInfo();

        Beverage whippedEspresso = new Whip(Espresso);
        whippedEspresso.printInfo();

        Beverage doubleWhippedEspresso = new Whip(new Whip(Espresso));
        doubleWhippedEspresso.printInfo();
    }
}




