package agentManager;

import java.util.Scanner;

public class AdminCustomersMenu implements Menu {
    @Override
    public void showMenu(){
        Administrator admin = (Administrator) Program.getInstance().getActiveUser();
        Scanner in = new Scanner(System.in);

        boolean quit=false;
        int menuItem;

        do {
            admin.viewCustomer();
            System.out.println("1. Add Customers");
            System.out.println("2. Delete Customers");
            System.out.println("3. View Order Client");
            System.out.println("9. Back");
            System.out.println("0. Quit");
            System.out.print("Choose menu item: ");
            try{
                menuItem=Integer.parseInt(in.next());
            }catch (Exception e){
                menuItem=-1;
            }
            switch (menuItem){
                case 1:
                    createCustomers(admin);
                    break;
                case 2:
                    System.out.println("enter the code of the customer to delete");
                    try {
                        int idC=in.nextInt();
                        admin.deleteCustomer(idC);
                    }catch (Exception e){
                        System.err.println("invalid id");
                    }
                    break;
                case 3:
                    System.out.println("enter the code of the customer for which to view the orders");
                    try {
                        int idCustomer = in.nextInt();
                        admin.viewCustomerOrders(idCustomer);
                    }catch (Exception e){
                        System.err.println("invalid id");
                    }
                    break;
                case 9:
                    quit=true;
                    Program.getInstance().setMenu(new AdminMainMenu());
                    break;
                case 0:
                    quit=true;
                    Program.getInstance().close();
                    break;

                default:
                    System.err.println("invaid choice");
            }
        }while (!quit);
    }

    private void createCustomers(Administrator activeUser){

        Scanner in= new Scanner(System.in);
        System.out.println("insert business name:");
        String name = in.nextLine();
        System.out.println("insert email:");
        String email = in.nextLine();
        System.out.println("insert country:");
        String country = in.nextLine();

        activeUser.createCustomer(name,country,email);

    }
}
