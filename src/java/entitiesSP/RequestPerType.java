/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesSP;



/**
 *
 * @author anastasios
 */


public class RequestPerType {
    
    int type;
    long num;

    public RequestPerType() {
    }

    public RequestPerType(int type, long num) {
        this.type = type;
        this.num = num;
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
        hash = 47 * hash + this.type;
        hash = 47 * hash + (int) (this.num ^ (this.num >>> 32));
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
        final RequestPerType other = (RequestPerType) obj;
        if (this.type != other.type) {
            return false;
        }
        if (this.num != other.num) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RequestPerType{" + "type=" + type + ", num=" + num + '}';
    }

}
