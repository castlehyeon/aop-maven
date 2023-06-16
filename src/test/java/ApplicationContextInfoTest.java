import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ApplicationContextInfoTest {

    @Autowired
    DefaultListableBeanFactory bf;

    @Test
    public void beans(){
        for(String n : bf.getBeanDefinitionNames()){
            System.out.println(n + " \t" + bf.getBean(n).getClass().getName());
        }
    }
}