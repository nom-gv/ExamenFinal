using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace E1Ejercicio4
{
    public partial class Index : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void MostrarPrimos(object sender, EventArgs e)
        {
            resultado.Text = mostrar(Int32.Parse(num1.Text));
        }
        private Boolean[] cribaEratostenes()
        {
            Boolean [] primo = new bool[100];
            for (int i = 0; i < 100; i++)
                primo[i] = true;
            for (int i = 2; i * i < 100; i++)
                if (primo[i] == true)
                    for (int j = i * 2; j < 100; j+=i)
                        primo[j] = false;
            return primo;
        }
        String mostrar(int n)
        {
            Boolean [] primo = cribaEratostenes();
            String cad = "";
            int r = 0;
            for(int i=2; i<100; i++)
            {
                if (r == n)
                    break;
                else
                {
                    if (primo[i] == true)
                    {
                        cad = cad + i + " ";
                        r++;
                    }
                }
            }
            return cad;
        }
    }
}