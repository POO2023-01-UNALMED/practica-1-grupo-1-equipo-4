import tkinter as tk
from tkinter import ttk,Frame, END
from tkinter import scrolledtext

class PagoTrabajadores(Frame):
    def __init__(self, window):
        super().__init__(window)

        #--------------Eventos --------------
        def opcionTipoTrabajador():
            pass

        for i in range(8):
            self.rowconfigure(i, weight=1)

        for j in range(4):
            self.columnconfigure(j, weight=1)

        #--------------Titulo y descripción --------------
        frameCabecera = tk.Frame(self)
        frameCabecera.grid(row=0, column=0, columnspan=4,padx=5, pady=5)
        titulo = tk.Label(frameCabecera, text='Pagar a trabajadores', font=("Arial", 15))
        titulo.pack()
        textoDescripcion = """Aquí podra seleccionar alguno de los trabajadores disponibles
        según su función (Conductores,Operarios y Vendedores), pagarles por sus respectivas
        horas trabajadas y además verificar sus metas dando bonificaciones por el cumpliento
        de las mismas"""
        descripcion = tk.Label(frameCabecera, text=textoDescripcion,font=("Arial", 10))
        descripcion.pack()

        #--------------Tipo de trabajador --------------
        frameTipos1 = tk.Frame(self, width=200 ,height=100)
        frameTipos1.grid(row=1, column=1, columnspan=2, padx=5, pady=5)

        frameTipos11 = tk.Frame(frameTipos1)
        frameTipos11.grid(row=1, column=1, padx=5, pady=5)

        textoTipos = tk.Label(frameTipos11, text='Tipos de trabajadores', font=("Arial", 12))
        textoTipos.pack(side='top', anchor='center')

        tipoPredeterminado = tk.StringVar(value='Seleccionar tipo')
        desplegableTipos = ttk.Combobox(frameTipos11, values=["Operarios", "Conductores", "Vendedores"], textvariable=tipoPredeterminado, state='readonly')
        desplegableTipos.pack(side='top', anchor='center')
        #desplegableTipos.bind("<<ComboboxSelected>>",opcionTipoTrabajador)

        #--------------Trabajadores --------------
        frameTipos12 = tk.Frame(frameTipos1)
        frameTipos12.grid(row=1, column=2, padx=5, pady=5)

        textoTrabajadores = tk.Label(frameTipos12, text='Trabajadores', font=("Arial", 12))
        textoTrabajadores.pack(side='top', anchor='center')

        trabajadorPredeterminado = tk.StringVar(value='Seleccionar tipo')
        desplegableTrabajadores = ttk.Combobox(frameTipos12,values=["Roberto", "Carlitos", "Messi"],textvariable=trabajadorPredeterminado, state='readonly')
        desplegableTrabajadores.pack(side='top', anchor='center')
        #desplegableTrabajadores.bind("<<ComboboxSelected>>",opcionTrabajador)






