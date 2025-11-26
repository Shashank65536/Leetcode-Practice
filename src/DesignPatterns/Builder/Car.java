package DesignPatterns.Builder;

public class Car {

    private final int engineCC;
    private final int price;

    //optional variable
    private int modelYear;

    private Car(CarBuilder builder){
        this.engineCC = builder.cc;
        this.price = builder.price;
        this.modelYear = builder.modelYear;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public int getPrice() {
        return price;
    }

    public int getModelYear() {
        return modelYear;
    }

    public static class CarBuilder{

        private final int cc;
        private final int price;
        private int modelYear;

        public void setModelyear(int year){
            this.modelYear = year;
        }
        public CarBuilder(int price, int cc){
            this.cc = cc;
            this.price = price;
        }

        public Car build(){
            return new Car(this);
        }


    }



}
/*Example of builder pattern*/
/*The Builder Pattern is particularly useful in cases like the Pizza example because it addresses several issues that arise when dealing with objects that have multiple configuration options*/
/*package DesignPatterns.Builder;

public class Pizza {

    // Required parameters
    private final String size;
    private final String crustType;

    // Optional parameters
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;
    private boolean olives;

    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.crustType = builder.crustType;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.olives = builder.olives;
    }

    public String getSize() {
        return size;
    }

    public String getCrustType() {
        return crustType;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasPepperoni() {
        return pepperoni;
    }

    public boolean hasMushrooms() {
        return mushrooms;
    }

    public boolean hasOlives() {
        return olives;
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", crustType=" + crustType + ", cheese=" + cheese +
               ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms + ", olives=" + olives + "]";
    }

    public static class PizzaBuilder {

        // Required parameters
        private final String size;
        private final String crustType;

        // Optional parameters - initialized to default values
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean mushrooms = false;
        private boolean olives = false;

        public PizzaBuilder(String size, String crustType) {
            this.size = size;
            this.crustType = crustType;
        }

        public PizzaBuilder addCheese() {
            this.cheese = true;
            return this;
        }

        public PizzaBuilder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public PizzaBuilder addMushrooms() {
            this.mushrooms = true;
            return this;
        }

        public PizzaBuilder addOlives() {
            this.olives = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

public class TestBuilder {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder("Large", "Thin Crust")
                               .addCheese()
                               .addPepperoni()
                               .addMushrooms()
                               .build();

        System.out.println(pizza);
    }
}

*/
/*Why would we need builder design pattern*/

/*. Avoiding Constructor Overload and Telescoping Constructors
Without the Builder Pattern, you would need multiple constructors to handle each possible combination of pizza configurations. For example:*/

/*public Pizza(String size, String crustType);
public Pizza(String size, String crustType, boolean cheese);
public Pizza(String size, String crustType, boolean cheese, boolean pepperoni);
public Pizza(String size, String crustType, boolean cheese, boolean pepperoni, boolean mushrooms);
*/

/*This is much easier to read and understand than setting multiple parameters in a constructor. Each method clearly indicates what is being set, so developers know exactly which options the Pizza will have.
This flexibility also makes the code easier to maintain and extend, as adding a new topping option is as simple as adding a new method in the PizzaBuilder.
3. Optional Parameters Without Setters in the Main Cl*/

/*Pizza pizza = new Pizza.PizzaBuilder("Large", "Thin Crust")
                       .addCheese()
                       .addPepperoni()
                       .addMushrooms()
                       .build();
*/
