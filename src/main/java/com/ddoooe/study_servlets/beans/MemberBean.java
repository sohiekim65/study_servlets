package com.ddoooe.study_servlets.beans;
;

public class MemberBean {
    String firstName;
    String secondName;
    String handleName;

    // getter
    public String getFirstName(){
        return this.firstName;
    }
    public String getSecondName(){
        return this.secondName;
    }
    public String getHandleName(){
        return this.handleName;
    }

    // setter
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setSecondName(String secondName){
        this.secondName = secondName;
    }
    public void setHandleName(String handleName){
        this.handleName = handleName;
    }
}
