package com.example.task.Entities;

import com.example.task.Repositories.AnimalRepository;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DetailedInfoEntity {
    private @Id
    @GeneratedValue Long id;
    @Column(nullable = false)
    private String ownerName;
    @Column(nullable = false)
    private String ownerSurname;
    @Column(nullable = false)
    private String cityAddress;
    @Column(nullable = false)
    private String streetAddress;
    @Column(nullable = false)
    private int buildingNumberAddress;

    @ManyToOne
    private AnimalEntity animalEntity;

    public DetailedInfoEntity() {}

    public DetailedInfoEntity(String ownerName, String ownerSurname, String cityAddress, String streetAddress, int buildingNumberAddress, AnimalEntity animalEntity){
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.cityAddress = cityAddress;
        this.streetAddress = streetAddress;
        this.buildingNumberAddress = buildingNumberAddress;
        this.animalEntity = animalEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getBuildingNumberAddress() {
        return buildingNumberAddress;
    }

    public void setBuildingNumberAddress(int buildingNumberAddress) {
        this.buildingNumberAddress = buildingNumberAddress;
    }

    public AnimalEntity getAnimalEntity() {
        return animalEntity;
    }

    public void setAnimalEntity(AnimalEntity animalEntity) {
        this.animalEntity = animalEntity;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (!(this instanceof DetailedInfoEntity)){
            return false;
        }
        DetailedInfoEntity detailedInfoEntity = (DetailedInfoEntity) obj;
        return Objects.equals(this.id, detailedInfoEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.ownerName, this.ownerSurname, this.cityAddress, this.streetAddress, this.buildingNumberAddress);
    }

    @Override
    public String toString() {
        return "DetailedInfo{"+"id="+this.id+", ownerName='"+this.ownerName + '\'' + ", ownerSurname='"+this.ownerSurname+'\''+", cityAddress='"+this.cityAddress+'\''+", streetAddress='"+this.streetAddress+'\''+", buildingAddress='"+this.buildingNumberAddress+'\''+'}';
    }
}
