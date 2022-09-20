package agentManager;

import org.javatuples.Pair;

import java.util.ArrayList;

public final class Agent extends User implements Subject {

    private final Catalog catalog;
    private final float commissionPercentage;
    private final ArrayList<Observer> observers;


    public Agent(String name, String passwordHash, String email, Catalog catalog, float commissionPercentage) {
        super(name, passwordHash, email);
        this.catalog = catalog;
        this.commissionPercentage = commissionPercentage;
        this.observers = new ArrayList<>();
    }

    public Agent(String name, String passwordHash, String email, int id, Catalog catalog, float commissionPercentage) {
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
    public void viewOrders() {

    }

    @Override
    public void viewCatalog() {

    }

    @Override
    public void notify(Object obj) {

    }

    @Override
    public void attach(Observer o) {

    }

    @Override
    public void detach(Observer o) {

    }

    public void createOrder(Customer c, ArrayList<Pair<Article, Integer>> articles) {
        Order order = new Order(this, articles, c);
    }
}
