/**
 * The Policy class represents an insurance policy and contains information
 * about the policy and a PolicyHolder object.
 */
public class Policy
{
   private int policyNumber;
   private String providerName;
   private PolicyHolder policyHolder;

   private static int policyCount = 0;

   public Policy()
   {
      policyNumber = 0;
      providerName = "";
      policyHolder = new PolicyHolder();
      policyCount++;
   }

   public Policy(int pNum, String prov, String fName, String lName,
                 int theAge, String smoke, double h, double w)
   {
      policyNumber = pNum;
      providerName = prov;
      policyHolder = new PolicyHolder(fName, lName, theAge, smoke, h, w);
      policyCount++;
   }

   public int getPolicyNumber() { return policyNumber; }
   public String getProviderName() { return providerName; }

   public void setPolicyNumber(int pNum) { policyNumber = pNum; }
   public void setProviderName(String prov) { providerName = prov; }

   public PolicyHolder getPolicyHolder()
   {
      return policyHolder;
   }

   public static int getPolicyCount()
   {
      return policyCount;
   }

   public double calculatePolicyPrice()
   {
      double price = 600.0;

      if(policyHolder.getAge() > 50)
         price += 75.0;

      if(policyHolder.getSmokingStatus() != null &&
         policyHolder.getSmokingStatus().equalsIgnoreCase("smoker"))
         price += 100.0;

      double bmi = policyHolder.calculateBMI();
      if(bmi > 35.0)
         price += (bmi - 35.0) * 20.0;

      return price;
   }

   public String toString()
   {
      return "Policy Number: " + policyNumber +
             "\nProvider Name: " + providerName +
             "\n" + policyHolder.toString() +
             "\nPolicy Price: $" + String.format("%.2f", calculatePolicyPrice());
   }
}