package agentManager;

import java.util.ArrayList;


public class Program {
    private User activeUser;
    private final ArrayList<User> users;

    private static Program instance;
    private final ArrayList<Article> articles;
    private final ArrayList<Catalog> catalogs;
    private final ArrayList<Customer> customers;
    private final ArrayList<Order> orders;
    private Menu menu;
    private final NotificationCenter notCenter;


    private Program() {
        users = new ArrayList<>();
        articles = new ArrayList<>();
        catalogs = new ArrayList<>();
        customers = new ArrayList<>();
        orders = new ArrayList<>();
        notCenter = new NotificationCenter();
    }


    public User getActiveUser() {
        return activeUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public ArrayList<Catalog> getCatalogs() {
        return catalogs;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public static Program getInstance() {
        if (instance == null)
            instance = new Program();
        return instance;

    }

    public NotificationCenter getNotCenter() {
        return notCenter;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void Run() {
    }
}
