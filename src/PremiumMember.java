public class PremiumMember extends Member{
    private final double personalTrainerFee = 100;

    //Constructor
    public PremiumMember(int memberID, String name, double height){
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
