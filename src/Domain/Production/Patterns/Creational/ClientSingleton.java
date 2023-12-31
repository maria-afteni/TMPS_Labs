package Domain.Production.Patterns.Creational;

import Domain.Production.ClientAuthorization;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClientSingleton {
    private static ClientSingleton instance = null;
    boolean logged;
    ClientAuthorization c1 = new ClientAuthorization();
    Map<String, String> credentials = new HashMap<>(){{
        put("Admin", c1.hashPassword("admin32"));
        put("Nicu", c1.hashPassword("angel"));
    }};

    private ClientSingleton(){
        String username;
        Scanner scanner = new Scanner(System.in);
        this.logged = false;
        System.out.println("\n1. Sign in \n2. Log in");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> credentials = c1.singIn(credentials);
            case 2 -> {
                assert credentials != null;
                username = c1.logIn(credentials);
                if (!username.isEmpty() && c1.checkIfAdmin(username)){
                    this.logged = true;
                }

            }
        }
    }
    public static synchronized ClientSingleton getInstance(){
        if (instance == null){
            instance = new ClientSingleton();
        }

        return instance;
    }

    public boolean getStatus(){
        return logged;
    }
}
