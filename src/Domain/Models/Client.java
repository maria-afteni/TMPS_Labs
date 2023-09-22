package Domain.Models;

import java.util.Scanner;

public class Client {
    String Username;

    public String Set_User_Username(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        Username = scanner.nextLine();
        return Username;
    }

    public String Set_User_Password(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Password:");

        return scanner.nextLine();
    }









}
