package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class ListOfSites {

    public ListOfSites() {
        super();
    }

    public void addNewSite (String site, File file) throws SiteAdressException {

        List<String> checkSite = new ArrayList<>(Arrays.asList(site.split("\\.")));

        if (!checkSite.get(0).equals("www")) {
            throw new SiteAdressException("Wrong site adress!");
        }

        try(FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fileWriter);) {
            pw.print("https://" + site + ";");
            System.out.println("Site \'" + site + "\' was succesfully added");
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getListOfSites(File file) {
        Map<String, Integer> sites = new HashMap<>();
        String str = "";

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                str += sc.nextLine().toLowerCase();
            }
            List<String> list = new ArrayList<>(Arrays.asList(str.split(";")));
            for ( String elem : list ) {
                URL url = new URL(elem);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                Integer rc = connection.getResponseCode();
                sites.put(elem, rc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String k: sites.keySet() ) {
            System.out.println(k + " response code => " + sites.get(k));
        }
    }

}
