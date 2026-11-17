//https://github.com/prussia2017-maker/COSC_CGPS.git

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxCGPA {
    public static void main(String[] args) {
        // Specify the input file name
        File file = new File("students.txt");

        String topStudent = "";
        double maxCGPA = -1.0;

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                // Skip any empty lines
                if (line.isEmpty()) {
                    continue;
                }

                // Split at the last space to support full names (e.g., "Jane Doe 3.85")
                int lastSpaceIndex = line.lastIndexOf(' ');
                if (lastSpaceIndex != -1) {
                    String studentName = line.substring(0, lastSpaceIndex).trim();
                    double cgpa = Double.parseDouble(line.substring(lastSpaceIndex + 1).trim());

                    if (cgpa > maxCGPA) {
                        maxCGPA = cgpa;
                        topStudent = studentName;
                    }
                }
            }

            if (maxCGPA >= 0) {
                System.out.printf("Highest CGPA: %.2f (Student: %s)%n", maxCGPA, topStudent);
            } else {
                System.out.println("No valid student records found in the file.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Make sure 'students.txt' is in the project directory.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid CGPA format detected in the file.");
        }
    }
}
