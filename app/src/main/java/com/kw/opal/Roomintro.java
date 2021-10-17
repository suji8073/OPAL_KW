package com.kw.opal;
import java.util.HashMap;
import java.util.Map;

public class Roomintro {

    private RoomIntroItems items;
    private Integer numOfRows;
    private Integer pageNo;
    private Integer totalCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public RoomIntroItems getItems() {
        return items;
    }

    public void setItems(RoomIntroItems items) {
        this.items = items;
    }

    public Integer getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(Integer numOfRows) {
        this.numOfRows = numOfRows;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
