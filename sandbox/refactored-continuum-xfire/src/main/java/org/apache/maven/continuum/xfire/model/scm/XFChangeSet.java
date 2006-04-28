/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.scm;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

/**
 * null
 * 
 * @version $Revision$ $Date$
 */
public class XFChangeSet implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field author
     */
    private String author;

    /**
     * Field comment
     */
    private String comment;

    /**
     * Field date
     */
    private long date = 0;

    /**
     * Field files
     */
    private java.util.List files;


    // -----------/
    // - Methods -/
    // -----------/

    /**
     * Method addFile
     * 
     * @param changeFile
     */
    public void addFile(XFChangeFile changeFile) {
        getFiles ().add (changeFile);
    } // -- void addFile(ChangeFile)


    /**
     * Get null
     */
    public String getAuthor() {
        return this.author;
    } // -- String getAuthor()


    /**
     * Get null
     */
    public String getComment() {
        return this.comment;
    } // -- String getComment()


    /**
     * Get null
     */
    public long getDate() {
        return this.date;
    } // -- long getDate()


    /**
     * Method getFiles
     */
    public java.util.List getFiles() {
        if (this.files == null) {
            this.files = new java.util.ArrayList ();
        }

        return this.files;
    } // -- java.util.List getFiles()


    /**
     * Method removeFile
     * 
     * @param changeFile
     */
    public void removeFile(XFChangeFile changeFile) {
        getFiles ().remove (changeFile);
    } // -- void removeFile(ChangeFile)


    /**
     * Set null
     * 
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    } // -- void setAuthor(String)


    /**
     * Set null
     * 
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    } // -- void setComment(String)


    /**
     * Set null
     * 
     * @param date
     */
    public void setDate(long date) {
        this.date = date;
    } // -- void setDate(long)


    /**
     * Set null
     * 
     * @param files
     */
    public void setFiles(java.util.List files) {
        this.files = files;
    } // -- void setFiles(java.util.List)


    /**
     * @return Returns string representation of the changeset
     */
    public String toString() {
        String result = author + "\n" + date + "\n";

        if (files != null) {
            for (java.util.Iterator i = files.iterator (); i.hasNext ();) {
                XFChangeFile file = (XFChangeFile) i.next ();

                result += file + "\n";
            }
        }

        result += comment;

        return result;
    }


    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (obj instanceof XFChangeSet) {
            XFChangeSet changeSet = (XFChangeSet) obj;

            if (toString ().equals (changeSet.toString ())) { return true; }
        }

        return false;
    }


    public java.util.Date getDateAsDate() {
        if (date > 0) { return new java.util.Date (date); }

        return null;
    }

    private String modelEncoding = "UTF-8";


    public void setModelEncoding(String modelEncoding) {
        this.modelEncoding = modelEncoding;
    }


    public String getModelEncoding() {
        return modelEncoding;
    }
}
