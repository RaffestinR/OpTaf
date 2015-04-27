package outil;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
            throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (!s.startsWith("quit")) {
            System.out.print('>');
            StringBuilder commande = new StringBuilder();
            do {
                s = sc.nextLine();
                commande.append(s);
            } while (!


                    s.endsWith(";;"));
            try {
                AutomateParser.parserString(commande.toString());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}

