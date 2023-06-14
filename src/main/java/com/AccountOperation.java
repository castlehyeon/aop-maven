package com;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//create an AccountOperation annotation
//use it as the pointcut
@Target(ElementType.METHOD)
//@AccountOperation 어노테이션은 메소드에 적용
@Retention(RetentionPolicy.RUNTIME)

public @interface AccountOperation {
    String operation();
    //어노테이션이 적용된 메소드의 작업 또는 동작을 설명하는 문자열 값을 저장
}
