/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesSP;

import java.util.Objects;

/**
 *
 * @author anastasios
 */
public class PlatesMoreThanOnce {
    private String plate;
    private Long num;

    public PlatesMoreThanOnce() {
    }

    public PlatesMoreThanOnce(String plate, Long num) {
        this.plate = plate;
        this.num = num;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.plate);
        hash = 19 * hash + Objects.hashCode(this.num);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlatesMoreThanOnce other = (PlatesMoreThanOnce) obj;
        if (!Objects.equals(this.plate, other.plate)) {
            return false;
        }
        if (!Objects.equals(this.num, other.num)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlatesMoreThanOnce{" + "plate=" + plate + ", num=" + num + '}';
    }
    
    
}
