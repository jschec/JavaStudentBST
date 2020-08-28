import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main class demonstrating Search tree set using student enrollment records
 */
public class Main {
    /** enrollment file path */
    public static final String ENROLLMENT_FILE = System.getProperty("user.dir") 
    + "/" + "2020Summer.txt";
    /** enables print statements for debugging */
    public static final boolean VERBOSE = false;

    /**
     * Opens the specified student enrollment file and adds unique
     * students to a Search tree set.
     *
     * Note that each row of enrollment file has the following format:
     * ClassID#StudentId#StudentName#StudentGrade
     *
     * @param   enrollFile  path to student enrollment file
     * @return              Search tree set with enrollment data
     */
    private static SearchTreeSet<Student> loadEnrollmentData(File enrollFile) {
        SearchTreeSet<Student> studentEnrollment = new SearchTreeSet<Student>();
        try {
            Scanner in = new Scanner(enrollFile);
            while (in.hasNextLine()) {
                String enrollmentLine = in.nextLine();
                String[] enrollmentLineData = enrollmentLine.split("#");
                String studentId = enrollmentLineData[1];
                String studentName = enrollmentLineData[2];
                studentEnrollment.add(new Student(studentId, studentName));
            }
        } catch (FileNotFoundException e) {
            if (VERBOSE) {
                System.out.println(e.getLocalizedMessage());
            }
        }
        return  studentEnrollment;
    }

    /**
     * Entry point for application. Initiates demonstration of Search tree set 
     * features
     *
     * @param   args    supplied command line arguments
     */
    public static void main(String[] args) {
        SearchTreeSet<Student> studentEnrollment = loadEnrollmentData(
        new File(ENROLLMENT_FILE));
        System.out.println();
        System.out.println("Total nodes in student enrollment search tree: " 
        + studentEnrollment.countNodes());
        System.out.println();
        System.out.println("=============================================");
        System.out.println("In-order list (ascending by ID):");
        System.out.println("=============================================");
        System.out.println();
        System.out.println(studentEnrollment.getInOrderList(true));
        System.out.println();
        System.out.println("=============================================");
        System.out.println("Reverse in-order list (descending by ID):");
        System.out.println("=============================================");
        System.out.println();
        System.out.println(studentEnrollment.getInOrderList(false));
    }
}
