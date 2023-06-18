from tkinter import Text, Frame, INSERT, scrolledtext,END
import os
import pathlib

texto = """Bienvenido al menú principal de Distribuidora JMLMJ

Instrucciones de uso
En el menú superior encontrará las siguientes opciones:

*Archivo: Aquí se desplegarán dos opciones, Aplicación para ver información 
del programa y salir para volver a la ventana principal.

*Procesos y consultas: Aquí se desplegarán las 6 opciones asociadas 
a las funcionalidades del sistema
-Enviar pedido
-Pagar a trabajadores
-Abastecer tiendas
-Gestionar devoluciones
-Mostrar estadísticas

*Ayuda: Aquí se desplegará la opción acerca de donde podrá
consultar el nombre de los desarrolladores"""

class ventanaDeEntrada(Frame):
    def __init__(self, window):
        super().__init__(window)
        text = scrolledtext.ScrolledText(self)
        text.insert(END, texto)
        text.tag_configure('center', justify='center')
        text.configure(state='disabled')
        text.pack(expand=True, fill='both')
        