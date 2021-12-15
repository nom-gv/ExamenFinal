package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

public class AddServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		String ope = req.getParameter("ope");
		
		int resultado = 0;
		if(ope.equals("MCD")) 
			resultado = mcd(num1,num2);
		else if(ope.equals("MCM"))
			resultado = mcm(num1,num2);
		
		PrintWriter out = res.getWriter();
		
		try {
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset='ISO-8859-1'>");
			out.print("<title>Quinto Ejercicio</title>");
			out.print("<link rel='preconnect' href='https://fonts.googleapis.com'>");
			out.print("<link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
			out.print("<link href='https://fonts.googleapis.com/css2?family=Raleway&display=swap' rel='stylesheet'>");
			out.print("<link rel='stylesheet' type='text/css' href='Style.css'>");
			out.print("</head>");
			out.print("<body>");
			out.print("<div class='body-cont'>");
			out.print("<h1>QUINTO EJERCICIO</h1>");
			out.print("<h2>Hallar el mcd y el mcm</h2>");
			out.print("<form action='add' method='post'>");
			out.print("<div class='uno'>");
			out.print("<input type='text' name='num1' placeholder='Ingresar Primer Número' value='"+num1+"'>");
			out.print("<input type='text' name='num2' placeholder='Ingresar Segundo Número' value='"+num2+"'>");
			out.print("</div>");
			out.print("<div class='dos'>");
			out.print("<div class='tres cuatro'>");
			out.print("<input type='submit' onmouseenter='cambio(this)' value='MCM'>");
			out.print("<input type='submit' onmouseenter='cambio(this)' value='MCD'>");
			out.print("</div>");
			out.print("<div class='tres cinco'>");
			out.print("<input type='text' name='respuesta' placeholder='Resultado' value='"+resultado+"' disabled>");
			out.print("</div>");
			out.print("</div>");
			out.print("<input type='hidden' id='ope' name='ope' value=''>");
			out.print("</div>");
			out.print("</form>");
			out.print("</div>");
			out.print("<script type='text/javascript'>");
			out.print("function cambio(x) {");
			out.print("document.getElementById('ope').value = x.value;");
			out.print("}");
			out.print("</script>");
			out.print("</body>");
			out.print("</html>");
		}
		finally {
			out.close();
		}
	}
	
	public static int mcd (int x, int y) {
		if (x < 0 || y < 0)
			return -1;
		if (y == 0)
			return x;
		return mcd(y, x%y);
	}
	
	public static int mcm (int x, int y) {
		if(x<0 || y < 0)
			return -1;
		return x*y / mcd(x,y);
	}
	
}
