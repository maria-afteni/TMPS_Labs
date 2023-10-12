package Domain.Production;

import Domain.Models.Client;
import Domain.Production.Patterns.Creational.ClientBuilder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public class ClientAuthorization {

    public boolean validateUsername(String Username, Map<String, String> Credentials){
        boolean username = false;
        boolean u_equals = false;

        for (int i = 0; i < Credentials.size(); i++ ){
            if (Credentials.containsKey(Username)){
                u_equals = true;
                System.out.println("!! Username already exists");
                break;
            }
        }

        if (!u_equals){
            username = true;
        }
        return username;
    }


    public Map<String, String> singIn(Map<String, String> Credentials){
        Client c = new Client();
        String username = c.setUserUsername();
        String password = hashPassword(c.setUserPassword());
        ClientBuilder.clientBuilder client = new ClientBuilder.clientBuilder()
                .setUsername(username)
                .setPassword(password);
        if(Credentials.isEmpty() || validateUsername(username, Credentials)) {
            Credentials.put(username, password);
            System.out.println("Signed in successfully!");
        }
        return Credentials;
    }

    public boolean logIn(Map<String, String> Credentials){
        boolean log_in = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        String hashedPassword = hashPassword(password);

        if(Credentials.containsKey(username) && Objects.equals(Credentials.get(username), hashedPassword)){
            log_in = true;
            System.out.println("Logged in successfully");
        }else{
            System.out.println("!! Failed to log in");
        }
        return log_in;
    }

    public String hashPassword(String Password)  {
        SecureRandom random =  new SecureRandom();
        byte[] salt = new byte[16];
        String hashedPassword;
        random.nextBytes(salt);
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] messageDigest = md.digest(Password.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        hashedPassword = no.toString(16);

        return hashedPassword;
    }
}
