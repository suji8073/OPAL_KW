package com.kw.opal;

import java.io.Serializable;

public class RouteModel implements Serializable {
    private String cat;
    private String id;
    private String image;
    private String name;
    private  String contentTypeId;


    public String getContentTypeId(){return contentTypeId;}


    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }
    public String getName(){return name;}


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
