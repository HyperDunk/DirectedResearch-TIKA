package org.apache.tika.parser.xml;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.tika.metadata.DublinCore;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.TeeContentHandler;
import org.xml.sax.ContentHandler;

public class DIFParser extends XMLParser {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6438308460800789006L;
	
	private static final Set<MediaType> SUPPORTED_TYPES =
        Collections.unmodifiableSet(new HashSet<MediaType>(Arrays.asList(
                MediaType.application("x-gcmd-dif"))));

    public Set<MediaType> getSupportedTypes(ParseContext context) {
        return SUPPORTED_TYPES;
    }
    
    /*private static ContentHandler getDublinCoreHandler(
            Metadata metadata, Property property, String element) {
        return new ElementMetadataHandler(
                DublinCore.NAMESPACE_URI_DC, element,
                metadata, property);
    }
    
    protected ContentHandler getContentHandler(
            ContentHandler handler, Metadata metadata, ParseContext context) {
        return new TeeContentHandler(
                super.getContentHandler(handler, metadata, context),
                getDublinCoreHandler(metadata, TikaCoreProperties.TITLE, "title"),
                getDublinCoreHandler(metadata, TikaCoreProperties.KEYWORDS, "subject"),
                getDublinCoreHandler(metadata, TikaCoreProperties.CREATOR, "creator"),
                getDublinCoreHandler(metadata, TikaCoreProperties.DESCRIPTION, "description"),
                getDublinCoreHandler(metadata, TikaCoreProperties.PUBLISHER, "publisher"),
                getDublinCoreHandler(metadata, TikaCoreProperties.CONTRIBUTOR, "contributor"),
                getDublinCoreHandler(metadata, TikaCoreProperties.CREATED, "date"),
                getDublinCoreHandler(metadata, TikaCoreProperties.TYPE, "type"),
                getDublinCoreHandler(metadata, TikaCoreProperties.FORMAT, "format"),
                getDublinCoreHandler(metadata, TikaCoreProperties.IDENTIFIER, "identifier"),
                getDublinCoreHandler(metadata, TikaCoreProperties.LANGUAGE, "language"),
                getDublinCoreHandler(metadata, TikaCoreProperties.RIGHTS, "rights"));
    }*/

}
