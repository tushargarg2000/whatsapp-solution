package com.driver;

public class User {
    private String name;
    private String mobile;

    public User(){

    }

    User(String name,String mobile){
        this.mobile = mobile;
        this.name=  name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object that)
    {

        if(this == that)
            return true;


        if(that == null || that.getClass()!= this.getClass())
            return false;


        User obj = (User) that;


        return (obj.getName().equals(this.getName())  && obj.getMobile() == this.getMobile());
    }

}
