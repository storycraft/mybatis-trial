package sh.pancake;

import java.io.InputStream;
import java.sql.Timestamp;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sh.pancake.database.User;
import sh.pancake.database.UserRepository;

public class App {

    public static void main(String[] args) throws Throwable {
        try (InputStream configStream = App.class.getResourceAsStream("/mybatis.xml")) {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                    .build(configStream);

            try (SqlSession session = sessionFactory.openSession(true)) {
                UserRepository userRepo = session.getMapper(UserRepository.class);

                User exampleUser = new User(
                        0,
                        "example@example.com",
                        "f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b", // sha256(asdf)
                        null,
                        null,
                        new Timestamp(System.currentTimeMillis()),
                        "exampleUser",
                        null,
                        0);

                userRepo.insert(exampleUser);
                long newUserId = exampleUser.getId();

                System.out.printf("Inserted new user id: %d\n", newUserId);
                System.out.println("=====");

                System.out.println("Displaying user list");
                
                for (User user : userRepo.getAllUsers()) {
                    System.out.printf("id: %d, %s\n", user.getId(), user);
                }

                System.out.println("=====");

                String newUserProfileName = "exampleUser2";
                if (userRepo.updateProfileName(newUserId, newUserProfileName) > 0) {
                    System.out.printf("id: %d profile_name updated to %s\n", newUserId, newUserProfileName);
                }

                System.out.println("=====");

                if (userRepo.removeUser(newUserId) > 0) {
                    System.out.printf("Removed user %d\n", newUserId);
                }
                System.out.println("=====");
            }
        }
    }
}
