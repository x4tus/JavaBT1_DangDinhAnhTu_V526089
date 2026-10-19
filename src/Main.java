import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n========== BÀI TẬP MẢNG ==========");
                System.out.println("1. Bài 1 - Nhập mảng và tính tổng");
                System.out.println("2. Bài 2 - Cộng hai mảng");
                System.out.println("3. Bài 3 - Nhập một dòng, đếm và tính tổng");
                System.out.println("0. Thoát");

                int choice = InputValidator.readInteger(scanner, "Chọn bài (0-3): ", 0, 3);
                switch (choice) {
                    case 1 -> Bai1.run(scanner);
                    case 2 -> Bai2.run(scanner);
                    case 3 -> Bai3.run(scanner);
                    case 0 -> {
                        System.out.println("Đã thoát chương trình.");
                        return;
                    }
                }
            }
        } catch (InputValidator.InputEndedException e) {
            System.out.println("\nĐã kết thúc dữ liệu nhập.");
        }
    }
}
