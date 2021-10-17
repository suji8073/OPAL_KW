package com.kw.opal;

import java.util.HashMap;
import java.util.Map;

public class PointintroItem {

    private String chkbabycarriage;
    private String chkcreditcard;
    private String chkpet;
    private Integer contentid;
    private Integer contenttypeid;
    private String expguide;
    private Integer heritage1;
    private Integer heritage2;
    private Integer heritage3;
    private String infocenter;
    private String parking;
    private String restdate;
    private String usetime;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getChkbabycarriage() {
        return chkbabycarriage;
    }

    public void setChkbabycarriage(String chkbabycarriage) {
        this.chkbabycarriage = chkbabycarriage;
    }

    public String getChkcreditcard() {
        return chkcreditcard;
    }

    public void setChkcreditcard(String chkcreditcard) {
        this.chkcreditcard = chkcreditcard;
    }

    public String getChkpet() {
        return chkpet;
    }

    public void setChkpet(String chkpet) {
        this.chkpet = chkpet;
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

    public String getExpguide() {
        return expguide;
    }

    public void setExpguide(String expguide) {
        this.expguide = expguide;
    }

    public Integer getHeritage1() {
        return heritage1;
    }

    public void setHeritage1(Integer heritage1) {
        this.heritage1 = heritage1;
    }

    public Integer getHeritage2() {
        return heritage2;
    }

    public void setHeritage2(Integer heritage2) {
        this.heritage2 = heritage2;
    }

    public Integer getHeritage3() {
        return heritage3;
    }

    public void setHeritage3(Integer heritage3) {
        this.heritage3 = heritage3;
    }

    public String getInfocenter() {
        return infocenter;
    }

    public void setInfocenter(String infocenter) {
        this.infocenter = infocenter;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getRestdate() {
        return restdate;
    }

    public void setRestdate(String restdate) {
        this.restdate = restdate;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
