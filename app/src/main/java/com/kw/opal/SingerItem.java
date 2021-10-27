package com.kw.opal;

public class SingerItem {
    int resId;
    String name;
    // Generate > Constructor
    public SingerItem(String name,  int resId) {
        this.name = name;

        this.resId = resId;
    }

    // Generate > Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    // Generate > toString() : 아이템을 문자열로 출력

    @Override
    public String toString() {
        return "hey";
    }
}
