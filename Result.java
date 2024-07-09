import java.util.Scanner;

public class Result {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            //Displays the menu
            System.out.println("\n--- Menu ---");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourseworkResults();
                    break;
                case 2:
                    viewExamResults();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    //Counts the number of coursework assessments
    public static int countCourseworkAssessments(double[] assessments) {
        int count = 0;
        for (double assessment : assessments) {
            if (assessment != -1) {
                count++;
            }
        }
        return count;
    }

    //Checks whether the student has completed 2/3 of the coursework
    public static boolean checkCourseworkCompletion(int assessmentsDone) {
        int totalAssessments = 5;
        double requiredAssessments = (2.0 / 3.0) * totalAssessments;
        return assessmentsDone >= requiredAssessments;
    }

    // A function to view coursework results
    public static void viewCourseworkResults() {
        Scanner scanner = new Scanner(System.in);
        double[] assessments = new double[5];

        assessments[0] = getInput(scanner, "Enter the marks for ass1 (or press Enter if not done): ");
        assessments[1] = getInput(scanner, "Enter the marks for ass2 (or press Enter if not done): ");
        assessments[2] = getInput(scanner, "Enter the marks for ass3 (or press Enter if not done): ");
        assessments[3] = getInput(scanner, "Enter the marks for cat1 (or press Enter if not done): ");
        assessments[4] = getInput(scanner, "Enter the marks for cat2 (or press Enter if not done): ");

        double coursework = 0;
        for (double assessment : assessments) {
            if (assessment != -1) {
                coursework += assessment;
            }
        }

        int assessmentsDone = countCourseworkAssessments(assessments);
        boolean completed = checkCourseworkCompletion(assessmentsDone);

        System.out.println("Coursework Results: " + coursework + " out of 50");
        if (completed) {
            System.out.println("Student has completed at least 2/3 of the coursework.");
        } else {
            System.out.println("Student has NOT completed 2/3 of the coursework. Student needs to repeat the coursework.");
        }
    }

    // A function to view exam results
    public static void viewExamResults() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the marks for the final exam: ");
        double finalExam = scanner.nextDouble();

        double totalScore = finalExam + 50; // Assuming coursework is already 50
        System.out.println("Final Exam Results: " + finalExam + " out of 50");
        System.out.println("Total Score: " + totalScore + " out of 100");
    }

    // A function that gets user input or return -1 if no input is given
    public static double getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return -1; // Special value to indicate no input
        } else {
            return Double.parseDouble(input);
        }
    }
}