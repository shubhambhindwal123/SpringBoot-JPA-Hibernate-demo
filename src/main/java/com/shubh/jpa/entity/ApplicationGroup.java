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

/**
 * ApplicationGroup Entity
 * 
 * @author Shubham Bhindwal
 *
 */
@Entity
public class ApplicationGroup implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ApplicationVO> applicationVOs;

    public Set<ApplicationVO> getApplicationVOs() {
        return applicationVOs;
    }

    public void setApplicationVOs(Set<ApplicationVO> applicationVOs) {
        this.applicationVOs = applicationVOs;
    }

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

}
