package com.keega.plat.wechat.service.sys;

import java.sql.SQLException;

/**
 * 薪资接口
 * Created by zun.wei on 2016/12/21.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
public interface ISalaryService {

    /**
     * 获取发放薪资日期
     * @param a0100 人员标志
     * @return 薪资日期json字符串
     */
    String getSendSalaryDateJsonByA0100(String a0100) throws SQLException;

    /**
     * 获取薪资信息
     * @param a0100 人员标志
     * @param salaryDate 发放薪资日期
     * @return 薪资
     */
    String getSalaryInfoByDateA0100(String a0100, String salaryDate) throws SQLException;

}
