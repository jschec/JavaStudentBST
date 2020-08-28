/**
 * Represents a single student in the enrollment records
 *
 * @author      Joshua Scheck
 * @version     2020-07-26
 */
public class Student implements Comparable<Student> {
    //----------------------------------------------------------------
    //      INSTANCE DATA
    //----------------------------------------------------------------
    /** unique identifier for this Student */
    private String id;
    /** full name of this Student */
    private String name;

    //----------------------------------------------------------------
    //      CONSTRUCTORS
    //----------------------------------------------------------------
    /**
     * Constructor for Student class
     *
     * @param   id      unique identifier for this Student
     * @param   name    full name for this Student
     */
    public Student(String id, String name) {
        setId(id);
        this.name = name;
    }

    /**
     * Retrieves the unique identifier for this Student
     *
     * @return      unique identifier for this Student
     */
    public String getId() {
        return this.id;
    }

    /**
     * Retrieves the full name for this Student
     *
     * @return      the full name for this Student
     */
    public String getName() {
        return this.name;
    }

    /**
     * Assigns a new unique identifier to this student
     *
     * @param   id  unique identifier for this student; must not be null 
     *              or empty
     */
    private void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException(
            "Student ID cannot be null or empty");
        }
        this.id = id;
    }

    /**
     * Compares this Student with another Student on the basis
     * of their ID. Order is determined Lexicographically.
     *
     * @param   otherStudent    another Student to compare
     * @return                  lexicographical determined order
     */
    @Override
    public int compareTo(Student otherStudent) {
        return id.compareTo(otherStudent.getId());
    }

    /**
     * Retrieves a String representation of this Student
     *
     * @return  String representation of this Student
     */
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + "'" +
                ", name='" + name + "'" +
                "}";
    }
}
