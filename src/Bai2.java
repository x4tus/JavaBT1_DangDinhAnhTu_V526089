import java.util.Arrays;
import java.util.Scanner;

public class Bai2 {
    public static long[] addArrays(int[] first, int[] second) {
        int size = Math.max(first.length, second.length);
        long[] result = new long[size];

        for (int i = 0; i < size; i++) {
            if (i < first.length) {
                result[i] += first[i];
            }
            if (i < second.length) {
                result[i] += second[i];
            }
        }
        return result;
    }

    public static void run(Scanner scanner) {
        int[] first = InputValidator.readArray(scanner, "mảng thứ nhất");
        int[] second = InputValidator.readArray(scanner, "mảng thứ hai");
        long[] result = addArrays(first, second);
        System.out.println("Mảng tổng: " + Arrays.toString(result));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        } catch (InputValidator.InputEndedException e) {
            System.out.println("\nĐã kết thúc dữ liệu nhập.");
        }
    }
}
