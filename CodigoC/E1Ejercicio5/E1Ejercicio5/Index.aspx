<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="E1Ejercicio5.Index" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Quinto Ejercicio</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="Estilo/Style.css">
</head>
<body>
	<div class="body-cont">
		<h1>QUINTO EJERCICIO</h1>
		<h2>Hallar el mcd y el mcm</h2>
		<form id="form1" runat="server">
			<div class="uno">
				<input type="text" id="Num1" name="Num1" placeholder="Ingresar Primer Número" runat="server">
                <asp:TextBox ID="Num2" runat="server" placeholder="Ingresar Segundo Número"></asp:TextBox>
			</div>
			<div class="dos">
				<div class="tres cuatro">
                    <asp:Button ID="Button1" runat="server" Text="MCM" onmouseenter="cambio(this)" OnClick="Respuesta"/>
                    <asp:Button ID="Button2" runat="server" Text="MCD" onmouseenter="cambio(this)" OnClick="Respuesta"/>
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
