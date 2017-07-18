package addition.jdbc;

import addition.jdbc.service.DBService;
import addition.jdbc.service.dataset.UserDataSet;
import addition.jdbc.service.exception.DBException;

/**
 * Created by alterG on 17.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        dbService.printConnectionInfo();

        try {
            long userId = dbService.addUser("tully");
            System.out.println("Add new user id = " + userId);

            UserDataSet userDataSet = dbService.getUser(userId);
            System.out.println("New user is " + userDataSet);
            dbService.cleanUp();

        } catch (DBException e) {
            e.printStackTrace();
        }

    }
}
