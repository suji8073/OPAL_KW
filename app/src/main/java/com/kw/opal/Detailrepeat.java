package com.kw.opal;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Detailrepeat {
    response response;
    class response {
        body body;
        class body {
            items items;
            class items {
                List<item> item;
                String TextInfo;
                public String getTextInfo(){
                    if (!item.isEmpty()){
                        TextInfo="";
                        for (int i =0;i<item.size();i++) {
                            if (!(isBlank(item.get(i).infoname)||isBlank(item.get(i).infotext))){
                                TextInfo = TextInfo + item.get(i).infoname + " : " + item.get(i).infotext + "\n";
                            }


                        }
                        return  TextInfo;
                    }
                    else
                        return "";
                }

                class item {
                    private Integer contentid;
                    private Integer contenttypeid;
                    private Integer fldgubun;
                    private String infoname;
                    private String infotext;
                    private Integer serialnum;
                    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

                    public Integer getFldgubun() {
                        return fldgubun;
                    }

                    public void setFldgubun(Integer fldgubun) {
                        this.fldgubun = fldgubun;
                    }

                    public String getInfoname() {
                        return infoname;
                    }

                    public void setInfoname(String infoname) {
                        this.infoname = infoname;
                    }

                    public String getInfotext() {
                        return infotext;
                    }

                    public void setInfotext(String infotext) {
                        this.infotext = infotext;
                    }

                    public Integer getSerialnum() {
                        return serialnum;
                    }

                    public void setSerialnum(Integer serialnum) {
                        this.serialnum = serialnum;
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