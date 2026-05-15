import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GymManager gym = new GymManager("Arnold Gym");

        gym.addMember(new Member(1, "john", 165));
        gym.addMember(new Member(2, "ali", 175));

        gym.displayAllMembers();

        gym.addMember(new Member(3, "allison", 160));

    }
}