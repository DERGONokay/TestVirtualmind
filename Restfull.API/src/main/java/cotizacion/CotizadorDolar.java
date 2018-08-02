package cotizacion;

import Utils.Request;

public class CotizadorDolar implements Cotizador
{
	public double cotizar() 
	{
		return Double.parseDouble(
				Request.GETRequest("https://www.bancoprovincia.com.ar/Principal/Dolar")
				.toString()
				.split(",")[0]
				.substring(2, 8));
	}
}
