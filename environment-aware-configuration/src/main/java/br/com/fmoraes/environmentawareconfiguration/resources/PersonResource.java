package br.com.fmoraes.environmentawareconfiguration.resources;

import br.com.fmoraes.environmentawareconfiguration.model.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author fmoraes
 */
@Path("person")
@Stateless
public class PersonResource {

    @PersistenceContext
    private EntityManager em;
    
    @POST
    public void create() {
        em.persist(new Person("Felipe"));
    }
    
}