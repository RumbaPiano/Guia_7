public class DescuentoPorcentual extends Descuentos {
    @Override
    public double montoFinal(double montoInicial) {
        return montoInicial-(montoInicial*this.getDescuento()/100);
    }
}
