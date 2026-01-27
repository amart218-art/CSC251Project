import java.util.Scanner;

public class Project_jalex_martinez
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);

      int policyNumber = getPolicyNumber(keyboard);
      String providerName = getProviderName(keyboard);
      String firstName = getFirstName(keyboard);
      String lastName = getLastName(keyboard);
      int age = getAge(keyboard);
      String smokingStatus = getSmokingStatus(keyboard);
      double height = getHeight(keyboard);
      double weight = getWeight(keyboard);

      Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                 age, smokingStatus, height, weight);

      System.out.println();
      displayPolicy(policy);
   }

   public static int getPolicyNumber(Scanner keyboard)
   {
      System.out.print("Please enter the Policy Number: ");
      return readInt(keyboard);
   }

   public static String getProviderName(Scanner keyboard)
   {
      System.out.print("Please enter the Provider Name: ");
      return keyboard.nextLine();
   }

   public static String getFirstName(Scanner keyboard)
   {
      System.out.print("Please enter the Policyholder's First Name: ");
      return keyboard.nextLine();
   }

   public static String getLastName(Scanner keyboard)
   {
      System.out.print("Please enter the Policyholder's Last Name: ");
      return keyboard.nextLine();
   }

   public static int getAge(Scanner keyboard)
   {
      int age;
      System.out.print("Please enter the Policyholder's Age: ");
      age = readInt(keyboard);

      while(age < 0)
      {
         System.out.print("Age must not be negative. Enter again: ");
         age = readInt(keyboard);
      }

      return age;
   }

   public static String getSmokingStatus(Scanner keyboard)
   {
      String status;

      System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
      status = keyboard.nextLine().trim();

      while(!status.equalsIgnoreCase("smoker") && !status.equalsIgnoreCase("non-smoker"))
      {
         System.out.print("Please type exactly smoker or non-smoker: ");
         status = keyboard.nextLine().trim();
      }

      return status;
   }

   public static double getHeight(Scanner keyboard)
   {
      double height;

      System.out.print("Please enter the Policyholder's Height (in inches): ");
      height = readDouble(keyboard);

      while(height <= 0)
      {
         System.out.print("Height must be greater than 0. Enter again: ");
         height = readDouble(keyboard);
      }

      return height;
   }

   public static double getWeight(Scanner keyboard)
   {
      double weight;

      System.out.print("Please enter the Policyholder's Weight (in pounds): ");
      weight = readDouble(keyboard);

      while(weight <= 0)
      {
         System.out.print("Weight must be greater than 0. Enter again: ");
         weight = readDouble(keyboard);
      }

      return weight;
   }

   public static int readInt(Scanner keyboard)
   {
      while(!keyboard.hasNextInt())
      {
         System.out.print("Numbers only. Try again: ");
         keyboard.nextLine();
      }
      int value = keyboard.nextInt();
      keyboard.nextLine(); 
      return value;
   }

   public static double readDouble(Scanner keyboard)
   {
      while(!keyboard.hasNextDouble())
      {
         System.out.print("Numbers only (example: 250.5). Try again: ");
         keyboard.nextLine();
      }
      double value = keyboard.nextDouble();
      keyboard.nextLine();
      return value;
   }

   public static void displayPolicy(Policy p)
   {
      System.out.println("Policy Number: " + p.getPolicyNumber());
      System.out.println("Provider Name: " + p.getProviderName());
      System.out.println("Policyholder's First Name: " + p.getFirstName());
      System.out.println("Policyholder's Last Name: " + p.getLastName());
      System.out.println("Policyholder's Age: " + p.getAge());
      System.out.println("Policyholder's Smoking Status: " + p.getSmokingStatus());
      System.out.printf("Policyholder's Height: %,.1f inches\n", p.getHeight());
      System.out.printf("Policyholder's Weight: %,.1f pounds\n", p.getWeight());
      System.out.printf("Policyholder's BMI: %,.2f\n", p.calculateBMI());
      System.out.printf("Policy Price: $%,.2f\n", p.calculatePolicyPrice());
   }
}