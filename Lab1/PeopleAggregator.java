package org.example;

import org.example.model.Gender;
import org.example.model.Person;
import org.example.model.Samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleAggregator {

    public Map<Gender, List<Person>> aggregatePeopleByGender(){
        List<Person> newListOfMales = new ArrayList<>();
        List<Person> newListOfFemales = new ArrayList<>();
        Map<Gender, List<Person>> aggregatedByGender = new HashMap<>();
        aggregatedByGender.put(Gender.FEMALE, newListOfFemales);
        aggregatedByGender.put(Gender.MALE, newListOfMales);
        for (Person person : Samples.getSampleListOfPeople()) {
            if (person.getGender() == Gender.MALE)
//                newListOfPeople.add(person);
                aggregatedByGender.get(Gender.MALE).add(person);
            if(person.getGender() == Gender.FEMALE)
                aggregatedByGender.get(Gender.FEMALE).add(person);
//                newListOfPeople.add(person);
        }
        return aggregatedByGender;
    }
}
