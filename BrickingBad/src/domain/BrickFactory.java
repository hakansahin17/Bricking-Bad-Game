package domain;

/**
 * Factory class for brick creation. Does not require initialization only method is static.
 */
public class BrickFactory {

    /**
     * REQUIRES: type!=null
     * EFFECTS: Creates a Brick object with the subtype specified by the type string.
     * @param type
     * String which specifies the type of the brick to create.
     * @return
     * A brick object.
     */
	public static Brick getBrick(String type) {
        Brick brick = null;
        if (type.equals("Simple")) {
            brick = new SimpleBrick();
        } else if (type.equals("Half-metal")) {
        	brick = new HalfMetalBrick();
        } else if (type.equals("Mine")) {
        	brick = new MineBrick();
        } else if (type.equals("Wrapper")) {
        	brick = new WrapperBrick();
        }
        return brick;
    }

}
