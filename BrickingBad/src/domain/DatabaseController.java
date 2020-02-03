package domain;

import UI.GUIGameObject;
import UI.UIController;


import java.io.*;
import java.util.LinkedList;

public class DatabaseController {
    private GameController gc;
    private UIController uic;
    private DatabaseAdapter databaseAdapter;

    private String username;
    private boolean connected;



    public DatabaseController(GameController gameController, UIController uiController) {
        this.gc = gameController;
        this.uic=uiController;
        this.databaseAdapter=new DatabaseAdapter(new LocalDBController(gc, uic));
    }
    public void saveGame(String fileName) {


        databaseAdapter.saveGame(fileName);
        databaseAdapter=new DatabaseAdapter(new LocalDBController(gc, uic));
        databaseAdapter.saveGame(fileName);

    }

    public void loadGame(String fileName) {
    	databaseAdapter=new DatabaseAdapter(new LocalDBController(gc, uic));
        databaseAdapter.loadGame(fileName);
        gc.setInitialBrickCount(gc.objects.size());
        System.out.println(gc.remainingBrickPercentage());

    }


    public void login(String username) {
        this.username = username;
        this.connected = true;
        this.databaseAdapter = new DatabaseAdapter(new RemoteDBController(gc, uic));
    }
    
    public void logout(){
        this.username="";
        this.connected=false;
        this.databaseAdapter=new DatabaseAdapter(new LocalDBController(gc, uic));
    }


    public static void serialize(GameObject obj) {
        try {
            FileOutputStream fileOut = new FileOutputStream("saves.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static GameObject deserialize(String fileName) {
        GameObject obj;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = (GameObject) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Ball class not found");
            c.printStackTrace();
            return null;
        }
        return obj;
    }

}
