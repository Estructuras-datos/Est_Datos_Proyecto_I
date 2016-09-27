#pragma once
#include "Nodo.h"


template <typename T>
class ListaDoble {

private:
	Nodo<T>* inicio;
	Nodo<T>* fin;
	int tam;

public:
	ListaDoble() {
		inicio = fin = NULL;
		tam = 0;
	}
	//destructor
	~ListaDoble() {}

	bool isEmpty() {
		return tam == 0;
	}

	int size() {
		return tam;
	}

	void toString() {
		if (!isEmpty()) {
			Nodo<T>* tmp = inicio;
			cout << " <-> ";
			do {
				cout << tmp->getDato() << " <-> ";
				tmp = tmp->getSig();
			} while (tmp != inicio);
			cout << endl;
		}
		else {
			cout << "Lista Vacia!" << endl;
		}
	}

	void addInicio(T e) {
		Nodo<T>* nuevo = new Nodo<T>(e, NULL, NULL);
		if (!isEmpty()) {
			nuevo->setSig(inicio);
			nuevo->setAnt(inicio->getAnt());
			inicio->getAnt()->setSig(nuevo);
			inicio->setAnt(nuevo);
			inicio = nuevo;
			tam++;
		}
		else {
			nuevo->setSig(nuevo);
			nuevo->setAnt(nuevo);
			inicio = nuevo;
			tam++;
		}
	}

	void addFinal(T e) {
		Nodo<T>* nuevo = new Nodo<T>(e, NULL, NULL);
		if (!isEmpty()) {
			inicio->getAnt()->setSig(nuevo);
			nuevo->setSig(inicio);
			nuevo->setAnt(inicio->getAnt());
			inicio->setAnt(nuevo);
			tam++;
		}
		else {
			nuevo->setSig(nuevo);
			nuevo->setAnt(nuevo);
			inicio = nuevo;
			tam++;
		}
	}

	void add(int pos, T e) {
		Nodo<T>* nuevo = new Nodo<T>(e, NULL, NULL);
		if (!isEmpty()) {
			if (pos == 0)
			{
				addInicio(e);
			}
			else if (pos <= size() - 1 && pos >= 0)
			{
				Nodo<T>* tmp = inicio;
				for (int i = 0; i < pos; i++)
				{
					tmp = tmp->getSig();
				}
				nuevo->setSig(tmp);
				nuevo->setAnt(tmp->getAnt());
				tmp->getAnt()->setSig(nuevo);
				tmp->setAnt(nuevo);
				tam++;
			}
			else if (pos == size())
			{
				addFinal(e);
			}
		}
		else {
			cout << "Lista VACIA, posicion invalida!" << endl;
		}
	}


	void remove(int pos) {
		if (!isEmpty()) {
			if (pos == 0) {
				eliminaPrimero();
			}
			else {
				Nodo<T>* aux = inicio;
				int p = 0;
				while (aux->getSig() != inicio && p<pos) {
					aux = aux->getSig();
					p++;
				}
				if (p == pos) {
					aux->getAnt()->setSig(aux->getSig());
					aux->getSig()->setAnt(aux->getAnt());
					tam--;
					delete aux;
				}
			}
		}
	}




	void eliminaPrimero()
	{
		if (!isEmpty())
		{
			if (inicio == inicio->getAnt()) //si solo hay un nodo
			{
				inicio = NULL;
			}
			else
			{

				Nodo<T> *temp = inicio;
				inicio->getSig()->setAnt(inicio->getAnt());
				inicio->getAnt()->setSig(inicio->getSig());
				inicio = inicio->getSig();
				delete temp;
				tam--;
			}

		}
	}



	void clear() {
		while (!isEmpty())
			remove(0);
	}


	ListaDoble<T>* clone() {

		if (!isEmpty()) {
			ListaDoble<T>* nueva = new ListaDoble<T>();
			Nodo<T>* aux = inicio->getSig();
			nueva->addInicio(inicio->getDato()); //en caso de que solo hay 1 nodo no entraria al while

			while (aux != inicio) {
				nueva->addFinal(aux->getDato());
				aux = aux->getSig();
			}
			return nueva;
		}
		return NULL;

	}


	bool contains(T e) {
		if (!isEmpty()) {
			Nodo<T>* aux = inicio;
			for (int i = 0; i<tam; i++) {
				if (aux->getDato() == e)
					return true;
				else aux = aux->getSig();

			}
		}
		return false;
	}


	T get(int pos) {
		if (!isEmpty()) {

			Nodo<T>* aux = inicio;
			int p = 0;
			while (aux->getSig() != inicio && p<pos) {
				aux = aux->getSig();
				p++;
			}
			if (p == pos) {
				return aux->getDato();
			}
		}
		return NULL;

	}


	int indexOf(T e) {

		if (!isEmpty()) {

			Nodo<T>* aux = inicio;
			int p = 0;
			while (aux->getSig() != inicio && aux->getDato() != e) {
				aux = aux->getSig();
				p++;
			}
			return p;
		}
		return -1;

	}




};