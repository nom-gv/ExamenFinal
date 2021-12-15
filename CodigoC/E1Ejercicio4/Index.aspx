<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="E1Ejercicio4.Index" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Cuarto Algoritmo</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="Estilo/Style.css">
</head>
<body>
	<div class="body-cont">
		<h1>CUARTO EJERCICIO</h1>
		<h2>Mostrar n cantidad de primos</h2>
		<form id="form1" runat="server">
            <asp:TextBox ID="num1" runat="server" Width="100%" placeholder="Numero de datos a mostrar"></asp:TextBox>
            <br>
			<hr>
			<label>Resultado: </label>
            <asp:TextBox ID="resultado" runat="server" Width="100%"></asp:TextBox>
			&nbsp;<hr>
            <asp:Button ID="Button1" runat="server" Text="Mostrar Primos" Width="100%" OnClick="MostrarPrimos"/>
		</form>
	</body>
</html>