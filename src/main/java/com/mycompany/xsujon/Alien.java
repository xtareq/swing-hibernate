/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xsujon;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author tareq
 */
@Entity
@Table(name="aliens")
public class Alien implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    @Column(name="name")
    private String aname;
    private String color;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        int oldAid = this.aid;
        this.aid = aid;
        changeSupport.firePropertyChange("aid", oldAid, aid);
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        String oldAname = this.aname;
        this.aname = aname;
        changeSupport.firePropertyChange("aname", oldAname, aname);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        String oldColor = this.color;
        this.color = color;
        changeSupport.firePropertyChange("color", oldColor, color);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    
}
