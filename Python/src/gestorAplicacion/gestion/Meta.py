# Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
# Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
# FUNCIONALIDAD DE LA CLASE: clase que representa las metas que se le pueden dar a los trabajadores 
# para recibir incentivos monetarios por el cumplimiento de ciertos objetivos. 

import pickle

class Meta:
    def __init__(self, nivelDeDificultad, indice, pago):
        self._nivelDeDificultad = nivelDeDificultad
        self._indice = indice
        self._pago = pago

    # Métodos

    # FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Pago a trabajadores
    # 
    # RECIBE: 
    # El respectivo indice (double) trabajado hasta el momento.
    # 
    # DEVUELVE: 
    # Boolean que representa si la meta fue cumplida o no.
    # 
    # DESCRIPCIÓN: 
    # Este método permite saber si la meta fue o no cumplida.

    def cumpleMeta(self, indiceTrabajado):
        if indiceTrabajado >= self._indice:
            return True
        else:
            return False
        
    
    # FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Pago a trabajadores
    # 
    # RECIBE: 
    # El respectivo indice trabajado hasta el momento.
    # 
    # DEVUELVE: 
    # String con las estadisticas de la meta.
    # 
    # DESCRIPCIÓN:
    # Este método permite obtener el porcentaje cumplido de meta, además del
    # porcentaje faltante y cuando falta para que se cumpla la meta.
    
    def porcentajesCumplidos(self, indiceTrabajado):
        porcentajeindice = (indiceTrabajado*100)/self._indice
        texto = "Porcentaje de la meta cumplido: " + str(porcentajeindice) + "%"
        if porcentajeindice < 100:
            texto += "\nPorcentaje faltante: " + str(100-porcentajeindice) + "%"
            texto += "\nCantidad faltante del indice indicado: " + str(self._indice-indiceTrabajado) 
        return texto
    
    def __str__(self):
        return "Nivel de dificultad: "            + self._nivelDeDificultad + "\n" \
             + "indice requerido: "               + str(self._indice) + "\n" \
             + "Bonificación por cumplimiento: "  + str(self._pago) + "\n"
    
    # Getters and Setters

    def getNivelDeDificultad(self):
        return self._nivelDeDificultad
    
    def setNivelDeDificultad(self, nivelDeDificultad):
        self._nivelDeDificultad = nivelDeDificultad
    
    def getIndice(self):
        return self._indice
    
    def setIndice(self, indice):
        self._indice = indice
    
    def getPago(self):
        return self._pago
    
    def setPago(self, pago):
        self._pago = pago