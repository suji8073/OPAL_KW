package com.kw.opal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RepeatItems {

    private List<RepeatItem> item = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<RepeatItem> getItem() {
        return item;
    }

    public void setItem(List<RepeatItem> item) {
        this.item = item;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
