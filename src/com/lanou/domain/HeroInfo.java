package com.lanou.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lanouhn on 17/8/8.
 */
public class HeroInfo {
    private int id;
    private String name;
    private String sex;


    private ForceInfo forceInfo;
    private Set<EquipInfo> equipInfoSet = new HashSet<>();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeroInfo heroInfo = (HeroInfo) o;

        if (id != heroInfo.id) return false;
        if (name != null ? !name.equals(heroInfo.name) : heroInfo.name != null) return false;
        if (sex != null ? !sex.equals(heroInfo.sex) : heroInfo.sex != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "HeroInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +

                '}';
    }

    public ForceInfo getForceInfo() {
        return forceInfo;
    }

    public void setForceInfo(ForceInfo forceInfo) {
        this.forceInfo = forceInfo;
    }


    public Set<EquipInfo> getEquipInfoSet() {
        return equipInfoSet;
    }

    public void setEquipInfoSet(Set<EquipInfo> equipInfoSet) {
        this.equipInfoSet = equipInfoSet;
    }
}
