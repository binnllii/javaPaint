

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	protected static final Color PaintColor = Color.GREEN;
	private final PaintPanel _paintPanel;
	JButton smallButton, medButton, largeButton, blueButton, 
	greenButton, redButton, clearButton, anotherColor, yellowButton;
	
	
	public MainFrame() {
		super("Interactive Paint Application");
		setLayout(new BorderLayout());
		
		_paintPanel = new PaintPanel();
		_paintPanel.setPreferredSize(new Dimension(600, 500));
		add(_paintPanel, BorderLayout.CENTER);
		
		smallButton = new JButton("Small");
		smallButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setShape(PaintPoint.SMALL_SHAPE);			
			}			
		});
		
		medButton = new JButton("Medium");
		medButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setShape(PaintPoint.MED_SHAPE);			
			}			
		});
		largeButton = new JButton("Large");
		largeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setShape(PaintPoint.LARGE_SHAPE);			
			}			
		});
		
		blueButton = new JButton("Blue");
		blueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setGlobalColor(Color.BLUE);			
			}			
		});
		greenButton = new JButton("Green");
		greenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setGlobalColor(Color.GREEN);				
			}			
		});
		redButton = new JButton("Red");
		redButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setGlobalColor(Color.RED);			
			}			
		});
		yellowButton = new JButton("Yellow");
		yellowButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setGlobalColor(Color.YELLOW);			
			}			
		});
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.clearPoints();
			}			
		});
		
		anotherColor = new JButton("Choose another Color");
		anotherColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// MainFrame.this is this for the current MainFrame instance.
				Color color = JColorChooser.showDialog(MainFrame.this, 
						"Choose another color!", Color.GREEN);
				// color will be null if the user hit cancelled.
				if (color != null) {
					_paintPanel.setGlobalColor(color);
				}
			}			 
		});

		
		
		JPanel shapeButtonPanel = new JPanel(new GridLayout(4, 1));
		shapeButtonPanel.add(smallButton);
		shapeButtonPanel.add(medButton);
		shapeButtonPanel.add(largeButton);
		shapeButtonPanel.add(clearButton);
		
		JPanel colorButtonPanel = new JPanel(new GridLayout(5, 1));
		colorButtonPanel.add(blueButton);
		colorButtonPanel.add(greenButton);
		colorButtonPanel.add(redButton);
		colorButtonPanel.add(yellowButton);
		colorButtonPanel.add(anotherColor);
	
		JPanel buttonPanelWest = new JPanel(new GridLayout(2, 1));
		buttonPanelWest.add(colorButtonPanel);
		buttonPanelWest.add(shapeButtonPanel);
		add(buttonPanelWest, BorderLayout.WEST);
		
	}

}