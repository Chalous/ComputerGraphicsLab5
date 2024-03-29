import java.awt.Color;
import java.util.ArrayList;

/**
 * Scene - the list of items that make up a scene.
 * 
 * Eric McCreath 2009, 2019
 */

public class Scene extends ArrayList<Item> {

	Color background = Color.black;

	public Color raytrace(Ray r) {
		
		Double mindis = null;
		Intersect intersect = null;
		
		for (Item s : this) {
			Intersect i = s.intersect(r);
			if (i != null) {
				if (intersect == null || i.distance < mindis) {
					mindis = i.distance;
					intersect = i;
				}
			}
		}
		if (intersect != null) {
			return intersect.color;
		} else {
			return background;
		}
	}
	
	private double clamp(double r) {
		return (r < 0.0 ? 0.0 : (r > 1.0 ? 1.0 : r));
	}

	

}
