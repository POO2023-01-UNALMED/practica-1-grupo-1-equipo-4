import tkinter as tk
from tkinter import ttk, Frame

#from gestorAplicacion.gestion import Factura

class Estadisticas(Frame):

    def __init__(self, window):
        super().__init__(window)

        for i in range(5):
            self.rowconfigure(i, weight=1)

        for j in range(8):
            self.columnconfigure(j, weight=1)

        # Create the header frame
        frameCabecera = tk.Frame(self)
        frameCabecera.grid(row=0, column=0, columnspan=8, padx=5, pady=5)

        # Create the title label
        titulo = tk.Label(frameCabecera, text='Estadísticas', font=('Arial', 15))
        titulo.pack()

        # Create the description label
        textoDescripcion = """Aquí podrá ver información estadística sobre las ganancias de la empresa entre dos fechas ingresadas"""
        descripcion = tk.Label(frameCabecera, text=textoDescripcion, font=('Arial', 10))
        descripcion.pack()

        """fechaMin = Factura.getFechaMin()
        fechaMax = Factura.getFechaMax()"""

        fechaMin = 1
        fechaMax = 100

        textoRangoFechas = "La fecha mínima es " + str(fechaMin) + " y la fecha máxima es " + str(fechaMax)

        lblRangoFechas = tk.Label(frameCabecera, text = textoRangoFechas, font=('Arial', 10))
        lblRangoFechas.pack()

        # Create the dates frame
        frameFechas = tk.Frame(self)
        frameFechas.grid(row=1, column=3, columnspan=2, padx=5, pady=5, sticky="n s e w")

        # Create the date 1 label
        lblFecha1 = tk.Label(frameFechas, text='Fecha 1')
        lblFecha1.grid(row=0, column=0)

        # Create the date 2 label
        lblFecha2 = tk.Label(frameFechas, text='Fecha 2')
        lblFecha2.grid(row=1, column=0)

        # Create the date 1 entry
        self.fieldFecha1 = tk.Entry(frameFechas)
        self.fieldFecha1.grid(row=0, column=1, sticky="ew", ipadx=10)

        # Create the date 2 entry
        self.fieldFecha2 = tk.Entry(frameFechas)
        self.fieldFecha2.grid(row=1, column=1, sticky="ew", ipadx=10)

        # Create the ingresar button
        buttonIngresar = tk.Button(frameFechas, text="Ingresar", command=self.ingresar)
        buttonIngresar.grid(row=2, column=0, columnspan=2, pady=10, sticky="ew")

    def ingresar(self):
        
        """..."""

        
