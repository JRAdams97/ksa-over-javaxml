package com.ksa;

import com.ksa.model.entity.Database;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLDataLoader {

	public Database parseAsMovie(File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Database.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		return (Database) jaxbUnmarshaller.unmarshal(file);
	}
}
