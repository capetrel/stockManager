package gesionStock;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by jeromeheissler on 25/11/2015.
 */
public class SaisieStock {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Classe pour gérer les entrées clavier
     * @param prompt
     * @return
     */
    public static int lireEntier(String prompt) {
        int read = 0;
        boolean valid = false;
        while(!valid) {
            try {
                System.out.print(prompt);
                read = sc.nextInt();
                sc.nextLine();
                valid = true;
            } catch (InputMismatchException inputMismatchException) {
                sc.nextLine();
            }
        }
        return read;
    }

    public static String lireChaine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static double lireDouble(String prompt) {
        double read = 0;
        boolean valid = false;
        while(!valid) {
            try {
                System.out.print(prompt);
                read = sc.nextDouble();
                valid = true;
            } catch (InputMismatchException inputMismatchException) {
                //
            } finally {
                sc.nextLine();
            }
        }
        return read;
    }

    /**
     * question de type Oui/Non
     *
     * @param prompt le message d'invite à afficher
     * @return true si la réponse commence par 'o' ou 'O', false sinon
     */
    public static boolean lireOuiNon(String prompt) {
        System.out.print(prompt);
        String rep = sc.nextLine();
        return rep.toUpperCase().startsWith("O");
    }

    public static boolean lireNonOui(String prompt) {
        System.out.print(prompt);
        String rep = sc.nextLine();
        return rep.toUpperCase().startsWith("N");
    }

}
