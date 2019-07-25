package com.xuewei.mongodb.vo;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "his")
public class His {
    @Id
    private ObjectId _id;
    @Field("num")
    private String num;//编号
    @Field("pn")
    private String pn;//名称
    @Field("pd")
    private Date pd;//存储日期
    @Field("pv")

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
    private Integer pv;//值

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public Date getPd() {
        return pd;
    }

    public void setPd(Date pd) {
        this.pd = pd;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }
}
