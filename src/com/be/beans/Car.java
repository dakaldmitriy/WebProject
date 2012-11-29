package com.be.beans;

import java.util.Objects;


public class Car {
    private int carId;
    private String model;
    private String producer;
    private String type;
    private String description;
    private boolean deleted;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (this.carId != other.carId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.carId;
        hash = 53 * hash + Objects.hashCode(this.model);
        hash = 53 * hash + Objects.hashCode(this.producer);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + (this.deleted ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + carId + ", model=" + model + ", producer=" + producer + ", type=" + type + ", description=" + description + ", deleted=" + deleted + '}';
    }
    
    
    
    
    
}
