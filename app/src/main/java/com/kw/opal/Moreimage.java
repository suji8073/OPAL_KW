package com.kw.opal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Moreimage {

    private List<imageItem> Item = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<imageItem> getItem() {
        return Item;
    }

    public void setItem(List<imageItem> imageItem) {
        this.Item = imageItem;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}