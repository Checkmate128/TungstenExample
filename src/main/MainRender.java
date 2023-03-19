package main;

import test.MainScreen;
import ui.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainRender extends JPanel implements ActionListener {

	private Timer gameTimer;

	private static Screen currentScreen;

	public MainRender() {
		super.setDoubleBuffered(true);
		gameTimer = new Timer(16, this);
		gameTimer.start();

		this.setBackground(new Color(0, 200, 0));

		currentScreen = new MainScreen();
	}

	public static void switchScreen(Screen screen) {
		currentScreen = screen;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		render(g2d);
	}

	public void render(Graphics2D g) {
		currentScreen.render(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}
