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
public class MostCommonRequestPerZipByDate {
    String zip;
    int type;
    long num;

    public MostCommonRequestPerZipByDate() {
    }

    public MostCommonRequestPerZipByDate(String zip, int type, long num) {
        this.zip = zip;
        this.type = type;
        this.num = num;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.zip);
        hash = 19 * hash + this.type;
        hash = 19 * hash + (int) (this.num ^ (this.num >>> 32));
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
        final MostCommonRequestPerZipByDate other = (MostCommonRequestPerZipByDate) obj;
        if (this.type != other.type) {
            return false;
        }
        if (this.num != other.num) {
            return false;
        }
        if (!Objects.equals(this.zip, other.zip)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MostCummonRequestPerZipByDate{" + "zip=" + zip + ", type=" + type + ", num=" + num + '}';
    }
    
    
}
