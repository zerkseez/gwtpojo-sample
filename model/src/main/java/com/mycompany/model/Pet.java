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
package com.mycompany.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.zerkseez.gwtpojo.annotation.GWTPojo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @Type(value = Dog.class, name = "DOG"),
    @Type(value = Cat.class, name = "CAT")
})
@GWTPojo
public abstract class Pet {
    private Long microchipId = null;
    private String name = null;
    private Gender gender = null;
    private PetOwner owner = null;
    private List<PetOwner> previousOwners = null;

    public Long getMicrochipId() {
        return microchipId;
    }

    public void setMicrochipId(Long microchipId) {
        this.microchipId = microchipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PetOwner getOwner() {
        return owner;
    }

    public void setOwner(PetOwner owner) {
        this.owner = owner;
    }

    public List<PetOwner> getPreviousOwners() {
        return previousOwners;
    }

    public void setPreviousOwners(List<PetOwner> previousOwners) {
        this.previousOwners = previousOwners;
    }
}
