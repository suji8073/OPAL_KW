package com.kw.opal;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Foodintro {
    response response;
    class response {
        body body;
        class body {
            items items;
            class items {
                ArrayList<item> item = new ArrayList<>();
                class item {
                    private String chkcreditcardfood;//
                    private Integer contentid;//
                    private Integer contenttypeid;//
                    private String discountinfofood;
                    private String firstmenu;//
                    private String infocenterfood;//
                    private Integer kidsfacility;//
                    private Long lcnsno;//
                    private String opentimefood;
                    private String packing;
                    private String parkingfood;//
                    private String reservationfood;
                    private String restdatefood;//
                    private String smoking;//
                    private String treatmenu;//
                    private String TextInfo;
                    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                    public String getTextInfo(){
                        TextInfo="";
                        if (!isBlank(treatmenu))
                            TextInfo=TextInfo+"취급 메뉴 : "+treatmenu+"\n";
                        if (!isBlank(firstmenu))
                            TextInfo=TextInfo+"영업시간 : "+opentimefood+"\n";
                        if (!isBlank(chkcreditcardfood))
                            TextInfo=TextInfo+"신용카드가능 정보 : "+chkcreditcardfood+"\n";
                        if (!isBlank(restdatefood))
                            TextInfo=TextInfo+"예약 안내 : "+restdatefood+"\n";
                        if (!isBlank(infocenterfood))
                            TextInfo=TextInfo+"문의 및 안내 : "+infocenterfood+"\n";
                        if (!isBlank(parkingfood))
                            TextInfo=TextInfo+"주차시설 : "+parkingfood+"\n";
                        if (!isBlank(restdatefood))
                            TextInfo=TextInfo+"쉬는날 : "+restdatefood+"\n";
                        if (!isBlank(smoking))
                            TextInfo=TextInfo+"금연/흡연 여부 : "+smoking+"\n";
                        if (!isBlank(packing))
                            TextInfo=TextInfo+"포장 가능 : "+packing+"\n";
                        if (kidsfacility!=0)
                            TextInfo=TextInfo+"어린이 놀이방 여부 : O\n";


                        return TextInfo;
                    }

                    public String getChkcreditcardfood() {
                        return chkcreditcardfood;
                    }


                    public Integer getContentid() {
                        return contentid;
                    }


                    public Integer getContenttypeid() {
                        return contenttypeid;
                    }


                    public String getDiscountinfofood() {
                        return discountinfofood;
                    }


                    public String getFirstmenu() {
                        return firstmenu;
                    }


                    public String getInfocenterfood() {
                        return infocenterfood;
                    }



                    public Integer getKidsfacility() {
                        return kidsfacility;
                    }


                    public Long getLcnsno() {
                        return lcnsno;
                    }

                    public String getOpentimefood() {
                        return opentimefood;
                    }

                    public String getPacking() {
                        return packing;
                    }

                    public String getParkingfood() {
                        return parkingfood;
                    }

                    public String getReservationfood() {
                        return reservationfood;
                    }


                    public String getRestdatefood() {
                        return restdatefood;
                    }


                    public String getSmoking() {
                        return smoking;
                    }

                    public String getTreatmenu() {
                        return treatmenu;
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
