import java.util.Scanner;

public class Bai1 {
    public static void run(Scanner scanner) {
        int[] array = InputValidator.readArray(scanner, "mảng");
        long sum = 0;
        for (int value : array) {
            sum += value;
        }
        System.out.println("Tổng các phần tử: " + sum);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        } catch (InputValidator.InputEndedException e) {
            System.out.println("\nĐã kết thúc dữ liệu nhập.");
        }
    }
}
