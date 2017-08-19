import com.lanou.domain.EquipInfo;
import com.lanou.domain.ForceInfo;
import com.lanou.domain.HeroInfo;
import com.lanou.uilts.Utils;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

/**
 * Created by lanouhn on 17/8/8.
 */
public class Main {


    public static void main(final String[] args) throws Exception {
       // oneToManyAddData();
       // oneToManyAddData2();
        //deleteCascadeData();
        manyToManyAddData();
    }




    /**
     * 添加数据  一对多
     * oneToMany
     */
    public static void oneToManyAddData() {
        Session session =Utils.getSession();
//        开启事务
        Transaction transaction =session.beginTransaction();
//        新建一个势力
        ForceInfo forceInfo = new ForceInfo();
        forceInfo.setName("艾欧尼亚");
        forceInfo.setArea("死境之地");

        HeroInfo heroInfo1 = new HeroInfo();
        heroInfo1.setName("索拉卡");
        heroInfo1.setSex("女");

        HeroInfo heroInfo2 = new HeroInfo();
        heroInfo2.setName("艾瑞莉娅");
        heroInfo2.setSex("女");

//        表达 一对多，一个势力下面有多个英雄
        forceInfo.getHeroInfos().add(heroInfo1);
        forceInfo.getHeroInfos().add(heroInfo2);

//        表达多对一，多个英雄对应一个势力
        heroInfo1.setForceInfo(forceInfo);
        heroInfo2.setForceInfo(forceInfo);

//        保存数据
        session.save(forceInfo);
        session.save(heroInfo1);
        session.save(heroInfo2);

        transaction.commit();
       // session.close();

    }


    public static void oneToManyAddData2() {
        Session session =Utils.getSession();
//        开启事务
        Transaction transaction =session.beginTransaction();


//        数据的操作
//        新建一个势力
        ForceInfo forceInfo = new ForceInfo();
        forceInfo.setName("暗影岛");
        forceInfo.setArea("西北部");

        HeroInfo heroInfo1 = new HeroInfo();
        heroInfo1.setName("卡尔萨斯");
        heroInfo1.setSex("男");

        HeroInfo heroInfo2 = new HeroInfo();
        heroInfo2.setName("战争之影");
        heroInfo2.setSex("男");

//        表达 一对多，一个势力下面有多个英雄
        forceInfo.getHeroInfos().add(heroInfo1);
        forceInfo.getHeroInfos().add(heroInfo2);

//        表达多对一，多个英雄对应一个势力
         heroInfo1.setForceInfo(forceInfo);
         heroInfo2.setForceInfo(forceInfo);

//        保存数据
        //cascade="save-update"
        //设置级联操作之后,只需要保存势力(一的一方)
        session.save(forceInfo);
//        session.save(heroInfo1);
//        session.save(heroInfo2);

        transaction.commit();
        // session.close();

    }




    /*
    级联删除
     */


    public static void deleteCascadeData(){

        Session session= Utils.getSession();
        Transaction transaction = session.beginTransaction();
        ForceInfo forceInfo = session.get(ForceInfo.class,2);
        //  删除对应的对象
        session.delete(forceInfo);
        transaction.commit();
        //session.close();


    }


    /*
    多对多的添加数据
     */


    public static void manyToManyAddData(){
        Session session= Utils.getSession();
        Transaction transaction = session.beginTransaction();
        //创建对应的英雄
        HeroInfo heroInfo1 = new HeroInfo();
        HeroInfo heroInfo2 = new HeroInfo();
        heroInfo1.setName("EZ");
        heroInfo1.setSex("男");
        heroInfo2.setName("贾克斯");
        heroInfo2.setSex("男");

        //创建对应的装备
        EquipInfo equipInfo1 = new EquipInfo();
        EquipInfo equipInfo2 = new EquipInfo();
        equipInfo1.setName("三相之力");
        equipInfo1.setPrice(3888);
        equipInfo2.setName("冰壶");
        equipInfo2.setPrice(2888);
        //设置对应的关系
        heroInfo1.getEquipInfoSet().add(equipInfo1);
        heroInfo1.getEquipInfoSet().add(equipInfo2);
        heroInfo2.getEquipInfoSet().add(equipInfo1);
        heroInfo2.getEquipInfoSet().add(equipInfo2);

        equipInfo1.getHeroInfos().add(heroInfo1);
        equipInfo1.getHeroInfos().add(heroInfo2);
        equipInfo2.getHeroInfos().add(heroInfo1);
        equipInfo2.getHeroInfos().add(heroInfo2);

        session.save(heroInfo1);
        session.save(heroInfo2);

        transaction.commit();

    }

}