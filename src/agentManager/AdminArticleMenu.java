package agentManager;

import java.util.ArrayList;
import java.util.Scanner;

public final class AdminArticleMenu implements Menu {

    @Override
    public void showMenu() {
        Administrator admin = (Administrator) Program.getInstance().getActiveUser();//TODO wtf
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        int menuitem;

        do {
            admin.viewProduct();
            System.out.println("1. Add Article");
            System.out.println("2. Delete Article");
            System.out.println("9. Back");
            System.out.println("0. Quit");
            System.out.print("Choose menu item: ");
            try {
                menuitem = Integer.parseInt(in.next());

            } catch (Exception e) {
                menuitem = -1;
            }
            switch (menuitem) {


                case 1:
                    createProductQuery(admin);
            }

        } while (!quit);

    }

    private void createProductQuery(Administrator activeUser) {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        float price = 0;
        ArrayList<Article> articles = new ArrayList<>();

        System.out.println("Insert Article Name :");
        String name = in.nextLine();

        int reply;
        do {
            System.out.println("Do you want to insert a Composite Article?");
            System.out.println("1. Yes");
            System.out.println("0. No");

            try {
                reply = Integer.parseInt(in.next());
            } catch (Exception e) {
                reply = -1;
            }

            switch (reply) {
                case 1:
                    boolean agg;
                    while (true) {

                    }
            }
        } while (!done);
    }
}
