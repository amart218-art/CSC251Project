import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Project_jalex_martinez
{
   public static void main(String[] args) throws IOException
   {
      Locale.setDefault(Locale.US);

      ArrayList<Policy> policies = new ArrayList<Policy>();

      File file = new File("PolicyInformation.txt");
      Scanner inputFile = new Scanner(file);
      inputFile.useLocale(Locale.US);

      while(inputFile.hasNext())
      {
         int policyNumber = inputFile.nextInt();
         inputFile.nextLine();

         String providerName = inputFile.nextLine();
         String firstName = inputFile.nextLine();
         String lastName = inputFile.nextLine();

         int age = inputFile.nextInt();
         inputFile.nextLine();

         String smokingStatus = inputFile.nextLine();

         double height = inputFile.nextDouble();
         double weight = inputFile.nextDouble();

         if(inputFile.hasNextLine())
            inputFile.nextLine();

         Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                    age, smokingStatus, height, weight);

         policies.add(policy);
      }

      inputFile.close();

      int smokerCount = 0;
      int nonSmokerCount = 0;

      for(int i = 0; i < policies.size(); i++)
      {
         Policy p = policies.get(i);

         // Step 6: implicit toString call
         System.out.println(p);
         System.out.println();

         if(p.getPolicyHolder().getSmokingStatus().equalsIgnoreCase("smoker"))
            smokerCount++;
         else
            nonSmokerCount++;
      }

      // Step 7 output:
      System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
      System.out.println("The number of policies with a smoker is: " + smokerCount);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
   }
}