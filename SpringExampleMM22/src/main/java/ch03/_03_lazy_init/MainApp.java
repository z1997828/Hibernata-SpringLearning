package ch03._03_lazy_init;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext context = 
        		new AnnotationConfigApplicationContext();
        context.scan("ch03._03_lazy_init");
        context.refresh();
        System.out.println("--------------容器初始化完畢---------------------");
        pause();    // 暫停執行以利觀察
        System.out.println("-------開始取出Student物件-------");
        Student mary = (Student) context.getBean("student");
        System.out.println("Student: " + mary);
        context.close();
    }
    private static void pause() {
        try {
            Thread.sleep(5000);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }        
    }    
}

