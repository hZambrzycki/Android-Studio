package com.example.proyectoandroid_hz;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name="content", strict = false)
public class Content {
    public void setUrl(String url) {
        this.url = url;
    }

    @Attribute(name="url")
    private String url;

    public Content() {
    }

    public Content(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}