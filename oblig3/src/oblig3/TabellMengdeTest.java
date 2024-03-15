package oblig3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TabellMengdeTest {

	@Test
    public void erTom_returnerer_true_når_mengden_er_tom() {
        MengdeADT<Integer> mengde = new TabellMengde<>();
        assertTrue(mengde.erTom());
    }

    @Test
    public void leggTil_legger_til_element_i_mengden() {
        MengdeADT<Integer> mengde = new TabellMengde<>();
        mengde.leggTil(1);
        assertTrue(mengde.inneholder(1));
        assertFalse(mengde.erTom());
    }

    @Test
    public void fjern_fjerner_element_fra_mengden() {
        MengdeADT<Integer> mengde = new TabellMengde<>();
        mengde.leggTil(1);
        mengde.fjern(1);
        assertFalse(mengde.inneholder(1));
        assertTrue(mengde.erTom());
    }

    @Test
    public void leggTilAlleFra_legger_til_elementer_fra_annen_mengde() {
        MengdeADT<Integer> mengde = new TabellMengde<>();
        mengde.leggTil(1);
        MengdeADT<Integer> annenMengde = new TabellMengde<>();
        annenMengde.leggTil(2);
        annenMengde.leggTil(3);
        mengde.leggTilAlleFra(annenMengde);
        assertTrue(mengde.inneholder(2));
        assertTrue(mengde.inneholder(3));
    }

    @Test
    public void union_returnerer_unionen_av_to_mengder() {
        MengdeADT<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        MengdeADT<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        MengdeADT<Integer> union = mengde1.union(mengde2);
        assertTrue(union.inneholder(1));
        assertTrue(union.inneholder(2));
        assertTrue(union.inneholder(3));
    }

    @Test
    public void snitt_returnerer_snittet_av_to_mengder() {
        MengdeADT<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        MengdeADT<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        MengdeADT<Integer> snitt = mengde1.snitt(mengde2);
        assertTrue(snitt.inneholder(2));
        assertFalse(snitt.inneholder(1));
        assertFalse(snitt.inneholder(3));
    }

    @Test
    public void minus_returnerer_differansen_mellom_to_mengder() {
        MengdeADT<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        MengdeADT<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        MengdeADT<Integer> differanse = mengde1.minus(mengde2);
        assertTrue(differanse.inneholder(1));
        assertFalse(differanse.inneholder(2));
        assertFalse(differanse.inneholder(3));
    }

    @Test
    public void erDelmengdeAv_returnerer_true_hvis_mengden_er_delmengde_av_annen_mengde() {
        MengdeADT<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        MengdeADT<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(1);
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        assertTrue(mengde1.erDelmengdeAv(mengde2));
    }

    @Test
    public void erLik_returnerer_true_hvis_to_mengder_er_like() {
        MengdeADT<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        MengdeADT<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(1);
        mengde2.leggTil(2);
        assertTrue(mengde1.erLik(mengde2));
    }

    @Test
    public void erDisjunkt_returnerer_true_hvis_to_mengder_er_disjunkte() {
        MengdeADT<Integer> mengde1 = new TabellMengde<>();
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        MengdeADT<Integer> mengde2 = new TabellMengde<>();
        mengde2.leggTil(3);
        mengde2.leggTil(4);
        assertTrue(mengde1.erDisjunkt(mengde2));
    }

}