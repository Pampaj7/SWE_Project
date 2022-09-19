package agentManager;

public final class Administrator extends User {

    public Administrator(String name, String password, String email) {
        super(name, password, email);
    }

    public Administrator(String name, String passwordHash, String email, int id) {
        super(name, passwordHash, email, id);
    }

    @Override
    public void viewOrders() {

    }
}
