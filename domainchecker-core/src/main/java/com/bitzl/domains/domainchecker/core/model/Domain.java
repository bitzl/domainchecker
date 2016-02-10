package com.bitzl.domains.domainchecker.core.model;

public class Domain {

    private String name;
    private boolean exists;
    private String tld;

    public Domain(String name) {
        setName(name);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public boolean getExists() {
        return exists;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    public String getTld() {
        return tld;
    }
}
