package com.arao.challenges.topics.designpatterns.structural.adapter.players;

// Adaptee class that offers the same feature but by exposing a different interface (AdvancedPlayer instead of MediaPlayer)
public class Mp4Player implements AdvancedPlayer {
    @Override
    public void playMp4(String file) {
        System.out.println("MP4 File "+ file + " Playing....");
    }

    @Override
    public void playWav(String file) {
        // do nothing
    }
}
