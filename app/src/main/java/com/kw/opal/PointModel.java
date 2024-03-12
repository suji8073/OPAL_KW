package com.kw.opal;

import java.io.Console;
import java.io.Serializable;

public class PointModel implements Serializable {
    private String addr;
    private String cat;
    private String id;
    private String image;
    private String name;
    private  String contentTypeId;

    public float mapx;
    public float mapy;

    int count = 0; //??? 이거 필요?

    public PointModel(String addr,String id,String image,String name,String contentTypeId,float mapx,float mapy){
        this.addr=addr;
        this.id=id;
        this.image=image;
        this.name=name;
        this.contentTypeId=contentTypeId;
        this.mapx=mapx;
        this.mapy=mapy;

    }


    @Override
    public String toString(){
        String str = super.toString();

        return "주소는 "+count+" 이름은 "+ getName() + " " + getId();
    }

    public String getName() {
        count+=1;
        return name;
    }
    public String getContentTypeId(){return contentTypeId;}

    public String getAddr() {
        return addr;
    }

    public String getImage() {
        return image;
    }

    public String getId() {
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


    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }
}
