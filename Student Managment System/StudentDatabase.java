import java.util.Scanner;

public class StudentDatabase {
   private static int AllStudent=100;
   private static String [] StudentNames = new  String[AllStudent];
   private static int [] StudentGrades = new  int[AllStudent];

   public static  int Students = 0;

   public static void main(String[] args) {
    // with while loop and looping the user inputs
    while (true) {
        Scanner In = new Scanner(System.in);

        System.out.println("Student management system");
        System.out.println("********************************");
        System.out.println("1. Add Student Details :");
        System.out.println("2. Display all students Details:");
        System.out.println("3. Search students Details:");
        System.out.println("4. Total average :");
        System.out.println("5. Sorted grade :");
        System.out.println("6. Highest grade :");
        System.out.println("7. Lowest grade :");
        System.out.println("8. Update student :");
        System.out.println("9. Remove student :");
        System.out.println("....................................");
        System.out.print("Your choice here: ");
        int choice = In.nextInt();
        switch (choice) {
            case 1:
                addStudents();
                break;
            case 2:
                displayAllStudents();
                break;
            case 3:
                searchStudentsByName();
                break;
            case 4:
                calculateAverageGrade();
                break;
            case 5:
                sortStudentByGrade();
                break;
            case 6:
                findHighestGradeStudent();
                break;
            case 7:
                findLowestGradeStudent();
                break;
            case 8:
                updateStudentGrade();
                break;
            case 9:
                removeStudent();
                break;
            default:
                break;
        }

    }
  }

    public static void addStudents(){
        Scanner In=new Scanner(System.in);
        if(AllStudent == Students){
          resizeArrays();
        }
        System.out.println("Enter Student Name:");
          String name = In.next();

          System.out.println("Enter Student Grades:");
          int grade = In.nextInt();

          StudentNames[Students] = name;
          StudentGrades[Students] = grade;
          Students++;
    }

    public static void displayAllStudents(){
        if(Students== 0){
            System.out.println("not found");
        }
        else{
            for(int i=0;i<Students; i++){
            System.out.println("Student Name:  "+StudentNames[i] +" "+"Student Grades:  "+StudentGrades[i]);
            }
        }
        }
       public static void searchStudentsByName(){
        Scanner In =new Scanner(System.in);
        System.out.println("Enter Student Name:");
         String name = In.next();
         boolean found = false;
         for(int i=0;i<Students; i++){
             if(StudentNames[i].equals(name)){
                 System.out.println("Student Name"+StudentNames[i] +" "+"Student Grades"+StudentGrades[i]);
                 found = true;
             }
             if(!found){
              System.out.println("");
              System.out.println("");
              System.out.println("Not User");
             }

         }
       }
    public static void calculateAverageGrade(){
        int sum = 0;
        for(int i=0;i<Students; i++){
            sum = sum + StudentGrades[i];
        }
        double average = sum/Students;
        System.out.println("Average Grade:"+average);
    }
    public static void sortStudentByGrade() {
        
        if (Students == 0) {
            System.out.println("No students or grade here");
        }
        for (int i = 0; i < Students - 1; i++) {
            for (int j = 0; j < Students - 1; j++) {
                if (StudentGrades[i] > StudentGrades[j + 1]) {
                    int tempGrade = StudentGrades[i];
                    StudentGrades[i] = StudentGrades[i + 1];
                    StudentGrades[i + 1] = tempGrade;

                    String tempName = StudentNames[i];
                    StudentNames[i] = StudentNames[i + 1];
                    StudentNames[i + 1] = tempName;

                }
            }
            System.out.println("Sorted grade ");
            
            for (int k = 0; k < Students; k++) {
                System.out.println(StudentNames[i] + " " + StudentNames[i]);
            }
        }
    }
    public static void findHighestGradeStudent() {
        if (Students == 0) {
            System.out.println("No students here");
        }
        int i;

        int highestGrade = StudentGrades[0];
        String highestName = StudentNames[0];

        for (i = 0; i < Students; i++) {
            if (StudentGrades[i] > highestGrade) {
                highestGrade = StudentGrades[i];
                highestName = StudentNames[i];

            }
        }

        System.out.println(highestName + " " + "student have highest " + highestGrade);
    }
    public static void findLowestGradeStudent() {
        if (Students == 0) {
            System.out.println("No students here");
        }
        int i;

        int lowestGrade = StudentGrades[0];
        String lowestName = StudentNames[0];

        for (i = 0; i <Students; i++) {
            if (StudentGrades[i] < lowestGrade) {
                lowestGrade =StudentGrades[i];
                lowestName = StudentNames[i];

            }
        }

        System.out.println(lowestName + " " + "student have lowest " + lowestGrade);
    }
    public static void updateStudentGrade() {
        Scanner In = new Scanner(System.in);
        System.out.println("Enter Student Name:");
        String name = In.next();
        boolean found = false;
        for(int i=0;i<Students; i++){
            if(StudentNames[i].equals(name)){
                System.out.println("Enter Student Grades:");
                int grade = In.nextInt();
                StudentGrades[i] = grade;
                found = true;
                System.out.println("updated user grade " + StudentGrades[i]);
            }
            if(!found){
                System.out.println("");
                System.out.println("");
                System.out.println("Not User");
            }
    }
 }
public static void removeStudent(){
    Scanner In = new Scanner(System.in);
        System.out.println("Enter name to remove :");

        String name = In.nextLine();
        int i;
        boolean found = true;
        for (i = 0; i <Students; i++) {
            if (StudentNames[i].equalsIgnoreCase(name)) {
                for (int j = i; j < Students - 1; j++) {
                    StudentNames[j] = StudentNames[j + 1];
                    StudentGrades[j] = StudentGrades[j + 1];
                }
                Students--;
                found = true;
                System.out.println("Student removed " + StudentNames[i]);
            }
        }
        if (!found) {
            System.out.println("Student not found");
        }
    }

  private static void resizeArrays() {
    int newCapacity = StudentNames.length * 10;
    String[] newNames = new String[newCapacity];
    int[] newGrades = new int[newCapacity];
    System.arraycopy(StudentNames, 0, newNames, 0, Students);
    System.arraycopy(StudentGrades, 0, newGrades, 0, Students);
    StudentNames = newNames;
    StudentGrades = newGrades;
  }

}


