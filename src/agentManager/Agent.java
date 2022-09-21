package agentManager;

import org.javatuples.Pair;

import java.util.ArrayList;

public final class Agent extends User implements Subject {

    private final Catalog catalog;
    private final float commissionPercentage;
    private final ArrayList<Observer> observers;


    public Agent(String name, String passwordHash, float commissionPercentage, Catalog catalog, String email) {
        super(name, passwordHash, email);
        this.catalog = catalog;
        this.commissionPercentage = commissionPercentage;
        this.observers = new ArrayList<>();
    }

    public Agent(String name, String passwordHash, String email, float commissionPercentage, Catalog catalog, int id) {
        super(name, passwordHash, email, id);
        this.catalog = catalog;
        this.commissionPercentage = commissionPercentage;
        this.observers = new ArrayList<>();
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public float getCommissionPercentage() {
        return commissionPercentage;
    }


    @Override
    public void notify(Object obj) {
        for (Observer o : observers) {
            o.update(obj);
        }

    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }


    @Override
    public void viewOrders() {
        System.out.println("--");
        boolean check = false;
        for (Order i : Program.getInstance().getOrders()) {
            if (i.getAgent().getId() == this.getId()) { //TODO necessario?
                System.out.println("Order iD: " + i.getId() + "TOTAL: " + i.getTotal() + "COMMISSION: " + i.getCommissionTot() + "Client: " + i.getClient().getBusinessName());
                i.printArticle();
                check = true;
            }
        }

        if (!check) {
            System.out.println("No orders!");
            System.out.println("--------------");

        }

    }

    @Override
    public void viewCatalog() {
        System.out.println("--");
        catalog.printCatalog();
        System.out.println("--");

    }

    public void createOrder(Customer c, ArrayList<Pair<Article, Integer>> articles) {
        Order order = new Order(this, articles, c); //>TODO in che modo?
        Program.getInstance().getOrders().add(order);
        System.out.println("Created!");
        notify(new Order(order));
    }

    public boolean deleteOrder(int id) {

        Order orderToDelete = null;

        for (Order i : Program.getInstance().getOrders()) {
            if (i.getId() == id && i.getAgent().getId() == this.getId()) {
                orderToDelete = i;
            }
        }

        if (orderToDelete == null) {
            System.err.println("Error, ID wrong!");
            return false; //TODO farei lanciare un'eccezione
        }

        Program.getInstance().getOrders().remove(orderToDelete);

        return true;

    }

}
