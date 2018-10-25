/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xsujon;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 *
 * @author tareq
 */
public class Xsujon {
    
    
    public static boolean save(String name, String color) {
        Alien telisko = new Alien();
        telisko.setAname(name);
        telisko.setColor(color);
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(sr);
        
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
        session.save(telisko);
        ts.commit();
        session.close();
        sf.close();
        
        return true;
    }
    
    public static ArrayList<Alien> getAllAliens()
    {
        ArrayList<Alien> alienList = new ArrayList<Alien>();
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(sr);
        
        Session session = sf.openSession();
        //ArrayList list = session.createQuery("from Alien d");
       
        List li = session.createQuery("from Alien al").list();
        Iterator ir = li.iterator();
        
        while(ir.hasNext()){
            Object o = (Object)ir.next();
            Alien al = (Alien)o;
            alienList.add(al);
        }
      
        session.close();
        sf.close();
        
        return alienList;
    }
    
}
