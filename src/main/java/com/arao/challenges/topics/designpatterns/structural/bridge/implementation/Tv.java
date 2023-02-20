package com.arao.challenges.topics.designpatterns.structural.bridge.implementation;

// Implementation class for Device interface
public class Tv implements Device {

    private boolean on = false;
    private int volume = 5;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int getChannel() {
        return this.channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("Tv status: " + (on ? "enabled" : "disabled") + " - Current volume: " + this.volume
                           + " - Current channel: " + this.channel + "\n");
    }}
