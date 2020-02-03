package domain;

import UI.GUIGameObject;
import UI.UIController;
import com.google.gson.Gson;

import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.*;
import org.bson.Document;


import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemoteDBController implements SaveLoad{


    private GameController GC;
    private UIController UIC;

    MongoClient client = MongoClients.create("mongodb+srv://admin:admin@bricking-bad-db-n48sh.mongodb.net/test?retryWrites=true&w=majority");
    MongoDatabase db = client.getDatabase("BrickingBadDB");
    MongoCollection games = db.getCollection("games");
    Gson gson = new Gson();

    public RemoteDBController(GameController gc, UIController uic){
        this.GC=gc;
        this.UIC=uic;
        //TODO

    }

    @Override
    public void saveGame(String fileName){
        System.out.println("Remote save was called.");
        LinkedList<LinkedList> objectLists = new LinkedList<>();
        objectLists.add(GC.objects);
        objectLists.add(UIC.objects);

        String json = gson.toJson(objectLists);
        //gson.fromJson(json, LinkedList.class);
        Document map = new Document("map", json);
        map.put("username", "obayhun");
        games.insertOne(map);
        System.out.println("Remote save was called.");
    }

    @Override
    public void loadGame(String fileName){
        BasicDBObject query = new BasicDBObject();
        query.put("username", "obayhun");
        MongoCursor cursor = games.find(query).cursor();
        Document doc=(Document)cursor.next();

        //System.out.println(gson.fromJson((String) doc.get("map"), LinkedList.class));


        LinkedList<LinkedList> objectLists=gson.fromJson((String) doc.get("map"), LinkedList.class);


        //System.out.println(objectLists.get(0).get(0));
        LinkedList domainObjects =new LinkedList<>();

        LinkedList guiObjects = new LinkedList<>();

        domainObjects.addAll(objectLists.get(0));
        guiObjects.addAll(objectLists.get(1));



        for(Object obj : domainObjects){
            GameObject objj=gson.fromJson((String)obj, GameObject.class);
            System.out.println(objj.getClass());
        }

        GC.objects = domainObjects;
        UIC.objects = guiObjects;
        System.out.println("Remote load was called.");
        //TODO
    }

    public boolean isAvailable(){
        return false;
    }
}
