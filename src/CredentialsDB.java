import java.util.ArrayList;
import java.util.List;

public class CredentialsDB {

    static List<Credentials> credentialsDB = new ArrayList<>();

    public static int userBusy(String username) {

        int user  = -1;

        for (int i = 0; i < credentialsDB.size(); i++) {

            if (credentialsDB.get(i).getUsername().equals(username)) {
            user = i;

        }
    }return user;
}


    public static boolean addUser(String username, String password){

        boolean user = false;

        if(userBusy(username)==-1) {
            credentialsDB.add(new Credentials(username, password));
            user = true;
        }return user;
    }

    public static int passCheck (String username, String password){

        int user = userBusy(username);

        if ((user != -1) && credentialsDB.get(user).getPassword().equals(password)){}

        else user = -1;
    return user;
    }

    public static boolean passChange (String username, String passold, String passnew){

        int user = passCheck(username,passold);
        boolean pass = false;

        if (user!=-1){
            credentialsDB.get(user).setPassword(passnew);
            pass = true;
        }return pass;
    }
}
