import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class CompagnieAutorouteTest {
    @Test
    public void testObtenirTarifExacte() {
        CompagnieAutoroute compagnieAutoroute = new CompagnieAutoroute();
        Route r2 = new Route();
        Porte pA = new PorteEntree(10), pB = new PorteSortie(20), pC = new PorteSortie(30), pD = new PorteSortie(40);


        r2.addPorte(pA);
        r2.addPorte(pB);
        r2.addPorte(pC);
        r2.addPorte(pD);

        compagnieAutoroute.ajouterRoute(r2);

        Tarif tABCD = new Tarif(pA, pD, new BigDecimal("1.23E+3"));


        compagnieAutoroute.ajouterTarif(tABCD);

        assertEquals("Erreur calcul exacte du tarif", new BigDecimal("1.23E+3"), compagnieAutoroute.obtenirTarif(pA, pD));
    }

    @Test
    public void testObtenirTarifCalcule() {
        CompagnieAutoroute compagnieAutoroute = new CompagnieAutoroute();
        Route r1 = new Route();
        Porte p1 = new PorteEntree(1), p2 = new PorteSortie(2), p3 = new PorteEntree(3), p4 = new PorteSortie(4);

        r1.addPorte(p4);
        r1.addPorte(p3);
        r1.addPorte(p1);
        r1.addPorte(p2);

        compagnieAutoroute.ajouterRoute(r1);
        Collections.sort(r1.portes, new OrdrePorteComparator());

        Tarif
                t12 = new Tarif(p1, p2, new BigDecimal("1E+1")),
                t23 = new Tarif(p2, p3, new BigDecimal("2E+1")),
                t34 = new Tarif(p3, p4, new BigDecimal("3E+1"));

        compagnieAutoroute.ajouterTarif(t12);
        compagnieAutoroute.ajouterTarif(t23);
        compagnieAutoroute.ajouterTarif(t34);

        assertEquals("Erreur calcul du tarif", new BigDecimal("60"), compagnieAutoroute.obtenirTarif(p1, p4));
    }
}