public class StandardMember extends Member {


    public StandardMember(){}

    public StandardMember(int memberID, String name, double height) throws InvalidMemberDataException{
        super(memberID, name, height);
    }

    @Override
    public double calculateMonthlyDues() {
        return 30.0;
    }
}
