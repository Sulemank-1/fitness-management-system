import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GymManager {
     private ArrayList<Member> members;
     private String gymName;
     private final int TOTAL_CAPACITY = 100;

     public GymManager(String gymName){
         this.gymName = gymName;
         members = new ArrayList<>();
     }

     public void addMember(Member m){
         if (members.size() >= TOTAL_CAPACITY)
             System.out.println("Members full");
         else {
             for (Member member : members)
                 if (member.getMemberID() == m.getMemberID()) {
                     System.out.println("Member already exists");
                     return;
                 }

             members.add(m);
         }
     }

     public boolean removeMember(int memberID){
         for (Member member: members)
             if (member.getMemberID() == memberID){
                 members.remove(member);
                 return true;
             }

         return false;
     }

    public Member findMember(int memberID){
        for (Member member: members)
            if (member.getMemberID() == memberID)
                return member;

        return null;
    }

    public double calculateTotalRevenue(){
         double sum = 0.0;
         for (Member member: members)
            sum += member.calculateMonthlyDues();

         return sum;
    }

    public int getMemberCount(){
         return members.size();
    }

    public void displayAllMembers(){
         ArrayList<Member> sortedList = new ArrayList<>(members);
         Collections.sort(sortedList);
         for (Member member: sortedList)
            System.out.println(member);
    }

    public void saveMembersToFile(String filename) {

         try (PrintWriter output = new PrintWriter(filename)) {
            for (Member m : members) {
                if (m instanceof StudentMember) {
                    StudentMember sm = (StudentMember) m;
                    output.println("STUDENT," + sm.getMemberID() + "," + sm.getName() + "," + sm.getHeight() + "," + sm.getSchoolName());
                } else if (m instanceof PremiumMember)
                    output.println("PREMIUM," + m.getMemberID() + "," + m.getName() + "," + m.getHeight());
                else if (m instanceof StandardMember) {
                    output.println("STANDARD," + m.getMemberID() + "," + m.getName() + "," + m.getHeight());
                }
            }
            System.out.println("All members successfully saved to " + filename);
        } catch (IOException e) {
            System.out.println("System Error: Could not save data to file. " + e.getMessage());
        }
    }

    public void loadMembersFromFile(String filename) {
         File file = new File(filename);
         if (!file.exists()) {
             System.out.println("No existing record file found.");
             return;
         }

         try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] tokens = line.split(",");

                String type = tokens[0];
                int id = Integer.parseInt(tokens[1]);
                String name = tokens[2];
                double height = Double.parseDouble(tokens[3]);

                switch (type) {
                    case "STUDENT":
                        String school = tokens[4];
                        this.addMember(new StudentMember(id, name, height, school));
                        break;
                    case "PREMIUM":
                        this.addMember(new PremiumMember(id, name, height));
                        break;
                    case "STANDARD":
                        this.addMember(new StandardMember(id, name, height));
                        break;
                }
            }
            System.out.println("Data successfully loaded from " + filename);
        } catch (Exception e) {
            System.out.println("System Error: File reading failed" + e.getMessage());
        }
    }

}
