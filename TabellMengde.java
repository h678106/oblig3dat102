package oblig3;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T>{
	private static final int DEFAULT_CAPACITY = 10;
	private T[] elementer;
	private int antall;
	
	public TabellMengde() {
		this.elementer = (T[]) new Object[DEFAULT_CAPACITY];
		this.antall = 0;
	}
	
	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		for (int i =0; i < antall; i++) {
			if (element.equals(elementer[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for (int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(elementer[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		if (antall != annenMengde.antallElementer()) {
			return false;
		}
		for ( int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(elementer[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for (int i = 0; i < antall; i++) {
			if (annenMengde.inneholder(elementer[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> snitt = new TabellMengde<>();
		for (int i = 0; i < antall; i++) {
			if (annenMengde.inneholder(elementer[i])) {
				snitt.leggTil(elementer[i]);
			}
		}
		return snitt;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> union = new TabellMengde<>();
		for (int i = 0; i < antall; i++) {
			union.leggTil(elementer[i]);
		}
		for (T element : annenMengde.tilTabell()) {
			union.leggTil(element);
		}
		return union;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		MengdeADT<T> differanse = new TabellMengde<>();
		for ( int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(elementer[i])) {
				differanse.leggTil(elementer[i]);
			}
		}
		return differanse;
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == elementer.length) {
				utvidKapasitet();
			}
			elementer[antall++] = element;
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
		for (int i = 0; i < antall; i++) {
            if (element.equals(elementer[i])) {
                T fjernetElement = elementer[i];
                elementer[i] = elementer[antall - 1];
                elementer[antall - 1] = null;
                antall--;
                return fjernetElement;
            }
        }
        return null;
    }
	
    @SuppressWarnings("unchecked")
	@Override
	public T[] tilTabell() {
        return Arrays.copyOf(elementer, antall);
	}

    @Override
    public int antallElementer() {
        return antall;
    }

    private void utvidKapasitet() {
        elementer = Arrays.copyOf(elementer, elementer.length * 2);
    }

}
