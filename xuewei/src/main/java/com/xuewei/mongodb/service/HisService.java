package com.xuewei.mongodb.service;

import com.xuewei.mongodb.dao.HisMongoDao;
import com.xuewei.mongodb.vo.His;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HisService {

    @Autowired
    public HisMongoDao hisMongoDao;

    //查询
    public List<His> queryHis(String num){
        List<His> result = new ArrayList<His>();
        result = hisMongoDao.queryHis(num);
        return result;
    }
    //插入
    public void insertHis(His his){
        hisMongoDao.insertHis(his);
    }
    //更新
    public void updateHis(String num,String pv){
        hisMongoDao.updateHis(num,pv);
    }
    /**
     * 删除满足查询条件的数据
     */
    public void delHis(String num){
        hisMongoDao.delHis(num);
    }
    /**
     * 根据id删除单条数据
     */
    public void delHisById(String id){
        hisMongoDao.delHisById(id);
    }
}
