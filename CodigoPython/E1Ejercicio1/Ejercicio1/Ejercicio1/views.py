from django.shortcuts import render
from .forms import CreateNewList

def saludo(request):

	form = CreateNewList()

	if request.method == 'POST':
		form = CreateNewList(request.POST)
		
	context = {'form':form}
	return render(request, 'Paginas/index.html', context)