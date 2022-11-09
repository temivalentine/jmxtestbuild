package com.jmxtestbuilder.toy.common;

import com.jmxtestbuilder.toy.dto.BoolProp;
import com.jmxtestbuilder.toy.dto.CollectionProp;
import com.jmxtestbuilder.toy.dto.ElementProp;
import com.jmxtestbuilder.toy.dto.StringProp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class CustomMethod {
    //Custom Method() 1
    public static void collectionElementProp(String keys, String values) {

        BoolProp boolProp = new BoolProp();
        boolProp.setName("HTTPArgument.always_encode");
        boolProp.setValue("true");

        BoolProp boolProp2 = new BoolProp();
        boolProp2.setName("HTTPArgument.use_equals");
        boolProp2.setValue("true");

        StringProp stringProp = new StringProp();
        stringProp.setName("Argument.value");
        stringProp.setValue(values);

        StringProp stringProp3 = new StringProp();
        stringProp3.setName("Argument.name");
        stringProp3.setValue(keys);

        List<BoolProp> boolPropList = new ArrayList<>();
        List<StringProp> stringPropList = new ArrayList<>();
        boolPropList.add(boolProp);
        boolPropList.add(boolProp2);
        stringPropList.add(stringProp);
        stringPropList.add(stringProp3);

        ElementProp elementProp = new ElementProp();
        elementProp.setName("id");
        elementProp.setElementType("HTTPArgument");
        elementProp.setBoolPropList(boolPropList);
        elementProp.setStringPropList(stringPropList);

        CollectionProp collectionProp = new CollectionProp();
        List<ElementProp> elementPropList = new ArrayList<>();
        collectionProp.setName("Arguments.arguments");
        elementPropList.add(elementProp);
        collectionProp.setElementPropList(elementPropList);

        ElementProp elementProp2 = new ElementProp();
        elementProp2.setName("HTTPsampler.Arguments");
        elementProp2.setElementType("Arguments");
        elementProp2.setGuiclass("HTTPArgumentsPanel");
        elementProp2.setTestclass("Arguments");
        elementProp2.setEnabled("true");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ElementProp.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            marshaller.marshal(elementProp, sw);
            System.out.println(sw);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    // custom ElementProp Method 1
//    public static ElementProp epProperty() {
//        String name;

//    }
}
