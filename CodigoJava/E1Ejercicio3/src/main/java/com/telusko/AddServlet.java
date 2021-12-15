package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

public class AddServlet extends HttpServlet {
	public interface Function {
		int[][] operacion(int[][] a, int[][] b, int dim);
	}
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		Function suma = (x,y,d) -> {
			int r[][] = new int[d][d];
			for(int i=0; i<d; i++) 
				for(int j=0; j<d; j++) 
					r[i][j] = x[i][j]+y[i][j];
			return r;
		};
		Function resta = (x,y,d) -> {
			int r[][] = new int[d][d];
			for(int i=0; i<d; i++) 
				for(int j=0; j<d; j++) 
					r[i][j] = x[i][j]-y[i][j];
			return r;
		};
		Function multiplicacion = (x,y,d) -> {
			int r[][] = new int[d][d];
			for(int i=0; i<d; i++) {
				for(int j=0; j<d; j++) 
					for(int k=0; k<d; k++) {
						r[i][j] += x[i][k] * y[k][j]; 
					}
			}
			return r;
		};
		Function inversa = (x,y,d) -> {
	         int a[][] = new int[d][d];
	         int b[][] = new int[d][d];
	         int index[] = new int[d];
	         for (int i=0; i<d; ++i)
	        	 b[i][i] = 1;
	         
	         gaussian(a, index);

	         for (int i=0; i<d-1; ++i)
	        	 for (int j=i+1; j<d; ++j)
	        		 for (int k=0; k<d; ++k)
	        			 b[index[j]][k] -= x[index[j]][i]*b[index[i]][k];

	         for (int i=0; i<d; i++) {
	        	 a[d-1][i] = b[index[d-1]][i]/x[index[d-1]][d-1];
	        	 for (int j=d-2; j>=0; j--) {
	        		 a[j][i] = b[index[j]][i];
	        		 for (int k=j+1; k<d; k++) {
	        			 a[j][i] -= x[index[j]][k]*x[k][i];
	        			 }
	        		 a[j][i] /= x[index[j]][j];
	        		 }
	        	 }
	         return a;
		};
		
		int dim = Integer.parseInt(req.getParameter("dim"));
		System.out.println(dim);
		int t1[][] = new int[dim][dim];
		int t2[][] = new int[dim][dim];
		
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				String pos = "1"+i+""+j;
				t1[i][j] = Integer.parseInt(req.getParameter(pos));
				
				pos = "2"+i+""+j;
				t2[i][j] = Integer.parseInt(req.getParameter(pos));
			}
		}
		
		String ope = req.getParameter("ope");
		
		int tr[][] = new int[dim][dim];
		
		if(ope.equals("Suma"))
			tr = calculadora(suma,t1,t2,dim);
		else if(ope.equals("Resta"))
			tr = calculadora(resta,t1,t2,dim);
		else if(ope.equals("Multiplicacion"))
			tr = calculadora(multiplicacion,t1,t2,dim);
		else if(ope.equals("Inversa"))
			tr = calculadora(inversa,t1,t2,dim);
		
		PrintWriter out = res.getWriter();
		
		try {
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>");
			out.print("<meta charset='ISO-8859-1'>");
			out.print("<title>Tercer Ejercicio</title>");
			out.print("<link rel='preconnect' href='https://fonts.googleapis.com'>");
			out.print("<link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
			out.print("<link href='https://fonts.googleapis.com/css2?family=Raleway&display=swap' rel='stylesheet'>");
			out.print("<link rel='stylesheet' type='text/css' href='Style.css'>");
			out.print("</head>");
			out.print("<body>");
			out.print("<div class='body-cont'>");
			out.print("<h1>TERCER EJERCICIO</h1>");
			out.print("<h2>Calculadora de matrices con funciones de orden superior</h2>");
			out.print("<form action='add'>");
			out.print("<div class='uno'>");
			out.print("<div class='tres'>");
			out.print("<input type='text' name='dim' id='dimension' placeholder='Ingrese la dimension de la(s) matriz(ces)' value='"+dim+"'>");
			out.print("<a onclick='redimension()'>Dimension</a>");
			out.print("</div>");
			out.print("<div class='cuatro'>");
			out.print("<div class='cinco'>");
			out.print("<table border='1' id='1'>");
			for(int i=0; i<dim; i++) {
				out.print("<tr>");
				for(int j=0; j<dim; j++) 
					out.print("<td><input type='text' name='1"+i+""+j+"' value="+t1[i][j]+"></td>");
				out.print("</tr>");
			}
			out.print("</table>");
			out.print("</div>");
			out.print("<div class='seis'>");
			out.print("<table border='1' id='2'>");
			for(int i=0; i<dim; i++) {
				out.print("<tr>");
				for(int j=0; j<dim; j++) 
					out.print("<td><input type='text' name='2"+i+""+j+"' value="+t2[i][j]+"></td>");
				out.print("</tr>");
			}
			out.print("</table>");
			out.print("</div>");
			out.print("</div>");
			out.print("<div class='siete'>");
			out.print("<div class='ocho'>");
			out.print("<input type='submit' onmouseenter='cambios(this)' value='Matriz Inversa' style='border-bottom: 2px solid black;'>");
			out.print("<input type='submit' onmouseenter='cambios(this)' value='Suma'>");
			out.print("</div>");
			out.print("<div>");
			out.print("<input type='submit' onmouseenter='cambios(this)' value='Resta' style='border-bottom: 2px solid black;'>");
			out.print("<input type='submit' onmouseenter='cambios(this)' value='Multiplicacion'>");
			out.print("</div>");
			out.print("</div>");
			out.print("</div>");
			out.print("<div class='dos'>");
			out.print("<h3>Resultado</h3>");
			out.print("<table border='1' id='r'>");
			for(int i=0; i<dim; i++) {
				out.print("<tr>");
				for(int j=0; j<dim; j++) 
					out.print("<td><input type='text' name='r"+i+""+j+"' value="+tr[i][j]+"></td>");
				out.print("</tr>");
			}
			out.print("</table>");
			out.print("</div>");
			out.print("<input type='hidden' id='ope' name='ope' value=''>");
			out.print("</form>");
			out.print("</div>");
			out.print("<script type='text/javascript' src='script.js'></script>");
			out.print("</body>");
			out.print("</html>");
		}
		finally {
			out.close();
		}
	}
	
	public static int[][] calculadora(Function funcion, int[][] a, int[][] b, int d) {
		return funcion.operacion(a,b,d);
	}
	
	
	public static void gaussian(int a[][], int index[])  {

        int n = index.length;
        double c[] = new double[n];
        
        for (int i=0; i<n; ++i)
            index[i] = i;
        
        for (int i=0; i<n; ++i) {
            double c1 = 0;
            for (int j=0; j<n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        int k = 0;
        for (int j=0; j<n-1; ++j) {
            double pi1 = 0;
            for (int i=j; i<n; ++i)  {

                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i) {
                int pj = a[index[i]][j]/a[index[j]][j];

                a[index[i]][j] = pj;

                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
	}
}
