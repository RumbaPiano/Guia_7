class DescuentoFijo extends Descuentos{

    @Override
    public double montoFinal(double montoInicial) {
        return montoInicial-this.getDescuento();
    }
}
