package com.kw.opal;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShopIntro {
    response response;
    class response {
        body body;
        class body {
            items items;
            class items {
                ArrayList<item> item = new ArrayList<>();
                class item {
                    private String chkbabycarriageshopping;//
                    private String chkcreditcardshopping;//
                    private String chkpetshopping;//
                    private Integer contentid;//
                    private Integer contenttypeid;//
                    private String infocentershopping;//
                    private String opentime;//
                    private String parkingshopping;//
                    private String restdateshopping;//
                    private String saleitem;//
                    private String saleitemcost;//
                    private String shopguide;
                    private String scaleshopping;
                    private String TextInfo;
                    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                    public String getTextInfo(){
                        TextInfo="";
                        if (!isBlank(saleitem))
                            TextInfo=TextInfo+"판매 품목 : "+saleitem+"\n";
                        if (!isBlank(saleitemcost))
                            TextInfo=TextInfo+"판매 품목별 가격 : "+saleitemcost+"\n";
                        if (!isBlank(chkcreditcardshopping))
                            TextInfo=TextInfo+"신용카드가능 정보 : "+chkcreditcardshopping+"\n";
                        if (!isBlank(infocentershopping))
                            TextInfo=TextInfo+"문의 및 안내 : "+infocentershopping+"\n";
                        if (!isBlank(opentime))
                            TextInfo=TextInfo+"영업시간 : "+opentime+"\n";
                        if (!isBlank(parkingshopping))
                            TextInfo=TextInfo+"주차시설 : "+parkingshopping+"\n";
                        if (!isBlank(restdateshopping))
                            TextInfo=TextInfo+"쉬는날 : "+restdateshopping+"\n";
                        if (!isBlank(chkbabycarriageshopping))
                            TextInfo=TextInfo+"유모차 대여정보 : "+chkbabycarriageshopping+"\n";
                        if (!isBlank(chkpetshopping))
                            TextInfo=TextInfo+"애완동물동반가능 정보 : "+chkpetshopping+"\n";
                        if (!isBlank(shopguide))
                            TextInfo=TextInfo+"쇼핑안내 : "+shopguide+"\n";
                        return TextInfo;
                    }
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
            }
        }
    }

}
