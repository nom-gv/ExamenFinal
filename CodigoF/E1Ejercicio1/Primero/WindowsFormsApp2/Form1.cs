using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void numeros(object sender, EventArgs e)
        {
            Button botonActual = (Button)sender;
            Resultado.Text = Resultado.Text + botonActual.Text;
            
        }

        private void operacion(object sender, EventArgs e)
        {
            Button botonActual = (Button)sender;
            Resultado.Text = Resultado.Text + botonActual.Text;
        }

        private void borrar(object sender, EventArgs e)
        {
            String result = Resultado.Text;
            if (result != "")
                result = result.Substring(0, result.Length - 1);
            Resultado.Text = result;
        }

        private void eliminar(object sender, EventArgs e)
        {
            Resultado.Text = "";
            Total.Text = "0";
        }

        private void igual(object sender, EventArgs e)
        {
            String result = Resultado.Text;
            if (result != "")
            {
                if("0123456789".IndexOf(result.Substring(result.Length - 1, 1)) > -1)
                {
                    var respuesta = Evaluar(result);
                    Total.Text = respuesta.ToString();
                }
            }   
        }

        private static Double Evaluar(String expression)
        {
            //Creo un DataTable
            System.Data.DataTable table = new System.Data.DataTable();
            //Realizo el cálculo..
            object result = table.Compute(expression, string.Empty);
            //Lo devuelvo convertido a Double
            return Convert.ToDouble(result);
        }
    }
}
