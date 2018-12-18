package movement;
import movement.Vector2D;

public class KinematicOutput {
	private Vector2D velocity;	
	private double rotation;	
	
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
	
	public KinematicOutput(Vector2D velocity, double rotation) {
		super();
		this.velocity = velocity;
		this.rotation = rotation;
	}
	
	public KinematicOutput() {
		super();
	}
	
	@Override
	public String toString() {
		return "KinematicOutput [velocity=" + velocity + ", rotation=" + rotation + "]";
	}
}
