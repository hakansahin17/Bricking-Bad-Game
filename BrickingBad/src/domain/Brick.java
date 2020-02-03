package domain;

/**
 * Abstract class that represents the basic brick object in the game. Serves as the superclass of the brick subtype classes.
 * Extends GameObject abstract class.
 */
@SuppressWarnings("serial")
public abstract class Brick extends GameObject {


    private int length;
    private int height;
    private boolean isSelected = false;
    private boolean isHit = false;


    public Brick() {

    }

    /**
     *
     * @return length of the brick
     */
    public int getLength() {
        return length;
    }

    /**
     *
     * @param length length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     *
     * @return height of the brick
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return boolean that indicates whether the brick is currently selected
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     *
     * @param isSelected sets selected/unselected
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    /**
     *
     * @return boolean that indicates whether the brick is hit by the ball.
     */
    public boolean isHit() {
        return isHit;
    }


    /**
     *
     * @param isHit sets isHit boolean
     */
    public void setHit(boolean isHit) {
        this.isHit = isHit;
    }
}