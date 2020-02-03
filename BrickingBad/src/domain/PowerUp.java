package domain;

public interface PowerUp {
	
	public abstract ID getID();
	
	public abstract void activatePaddle(Paddle p);
	
	public abstract void activateBall(Ball b);
	
	public abstract void deactivatePaddle(Paddle p);
	
	public abstract void deactivateBall(Ball b);
	
}