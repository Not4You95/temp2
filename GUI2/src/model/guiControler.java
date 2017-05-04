/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gui2.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.TreeItem;
import model.*;

/**
 *
 * @author jonas
 */
public class guiControler {
    private GUI2 gui;
    private GUImodel model;
    private ArrayList<String> tempTask;
    private boolean Plan=true,Live=false,Simulate=false;
    
    
    public guiControler(GUI2 GUICLASS){
        gui = GUICLASS; 
        model = new GUImodel();
        model.test();
        tempTask = new ArrayList<String>();
        
        
    }
    
    public void SetGroup(){
        
        
        
    }
    
    public void SetDate(LocalDate date){
        model.setDayOfMission(date);
        setScreenForPlanMode();
    }
    
    public void setDesierdTask(int DesierdTask){
        if (DesierdTask >=0) {             
             model.choiseOfTask(DesierdTask);             
            upDateTabs();
        }
    }
    
    public void upDateTabs(){
        gui.SetTabsForLiveMode();
        gui.topLineforEdeting();
             upDateInterface();
             upDateNode();
             Overview(); 
    }
    
   
    
    public void Overview(){
        gui.OverViewSceen(model.GetOrgPriorityForAll(),model.GetOrgInfo(),model.getStarDate(),model.getEndDate());
       
    }
    
    public void setScreen(){      
        gui.TaskMenu();
        gui.InterfaceMenu();
        gui.P_2_PMenu();
        gui.SendMenu();        
        gui.setListOfTask();
        tempTask.clear();
        gui.ModeMenu();
       
        //UppdateScreen();
        
    }
    public void setScreenLiveMode(){
         gui.TaskMenu();
         gui.InterfaceMenu();
         gui.P_2_PMenu();
         gui.SendMenu();      
         tempTask.clear();
         gui.ModeMenu();      
    }
    
    public void setScreenForPlanMode(){        
         gui.screenForPlanMode(model.getTaskList());
      //  gui.topLineForPlanmode();
    }
    
    public void ChoiseOfTaskPlanMode(Task object){
        model.settempTask(object);       
        upDateTabs();
     
    }
    
    public void UppdateScreen(){       
    
        if (Plan) {
            setScreenForPlanMode();
          
            
        }else if(Live){
            ArrayList<String> temp = new ArrayList<String>(); 
            temp.addAll(model.GetTaskNames());
            gui.UppdateListOfTask(temp); 
            gui.SetScreenForLiveMode();
              
            
        }
        else if(Simulate){
            
        }
        
       // tempTask.add("Test");
       // tempTask.add("Hello");
       
        
       
    }
    
    public void updateP_2_P(){
          gui.P_2_PScreen();
      }
    
    public void choiseOfInterface(String temp){
        //gui.makeNewTabView(temp,"");
       
    }
    
    public void newTabInterface(Object node){
        System.out.println("New tab "+node.toString());     
      
    }
    
    public void getTask(Task obejct){
        
    }
    
    public void newTabNode(Object node){
        System.out.println("New tab :"+node.toString());
        TSN temp = model.getNode(node.toString());
        if (temp != null) {
            gui.nodeAndComtypeTab(temp.getName(), temp.getInfo());
        }
    }
    
    public void modeState(){
        modeState(Plan, Live, Simulate);
    }
    
   public void modeState(boolean Plan,boolean Live,boolean Simulate){
          this.Plan = Plan;
          this.Live = Live;
          this.Simulate = Simulate;
          UppdateScreen();
          gui.upDateModeState(Plan, Live, Simulate);
      }
   public void upDateNode(){
       
       gui.NodeTabScreen(model.getNodes());
   }
      public void upDateInterface(){
         
          gui.InterfaceScreen(model.getInterfaceTypes());
      }
      
     
    
}
