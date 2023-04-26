import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String ruta="..\\Guia_7\\ListaDeProductos.txt";
        Path archivo1 = Paths.get(ruta);
        try{
            FileReader fr = new FileReader(ruta);
            BufferedReader bf = new BufferedReader(fr);
            int lineas= (int) bf.lines().count();
            Producto[] prod = new Producto[lineas];
            int iter=0;
            try {
                for(String linea : Files.readAllLines(archivo1)) {
                    String[] datos = linea.split(";");
                    prod[iter] = new Producto(datos[0],Integer.parseInt(datos[1]),Double.parseDouble(datos[2]));
                    iter++;
                }
                System.out.println("Lista de productos:\n");
                for(int i=0;i<lineas;i++){
                    System.out.println(prod[i].getNombre() +"|Cod:"+ prod[i].getCodigo() +"|$"+ prod[i].getPrecio());
                }
                //Scanner leer = new Scanner(System.in);

                //Se crea un carrito nuevo
                Carrito carrito1 = new Carrito();

                //Se agregan items al carrito
                carrito1.agregarItem(prod[0],2);
                carrito1.agregarItem(prod[1],2);
                carrito1.agregarItem(prod[7],2);

                System.out.println("\nSe agregaron los siguientes productos a su carrito:\n");
                for(ItemCarrito item : carrito1.getItems()){
                    System.out.println(item.getProducto().getNombre()+" * "+item.getCantidad()+" = $"+item.getPrecioTotal());
                }
                System.out.println("Total = $"+carrito1.getPrecioTotal()+" en "+carrito1.getCantidadTotal()+" unidades");

                //Se aplican descuentos(...o no, jeje)
                Descuentos desc1 = new DescuentoFijo();
                desc1.setDescuento(500);
                Descuentos desc2 = new DescuentoPorcentual();
                desc2.setDescuento(20);
                DescuentoPorcentualConTope desc3 = new DescuentoPorcentualConTope(500);
                desc3.setDescuento(25);
                String aplicaDesc = new String("portop");


                switch (aplicaDesc){
                    case "fij":
                        System.out.println("Se aplica descuento fijo de $"+desc1.getDescuento());
                        System.out.println("Total = $"+desc1.montoFinal(carrito1.getPrecioTotal()));
                        break;
                    case "por":
                        System.out.println("Se aplica descuento porcentual de "+desc2.getDescuento()+"%");
                        System.out.println("Total = $"+desc2.montoFinal(carrito1.getPrecioTotal()));
                        break;
                    case "portop":
                        if(desc3.porOTope(carrito1.getPrecioTotal())) {
                            System.out.println("Se aplica descuento porcentual de " + desc3.getDescuento());
                        }else{
                            System.out.println("Se aplica descuento fijo de $" + desc3.getValorTope());
                        }
                        System.out.println("Total = $"+desc3.montoFinal(carrito1.getPrecioTotal()));
                        break;
                    case "non":
                        System.out.println("No se aplican descuentos");
                        break;
                    default:
                        System.out.println("No se definieron descuentos, por lo tanto no se aplican descuentos");
                        break;
                }


            }catch(IOException IOE) {
                System.out.println("No se pudo leer el archivo de productos!");
            }
        }catch(FileNotFoundException FNFE){
            System.out.println("No se pudo abrir el archivo para leer la cantidad de productos!");
        }
    }
}
