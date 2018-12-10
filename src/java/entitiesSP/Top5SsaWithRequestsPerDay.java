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
public class Top5SsaWithRequestsPerDay {
    private int ssa;
    private long num;
    private Date hmnia;

    public Top5SsaWithRequestsPerDay() {
    }

    
    public Top5SsaWithRequestsPerDay(int ssa, long num, Date hmnia) {
        this.ssa = ssa;
        this.num = num;
        this.hmnia = hmnia;
    }

    public int getSsa() {
        return ssa;
    }

    public void setSsa(int ssa) {
        this.ssa = ssa;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public Date getHmnia() {
        return hmnia;
    }

    public void setHmnia(Date hmnia) {
        this.hmnia = hmnia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.ssa;
        hash = 47 * hash + (int) (this.num ^ (this.num >>> 32));
        hash = 47 * hash + Objects.hashCode(this.hmnia);
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
        final Top5SsaWithRequestsPerDay other = (Top5SsaWithRequestsPerDay) obj;
        if (this.ssa != other.ssa) {
            return false;
        }
        if (this.num != other.num) {
            return false;
        }
        if (!Objects.equals(this.hmnia, other.hmnia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Top5SsaWithRequestsPerDay{" + "ssa=" + ssa + ", num=" + num + ", hmnia=" + hmnia + '}';
    }
    
    
}
