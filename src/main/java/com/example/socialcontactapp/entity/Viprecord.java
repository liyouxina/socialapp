package com.example.socialcontactapp.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Viprecord)实体类
 *
 * @author makejava
 * @since 2022-06-18 20:59:26
 */
public class Viprecord implements Serializable {
    private static final long serialVersionUID = -94190211397412074L;
    
    private Integer id;
    
    private Integer userid;
    
    private Date buydate;
    
    private Date enddate;
    
    private Integer typeid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getBuydate() {
        return buydate;
    }

    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

}