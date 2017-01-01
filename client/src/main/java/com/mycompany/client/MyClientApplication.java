/*******************************************************************************
 * Copyright 2016 Xerxes Tsang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.mycompany.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.zerkseez.gwtpojo.client.serialization.collection.ListSerializer;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.mycompany.model.Cat;
import com.mycompany.model.Dog;
import com.mycompany.model.Gender;
import com.mycompany.model.Pet;
import com.mycompany.model.PetOwner;
import com.mycompany.model.PetSerializer;
import com.mycompany.model.SamplePojo;
import com.mycompany.model.SamplePojoSerializer;

public class MyClientApplication implements EntryPoint {
    private final SamplePojoSerializer samplePojoSerializer = new SamplePojoSerializer();

    @Override
    public void onModuleLoad() {
        testSamplePojo();
        testListOfSamplePojo();
        testPolymorphism();
    }

    public void testSamplePojo() {
        final SamplePojo samplePojo = new SamplePojo(12345, "Hello world!");
        final JSONValue samplePojoJson = samplePojoSerializer.serialize(samplePojo);
        showResult("SamplePojo serialization result: " + samplePojoJson.toString());
        showResult("SamplePojo deserialization result: " + samplePojoSerializer.deserialize(samplePojoJson).toString());
    }

    public void testListOfSamplePojo() {
        final List<SamplePojo> samplePojoList = Arrays.asList(
                new SamplePojo(123, "Testing support for java.util.List<E>"), new SamplePojo(456, "GWTPojo rocks"));

        final ListSerializer<SamplePojo> serializer = new ListSerializer<SamplePojo>(samplePojoSerializer);
        final JSONValue samplePojoListJson = serializer.serialize(samplePojoList);

        showResult("List<SamplePojo> serialization result: " + samplePojoListJson);
        showResult("List<SamplePojo> deserialization result: " + serializer.deserialize(samplePojoListJson));
    }

    public void testPolymorphism() {
        final List<Pet> pets = new ArrayList<Pet>();

        final Cat cat = new Cat();
        cat.setMicrochipId(123L);
        cat.setName("Charlie");
        cat.setGender(Gender.MALE);
        cat.setBreed(Cat.Breed.AMERICAN_SHORTHAIR);
        cat.setOwner(new PetOwner("John", "123-456-7890"));
        cat.setPreviousOwners(
                Arrays.asList(new PetOwner("Paul", "222-333-4444"), new PetOwner("Mary", "321-321-3210")));
        pets.add(cat);

        final Dog dog = new Dog();
        dog.setMicrochipId(456L);
        dog.setName("Lucy");
        dog.setGender(Gender.FEMALE);
        dog.setBreed(Dog.Breed.LABRADOR_RETRIEVER);
        pets.add(dog);

        final ListSerializer<Pet> serializer = new ListSerializer<Pet>(new PetSerializer());
        final JSONValue petListJson = serializer.serialize(pets);

        showResult("List<Pet> serialization result: " + petListJson);
        showResult("List<Pet> deserialization result: " + serializer.deserialize(petListJson));
    }

    public void showResult(final String result) {
        RootPanel.get().add(new Label(result));
    }
}
