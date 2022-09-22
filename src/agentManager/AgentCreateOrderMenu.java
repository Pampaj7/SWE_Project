package agentManager;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public final class AgentCreateOrderMenu implements Menu {


    @Override
    public void showMenu() {
        Agent agent = (Agent) Program.getInstance().getActiveUser();
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        boolean checkCustomer;
        int menuItem;
        int idS;
        do {
            agent.viewCustomer();

            System.out.println("agentManager.Menu option:");
            System.out.println("1. Create new customers");
            System.out.println("2. Select a existing customers");

            System.out.println("9. Back");
            System.out.println("0. Quit");
            System.out.print("Choose menu item: ");

            try {
                menuItem = Integer.parseInt(in.next());
            } catch (Exception e) {
                menuItem = -1;
            }


        } while (!quit);
    }

    private void createCustomers(Agent activeUser) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert Email:");
        String email = in.nextLine();
        System.out.println("Insert country :");
        String country = in.nextLine();
        System.out.println("Insert Business-Name :");
        String name = in.nextLine();
        activeUser.createCustomer(name, country, email);
    }

    private void subMenuSelectArticles(Agent agent, int idSelectedCustomers) {
        Scanner in = new Scanner(System.in);
        ArrayList<Pair<Article, Integer>> articlesPair = new ArrayList<>();
        Catalog c = agent.getCatalog();

        boolean agg;

        int qtaArticle;
        while (true) {
            agg = false;
            agent.viewCatalog();
            System.out.println("Insert an ID articles or 0 to terminate order");
            try {
                int idArticle = Integer.parseInt(in.next());
                if (idArticle == 0) {
                    if (articlesPair.size() > 0) {
                        break;
                    } else {
                        System.err.println("Select at least an Article!");
                        continue;
                    }
                }
                for (Article i : c.getArticles()) {
                    if (i.getId() == idArticle) {
                        do {
                            System.out.println("Insert quantity of article (>0)");
                            try {
                                qtaArticle = Math.abs(Integer.parseInt(in.next()));
                            } catch (Exception e) {
                                System.err.println("Value not valid");
                                qtaArticle = -1;
                            }
                            if (qtaArticle == 0) {
                                System.err.println("Value not valid");
                                qtaArticle = -1;
                            }
                        } while (qtaArticle == -1);

                        articlesPair.add(new Pair<>(i, qtaArticle));
                        agg = true;
                    }
                }
                if (!agg) System.err.println("Id Article Not Found!");
            } catch (Exception e) {
                System.err.println("Id not valid!");
            }
        }

        for (Customer i : Program.getInstance().getCustomers()) {
            if (i.getId() == idSelectedCustomers) {
                agent.createOrder(i, articlesPair);
                return;
            }
        }
    }

}
