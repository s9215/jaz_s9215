
package mpr.jaz.pjwstk.ejb;

import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mpr.jaz.pjwstk.domain.Animal;

@Stateful
@Named
public class AnimalManager {
    
    @PersistenceContext(unitName = "9215_TPU")
    private EntityManager em;
    
    public List<Animal> getAllAnimals() {
        return em.createQuery("select a from Animal a").getResultList();
    }
    
    public void delete(Animal animal) {
        animal = em.merge(animal);
        em.remove(animal);
    }
 
    public void persist(Animal animal) {
        em.merge(animal);
    }
}
