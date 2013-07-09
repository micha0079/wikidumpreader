/**
 * @author Michael
 * @date 09.07.2013
 */
package com.wiki.wikidumpreader;

import java.awt.print.PageFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.bind.annotation.XmlInlineBinaryData;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wiki.wikidumpreader.model.WikiDumpContributor;
import com.wiki.wikidumpreader.model.WikiDumpPage;
import com.wiki.wikidumpreader.model.WikiDumpRevision;

/**
 * @author Michael
 * @date 09.07.2013
 */
public class WikiDumpReader {

	private static final String PAGE_TAG = "page";
	private static final String TITLE_TAG = "title";
	private static final String ID_TAG = "id";
	private static final String NS_TAG = "ns";
	private static final String REVISION_TAG = "revision";
	private static final String PARENTID_TAG = "parentid";
	private static final String TIMESTAMP_TAG = "timestamp";
	private static final String CONTRIBUTOR_TAG = "contributor";
	private static final String CONTRIBUTOR_USERNAME_TAG = "username";
	private static final String CONTRIBUTOR_ID_TAG = "id";
	private static final String COMMENT_TAG = "comment";
	private static final String TEXT_TAG = "text";
	private static final String SHA1_TAG = "sha1";
	private static final String MODEL_TAG = "model";
	private static final String FORMAT_TAG = "format";

	private static Logger log = LogManager.getLogger(WikiDumpReader.class);

	private String dumpFilePath;

	/**
	 * 
	 * @author Michael
	 * @date 09.07.2013
	 * @param dumpFilePath
	 */
	public WikiDumpReader(String dumpFilePath) {
		super();
		this.dumpFilePath = dumpFilePath;
	}

	/**
	 * 
	 * @author Michael
	 * @date 09.07.2013
	 * @param title
	 * @return
	 */
	public WikiDumpPage getPageByTitle(String title) {
		WikiDumpPage result = null;

		InputStream xmlInputStream = null;
		XMLStreamReader streamReader = null;
		try {
			File file = new File(dumpFilePath);
			if (!file.exists()) {
				log.error("Dump File on path " + dumpFilePath
						+ " doesn't exist!");
				return result;
			} else {
				XMLInputFactory factory = XMLInputFactory.newFactory();
				xmlInputStream = new FileInputStream(file);
				streamReader = factory.createXMLStreamReader(xmlInputStream,
						"UTF-8");
				result = getPageFromStream(streamReader, title);
				streamReader.close();
				xmlInputStream.close();
			}
		} catch (Exception e) {
			log.error("error processing xml document: " + e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 
	 * @author Michael
	 * @date 09.07.2013
	 * @param streamReader
	 * @param queryTitle
	 * @return
	 * @throws XMLStreamException
	 */
	private static WikiDumpPage getPageFromStream(XMLStreamReader streamReader,
			String queryTitle) throws XMLStreamException {
		WikiDumpPage wikiDumpPage = null;

		boolean pageStartFound = false;
		boolean pageEndFound = false;
		boolean revisionStart = false;
		boolean contributorStart = false;

		while (streamReader.hasNext() && !pageEndFound) {
			streamReader.next();
			if (!pageStartFound && streamReader.isStartElement()
					&& streamReader.getName().getLocalPart().equals(TITLE_TAG)
					&& streamReader.getElementText().equals(queryTitle)) {
				wikiDumpPage = new WikiDumpPage();
				wikiDumpPage.setTitle(queryTitle);
				pageStartFound = true;
			} else if (streamReader.isStartElement() && pageStartFound
					&& !pageEndFound) {
				String localName = streamReader.getName().getLocalPart();

				if (localName.equals(REVISION_TAG)) {
					if (streamReader.isStartElement()) {
						revisionStart = true;
						wikiDumpPage.setRevision(new WikiDumpRevision());
					} else if (streamReader.isEndElement()) {
						revisionStart = false;
					}

				} else if (localName.equals(CONTRIBUTOR_TAG)) {
					if (streamReader.isStartElement()) {
						contributorStart = true;
						wikiDumpPage.getRevision().setContributor(new WikiDumpContributor());
					} else if (streamReader.isEndElement()) {
						contributorStart = false;
					}
				} else {
					String valueString = streamReader.getElementText();
					if (localName.equals(NS_TAG)) {
						wikiDumpPage.setNs(new Long(valueString));

					} else if (localName.equals(ID_TAG)) {
						if (revisionStart) {
							wikiDumpPage.getRevision().setId(
									new Long(valueString));
						} else if (contributorStart) {
							wikiDumpPage.getRevision().getContributor()
									.setId(new Long(valueString));
						} else {
							wikiDumpPage.setId(new Long(valueString));
						}

					} else if (localName.equals(PARENTID_TAG)) {
						wikiDumpPage.getRevision().setParentId(
								new Long(valueString));
					} else if (localName.equals(TIMESTAMP_TAG)) {
						wikiDumpPage.getRevision().setTimestamp(valueString);
					} else if (localName.equals(CONTRIBUTOR_USERNAME_TAG)) {
						wikiDumpPage.getRevision().getContributor()
								.setUsername(valueString);
					} else if (localName.equals(COMMENT_TAG)) {
						wikiDumpPage.getRevision().setComment(valueString);
					} else if (localName.equals(TEXT_TAG)) {
						wikiDumpPage.getRevision().setText(valueString);
					} else if (localName.equals(SHA1_TAG)) {
						wikiDumpPage.getRevision().setSha1(valueString);
					} else if (localName.equals(MODEL_TAG)) {
						wikiDumpPage.getRevision().setModel(valueString);
					} else if (localName.equals(FORMAT_TAG)) {
						wikiDumpPage.getRevision().setFormat(valueString);
					}
				}
			} else if (streamReader.isEndElement() && pageStartFound
					&& streamReader.getName().getLocalPart().equals(PAGE_TAG)) {
				pageEndFound = true;
			}
		}

		return wikiDumpPage;
	}

	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the dumpFilePath
	 */
	public String getDumpFilePath() {
		return dumpFilePath;
	}

}
