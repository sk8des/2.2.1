package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1;

        user1 = new User("User1", "Lastname1", "user1@mail.ru");
        user1.setCar(new Car("Lincoln Town Car", 1989));
        userService.add(user1);

        user1 = new User("User2", "Lastname2", "user2@mail.ru");
        user1.setCar(new Car("Cadillac Escalade", 2015));
        userService.add(user1);

        user1 = new User("User3", "Lastname3", "user3@mail.ru");
        user1.setCar(new Car("Mercedes-Benz SL", 1951));
        userService.add(user1);

        user1 = new User("User4", "Lastname4", "user4@mail.ru");
        user1.setCar(new Car("Rolls-Royce Phantom", 2016));
        userService.add(user1);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id: " + user.getId());
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Car: " + user.getCar().toString());
            System.out.println();
        }

        System.out.println(userService.userOfCar("Rolls-Royce Phantom", 2016).toString());

        context.close();
    }
}
