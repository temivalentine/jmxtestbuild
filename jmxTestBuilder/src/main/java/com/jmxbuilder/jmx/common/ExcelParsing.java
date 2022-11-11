package com.jmxbuilder.jmx.common;

import com.jmxbuilder.jmx.type.BoolPropType;
import com.jmxbuilder.jmx.type.StringPropType;
import com.jmxbuilder.jmx.dto.tag.*;
import com.jmxbuilder.jmx.utils.URLParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ExcelParsing {
    public static void main(String[] args) throws IOException {
        parsing();
    }

    //parsing Method() 1
    public static void parsing() throws IOException {

        HTTPSamplerProxy httpSamplerProxy = new HTTPSamplerProxy();

        List<HashMap<String, String>> testmaplist = URLParser.readExcel();

        for (HashMap<String, String> hmap : testmaplist) {
            for (Map.Entry<String, String> entry : hmap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                hmap.put(key, value);
            }
            httpSamplerProxy(hmap);
        }


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(HTTPSamplerProxy.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            marshaller.marshal(httpSamplerProxy, sw);
            System.out.println(sw);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /*
            Parsing Data Method
     */
    // HTTPSampleProxy
    public static HTTPSamplerProxy httpSamplerProxy(HashMap<String, String> hpmap) {
        HTTPSamplerProxy httpSamplerProxy = new HTTPSamplerProxy();
        List<ElementProp> elementPropList = new ArrayList<>();
        elementPropList.add(elementPropHSP(hpmap));

        httpSamplerProxy.setElementPropList(elementPropList);

        return httpSamplerProxy;
    }

    // <HTTPSampleProxy>    ElementProp  상위
    public static ElementProp elementPropHSP(HashMap<Enum, String> hpmap) {
        ElementProp elementProp = new ElementProp();
        List<CollectionProp> collectionPropList = new ArrayList<>();
        collectionPropList.add(cp(hpmap));
        elementProp.setCollectionPropList(collectionPropList);

        return elementProp;
    }

    // CollectionProp
    public static CollectionProp cp(HashMap<Enum, String> hpmap) {
        CollectionProp collectionProp = new CollectionProp();
        List<ElementProp> elementPropList = new ArrayList<>();
        elementPropList.add(ep(hpmap));
        collectionProp.setElementPropList(elementPropList);

        return collectionProp;
    }

    // ElementProp  하위
    public static ElementProp ep(HashMap<Enum, String> hpmap) {
        ElementProp elementProp = new ElementProp();
        List<BoolProp> boolPropList = new ArrayList<>();
        List<StringProp> stringPropList = new ArrayList<>();

        boolPropList.add(bp(BoolPropType.ENCODE, hpmap.get(BoolPropType.ENCODE)));
        boolPropList.add(bp(BoolPropType.EQUALS, hpmap.get(BoolPropType.EQUALS)));

        stringPropList.add(sp(StringPropType.VALUE, hpmap.get(StringPropType.VALUE)));
        stringPropList.add(sp(StringPropType.METADATA, hpmap.get(StringPropType.METADATA)));
        stringPropList.add(sp(StringPropType.NAME, hpmap.get(StringPropType.NAME)));

        elementProp.setBoolPropList(boolPropList);
        elementProp.setStringPropList(stringPropList);

        return elementProp;
    }

    //  <collection> <elementProp>    BoolProp
    public static BoolProp bp(BoolPropType bp, String value) {
        BoolProp boolProp = new BoolProp();
        boolProp.setName(bp.getName());
        boolProp.setValue(value);

        return boolProp;
    }

    //  <collection> <elementProp>    StringProp
    public static StringProp sp(StringPropType sp, String value) {
        StringProp stringProp = new StringProp();
        stringProp.setName(sp.getName());
        stringProp.setValue(value);

        return stringProp;
    }

}
