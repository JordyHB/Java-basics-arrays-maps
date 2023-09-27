import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Array with the numbers and their corresponding words
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        // Create a new instance of the Translator class
        Translator translator = new Translator(numbers, words);
        // Scanner to get user input
        Scanner myScanner = new Scanner(System.in);
        // flag that keeps the loop going
        boolean keepGoing = true;

        System.out.println("Welcome to the number translator!");

        while (keepGoing) {

            handleInput(myScanner, translator);
            /* Checks whether the loop should be continued or the info should be sent off for translation */
            keepGoing = keepGoingCheck(myScanner);
        }

        // Prints the translated numbers once the loop is done
        translator.translateNumbers();
    }

    public static void handleInput(Scanner myScanner, Translator translator) {

        System.out.println("Please enter a number between 1 and 9");
        // put in a try catch block to handle unexpected inputs
        try {
            // stores the int in a variable for further use
            int input = myScanner.nextInt();
            // Pushes the scanner to the next line, so it doesn't use the old input
            myScanner.nextLine();
            // Checks whether the given number is in the correct range.
            if (input < 1 || input > 9) {
                System.out.println(input + " is NOT between 1 and 9 :(");
                // Calls the method again to give the user another chance to input a number
                handleInput(myScanner, translator);
            }
            // adds it to an arrayList with requested numbers
            translator.addNumber(input);


        } catch (InputMismatchException e) { // Will execute if user inputs anything other than an int
            System.out.println("Only full NUMBERS between 1 and 9 please :)");
            // Pushes the scanner to the next line, so it doesn't use the old input
            myScanner.nextLine();
            // Calls the method again to give the user another chance to input a number
            handleInput(myScanner, translator);
        }
    }

    public static boolean keepGoingCheck(Scanner myScanner) {

        /* Checks whether the loop should be continued or the info should be sent off for translation */
        System.out.println("Would you like to enter another Number? Enter Y/N");

        while (true) {
            // loop will continue if the user enters Y or y and will break if the user enters N or n will ask again if the user enters anything else
            String answer = myScanner.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                System.out.println("Great! Let's continue!");
                return true;
            } else if (answer.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("All I'm asking for is a simple Y or N, please try again.");
            }
        }
    }
}

