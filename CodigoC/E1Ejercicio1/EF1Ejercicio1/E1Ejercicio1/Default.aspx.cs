using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace E1Ejercicio1
{
    public partial class _Default : Page
    {
        private int nro = 0;
        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void mostrarFibonacci(object sender, EventArgs e)
        {
            string r = "";
            nro = Int32.Parse(Ingreso.Text);
            for (int i = 1; i <= nro; i++)
            {
                if (i == nro)
                    r = r + Fibonacci(i);
                else
                    r = r + Fibonacci(i) + " ";
            }
            Salida.Text = r;
        }

        private string Fibonacci(int n)
        {
            if (n == 0)
                return "0";
            if (n == 1)
                return "0";
            if (n == 2)
                return "0";
            if (n == 3)
                return "1";
            return Convert.ToString(Int32.Parse(Fibonacci(n - 1)) + Int32.Parse(Fibonacci(n - 2)));
        }
    }
}