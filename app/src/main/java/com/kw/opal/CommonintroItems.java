package com.kw.opal;

import java.util.HashMap;
import java.util.Map;

public class CommonintroItems {

    private CommonintroItem item;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public CommonintroItem getItem() {
        return item;
    }

    public void setItem(CommonintroItem item) {
        this.item = item;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
