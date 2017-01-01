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

import com.github.zerkseez.gwtpojo.annotation.GWTPojo;

@GWTPojo
public class Cat extends Pet {
    public enum Breed {
        ABYSSINIAN, AMERICAN_SHORTHAIR, BIRMAN, MAINE_COON
    }

    private Breed breed = null;

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "[Cat|microchipId=" + getMicrochipId() + ",name=" + getName() + ",gender=" + getGender() + ",owner="
                + getOwner() + ",previousOwners=" + getPreviousOwners() + ",breed=" + getBreed() + "]";
    }
}
