package org.solent.carPark.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ReplyMessage {

    private Integer code;

    private String debugMessage;
    
    private Meter meter= new Meter();


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }

    @Override
    public String toString() {
        return "ReplyMessage{" + "code=" + code + ", debugMessage=" + debugMessage + ", meter=" + meter + '}';
    }

 



}
