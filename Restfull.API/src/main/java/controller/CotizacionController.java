package controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cotizacion.Cotizador;
import cotizacion.CotizadorDolar;
import cotizacion.CotizadorPeso;
import cotizacion.CotizadorReal;

@RestController
public class CotizacionController 
{
	private Cotizador cotizador;
	
	/**
	 * Devuelve la cotizacion de la MONEDA en AR$
	 * @param MONEDA 
	 * @return Cotizacion de la MONEDA en Pesos
	 */
	@RequestMapping(value="/MONEDA", method=RequestMethod.GET)
	public double cotizar(@PathVariable String MONEDA)
	{
		System.out.println("Cotizando el "+MONEDA);
		if(MONEDA.equals("Dolar"))
		{
			cotizador = new CotizadorDolar();
		}
		else if(MONEDA.equals("Pesos"))
		{
			cotizador = new CotizadorPeso();
		}
		else if(MONEDA.equals("Real"))
		{
			cotizador = new CotizadorReal();
		}
		
		return cotizador.cotizar();
	}
}
