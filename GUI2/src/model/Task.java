/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author jonas
 */
public class Task implements Serializable{
     private  ArrayList<TSN> noder;
     private SimpleStringProperty Name = new SimpleStringProperty();
     private SimpleStringProperty info = new SimpleStringProperty();
     private SimpleStringProperty orginsastion = new SimpleStringProperty();
     private IntegerProperty rank = new SimpleIntegerProperty();
     private ObjectProperty StartTime = new SimpleObjectProperty();
     private ObjectProperty EndTime = new SimpleObjectProperty();
     //private final priorityAndQulaityLevels priorityFromPlan ;
     
     
     
     
     public Task(String name,String info, String Orginsation){
        
         noder = new ArrayList<TSN>();
         setName(name);
         setInfo(info);
         setOrginsastion(Orginsation);
         
         
     }
     
     
     
     public void SetpriorityForAllTSN(priorityAndQulaityLevels priority){
         for (int i = 0; i < getNoder().size(); i++) {
             getNoder().get(i).SetPriorityForAllInterface(priority);
         }
     }

    /**
     * @return the noder
     */
    public ArrayList<TSN> getNoder() {
        ArrayList<TSN> temp = new ArrayList<TSN>();
        temp.addAll(noder);
        return temp;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name.get();
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info.get();
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info.set(info);
    }

    /**
     * @return the rank
     */
    public Integer getRank() {
        return rank.get();
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank.set(rank);
    }

    /**
     * @return the StartTime
     */
    public Object getStartTime() {
        return StartTime.get();
    }

    /**
     * @param StartTime the StartTime to set
     */
    public void setStartTime(Date StartTime) {
        this.StartTime.set(StartTime);
    }

    /**
     * @return the EndTime
     */
    public Object getEndTime() {
        return EndTime.get();
    }

    /**
     * @param EndTime the EndTime to set
     */
    public void setEndTime(Date EndTime) {
        this.EndTime.set(EndTime);
    }

    /**
     * @return the orginsastion
     */
    public String getOrginsastion() {
        return orginsastion.get();
    }

    /**
     * @param orginsastion the orginsastion to set
     */
    public void setOrginsastion(String orginsastion) {
        this.orginsastion.set(orginsastion);
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name.set(Name);
    }

    /**
     * @param noder the noder to set
     */
    public void setNoder(ArrayList<TSN> noder) {
        this.noder = noder;
    }

    /**
     * @param noder the noder to set
     */
   
    
    
    
    
     
     
}
