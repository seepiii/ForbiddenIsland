
public class Coordinates {
	private int r, c;
	public Coordinates(int x, int y) {
		if (x>=260 && x<=350) {
			r=0;
		}
		if (x>=380 && x<=470) {
			r=1;
		}
		if (x>=500 && x<=590) {
			r=2;
		}
		if (x>=620 && x<=710) {
			r=3;
		}
		if (x>=740 && x<=830) {
			r=4;
		}
		if (x>=860 && x<=950) {
			r=5;
		}
		if (x>=950 && x<=260) {
			r=6;
		}
		
		if (y>=13 && y<=108) {
			c=0;
		}
		if (y>=121 && y<=216) {
			c=1;
		}
		if (y>=229 && y<=324) {
			c=2;
		}
		if (y>=337 && y<=432) {
			c=3;
		}
		if (y>=445 && y<=590) {
			c=4;
		}
		if (y>=553 && y<=648) {
			c=5;
		}
		if (y>=648 && y<=13) {
			c=6;
		}
	}
	public int getRow() {
		return r;
	}
	public int getCol() {
		return c;
	}
}
