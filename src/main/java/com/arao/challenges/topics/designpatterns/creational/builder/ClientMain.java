package com.arao.challenges.topics.designpatterns.creational.builder;

public class ClientMain {

    public static void main(String[] args) {

        User firstUser = new User.UserBuilder("Sheldon", "Cooper")
                .age(30)
                .phoneNbr("913456789")
                .address("Calle siempre viva")
                .build();

        System.out.println(firstUser);

        User secondUser = new User.UserBuilder("Leonard", "Hofstarter")
                .age(32)
                .phoneNbr("913456789")
                //no address
                .build();

        System.out.println(secondUser);

        User thirdUser = new User.UserBuilder("Howard", "Wolowitz")
                // no age
                // no address
                .nationality("USA")
                .build();

        System.out.println(thirdUser);
    }
}
