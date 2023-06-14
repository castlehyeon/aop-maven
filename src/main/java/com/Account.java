package com;

import lombok.Data;

//서비스 메서드에서 메서드 인수로 사용
@Data
public class Account {
    private String accountNumber;
    private double balance;
}
