package com.jmxtestbuilder.toy.webcontroller;


import com.jmxtestbuilder.toy.dto.HashTree;
import com.jmxtestbuilder.toy.dto.HttpRequest;

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

        HashTree hashTree = new HashTree();
        HttpRequest httpRequest = new HttpRequest();
        HttpRequest httpRequest2 = httpRequest;

        List<HttpRequest> list = new ArrayList<>();

        httpRequest.setGuiclass("HttpTestSampleGui");
        httpRequest.setTestclass("HTTPSamplerProxy");
        httpRequest.setTestname("HTTP Request");
        httpRequest.setEnabled("true");
        httpRequest.setTest("test");


        list.add(httpRequest);
        list.add(httpRequest2);
        hashTree.setList(list);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(HashTree.class, HttpRequest.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(hashTree, sw);
            System.out.println(sw);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
