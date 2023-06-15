from tkinter import Text, Frame, INSERT, scrolledtext,END
import os
import pathlib


class ventanaDeEntrada(Frame):
    def __init__(self, window):
        super().__init__(window)
        text = scrolledtext.ScrolledText(self)
        
        texto = "Bienvenido al menú principal de Distribuidora JMLMJ\n \
                Instrucciones de uso\n \
                ...              "
        text.insert(END, texto)
        text.tag_configure('center', justify='center')
        text.configure(state='disabled')
        text.pack(expand=True, fill='both')
        