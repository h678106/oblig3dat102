package oblig3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T>{
	private Set<T> set;
	
	public JavaSetToMengde() {
		this.set = new HashSet<>();
		
	}
	@Override
	public boolean erTom() {
		return set.isEmpty();
	}

	@Override
	public boolean inneholder(T element) {
		return set.contains(element);
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for (T element : tilTabell()) {
	        if (!annenMengde.inneholder(element)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		Set<T> annenSet = new HashSet<>();
	    for (T element : annenMengde.tilTabell()) {
	        annenSet.add(element);
	    }
	    return set.equals(annenSet);
	}
	
	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		List<T> annenListe = Arrays.asList(annenMengde.tilTabell());
	    Set<T> annenSet = new HashSet<>(annenListe);
	    for (T element : set) {
	        if (annenSet.contains(element)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		Set<T> snittSet = new HashSet<>(set);
	    snittSet.retainAll(new HashSet<>(Arrays.asList(annenMengde.tilTabell())));
	    JavaSetToMengde<T> snitt = new JavaSetToMengde<>();
	    for (T element : snittSet) {
	        snitt.leggTil(element);
	    }
	    return snitt;
	}
	
	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> forening = new JavaSetToMengde<>();
        forening.leggTilAlleFra(this);
        forening.leggTilAlleFra(annenMengde);
        return forening;
    }
	
	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		Set<T> annenSet = new HashSet<>(Arrays.asList(annenMengde.tilTabell()));
	    Set<T> differanseSet = new HashSet<>(set);
	    differanseSet.removeAll(annenSet);
	    JavaSetToMengde<T> differanse = new JavaSetToMengde<>();
	    for (T element : differanseSet) {
	        differanse.leggTil(element);
	    }
	    return differanse;
	}

	@Override
	public void leggTil(T element) {
		set.add(element);
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for (T element : annenMengde.tilTabell()) {
	        set.add(element);
	    }
	}

	@Override
	public T fjern(T element) {
		if (set.remove(element)) {
            return element;
        }
        return null;
    }

	@Override
	public T[] tilTabell() {
        return (T[]) set.toArray();
	}

	@Override
	public int antallElementer() {
		return set.size();
	}

}
