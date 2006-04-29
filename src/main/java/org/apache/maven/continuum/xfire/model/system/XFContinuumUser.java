/*
 * $Id$
 */

package org.apache.maven.continuum.xfire.model.system;

// ---------------------------------/
// - Imported classes and packages -/
// ---------------------------------/

/**
 * null
 * 
 * @version $Revision$ $Date$
 */
public class XFContinuumUser implements java.io.Serializable {

    // --------------------------/
    // - Class/Member Variables -/
    // --------------------------/

    /**
     * Field accountId
     */
    private int accountId = 0;

    /**
     * Field username
     */
    private String username;

    /**
     * Field guest
     */
    private boolean guest = false;

    /**
     * Field hashedPassword
     */
    private String hashedPassword;

    /**
     * Field fullName
     */
    private String fullName;

    /**
     * Field email
     */
    private String email;

    /**
     * Field group
     */
    private XFUserGroup group;

    /**
     * Field notificationAddresses
     */
    private java.util.List notificationAddresses;


    // -----------/
    // - Methods -/
    // -----------/

    /**
     * Method addNotificationAddresse
     * 
     * @param notificationAddress
     */
    public void addNotificationAddresse(XFNotificationAddress notificationAddress) {
        getNotificationAddresses ().add (notificationAddress);
    } // -- void addNotificationAddresse(NotificationAddress)


    /**
     * Method equals
     * 
     * @param other
     */
    public boolean equals(Object other) {
        if (this == other) { return true; }

        if (!(other instanceof XFContinuumUser)) { return false; }

        XFContinuumUser that = (XFContinuumUser) other;
        boolean result = true;
        result = result && accountId == that.accountId;
        return result;
    } // -- boolean equals(Object)


    /**
     * Get null
     */
    public int getAccountId() {
        return this.accountId;
    } // -- int getAccountId()


    /**
     * Get null
     */
    public String getEmail() {
        return this.email;
    } // -- String getEmail()


    /**
     * Get null
     */
    public String getFullName() {
        return this.fullName;
    } // -- String getFullName()


    /**
     * Get null
     */
    public XFUserGroup getGroup() {
        return this.group;
    } // -- UserGroup getGroup()


    /**
     * Get null
     */
    public String getHashedPassword() {
        return this.hashedPassword;
    } // -- String getHashedPassword()


    /**
     * Method getNotificationAddresses
     */
    public java.util.List getNotificationAddresses() {
        if (this.notificationAddresses == null) {
            this.notificationAddresses = new java.util.ArrayList ();
        }

        return this.notificationAddresses;
    } // -- java.util.List getNotificationAddresses()


    /**
     * Get null
     */
    public String getUsername() {
        return this.username;
    } // -- String getUsername()


    /**
     * Method hashCode
     */
    public int hashCode() {
        int result = 17;
        long tmp;
        result = 37 * result + (int) accountId;
        return result;
    } // -- int hashCode()


    /**
     * Get null
     */
    public boolean isGuest() {
        return this.guest;
    } // -- boolean isGuest()


    /**
     * Method removeNotificationAddresse
     * 
     * @param notificationAddress
     */
    public void removeNotificationAddresse(XFNotificationAddress notificationAddress) {
        getNotificationAddresses ().remove (notificationAddress);
    } // -- void removeNotificationAddresse(NotificationAddress)


    /**
     * Set null
     * 
     * @param accountId
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    } // -- void setAccountId(int)


    /**
     * Set null
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    } // -- void setEmail(String)


    /**
     * Set null
     * 
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    } // -- void setFullName(String)


    /**
     * Set null
     * 
     * @param group
     */
    public void setGroup(XFUserGroup group) {
        this.group = group;
    } // -- void setGroup(UserGroup)


    /**
     * Set null
     * 
     * @param guest
     */
    public void setGuest(boolean guest) {
        this.guest = guest;
    } // -- void setGuest(boolean)


    /**
     * Set null
     * 
     * @param hashedPassword
     */
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    } // -- void setHashedPassword(String)


    /**
     * Set null
     * 
     * @param notificationAddresses
     */
    public void setNotificationAddresses(java.util.List notificationAddresses) {
        this.notificationAddresses = notificationAddresses;
    } // -- void setNotificationAddresses(java.util.List)


    /**
     * Set null
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    } // -- void setUsername(String)


    /**
     * Method toString
     */
    public java.lang.String toString() {
        StringBuffer buf = new StringBuffer ();
        buf.append ("accountId = '");
        buf.append (getAccountId () + "'");
        return buf.toString ();
    } // -- java.lang.String toString()


    public String getPassword() {
        return "";
    }


    public void setPassword(String password) {
        setHashedPassword (crypt (password));
    }


    public boolean equalsPassword(String password) {
        if (hashedPassword == null && password == null) { return true; }

        if ((hashedPassword == null && password != null) || (hashedPassword == null && password != null)) { return false; }

        return hashedPassword.equals (crypt (password));
    }


    private String crypt(String data) {
        try {
            java.security.MessageDigest digester = java.security.MessageDigest.getInstance ("SHA-1");
            digester.reset ();
            digester.update (data.getBytes ());
            return encode (digester.digest ());
        } catch (Exception e) {
            return data;
        }
    }


    /**
     * Encodes a 128 bit or 160-bit byte array into a String.
     * 
     * @param binaryData
     *            Array containing the digest
     * @return Encoded hex string, or null if encoding failed
     */
    private String encode(byte [] binaryData) {
        if (binaryData.length != 16 && binaryData.length != 20) {
            int bitLength = binaryData.length * 8;
            throw new IllegalArgumentException ("Unrecognised length for binary data: " + bitLength + " bits");
        }

        String retValue = "";

        for (int i = 0; i < binaryData.length; i++) {
            String t = Integer.toHexString (binaryData[i] & 0xff);

            if (t.length () == 1) {
                retValue += ("0" + t);
            } else {
                retValue += t;
            }
        }

        return retValue.trim ();
    }

    private String modelEncoding = "UTF-8";


    public void setModelEncoding(String modelEncoding) {
        this.modelEncoding = modelEncoding;
    }


    public String getModelEncoding() {
        return modelEncoding;
    }
}
