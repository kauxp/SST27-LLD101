import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        UserProfile p2 = new UserProfile.Builder().setId("u1").setEmail("a@b.com").build();
        System.out.println("Email: " + p2.getEmail());
        // p.setEmail("evil@example.com"); // demonstrates mutability problem
        System.out.println("=> In the solution, this setter disappears and object becomes immutable.");
    }
}
