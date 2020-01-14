package com.yinzuomei.demowebservice.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.yinzuomei.demowebservice.dto.UserDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author rongchao
 * @Date 18-12-4
 */
public class XstreamUtil {

    /**
     * 将xml转换为bean
     *
     * @param <T> 泛型
     * @param xml 要转换为bean的xml
     * @param cls bean对应的Class
     * @return xml转换为bean
     */
    public static <T> T xmlToObject(String xml, Class<T> cls) {
        XStream xStream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(new Class[]{cls});
        //xstream使用注解转换
        xStream.processAnnotations(cls);
        return (T) xStream.fromXML(xStream.fromXML(xml).toString());
    }

    /**
     * 将bean转换为xml
     *
     * @param obj
     * @return
     */
    public static String objectToXml(Object obj) {
        //解决下划线问题
        XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
        xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null, TimeZone.getTimeZone("GMT+8")));
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(new Class[]{obj.getClass()});
        //xstream使用注解转换
        xStream.processAnnotations(obj.getClass());
        return xStream.toXML(obj);
    }

    public static void main(String[] args) {
        UserDTO userDTO=new UserDTO(1,"test",new Date(),new BigDecimal("7.66"));
        System.out.println(objectToXml(userDTO));

    }
}
