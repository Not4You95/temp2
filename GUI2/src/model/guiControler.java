/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gui2.*;
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
    
    public void setDesierdTask(int DesierdTask){
        if (DesierdTask >=0) {
             gui.SetTabsForLiveMode();
             model.choiseOfTask(DesierdTask);             
             upDateInterface();
             upDateNode();
             Overview();             
        }
    }
    
    public void ChoiceOfOrg(String name){
        
       model.SetOrgName(name);
        ArrayList<String> temp = new ArrayList<String>(); 
        temp.addAll(model.GetTaskNames());
        gui.UppdateListOfTask(temp); 
        System.out.println("Contoler name: "+name);          
    }
    
    public void Overview(){
        gui.OverViewSceen(model.GetOrgPriorityForAll(), model.GetOrgQualityForAll(),model.GetOrgInfo());
       
    }
    
    public void setScreen(){
       // gui.OrgMenu(model.GetOrgNames());
        gui.TaskMenu();
        gui.InterfaceMenu();
        gui.P_2_PMenu();
        gui.SendMenu();
        gui.ButtonTopLine();
        gui.setListOfTask();
        tempTask.clear();
        gui.ModeMenu();
        modeState(Plan, Live, Simulate);
        //UppdateScreen();
        
    }
    public void setScreenLiveMode(){
         gui.TaskMenu();
        gui.InterfaceMenu();
        gui.P_2_PMenu();
        gui.SendMenu();
        gui.ButtonTopLine();
       // gui.setListOfTask();
        tempTask.clear();
        gui.ModeMenu();
       // modeState(Plan, Live, Simulate);
    }
    
    public void setScreenForPlanMode(){
         gui.TaskMenu();
        gui.InterfaceMenu();
        gui.P_2_PMenu();
        gui.screenForPlanMode(model.getTaskList());
      //  gui.topLineForPlanmode();
    }
    
    public void ChoiseOfTaskPlanMode(String obejct){
        System.out.println(obejct);
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
