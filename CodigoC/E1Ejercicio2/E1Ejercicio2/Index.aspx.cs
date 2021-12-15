using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace E1Ejercicio2
{
    public partial class Index : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void calculadora(object sender, EventArgs e)
        {
            Func<int, int, int> suma = (a, b) => a + b;
            Func<int, int, int> resta = (a, b) => a - b;
            Func<int, int, int> multiplicacion = (a, b) => a * b;
            Func<int, int, int> division = (a, b) => a / b;

            string s = (sender as Button).Text;
            int num1 = Int32.Parse(Num1.Text);
            int num2 = Int32.Parse(Num2.Text);

            if(s == "Suma")
                respuesta.Text = suma(num1, num2).ToString();
            else if(s == "Resta")
                respuesta.Text = resta(num1, num2).ToString();
            else if(s == "Multiplicacion")
                respuesta.Text = multiplicacion(num1, num2).ToString();
            else if(s == "Division")
                respuesta.Text = division(num1, num2).ToString();
        }
    }
}