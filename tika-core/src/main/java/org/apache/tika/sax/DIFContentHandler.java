package org.apache.tika.sax;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class DIFContentHandler extends DefaultHandler {
	
private static final char[] SPACE = new char[] {' '};
    
    private boolean flag;
    private Stack<String> treeStack;
    private final ContentHandler delegate;
    private final boolean addSpaceBetweenElements;

    public DIFContentHandler(ContentHandler delegate) {
    	
        this(delegate, false);
        this.flag = false;
    }

    public DIFContentHandler(ContentHandler delegate, boolean addSpaceBetweenElements) {
    	this.flag = false;
        this.delegate = delegate;
        this.addSpaceBetweenElements = addSpaceBetweenElements;
        this.treeStack = new Stack<String>();
        System.out.println("DIFContentHandler - delegate: " + delegate.getClass().getName());
    }

    @Override
    public void setDocumentLocator(org.xml.sax.Locator locator) {
	    delegate.setDocumentLocator(locator);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
    	/*if(this.flag) {
        	System.out.println(new String(ch, start, length));
    	}*/
    	Stack<String> tempStack = (Stack<String>) this.treeStack.clone();
    	String keyValue = "";
    	while(!tempStack.isEmpty()) {
    		keyValue = tempStack.pop() + "-" + keyValue;
    	}
    	keyValue = keyValue + " : " + (new String(ch, start, length)).toString();
        delegate.characters(keyValue.toCharArray(), 0, keyValue.toCharArray().length);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length)
            throws SAXException {
        delegate.ignorableWhitespace(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
             throws SAXException {
    	/*if(uri.equals("http://gcmd.gsfc.nasa.gov/Aboutus/xml/dif/")) {
        	System.out.println(localName);
        	this.flag = true;
    	}*/
    	this.treeStack.push(localName);
        if (addSpaceBetweenElements) {
            delegate.characters(SPACE, 0, SPACE.length);
        }
    }
    
    @Override
    public void endElement (String uri, String localName, String qName)
            throws SAXException {
    	this.treeStack.pop();
    }
    

    @Override
    public void startDocument() throws SAXException {
        delegate.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        delegate.endDocument();
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

}
