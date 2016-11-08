package Modelo.Ataques;

public abstract class Ataque {
	private double potencia;
	private int cantidad;
	private String tipo;
	
//	Tipo:
//	"N" = Normal
//	"A" = Agua
//	"P" = Planta
//	"F" = Fuego
	
	public void setPotencia(double potencia){
		this.potencia = potencia;
	}
	
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public double getPotencia(){
		return this.potencia;
	}
	
	public int getCantidad(){
		return this.cantidad;
	}
	
	public String getTipo(){
		return this.tipo;
	}
}
