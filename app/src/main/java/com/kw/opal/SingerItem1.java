package com.kw.opal;

public class SingerItem1 {
    String name;
    String mobile;


    // Generate > Constructor
    public SingerItem1(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;

    }

    // Generate > Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    // Generate > toString() : 아이템을 문자열로 출력

    @Override
    public String toString() {
        return "dd";
    }

}
