package com.kw.opal;

import java.util.HashMap;
import java.util.Map;

public class ShopIntroItem {

    private String chkbabycarriageshopping;
    private String chkcreditcardshopping;
    private String chkpetshopping;
    private Integer contentid;
    private Integer contenttypeid;
    private String infocentershopping;
    private String opentime;
    private String parkingshopping;
    private String restdateshopping;
    private String saleitem;
    private String saleitemcost;
    private String scaleshopping;
    private String shopguide;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getChkbabycarriageshopping() {
        return chkbabycarriageshopping;
    }

    public void setChkbabycarriageshopping(String chkbabycarriageshopping) {
        this.chkbabycarriageshopping = chkbabycarriageshopping;
    }

    public String getChkcreditcardshopping() {
        return chkcreditcardshopping;
    }

    public void setChkcreditcardshopping(String chkcreditcardshopping) {
        this.chkcreditcardshopping = chkcreditcardshopping;
    }

    public String getChkpetshopping() {
        return chkpetshopping;
    }

    public void setChkpetshopping(String chkpetshopping) {
        this.chkpetshopping = chkpetshopping;
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

    public String getInfocentershopping() {
        return infocentershopping;
    }

    public void setInfocentershopping(String infocentershopping) {
        this.infocentershopping = infocentershopping;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public String getParkingshopping() {
        return parkingshopping;
    }

    public void setParkingshopping(String parkingshopping) {
        this.parkingshopping = parkingshopping;
    }

    public String getRestdateshopping() {
        return restdateshopping;
    }

    public void setRestdateshopping(String restdateshopping) {
        this.restdateshopping = restdateshopping;
    }

    public String getSaleitem() {
        return saleitem;
    }

    public void setSaleitem(String saleitem) {
        this.saleitem = saleitem;
    }

    public String getSaleitemcost() {
        return saleitemcost;
    }

    public void setSaleitemcost(String saleitemcost) {
        this.saleitemcost = saleitemcost;
    }

    public String getScaleshopping() {
        return scaleshopping;
    }

    public void setScaleshopping(String scaleshopping) {
        this.scaleshopping = scaleshopping;
    }

    public String getShopguide() {
        return shopguide;
    }

    public void setShopguide(String shopguide) {
        this.shopguide = shopguide;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}