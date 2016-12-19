package com.keega.plat.wechat.util.config;

import org.dom4j.Document;
import org.dom4j.Element;

/**
 * Created by zun.wei on 2016/12/19.
 * To change this template use File|Default Setting
 * |Editor|File and Code Templates|Includes|File Header
 */
public class WxConfigInit {

    private static Document document;

    private WxConfigInit() {
    }

    static {
        if (document == null) {
            document = XMLUtil.getWechatDocument();
        }
    }

    private Element getRootElement() {
        return document.getRootElement();
    }

    public void test(){
        Element root = getRootElement();
        root.elementIterator();
    }

}
