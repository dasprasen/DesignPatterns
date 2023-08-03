package com.design.builder;

/**
 * @author Prasenjit Kumar Das
 */
public class Account {
    private final long id;
    private final String name;
    private final int amount;

    private Account(Builder builder){

        this.id = (builder.id==0L) ? 10L : builder.id;
//        if(builder.id==0L){
//            this.id=10L;
//        } else {
//            this.id=builder.id;
//        }
        //this.id = builder.id;
        this.name = builder.name;
        this.amount = builder.amount;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public static class Builder{
        private long id=0L;
        private String name="ram";
        private int amount=1000;

        public Builder id(final long id){
            this.id=id;
            return this;
        }

        public Builder name(final String name){
            this.name=name;
            return this;
        }

        public Builder amount(final int amount){
            this.amount=amount;
            return this;
        }
        public Account build(){
            return new Account(this);
        }
    }
}
