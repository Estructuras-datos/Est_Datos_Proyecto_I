#pragma once
#include <iostream>
using namespace std;

template <typename T>
class NodoDoble {
private:
	T dato;
	NodoDoble* sig;
	NodoDoble* ant;

public:
	NodoDoble(T dato, NodoDoble* sig, NodoDoble* ant) {
		this->dato = dato;
		this->sig = sig;
		this->ant = ant;
	}

	T getDato() {
		return dato;
	}

	void setDato(T dato) {
		this->dato = dato;
	}

	NodoDoble* getSig() {
		return sig;
	}

	void setSig(NodoDoble* sig) {
		this->sig = sig;
	}

	NodoDoble* getAnt() {
		return ant;
	}

	void setAnt(NodoDoble* ant) {
		this->ant = ant;
	}

};