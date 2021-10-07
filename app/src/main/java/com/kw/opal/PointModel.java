package com.kw.opal;

import java.io.Serializable;

public class PointModel implements Serializable {
    public String addr;
    public String cat;
    public int id;
    public String image;
    public String name;
    int count = 0;

    @Override
    public String toString(){
        String str = super.toString();

        return "주소는 "+count+" 이름은 "+ name+ " " + id;
    }

    public String getName() {
        count+=1;
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
}
