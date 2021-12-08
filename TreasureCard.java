import java.awt.image.BufferedImage;

public class TreasureCard {
	private boolean waterRises;
	private boolean action;
	private String actionType;
	private boolean treasure;
	private String treasureType="";
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
		return actionType;
	}
	public String getTreasureType() {
		return treasureType;
	}
	public BufferedImage getImage() {
		return image;
	}
}
