package Utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Request 
{
	public static String GETRequest(String URL)
	{
		StringBuffer response = null;
		try
		{
			//Create URL
			URL url;
			url = new URL(URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setUseCaches (false);
		    con.setDoInput(true);
		    con.setDoOutput(true);
			//Send request
			DataOutputStream wr = new DataOutputStream (con.getOutputStream ());
			wr.writeBytes("");
			wr.flush ();
			wr.close ();
			//Get Response	
			InputStream is = con.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			response = new StringBuffer(); 
			while((line = rd.readLine()) != null) 
			{
				response.append(line);
				response.append('\r');
			}
			
		} catch(ProtocolException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response.toString();
	}

}
