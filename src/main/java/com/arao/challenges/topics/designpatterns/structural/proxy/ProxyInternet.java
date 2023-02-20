package com.arao.challenges.topics.designpatterns.structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {

    // Proxy class contains the instance to the original object
    private Internet internet = new RealInternet();

    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<>();
        bannedSites.add("suspicious.com");
        bannedSites.add("wrong.com");
        bannedSites.add("badsite.com");
        bannedSites.add("dontdothis.com");
    }

    @Override
    public void connectTo(String serverHost) throws Exception {
        if (bannedSites.contains(serverHost.toLowerCase())) {
            throw new Exception("Site " + serverHost.toLowerCase() + " is denied");
        }
        // call the original project method
        internet.connectTo(serverHost);
    }
}
