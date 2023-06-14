package com.example.proyectoandroid_hz;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class Item {

    @Element(name="title")
    private String title;

    @Element(name = "description")
    private String descripcion;

    @Element(name="link")
    private String link;

    @Element(name="content")
    @Namespace(reference="http://search.yahoo.com/mrss/", prefix="media")
    private Content content;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Item() {
    }

    public Item(String title, String descripcion, String link, Content content) {
        this.title = title;
        this.descripcion = descripcion;
        this.link = link;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLink() {
        return link;
    }

    public Content getContent() {
        return content;
    }
}