package com.driver;

public class Group {
    private String name;
    private int numberOfParticipants;



    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
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


        Group obj = (Group) that;


        return (obj.name.equals(this.name)  && obj.numberOfParticipants == this.numberOfParticipants);
    }



}
