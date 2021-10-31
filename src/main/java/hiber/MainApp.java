package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.util.List;

public class MainApp {

//   public static void main(MysqlxDatatypes.Scalar.String[] args) throws SQLException s{
      public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User testUser1 =new User("User1", "Lastname1", "user1@mail.ru");
      testUser1.setCar(new Car("Tesla Model",10));
//      testUser1.setCar(new Car("BMW",5));
      userService.add(testUser1);

      User testUser2 =new User("User2", "Lastname2", "user2@mail.ru");
      testUser2.setCar(new Car("BMW",5));
//      testUser2.setCar(new Car("Tesla Model",10));
      userService.add(testUser2);

      User testUser3 =new User("User3", "Lastname3", "user3@mail.ru");
      testUser3.setCar(new Car("Car",3));
      userService.add(testUser3);

      User testUser4 =new User("User4", "Lastname4", "user4@mail.ru");
      testUser4.setCar(new Car("Car",4));
      userService.add(testUser4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar().toString());
         System.out.println();
      }

          System.out.println(userService.getUserByCar("BMW",5).toString());

      context.close();
   }
}
