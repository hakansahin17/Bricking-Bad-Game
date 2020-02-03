package domain;


import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

public class DrunkAlien extends Alien{

    private Alien instance;

    public DrunkAlien(){
        this.id=ID.DrunkAlien;
    }

    public DrunkAlien(double brickPercentage){
        this.id=ID.DrunkAlien;
        if(brickPercentage>70){
            instance=new ProtectingAlien(); //new CooperativeAlien();
        }else if(brickPercentage<30){
            instance=new RepairingAlien();
        }else if(brickPercentage>40 && brickPercentage<50){
            instance=new ProtectingAlien();
        }else if(brickPercentage>50 && brickPercentage<60){
           instance=new RepairingAlien();
        }
    }




    public void update() {
        if(instance!=null)
            instance.update();
    }
    public Shape getBounds() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(Game.WIDTH / 50, 20);
		rect.setLocation((int) x, (int)y);
		return rect;
	}

    public void move() {
        if(instance!=null){
        if(instance.x> Game.WIDTH-50) {
            instance.x = 0;
        }
        }
    }

    public void setInstance(double brickPercentage){
        /*if (tempobject.getId().equals(ID.DrunkAlien)){
				DrunkAlien drunk =(DrunkAlien) tempobject;
				int x = (int) drunk.getX();
				int y = (int) drunk.getY();
				if(getBrickCount()/getInitialBrickCount()*100>70 && !drunk.getInstance().getId().equals(ID.CooperativeAlien)){
					drunk.setInstance(new CooperativeAlien());
				}else if(getBrickCount()/getInitialBrickCount()*100<30){
					drunk.setInstance(new RepairingAlien());
				}else if(getBrickCount()/getInitialBrickCount()*100>40 && getBrickCount()/getInitialBrickCount()*100<50 && !drunk.getInstance().getId().equals(ID.ProtectingAlien)){
					drunk.setInstance(new ProtectingAlien());
				}else if(getBrickCount()/getInitialBrickCount()*100>50 && getBrickCount()/getInitialBrickCount()*100<60 && !drunk.getInstance().getId().equals(ID.RepairingAlien)){
					drunk.setInstance(new RepairingAlien());
				}
			}*/
        if(brickPercentage>70 && !getInstance().getId().equals(ID.CooperativeAlien)){
            instance=new ProtectingAlien(); //new CooperativeAlien();
        }else if(brickPercentage<30){
            instance=new RepairingAlien();
        }else if(brickPercentage>40 && brickPercentage<50 && !getInstance().getId().equals(ID.ProtectingAlien)){
            instance=new ProtectingAlien();
        }else if(brickPercentage>50 && brickPercentage<60 && !getInstance().getId().equals(ID.RepairingAlien)){
            instance=new RepairingAlien();
        }
    }

    public Alien getInstance(){
        if (instance==null){

        }
        return instance;
    }
}
