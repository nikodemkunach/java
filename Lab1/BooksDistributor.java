package org.example;

import org.example.model.Person;
import org.example.model.Samples;

import java.util.Random;

public class BooksDistributor {

    public void distributeBooksThroughPeople(){

        for (Person person: Samples.getSampleListOfPeople())
        {
            if(Samples.getAvailableBooks().size() > 0){
                int index = getRandomIndex();
                person.getBooks().add(Samples.getAvailableBooks().get(index));
                Samples.getAvailableBooks().get(index).setOwner(person);
                Samples.getAvailableBooks().remove(index);
            }
        }

    }
    private int getRandomIndex(){
        return new Random().nextInt(Samples.getAvailableBooks().size());
    }


}







