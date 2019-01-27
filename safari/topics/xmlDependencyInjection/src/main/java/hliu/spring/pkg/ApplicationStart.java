package hliu.spring.pkg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationStart {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("Beans.xml");

        Point pointTen = (Point)applicationContext.getBean("pointTen");
        System.out.println(pointTen.getX());
        System.out.println(pointTen.getY());

    }

}
