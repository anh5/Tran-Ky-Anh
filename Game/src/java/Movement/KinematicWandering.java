package movement;

public class KinematicWandering {
	private Character character;	
	private double maxSpeed;	
	private double maxRotation;
	
	public Character getCharacter() {
		return character;
	}
	
	public void setCharacter(Character character) {
		this.character = character;
	}
	
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public double getMaxRotation() {
		return maxRotation;
	}
	
	public void setMaxRotation(double maxRotation) {
		this.maxRotation = maxRotation;
	}
	
	public KinematicWandering(Character character, double maxSpeed, double maxRotation) {
		super();
		this.character = character;
		this.maxSpeed = maxSpeed;
		this.maxRotation = maxRotation;
	}

	public KinematicWandering() {
		super();
	}

	@Override
	public String toString() {
		return "KinematicWandering [character=" + character + ", maxSpeed=" + maxSpeed + ", maxOrientation="
				+ maxRotation + "]";
	}
	
	public double randomBinomial() {
		return Math.random() - Math.random();
	}
	
	public KinematicOutput generateKinematicOutput() {		
		double newRotation = randomBinomial()*this.maxRotation;
		
		Vector2D velocity = new Vector2D(Math.sin(character.getOrientation()), Math.cos(character.getOrientation()));
		velocity.mulConstant(maxSpeed);
		
		return new KinematicOutput(velocity, newRotation);
	}
	
	public static void main(String[] args) {
		Character charater = new Character();
		charater.setPosition(new Vector2D(0, 0));

		KinematicWandering kinematicWandering = new KinematicWandering(charater, 2, 3);
		KinematicOutput kinematicOutput = kinematicWandering.generateKinematicOutput();
		
		charater.update(kinematicOutput, 2);
		charater.update(kinematicOutput, 1);
		
		System.out.println(charater);
		charater.update(kinematicOutput, 2);
		
		charater.update(kinematicOutput, 1);
		
		System.out.println(charater);
	}
	
}
