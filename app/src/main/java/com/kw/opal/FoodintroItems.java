package com.kw.opal;

import java.util.HashMap;
import java.util.Map;

public class FoodintroItems {

    private FoodintroItem item;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public FoodintroItem getItem() {
        return item;
    }

    public void setItem(FoodintroItem item) {
        this.item = item;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}