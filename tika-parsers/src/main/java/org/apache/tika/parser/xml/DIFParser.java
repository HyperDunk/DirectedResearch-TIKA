package org.apache.tika.parser.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.tika.exception.TikaException;
import org.apache.tika.io.CloseShieldInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.DIFContentHandler;
import org.apache.tika.sax.EmbeddedContentHandler;
import org.apache.tika.sax.OfflineContentHandler;
import org.apache.tika.sax.TaggedContentHandler;
import org.apache.tika.sax.XHTMLContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class DIFParser extends AbstractParser {

    private static final Set<MediaType> SUPPORTED_TYPES =
            Collections.unmodifiableSet(new HashSet<MediaType>(Arrays.asList(
                    MediaType.text("dif+xml"))));
    
    @Override
    public Set<MediaType> getSupportedTypes(ParseContext context) {
        // TODO Auto-generated method stub
        return SUPPORTED_TYPES;
    }

    @Override
    public void parse(InputStream stream, ContentHandler handler,
            Metadata metadata, ParseContext context) throws IOException,
            SAXException, TikaException {
        // TODO Auto-generated method stub
        System.out.println(handler.getClass().getName());
        System.out.println(handler.toString());
        System.out.println(context.getClass().toString());
        System.out.println(metadata.toString());
        
        final XHTMLContentHandler xhtml =
            new XHTMLContentHandler(handler, metadata);
        xhtml.startDocument();
        xhtml.startElement("p");

        TaggedContentHandler tagged = new TaggedContentHandler(handler);
        try {
            context.getSAXParser().parse(
                    new CloseShieldInputStream(stream),
                    new OfflineContentHandler(new EmbeddedContentHandler(
                            getContentHandler(tagged, metadata, context))));
        } catch (SAXException e) {
            tagged.throwIfCauseOf(e);
            throw new TikaException("XML parse error", e);
        } finally {
            xhtml.endElement("p");
            xhtml.endDocument();
        }

    }
    
    protected ContentHandler getContentHandler(
            ContentHandler handler, Metadata metadata, ParseContext context) {
                
        return new DIFContentHandler(handler, true);
        
    }

}
