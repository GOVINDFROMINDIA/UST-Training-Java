import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalGrade = 0;
        int numberOfGrades = 0;
        String gradeLetter = "";

        while (true) {
            try {
                System.out.print("Enter student's grade (or 'done' to finish): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("done")) {
                    break;
                }

                double grade = Double.parseDouble(input);

                if (grade < 0 || grade > 100) {
                    throw new IllegalArgumentException("Grade must be between 0 and 100");
                }

                totalGrade += grade;
                numberOfGrades++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (numberOfGrades > 0) {
            double averageGrade = totalGrade / numberOfGrades;
            gradeLetter = determineGradeLetter(averageGrade);
            System.out.printf("Average Grade: %.2f\nGrade Letter: %s\n", averageGrade, gradeLetter);
        } else {
            System.out.println("No grades entered.");
        }
    }

    private static String determineGradeLetter(double averageGrade) {
        if (averageGrade >= 90) {
            return "A";
        } else if (averageGrade >= 80) {
            return "B";
        } else if (averageGrade >= 70) {
            return "C";
        } else if (averageGrade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
