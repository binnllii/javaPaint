
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaintPanel extends JPanel { 
	private ArrayList<PaintPoint> _points;
	
	private Color _globalColor;
	private int _currentShape;
	
	
	
	public PaintPanel() {
		_points = new ArrayList<>();
		_globalColor = Color.BLACK;
		_currentShape = PaintPoint.SMALL_SHAPE;
		  
		MouseAdapter adapter = new MouseAdapter() {
			@Override
		    public void mouseDragged(MouseEvent e) {
				PaintPoint point = new PaintPoint(e.getX(), e.getY(),
						_currentShape, _globalColor);
				_points.add(point);
				repaint(); 
			}
			
			
			public void mouseClicked(MouseEvent e){
				PaintPoint point = new PaintPoint(e.getX(), e.getY(),
						_currentShape, _globalColor);
				_points.add(point);
				repaint();
			}
		};
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
	}
	
		    
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		for (PaintPoint point: _points) {
			g.setColor(point.color());
			point.draw(g);	
		}
	}
	
	
	public void setGlobalColor(Color color) {
		_globalColor = color;
		repaint();
	}
	
	public void setShape(int shape) {
		_currentShape = shape;
	}
	
	public void clearPoints(){
		_points.clear();
		repaint();
	}
	
}