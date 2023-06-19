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
            label = Label(self, text=criterio, font=("Arial", 12, "bold"), border=2,relief="sunken")
            entry = Entry(self, font=("Arial", 10))

            if(valores != None):
                if i < len(self.valores):
                    entry.insert(0, self.valores[i])

            if self.habilitado:
                entry.config(state="disabled" if not self.habilitado else "normal")

            label.grid(row=i, column=0, padx=5, pady=3)
            entry.grid(row=i, column=1, padx=5, pady=3)

            self.dict[criterio] = entry

    def getValue(self, criterio):
        return self.dict[criterio].get()
    
    def getEntry(self, criterio):
        return self.dict[criterio]
    
    def getEntrysVacios(self):

        entrysVacios = []

        for criterio in self.criterios:

            if(self.getEntry(criterio).get() == ""):
                entrysVacios.append(criterio)

        return entrysVacios

