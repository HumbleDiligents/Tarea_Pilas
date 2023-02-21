/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapilas;

/**
 *
 * @author Sebastian
 */
public class Lavaplatos {

    public class Traste {

        private String tipo;

        public Traste(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }

        @Override
        public String toString() {
            return tipo;
        }
    }

    public class Cubierto extends Traste {

        private String tipoCubierto;

        public Cubierto(String tipo, String tipoCubierto) {
            super(tipo);
            this.tipoCubierto = tipoCubierto;
        }

        public String getTipoCubierto() {
            return tipoCubierto;
        }

        @Override
        public String toString() {
            return tipoCubierto + " " + getTipo();
        }
    }

    public class Cubierto extends Traste {

        private String tipoCubierto;

        public Cubierto(String tipo, String tipoCubierto) {
            super(tipo);
            this.tipoCubierto = tipoCubierto;
        }

        public String getTipoCubierto() {
            return tipoCubierto;
        }

        @Override
        public String toString() {
            return tipoCubierto + " " + getTipo();
        }
    }

    public class Pila {

        private Nodo top;

        public Pila() {
            top = null;
        }

        public void push(Traste traste) {
            Nodo nodo = new Nodo(traste);

            if (top == null) {
                top = nodo;
            } else {
                nodo.setSiguiente(top);
                top = nodo;
            }
        }

        public Traste pop() {
            if (top == null) {
                return null;
            } else {
                Nodo temp = top;
                top = top.getSiguiente();
                return temp.getTraste();
            }
        }

        public Traste peek() {
            if (top == null) {
                return null;
            } else {
                return top.getTraste();
            }
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void imprimirPila() {
            Nodo nodoActual = top;

            while (nodoActual != null) {
                System.out.println(nodoActual.getTraste());
                nodoActual = nodoActual.getSiguiente();
            }
        }

        public void agregarCubiertos(Cubierto cubierto) {
            if (isEmpty()) {
                push(cubierto);
            } else {
                Traste trasteActual = peek();

                if (trasteActual instanceof Plato) {
                    ((Plato) trasteActual).agregarCubierto(cubierto);
                } else {
                    push(cubierto);
                }
            }
        }

        public void insertarTraste(Traste traste) {
            if (isEmpty()) {
                push(traste);
            } else {
                Traste trasteActual = peek();

                if (trasteActual instanceof Plato) {
                    ((Plato) trasteActual).pasarCubiertosA((Plato) traste);
                    push(traste);
                } else {
                    push(traste);
                }
            }
        }
    }

    public class Nodo {

    }
    private Traste traste;
    private Nodo siguiente;

    public Nodo(Traste traste) {
        this.traste = traste;
        siguiente = null;
    }

    public Traste getTraste() {
        return traste;
    }

    public void setTraste(Traste traste) {
        this.traste = traste;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

public class Plato extends Traste {

    private Pila cubiertos;

    public Plato() {
        super("Plato");
        cubiertos = new Pila();
    }

    public void agregarCubierto(Cubierto cubierto) {
        cubiertos.push(cubierto);

    }
