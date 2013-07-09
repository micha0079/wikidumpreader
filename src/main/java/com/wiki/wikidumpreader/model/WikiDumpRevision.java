/**
 * @author Michael
 * @date 09.07.2013
 */
package com.wiki.wikidumpreader.model;

/**
 * @author Michael
 * @date 09.07.2013
 */
public class WikiDumpRevision {

	private Long id;
	private Long parentId;
	private String timestamp;
	private WikiDumpContributor contributor;
	private String comment;
	private String text;
	private String sha1;
	private String model;
	private String format;
	
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
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the contributor
	 */
	public WikiDumpContributor getContributor() {
		return contributor;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param contributor the contributor to set
	 */
	public void setContributor(WikiDumpContributor contributor) {
		this.contributor = contributor;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the sha1
	 */
	public String getSha1() {
		return sha1;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param sha1 the sha1 to set
	 */
	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * @author Michael
	 * @date 09.07.2013
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}
}
