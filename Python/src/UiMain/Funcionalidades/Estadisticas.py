import tkinter as tk

import sys

sys.path.append('../')
from gestorAplicacion.gestion.Factura import Factura
from excepciones import ExceptionFechasFueraDeRango, ExceptionFecha1MayorQueFecha2, Letras2

from tkinter import ttk, Frame, messagebox


class Estadisticas(Frame):

    def __init__(self, window):
        super().__init__(window)
        self.config(bg="#b6fce6")
        for i in range(6):
            self.rowconfigure(i, weight=1)

        self.columnconfigure(0, weight=8)
        self.columnconfigure(1, weight=1)
        self.columnconfigure(2, weight=8)

        frameCabecera = tk.Frame(self, bg="#b6fce6")
        frameCabecera.grid(row=0, column=1, padx=5, pady=5)

        titulo = tk.Label(frameCabecera, text='Estadísticas', font=("Arial", 15, "bold"), bg ="#33a8d6", relief="raised", border=3)
        titulo.pack(padx=3, pady=3, fill="x")

        textoDescripcion = """Aquí podrá ver información estadística 
        sobre las ganancias de la empresa entre dos fechas ingresadas"""
        descripcion = tk.Label(frameCabecera, text=textoDescripcion,font=("Arial", 12), bg ="#93cfbc", border=2,relief="sunken")
        descripcion.pack(padx=3, pady=3)

        fechaMin = Factura.getFechaMin()
        fechaMax = Factura.getFechaMax()

        textoRangoFechas = "La fecha mínima es " + str(fechaMin) + " y la fecha máxima es " + str(fechaMax)

        lblRangoFechas = tk.Label(frameCabecera, text=textoRangoFechas, font=('Arial', 10), bg ="#2a32bf", fg="#ffffff", border=2,relief="sunken")
        lblRangoFechas.pack(pady=6)

        frameFechas = tk.Frame(self, bg="#338dd6",relief="raised",  border=2)
        frameFechas.grid(row=1, column=1, padx=30, pady=5, sticky="nsew")

        for a in range(3):
            frameFechas.rowconfigure(a,weight=1)
        frameFechas.columnconfigure(0, weight=2)
        frameFechas.columnconfigure(1, weight=1)
        frameFechas.columnconfigure(2, weight=2)
        lblFecha1 = tk.Label(frameFechas, text='Fecha 1',font=("Arial", 12, "bold"), relief="raised",  border=2, width=10)
        lblFecha1.grid(row=0, column=0, padx=1, pady=1)

        lblFecha1 = tk.Label(frameFechas, text='Fecha 1',font=("Arial", 12, "bold"), relief="raised",  border=2, width=10)
        lblFecha1.grid(row=0, column=0, padx=1, pady=1)

        lblFecha2 = tk.Label(frameFechas, text='Fecha 2', font=("Arial", 12, "bold"), relief="raised",  border=2, width=10)
        lblFecha2.grid(row=1, column=0, padx=1, pady=1)

        self.fieldFecha1 = tk.Entry(frameFechas, font=("Arial", 12), width=10)
        self.fieldFecha1.grid(row=0, column=2, pady=1)

        self.fieldFecha2 = tk.Entry(frameFechas, font=("Arial", 12), width=10)
        self.fieldFecha2.grid(row=1, column=2, pady=1)

        buttonIngresar = tk.Button(frameFechas, text="Ingresar", command=self.ingresar, font=("Arial", 12, "bold"), relief="raised",  border=2, width=10)
        buttonIngresar.grid(row=2, column=1, pady=10)

        self.frameEstadisticas = tk.Frame(self, bg="#338dd6",relief="raised",  border=2)

        lblGananciasTotales = tk.Label(self.frameEstadisticas, text='Ganancias totales')
        lblGananciasTotales.grid(row=0, column=0, padx=5, pady=5)

        self.entryGananciasTotales = tk.Entry(self.frameEstadisticas)
        self.entryGananciasTotales.grid(row=0, column=1, padx=5, pady=5)

        lblPromedioPorDia = tk.Label(self.frameEstadisticas, text='Promedio por día',font=("Arial", 12, "bold"))
        lblPromedioPorDia.grid(row=1, column=0, padx=5, pady=5)

        self.entryPromedioPorDia = tk.Entry(self.frameEstadisticas, state="readonly", font=("Arial", 12))
        
        self.entryPromedioPorDia.grid(row=1, column=1, padx=5, pady=5)

        estilo = ttk.Style()
        estilo.configure("Estilo.TButton", font=("Arial", 10), padding=5, width=25, bg="#93cfbc")

        buttonGananciasDiscretas = ttk.Button(self.frameEstadisticas, text='Ganancias discretas', command = self.mostrarGananciasDiscretas, style="Estilo.TButton")
        buttonGananciasDiscretas.grid(row=2, column=0, padx=5, pady=5)

        buttonAumentoPorcentual = ttk.Button(self.frameEstadisticas, text='Aumento porcentual', command = self.mostrarAumentoPorcentual, style="Estilo.TButton")
        buttonAumentoPorcentual.grid(row=2, column=1, padx=5, pady=5)

        self.frameModas = tk.Frame(self)
        self.frameModas = tk.Frame(self, bg="#338dd6",relief="raised",  border=2)

        


    def ingresar(self):


        if(self.fieldFecha1.get() == "" or self.fieldFecha2.get() == ""):

                  messagebox.showerror('Error', 
                                 'Debe llenar ambos campos de fecha')
        else:
            try:

                fecha1 = int(self.fieldFecha1.get())
                fecha2 = int(self.fieldFecha2.get())

                self.dict = Factura.gananciasDiscretas(fecha1, fecha2)

                self.frameEstadisticas.grid(row=2, column=0, columnspan=8)

                self.entryGananciasTotales.configure(state="normal")
                self.entryGananciasTotales.delete(0, tk.END)  
                self.entryGananciasTotales.insert(0, str(Factura.gananciasTotales(self.dict)))  # Insert the new text
                self.entryGananciasTotales.configure(state="readonly")

                self.entryPromedioPorDia.configure(state="normal")
                self.entryPromedioPorDia.delete(0, tk.END)  # Limpiar el texto actual si lo deseas
                self.entryPromedioPorDia.insert(0, str(Factura.promedioPorDia(self.dict)))  # Insert the new text
                self.entryPromedioPorDia.configure(state="readonly")


                self.frameModas.grid(row=3, column=0, columnspan=8, padx=5, pady=5)
            
                fecha1 =   int(self.fieldFecha1.get())
                fecha2  =  int(self.fieldFecha2.get())

                tiendaModa     = Factura.moda(fecha1, fecha2, "tienda")
                clienteModa    = Factura.moda(fecha1, fecha2, "cliente")
                transporteModa = Factura.moda(fecha1, fecha2, "transporte")

                lblModaTienda = tk.Label(self.frameModas, text='Tienda más usada: ' + str(tiendaModa))
                lblModaTienda.grid(row=0, column=0, padx=5, pady=5)
            
            
                lblModaTransporte = tk.Label(self.frameModas, text='Transporte más usado: ' + str(transporteModa))
                lblModaTransporte.grid(row=1, column=0, padx=5, pady=5)

                lblModaCliente = tk.Label(self.frameModas, text='Cliente más vendido: ' + str(clienteModa))
                lblModaCliente.grid(row=2, column=0, padx=5, pady=5)

            except(ExceptionFechasFueraDeRango):

                messagebox.showerror('Error', 
                                    str(ExceptionFechasFueraDeRango()) + '.La fecha mínima es {} y la máxima es {}'.format(Factura.getFechaMin(), Factura.getFechaMax()))

            except(ExceptionFecha1MayorQueFecha2):

                messagebox.showerror('Error', 
                                    str(ExceptionFecha1MayorQueFecha2()))
                
            except(ValueError):

                messagebox.showerror('Error', 
                                    str(Letras2()))


    import tkinter as tk

    def mostrarGananciasDiscretas(self):
        # Crear la ventana principal
        ventana = tk.Tk()
        ventana.title("Ganancias Discretas")

        datos = [(k, v) for k, v in self.dict.items()]
        datos.sort()

        # Crear etiquetas para la cabecera
        lbl_dia_header = tk.Label(ventana, text="Día", font=("Arial", 12, "bold"))
        lbl_dia_header.grid(row=0, column=0, padx=5, pady=5)

        lbl_ganancias_header = tk.Label(ventana, text="Ganancias", font=("Arial", 12, "bold"))
        lbl_ganancias_header.grid(row=0, column=1, padx=5, pady=5)

        # Crear la tabla utilizando etiquetas
        for i, (dia, ganancias) in enumerate(datos):
            # Crear etiqueta para el día
            lbl_dia = tk.Label(ventana, text=dia)
            lbl_dia.grid(row=i + 1, column=0, padx=5, pady=5)

            # Crear etiqueta para las ganancias
            lbl_ganancias = tk.Label(ventana, text=ganancias)
            lbl_ganancias.grid(row=i + 1, column=1, padx=5, pady=5)


    def mostrarAumentoPorcentual(self):
        # Crear la ventana principal
        ventana = tk.Tk()
        ventana.title("Aumentos porcentuales")



        # Crear una lista de datos de ejemplo
        datos = [(k, str(v) + "%") for k, v in Factura.aumentoPorcentual(self.dict).items()]
        datos.sort()

        # Crear etiquetas para la cabecera
        lbl_dia_header = tk.Label(ventana, text="Día", font=("Arial", 12, "bold"))
        lbl_dia_header.grid(row=0, column=0, padx=5, pady=5)

        lbl_aumento_header = tk.Label(ventana, text="Aumento Porcentual", font=("Arial", 12, "bold"))
        lbl_aumento_header.grid(row=0, column=1, padx=5, pady=5)

        # Crear la tabla utilizando etiquetas
        for i, (dia, aumento) in enumerate(datos):
            # Crear etiqueta para el día
            lbl_dia = tk.Label(ventana, text=dia)
            lbl_dia.grid(row=i + 1, column=0, padx=5, pady=5)

            # Crear etiqueta para las ganancias
            lbl_aumento = tk.Label(ventana, text= aumento)
            lbl_aumento.grid(row=i + 1, column=1, padx=5, pady=5)



