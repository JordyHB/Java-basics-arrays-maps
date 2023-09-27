import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bonus {

    public static void main(String[] args) {

        HashSet<Integer> secretNumber = randomnumbergenerator();
        String stringNumber = setToStringConverter(secretNumber);
        feedback(stringNumber);

    }

    public static HashSet<Integer> randomnumbergenerator(){

        Random randGen = new Random();
        HashSet<Integer> secretNumbers = new HashSet<>();

        while (secretNumbers.size() < 4) {
            //Adds a random int between 1 and 9 till 4 numbers are given
            secretNumbers.add(randGen.nextInt(1,9));
        }

        return secretNumbers;
    }

    public static String setToStringConverter(HashSet<Integer> secretNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        //loops over all the secret numbers and adds them to a string for returning
        for (Integer secretNumber : secretNumbers) {
            stringBuilder.append(secretNumber);
        }

        return stringBuilder.toString();
    }



    public static void/*moet dit "void" zijn of wat anders?*/ feedback(String stringnumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(stringnumber);
        StringBuilder feedback = new StringBuilder();
        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
        while (true) {
            System.out.println("Doe een gok, Let op vul 4 getallen in.");
            String guess = scanner.nextLine();
            if (Objects.equals(guess, stringnumber)) {
                System.out.println("gefeliciteerd je hebt het goed");
                break;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("0");
                    } else {
                        feedback.append("X");
                    }
                }
            }
            System.out.println(feedback.toString());
            // empties the old stringbuilder
            feedback.setLength(0);
        }
    }
}
