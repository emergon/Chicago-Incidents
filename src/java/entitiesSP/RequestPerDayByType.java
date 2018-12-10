/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesSP;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author anastasios
 */
public class RequestPerDayByType {
    Date creationDate;
    long num;

    public RequestPerDayByType(Date creationDate, long num) {
        this.creationDate = creationDate;
        this.num = num;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.creationDate);
        hash = 29 * hash + (int) (this.num ^ (this.num >>> 32));
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
        final RequestPerDayByType other = (RequestPerDayByType) obj;
        if (this.num != other.num) {
            return false;
        }
        if (!Objects.equals(this.creationDate, other.creationDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RequestPerDayByType{" + "creationDate=" + creationDate + ", num=" + num + '}';
    }
    
}
