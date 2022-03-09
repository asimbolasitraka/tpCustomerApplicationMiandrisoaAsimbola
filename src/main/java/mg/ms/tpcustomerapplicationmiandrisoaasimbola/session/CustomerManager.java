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
import mg.ms.tpcustomerapplicationmiandrisoaasimbola.entities.Customer;


/**
 * Gère la persistance des Customers.
 */
@Stateless
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    public void persist(Customer customer) {
        em.persist(customer);
    }

    /**
     * 
     * Récuperer tous les customers
     * @return 
     */
    public List<Customer> getAllCustomers() {
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }

    /**
     * Modifier un customer
     * @param customer
     * @return 
     */
    public Customer update(Customer customer) {
       return em.merge(customer);
    }

}
