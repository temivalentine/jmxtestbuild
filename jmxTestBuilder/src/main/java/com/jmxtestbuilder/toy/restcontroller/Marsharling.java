package com.jmxtestbuilder.toy.restcontroller;

import com.jmxtestbuilder.toy.dto.HashTree;
import com.jmxtestbuilder.toy.dto.TestPlan;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Marsharling {
    public static void main(String[] args) throws JAXBException, IOException {

        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

        JAXBContext jc = null;
        Marshaller marshaller = null;

        List<TestPlan> tlist = new ArrayList<>();
//        JmeterTestPlan jmeterTestPlan = new JmeterTestPlan();
        HashTree<TestPlan> hashTree = new HashTree<>();
        TestPlan testPlan = new TestPlan();

        jc = JAXBContext.newInstance(HashTree.class);

        testPlan.setStringProp("");
        testPlan.setBoolProp("false");
        testPlan.setElementProp("");
//        testPlan.setName("TestPlan.comments");

        tlist.add(testPlan);
//        hashTree.setHashTreeList(tlist);
        hashTree.setHashTree(tlist);
//        hllist.add(hashTree);
//        jmeterTestPlan.setHashTree();

        marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);


//        File file = new File("/root/IdeaProjects/jmxtestbuild/jmxTestBuilder/src/main/resources/test.jmx");

//        FileWriter fw = new FileWriter(file);
//        fw.write(test);
//        fw.close();

//        StringWriter sw = new StringWriter();

//        marshaller.marshal(hashTree, new File("/root/IdeaProjects/jmxtestbuild/jmxTestBuilder/src/main/resources/test.jmx"));
        marshaller.marshal(hashTree, new File("/root/IdeaProjects/jmxtestbuild/jmxTestBuilder/src/main/resources/test.jmx"));
        // marshaller.marshal(jmeterTestPlan, sw);


//        sb.append(sw.toString());
//        System.out.println(sb.toString());

    }
}
