package com.jmxtestbuilder.toy.webcontroller;


import com.jmxtestbuilder.toy.dto.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class ListTypeMarsharling {
    public static void main(String[] args) throws JAXBException {
        marshal();
    }

    public static void marshal() {

        List list = new ArrayList();

        JmeterTestPlan jmeterTestPlan = new JmeterTestPlan();
        HashTree hashTree = new HashTree();
        TestPlan testPlan = new TestPlan();
        HeaderManager headerManager = new HeaderManager();
        CollectionProp collectionProp = new CollectionProp();
        ElementProp elementProp = new ElementProp();

        jmeterTestPlan.setVersion("1.2");
        jmeterTestPlan.setProperties("5.0");
        jmeterTestPlan.setJmeter("5.4.3");

        testPlan.setGuiclass("TestPlanGui");
        testPlan.setTestclass("TestPlan");
        testPlan.setTestname("역직구성능테스트MC");
        testPlan.setEnabled("true");
        testPlan.setBoolProp("");
        testPlan.setElementProp("false");
        testPlan.setStringProp("");

//        elementProp.setStringProp("abcd");

//        collectionProp.setElementProp();

//        headerManager.setCollectionProps();

        headerManager.setHeadStyle("headstyle");
        list.add(headerManager);
        hashTree.setList(list);


        list.add(testPlan);
        jmeterTestPlan.setList(list);
//        jmeterTestPlan.setList(testPlan);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(JmeterTestPlan.class, TestPlan.class, HashTree.class, HeaderManager.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(jmeterTestPlan, sw);
            System.out.println(sw);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
