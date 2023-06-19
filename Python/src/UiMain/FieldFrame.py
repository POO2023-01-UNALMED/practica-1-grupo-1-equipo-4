from tkinter import Frame, Label, Entry, Grid

class FieldFrame(Frame):

    def __init__(self, frame, tituloCriterios, criterios, tituloValores, valores, habilitado):
        super().__init__(frame)

        self.tituloCriterios = tituloCriterios
        self.criterios = criterios
        self.tituloValores = tituloValores
        self.valores = valores
        self.habilitado = habilitado

        self.dict = {}

        for i, criterio in enumerate(self.criterios):
            label = Label(self, text=criterio)
            entry = Entry(self)

            if(valores != None):
                if i < len(self.valores):
                    entry.insert(0, self.valores[i])

            if self.habilitado:
                entry.config(state="disabled" if not self.habilitado else "normal")

            label.grid(row=i, column=0)
            entry.grid(row=i, column=1)

            self.dict[criterio] = entry

    def getValue(self, criterio):
        return self.dict[criterio].get()
    
    def getEntry(self, criterio):
        return self.dict[criterio]
