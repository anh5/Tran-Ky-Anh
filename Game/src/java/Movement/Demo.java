package movement;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Demo extends JFrame {
	private GameLoop gameLoop;
	
	public Demo() {
		this.setSize(600, 600);
		this.setVisible(true);
		gameLoop = new GameLoop(true, this);
		new Thread(gameLoop).start();
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
	}
	
	
}
