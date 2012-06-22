
package mpr.jaz.pjwstk.web;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import mpr.jaz.pjwstk.domain.Animal;
import mpr.jaz.pjwstk.ejb.AnimalManager;

@SessionScoped
@Named
public class AnimalBean implements Serializable {
    
    private ListDataModel<Animal> animals = new ListDataModel<Animal>();
    private Animal animal;
    
    @Inject
    private AnimalManager am;

    public ListDataModel<Animal> getAnimals() {
        animals.setWrappedData(am.getAllAnimals());
        return animals;
    }

    public Animal getAnimal() {
        if(animal == null) {
            animal = new Animal();
        }
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public String addAnimal() {
        return "addAnimal";
    }
    
    public String showAnimal() {
        setSelectedAnimal();
        return "showAnimal";
    }
    
    public String editAnimal() {
        setSelectedAnimal();
        return "editAnimal";
    }
    
    public String deleteAnimal() {
        am.delete(animals.getRowData());
        return "listAnimals";
    }
    
    public String persistAnimal() {
        am.persist(animal);
        return "listAnimals";
    }
    
    private void setSelectedAnimal() {
        animal = animals.getRowData();
    }
}
