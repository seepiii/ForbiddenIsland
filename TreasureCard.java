import java.awt.image.BufferedImage;

public class TreasureCard {
	private boolean waterRises;
	private boolean action;
	private String actionType;
	private boolean treasure;
	private String treasureType;
	private BufferedImage image;
	
	public TreasureCard(BufferedImage i, boolean w, boolean a, boolean t) {
		image=i;
		waterRises=w;
		action=a;
		treasure=t;
	}
	
	//set methods
	public void setActionType(String s) {
		actionType=s;
		action=true;
	}
	public void setTreasureType(String s) {
		treasureType=s;
		treasure=true;
	}
	
	//get methods
	public boolean isWaterRises() {
		return waterRises;
	}
	public boolean isAction() {
		return action;
	}
	public boolean isTreasure() {
		return treasure;
	}
	public String getActionType() {
		if (action)
			return actionType;
		return null;
	}
	public String getTreasureType() {
		if (treasure)
			return treasureType;
		return null;
	}
	public BufferedImage getImage() {
		return image;
	}
}
