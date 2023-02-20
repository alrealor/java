package com.arao.challenges.topics.designpatterns.structural.bridge.abstraction;

import com.arao.challenges.topics.designpatterns.structural.bridge.implementation.Device;

// New remote that extends from basic remote
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        // assign the device to the super class
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
