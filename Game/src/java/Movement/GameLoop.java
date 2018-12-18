package movement;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GameLoop implements Runnable{
	private boolean isRunning;
	private Demo demo;
	private List<Character> characters;
	private List<KinematicWandering> kinematicWanderings;
      //  1
        private List<KinematicFlee> kinematicFlees;
        private List<Character> CharacterFlees;
        private Character root;
      //2
	public GameLoop(boolean isRunning, Demo demo) {
		super();
		this.isRunning = isRunning;
		this.demo = demo;
		
		Character c1 = new Character(new Vector2D(300, 300), 0, new Vector2D(0, 0), 0, Color.RED);
		Character c2 = new Character(new Vector2D(300, 300), 0, new Vector2D(0, 0), 0, Color.GREEN);
		
                //1
                Character c3 = new Character(new Vector2D(400, 300), 0, new Vector2D(0, 0), 0, Color.black);
		Character c4 = new Character(new Vector2D(200, 300), 0, new Vector2D(0, 0), 0, Color.ORANGE);
		
                //2
                
		this.characters = new ArrayList<Character>();
                //1
                this.CharacterFlees=new ArrayList<Character>();
                //2
		this.kinematicWanderings = new ArrayList<KinematicWandering>();
                //1
                this.kinematicFlees=new ArrayList<KinematicFlee>();
                //2
		
		this.characters.add(c1);
		this.characters.add(c2);
                
                //1
                this.CharacterFlees.add(c3);
                this.CharacterFlees.add(c4);
                //2
                //1
                root=new Character();
                root.setPosition(new Vector2D(300,300));
                root.setRotation(1);
                root.setOrientation(1);
                root.setVelocity(new Vector2D(0,0));
                
                //2
		for (Character c: this.characters) {
			//this.kinematicWandering = new KinematicWandering(c, 5, 1);
			this.kinematicWanderings.add(new KinematicWandering(c, 6, 2));
                }
                //1
                for(Character c:this.CharacterFlees){
                        
                        this.kinematicFlees.add(new KinematicFlee(c,root,2));
                        
		}
                //2
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		/*for (int i=0; i<20; i++) {
			demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
			int x, y;
			x = 100 + i*10;
			y = 100 + i*10;
			demo.getGraphics().drawOval(x, y, 50, 50);
			demo.getGraphics().drawLine(x, y, x + 25, y + 25);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		while (true) {
			demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
                        this.root.render(demo.getGraphics());
			for (Character c: this.characters) {
				c.update(this.kinematicWanderings.get(this.characters.indexOf(c)).generateKinematicOutput(), 2);
				c.render(this.demo.getGraphics());
			}
                        for (Character c: this.CharacterFlees) {
				c.update(this.kinematicFlees.get(this.CharacterFlees.indexOf(c)).generateKinematicOutput(), 2);
				c.render(this.demo.getGraphics());
                        }
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
