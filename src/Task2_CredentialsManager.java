import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2_CredentialsManager {

    public static void main(String[] args) {

        String command;

        do {
            Scanner sc = new Scanner(System.in);

            command = sc.next();
            if (command.equals("END"))
                System.exit(0);
            String username = sc.next();
            String password = sc.next();


            switch (command) {

                case "ENROLL":
                    if (
                    CredentialsDB.addUser(username, password))
                        System.out.println("ENROLL success");
                    else System.out.println("ENROLL fail");
                    break;

                case "AUTH":
                    if(
                    CredentialsDB.passCheck(username, password)!=-1)
                        System.out.println("AUTH success");
                    else System.out.println("AUTH fail");
                    break;

                case "CHPASS":
                    String passnew = sc.next();
                    if(
                    CredentialsDB.passChange(username, password, passnew))
                        System.out.println("CHPASS success");
                    else System.out.println("CHPASS fail");
            }
        } while (true);
    }
}
