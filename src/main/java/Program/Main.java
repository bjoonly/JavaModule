package Program;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            //task1();
            //task2(scanner);
            //task3(scanner);
            //task4(scanner);
            //task5(scanner);
            //task6(scanner);
            //task7(scanner);
            //task8(scanner);
            //task9();
            //task10();
            //task11(scanner);
            task12(scanner);
        } catch (InputMismatchException ex) {
            System.err.println("Invalid input value.");
        } catch (Exception ex) {
            System.out.println("Something went wrong.");
            if (ex.getMessage() != null)
                System.err.println("Exception: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void task1() {
        System.out.println("“Your time is limited," +
                "\n\tso don’t waste it" +
                "\n\t\tliving someone else’s life”" +
                "\n\t\t\tSteve Job");
    }

    public static void task2(Scanner scanner) {
        System.out.print("Enter number: ");
        double number = scanner.nextDouble();
        System.out.print("Enter percent: ");
        double percent = scanner.nextDouble();
        double result = number / 100 * percent;
        System.out.println("Result: " + result);
    }

    public static void task3(Scanner scanner) {
        System.out.print("Enter first number: ");
        int firstNum = scanner.nextInt();
        System.out.print("Enter second number: ");
        int secondNum = scanner.nextInt();
        System.out.print("Enter third number: ");
        int thirdNum = scanner.nextInt();
        int result = firstNum * 100 + secondNum * 10 + thirdNum;
        System.out.println("Result: " + result);
    }

    public static void task4(Scanner scanner) {
        System.out.print("Enter a six-digit number: ");
        String numberStr = String.valueOf(scanner.nextInt());

        if (numberStr.length() != 6) {
            System.out.print("This is not a six-digit number!");
            return;
        }

        StringBuilder sb = new StringBuilder(numberStr);
        sb.setCharAt(0, numberStr.charAt(numberStr.length() - 1));
        sb.setCharAt(numberStr.length() - 1, numberStr.charAt(0));

        sb.setCharAt(1, numberStr.charAt(numberStr.length() - 2));
        sb.setCharAt(numberStr.length() - 2, numberStr.charAt(1));

        System.out.println(sb);
    }

    public static void task5(Scanner scanner) {
        System.out.print("Enter number of month: ");
        int month = scanner.nextInt();
        if (month < 1 || month > 12)
            System.out.println("Invalid number of month.");
        else if (month == 12 || month <= 2)
            System.out.println("Winter");
        else if (month <= 5)
            System.out.println("Spring");
        else if (month <= 8)
            System.out.println("Summer");
        else
            System.out.println("Autumn");
    }

    public static void task6(Scanner scanner) {
        System.out.print("Enter number of meters: ");
        double number = scanner.nextDouble();
        System.out.print("Convert to: \n" +
                "1. Miles\n" +
                "2. Inches\n" +
                "3. Yards\n" +
                "Option: ");
        int option = scanner.nextInt();
        double result;
        switch (option) {
            case 1:
                result = number * 0.000621371;
                System.out.printf("%s meters = %f mi", number, result);
                break;
            case 2:
                result = number * 39.3701;
                System.out.printf("%s meters = %f in", number, result);
                break;
            case 3:
                result = number * 1.09361;
                System.out.printf("%s meters = %f yd", number, result);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    public static void task7(Scanner scanner) {
        System.out.print("Enter first number: ");
        int firstNum = scanner.nextInt();
        System.out.print("Enter second number: ");
        int secondNum = scanner.nextInt();

        if (firstNum > secondNum) {
            int tmp = firstNum;
            firstNum = secondNum;
            secondNum = tmp;
        }
        if (firstNum == secondNum || firstNum + 1 == secondNum) {
            System.out.printf("There are no odd numbers in [%s, %s] range!", firstNum, secondNum);
            return;
        }

        for (int i = firstNum + 1; i < secondNum; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void task8(Scanner scanner) {
        System.out.print("Enter first number: ");
        int start = scanner.nextInt();
        System.out.print("Enter second number: ");
        int end = scanner.nextInt();

        if (start > end) {
            System.out.print("Invalid range.");
            return;
        }

        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%2d * %-2d = %-3d \n", i, j, i * j);
            }
        }
    }

    public static void task9() {
        int size = 10;
        int[] array = fillRandomArray(size);
        int min = array[0],
                max = array[0];
        int countNegative = 0,
                countPositive = 0,
                countZero = 0;

        for (int i = 0; i < size; i++) {
            if (array[i] < min)
                min = array[i];
            if (array[i] > max)
                max = array[i];
            if (array[i] > 0)
                countPositive++;
            else if (array[i] < 0)
                countNegative++;
            else
                countZero++;
        }
        showArray(array);
        System.out.printf("\nMax: %d\nMin: %d\nCount positive: %d\n" +
                "Count negative: %d\nCount zero: %d", max, min, countPositive, countNegative, countZero);

    }

    public static void task10() {
        int size = 20;
        int[] array = fillRandomArray(size);
        int countEven = 0,
                countNegative = 0,
                countZero = 0;

        for (int i = 0; i < size; i++) {
            if (array[i] < 0)
                countNegative++;
            else if (array[i] == 0)
                countZero++;
            if (array[i] % 2 == 0)
                countEven++;
        }

        int[] arrayEven = new int[countEven],
                arrayOdd = new int[size - countEven],
                arrayNegative = new int[countNegative],
                arrayPositive = new int[size - countNegative - countZero];

        int indexEven = 0,
                indexOdd = 0,
                indexNegative = 0,
                indexPositive = 0;

        for (int i = 0; i < size; i++) {
            if (array[i] % 2 == 0) {
                arrayEven[indexEven] = array[i];
                indexEven++;
            } else {
                arrayOdd[indexOdd] = array[i];
                indexOdd++;
            }
            if (array[i] > 0) {
                arrayPositive[indexPositive] = array[i];
                indexPositive++;
            } else if (array[i] < 0) {
                arrayNegative[indexNegative] = array[i];
                indexNegative++;
            }
        }
        System.out.print("All numbers: ");
        showArray(array);
        System.out.print("\nEven numbers: ");
        showArray(arrayEven);
        System.out.print("\nOdd numbers: ");
        showArray(arrayOdd);
        System.out.print("\nNegative numbers: ");
        showArray(arrayNegative);
        System.out.print("\nPositive numbers: ");
        showArray(arrayPositive);
    }

    public static void task11(Scanner scanner) {
        System.out.print("Enter line length: ");
        int length = scanner.nextInt();
        if (length < 1) {
            System.out.println("Invalid line length.");
            return;
        }

        System.out.print("Choose direction:" +
                "\n1.Horizontal" +
                "\n2.Vertical" +
                "\nOption: ");
        int direction = scanner.nextInt();
        boolean isHorizontalDirection;
        switch (direction) {
            case 1:
                isHorizontalDirection = true;
                break;
            case 2:
                isHorizontalDirection = false;
                break;
            default:
                System.out.println("Invalid direction option.");
                return;
        }
        System.out.print("Enter symbol: ");
        char symbol = scanner.next().charAt(0);

        showLine(length, isHorizontalDirection, symbol);

    }

    public static void task12(Scanner scanner) {
        int size = 10;
        int[] array = fillRandomArray(size);
        System.out.print("Choose sort direction:" +
                "\n1.Ascending" +
                "\n2.Descending" +
                "\nOption: ");
        int sortBy = scanner.nextInt();
        int[] sortedArray = array.clone();
        switch (sortBy) {
            case 1:
                sortArray(sortedArray, true);
                break;
            case 2:
                sortArray(sortedArray, false);
                break;
            default:
                System.out.println("Invalid sort direction.");
                return;
        }
        System.out.print("Array: ");
        showArray(array);
        System.out.print("\nSorted array: ");
        showArray(sortedArray);
    }


    public static void sortArray(int[] array, boolean isSortByAsc) {
        if (isSortByAsc) {
            for (int i = array.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (array[j] > array[j + 1]) {
                        int tmp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;
                    }
                }
            }
        } else {
            for (int i = array.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (array[j] < array[j + 1]) {
                        int tmp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;
                    }
                }
            }
        }
    }

    public static void showLine(int length, boolean isHorizontalDirection, char symbol) {
        if (isHorizontalDirection) {
            for (int i = 0; i < length; i++) {
                System.out.print(symbol);
            }
        } else {
            for (int i = 0; i < length; i++) {
                System.out.println(symbol);
            }
        }
    }

    public static void showArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
    }

    public static int[] fillRandomArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * (-30 - 30)) + 30;
        }
        return array;
    }
}
