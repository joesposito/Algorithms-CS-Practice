package main;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Class for creating instances of different coffee machines that support three types of coffee
public class CoffeeMachine {
    //Initialize/Assign instance variables
    private Scanner scanner = new Scanner(System.in);
    private boolean isActive = true;
    private int mlWater;
    private int mlMilk;
    private int gBeans;
    private int numCups;
    private int money;

    //Put supported coffee types here
    Espresso espresso = new Espresso();
    Latte latte = new Latte();
    Cappuccino cappuccino = new Cappuccino();

    //CoffeeMachine constructor, takes in values describing resources of the machine
    public CoffeeMachine(int mlWater, int mlMilk, int gBeans, int numCups, int money){
        this.mlWater = mlWater;
        this.mlMilk = mlMilk;
        this.gBeans = gBeans;
        this.numCups = numCups;
        this.money = money;
    }

    //This method will run the machine unless a fatal error occurs or the user instructs
    //the machine to stop running
    public void runMachine(){
        do{
            //Print starting menu
            System.out.println("Write action (buy, fill, take, remaining, exit): ");

            //Obtain valid input for starting menu options
            String input = getInput();
            while(!input.equals("buy") && !input.equals("fill") && !input.equals("take")
                    && !input.equals("remaining") && !input.equals("exit")){
                System.out.println("Please enter valid input: ");
                input = getInput();
            }

            //Pass input to a seperate method that will handle the options
            actionHandler(input);
        }while(isActive);
    }

    //Handles the five key functionalities of the coffee machine
    public void actionHandler(String str){
        switch(str) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                isActive = false;
                exit();
                break;
            default:
                isActive = false;
                System.out.println("Switch Statement Error");
                System.exit(0);
        }
    }

    //Allows user to purchase a coffee
    public void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");

        //User must either go back to main menu or select a valid coffee type
        String input = "0";
        int numInput = 0;
        while(!input.equals("back")){
            try{
                numInput = Integer.parseInt(input);
                if(numInput == 1 || numInput == 2 || numInput == 3){
                    break;
                }
            }catch(NumberFormatException e){
                System.out.println("Please enter valid input: ");
            }

            input = getInput();
        }

        //If a valid type is selected, we need to check if the resources to make that coffee
        //type are available before we make it
        switch(numInput){
            case 1:
                if(espresso.hasResources(this)){
                    espresso.makeCup(this);
                    System.out.println("I have enough resources, making you a coffee!\n");
                }
                break;
            case 2:
                if(latte.hasResources(this)){
                    latte.makeCup(this);
                    System.out.println("I have enough resources, making you a coffee!\n");
                }
                break;
            case 3:
                if(cappuccino.hasResources(this)){
                    cappuccino.makeCup(this);
                    System.out.println("I have enough resources, making you a coffee!\n");
                }
                break;
            default:
                return;
        }
    }

    //Will allow the user to add resources to the machine
    public void fill(){
        System.out.println("Write how many ml of water you want to add: ");
        this.addWater(getFillInput());
        System.out.println("Write how many ml of milk you want to add: ");
        this.addMilk(getFillInput());
        System.out.println("Write how many grams of coffee you want to add: ");
        this.addBeans(getFillInput());
        System.out.println("Write how many disposable cups you want to add: ");
        this.addCups(getFillInput());
    }

    //Will allow the user to take the money from the machine
    public void take(){
        System.out.println("I gave you $" + money + "\n");
        addMoney(-money);
    }

    //Will print the remaining resources of the machine
    public void remaining(){
        printState();
        System.out.println();
    }

    //Will allow the user to exit the program
    public void exit(){
        System.out.println("Exiting...");
        System.exit(0);
    }

    //A method for obtaining valid string input
    public String getInput(){
        String str = "";
        try{
            str += scanner.next();
        }catch(NoSuchElementException e){
            System.out.println("End of input.");
            System.exit(0);
        }

        return str;
    }

    //A method for obtaining valid non-negative integers for the Fill() method
    public int getFillInput(){
        int numInput = -1;
        while(numInput < 0){
            try{
                numInput = Integer.parseInt(getInput());
            }catch(NumberFormatException e){
                System.out.println("Enter a valid number: ");
            }catch(NoSuchElementException e){
                System.out.println("End of input.");
                System.exit(0);
            }
        }
        return numInput;
    }

    //Getter methods
    public int getWater(){
        return mlWater;
    }

    public int getMilk(){
        return mlMilk;
    }

    public int getBeans(){
        return gBeans;
    }

    public int getCups(){
        return numCups;
    }

    public int getMoney(){
        return money;
    }

    //Setters
    //Note: If the parameter is negative, we subtract from the resources
    public void addWater(int water){
        mlWater += water;
    }

    public void addMilk(int milk){
        mlMilk += milk;
    }

    public void addBeans(int beans){
        gBeans += beans;
    }

    public void addCups(int cups){
        numCups += cups;
    }

    public void addMoney(int money){
        this.money += money;
    }

    //Prints the resources of the coffee machine
    public void printState(){
        System.out.println("The coffee machine has: ");
        System.out.println(this.mlWater + " ml of water");
        System.out.println(this.mlMilk + " ml of milk");
        System.out.println(this.gBeans + " g of coffee beans");
        System.out.println(this.numCups + " disposable cups");
        System.out.println("$" + this.money + " of money");
    }
}
