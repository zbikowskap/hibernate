package org.example.learning;

public class Laptop {
    private Keyboard keyboard;

    public Laptop(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public static void main(String[] args) {
        Laptop logitech = new Laptop(new Keyboard("Logitech"));
        Laptop hp = new Laptop(new Keyboard("hp"));
    }
}
