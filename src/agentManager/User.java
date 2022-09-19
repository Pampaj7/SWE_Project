package agentManager;

public abstract class User {
    private final String name;
    private final String passwordHash;
    private final String email;
    private final int id;
    private static int lastID;


    public User(String name, String passwordHash, String email, int id) {
        this.name = name;
        this.passwordHash = passwordHash;
        this.email = email;
        this.id = id;
        lastID = Math.max(lastID, id);
    }

    public User(String name, String passwordHash, String email) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        lastID++;//todo cazzo serve
        id = 0;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public int getId() {
        return id;
    }

    public void createCustomer(String buisnessName, String country, String email) {
        Program.getInstance().getCustomers().add(new Customer(buisnessName, country, email));
        System.out.println("Created");
    }

    public void viewCustomer() {
        System.out.println("$$$$$$$$");
        for (Customer c : Program.getInstance().getCustomers()) {
            System.out.println("Customer ID: " + c.getId() + "Customer name: " + c.getBusinessName() + "Customer email: " + c.getEmail());
            System.out.println("£££££££");
        }
    }

    public abstract void viewOrders();

    public abstract void viewCatalog();


}


