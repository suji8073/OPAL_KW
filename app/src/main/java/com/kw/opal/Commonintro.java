package com.kw.opal;

import java.util.HashMap;
import java.util.Map;

public class Commonintro {

    private CommonintroItems items;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public CommonintroItems getItems() {
        return items;
    }

    public void setItems(CommonintroItems items) {
        this.items = items;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}