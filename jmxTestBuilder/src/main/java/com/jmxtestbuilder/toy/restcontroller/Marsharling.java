package com.jmxtestbuilder.toy.restcontroller;

import com.jmxtestbuilder.toy.dto.HashTree;
import com.jmxtestbuilder.toy.dto.JmeterTestPlan;
import com.jmxtestbuilder.toy.dto.TestPlan;
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
//        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
//
        JAXBContext jc = null;
        Marshaller marshaller = null;

        JmeterTestPlan jmeterTestPlan = new JmeterTestPlan();
        HashTree hashTree = new HashTree();
        TestPlan testPlan = new TestPlan();


//        List<JmeterTestPlan> jlist = new ArrayList<>();
//        List<TestPlan> tlist = new ArrayList<>();
//        List<HashTree> hlist = new ArrayList<>();
//
//        testPlan.setStringProp("");
//        testPlan.setBoolProp("false");
//        testPlan.setElementProp("");
//        tlist.add(testPlan);
//        hashTree.setTestPlan(tlist);
//        jmeterTestPlan.setHashTrees(hlist);

//        JmeterTestPlan jmeterTestPlan = new JmeterTestPlan<>();
//        HashTree object = new HashTree();

//        object.setHashTree(new TestPlan());
//        TestPlan testPlan = new TestPlan();

        jc = JAXBContext.newInstance(GenericWrapper.class, HashTree.class);

//        testPlan.setStringProp("");
//        testPlan.setBoolProp("false");
//        testPlan.setElementProp("");
//        testPlan.setName("TestPlan.comments");

//        tlist.add(testPlan);
//        hashTree.setHashTreeList(tlist);
//        hashTree.setHashTree(tlist);
//        hllist.add(hashTree);
//        jmeterTestPlan.set

        marshaller = jc.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);


        File file = new File("/root/IdeaProjects/jmxtestbuild/jmxTestBuilder/src/main/resources/test.jmx");

//        FileWriter fw = new FileWriter(file);
//        fw.write(test);
//        fw.close();

//        StringWriter sw = new StringWriter();
        List<HashTree> datas = new ArrayList<>();

        hashTree.setTestID("1");
        datas.add(hashTree);

        marshal(marshaller, datas, "hashTree", file);
//        marshaller.mamarshal(jmeterTestPlan, new File("/root/IdeaProjects/jmxtestbuild/jmxTestBuilder/src/main/resources/test.jmx"));
        // marshaller.marshal(jmeterTestPlan, sw);


//        sb.append(sw.toString());
//        System.out.println(sb.toString());

//        JaxbGeneric jaxbGeneric = new JaxbGeneric();
//        jaxbGeneric.marshal(hashTree.getTestID(), JmeterTestPlan.class, file);


    }

    private static void marshal(Marshaller marshaller, List<?> list, String name, File file) throws JAXBException {
        QName qName = new QName(name);
        GenericWrapper genericWrapper = new GenericWrapper(list);
        JAXBElement<GenericWrapper> jaxbElement = new JAXBElement<GenericWrapper>(qName, GenericWrapper.class, genericWrapper);
        marshaller.marshal(jaxbElement, file);
    }
}
