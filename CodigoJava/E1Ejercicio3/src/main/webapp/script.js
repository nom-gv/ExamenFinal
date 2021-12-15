function redimension() {
    var dim = document.getElementById('dimension').value;
    console.log(dim);
    var tabla1 = "<table border='1' id='1'>";
    var tabla2 = "<table border='1' id='2'>";
    var tablar = "<table border='1' id='r'>";
    for (var i = 0; i < dim; i++) {
        tabla1 += "<tr>";
        tabla2 += "<tr>";
        tablar += "<tr>";
        for (var j = 0; j < dim; j++) {
            tabla1 += "<td><input type='text' name='1" + i + "" + j + "'></td>";
            tabla2 += "<td><input type='text' name='2" + i + "" + j + "'></td>";
            tablar += "<td><input type='text' name='r" + i + "" + j + "'></td>";
        }
        tabla1 += "</tr>";
        tabla2 += "</tr>";
        tablar += "</tr>";
    }
    tabla1 += "</table>";
    tabla2 += "</table>";
    tablar += "</table>";
    document.getElementById('1').innerHTML = tabla1;
    document.getElementById('2').innerHTML = tabla2;
    document.getElementById('r').innerHTML = tablar;
}

function cambios(x) {
    console.log(x);
    document.getElementById('ope').value = x.value;
}