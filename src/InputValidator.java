import java.util.Scanner;

public final class InputValidator {
    public static final int MAX_ELEMENTS = 100000;

    private InputValidator() {
    }

    private static String readLine(Scanner scanner, String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            throw new InputEndedException();
        }
        return scanner.nextLine().trim();
    }

    private static int parseInteger(String value) {
        if (!value.matches("[+-]?\\d+")) {
            throw new IllegalArgumentException("Dữ liệu phải là số nguyên, không được chứa chữ hoặc số thập phân.");
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Số nằm ngoài phạm vi int (-2147483648 đến 2147483647).");
        }
    }

    public static int readInteger(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            String line = readLine(scanner, prompt);
            try {
                int value = parseInteger(line);
                if (value < min || value > max) {
                    System.out.println("Lỗi: Giá trị phải nằm trong khoảng " + min + " đến " + max + ".");
                    continue;
                }
                return value;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }

    private static int[] parseArray(String line, int expectedCount) {
        if (line.isEmpty()) {
            throw new IllegalArgumentException("Không được để trống dòng nhập.");
        }

        String[] values = line.split("\\s+");
        if (values.length > MAX_ELEMENTS) {
            throw new IllegalArgumentException("Tối đa " + MAX_ELEMENTS + " phần tử.");
        }
        if (expectedCount >= 0 && values.length != expectedCount) {
            throw new IllegalArgumentException("Cần nhập đúng " + expectedCount
                    + " phần tử, nhưng đã nhập " + values.length + ".");
        }

        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            try {
                result[i] = parseInteger(values[i]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Phần tử thứ " + (i + 1)
                        + " (\"" + values[i] + "\") không hợp lệ: " + e.getMessage());
            }
        }
        return result;
    }

    public static int[] readArray(Scanner scanner, String name) {
        int count = readInteger(scanner,
                "Nhập số phần tử của " + name + " (0-" + MAX_ELEMENTS + "): ",
                0, MAX_ELEMENTS);
        if (count == 0) {
            System.out.println("Mảng rỗng (0 phần tử).");
            return new int[0];
        }

        while (true) {
            String line = readLine(scanner,
                    "Nhập đúng " + count + " số nguyên, cách nhau bằng dấu cách: ");
            try {
                return parseArray(line, count);
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại cả dòng.");
            }
        }
    }

    public static int[] readSequence(Scanner scanner) {
        while (true) {
            String line = readLine(scanner, "Nhập các số nguyên cách nhau bằng dấu cách: ");
            try {
                return parseArray(line, -1);
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");
            }
        }
    }

    public static final class InputEndedException extends RuntimeException {
    }
}
