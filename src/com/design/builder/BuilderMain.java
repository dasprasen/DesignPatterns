package com.design.builder;

/**
 * @author Prasenjit Kumar Das
 */
public class BuilderMain {
    public static void main(String[] args){
        Account account = new Account.Builder().id(1).name("prasen").amount(10000).build();
        System.out.println(account.getId() +" "+account.getName()+ " "+account.getAmount());

        Account account1 = new Account.Builder().id(2).name("jeet").build();
        System.out.println(account1.getId()+" "+account1.getName());

        Account account3 = new Account.Builder().build();
        System.out.println(account3.getId()+" "+account3.getName()+" "+account3.getAmount());

        final long res = 0;
        System.out.println(res);
    }
}
