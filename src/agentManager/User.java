package agentManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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


    public abstract void viewOrders();

    public abstract void viewCatalog();


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

    public static String getHash(String Password) { // serie di funzioni hash che criptano la password
        String generatePassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); //E' praticamente una funzione hash che cripta la
            // password e la rende più sicura --> roba di sicurezza ceh si può levare
            md.update(Password.getBytes());
            byte bytes[] = md.digest(); //TODO modificare o capire
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            generatePassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatePassword;
    }
}


