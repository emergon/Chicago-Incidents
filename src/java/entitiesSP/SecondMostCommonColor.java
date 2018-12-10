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
public class SecondMostCommonColor {
    private int color;
    private Long num;

    public SecondMostCommonColor() {
    }

    public SecondMostCommonColor(int color, Long num) {
        this.color = color;
        this.num = num;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.color;
        hash = 71 * hash + (int) (this.num ^ (this.num >>> 32));
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
        final SecondMostCommonColor other = (SecondMostCommonColor) obj;
        if (this.color != other.color) {
            return false;
        }
        if (this.num != other.num) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SecondMostCommonColor{" + "color=" + color + ", num=" + num + '}';
    }
    
    
}
