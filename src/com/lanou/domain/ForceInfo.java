package com.lanou.domain;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lanouhn on 17/8/8.
 */
public class ForceInfo {
    private int id;
    private String name;
    private String area;
//一对多
    private Set<HeroInfo> heroInfos = new HashSet<>();
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForceInfo forceInfo = (ForceInfo) o;

        if (id != forceInfo.id) return false;
        if (name != null ? !name.equals(forceInfo.name) : forceInfo.name != null) return false;
        if (area != null ? !area.equals(forceInfo.area) : forceInfo.area != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "ForceInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    public Set<HeroInfo> getHeroInfos() {
        return heroInfos;
    }

    public void setHeroInfos(Set<HeroInfo> heroInfos) {
        this.heroInfos = heroInfos;
    }
}
