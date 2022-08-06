package com.kw.opal;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pointintro {
    response response;
    class response {
        body body;
        class body {
            items items;
            class items {
                ArrayList<item> item = new ArrayList<>();
                class item {
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
                    private String TextInfo;
                    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                    public String getTextInfo(){
                        TextInfo="";
                        if (!isBlank(chkbabycarriage))
                            TextInfo=TextInfo+"유모차 대여정보 : "+chkbabycarriage+"\n";
                        if (!isBlank(chkcreditcard))
                            TextInfo=TextInfo+"신용카드가능 정보 : "+chkcreditcard+"\n";
                        if (!isBlank(chkpet))
                            TextInfo=TextInfo+"애완동물동반가능 정보 : "+chkpet+"\n";
                        if (!isBlank(expguide))
                            TextInfo=TextInfo+"체험안내 : "+expguide+"\n";
                        if (!isBlank(infocenter))
                            TextInfo=TextInfo+"문의 및 안내 : "+infocenter+"\n";
                        if (!isBlank(parking))
                            TextInfo=TextInfo+"주차시설 : "+parking+"\n";
                        if (!isBlank(restdate))
                            TextInfo=TextInfo+"쉬는날 : "+restdate+"\n";
                        if (!isBlank(usetime))
                            TextInfo=TextInfo+"이용시간 : "+usetime+"\n";

                        return TextInfo;
                    }

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
            }
        }
    }

}