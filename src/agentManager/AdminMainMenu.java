package agentManager;

import java.util.Scanner;

public class AdminMainMenu implements Menu {

    @Override
    public void showMenu() {

        Administrator admin = (Administrator) Program.getInstance().getActiveUser();
        Scanner in = new Scanner(System.in);

        System.out.println("hello " + admin.getName());
        admin.viewNotification();

        boolean quit = false;
        int menuItem;

        do {
            System.out.println("Menu option:\n1) View Agent\n2) View Catalogs\n3)View ");
        } while (!quit);

    }
}
