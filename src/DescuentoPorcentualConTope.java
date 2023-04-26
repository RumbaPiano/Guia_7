public class DescuentoPorcentualConTope extends Descuentos{
    private double valorTope;

    public DescuentoPorcentualConTope(double valorTope){
        this.valorTope=valorTope;
    }
    public double getValorTope() {
        return this.valorTope;
    }

    public void setValorTope(double valorTope) {
        this.valorTope = valorTope;
    }
    public boolean porOTope(double montoInicial){
        if(this.valorTope>montoInicial*this.getDescuento()/100){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public double montoFinal(double montoInicial){
        if(this.valorTope>montoInicial*this.getDescuento()/100){
            return montoInicial-(montoInicial*this.getDescuento()/100);
        }else{
            return montoInicial-this.valorTope;
        }
    }


}
