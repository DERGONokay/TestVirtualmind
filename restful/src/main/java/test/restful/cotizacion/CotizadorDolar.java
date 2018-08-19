package test.restful.cotizacion;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import test.restful.util.Request;

public class CotizadorDolar implements Cotizador
{
	public double cotizar() 
	{
		JSONArray respuesta = null;
			try 
			{
				respuesta = (JSONArray)new JSONParser().parse(Request.GETRequest("https://www.bancoprovincia.com.ar/Principal/Dolar"));
			} catch (ParseException e) {
				e.printStackTrace();
				return 0;
			}
		return Double.parseDouble((String)respuesta.get(0));
	}
}
