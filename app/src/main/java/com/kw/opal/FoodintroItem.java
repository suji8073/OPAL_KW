package com.kw.opal;


import java.util.HashMap;
import java.util.Map;

public class FoodintroItem {

    private String chkcreditcardfood;
    private Integer contentid;
    private Integer contenttypeid;
    private String discountinfofood;
    private String firstmenu;
    private String infocenterfood;
    private Integer kidsfacility;
    private Long lcnsno;
    private String opentimefood;
    private String packing;
    private String parkingfood;
    private String reservationfood;
    private String restdatefood;
    private String smoking;
    private String treatmenu;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getChkcreditcardfood() {
        return chkcreditcardfood;
    }

    public void setChkcreditcardfood(String chkcreditcardfood) {
        this.chkcreditcardfood = chkcreditcardfood;
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

    public String getDiscountinfofood() {
        return discountinfofood;
    }

    public void setDiscountinfofood(String discountinfofood) {
        this.discountinfofood = discountinfofood;
    }

    public String getFirstmenu() {
        return firstmenu;
    }

    public void setFirstmenu(String firstmenu) {
        this.firstmenu = firstmenu;
    }

    public String getInfocenterfood() {
        return infocenterfood;
    }

    public void setInfocenterfood(String infocenterfood) {
        this.infocenterfood = infocenterfood;
    }

    public Integer getKidsfacility() {
        return kidsfacility;
    }

    public void setKidsfacility(Integer kidsfacility) {
        this.kidsfacility = kidsfacility;
    }

    public Long getLcnsno() {
        return lcnsno;
    }

    public void setLcnsno(Long lcnsno) {
        this.lcnsno = lcnsno;
    }

    public String getOpentimefood() {
        return opentimefood;
    }

    public void setOpentimefood(String opentimefood) {
        this.opentimefood = opentimefood;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getParkingfood() {
        return parkingfood;
    }

    public void setParkingfood(String parkingfood) {
        this.parkingfood = parkingfood;
    }

    public String getReservationfood() {
        return reservationfood;
    }

    public void setReservationfood(String reservationfood) {
        this.reservationfood = reservationfood;
    }

    public String getRestdatefood() {
        return restdatefood;
    }

    public void setRestdatefood(String restdatefood) {
        this.restdatefood = restdatefood;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getTreatmenu() {
        return treatmenu;
    }

    public void setTreatmenu(String treatmenu) {
        this.treatmenu = treatmenu;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
