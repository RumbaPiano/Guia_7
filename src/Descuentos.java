abstract class Descuentos {

    private double descuento;

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }


    public abstract double montoFinal(double montoInicial);
}
