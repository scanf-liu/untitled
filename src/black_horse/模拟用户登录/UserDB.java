package black_horse.模拟用户登录;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User("zzz", "12345"));
        users.add(new User("qqq", "12345"));
        users.add(new User("ccc", "1234"));
    }

    public static List<User> getUsers() {
        return users;
    }
}
