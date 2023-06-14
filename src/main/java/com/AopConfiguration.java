//package com.baeldung.method.info;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//@Configuration
//@EnableAspectJAutoProxy
//@ComponentScan(basePackages = "com.baeldung.method.info")
//public class AopConfiguration {
//    @Bean
//    BankAccountServiceInterface bankAccountServiceInterface(){
//        return new BankAccountService();
//    }
//
//    @Bean
//    BankAccountAspect bankAccountAspect(){
//        return new BankAccountAspect();
//    }
//
//}
package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com")
public class AopConfiguration {
}