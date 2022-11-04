package com.jmxtestbuilder.toy.webcontroller;


import com.jmxtestbuilder.toy.dto.ThreadGroup;
import com.jmxtestbuilder.toy.dto.*;
import org.springframework.web.bind.annotation.RequestParam;

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

        BoolProp boolProp = new BoolProp();
        boolProp.setName("HTTPArgument.always_encode");
        boolProp.setValue("true");

        BoolProp boolProp2 = new BoolProp();
        boolProp2.setName("HTTPArgument.use_equals");
        boolProp2.setValue("true");

        StringProp stringProp = new StringProp();
        stringProp.setName("Argument.value");
        stringProp.setValue("hd");

        StringProp stringProp2 = new StringProp();
        stringProp2.setName("Argument.metadata");
        stringProp2.setValue("=");

        StringProp stringProp3 = new StringProp();
        stringProp3.setName("Argument.name");
        stringProp3.setValue("id");

        List<BoolProp> boolPropList = new ArrayList<>();
        List<StringProp> stringPropList = new ArrayList<>();
        boolPropList.add(boolProp);
        boolPropList.add(boolProp2);
        stringPropList.add(stringProp);
        stringPropList.add(stringProp2);
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

        List<CollectionProp> collectionPropList = new ArrayList<>();
        collectionPropList.add(collectionProp);
        elementProp2.setCollectionPropList(collectionPropList);

        HTTPSamplerProxy httpSamplerProxy = new HTTPSamplerProxy();
        httpSamplerProxy.setGuiclass("HttpTestSampleGui");
        httpSamplerProxy.setTestclass("HTTPSamplerProxy");
        httpSamplerProxy.setTestname("HTTP Request");
        httpSamplerProxy.setEnabled("true");

        StringProp httpStringProp = new StringProp();
        httpStringProp.setName("HTTPSampler.domain");
        httpStringProp.setValue("192.168.111.99");

        StringProp httpStringProp2 = new StringProp();
        httpStringProp2.setName("HTTPSampler.port");
        httpStringProp2.setValue("8000");

        StringProp httpStringProp3 = new StringProp();
        httpStringProp3.setName("HTTPSampler.protocol");
        httpStringProp3.setValue("https");

        StringProp httpStringProp4 = new StringProp();
        httpStringProp4.setName("HTTPSampler.contentEncoding");
        httpStringProp4.setValue("");

        StringProp httpStringProp5 = new StringProp();
        httpStringProp5.setName("HTTPSampler.path");
        httpStringProp5.setValue("/getCSINfo");

        StringProp httpStringProp6 = new StringProp();
        httpStringProp6.setName("HTTPSampler.method");
        httpStringProp6.setValue("HEAD");

        StringProp httpStringProp7 = new StringProp();
        httpStringProp7.setName("HTTPSampler.embedded_url_re");
        httpStringProp7.setValue("");

        StringProp httpStringProp8 = new StringProp();
        httpStringProp8.setName("HTTPSampler.connect_timeout");
        httpStringProp8.setValue("");

        StringProp httpStringProp9 = new StringProp();
        httpStringProp9.setName("HTTPSampler.response_timeout");
        httpStringProp9.setValue("");

        StringProp httpStringProp10 = new StringProp();
        httpStringProp10.setName("TestPlan.comments");
        httpStringProp10.setValue("subtitle");

        List<StringProp> httpStringPropList2 = new ArrayList<>();
        httpStringPropList2.add(httpStringProp);
        httpStringPropList2.add(httpStringProp2);
        httpStringPropList2.add(httpStringProp3);
        httpStringPropList2.add(httpStringProp4);
        httpStringPropList2.add(httpStringProp5);
        httpStringPropList2.add(httpStringProp6);
        httpStringPropList2.add(httpStringProp7);
        httpStringPropList2.add(httpStringProp8);
        httpStringPropList2.add(httpStringProp9);
        httpStringPropList2.add(httpStringProp10);

        BoolProp httpBoolProp = new BoolProp();
        httpBoolProp.setName("HTTPSampler.follow_redirects");
        httpBoolProp.setValue("false");

        BoolProp httpBoolProp2 = new BoolProp();
        httpBoolProp2.setName("HTTPSampler.auto_redirects");
        httpBoolProp2.setValue("true");

        BoolProp httpBoolProp3 = new BoolProp();
        httpBoolProp3.setName("HTTPSampler.use_keepalive");
        httpBoolProp3.setValue("true");

        BoolProp httpBoolProp4 = new BoolProp();
        httpBoolProp4.setName("HTTPSampler.DO_MULTIPART_POST");
        httpBoolProp4.setValue("true");

        BoolProp httpBoolProp5 = new BoolProp();
        httpBoolProp5.setName("HTTPSampler.BROWSER_COMPATIBLE_MULTIPART");
        httpBoolProp5.setValue("true");

        List<BoolProp> httpBoolPropList = new ArrayList<>();
        httpBoolPropList.add(httpBoolProp);
        httpBoolPropList.add(httpBoolProp2);
        httpBoolPropList.add(httpBoolProp3);
        httpBoolPropList.add(httpBoolProp4);
        httpBoolPropList.add(httpBoolProp5);


        httpSamplerProxy.setHttpBoolProp(httpBoolPropList);
        httpSamplerProxy.setHttpStringProp(httpStringPropList2);

        List<ElementProp> elementPropList2 = new ArrayList<>();
        elementPropList2.add(elementProp2);
        httpSamplerProxy.setElementPropList(elementPropList2);

        //HashTree
        HTTPHashTree httpHashTree = new HTTPHashTree();

        List<HTTPSamplerProxy> httpSamplerProxyList = new ArrayList<>();

        httpSamplerProxyList.add(httpSamplerProxy);

        httpHashTree.setHttpSamplerProxyList(httpSamplerProxyList);

        //TransactionController
        TransactionController transactionController = new TransactionController();

        List<BoolProp> transactionBoolPropList = new ArrayList<>();

        BoolProp transactionBoolProp = new BoolProp();
        transactionBoolProp.setName("TransactionController.includeTimers");
        transactionBoolProp.setValue("false");

        BoolProp transactionBoolProp2 = new BoolProp();
        transactionBoolProp2.setName("TransactionController.parent");
        transactionBoolProp2.setValue("false");

        transactionBoolPropList.add(transactionBoolProp);
        transactionBoolPropList.add(transactionBoolProp2);

        transactionController.setTransactionBoolPropList(transactionBoolPropList);
        transactionController.setGuiclass("TransactionControllerGui");
        transactionController.setTestclass("TransactionController");
        transactionController.setTestname("Transaction Controller");
        transactionController.setEnabled("true");

        // Transaction HashTree (with HTTP Request Hashtree)
        TransactionHashTree transactionHashTree = new TransactionHashTree();
        List<TransactionController> transactionControllerList = new ArrayList<>();
        transactionControllerList.add(transactionController);
        transactionHashTree.setTransactionControllerList(transactionControllerList);
        //HTTP Request HashTree
        List<HTTPHashTree> httpHashtree = new ArrayList<>();
        httpHashtree.add(httpHashTree);
        transactionHashTree.setHttpHashTreeList(httpHashtree);

        // ThreadGroup (with ThreadGroup HashTree
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setGuiclass("ThreadGroupGui");
        threadGroup.setTestclass("ThreadGroup");
        threadGroup.setTestname("Thread Group");
        threadGroup.setEnabled("true");

        // ThreadGroup <stringProp>
        StringProp threadGroupStringProp = new StringProp();
        threadGroupStringProp.setName("ThreadGroup.on_sample_error");
        threadGroupStringProp.setValue("continue");

        StringProp threadGroupStringProp2 = new StringProp();
        threadGroupStringProp2.setName("ThreadGroup.num_threads");
        threadGroupStringProp2.setValue("1");

        StringProp threadGroupStringProp3 = new StringProp();
        threadGroupStringProp3.setName("ThreadGroup.ramp_time");
        threadGroupStringProp3.setValue("1");

        StringProp threadGroupStringProp4 = new StringProp();
        threadGroupStringProp4.setName("ThreadGroup.duration");
        threadGroupStringProp4.setValue("");

        StringProp threadGroupStringProp5 = new StringProp();
        threadGroupStringProp5.setName("ThreadGroup.delay");
        threadGroupStringProp5.setValue("");

        List<StringProp> threadGroupStringPropList = new ArrayList<>();
        threadGroupStringPropList.add(threadGroupStringProp);
        threadGroupStringPropList.add(threadGroupStringProp2);
        threadGroupStringPropList.add(threadGroupStringProp3);
        threadGroupStringPropList.add(threadGroupStringProp4);
        threadGroupStringPropList.add(threadGroupStringProp5);

        threadGroup.setStringPropList(threadGroupStringPropList);

        // ThreadGroup <boolProp>
        BoolProp threadGroupBoolProp = new BoolProp();
        threadGroupBoolProp.setName("ThreadGroup.scheduler");
        threadGroupBoolProp.setValue("false");

        BoolProp threadGroupBoolProp2 = new BoolProp();
        threadGroupBoolProp.setName("ThreadGroup.same_user_on_next_iteration");
        threadGroupBoolProp2.setValue("true");

        List<BoolProp> threadGroupBoolPropList = new ArrayList<>();
        threadGroupBoolPropList.add(threadGroupBoolProp);
        threadGroupBoolPropList.add(threadGroupBoolProp2);

        threadGroup.setBoolPropList(transactionBoolPropList);

        // ThreadGroup <elementProp>
        ElementProp threadElementProp = new ElementProp();
        threadElementProp.setName("ThreadGroup.main_controller");
        threadElementProp.setElementType("LoopController");
        threadElementProp.setGuiclass("LoopControlPanel");
        threadElementProp.setTestclass("LoopController");
        threadElementProp.setTestname("Loop Controller");
        threadElementProp.setEnabled("true");
        // ThreadGroup <elementProp> <boolProp>
        BoolProp threadElementBoolProp = new BoolProp();
        threadElementBoolProp.setName("LoopController.continue_forever");
        threadElementBoolProp.setValue("false");
        // ThreadGroup <elementProp> <stringProp>
        StringProp threadStringProp = new StringProp();
        threadStringProp.setName("LoopController.loops");
        threadStringProp.setValue("1");

        List<BoolProp> threadElementPropBoolPropList = new ArrayList<>();
        threadElementPropBoolPropList.add(threadElementBoolProp);
        List<StringProp> threadElementStringPropList = new ArrayList<>();
        threadElementStringPropList.add(threadStringProp);

        threadElementProp.setBoolPropList(threadElementPropBoolPropList);
        threadElementProp.setStringPropList(threadElementStringPropList);

        List<ElementProp> threadElementPropList = new ArrayList<>();
        threadElementPropList.add(threadElementProp);

        threadGroup.setElementPropList(threadElementPropList);

        // ThreadGroup HashTree
        ThreadGroupHashTree threadGroupHashTree = new ThreadGroupHashTree();
        List<ThreadGroup> threadGroupList = new ArrayList<>();
        threadGroupList.add(threadGroup);
        threadGroupHashTree.setThreadGroupList(threadGroupList);

        List<TransactionHashTree> transactionHashTreeList = new ArrayList<>();
        transactionHashTreeList.add(transactionHashTree);
        threadGroupHashTree.setTransactionHashTreeList(transactionHashTreeList);

        // TestPlan (with HashTree
        TestPlan testPlan = new TestPlan();
        testPlan.setGuiclass("TestPlanGui");
        testPlan.setTestclass("TestPlan");
        testPlan.setTestname("Test Plan");
        testPlan.setEnabled("true");

        // TestPlan <elementProp>
        ElementProp testPlanElementProp = new ElementProp();
        testPlanElementProp.setName("TestPlan.user_defined_variables");
        testPlanElementProp.setElementType("Arguments");
        testPlanElementProp.setGuiclass("ArgumentsPanel");
        testPlanElementProp.setTestclass("Arguments");
        testPlanElementProp.setTestname("User Defined Variables");
        testPlanElementProp.setEnabled("true");

        // TestPlan <elementProp> <collectionProp>
        CollectionProp testPlanCollectionProp = new CollectionProp();
        testPlanCollectionProp.setName("Arguments.arguments");
        List<ElementProp> testPlanElementPropList = new ArrayList<>();
        List<CollectionProp> testPlanCollectionPropList = new ArrayList<>();
        testPlanCollectionPropList.add(testPlanCollectionProp);

        testPlanElementProp.setCollectionPropList(testPlanCollectionPropList);
        testPlanElementPropList.add(testPlanElementProp);

        testPlan.setElementPropList(testPlanElementPropList);

        // TestPlan <stringProp>
        StringProp testPlanStringProp = new StringProp();
        testPlanStringProp.setName("TestPlan.comments");
        testPlanStringProp.setValue("");

        StringProp testPlanStringProp2 = new StringProp();
        testPlanStringProp2.setName("TestPlan.user_define_classpath");
        testPlanStringProp2.setValue("");

        List<StringProp> testplanStringPropList = new ArrayList<>();
        testplanStringPropList.add(testPlanStringProp);
        testplanStringPropList.add(testPlanStringProp2);
        testPlan.setStringPropList(testplanStringPropList);

        // Test Plan <boolProp>
        BoolProp testPlanBoolProp = new BoolProp();
        testPlanBoolProp.setName("TestPlan.functional_mode");
        testPlanBoolProp.setValue("false");

        BoolProp testPlanBoolProp2 = new BoolProp();
        testPlanBoolProp2.setName("TestPlan.tearDown_on_shutdown");
        testPlanBoolProp2.setValue("true");

        BoolProp testPlanBoolProp3 = new BoolProp();
        testPlanBoolProp3.setName("TestPlan.serialize_threadgroups");
        testPlanBoolProp3.setValue("false");

        List<BoolProp> testplanBoolPropList = new ArrayList<>();
        testplanBoolPropList.add(testPlanBoolProp);
        testplanBoolPropList.add(testPlanBoolProp3);
        testplanBoolPropList.add(testPlanBoolProp3);

        testPlan.setBoolPropList(testplanBoolPropList);

        // TestPlanHashTree
        TestPlanHashTree testPlanHashTree = new TestPlanHashTree();
        List<TestPlan> testPlanList = new ArrayList<>();
        testPlanList.add(testPlan);
        testPlanHashTree.setTestPlanList(testPlanList);

        List<ThreadGroupHashTree> threadGroupHashTreeList = new ArrayList<>();
        threadGroupHashTreeList.add(threadGroupHashTree);
        testPlanHashTree.setThreadGroupHashTreeList(threadGroupHashTreeList);

        // JmeterTestPlan
        JmeterTestPlan jmeterTestPlan = new JmeterTestPlan();
        jmeterTestPlan.setVersion("1.2");
        jmeterTestPlan.setProperties("5.0");
        jmeterTestPlan.setJmeter("5.5");

        // JmerTestPlan HashTree

        List<TestPlanHashTree> testPlanHashTreeList = new ArrayList<>();
        testPlanHashTreeList.add(testPlanHashTree);
        jmeterTestPlan.setTestPlanHashTreeList(testPlanHashTreeList);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(JmeterTestPlan.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
//            marshaller.marshal(jmeterTestPlan, new File("/root/jmeter_test.jmx"));
//
            marshaller.marshal(jmeterTestPlan, sw);
            System.out.println(sw);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    //HTTP Request method()
    public HTTPSamplerProxy addHttpSampleProxy(@RequestParam("URL") String url, List<ElementProp> elementPropList,
                                               List<StringProp> stringPropList, List<BoolProp> boolPropList) {
        HTTPSamplerProxy httpSamplerProxy = new HTTPSamplerProxy();

        
        return httpSamplerProxy;
    }
}
