package com.jmxtestbuilder.toy.restcontroller;

import com.jmxtestbuilder.toy.dto.*;
import com.jmxtestbuilder.toy.utils.GenericWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Marsharling {
    public static void main(String[] args) throws JAXBException, IOException {

//        StringBuilder sb = new StringBuilder();
//        StringWriter sw = new StringWriter();
//        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<jmeterTestPlan version=\"1.2\" properties=\"5.0\" jmeter=\"5.4.3\">");
//        sb.append(sw.toString());

        JAXBContext jc = null;
        Marshaller marshaller = null;

        File file = new File("/root/IdeaProjects/jmxtestbuild/jmxTestBuilder/src/main/resources/test.jmx");

        JmeterTestPlan jmeterTestPlan = new JmeterTestPlan();
        HashTree hashTree = new HashTree();
        HashTree hashTree2 = new HashTree();

        TestPlan testPlan = new TestPlan();
        HeaderManager headerManager = new HeaderManager();
        CollectionProp collectionProp = new CollectionProp();
        ElementProp elementProp = new ElementProp();

        List<TestPlan> tlist = new ArrayList<>();
        List<HashTree> hlist = new ArrayList<>();
        List<HeaderManager> headlist = new ArrayList<>();
        List<CollectionProp> clist = new ArrayList<>();
        List<ElementProp> elist = new ArrayList<>();


        //TestPlan Atrribute
        testPlan.setGuiclass("TestPlanGui");
        testPlan.setTestclass("TestPlan");
        testPlan.setTestname("역직구성능테스트MC");
        testPlan.setEnabled("true");
        //TestPlan
        testPlan.setBoolProp("");
        testPlan.setElementProp("false");
        testPlan.setStringProp("");
        tlist.add(testPlan);

        elementProp.setStringProp("abcdefg");
        elist.add(elementProp);

        collectionProp.setElementProp(elist);
        clist.add(collectionProp);

        headerManager.setCollectionProps(clist);
        headlist.add(headerManager);

        hashTree.setTestPlan(tlist);
        hashTree2.setHeaderManager(headlist);
        hlist.add(hashTree);
        hlist.add(hashTree2);

        jmeterTestPlan.setHashTrees(hlist);

        jc = JAXBContext.newInstance(GenericWrapper.class, JmeterTestPlan.class);

        marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

        marshal(marshaller, hlist, "jmeterTestPlan version=\"1.2\" properties=\"5.0\" jmeter=\"5.4.3\"", file);

//        System.out.println(sb.toString());
    }

    private static void marshal(Marshaller marshaller, List<?> list, String name, File file) throws JAXBException {
        QName qName = new QName(name);
        GenericWrapper genericWrapper = new GenericWrapper(list);
        JAXBElement<GenericWrapper> jaxbElement = new JAXBElement<GenericWrapper>(qName, GenericWrapper.class, genericWrapper);
        marshaller.marshal(jaxbElement, file);
    }

}
