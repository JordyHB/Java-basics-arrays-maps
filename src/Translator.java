import java.util.ArrayList;
import java.util.HashMap;

public class Translator {

    private ArrayList<Integer> requestedNumbers = new ArrayList<>();
     private final HashMap<Integer, String> translationMap = new HashMap<>();

    public Translator(int[] numbers, String[] words) {

        // fills the Hashmap
        for (int i = 0; i < numbers.length; i++) {
            translationMap.put(numbers[i], words[i]);
        }
    }

    // adds given number to the requestedNumbers arrayList
    public void addNumber(int number) {
        requestedNumbers.add(number);
    }

    // prints all translated numbers back to the user
    public void translateNumbers() {
        System.out.println("Here are your numbers translated:");
        for (int number : requestedNumbers) {
            System.out.println(number + ": " + translationMap.get(number));
        }
    }
}
