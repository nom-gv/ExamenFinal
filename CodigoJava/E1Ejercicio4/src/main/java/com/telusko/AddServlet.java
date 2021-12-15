package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

public class AddServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		int nro = Integer.parseInt(req.getParameter("num1"));
		String r = mostrar(nro);
		PrintWriter out = res.getWriter();
		
		try {
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset='ISO-8859-1'>");
			out.print("<title>Cuarto Algoritmo</title>");
			out.print("<link rel='preconnect' href='https://fonts.googleapis.com'>");
			out.print("<link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
			out.print("<link href='https://fonts.googleapis.com/css2?family=Raleway&display=swap' rel='stylesheet'>");
			out.print("<link rel='stylesheet' type='text/css' href='Style.css'>");
			out.print("</head>");
			out.print("<body>");
			out.print("<div class=\"body-cont\">");
			out.print("<h1>CUARTO EJERCICIO</h1>");
			out.print("<h2>Mostrar n cantidad de primos</h2>");
			out.print("<form action='add' method='post'>");
			out.print("<input type='text' name='num1' placeholder='Ingresar número de datos a mostrarse' value='"+nro+"'><br>");
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
	
	boolean[] cribadeEratostenes()
    {
        boolean primo[] = new boolean[100];
        for(int i=0;i<100;i++)
            primo[i] = true;

        for(int i = 2; i*i < 100; i++)
        {
            if(primo[i] == true)
            {
                for(int j = i*2; j < 100; j += i)
                    primo[j] = false;
            }
        }

        return primo;
    }
	String mostrar(int n) {
		boolean primo[] = cribadeEratostenes();
		String cad = "";
		int r = 0;
		for(int i=2; i<100; i++) {
			if(r == n)
				break;
			else {
				if(primo[i] == true) {
					cad = cad + i + " ";
					r++;
				}
			}
		}
		return cad;
	}
}
