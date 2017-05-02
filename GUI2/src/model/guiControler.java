/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gui2.*;
import java.util.ArrayList;
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
        model.choiseOfTask(DesierdTask);
        upDateInterface();
//        Overview();
    }
    
    public void ChoiceOfOrg(String name){
        
       model.SetOrgName(name);
       System.out.println("Contoler name: "+name);
       
       //Overview();
       UppdateScreen();      
    }
    
    public void Overview(){
        gui.OverViewSceen(model.GetOrgPriorityForAll(), model.GetOrgQualityForAll(),model.GetOrgInfo());
    }
    
    public void setScreen(){
        gui.OrgMenu(model.GetOrgNames());
        gui.TaskMenu();
        gui.InterfaceMenu();
        gui.P_2_PMenu();
        gui.SendMenu();
        gui.ButtonTopLine();
        gui.setListOfTask();
        tempTask.clear();
        gui.ModeMenu();
        modeState(Plan, Live, Simulate);
        
    }
    
    public void UppdateScreen(){          
        
        
        if (Plan) {
            gui.screenForPlanMode(model.getTaskList());
            
        }else if(Live){
            ArrayList<String> temp = new ArrayList<String>(); 
            temp.addAll(model.GetTaskNames());
            gui.UppdateListOfTask(temp);
            gui.SetTabsForLiveMode();
            
        }
        else if(Simulate){
            
        }
        
       // tempTask.add("Test");
       // tempTask.add("Hello");
       
        
       
    }
    
    public void choiseOfInterface(String temp){
        gui.makeNewTabView(temp);
       
    }
    
   public void modeState(boolean Plan,boolean Live,boolean Simulate){
          this.Plan = Plan;
          this.Live = Live;
          this.Simulate = Simulate;
          UppdateScreen();
          gui.upDateModeState(Plan, Live, Simulate);
      }
   
      public void upDateInterface(){
          ArrayList<TSN> tempTsn  = new ArrayList<>();
          ArrayList<Interface> tempI = new ArrayList<>();
          ArrayList<String> Interface = new ArrayList<>();
          //ArrayList<priorityAndQulaityLevels> TypeList
         // gui.makeBrach(InterfaceTypes.Message, parent);
         tempTsn.addAll(model.getInterfaceTypes());
          for (int i = 0; i < tempTsn.size(); i++) {
              tempI.addAll(tempTsn.get(i).getInterface());
          }
          for (int i = 0; i < tempI.size(); i++) {
              
              for (int j = 0; j < 10; j++) {
                   if (tempI.get(i).getName().compareToIgnoreCase(tempI.get(j).getName()) != 0) {
                  Interface.add(tempI.get(i).getName());
              }
                  
              }
              
              
          }
          for (int i = 0; i < Interface.size(); i++) {
                System.out.println(Interface.get(i).toString());
          }
      }
    
}
