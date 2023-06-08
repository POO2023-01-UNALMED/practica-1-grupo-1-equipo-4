import tkinter as tk
from tkinter import ttk
ventana = tk.Tk()
ventana.title("Ejemplo de Entry")
ventana.geometry("400x200")

def changed(event):
    entrada.delete(0,"end")
    entrada.insert(0,combo.get())

valorDefecto = tk.StringVar(value='ListadoDias')
combo = ttk.Combobox(ventana,values=["Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"],textvariable=valorDefecto)

combo.bind("<<ComboboxSelected>>",changed)
combo.grid(row=0,column=0,padx=10,pady=10,sticky="w")

entrada = tk.Entry(ventana)
entrada.grid(row=0,column=1,padx=10,pady=10,sticky="w")
ventana.mainloop()