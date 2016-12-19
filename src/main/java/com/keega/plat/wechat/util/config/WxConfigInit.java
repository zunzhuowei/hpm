package com.keega.plat.wechat.util.config;

import org.dom4j.Document;
import org.dom4j.Element;

import java.util.*;

/**
 * Created by zun.wei on 2016/12/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
public class WxConfigInit {

    private static Document document;
    //private static Map<String,Map<String,Object>> wxConfigData;

    private WxConfigInit() {
    }

    static {
        if (document == null) {
            document = XMLUtil.getWechatDocument();
        }
    }


    public void test(){
        Map<String, Map<String, Object>> wxConfigData = new HashMap<String, Map<String, Object>>();
        Element root = document.getRootElement();

        Element user_login = root.element("user_login");
        Element user_config = root.element("user_config");
        Element user_menus = root.element("user_menus");
        Element waitThing = root.element("waitThing");
        Element myInfo = root.element("myInfo");
        Element mySalary = root.element("mySalary");
        Element workInfo = root.element("workInfo");
        Element myCheck = root.element("myCheck");
        Map<String, Object> user_login_map = new HashMap<String, Object>();
        Map<String, Object> user_config_map = new HashMap<String, Object>();
        Map<String, Object> user_menus_map = new HashMap<String, Object>();
        Map<String, Object> waitThing_map = new HashMap<String, Object>();
        Map<String, Object> myInfo_map = new HashMap<String, Object>();
        Map<String, Object> mySalary_map = new HashMap<String, Object>();
        Map<String, Object> workInfo_map = new HashMap<String, Object>();
        Map<String, Object> myCheck_map = new HashMap<String, Object>();

        //<!-- 用户登录字段 -->
        user_login_map.put("username", user_login.elementTextTrim("username"));
        user_login_map.put("password", user_login.elementTextTrim("password"));

        //session要存放的信息字段
        List<Element> fields = user_config.elements();
        List<Object> names = new ArrayList<Object>();
        for (int i = 0; i < fields.size(); i++) {
            names.add(fields.get(i).attributeValue("name"));
        }
        user_config_map.put("fields", names);

        //菜单要显示的内容
        List<Element> menusElements = user_menus.elements();
        List<Object> menus = new ArrayList<Object>();
        for (int i = 0; i < menus.size(); i++) {
            MenuConfig menuConfig = new MenuConfig();
            menuConfig.setName(menusElements.get(i).attributeValue("name"));
            menuConfig.setName(menusElements.get(i).attributeValue("url"));
            menuConfig.setName(menusElements.get(i).attributeValue("desc"));
            menuConfig.setName(menusElements.get(i).getTextTrim());
            menus.add(menuConfig);
        }
        user_menus_map.put("munus", menus);



        wxConfigData.put("user_login_map", user_login_map);
        wxConfigData.put("user_config_map", user_config_map);
    }

}
