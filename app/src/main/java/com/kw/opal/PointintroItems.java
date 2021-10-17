package com.kw.opal;

import java.util.HashMap;
import java.util.Map;

public class PointintroItems {

    private PointintroItem item;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public PointintroItem getItem() {
        return item;
    }

    public void setItem(PointintroItem item) {
        this.item = item;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
