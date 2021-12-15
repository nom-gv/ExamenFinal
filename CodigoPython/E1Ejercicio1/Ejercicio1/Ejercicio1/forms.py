from django import forms
from django import forms
from django.forms.widgets import CheckboxInput

class CreateNewList(forms.Form):
	name = forms.CharField(label="Name", max_length=200)
	check = forms.BooleanField()