package Domain.Models;

import java.util.Scanner;

public class Client {
    String Username;

    public String setUserUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        Username = scanner.nextLine();
        return Username;
    }

    public String setUserPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Password:");

        return scanner.nextLine();
    }
}
