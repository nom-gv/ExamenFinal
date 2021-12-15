<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="E1Ejercicio2.Index" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Segundo Ejercicio</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="Estilos/Style.css">
</head>
<body>
	<div class="body-cont">
		<h1>SEGUNDO EJERCICIO</h1>
		<h2>Calculadora con orden superior</h2>
		<form id="form1" runat="server">
			<div class="uno">
				<asp:TextBox ID="Num1" runat="server" Width="50%" placeholder="Ingresar Primer Número" Height="50px"></asp:TextBox>
                <asp:TextBox ID="Num2" runat="server" Width="49.9%" placeholder="Ingresar Segundo Número" Height="50px"></asp:TextBox>
			</div>
			<div class="dos">
				<div class="tres cuatro">
                    <asp:Button ID="Suma" runat="server" Text="Suma" onmouseenter="cambio(this)" OnClick="calculadora" />
                    <asp:Button ID="Resta" runat="server" Text="Resta" onmouseenter="cambio(this)" OnClick="calculadora" />
					<asp:Button ID="Multiplicacion" runat="server" Text="Multiplicacion" onmouseenter="cambio(this)" OnClick="calculadora" />
					<asp:Button ID="Division" runat="server" Text="Division" onmouseenter="cambio(this)" OnClick="calculadora" />
				</div>
				<div class="tres cinco">
                    <asp:TextBox ID="respuesta" runat="server" placeholder="Resultado"></asp:TextBox>
				</div>
			</div>
			<input type="hidden" id="ope" name="ope" value="">
		</form>
	</div>

	<script type="text/javascript">
		function cambio(x) {
			document.getElementById('ope').value = x.value;
		}
	</script>
</body>
</html>