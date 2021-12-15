<%@ Page Title="Home Page" Language="C#" CodeBehind="Default.aspx.cs" Inherits="E1Ejercicio1._Default" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Primer Algoritmo</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="Estilo/Style.css">
</head>
<body>
	<div class="body-cont">
		<h1>PRIMER EJERCICIO</h1>
		<h2>Fibonacci de 4 terminos</h2>
		<form id="form1" runat="server">
			<asp:TextBox ID="Ingreso" runat="server" Width="100%" placeholder="Ingresar Numero de Fibonacci"></asp:TextBox>
            <br>
			<hr>
			<label>Resultado: </label>
            
			&nbsp;<asp:TextBox ID="Salida" runat="server" Height="269px" Width="100%"></asp:TextBox>
            
            <hr>

			<asp:Button ID="Button1" runat="server" Text="Button" Width="100%" Height="35px" OnClick="mostrarFibonacci" />
			
		</form>
	</div>
</body>
</html>

