package main;

//Creates coffee
public class Coffee{
    //Instance variables
    protected int ML_WATER_REQUIRED;
    protected int ML_MILK_REQUIRED;
    protected int G_BEANS_REQUIRED;
    protected int COST;

    //Assigns instance variables based on the type of coffee
    public Coffee(String type){
        if(type.equalsIgnoreCase("Espresso")){
            ML_WATER_REQUIRED = 250;
            ML_MILK_REQUIRED = 0;
            G_BEANS_REQUIRED = 16;
            COST = 4;
        }else if(type.equalsIgnoreCase("Latte")){
            ML_WATER_REQUIRED = 350;
            ML_MILK_REQUIRED = 75;
            G_BEANS_REQUIRED = 20;
            COST = 7;
        }else if(type.equalsIgnoreCase("Cappuccino")) {
            ML_WATER_REQUIRED = 200;
            ML_MILK_REQUIRED = 100;
            G_BEANS_REQUIRED = 12;
            COST = 6;
        }
    }

    //Will print true if there are enough resources for a cup of coffee, otherwise false
    public boolean hasResources(CoffeeMachine c){
        boolean r = true;

        if(c.getWater() < this.ML_WATER_REQUIRED){
            System.out.println("Sorry, not enough water!\n");
            r = false;
        }

        if(c.getMilk() < this.ML_MILK_REQUIRED){
            System.out.println("Sorry, not enough milk!\n");
            r = false;
        }

        if(c.getBeans() < this.G_BEANS_REQUIRED){
            System.out.println("Sorry, not enough beans!\n");
            r = false;
        }

        if(c.getCups() < 1){
            System.out.println("Sorry, not enough cups!\n");
            r = false;
        }

        return r;
    }

    //Will make a cup of coffee by removing the appropriate amount of resources that the cup requires
    public void makeCup(CoffeeMachine c){
        c.addWater(-ML_WATER_REQUIRED);
        c.addMilk(-ML_MILK_REQUIRED);
        c.addBeans(-G_BEANS_REQUIRED);
        c.addCups(-1);
        c.addMoney(COST);
    }
}
