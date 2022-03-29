/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package mg.ms.tpcustomerapplicationmiandrisoaasimbola.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mg.ms.tpcustomerapplicationmiandrisoaasimbola.entities.DiscountCode;

/**
 * Gère la persistance des Discount codes.
 */
@Stateless
public class DiscountCodeManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<DiscountCode> getAllDiscountCodes() {
        Query query = em.createNamedQuery("DiscountCode.findAll");
        return query.getResultList();
    }

    public DiscountCode findById(String discountCode) {
        return em.find(DiscountCode.class, discountCode);
    }
}
