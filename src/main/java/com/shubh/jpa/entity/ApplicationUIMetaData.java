package com.shubh.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: ApplicationMetaData
 * 
 * @author Shubham Bhindwal
 *
 */
@Entity
@Table(name = "ApplicationUIMetaData")
public class ApplicationUIMetaData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 255)
    @Size(min = 1, max = 128, message = "error.name.notnull")
    private String labelName;

    @Column(nullable = false, length = 255)
    @Size(min = 1, max = 128, message = "error.name.notnull")
    private String fieldType;

    @Column(nullable = false, length = 255)
    @Size(min = 1, max = 128, message = "error.name.notnull")
    private String fieldDataType;

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
     * @return the labelName
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * @param labelName
     *            the labelName to set
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    /**
     * @return the fieldType
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * @param fieldType
     *            the fieldType to set
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    /**
     * @return the fieldDataType
     */
    public String getFieldDataType() {
        return fieldDataType;
    }

    /**
     * @param fieldDataType
     *            the fieldDataType to set
     */
    public void setFieldDataType(String fieldDataType) {
        this.fieldDataType = fieldDataType;
    }

}
