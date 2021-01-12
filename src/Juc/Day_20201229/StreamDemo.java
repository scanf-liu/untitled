package Juc.Day_20201229;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Accessors(chain = true)
class User
{
    private Integer id;
    private String userName;
    private int age;
}

public class StreamDemo {
    public static void main(String[] args) {
        //User u1 = new User(11,"a",23);
        //User u2 = new User(12,"a",24);
        ////User u3 = new User(13,"a",22);
        //User u4 = new User(14,"a",28);
        //User u5 = new User(16,"a",26);

        //List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
    }
}
