package com.arao.challenges.topics.designpatterns.structural.adapter.players;

// Adaptee class that offers the same feature but by exposing a different interface (AdvancedPlayer instead of MediaPlayer)
public class WavPlayer implements AdvancedPlayer {
    @Override
    public void playMp4(String file) {
        // do nothing
    }

    @Override
    public void playWav(String file) {
        System.out.println("WAV File "+ file + " Playing....");
    }
}
