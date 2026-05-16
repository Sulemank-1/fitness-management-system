public class PremiumMember extends Member{
    private final double personalTrainerFee = 100;

    //Constructors
    public PremiumMember(){}

    public PremiumMember(int memberID, String name, double height) throws InvalidMemberDataException {
        super(memberID, name, height);
    }

    @Override
    public double calculateMonthlyDues(){
        return 30.0 + personalTrainerFee;
    }

    @Override
    public String toString(){
        return super.toString() + " Membership Type: Premium Member";
    }
}
