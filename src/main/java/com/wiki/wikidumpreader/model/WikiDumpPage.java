/**
 * @author Michael
 * @date 09.07.2013
 */
package com.wiki.wikidumpreader.model;

/**
 * @author Michael
 * @date 09.07.2013
 */
public class WikiDumpPage {

	private String title;
	private Long ns;
	private Long id;
	private WikiDumpRevision revision;
	
	
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the ns
	 */
	public Long getNs() {
		return ns;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param ns the ns to set
	 */
	public void setNs(Long ns) {
		this.ns = ns;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the revision
	 */
	public WikiDumpRevision getRevision() {
		return revision;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param revision the revision to set
	 */
	public void setRevision(WikiDumpRevision revision) {
		this.revision = revision;
	}
}
