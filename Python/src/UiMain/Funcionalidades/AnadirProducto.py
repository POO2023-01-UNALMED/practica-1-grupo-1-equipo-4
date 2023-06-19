import tkinter as tk
from tkinter import Frame, messagebox
from excepciones import ProductoYaExistente, FaltanCamposPorLLenar, SoloNumeros
from gestorAplicacion.produccion.Fabrica import Fabrica
from gestorAplicacion.produccion.Producto import Producto

from UiMain.FieldFrame import FieldFrame

class AnadirProducto(Frame):

    def __init__(self, window):
        super().__init__(window)

        for i in range(6):
            self.rowconfigure(i, weight=1)

        for j in range(8):
            self.columnconfigure(j, weight=1)

        frameCabecera = tk.Frame(self)
        frameCabecera.grid(row=0, column=0, columnspan=8, padx=5, pady=5)

        titulo = tk.Label(frameCabecera, text='Añadir producto', font=('Arial', 15))
        titulo.pack()

        textoDescripcion = """Aquí podrá añadir un producto rellenando el siguiente formulario."""
        descripcion = tk.Label(frameCabecera, text=textoDescripcion, font=('Arial', 10))
        descripcion.pack()

        self.criterios = ["Nombre", "Descripcion", "Valor", "Peso", "Tamaño", "Costo de producción", "Categoria"] 

        self.fp = FieldFrame(self, "Criterio", self.criterios, "Valor", None, True)
        self.fp.grid(row = 1, column = 3)

        frameBotones = Frame(self)
        frameBotones.grid(row = 2, column=3)

        botonIngresar = tk.Button(frameBotones, text = "Ingresar Producto", command = self.ingresarProducto)
        botonIngresar.grid(row = 0, column = 0)

        botonBorrar = tk.Button(frameBotones, text = "Borrar", command = self.borrar)
        botonBorrar.grid(row = 0, column = 1)


    def ingresarProducto(self):

        nombre = self.fp.getValue("Nombre")
        descripcion = self.fp.getValue("Descripcion")
        valor = self.fp.getValue("Valor")
        peso = self.fp.getValue("Peso")
        tamano = self.fp.getValue("Tamaño")
        costoProduccion = self.fp.getValue("Costo de producción")
        categoria = self.fp.getValue("Categoria")

        try:
            if(  len(self.fp.getEntrysVacios()) > 0):
                raise FaltanCamposPorLLenar()

            self.validarCampos()            
            nuevoProducto = Producto(nombre, descripcion, valor, peso, tamano, costoProduccion, categoria)


            fabrica = Fabrica.getListaFabricas()[0]

            try:

                fabrica.anadirProducto(nuevoProducto)

            except(ProductoYaExistente):
                
                messagebox.showerror('Error', str(ProductoYaExistente()))

            else:

                messagebox.showinfo('Producto agregado', 
                                        'El producto fue agregado con éxito.')

                self.borrar()

        except FaltanCamposPorLLenar:
            campos = self.fp.getEntrysVacios()
            c = "\n\n" + "\n".join([campo  for campo in campos])

            messagebox.showerror("Error", str(FaltanCamposPorLLenar(c)))

        except SoloNumeros:
            messagebox.showerror("Error", str(SoloNumeros()))

            
        

    def borrar(self):

        for criterio in self.criterios:

            self.fp.getEntry(criterio).delete(0, tk.END)


    def validarCampos(self):

        lista = [self.fp.getEntry("Valor").get(), self.fp.getEntry("Peso").get(),  self.fp.getEntry("Tamaño").get(), 
              self.fp.getEntry("Costo de producción").get()]
        
        respuesta = self.validarEnteros(lista)

        if(not respuesta):
            raise SoloNumeros

    def validarEnteros(self, lista):
        try:

            for valor in lista:
                if not isinstance(int(valor), int):
                    return False
            return True
        
        except ValueError:
            raise SoloNumeros




        