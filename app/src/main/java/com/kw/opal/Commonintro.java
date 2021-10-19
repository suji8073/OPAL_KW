package com.kw.opal;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Commonintro {
    response response;
    class response{
        body body;
        class body{
            items items;
            class items{
                item item;
                class item{
                    private String addr1;
                    private Integer areacode;
                    private Integer booktour;
                    private Integer contentid;
                    private Integer contenttypeid;
                    private Long createdtime;
                    private String firstimage;
                    private String firstimage2;
                    private String homepage;
                    private Long modifiedtime;
                    private String overview;
                    private Integer sigungucode;
                    private String title;
                    private String tel;
                    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                    public String getTel(){
                        return tel;
                    }


                    public String getaddr1(){
                        return addr1;
                    }
                    public Integer getAreacode() {
                        return areacode;
                    }

                    public void setAreacode(Integer areacode) {
                        this.areacode = areacode;
                    }

                    public Integer getBooktour() {
                        return booktour;
                    }

                    public void setBooktour(Integer booktour) {
                        this.booktour = booktour;
                    }

                    public Integer getContentid() {
                        return contentid;
                    }

                    public void setContentid(Integer contentid) {
                        this.contentid = contentid;
                    }

                    public Integer getContenttypeid() {
                        return contenttypeid;
                    }

                    public void setContenttypeid(Integer contenttypeid) {
                        this.contenttypeid = contenttypeid;
                    }

                    public Long getCreatedtime() {
                        return createdtime;
                    }

                    public void setCreatedtime(Long createdtime) {
                        this.createdtime = createdtime;
                    }

                    public String getFirstimage() {
                        return firstimage;
                    }

                    public void setFirstimage(String firstimage) {
                        this.firstimage = firstimage;
                    }

                    public String getFirstimage2() {
                        return firstimage2;
                    }

                    public void setFirstimage2(String firstimage2) {
                        this.firstimage2 = firstimage2;
                    }

                    public String getHomepage() {
                        return homepage;
                    }

                    public void setHomepage(String homepage) {
                        this.homepage = homepage;
                    }

                    public Long getModifiedtime() {
                        return modifiedtime;
                    }

                    public void setModifiedtime(Long modifiedtime) {
                        this.modifiedtime = modifiedtime;
                    }

                    public String getOverview() {
                        return overview;
                    }

                    public void setOverview(String overview) {
                        this.overview = overview;
                    }

                    public Integer getSigungucode() {
                        return sigungucode;
                    }

                    public void setSigungucode(Integer sigungucode) {
                        this.sigungucode = sigungucode;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public Map<String, Object> getAdditionalProperties() {
                        return this.additionalProperties;
                    }

                    public void setAdditionalProperty(String name, Object value) {
                        this.additionalProperties.put(name, value);
                    }
                }

            }
        }
    }






}

