
import java.awt.Color;
import java.awt.Graphics;

public class PaintPoint {
	public static final int SMALL_SHAPE = 0;
	public static final int MED_SHAPE = 1;
	public static final int LARGE_SHAPE = 2;
	public static final int SizeSmall = 6;
	public static final int SizeMed = 10;
	public static final int SizeLarge = 15;
	
	

	private final int _x;
	private final int _y;
	private final int _size;
	private final Color _color;
	
	public PaintPoint(int x, int y, int size, Color color) {
		_x = x;
		_y = y;
		_size = size;
		_color = color;
	}
	public Color color() {
		return _color;
	}
	
	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}

	public int getSize() {
		return _size;
	}
	
	public void draw(Graphics g) {
		switch (_size) {
		case SMALL_SHAPE:
			g.fillOval(_x, _y, SizeSmall, SizeSmall);
			break;
		case MED_SHAPE:
			g.fillOval(_x, _y, SizeMed, SizeMed);
			break;
		case LARGE_SHAPE:
			g.fillOval(_x, _y, SizeLarge, SizeLarge);
			break;
		
		}
	}
}