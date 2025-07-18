package com.learn.demo;

import com.learn.demo.Utils.EmptyImpl;
import com.learn.demo.Utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Validators {
    @Autowired // Spring会自动把所有类型为Validator的Bean装配为一个List注入进来
    List<Validator> validators;

    /**
     * @Autowired 当找不到类型为EmptyImpl的bean时，会报NoSuchBeanDefinitionException异常
     * 可以给@Autowired增加参数required=false解决,
     * 这个参数告诉Spring容器，如果找到一个类型为EmptyImpl的Bean，就注入，如果找不到，就忽略。
     */
    @Autowired(required = false)
    List<EmptyImpl> empties;



    public Boolean validate(String email, String password, String name) {
        boolean valid = true;
        for (Validator validator :
                validators) {
            try {
                validator.validate(email, password, name);
            } catch (Exception e) {
                e.printStackTrace();
                valid = false;
                break;
            }
        }
        return valid;
    }
}
