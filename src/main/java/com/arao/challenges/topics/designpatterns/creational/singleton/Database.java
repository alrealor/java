package com.arao.challenges.topics.designpatterns.creational.singleton;

/**
 * SINGLETON design pattern
 *
 * To create a singleton class, a class must implement the following properties:
 *
 * - Create a private constructor of the class to restrict object creation outside of the class.
 * - Create a private attribute of the class type that refers to the single object.
 * - Create a public static method that allows us to create and access the object we created.
 *   Inside the method, we will create a condition that restricts us from creating more than one object.
 */
public class Database {

    private static Database dbObject;

    // private constructor to avoid access from outside
    public Database() {}

    // static method to get the unique instance of the class
    public static Database getInstance() {
        if (dbObject == null) {
            dbObject = new Database();
        }
        return dbObject;
    }

    public void getConnection() {
        System.out.println("you are connected to the DB");
    }
}
