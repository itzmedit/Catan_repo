import java.util.Scanner;

public class Student {
   private String first_name, middle_name, last_name, suffix = "";
   
   String getFirstName() { return first_name; }
   String getMiddleName() { return middle_name; }
   String getLastName() { return last_name; }
   String getSuffix() { return suffix; }
   String getFullName() { return first_name + " " + middle_name + " " + last_name + " " + suffix ; }
   
   void setFirstName(String first_name) { this.first_name = first_name; }
   void setMiddleName(String middle_name) { this.middle_name = middle_name; }
   void setLastName(String last_name) { this.last_name = last_name; }
   void setSuffix(String suffix) { this.suffix = suffix; }
   
   static public void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      Student s = new Student();
      System.out.print("Enter your first name: ");
      s.setFirstName(scan.nextLine());
      System.out.print("Enter your middle name: ");
      s.setMiddleName(scan.nextLine());
      System.out.print("Enter your last name: ");
      s.setLastName(scan.nextLine());
      
      System.out.println("\nDo you have suffix: \n[1] Yes \n[2] No");
      int yn = scan.nextInt();
      switch(yn) {
         case 1:
            scan.nextLine();
            System.out.print("Enter your suffix: ");
            s.setSuffix(scan.nextLine());
            break;
      }
   
      System.out.println("\nSTUDENT'S PROFILE");
      System.out.println("First Name: " + s.getFirstName());
      System.out.println("Middle Name: " + s.getMiddleName());
      System.out.println("Last Name: " + s.getLastName());
      if (yn == 2) { System.out.println("Suffix: None"); }
      else { System.out.println("Suffix: " + s.getSuffix()); }
      System.out.println("Full Name: " + s.getFullName());  
   }   
}