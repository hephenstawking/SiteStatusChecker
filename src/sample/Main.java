package sample;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ListOfSites list = new ListOfSites();

        File sites = new File("sites.txt");
        Scanner sc = new Scanner(System.in);

        System.out.println("If you want to add a new site type \'A\', if you want to check sites state type \'S\':");
        String answer = sc.next();

        if (answer.equals("A")) {
            System.out.println("Enter site adress, starts with \'www\':");
            String siteAdress = sc.next();
            try {
                list.addNewSite(siteAdress, sites);
            } catch (SiteAdressException e) {
                e.printStackTrace();
            }
        } else if (answer.equals("S")) {
            list.getListOfSites(sites);
        }

    }
}
