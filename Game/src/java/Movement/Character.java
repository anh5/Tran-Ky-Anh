package movement;

import java.awt.Color;
import java.awt.Graphics;

public class Character {
	private Vector2D position;	
	private double orientation;	
	private Vector2D velocity;	
	private double rotation;	
	private Color color;
	
	// Getter
	// Setter
	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public double getOrientation() {
		return orientation;
	}

	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}

	public Vector2D getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2D velocity) {
		this.velocity = velocity;
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
	
	public Character() {
		super();
	}

	public Character(Vector2D position, double orientation, Vector2D velocity, double rotation, Color c) {
		super();
		this.position = position;
		this.orientation = orientation;
		this.velocity = velocity;
		this.rotation = rotation;
		this.color = c;
	}
	
	@Override
	public String toString() {
		return "Charater [position=" + position + ", orientation=" + orientation + ", velocity=" + velocity
				+ ", rotation=" + rotation + "]";
	}

	public void update(KinematicOutput KinematicOutput, double time){
		this.velocity = KinematicOutput.getVelocity();
		this.rotation = KinematicOutput.getRotation();
		
		this.position.addVector2D(Vector2D.mulConstant(this.velocity, time));
		this.orientation += this.rotation*time;
	}
	

	public void applyNewOrientation(){
		if (this.velocity.getLength()>0){
			this.orientation = Math.atan2(-this.velocity.getX(), this.velocity.getZ());
		}
	}
	
	public void render(Graphics g) {
		g.setColor(this.color);
		g.drawOval((int) this.position.getX(), (int) this.position.getZ(), 50, 50);
		g.drawLine((int) this.position.getX() + 25, (int) this.position.getZ() + 25, (int) this.position.getX() + 25 +  (int) ( 25*Math.sin(this.orientation)), (int) this.position.getZ() + 25 +  (int) ( 25*Math.cos(this.orientation)));
		System.out.println(this.orientation);
	}
}	
