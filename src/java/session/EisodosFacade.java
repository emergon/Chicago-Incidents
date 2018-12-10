/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.P1Xrhsths;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author deplh_5o_1
 */
@Stateless
public class EisodosFacade extends AbstractFacade<P1Xrhsths> {

    @PersistenceContext(unitName = "ChicagoIncidentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EisodosFacade() {
        super(P1Xrhsths.class);
    }

    public P1Xrhsths fereLogariasmo(String xrhsUsername, String pwd) {
        P1Xrhsths xr = null;
        Query qr = em.createNativeQuery("select * from p1_xrhsths where xrhs_username = :xrhsUsername \n"
                + "and xrhs_password = crypt(:xrhsPwd, xrhs_password)", P1Xrhsths.class);
        qr.setParameter("xrhsUsername", xrhsUsername);
        qr.setParameter("xrhsPwd", pwd);
        try {
            xr = (P1Xrhsths) qr.getSingleResult();
        } catch (NoResultException nre) {

        }
        return xr;
    }

    public void allaxeSynthimatiko(P1Xrhsths xrhsths, String neoSynthimatiko) {
        Query qr = em.createNativeQuery("update p1_xrhsths\n"
                + "set xrhs_password = crypt(:xrhsPwd, gen_salt('bf', 8))\n"
                + "where xrhs_kwd = :xrhsKwd");
        qr.setParameter("xrhsKwd", xrhsths.getXrhsKwd());
        qr.setParameter("xrhsPwd", neoSynthimatiko);
        int num = qr.executeUpdate();
        System.out.println("Updated " + num + " xrhsths = " + xrhsths.getXrhsUsername());
    }

    public void arxikoSynthimatiko(P1Xrhsths xrhsths) {
        System.out.println("Xrhsths = " + xrhsths.getXrhsKwd() + ", " + xrhsths.getXrhsUsername());
        String pwd = "1234";
        Query qr = em.createNativeQuery("update p1_xrhsths\n"
                + "set xrhs_password = crypt(:xrhsPwd, gen_salt('bf', 8))\n"
                + "where xrhs_kwd = :xrhsKwd");
        qr.setParameter("xrhsKwd", xrhsths.getXrhsKwd());
        qr.setParameter("xrhsPwd", pwd);
        int num = qr.executeUpdate();
        System.out.println("Updated " + num + " xrhsths = " + xrhsths.getXrhsUsername());
    }
}
