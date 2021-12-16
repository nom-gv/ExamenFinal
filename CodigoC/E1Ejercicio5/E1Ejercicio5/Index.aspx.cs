using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace E1Ejercicio5
{
    public partial class Index : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Respuesta(object sender, EventArgs e)
        {
            string s = (sender as Button).Text;
            int num1 = Int32.Parse(Num1.Value);
            int num2 = Int32.Parse(Num2.Text);

            if(s == "MCD")
            {
                Num1.Value = num1.ToString();
                respuesta.Text = mcd(num1, num2).ToString();
            }
            else
            {
                Num1.Value = num1.ToString();
                respuesta.Text = mcm(num1, num2).ToString();
            }

        }

        public int mcd(int x, int y)
        {
            if (x < 0 || y < 0)
                return -1;
            if (y == 0)
                return x;
            return mcd(y, x % y);
        }

        public int mcm(int x, int y)
        {
            if (x < 0 || y < 0)
                return -1;
            return x * y / mcd(x, y);
        }
    }
}