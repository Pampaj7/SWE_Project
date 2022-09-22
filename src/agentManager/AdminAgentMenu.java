package agentManager;

import java.util.Scanner;

public final class AdminAgentMenu implements Menu {
    @Override
    public void showMenu() {

        Administrator admin = (Administrator) Program.getInstance().getActiveUser();
        Scanner in = new Scanner(System.in);

        boolean quit = false;
        int menuItem;

        do {
            admin.viewAgent();
            System.out.println("1. Add Agent");
            System.out.println("2. Delete Agent");
            System.out.println("3. View Catalog Agent");
            System.out.println("9. Back");
            System.out.println("0. Quit");
            System.out.print("Choose menu item: ");
            try {
                menuItem = Integer.parseInt(in.next());
            } catch (Exception e) {
                menuItem = -1;
            }
            switch (menuItem) {
                case 1:
                    createAgent(admin);
                    break;
                case 2:
                    System.out.println("Enter the code of the agent to delete");
                    try {
                        int idA = in.nextInt();
                        admin.deleteAgent(idA);
                    } catch (Exception e) {
                        System.err.println("invalid id");
                    }
                    break;
                case 3:
                    System.out.println("Enter the code of agent you want to see the catalog");
                    try {
                        int idAgent = in.nextInt();
                        admin.viewCatalogAgent(idAgent);
                    } catch (Exception e) {
                        System.err.println("invalid id");
                    }
                    break;
                case 9:
                    quit = true;
                    Program.getInstance().setMenu(new AdminMainMenu());
                    break;
                case 0:
                    quit = true;
                    Program.getInstance().close();
                    break;
                default:
                    System.out.println("invalid input");
            }


        } while (!quit);

    }

    private void createAgent(Administrator activeUser) {

        Scanner in = new Scanner(System.in);

        System.out.println("Insert Name:");
        String name = in.nextLine();
        System.out.println("Insert Password :");
        String password = in.nextLine();
        System.out.println("Insert email :");
        String email = in.nextLine();

        float percentage;
        do {
            System.out.println("insert percentage of commission");
            try {
                percentage = Math.abs(Float.parseFloat(in.next()));
            } catch (Exception e) {
                System.err.println("you must enter a number");
                percentage = -1;
            }
        } while (percentage == -1);

        Catalog catalog = null;

        int idCatalog;
        do {
            activeUser.viewCatalog();
            System.out.println("insert catalog id:");
            try {
                idCatalog = Integer.parseInt(in.next());
                for (Catalog i : Program.getInstance().getCatalogs())
                    if (i.getId() == idCatalog)
                        catalog = i;
            } catch (Exception ignored) {
            }

            if (catalog == null)
                System.err.println("you must insert a number");
        } while (catalog == null);

        activeUser.createAgent(name, password, percentage, catalog, email);
    }
}
