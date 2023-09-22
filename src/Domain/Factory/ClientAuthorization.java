package Domain.Factory;

import Domain.Models.Client;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public class ClientAuthorization {

    public boolean Validate_Username(String Username, Map<String, String> Credentials){
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


    public Map<String, String> Sing_In(Map<String, String> Credentials){
        Client c = new Client();
        String Username = c.Set_User_Username();
        String Password = Hash_Password(c.Set_User_Password());
        if(Credentials.isEmpty() || Validate_Username(Username, Credentials)) {
            Credentials.put(Username, Password);
            System.out.println("Signed in successfully!");
        }
        return Credentials;
    }

    public boolean Log_in(Map<String, String> Credentials){
        boolean log_in = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        String hashedPassword = Hash_Password(password);

        if(Credentials.containsKey(username) && Objects.equals(Credentials.get(username), hashedPassword)){
            log_in = true;
            System.out.println("Logged in successfully");
        }else{
            System.out.println("!! Failed to logg in");
        }
        return log_in;
    }

    public String Hash_Password(String Password)  {
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
