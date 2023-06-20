import tkinter as tk
from tkinter import Frame, messagebox
from excepciones import ProductoYaExistente, FaltanCamposPorLLenar, SoloNumeros, CategoriaNoValida
from gestorAplicacion.produccion.Fabrica import Fabrica
from gestorAplicacion.produccion.Producto import Producto

from UiMain.FieldFrame import FieldFrame

class AnadirProducto(Frame):

    def __init__(self, window):
        super().__init__(window)
        self.configure(bg="#b6fce6")
        for i in range(6):
            self.rowconfigure(i, weight=1)

        self.columnconfigure(0, weight=2)
        self.columnconfigure(1, weight=1)
        self.columnconfigure(2, weight=2)

        frameCabecera = tk.Frame(self, bg="#b6fce6")
        frameCabecera.grid(row=0, column=1, padx=5, pady=5)

        titulo = tk.Label(frameCabecera, text='Añadir producto', font=("Arial", 15, "bold"), bg ="#33a8d6", relief="raised", border=3 )
        titulo.pack(pady= 5, fill="x")

        textoDescripcion = """Aquí podrá añadir un producto rellenando el siguiente formulario."""
        descripcion = tk.Label(frameCabecera, text=textoDescripcion, font=("Arial", 12), bg ="#93cfbc", border=2,relief="sunken" )
        descripcion.pack(pady= 5)

        contenedorField = tk.Frame(self, width=100, height=200, bg ="#93cfbc") #"#b6fce6"
        contenedorField.grid(row=1, column=1, pady=3, sticky="nsew")
        contenedorField.rowconfigure(0,weight=1)
        contenedorField.columnconfigure(0,weight=1)
        contenedorField.columnconfigure(1,weight=1)
        contenedorField.columnconfigure(2,weight=1)

        self.criterios = ["Nombre", "Descripcion", "Valor", "Peso", "Tamaño", "Costo de producción", "Categoria"] 
        self.fp = FieldFrame(contenedorField, "Criterio", self.criterios, "Valor", None, True)
        self.fp.configure( bg="#33a8d6",relief="raised", border=2, padx=20,pady=20)
        self.fp.grid(row=0,column=1, padx=50, pady=50, sticky="nsew")

        frameBotones = Frame(self, bg="#b6fce6")
        frameBotones.grid(row = 2, column=1, padx=5)

        botonIngresar = tk.Button(frameBotones, text = "Ingresar Producto", command = self.ingresarProducto, width=15, height=3, bg="#1c71b8", font=("Franklin Gothic", 14, "bold"), fg="#ffffff",border=2,relief="raised")
        botonIngresar.grid(row = 0, column = 0, padx=6)

        botonBorrar = tk.Button(frameBotones, text = "Borrar", command = self.borrar, width=10, height=3, bg="#1c71b8", font=("Franklin Gothic", 14, "bold"), fg="#ffffff",border=2,relief="raised")
        botonBorrar.grid(row = 0, column = 1,padx=6)

        lblCategorias = tk.Label(contenedorField, text = "En el campo de categorías los valores válidos son aseo, construccion y consumible." 
                                 , font=("Arial", 12), bg ="#93cfbc", border=2,relief="sunken" )
        lblCategorias.grid(row = 1, column = 1, padx = 6, )


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

            if categoria != "aseo" and categoria != "construccion" and categoria != "consumible":
                raise CategoriaNoValida()

            self.validarCampos()            
            nuevoProducto = Producto(nombre, descripcion, int(valor), int(peso), int(tamano), int(costoProduccion), categoria)


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

        except CategoriaNoValida:
            messagebox.showerror("Error", str(CategoriaNoValida()))
            
        

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




        