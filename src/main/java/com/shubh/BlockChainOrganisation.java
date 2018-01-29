package com.shubh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.User;
import org.hyperledger.fabric_ca.sdk.HFCAClient;

public class BlockChainOrganisation {

     String name;
     String mspid;
    HFCAClient caClient;

    Map<String, User> userMap = new HashMap<>();
    Map<String, String> peerLocations = new HashMap<>();
    Map<String, String> ordererLocations = new HashMap<>();
    Map<String, String> eventHubLocations = new HashMap<>();
    Set<Peer> peers = new HashSet<>();
    private BlockChainUser admin;
    private String caLocation;
    private Properties caProperties = null;

    private BlockChainUser peerAdmin;


    private String domainName;
	
}
