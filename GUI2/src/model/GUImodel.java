/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

/**
 *
 * @author jonas
 */
public class GUImodel {
    private ArrayList<Orginasation> Org;
    private ReadAndWriteToFile SaveAndRead;
    private File filename;
    private String OrgName;
    private Orginasation OrgTemp;
    private Task taskTemp = null;
    private int taskLevel;
    
    
    
    
    public GUImodel(){
        Org = new ArrayList<Orginasation>();
        SaveAndRead = new ReadAndWriteToFile();
        filename = new File("test.txt");       
    }
    
    public ArrayList<String> GetOrgNames(){
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < Org.size(); i++) {
            temp.add(Org.get(i).getName());
        }
        return temp;
    }
    
    public void SetOrgName(String name){
        OrgName = name;
        
        for (int i = 0; i < Org.size(); i++) {
            if (Org.get(i).getName() == OrgName) {
                OrgTemp = Org.get(i);
                              
            } 
        }
        
    }
    
    
    public ArrayList<String> GetTaskNames(){
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < Org.size(); i++) {
            if (Org.get(i).getName() == OrgName) {
                temp.addAll(Org.get(i).GetTaskNames());               
            } 
        }
        
        return temp;
    }
    
    public ObservableList<Task> getTaskList(){
        ObservableList<Task> Tasks = FXCollections.observableArrayList();
        for (int i = 0; i < Org.size(); i++) {
            if (Org.get(i).getName() == OrgName) {
                Tasks.addAll(Org.get(i).getTasks());
            } 
        }
        return Tasks;
        
    }
    
    
    public void SaveToFile() throws IOException, AlertToUser{
           SaveAndRead.writeToFile(Org, filename);          
    }
    
    public void ReadFromFile() throws AlertToUser, IOException, ClassNotFoundException{
         
         Org.add(SaveAndRead.readFromFile(filename));
        
    }
    
    public String GetOrgInfo(){
        String temp=null;
       for (int i = 0; i < Org.size(); i++) {
            if (Org.get(i).getName() == OrgName) {
                temp = Org.get(i).getInfo();
                              
            } 
        }
       return temp;
    }
    
    public priorityAndQulaityLevels GetOrgPriorityForAll(){
      priorityAndQulaityLevels temp;      
       temp = OrgTemp.getPriotetForAllTSN();
       return temp;
    }
    
    public priorityAndQulaityLevels GetOrgQualityForAll(){
         priorityAndQulaityLevels temp;
       
       temp = OrgTemp.getQualityForAllTSN();
       return temp;
    }
    
    public ArrayList<Interface> getInterfaceTypes(){
       ArrayList<Interface> temp = new ArrayList<>();
       
        
        return temp;
        
    }
    
    public void choiseOfTask(int name){
        taskTemp = OrgTemp.getTask(name);
        System.out.println("Task name: "+taskTemp.getName());
    }
    
    public ArrayList<TSN> getNodes(){
        ArrayList<TSN> temp  = new ArrayList<>();
        temp.addAll(taskTemp.getNoder());
        return temp;
    }
    
    public TSN getNode(String name){
        if (taskTemp != null) {
            for (int i = 0; i < taskTemp.getNoder().size(); i++) {
                System.out.println("---------------------------------------------------------");
                System.out.println(taskTemp.getNoder().get(i).getName());
                System.out.println(name);
                System.out.println(name.toLowerCase().contains(taskTemp.getNoder().get(i).getName().toLowerCase()));
            if (name.toLowerCase().contains(taskTemp.getNoder().get(i).getName().toLowerCase())) {
                return taskTemp.getNoder().get(i);
            }
        }
        }
        return null;
    }
    
    
      public void test() {
          ArrayList<TSN> temp = new ArrayList<TSN>();
        ArrayList<Orginasation> orgList = new ArrayList<Orginasation>();
        Task task = new Task("Defend the candy");
        Task task2 = new Task("Defend the hill");
        ArrayList<Task> taskList = new ArrayList<Task>();
        Orginasation Gotland = new Orginasation();
        Orginasation Blidö = new Orginasation();
        Orginasation Öland = new Orginasation();
       /* BFT – Blue Force Tracking
COP – Common Operational Picture
Voice – Streamed Voice
ISR – Intelligence, surveillance and reconnaissance
Video – Streamed Video
Msg – Command and control messages
Control – System Management*/
       
       Interface in1 = new Interface("BFT", priorityAndQulaityLevels.High, priorityAndQulaityLevels.High,InterfaceTypes.Tracking);
       Interface in2 = new Interface("Voice", priorityAndQulaityLevels.Low, priorityAndQulaityLevels.Low, InterfaceTypes.Mesagge);
       Interface in3 = new Interface("ISR", priorityAndQulaityLevels.Medium, priorityAndQulaityLevels.Medium, InterfaceTypes.Mesagge);
       Interface in4  =new Interface("Video", priorityAndQulaityLevels.Medium, priorityAndQulaityLevels.Low, InterfaceTypes.Video);
       Interface in5 = new Interface("Contol", priorityAndQulaityLevels.High, priorityAndQulaityLevels.High, InterfaceTypes.Mesagge);
       
       ArrayList<Interface> listInter = new ArrayList<>();
       listInter.add(in1);
       listInter.add(in2);
       listInter.add(in3);
       listInter.add(in4);
       listInter.add(in5);

        
        TSN one = new TSN("UAV ISR Global");
        one.setType(TSNTypes.UAV);
        one.addInterfaceArray(listInter);
        TSN two = new TSN("Datafusion M");
        two.addInterfaceArray(listInter);
        two.setType(TSNTypes.Radar);
        TSN three = new TSN("Datafusion S");
        three.addInterfaceArray(listInter);
        three.setType(TSNTypes.Radar);
        TSN FOUR = new TSN("Troups");
        FOUR.addInterfaceArray(listInter);
        FOUR.setType(TSNTypes.Troups);
        TSN five = new TSN("Military Hospital");
        five.addInterfaceArray(listInter);
        five.setType(TSNTypes.Hospital);
        TSN six = new TSN("BMS/Soldier");
        six.addInterfaceArray(listInter);
        six.setType(TSNTypes.Troups);
        TSN seven = new TSN("Deployed c2");
        seven.addInterfaceArray(listInter);
        seven.setType(TSNTypes.Comand_Central);
        TSN eight = new TSN("UAV Local");
        eight.addInterfaceArray(listInter);
        eight.setType(TSNTypes.UAV);
        //System.out.println(one.getName());
        
        System.out.println("-----------------------------------------------");
        ///////////////////////////////////////////////////////////////////////
        
        temp.add(one);
        temp.add(two);
        temp.add(three);
        temp.add(FOUR);
        temp.add(five);
        temp.add(six);
        temp.add(seven);
        temp.add(eight);
        task.setNoder(temp);
        task2.setNoder(temp);
        taskList.add(task);
        taskList.add(task2);
        /////////////////////////////////////////////////////
        Gotland.setTasks(taskList);
        Gotland.setName("Gotland");
        Gotland.setInfo("Defend Gtoland from Ryssland");
        Gotland.setPriotetForAllTSN(priorityAndQulaityLevels.High);
        Gotland.setQualityForAllTSN(priorityAndQulaityLevels.Medium);
        //////////////////////////////////////////////////////
        Öland.setTasks(taskList);
        Öland.setName("Öland");
        Öland.setInfo("Defend Öland from Denmark");
        Öland.setPriotetForAllTSN(priorityAndQulaityLevels.High);
        Öland.setQualityForAllTSN(priorityAndQulaityLevels.Low);
        //////////////////////////////////////////////////////
        Blidö.setTasks(taskList);
        Blidö.setName("Blidö");
        Blidö.setInfo("Defend from who?");
        Blidö.setPriotetForAllTSN(priorityAndQulaityLevels.High);
        Blidö.setQualityForAllTSN(priorityAndQulaityLevels.Medium);
        ///////////////////////////////////////////////////////////////////////
        Org.add(Öland);
        Org.add(Gotland);
        Org.add(Blidö);

       /*for (int i = 0; i < 1; i++) {
            for (int j = 0; j < temp.size() ; j++) {
                System.out.println(org.getTasks().get(0).getNoder().get(j).getName());
            }
            
        }*/
       
        
    }
      
    
}
