package cuenta_compartida;

public class Consumo {
  private String nombre;
  private double costo;

  Consumo(String nombre, double costo) {
    if (costo < 0) throw new Error("El costo de un consumo no puede ser negativo");
    this.nombre = nombre;
    this.costo = costo;
  }

  public double devolverCosto() {
    return this.costo;
  }

  public String devolverNombre() {
    return this.nombre;
  }

  public void imprimirConsumo() {
    System.out.println(this.nombre + "\t\t" + "| $ " + this.costo + "\t|");
  }
}
