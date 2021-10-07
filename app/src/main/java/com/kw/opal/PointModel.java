package com.kw.opal;

import java.io.Serializable;

public class PointModel implements Serializable {
    public String addr;
    public String cat;
    public int id;
    public String image;
    public String name;
    public float mapx;
    public float mapy;


    @Override
    public String toString(){
        String str = super.toString();
        return "주소는 "+addr+" 이름은 "+ name+ " 나머진 아몰라";
    }

    public String getName() {
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

    public float getMap_x() {
        return mapx;
    }

    public float getMap_y() {
        return mapy;
    }
}
