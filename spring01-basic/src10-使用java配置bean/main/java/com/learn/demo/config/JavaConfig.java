package com.learn.demo.byJava.config;

import com.learn.demo.byJava.model.Author;
import com.learn.demo.byJava.model.Book;
import com.learn.demo.byJava.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Configuration 表示这个类是一个配置类，作用类似于applicationContext.xml
 */
@Configuration
public class JavaConfig {
    /**
     * @Bean 向spring容器中注入一个bean，@Bean的参数可以指定bean的id，默认使用方法名作为id
     * 默认是单例的，可以使用@Scope("prototype")指定为多例模式
     */
    @Bean
    @Scope("prototype")
    User user1() {
        User user = new User();
        user.setUsername("Tom");
        user.setAddress("beijing");
        return user;
    }

    /**
     * 注册一个复杂对象，即注册一个对象，该对象的属性值还是对象
     */
    // 1. 先注册引用
    @Bean
    Author author() {
        Author author = new Author();
        author.setUsername("吴承恩");
        author.setAge(55);
        return author;
    }
    // 2. 注册被引用的对象
    @Bean
    Book book(Author author) { // Author author会先扫描spring容器是否存在该bean
        Book book = new Book();
        book.setName("西游记");
        book.setPrice(35.0);
        /**
         * 当前类为@Configuration配置类时：
         *  可以直接调用注册bean的方法名获取spring容器中的bean
         *  -> 因为@Configuration有拦截功能，当前类中的方法如果调用了当前类的方法，不会直接执行
         *     而是先到spring容器中先查找有没有对应的bean，有则直接引用，没有才会调用方法。
         *
         * 当前类为@Component类时：
         *  需要使用参数来获取spring容器中的bean
         *  -> 因为@Bean注册bean时，spring容器会自动查找方法需要用到的参数
         */
        book.setAuthor(author()); // 适用于@Configuration
        book.setAuthor(author); // 适用于@Component
        return book;
    }
}
