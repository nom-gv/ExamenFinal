package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

public class AddServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		int nro = Integer.parseInt(req.getParameter("num1"));
		String r = "";
		
		for(int i=1; i<=nro; i++) {
			if(i == nro)
				r = r + fibonacci(i);
			else
				r = r + fibonacci(i) + " ";
		}
		
		PrintWriter out = res.getWriter();
		
		try {
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset='ISO-8859-1'>");
			out.print("<title>Primer Algoritmo</title>");
			out.print("<link rel='preconnect' href='https://fonts.googleapis.com'>");
			out.print("<link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
			out.print("<link href='https://fonts.googleapis.com/css2?family=Raleway&display=swap' rel='stylesheet'>");
			out.print("<link rel='stylesheet' type='text/css' href='Style.css'>");
			out.print("</head>");
			out.print("<body>");
			out.print("<div class=\"body-cont\">");
			out.print("<h1>PRIMER EJERCICIO</h1>");
			out.print("<h2>Fibonacci de 4 terminos</h2>");
			out.print("<form action='add' method='post'>");
			out.print("<input type='text' name='num1' placeholder='Ingresar n�mero de datos a mostrarse' value='"+nro+"'><br>");
			out.print("<hr>");
			out.print("<label>Resultado: </label>");
			out.print("<textarea id='resultado' name='num2' disabled>"+r+"</textarea>");
			out.print("<hr>");
			out.print("<input id='boton' type='submit'>");
			out.print("</form>");
			out.print("</body>");
			out.print("</html>");
		}
		finally {
			out.close();
		}
	}
	
	public static String fibonacci(int n) 
	{  
		if(n == 0) 
			return "0";
		if(n == 1) 
			return "0";
		if(n == 2)
			return "0";
		if(n == 3)
			return "1";
		else
			return Integer.toString(Integer.parseInt(fibonacci(n-1)) + Integer.parseInt(fibonacci(n-2)));
	}
}
