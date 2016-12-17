package com.keega.plat.wechat.dao.sys;

import com.keega.common.dal.Dal;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Map;

/**
 * 系统用户Data Access Object
 * Created by zun.wei on 2016/12/15.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
@Repository("sysUserDao")
public class SysUserDao implements ISysUserDao {
    //迅雷的useranme字段为H01SZ；password字段为H01T5

    @Override//验证用户是否存在系统
    public boolean hashUserInDatabase(String openId) throws SQLException {//null,default_id
        String dbOpenId = Dal.single().query("select openid from UsrA01 where openid=?",openId);
        return !("default_id".equals(dbOpenId) || null == dbOpenId);
    }

    @Override//map的key区分大小写
    public Map<String, Object> getSysUserByOpenId(String openId) throws SQLException {
        return Dal.map().query("select * from UsrA01 where openid = ?", openId);
    }

    @Override//获取系统用户的账号密码
    public Map<String, Object> getAccPassByOpenId(String openId) throws SQLException {
        return Dal.map().query("select H01SZ as username,H01T5 as password from UsrA01 where openid = ?",
                openId);
    }

    @Override//绑定openid到系统用户中
    public void bindHrSysUser(String openId,String account) throws SQLException {
        Dal.upd().excute("update UsrA01 set openid=? where H01SZ=?", openId, account);
    }

    @Override//根据用户名和密码获取openId
    public Map<String, Object> getOpenIdByAccPss(String account, String password) throws SQLException  {
        if (password != null)
            return Dal.map().query("select openid from UsrA01 where H01SZ=? and H01T5=?"
                ,new Object[]{account,password});
        else
            return Dal.map().query("select openid from UsrA01 where H01SZ=? and H01T5 is null"
                    ,account);
    }

    @Override//还原默认openid值
    public void updateOpenId2Default(String fromUser) throws SQLException {
        Dal.upd().excute("update UsrA01 set openid = ? where openid = ?","default_id",fromUser);
    }

}
