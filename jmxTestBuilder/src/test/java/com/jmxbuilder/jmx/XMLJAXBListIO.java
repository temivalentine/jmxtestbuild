package com.jmxbuilder.jmx;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLJAXBListIO<T> implements ListIO<T> {
    private final Class typeInList;

    public XMLJAXBListIO(Class typeInList) {
        this.typeInList = typeInList;
    }

    @Override
    public void saveToFile(final List<T> list, final String fileName) {
        try {
            JaxbList<T> jaxbList = new JaxbList<>(list);
            File file = openFile(fileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            String xsdFilename = fileName + ".xsd";
            JAXBContext jaxbContext = JAXBContext.newInstance(jaxbList.getClass(), typeInList);
            jaxbContext.generateSchema(new XSDSchemaGenerator(xsdFilename));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, xsdFilename);
            marshaller.marshal(jaxbList, outputStream);
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "Cannot save list of items to file " + fileName, e);
            throw new ListIOException("Error saving to file", e);
        }
    }

    @Override
    public void appendToFile(final List<T> listToAppend, final String fileName) {
        List<T> list = loadFromFile(fileName);
        list.addAll(listToAppend);
        saveToFile(list, fileName);
    }

    @Override
    public List<T> loadFromFile(final String fileName) {
        try {
            List<T> list = new ArrayList<>();
            File file = openFile(fileName);
            FileInputStream fin = new FileInputStream(file);
            if (fin.read() != -1) //if file is not empty
            {
                JAXBContext jc = JAXBContext.newInstance(JaxbList.class, typeInList);
                String xsdFilename = fileName + ".xsd";
                Unmarshaller u = jc.createUnmarshaller();
                SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
                Schema schema = schemaFactory.newSchema(new File(xsdFilename));
                u.setSchema(schema);
                JaxbList<T> retrievedList = (JaxbList<T>) u.unmarshal(file);
                if (retrievedList.getList() != null) {
                    list = retrievedList.getList();
                }
            }
            return list;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "Cannot load list of items from file " + fileName, e);
            throw new ListIOException("Error loading from file", e);
        }
    }

    private static File openFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                String errormsg = "Cannot create a new file, possibly due to permissions.";
                Logger.getGlobal().log(Level.SEVERE, errormsg);
                throw new ListIOException(errormsg);
            }
        }
        return file;
    }

    @XmlRootElement(name = "list")
    private static class JaxbList<T> {
        @XmlElement(name = "item")
        private List<T> list;

        protected JaxbList() {
        }

        public JaxbList(List<T> list) {
            this.list = list;
        }


        public List<T> getList() {
            return list;
        }
    }


    private class XSDSchemaGenerator extends SchemaOutputResolver {
        private String filename;

        public XSDSchemaGenerator(String filename) {
            this.filename = filename;
        }

        @Override
        public Result createOutput(final String namespaceUri, final String suggestedFileName) throws IOException {
            File file = openFile(filename);
            return new StreamResult(file);
        }
    }

}