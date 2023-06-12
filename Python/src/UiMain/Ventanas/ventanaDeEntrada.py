from tkinter import Text, Frame, INSERT, scrolledtext,END
import os
import pathlib


class ventanaDeEntrada(Frame):
    def __init__(self, window):
        super().__init__(window)
        self.text = scrolledtext.ScrolledText(self)
        texto = "Bienvenido al menú principal de Distribuidora JMLMJ\n \
                Instrucciones de uso\n \
                ...              "
        self.text.insert(END, texto)
        self.text.tag_configure('center', justify='center')
        self.text.configure(state='disabled')
        self.text.pack()
        