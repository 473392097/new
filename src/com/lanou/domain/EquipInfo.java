package com.lanou.domain;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lanouhn on 17/8/8.
 */
public class EquipInfo {
    private int id;
    private String name;
    private Integer price;


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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipInfo equipInfo = (EquipInfo) o;

        if (id != equipInfo.id) return false;
        if (name != null ? !name.equals(equipInfo.name) : equipInfo.name != null) return false;
        if (price != null ? !price.equals(equipInfo.price) : equipInfo.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    public Set<HeroInfo> getHeroInfos() {
        return heroInfos;
    }

    public void setHeroInfos(Set<HeroInfo> heroInfos) {
        this.heroInfos = heroInfos;
    }
}
