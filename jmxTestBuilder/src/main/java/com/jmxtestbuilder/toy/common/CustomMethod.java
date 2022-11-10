package com.jmxtestbuilder.toy.common;

import com.jmxtestbuilder.toy.dto.*;
import com.jmxtestbuilder.toy.utils.BoolPropType;
import com.jmxtestbuilder.toy.utils.ElementPropType;
import com.jmxtestbuilder.toy.utils.StringPropType;
import org.apache.http.protocol.HTTP;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * packageName    : com.jmxtestbuilder.toy.common
 * fileName       : Test
 * author         : im-happy-coder
 * date           : 22. 11. 10.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 11. 10.        im-happy-coder       최초 생성
 */
public class CustomMethod {

    //CollectionProp Method() 1
    public static void collectionElementProp(String keys, String values) {

        // BoolProp method
        bpProperty(BoolPropType.ENCODE, "true");
        bpProperty(BoolPropType.EQUALS, "true");
        // StringProp method
        stProperty(StringPropType.VALUE, values);
        stProperty(StringPropType.NAME, keys);


//        BoolProp boolProp = new BoolProp();
//        boolProp.setName("HTTPArgument.always_encode");
//        boolProp.setValue("true");
//
//        BoolProp boolProp2 = new BoolProp();
//        boolProp2.setName("HTTPArgument.use_equals");
//        boolProp2.setValue("true");

//        StringProp stringProp = new StringProp();
//        stringProp.setName("Argument.value");
//        stringProp.setValue(values);

//        StringProp stringProp3 = new StringProp();
//        stringProp3.setName("Argument.name");
//        stringProp3.setValue(keys);

//        List<BoolProp> boolPropList = new ArrayList<>();
//        List<StringProp> stringPropList = new ArrayList<>();
//        boolPropList.add(boolProp);
//        boolPropList.add(boolProp2);
//        stringPropList.add(stringProp);
//        stringPropList.add(stringProp3);

//        ElementProp elementProp = new ElementProp();
//        elementProp.setName("id");
//        elementProp.setElementType("HTTPArgument");
//        elementProp.setBoolPropList(boolPropList);
//        elementProp.setStringPropList(stringPropList);
//        List<ElementProp> elementPropList = new ArrayList<>();
//        elementPropList.add(elementProp);

        CollectionProp collectionProp = new CollectionProp();

        collectionProp.setName("Arguments.arguments");
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

    // custom BoolProp Method
    public static BoolProp bpProperty(BoolPropType tp, String value) {
        BoolProp boolProp = new BoolProp();
        boolProp.setName(tp.getName());
        boolProp.setValue(value);


        List<BoolProp> boolPropList = new ArrayList<>();
        boolPropList.add(boolProp);

        elPropertyBo(ElementPropType.NAME, ElementPropType.ELEMENTTYPE, List < BoolProp > boolPropList);

        return boolPropList;
    }

    // custom StringProp Method
    public static List<StringProp> stProperty(StringPropType tp, String value) {
        StringProp stringProp = new StringProp();
        stringProp.setName(tp.getName());
        stringProp.setValue(value);

        List<StringProp> stringPropList = new ArrayList<>();
        stringPropList.add(stringProp);

        elPropertySt(ElementPropType.NAME, ElementPropType.ELEMENTTYPE, List < StringProp > stringPropList);


        return stringPropList;
    }

    //custom ElementProp Method
    public static List<ElementProp> elPropertyBo(ElementPropType ep, ElementPropType ep2, List<BoolProp> boList) {
        ElementProp elementProp = new ElementProp();
        elementProp.setName(ep.getName());
        elementProp.setElementType(ep2.getName());
        elementProp.setBoolPropList(boList);


        List<ElementProp> elementPropList = new ArrayList<>();
        elementPropList.add(elementProp);

        return elementPropList;
    }

    //custom ElementProp Method 2
    public static List<ElementProp> elPropertySt(ElementPropType ep, ElementPropType ep2, List<StringProp> stList) {
        ElementProp elementProp = new ElementProp();
        elementProp.setName(ep.getName());
        elementProp.setElementType(ep2.getName());
        elementProp.setStringPropList(stList);

        List<ElementProp> elementPropList = new ArrayList<>();
        elementPropList.add(elementProp);

        return elementPropList;
    }

    //    public static ElementProp epProperty(String) {
//        String name;
//        St
//    }
    public static HTTPSamplerProxy httpSamplerProxy(HashMap<Enum, String> hpmap) {
        HTTPSamplerProxy httpSamplerProxy = new HTTPSamplerProxy();
        List<ElementProp> elementPropList = new ArrayList<>();
        elementPropList.add(elementPropHSP(hpmap));

        httpSamplerProxy.setElementPropList(elementPropList);
    }

    public static ElementProp elementPropHSP(HashMap<Enum, String> hpmap) {
        ElementProp elementProp = new ElementProp();
        List<CollectionProp> collectionPropList = new ArrayList<>();
        collectionPropList.add(collectionProp(hpmap));
        elementProp.setCollectionPropList(collectionPropList);

        return elementProp;
    }

    public static CollectionProp collectionProp(HashMap<Enum, String> hpmap) {
        CollectionProp collectionProp = new CollectionProp();
        List<ElementProp> elementPropList = new ArrayList<>();
        elementPropList.add(elementProp(hpmap));
        collectionProp.setElementPropList(elementPropList);

        return collectionProp;
    }

    public static ElementProp elementProp(HashMap<Enum, String> hpmap) {
        ElementProp elementProp = new ElementProp();
        List<BoolProp> boolPropList = new ArrayList<>();
        List<StringProp> stringPropList = new ArrayList<>();

        boolPropList.add(boolProp(BoolPropType.ENCODE, hpmap.get(BoolPropType.ENCODE)));
        boolPropList.add(boolProp(BoolPropType.EQUALS, hpmap.get(BoolPropType.EQUALS)));

        stringPropList.add(stringProp(StringPropType.VALUE, hpmap.get(StringPropType.VALUE)));
        stringPropList.add(stringProp(StringPropType.METADATA, hpmap.get(StringPropType.METADATA)));
        stringPropList.add(stringProp(StringPropType.NAME, hpmap.get(StringPropType.NAME)));

        elementProp.setBoolPropList(boolPropList);
        elementProp.setStringPropList(stringPropList);

        return elementProp;
    }

    public static BoolProp boolProp(BoolPropType bp, String value) {
        BoolProp boolProp = new BoolProp();
        boolProp.setName(bp.getName());
        boolProp.setValue(value);

        return boolProp;
    }

    public static StringProp stringProp(StringPropType sp, String value) {
        StringProp stringProp = new StringProp();
        stringProp.setName(ep.getName());
        stringProp.setValue(value);

        return stringProp;
    }

}
