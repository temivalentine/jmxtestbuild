package com.jmxtestbuilder.toy.webcontroller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.logging.Logger;

public class JaxbGeneric {
    private static final Logger logger = Logger.getLogger(JaxbGeneric.class.getName());

    public static <T> File marshal(T object, Class<T> marshalClass, File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(marshalClass);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(object, file);

        return file;
    }
}
