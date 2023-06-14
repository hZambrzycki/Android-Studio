package com.example.proyectoandroid_hz;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.nio.channels.Channel;

@Root(name = "rss", strict = false)
@Namespace(reference="http://search.yahoo.com/mrss/")
public class RSS {
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Element
    private Channel channel;

    public RSS() {
    }

    public RSS(Channel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }
}
