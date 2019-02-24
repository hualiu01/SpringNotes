package hliu.spring.pkg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationStart {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("Beans.xml");

        Point pointTen = (Point)applicationContext.getBean("pointIntAuto");
        System.out.println(pointTen.toString());

        Point pointFloat = (Point)applicationContext.getBean("pointFloatAuto");
        System.out.println(pointFloat.toString());

        Point pointCastFloat = (Point)applicationContext.getBean("pointCastFloat");
        System.out.println(pointCastFloat.toString());

        Color.printAllColors();
        Color gray = Color.GRAY;
        System.out.println("Color.GRAY rgb value: " + gray.toRGB());
        Boolean withHashTag = Boolean.TRUE;
        System.out.println("Color.GRAY Hex Str: " + gray.toHexString(withHashTag));

        ColorPoint grayPoint = (ColorPoint)applicationContext.getBean("grayPoint");
        System.out.println(grayPoint.toString());

        ColorPoint blackPoint = (ColorPoint)applicationContext.getBean("blackPoint");
        System.out.println(blackPoint.toString());

        // Below through exp: can't find bean. Out of scope
        // Color black = (Color)applicationContext.getBean("BLACK");
    }

}
