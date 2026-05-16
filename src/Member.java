public abstract class Member {
    private int memberID;
    private String name;
    private double height;


    //Constructs
    protected Member() {
    }

    protected Member(int memberID, String name, double height) throws InvalidMemberDataException {
        if (height <= 0)
            throw new InvalidMemberDataException("Height must be greater than 0");

        if (name == null || name.trim().isEmpty())
            throw new InvalidMemberDataException("Name cannot be empty");
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

    public abstract double calculateMonthlyDues();

    @Override
    public String toString() {
        return "ID: " + memberID + " | Name: " + name;
    }
}
