package main;

public class Main {
    //Demo creates a coffee machine and runs it.
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        coffeeMachine.runMachine();
    }
}
