import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File inputFile = new File(args[0]);
        ArrayList<Integer> numbers = new ArrayList<>();
        int nextNumber;
        try {
            FileReader reader = new FileReader(inputFile);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                nextNumber = Integer.parseInt(scanner.nextLine());
                numbers.add(nextNumber);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        calculating(numbers);
    }

    private static void calculating(ArrayList<Integer> numbers) {
        float procentile = calculatingProcentile(numbers);
        float median = calculatingMedian(numbers);
        float max = calculatingMax(numbers);
        float min = calculatingMin(numbers);
        float average = calculatingAverage(numbers);

        System.out.println(String.format("%.2f\n%.2f\n%.2f\n%.2f\n%.2f\n",
                procentile, median, max, min, average));
    }

    private static float calculatingProcentile(ArrayList<Integer> numbers) {
        ArrayList<Integer> sortedNumbers = numbers;
        Collections.sort(sortedNumbers);
        float index = ((float) 90 / 100) * sortedNumbers.size();
        return sortedNumbers.get(Math.round(index) - 1);
    }

    private static float calculatingMedian(ArrayList<Integer> numbers) {
        ArrayList<Integer> sortedNumbers = numbers;
        Collections.sort(sortedNumbers);
        if (sortedNumbers.size() % 2 == 0) {
            return ((float) (sortedNumbers.get(sortedNumbers.size() / 2)) +
                    (sortedNumbers.get(sortedNumbers.size() / 2 + 1))) / 2;
        } else {
            return sortedNumbers.get(sortedNumbers.size() / 2 + 1);
        }
    }

    private static float calculatingMax(ArrayList<Integer> numbers) {
        float maxNumber = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > maxNumber) {
                maxNumber = numbers.get(i);
            }
        }
        return maxNumber;
    }

    private static float calculatingMin(ArrayList<Integer> numbers) {
        float minNumber = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < minNumber) {
                minNumber = numbers.get(i);
            }
        }
        return minNumber;
    }

    private static float calculatingAverage(ArrayList<Integer> numbers) {
        float sum = 0.00f;
        float amount = numbers.size();
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum / amount;
    }
}
