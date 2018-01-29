package com.shubh.jpa.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: pb_user_role
 * 
 * @author Shubham Bhindwal
 *
 */
@Entity
@Table(name = "application")
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 255)
    @Size(min = 1, max = 128, message = "error.name.notnull")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ApplicationUIMetaData> applicationMetaData;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ApplicationGroup> applicationGroups;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the applicationMetaData
     */
    public Set<ApplicationUIMetaData> getApplicationMetaData() {
        return applicationMetaData;
    }

    /**
     * @param applicationMetaData
     *            the applicationMetaData to set
     */
    public void setApplicationMetaData(Set<ApplicationUIMetaData> applicationMetaData) {
        this.applicationMetaData = applicationMetaData;
    }

    /**
     * @return the applicationGroups
     */
    public Set<ApplicationGroup> getApplicationGroups() {
        return applicationGroups;
    }

    /**
     * @param applicationGroups
     *            the applicationGroups to set
     */
    public void setApplicationGroups(Set<ApplicationGroup> applicationGroups) {
        this.applicationGroups = applicationGroups;
    }

}
