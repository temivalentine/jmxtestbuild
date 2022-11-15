package com.jmxbuilder.jmx.common;

import com.jmxbuilder.jmx.dto.data.Hsp;
import com.jmxbuilder.jmx.dto.tag.*;
import com.jmxbuilder.jmx.type.BoolPropType;
import com.jmxbuilder.jmx.type.HspBoolPropType;
import com.jmxbuilder.jmx.type.HspStringPropType;
import com.jmxbuilder.jmx.type.StringPropType;
import com.jmxbuilder.jmx.utils.ExcelParsing;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
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
public class JmxMarsharling {
    public static void main(String[] args) throws IOException {
        parsing();
    }

    //parsing Method() 1
    public static void parsing() throws IOException {
        int count = 0;

        Hsp hsp = new Hsp();
        // Excel Data List 가져오기
        hsp.setParamsList(ExcelParsing.readExcel());

        HashMap<Enum, String> hmap = new HashMap<>();

        for (int i = 1; i < hsp.getParamsList().size(); i++) {
            // StrProp Data
            hmap.put(StringPropType.NAME, hsp.getParamsList().get(i).getName());
            hmap.put(StringPropType.VALUE, hsp.getParamsList().get(i).getValue());
            hmap.put(StringPropType.METADATA, hsp.getParamsList().get(i).getMemtaData());
            // BoolProp Data
            hmap.put(BoolPropType.ENCODE, hsp.getParamsList().get(i).getEncode());
            hmap.put(BoolPropType.EQUALS, hsp.getParamsList().get(i).getEquals());
            // HspStrProp Data
            hmap.put(HspStringPropType.DOMAIN, hsp.getParamsList().get(i).getHspList().get(i).getDomain());
            hmap.put(HspStringPropType.PATH, hsp.getParamsList().get(i).getHspList().get(i).getPath());
            hmap.put(HspStringPropType.PORT, "");
            hmap.put(HspStringPropType.PROTOCOL, "");
            hmap.put(HspStringPropType.CONTENTENCODING, "");
            hmap.put(HspStringPropType.EMBEDDED_URL_RE, "");
            hmap.put(HspStringPropType.CONNECTION_TIMEOUT, "");
            hmap.put(HspStringPropType.RESPONSE_TIMEOUT, "");
            hmap.put(HspStringPropType.COMMENTS, "");
            hmap.put(HspStringPropType.METHOD, "GET");
            // HspBoolProp Data
            hmap.put(HspBoolPropType.FOLLOW_REDIRECTS, "true");
            hmap.put(HspBoolPropType.AUTO_REDIRECTS, "false");
            hmap.put(HspBoolPropType.USE_KEEPALIVE, "true");
            hmap.put(HspBoolPropType.MULTIPART_POST, "false");
            hmap.put(HspBoolPropType.BROWSER_COMPATIBLE, "false");


            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(HTTPHashTree.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.setProperty(marshaller.JAXB_FRAGMENT, Boolean.TRUE);

                StringWriter sw = new StringWriter();
                marshaller.marshal(JmxMarsharling.httpHashTree(hmap), sw);
                System.out.println(sw);

            } catch (JAXBException e) {
                e.printStackTrace();
            }
//            count++;
//            System.out.println("==========================================================");
//            System.out.println("count ================ : " + count);
        }
    }


    // HTTPHashTree   | <hashTree/>  만들기
    public static HTTPHashTree httpHashTree(HashMap<Enum, String> hmap) {
        HTTPHashTree httpHashTree = new HTTPHashTree();
        List<HTTPSamplerProxy> httpSamplerProxyList = new ArrayList<>();

        //<hashTree/>  만들기  용
        List<HashTree> hashTreeList = new ArrayList<>();
        HashTree hashTree = new HashTree();
        hashTreeList.add(hashTree);
        httpHashTree.setHashTreeList(hashTreeList);

        // HTTPSampleProxy 전체 HashTree
        httpSamplerProxyList.add(httpSamplerProxy(hmap));
        httpHashTree.setHttpSamplerProxyList(httpSamplerProxyList);
        return httpHashTree;
    }


    // HTTPSampleProxy
    public static HTTPSamplerProxy httpSamplerProxy(HashMap<Enum, String> hpmap) {
        HTTPSamplerProxy httpSamplerProxy = new HTTPSamplerProxy();
        List<ElementProp> elementPropList = new ArrayList<>();
        List<StringProp> stringPropList = new ArrayList<>();
        List<BoolProp> boolPropList = new ArrayList<>();

        elementPropList.add(elementPropHSP(hpmap));

        httpSamplerProxy.setGuiclass("HttpTestSampleGui");
        httpSamplerProxy.setTestclass("HTTPSamplerProxy");
        httpSamplerProxy.setTestname("HTTP Request");
        httpSamplerProxy.setEnabled("true");
        httpSamplerProxy.setElementPropList(elementPropList);

        //HttpSampleProxy stringProp Data insert
        stringPropList.add(stringproplist(HspStringPropType.DOMAIN, hpmap.get(HspStringPropType.DOMAIN)));
        stringPropList.add(stringproplist(HspStringPropType.PORT, hpmap.get(HspStringPropType.PORT)));
        stringPropList.add(stringproplist(HspStringPropType.PROTOCOL, hpmap.get(HspStringPropType.PROTOCOL)));
        stringPropList.add(stringproplist(HspStringPropType.CONTENTENCODING, hpmap.get(HspStringPropType.CONTENTENCODING)));
        stringPropList.add(stringproplist(HspStringPropType.PATH, hpmap.get(HspStringPropType.PATH)));
        stringPropList.add(stringproplist(HspStringPropType.METHOD, hpmap.get(HspStringPropType.METHOD)));
        stringPropList.add(stringproplist(HspStringPropType.EMBEDDED_URL_RE, hpmap.get(HspStringPropType.EMBEDDED_URL_RE)));
        stringPropList.add(stringproplist(HspStringPropType.CONNECTION_TIMEOUT, hpmap.get(HspStringPropType.CONNECTION_TIMEOUT)));
        stringPropList.add(stringproplist(HspStringPropType.RESPONSE_TIMEOUT, hpmap.get(HspStringPropType.RESPONSE_TIMEOUT)));
        stringPropList.add(stringproplist(HspStringPropType.COMMENTS, hpmap.get(HspStringPropType.COMMENTS)));

        httpSamplerProxy.setHttpStringProp(stringPropList);

        //HttpSampleProxy boolProp Data insert
        boolPropList.add(boolproplist(HspBoolPropType.FOLLOW_REDIRECTS, hpmap.get(HspBoolPropType.FOLLOW_REDIRECTS)));
        boolPropList.add(boolproplist(HspBoolPropType.AUTO_REDIRECTS, hpmap.get(HspBoolPropType.AUTO_REDIRECTS)));
        boolPropList.add(boolproplist(HspBoolPropType.USE_KEEPALIVE, hpmap.get(HspBoolPropType.USE_KEEPALIVE)));
        boolPropList.add(boolproplist(HspBoolPropType.MULTIPART_POST, hpmap.get(HspBoolPropType.MULTIPART_POST)));
        boolPropList.add(boolproplist(HspBoolPropType.BROWSER_COMPATIBLE, hpmap.get(HspBoolPropType.BROWSER_COMPATIBLE)));

        httpSamplerProxy.setHttpBoolProp(boolPropList);

        return httpSamplerProxy;
    }

    // <HTTPSampleProxy> <stringProp> method
    public static StringProp stringproplist(HspStringPropType hsp, String value) {
        StringProp stringProp = new StringProp();
        stringProp.setName(hsp.getName());
        stringProp.setValue(value);


        return stringProp;
    }

    // <HTTPSampleProxy> <boolProp> method
    public static BoolProp boolproplist(HspBoolPropType hbp, String value) {
        BoolProp boolProp = new BoolProp();
        boolProp.setName(hbp.getName());
        boolProp.setValue(value);

        return boolProp;
    }

    // <HTTPSampleProxy>    ElementProp  상위
    public static ElementProp elementPropHSP(HashMap<Enum, String> hpmap) {
        ElementProp elementProp = new ElementProp();
        List<CollectionProp> collectionPropList = new ArrayList<>();
        collectionPropList.add(cp(hpmap));

        elementProp.setName("HTTPsampler.Arguments");
        elementProp.setElementType("Arguments");
        elementProp.setGuiclass("HTTPArgumentsPanel");
        elementProp.setTestclass("Arguments");
        elementProp.setEnabled("true");
        elementProp.setCollectionPropList(collectionPropList);

        return elementProp;
    }

    // CollectionProp
    public static CollectionProp cp(HashMap<Enum, String> hpmap) {
        CollectionProp collectionProp = new CollectionProp();
        List<ElementProp> elementPropList = new ArrayList<>();
        elementPropList.add(ep(hpmap));

        collectionProp.setName("Arguments.arguments");
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

        elementProp.setName("id");
        elementProp.setElementType("HTTPArgument");

        if (hpmap.get(StringPropType.VALUE) == null) {
            return null;
        } else {
            elementProp.setBoolPropList(boolPropList);
            elementProp.setStringPropList(stringPropList);
            return elementProp;
        }

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
