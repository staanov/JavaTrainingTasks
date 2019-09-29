import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        File cashDir = new File(args[0]);
        File[] cashLists = new File[5];
        float[][] cashs = new float[5][16];
        float nextNumber;
        int maxBuyersPeriod;
        cashListsLoading(cashLists, cashDir);
        for (int i = 0; i < cashLists.length; i++) {
            try {
                FileReader reader = new FileReader(cashLists[i]);
                Scanner scanner = new Scanner(reader);
                int counter = 0;
                while (scanner.hasNextLine()) {
                    nextNumber = Float.parseFloat(scanner.nextLine());
                    cashs[i][counter] = nextNumber;
                    counter++;
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        maxBuyersPeriod = calculatingMaxBuyersPeriod(cashs);
        System.out.println(maxBuyersPeriod);
    }

    private static int calculatingMaxBuyersPeriod(float[][] cashs) {
        float realMax = cashs[0][0] + cashs[1][0] + cashs[2][0] + cashs[3][0] + cashs[4][0];
        float candidateMax = 0.0f;
        int indexMax = 0;
        for (int i = 1; i < cashs[0].length; i++) {
            candidateMax = cashs[0][i] + cashs[1][i] + cashs[2][i] + cashs[3][i] + cashs[4][i];
            if (candidateMax > realMax) {
                realMax = candidateMax;
                indexMax = i;
            }
        }
        indexMax++;
        return indexMax;
    }

    private static void cashListsLoading(File[] cashLists, File cashDir) {
        cashLists[0] = new File(cashDir, "Cash1.txt");
        cashLists[1] = new File(cashDir, "Cash2.txt");
        cashLists[2] = new File(cashDir, "Cash3.txt");
        cashLists[3] = new File(cashDir, "Cash4.txt");
        cashLists[4] = new File(cashDir, "Cash5.txt");
    }
}
