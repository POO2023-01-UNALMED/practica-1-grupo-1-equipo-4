from tkinter import Text, Frame, INSERT, scrolledtext,END
import os
import pathlib


class ventanaDeEntrada(Frame):
    def __init__(self, window):
        super().__init__(window)
        self.text = scrolledtext.ScrolledText(self)
        self.text.insert(END, "Mucho texto\n")
        self.text.tag_configure('center', justify='center')
        self.text.pack()