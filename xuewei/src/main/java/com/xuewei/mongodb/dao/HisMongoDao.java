package com.xuewei.mongodb.dao;

import com.xuewei.mongodb.vo.His;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class HisMongoDao extends BaseMongoDao {

    /**
     * 查询mongodb
     * @param num
     * @return
     */
    @RequestMapping(value = "/queryHis",method = RequestMethod.GET)
    public List<His> queryHis(String num) {
        List<His> result = new ArrayList<His>();
        Query query = new Query();
        //Query query1 = new Query().limit(1);限制查询条数
        query.with(new Sort(Sort.Direction.DESC, "pd"));
        query.addCriteria(Criteria.where("num").is(num));
        //query.addCriteria(Criteria.where("pd").gte(startDate).lte(endDate));
        //query.addCriteria(Criteria.where("pn").in("数组"));
        result = this.getMongoTemplate().find(query,His.class);
        return result;
    }

    /**
     * 插入数据
     * @param his
     */
    @RequestMapping(value = "/insertHis",method = RequestMethod.GET)
    public void insertHis(His his) {
        his.setNum("num1");
        his.setPd(new Date());
        his.setPn("电压");
        his.setPv(211);
        //单条插入insert
        this.getMongoTemplate().insert(his);
        //多条插入insertAll
        //List<His> list = new ArrayList<His>();
        //mongoTemplate.insertAll(list);
    }

    /**
     * 更新数据，也可以根据唯一ID去单条更新
     * @param num,pv
     */
    @RequestMapping(value = "/updateHis",method = RequestMethod.GET)
    public void updateHis(String num,String pv) {
        Query query = new Query();
        query.addCriteria(Criteria.where("num").is(num));
        Update update = Update.update("pv", pv);
        // mongoTemplate.updateFirst(query, update, His.class);//更新满足条件的第一个数据
        this.getMongoTemplate().updateMulti(query, update, His.class);//更新所有满足条件的
    }

    /**
     * 删除满足查询条件的数据
     */
    @RequestMapping(value = "/delHis",method = RequestMethod.GET)
    public void delHis(String num) {
        Query query = new Query();
        query.addCriteria(Criteria.where("num").is(num));
        this.getMongoTemplate().remove(query, His.class);
    }
    /**
     * 根据id删除单条数据
     */
    @RequestMapping(value = "/delHisById",method = RequestMethod.GET)
    public void delHisById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        this.getMongoTemplate().remove(query, His.class);
    }
}
