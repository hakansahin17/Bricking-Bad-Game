package domain;

@SuppressWarnings("serial")
public abstract class Alien extends GameObject{
	 private boolean isHit = false;

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}
}
