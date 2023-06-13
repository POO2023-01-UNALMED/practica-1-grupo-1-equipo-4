import tkinter as tk

ventana = tk.Tk()
ventana.geometry("500x500+350+100")
ventana.title("Abastecer")

ventana.columnconfigure(0, weight=1)
ventana.columnconfigure(1, weight=1)
# Crear el marco izquierdo
marco_izquierdo = tk.Frame(ventana, bg="#45ffb8")
marco_izquierdo.columnconfigure(0, weight=1)
marco_izquierdo.grid(row=0, column=0,padx=10, pady=10, sticky="nsew")
# Crear el marco derecho
marco_derecho = tk.Frame(ventana, bg="#4287f5")
marco_derecho.columnconfigure(0, weight=1)
marco_derecho.grid(row=0, column=1,padx=10, pady=10, sticky="nsew")
# Configurar el peso para que los marcos se ajusten al tamaño de la ventana
ventana.rowconfigure(0, weight=2)

ventana.mainloop()