public class Member {
    private int memberID;
    private String name;
    private double height;


    //Constructs
    public Member(){}

    public Member(int memberID, String name, double height){
        this.memberID = memberID;
        this.name = name;
        this.height = height;
    }

    //Getters
    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }



    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }



    public double calculateMonthlyDues(){
        return 30.0;
    }

    @Override
    public String toString() {
        return "ID: " + memberID + " | Name: " + name;
    }
}
