package movement;

public class Vector2D {
	private double x;
	private double z;
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getZ() {
		return z;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "Vector2D [x=" + x + ", z=" + z + "]";
	}

	public Vector2D() {
		super();
	}

	public Vector2D(double x, double z) {
		super();
		this.x = x;
		this.z = z;
	}
	
	public static Vector2D addVector2D(Vector2D v1, Vector2D v2){
		return new Vector2D(v1.getX() + v2.getX(), v1.getZ() + v1.getX());
	}
	
	public Vector2D addVector2D(Vector2D v){
		this.x += v.getX();
		this.z += v.getZ();
		return this;
	}
	
	public static Vector2D subVector2D(Vector2D v1, Vector2D v2){
		return new Vector2D(v1.getX() - v2.getX(), v1.getZ() - v1.getX());
	}
	
	public Vector2D subVector2D(Vector2D v){
		this.x -= v.getX();
		this.z -= v.getZ();
		return this;
	}
	
	public static Vector2D mulConstant(Vector2D v, double con){
		return new Vector2D(v.getX()*con, v.getZ()*con);
	}
	
	public Vector2D mulConstant(double con){
		this.x *= con;
		this.z *= con;
		return this;
	}
	
	public double getLength(){
		return Math.sqrt(this.x*this.x + this.z*this.z);
	}
	
	public void normalize(){
		double len = this.getLength();
		this.x /= len;
		this.z /= len;
	}
}
