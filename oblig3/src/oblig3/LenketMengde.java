package oblig3;

import java.util.Arrays;

public class LenketMengde<T> implements MengdeADT<T> {
	private Node<T> start;
	private int antall;
	
	private static class Node<T>{
		T data;
		Node<T> neste;
		
		Node(T data){
			this.data = data;
			this.neste = null;
		}
	}
	
	public LenketMengde() {
		this.start = null;
		this.antall = 0;
	}
	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		Node<T> current = start;
		while (current != null) {
			if (element.equals(current.data)) {
				return true;
			}
			current = current.neste;
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		Node<T> current = start;
        while (current != null) {
            if (!annenMengde.inneholder(current.data)) {
                return false;
            }
            current = current.neste;
        }
        return true;
    }

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		if (antallElementer() != annenMengde.antallElementer()) {
            return false;
        }
        for (T element : tilTabell()) {
            if (!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }
	
	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for (T element : tilTabell()) {
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		LenketMengde<T> snitt = new LenketMengde<>();
        for (T element : tilTabell()) {
            if (annenMengde.inneholder(element)) {
                snitt.leggTil(element);
            }
        }
        return snitt;
    }

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		LenketMengde<T> forening = new LenketMengde<>();
        forening.leggTilAlleFra(this);
        forening.leggTilAlleFra(annenMengde);
        return forening;
    }

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		LenketMengde<T> differanse = new LenketMengde<>();
        for (T element : tilTabell()) {
            if (!annenMengde.inneholder(element)) {
                differanse.leggTil(element);
            }
        }
        return differanse;
    }

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
            Node<T> newNode = new Node<>(element);
            newNode.neste = start;
            start = newNode;
            antall++;
        }
    }
	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for (T element : annenMengde.tilTabell()) {
            leggTil(element);
        }
    }


	@Override
	public T fjern(T element) {
		Node<T> current = start;
        Node<T> prev = null;
        while (current != null) {
            if (current.data.equals(element)) {
                if (prev == null) {
                    start = current.neste;
                } else {
                    prev.neste = current.neste;
                }
                antall--;
                return current.data;
            }
            prev = current;
            current = current.neste;
        }
        return null;
    }

	@Override
	public T[] tilTabell() {
		T[] array = (T[]) new Object[antall];
        Node<T> current = start;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.neste;
        }
        return array;
    }

	@Override
	public int antallElementer() {
		return antall;
	}
	
}
