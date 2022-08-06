package com.kw.opal;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Roomintro {
    response response;
    class response {
        body body;
        class body {
            items items;
            class items {
                ArrayList<item> item = new ArrayList<>();
                class item {
                    private Integer barbecue;
                    private Integer beauty;
                    private Integer benikia;
                    private Integer beverage;
                    private Integer bicycle;
                    private Integer campfire;
                    private String checkintime; //체크인
                    private String checkouttime;//체크아웃
                    private String chkcooking;
                    private Integer contentid;
                    private Integer contenttypeid;
                    private Integer fitness;
                    private String foodplace;
                    private Integer goodstay;
                    private Integer hanok;
                    private String infocenterlodging; //인포메이션
                    private Integer karaoke;
                    private String parkinglodging; //주차시설
                    private Integer publicbath;
                    private Integer publicpc;
                    private String reservationlodging;  //예약안내
                    private String roomcount; //방 개수
                    private String roomtype;    //객실유형
                    private Integer sauna;
                    private Integer seminar;
                    private Integer sports;
                    private String subfacility; //기타 부대시설
                    private String TextInfo;
                    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                    public String getTextInfo(){
                        TextInfo="";
                        if (!isBlank(checkintime))
                            TextInfo=TextInfo+"체크인 시간 : "+checkintime+"\n";
                        if (!isBlank(checkouttime))
                            TextInfo=TextInfo+"체크아웃 시간 : "+checkouttime+"\n";
                        if (!isBlank(infocenterlodging))
                            TextInfo=TextInfo+"문의 및 안내 : "+infocenterlodging+"\n";
                        if (!isBlank(parkinglodging))
                            TextInfo=TextInfo+"주차시설 : "+parkinglodging+"\n";
                        if (!isBlank(reservationlodging))
                            TextInfo=TextInfo+"예약 안내 : "+reservationlodging+"\n";
                        if (!isBlank(roomcount))
                            TextInfo=TextInfo+"객실 수 : "+roomcount+"\n";
                        if (!isBlank(roomtype))
                            TextInfo=TextInfo+"객실유형 : "+roomtype+"\n";
                        if (!isBlank(chkcooking))
                            TextInfo=TextInfo+"객실 내 취사 여부 : "+chkcooking+"\n\n";
                        if (!isBlank(foodplace))
                            TextInfo=TextInfo+"식음료장 : "+foodplace+"\n";
                        if (barbecue==1)
                            TextInfo=TextInfo+"바베큐장 : O\n";
                        if (beauty==1)
                            TextInfo=TextInfo+"뷰티시설 : O\n";
                        if (bicycle==1)
                            TextInfo=TextInfo+"자전거 대여 : O\n";
                        if (campfire==1)
                            TextInfo=TextInfo+"캠프파이어 : O\n";
                        if (fitness==1)
                            TextInfo=TextInfo+"휘트니스 센터 : O\n";
                        if (karaoke==1)
                            TextInfo=TextInfo+"노래방 : O\n";
                        if (publicbath==1)
                            TextInfo=TextInfo+"샤워실 : O\n";
                        if (publicpc==1)
                            TextInfo=TextInfo+"PC방 : O\n";
                        if (sauna==1)
                            TextInfo=TextInfo+"사우나 : O\n";
                        if (seminar==1)
                            TextInfo=TextInfo+"세미나실 : O\n";
                        if (sports==1)
                            TextInfo=TextInfo+"스포츠시설 : O\n";
                        if (!isBlank(subfacility))
                            TextInfo=TextInfo+"기타 부대시설 : "+subfacility+"\n";

                        return TextInfo;
                    }
                    public Integer getBarbecue() {
                        return barbecue;
                    }

                    public void setBarbecue(Integer barbecue) {
                        this.barbecue = barbecue;
                    }

                    public Integer getBeauty() {
                        return beauty;
                    }

                    public void setBeauty(Integer beauty) {
                        this.beauty = beauty;
                    }

                    public Integer getBenikia() {
                        return benikia;
                    }

                    public void setBenikia(Integer benikia) {
                        this.benikia = benikia;
                    }

                    public Integer getBeverage() {
                        return beverage;
                    }

                    public void setBeverage(Integer beverage) {
                        this.beverage = beverage;
                    }

                    public Integer getBicycle() {
                        return bicycle;
                    }

                    public void setBicycle(Integer bicycle) {
                        this.bicycle = bicycle;
                    }

                    public Integer getCampfire() {
                        return campfire;
                    }

                    public void setCampfire(Integer campfire) {
                        this.campfire = campfire;
                    }

                    public String getCheckintime() {
                        return checkintime;
                    }

                    public void setCheckintime(String checkintime) {
                        this.checkintime = checkintime;
                    }

                    public String getCheckouttime() {
                        return checkouttime;
                    }

                    public void setCheckouttime(String checkouttime) {
                        this.checkouttime = checkouttime;
                    }

                    public String getChkcooking() {
                        return chkcooking;
                    }

                    public void setChkcooking(String chkcooking) {
                        this.chkcooking = chkcooking;
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

                    public Integer getFitness() {
                        return fitness;
                    }

                    public void setFitness(Integer fitness) {
                        this.fitness = fitness;
                    }

                    public String getFoodplace() {
                        return foodplace;
                    }

                    public void setFoodplace(String foodplace) {
                        this.foodplace = foodplace;
                    }

                    public Integer getGoodstay() {
                        return goodstay;
                    }

                    public void setGoodstay(Integer goodstay) {
                        this.goodstay = goodstay;
                    }

                    public Integer getHanok() {
                        return hanok;
                    }

                    public void setHanok(Integer hanok) {
                        this.hanok = hanok;
                    }

                    public String getInfocenterlodging() {
                        return infocenterlodging;
                    }

                    public void setInfocenterlodging(String infocenterlodging) {
                        this.infocenterlodging = infocenterlodging;
                    }

                    public Integer getKaraoke() {
                        return karaoke;
                    }

                    public void setKaraoke(Integer karaoke) {
                        this.karaoke = karaoke;
                    }

                    public String getParkinglodging() {
                        return parkinglodging;
                    }

                    public void setParkinglodging(String parkinglodging) {
                        this.parkinglodging = parkinglodging;
                    }

                    public Integer getPublicbath() {
                        return publicbath;
                    }

                    public void setPublicbath(Integer publicbath) {
                        this.publicbath = publicbath;
                    }

                    public Integer getPublicpc() {
                        return publicpc;
                    }

                    public void setPublicpc(Integer publicpc) {
                        this.publicpc = publicpc;
                    }

                    public String getReservationlodging() {
                        return reservationlodging;
                    }

                    public void setReservationlodging(String reservationlodging) {
                        this.reservationlodging = reservationlodging;
                    }

                    public String getRoomcount() {
                        return roomcount;
                    }

                    public void setRoomcount(String roomcount) {
                        this.roomcount = roomcount;
                    }

                    public String getRoomtype() {
                        return roomtype;
                    }

                    public void setRoomtype(String roomtype) {
                        this.roomtype = roomtype;
                    }

                    public Integer getSauna() {
                        return sauna;
                    }

                    public void setSauna(Integer sauna) {
                        this.sauna = sauna;
                    }

                    public Integer getSeminar() {
                        return seminar;
                    }

                    public void setSeminar(Integer seminar) {
                        this.seminar = seminar;
                    }

                    public Integer getSports() {
                        return sports;
                    }

                    public void setSports(Integer sports) {
                        this.sports = sports;
                    }

                    public String getSubfacility() {
                        return subfacility;
                    }

                    public void setSubfacility(String subfacility) {
                        this.subfacility = subfacility;
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
