package com.jmxtestbuilder.toy.webcontroller;


import com.jmxtestbuilder.toy.dto.JmeterTestPlan;
import com.jmxtestbuilder.toy.dto.TestPlan;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class ListTypeMarsharling {
    public static void main(String[] args) throws JAXBException {
        marshal();
    }

    public static void marshal() {
        JmeterTestPlan<TestPlan> jmeterTestPlan = new JmeterTestPlan<>();
        TestPlan testPlan = new TestPlan();

        testPlan.setGuiclass("TestPlanGui");
        testPlan.setTestclass("TestPlan");
        testPlan.setTestname("역직구성능테스트MC");
        testPlan.setEnabled("true");
        testPlan.setBoolProp("");
        testPlan.setElementProp("false");
        testPlan.setStringProp("");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(JmeterTestPlan.class, TestPlan.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(testPlan, sw);
            System.out.println(sw);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
