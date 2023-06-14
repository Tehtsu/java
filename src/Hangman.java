// import Scanner for console input
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args){
/*
        Programmiersprachen
            - Java
        Zielstellung
            – Einstieg in die imperative Programmierung
            – Verwendung von Benutzerein- und ausgaben über die Konsole
            – Verwendung von Kontrollstrukturen (Verzweigungen und Schleifen)
            – Verwendung von Methoden
            – Verwendung von Variablen
        Aufgabenbeschreibung
            – es gibt ein geheimes Lösungswort [x]
            – der Spieler hat maximal 10 Versuche jeweils einen Buchstaben vom Lösungswort zu tippen [x]
            – nach jeder Eingabe darf er, wenn er möchte, das Lösungswort versuchen
                    zu lösen. []
            – nach jeder Eingabe eines Buchstaben wird das Lösungswort mit den
                    bereits richtig getippten Buchstaben angezeigt. []
            – der Spieler gewinnt, wenn er alle Buchstaben oder das Lösungswort
                    gelöst hat. []
            – sind die 10 Versuche verbraucht oder hat er das Lösungswort falsch
                    auflösen wollen, hat der Spieler verloren. []
            – dem Spieler wird das Ergebnis mitgeteilt. []
*/

        /**
         * Variables for guessiing word
         * max try = 10
         * attempts
         * and word guessed as bool (true or false) - false by default
         * array for correctly tipped letters
         * bool for letter found
         */
        String[] guessingWord = {"Hund",
                "Keks",
                "Auto",
                "Baum",
                "Haus"};
        Random random = new Random();
        int rndNumber = random.nextInt(5);
        //System.out.println(rndNumber + " " + guessingWord[rndNumber]);
        int maxTry = 10;
        int attempt = 0;
        boolean guessed = false;
        boolean[] correctLetter = new boolean[guessingWord[rndNumber].length()];
        boolean letterFound = false;

        //Scanner for input
        Scanner scanner = new Scanner(System.in);

        //output game rules
        System.out.println("Spielregeln:"
                + '\n' +
                "Du hast maximal 10 Versuche"
                + '\n' +
                "Du kannst nach jedem versuch das Wort auflösen, ist es falsch ist das Spiel vorbei.");

        while (attempt < maxTry){
            System.out.print("Gib einen Buchstaben von a-z ein: ");
            char inputLetter = scanner.nextLine().charAt(0);
            //System.out.println(inputLetter);

            // check if letter is into the guessing word
            for (int i = 0; i < guessingWord[rndNumber].length();i++){
                if (guessingWord[rndNumber].toLowerCase().charAt(i) == inputLetter){
                    correctLetter[i] = true;
                    letterFound = true;
                }
            }

            // show found letters of the solution word
            for (int i = 0; i <guessingWord[rndNumber].length(); i++){
                if (correctLetter[i]) {
                    System.out.print(guessingWord[rndNumber].charAt(i));
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();

            // show message if letter is incorrect and remaining tries
            if (!guessed){
                attempt++;
                System.out.println("Der Buchstabe " + inputLetter + " gehört nicht zum gesuchten Wort");
                System.out.println("Verbleibende Versuche: " + (maxTry-attempt));
            }
            
            // check if found all letters
            guessed = true;
            for (boolean guesses : correctLetter){
                if (!guesses){
                    guessed = false;
                    break;
                }
            }

            // if word is found game ends otherwise game is over
            if (guessed){
                System.out.println("Du hast das gesuchte " + guessingWord[rndNumber] + " gefunden!");
                break;
            } else if (attempt == maxTry) {
                System.out.println("Kein verbleibenden Versuche mehr! Game Over");
                break;
            } else {
                // solve the word
                System.out.print("Möchtest du Lösen? (y/n) ");
                String attemptSolved = scanner.nextLine();

                if (attemptSolved.equalsIgnoreCase("y")){
                    System.out.print("Gib das gesuchte Wort ein: ");
                    String solveWord = scanner.nextLine();

                    // if entered word is correct game is won otherwise game is over
                    if (solveWord.equalsIgnoreCase(guessingWord[rndNumber])) {
                        System.out.println("Du hast das gesuchte Wort " + guessingWord[rndNumber] + " gefunden!");
                        guessed = true;
                        break;
                    } else {
                        System.out.println("Dein Wort " + solveWord + " ist leider nicht das richtige Wort.");
                        System.out.println("Gesucht war das Wort " + guessingWord[rndNumber]);
                        break;
                    }
                }
            }
            System.out.println();

        }
        // close input - game end or game over
        scanner.close();

    }
}
