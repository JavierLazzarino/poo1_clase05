package cuenta_compartida;

public class CuentaCompartida {
    private int comensales;
    private Consumo[][] consumos;
    private int ultimoConsumo[];

    CuentaCompartida(int comensales) {
        if (comensales < 1) throw new Error("La cuenta se debe crear con al menos un comensal");
        this.consumos = new Consumo[comensales][100]; // Se establecen hasta 100 consumos por persona
        this.comensales = comensales;
        this.ultimoConsumo = new int[comensales];
    }

    public void agregarConsumo(int comensal, Consumo consumo) {
        this.consumos[comensal -1][this.ultimoConsumo[comensal -1]] = consumo;
        this.ultimoConsumo[comensal -1] ++;
    }

    public double calcularTotalDeConsumos() {
        int acumuladorDeConsumos = 0;
        for (int i = 0; i < this.consumos.length; i ++) {
            for (int j = 0; j < this.ultimoConsumo[i]; j ++) {
                acumuladorDeConsumos += this.consumos[i][j].devolverCosto();
            }
        }
        if (acumuladorDeConsumos == 0) throw new Error("Aún no se realizaron consumos sobre esta cuenta");

        return acumuladorDeConsumos;
    }

    public double calcularPromedioPorComensal() {
        return this.calcularTotalDeConsumos() / this.comensales;
    }

    public void imprimirTicket() {
        System.out.println("\nPromedio por comensal: " + this.calcularPromedioPorComensal() + "\n");

        System.out.println("|-------------------------------|---------------|");
        System.out.println("| Nombre" + "\t\t\t" + "| Precio\t|");
        System.out.println("|-------------------------------|---------------|");
        for (int i = 0; i < this.consumos.length; i ++) {
            for (int j = 0; j < this.ultimoConsumo[i]; j ++) {
                System.out.println("| " + this.consumos[i][j].devolverNombre() + "\t\t" + "| $ " + this.consumos[i][j].devolverCosto() + "\t|");
            }
        }

        System.out.println("|-------------------------------|---------------|");
        System.out.println("| Total" + "\t\t\t\t" + "| $ " + this.calcularTotalDeConsumos() + "\t|");
        System.out.println("|-------------------------------|---------------|");
    }
    
    public static void main(String[] args) {
        CuentaCompartida cuenta1 = new CuentaCompartida(5);

        cuenta1.agregarConsumo(1, new Consumo("Pinta de cerveza", 120));
        cuenta1.agregarConsumo(1, new Consumo("Papas con verdeo", 300));
        cuenta1.agregarConsumo(2, new Consumo("Trago de promocion", 180));
        cuenta1.agregarConsumo(3, new Consumo("Pinta de cerveza", 120));
        cuenta1.agregarConsumo(3, new Consumo("Papas con cheddar", 350));
        cuenta1.agregarConsumo(1, new Consumo("Promo Hamburguesa", 600));
        cuenta1.agregarConsumo(2, new Consumo("Promo Hambueguesa", 600));
        cuenta1.agregarConsumo(1, new Consumo("Pinta de cerveza", 120));
        cuenta1.agregarConsumo(2, new Consumo("Trago - Caipirinha", 200));
        cuenta1.agregarConsumo(3, new Consumo("Volcán de chocolate", 300));
        cuenta1.agregarConsumo(3, new Consumo("Pinta de cerveza", 120));


        cuenta1.imprimirTicket();
    }
    
}
