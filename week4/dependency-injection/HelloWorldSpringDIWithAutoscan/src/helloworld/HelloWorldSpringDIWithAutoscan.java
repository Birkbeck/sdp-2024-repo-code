package helloworld;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class HelloWorldSpringDIWithAutoscan {

    public static void main(String... args) {
        // get the bean factory
        var factory = new ClassPathXmlApplicationContext("/beans.xml");
        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }
}
