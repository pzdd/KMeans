
public class Ponto  implements Cloneable{
	
	private double x;
	private double y;
	private String nome;
	private double distancia;
	private String centroide;
	
	public Ponto(){
		
	}
	
	public Ponto(double x, double y, String nome){
		this.x = x;
		this.y = y;
		this.nome = nome;
	}
	
	public Ponto clone() throws CloneNotSupportedException{
		return (Ponto) super.clone();
	}
	
/*	public String toString(){
		return "Ponto: "+getNome()+"\n"+"X: "+getX()+" Y: "+getY()+"\nDistancia: "+getDistancia();
	}*/

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public String getCentroide() {
		return centroide;
	}

	public void setCentroide(String centroide) {
		this.centroide = centroide;
	}
	
	
		
		

}
