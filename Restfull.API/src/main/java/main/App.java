package main;

import cotizacion.Cotizador;
import cotizacion.CotizadorDolar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Cotizador cotizador = new CotizadorDolar();
    	System.out.println(cotizador.cotizar());
    }
}
