/**
 * @author Michael
 * @date 09.07.2013
 */
package com.wiki.wikidumpreader;

import javax.xml.stream.EventFilter;
import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


/**
 * @author Michael
 * @date 09.07.2013
 */
public class WikiDumpEventFilter implements StreamFilter {

	private static final String PAGE_TAG = "page";
	private static final String TITLE_TAG = "title";
	private String queryTitle;
	private boolean foundElement = false;
	
	
	/**
	 * 
	 * @author Michael
	 * @date 09.07.2013
	 * @param queryTitle
	 */
	public WikiDumpEventFilter(String queryTitle) {
		super();
		this.queryTitle = queryTitle;
		foundElement = false;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean accept(XMLStreamReader reader) {
		
		if(!foundElement && reader.isStartElement()) {
			if(reader.getName().equals(TITLE_TAG) && reader.getText().equals(queryTitle)) {
				foundElement = true;
			}
		} else if(foundElement && reader.isEndElement() && reader.getName().getLocalPart().equals(PAGE_TAG)) {
			foundElement = false;
		}
		
		return foundElement;
	}
}
