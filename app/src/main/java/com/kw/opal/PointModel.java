package com.kw.opal;

import java.io.Serializable;

public class PointModel implements Serializable {
    private String addr;
    private String cat;
    private int id;
    private String image;
    private String name;

    public float mapx;
    public float mapy;

    int count = 0; //??? 이거 필요?

    @Override
    public String toString(){
        String str = super.toString();

        return "주소는 "+count+" 이름은 "+ getName() + " " + getId();
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

    public float getMap_x() {
        return mapx;
    }

    public float getMap_y() {
        return mapy;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }
}
