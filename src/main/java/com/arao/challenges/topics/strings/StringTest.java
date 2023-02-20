package com.arao.challenges.topics.strings;

import java.util.Scanner;

public class StringTest {

    static int number1 = 0;
    int number2 = 0;

    // static method
    static {
        number1 = 1;
        System.out.println("Printing from static method - number = " + number1);
    }

    public static void main(String[] args) {
        System.out.print("Menu: \n" +
                "1. static String pool \n" +
                "Choice your menu option: ");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> staticStringPool();
            default -> System.out.println("Invalid option - exit");
        }
    }


    /**
     * This example shows the output for Strings using java string pool
     */
    private static void staticStringPool() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("String pool example");
        System.out.println("------------------------------------------------------------------------------------------");
        String a = "Hola";
        String b = "Hola";
        System.out.print("  String a = \"Hola\";\n" +
                         "  String b = \"Hola\";\n" +
                         "  if (a == b) -> " + ((a == b) ? "TRUE" : "FALSE") + "\n"+
                         "  if (a.equals(b)) -> " + (a.equals(b) ? "TRUE" : "FALSE") + "\n");

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Second example using new keyword");
        System.out.println("------------------------------------------------------------------------------------------");
        String a1 = "Hola";
        String b1 = new String("Hola");
        System.out.print("  String a = \"Hola\";\n" +
                         "  String b = new String(\"Hola\");\n" +
                         "  if (a == b) -> " + ((a1 == b1) ? "TRUE" : "FALSE") + "\n"+
                         "  if (a.equals(b)) -> " + (a1.equals(b1) ? "TRUE" : "FALSE") + "\n");

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Third example using intern method");
        System.out.println("------------------------------------------------------------------------------------------");
        String a2 = "Hola";
        String b2 = new String("Hola").intern();
        System.out.print("  String a = \"Hola\";\n" +
                         "  String b = new String(\"Hola\").intern();\n" +
                         "  if(a == b) -> " + ((a2 == b2) ? "TRUE" : "FALSE") + "\n"+
                         "  if(a.equals(b)) -> " + (a2.equals(b2) ? "TRUE" : "FALSE") + "\n");
    }
}


