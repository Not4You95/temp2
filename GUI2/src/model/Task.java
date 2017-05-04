/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jonas
 */
public class Task implements Serializable{
     private ArrayList<TSN> noder;
     private String Name;
     private String info;
     private String orginsastion;
     private int rank ;
     private priorityAndQulaityLevels priorityFromPlan ;
     
     
     
     
     public Task(String name,String info, String Orginsation){
         this.Name = name;
         noder = new ArrayList<TSN>();
         this.info = info;
         this.orginsastion = Orginsation;
     }
     
     public Task(){
         noder = new ArrayList<TSN>();
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
     * @param noder the noder to set
     */
    public void setNoder(ArrayList<TSN> noder) {
        this.noder.addAll(noder);
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return the priorityFromPlan
     */
    public priorityAndQulaityLevels getPriorityFromPlan() {
        return priorityFromPlan;
    }

    /**
     * @param priorityFromPlan the priorityFromPlan to set
     */
    public void setPriorityFromPlan(priorityAndQulaityLevels priorityFromPlan) {
        this.priorityFromPlan = priorityFromPlan;
    }

    

    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * @return the orginsastion
     */
    public String getOrginsastion() {
        return orginsastion;
    }

    /**
     * @param orginsastion the orginsastion to set
     */
    public void setOrginsastion(String orginsastion) {
        this.orginsastion = orginsastion;
    }
    
    
    
    
     
     
}
