package com.shubh;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.UUID;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.hyperledger.fabric.sdk.Enrollment;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class BlockChainUserEnrollment implements Enrollment,Serializable{

	public BlockChainUserEnrollment(String cert, String key) {
		super();
		this.cert = cert;
		this.key = key;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private UUID id;
	
	private String cert;
	private String key;
	

	
	
	public void setCert(String cert) {
		this.cert = cert;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public PrivateKey getKey() {
		PrivateKey privateKey = null;
		try {
			privateKey	 = 	getPrivateKeyFromString(key);
		} catch (NoSuchProviderException | NoSuchAlgorithmException | InvalidKeySpecException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return privateKey;
	}

	@Override
	public String getCert() {
		// TODO Auto-generated method stub
		return cert;
	}
	
    static PrivateKey getPrivateKeyFromString(String data) throws IOException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException {
        final Reader pemReader = new StringReader(new String(data));

        final PrivateKeyInfo pemPair;
        try (PEMParser pemParser = new PEMParser(pemReader)) {
            pemPair = (PrivateKeyInfo) pemParser.readObject();
        }

        PrivateKey privateKey = new JcaPEMKeyConverter().setProvider(BouncyCastleProvider.PROVIDER_NAME).getPrivateKey(pemPair);

        return privateKey;
    }


}
