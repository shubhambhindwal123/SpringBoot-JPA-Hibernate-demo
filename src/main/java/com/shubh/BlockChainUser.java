package com.shubh;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.User;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Table
public class BlockChainUser implements User,Serializable{

	public BlockChainUser(String name, Set<String> roles, String account, String affiliation, String mspId,
			BlockChainUserEnrollment enrollment) {
		this.name = name;
		this.roles = roles;
		this.account = account;
		this.affiliation = affiliation;
		this.mspId = mspId;
		this.enrollment = enrollment;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private UUID id;
	
	private String name;
	private Set<String> roles;
	private String account;
	private String affiliation;
	private String mspId;

	@OneToOne(cascade = CascadeType.ALL)
	private  BlockChainUserEnrollment enrollment;

	public void setName(String name) {
		this.name = name;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public void setMspId(String mspId) {
		this.mspId = mspId;
	}

	public void setEnrollment(BlockChainUserEnrollment enrollment) {
		this.enrollment = enrollment;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Set<String> getRoles() {
		return roles;
	}

	@Override
	public String getAccount() {
		return account;
	}

	@Override
	public String getAffiliation() {
		return affiliation;
	}

	@Override
	public Enrollment getEnrollment() {
		return enrollment;
	}

	@Override
	public String getMspId() {
		return mspId;
	}

}
