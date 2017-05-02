/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui2;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.InterfaceTypes;
import model.TSNTypes;
import model.Task;
import model.guiControler;
import model.priorityAndQulaityLevels;

/**
 *
 * @author jonas
 */
public class GUI2 extends Application {
           
    
   private BorderPane root;
   private GridPane  border;
   private Button ButtonOverview,ButtonInterface,ButtonNodes;
   private MenuItem SetGroupOrg,SetPrioritForAllTask,SetQualityForAllTask,SetQualityForOneTask,SetPriorityForOneTask;
   private MenuItem SendToSystem,P_2_P_MenuItem,SendToSystemItem;
   private guiControler Contolloer;
   private Menu SetTaskmMenu,SetInterfacemMenu,P_2_P_Menu,SendMenu,ModeMenu;
   private ComboBox <String> choiceBox;
   private CheckMenuItem Plan,Live,Simulate;
   private ListView<String> ListOfTasks;
   private HBox TopLine,TopLineLine2,CenterHBox;
   private VBox ToplineVBox,CentetVBox;
   private MenuBar menulist;
   private GridPane Net;
   private Tab Overview,Interface,Nodes,tabPlanScren;
   private TabPane tabPane;
    @Override   
    
    public void start(Stage primaryStage) {
       
        Contolloer = new guiControler(this);        
        root = new BorderPane();
        tabPane = new TabPane();
        border = new GridPane();
        TopLine = new HBox(20);
        TopLineLine2 = new HBox();
        ToplineVBox = new VBox();
        Contolloer.setScreen();        
        Live.setSelected(false);
        Simulate.setSelected(false);
       
        ///////////////////////////////////////////////////////////////////////
        
        
        /////////////////////////////////////////////////////
       
        
           
        /////////////////////Menu ////////////////////////////////////////
       
        Label Orginations = new Label("Organization:");
        Label Task = new Label("Task");
        ///////////////////////Task Menu///////////////////////////////////////////
       
        
       
        
        
        
        /*root.setStyle("-fx-background-color: linear-gradient(to bottom," +
                    " black 60, #141414 60.1%, black 100%);");*/
        
        
        menulist = new MenuBar();
        menulist.getMenus().addAll(SetTaskmMenu,SetInterfacemMenu,P_2_P_Menu,SendMenu,ModeMenu);
        /////////////////////////////////////////////////////////////
        TopLine.setAlignment(Pos.CENTER_LEFT);
        TopLine.setSpacing(20);
        
        TopLine.getChildren().addAll(choiceBox,menulist); 
        TopLineLine2.setSpacing(20);
        TopLineLine2.getChildren().addAll(Task);
       
               
               
       ToplineVBox.getChildren().addAll(TopLine);
       
       root.setTop(ToplineVBox);
       root.setCenter(tabPane);
       
        SetColor();
        Scene scene = new Scene(root, 700, 300);
        
        primaryStage.setTitle("GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    
    }
    
   public void SetTabsForLiveMode(){
       tabPane.getTabs().clear();
        Overview = new Tab("Overwiew");
        Interface = new Tab("Interface");
        Nodes = new Tab("Nodes");
        Overview.setClosable(false);
        Interface.setClosable(false);
        Nodes.setClosable(false);        
        tabPane.getTabs().addAll(Overview,Interface,Nodes);      
        root.setLeft(ListOfTasks);   
        
        
   }
    
public void ButtonTopLine(){
    ButtonOverview = new Button("Overview");
    ButtonOverview.addEventHandler(ActionEvent.ACTION, new ButtonChoice());
    ButtonInterface = new Button("Interface");
    ButtonInterface.addEventFilter(ActionEvent.ACTION, new ButtonChoice());
    ButtonNodes = new Button("Nodes");
    ButtonNodes.addEventFilter(ActionEvent.ACTION, new ButtonChoice());
    
}
public void ModeMenu(){
    ModeMenu = new Menu("_Mode");
    Plan = new CheckMenuItem("Plan");
    Plan.addEventHandler(ActionEvent.ACTION, new ModeMenuChoice());
    Live = new CheckMenuItem("Live");
    Live.addEventHandler(ActionEvent.ACTION, new ModeMenuChoice());
    Simulate = new CheckMenuItem("Simnulate");
    Simulate.addEventHandler(ActionEvent.ACTION, new ModeMenuChoice());
    ModeMenu.getItems().addAll(Plan,Live,Simulate);

}   

public void TaskMenu(){
    SetTaskmMenu = new Menu("_Task");
    SetPrioritForAllTask = new MenuItem("Set Priority for all task");
    SetPrioritForAllTask.addEventHandler(ActionEvent.ACTION, new MenuTaskChoice());
   SetQualityForAllTask = new MenuItem("Set Quality for all task");
   SetQualityForAllTask.addEventHandler(ActionEvent.ACTION, new MenuTaskChoice());
    SetTaskmMenu.getItems().addAll(SetPrioritForAllTask,SetQualityForAllTask);
        
}

public void InterfaceMenu(){
    SetInterfacemMenu = new Menu("_Interface");
    SetPriorityForOneTask = new MenuItem("Set Priority");
    SetPriorityForOneTask.addEventHandler(ActionEvent.ACTION, new menuInterfaceChoice());
    SetQualityForOneTask = new MenuItem("Set Quality");
    SetQualityForOneTask.addEventHandler(ActionEvent.ACTION, new menuInterfaceChoice());
    SetInterfacemMenu.getItems().addAll(SetPriorityForOneTask,SetQualityForOneTask);
}

public void SendMenu(){
    SendMenu = new Menu("_Send");
    SendToSystem = new Menu("Send to system");
    SendToSystem.addEventHandler(ActionEvent.ACTION, new MenuSendChoice());
    SendMenu.getItems().add(SendToSystem);
}

public void P_2_PMenu(){
    P_2_P_Menu = new Menu("_P_2_P");
    P_2_P_Menu.addEventHandler(ActionEvent.ACTION, new MenuP_2_PChoice());
    P_2_P_MenuItem = new MenuItem("P-2-P");
    P_2_P_MenuItem.addEventHandler(ActionEvent.ACTION, new MenuP_2_PChoice());
    P_2_P_Menu.getItems().add(P_2_P_MenuItem);
}

public void OrgMenu(ArrayList<String> TasknName){
    
    choiceBox = new ComboBox<>();
    //choiceBox.setStyle("-fx-Background-color: black");    
    choiceBox.getItems().addAll(TasknName); 
    choiceBox.setPromptText("Orginsation");
    choiceBox.getSelectionModel().selectedItemProperty().addListener((v,oldvalue,newvalue) -> Contolloer.ChoiceOfOrg(newvalue));
    
}
public void setListOfTask(){
    ListOfTasks = new ListView<String>();
    ListOfTasks.setPrefSize(100, 280);
    ListOfTasks.getSelectionModel().selectedIndexProperty().addListener((v,oldvalue,newvalue)-> Contolloer.setDesierdTask((int) newvalue));
    
}
public void UppdateListOfTask(ArrayList<String> task){
     ListOfTasks.getItems().clear();
     ListOfTasks.getItems().addAll(task);
   
}

public void SetColor(){
    TopLine.setStyle("-fx-background-color: #ccccb3");
    TopLineLine2.setStyle("-fx-background-color: #ccccb3");
    menulist.setStyle("-fx-background-color: #ccccb3");
    choiceBox.setStyle("-fx-background-color: #ccccb3");
    ButtonOverview.setStyle("-fx-background-color: #ccccb3");
    ButtonInterface.setStyle("-fx-background-color: #ccccb3");
    ButtonNodes.setStyle("-fx-background-color: #ccccb3");

}    

 

  



    private class ButtonChoice implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == ButtonOverview) {
                System.out.println("Overview");
                Contolloer.Overview();
            }
            else if (event.getSource() == ButtonInterface) {
                System.out.println("Interface");
                InterfaceScreen();
            }
            else if(event.getSource() == ButtonNodes){
                System.out.println("Nodes");
            }
        }
    }

    private class ModeMenuChoice implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == Plan) {
               // Live.setSelected(false);
                //Simulate.setSelected(false);
                Contolloer.modeState(true, false,false);
            }
            else if (event.getSource() == Live) {
               // Plan.setSelected(false);
               // Simulate.setSelected(false);
                Contolloer.modeState(false, true,false);
            }
            else if (event.getSource() == Simulate) {
               // Plan.setSelected(false);
               // Live.setSelected(false);
                Contolloer.modeState(false, false,true);
            }
        }
    }
    
    public void upDateModeState(boolean Plan,boolean Live,boolean Simulate){
        this.Plan.setSelected(Plan);
        this.Live.setSelected(Live);
        this.Simulate.setSelected(Simulate);
    }
    private class MenuP_2_PChoice implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           
            if (event.getSource() == P_2_P_MenuItem) {
                System.out.println("P_2_P\n");
                
            }
        }
    }

    private class MenuSendChoice implements EventHandler<ActionEvent>{

       

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == SendToSystem) {
                System.out.println("Send To System\n");
                
            }
        }
    }
   

//////////////////////////////////////////////////////////////////////////
    

    private class MenuTaskChoice implements EventHandler<ActionEvent>{

        
        @Override
        public void handle(ActionEvent event) {
            
            if (event.getSource() == SetQualityForAllTask) {
                System.out.println("Set Quality\n");
                
            }else if (event.getSource() == SetPrioritForAllTask) {
                System.out.println("Set Priority\n");
            }
                
        }
    }

    private class menuInterfaceChoice implements EventHandler<ActionEvent>{

       
        
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == SetPriorityForOneTask) {
                System.out.println("Set priority\n");
            }
            else if(event.getSource() == SetQualityForOneTask){
                System.out.println("Set Quality\n");
            }
        }
    }
    
    
    public void  OverViewSceen(priorityAndQulaityLevels GlobalPriorityIput,priorityAndQulaityLevels GlobalQualityInput,String info){
        Net = new GridPane();
        CenterHBox = new HBox();
        CentetVBox = new VBox();
        Label labelText = new Label("Information:");
        //Text texttest = new Text(info);
        TextArea text = new TextArea(info);
        text.setMaxWidth(150);
        text.setPrefColumnCount(10);
        text.setWrapText(true);
        
        ////////////////////////////////////////////////////////////////
        System.out.println("Priority: "+GlobalPriorityIput.toString());
        System.out.println("Quality: "+GlobalQualityInput.toString());
        System.out.println("Info: "+info);
        ////////////////////////////////////////////////////////////////
        
        Label globalPriotet = new Label("Global Priority:");
        Label globalQuality = new Label("Global Quality:");
        Net.setVgap(20);
        Net.setHgap(20);
        Net.setAlignment(Pos.TOP_CENTER);
        CentetVBox.setAlignment(Pos.TOP_CENTER);
        Net.add(globalPriotet,0,2);
        Net.add(globalQuality, 0, 3);
        
        Label temp1 = new Label(GlobalPriorityIput.toString());
        Label temp2 = new Label(GlobalQualityInput.toString());
        Net.add(temp1, 1, 2);
        Net.add(temp2, 1, 3);
        CentetVBox.getChildren().addAll(labelText,text);
        CenterHBox.setSpacing(20);
        CenterHBox.setAlignment(Pos.CENTER_LEFT);
        CenterHBox.getChildren().addAll(CentetVBox,Net);        
        Overview.setContent(CenterHBox);
        
    }
public void InterfaceScreen(){  
     
       
        TreeItem<String> root;
        
        root = new TreeItem<>();
        root.setExpanded(true);
        
      makeTreeAreaInterface(root);
        
        TreeView tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v,oldvalue,newvalue) -> {System.out.println(newvalue);});
            
        
        
    
    Interface.setContent(tree);
}
public void NodeTabScreen(){
     
        TreeItem<String> root;
        
        root = new TreeItem<>();
        root.setExpanded(true);
        
      makeTreeAreaNode(root);
        
        TreeView tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v,oldvalue,newvalue) -> {System.out.println(newvalue);});
            
        
        
    
    Nodes.setContent(tree);
}

  public TreeItem<String> makeBrach(String titel,TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(titel);
        item.setExpanded(true);        
        parent.getChildren().add(item);
        return item;
    }
  
  public void makeTreeAreaInterface(TreeItem<String> parentItem){
      for (int i = 1; i < InterfaceTypes.values().length+1; i++) {
          TreeItem<String> item = new TreeItem(InterfaceTypes.getTypes(i).toString());
          item.setExpanded(true);
          parentItem.getChildren().add(item);
      }
  }
  public void makeTreeAreaNode(TreeItem<String> parentItem){
      for (int i = 1; i < TSNTypes.values().length+1; i++) {
          TreeItem<String> item = new TreeItem(TSNTypes.getTypes(i).toString());
          item.setExpanded(true);
          parentItem.getChildren().add(item);
      }
  }
  
  public void makeNewTabView(String Name){
      Tab item = new Tab(Name);
      tabPane.getTabs().add(item);
      
      
    
      
  }
  
  public void screenForPlanMode(ObservableList<Task> Tasks){
      tabPlanScren = new Tab("Misions");
      tabPane.getTabs().clear();
      
      TableView<Task> table = new TableView<>();
      ObservableList<String> ratingSample = FXCollections.observableArrayList("High","Medium","Low");
        
        
        TableColumn<Task,String> nameColum = new TableColumn<>("Mision");
        nameColum.setMinWidth(200);
        nameColum.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        
         TableColumn<Task,String> priceColum = new TableColumn<>("Info");
        priceColum.setMinWidth(200);
        priceColum.setCellValueFactory(new PropertyValueFactory<>("info"));
        
         TableColumn<Task,String> QuantityColum = new TableColumn<>("Priority");
        QuantityColum.setMinWidth(100);
        QuantityColum.setCellValueFactory(new PropertyValueFactory<>("priorityFromPlan"));
        
        TableColumn<Task,String> SetPriority = new TableColumn<>("Priority");
        SetPriority.setMinWidth(100);
        SetPriority.setCellValueFactory(new PropertyValueFactory<>("priorityFromPlan"));
       
      
     
        SetPriority.setCellFactory(new Callback<TableColumn<Task, String>, TableCell<Task, String>>() {
          @Override
          public TableCell<Task, String> call(TableColumn<Task, String> param) {
              TableCell<Task,String> cellTemp = new TableCell<Task, String>(){
                  
              public void updateItem(String item, boolean empty){
                  ObservableList<String> ratingSample = FXCollections.observableArrayList("High","Medium","Low");
                  
                  if (item != null) {
                       ChoiceBox coicebox = new ChoiceBox(ratingSample);
                       coicebox.getSelectionModel().select(ratingSample.indexOf(item));                       
                       setGraphic(coicebox);                       
                       //obejct.setPriorityFromPlan(item);
                      
                  }
                  
              }
              
              };
              
              
              return cellTemp;
          }
      });        
        
       /*  rating.setCellFactory(new Callback<TableColumn<Music,Integer>,TableCell<Music,Integer>>(){        
            @Override
            public TableCell<Music, Integer> call(TableColumn<Music, Integer> param) {                
                TableCell<Music, Integer> cell = new TableCell<Music, Integer>(){
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        if(item!=null){
                            
                           ChoiceBox choice = new ChoiceBox(ratingSample);                                                      
                           choice.getSelectionModel().select(ratingSample.indexOf(item));
                           //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                           setGraphic(choice);
                        } 
                    }
                };                           
                return cell;
            }
            
        }); */ 
        
        table.setItems(Tasks);
        table.getColumns().addAll(nameColum,priceColum,QuantityColum,SetPriority);
        
        VBox box = new VBox();
        box.getChildren().add(table);
        tabPlanScren.setContent(box);
        tabPlanScren.setClosable(false); 
        tabPane.getTabs().add(tabPlanScren);
      
      
      
  }

    
    
}

  
  
