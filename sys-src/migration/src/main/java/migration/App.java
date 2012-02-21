package migration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;


/**
 * Hello world!
 */
public class App {
    @Autowired
    public static void main(String[] args) {

        // PREPARE
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        // of course, an ApplicationContext is just a BeanFactory
        BeanFactory factory = (BeanFactory) appContext;

        // Initialize
        Helper helper = new Helper();
        JournalMigration jmigration = new JournalMigration(factory, helper);
        
        // /run
        jmigration.run();

    }


}
