package com.arao.challenges.topics.designpatterns.structural.adapter;

import com.arao.challenges.topics.designpatterns.structural.adapter.players.AudioPlayer;

/**
 * ADAPTER pattern
 *
 * The adapter class has a Client class that expects some object type, and it has an Adaptee class that offers the same
 * feature but by exposing a different interface.
 *
 * Following are three key point for Adapter pattern
 * 1. A target interface (ie MediaPlayer)
 * 2. An Adaptee class (could be from library or external app) which will use the Adapter class (MP4Player, WavPlayer)
 * 3. The Adapter class which translate the request from Adaptee to a know functionality
 */
public class AdapterTester {

    public static void main(String args[]) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "song1.mp3");
        audioPlayer.play("mp4", "song2.mp4");
        audioPlayer.play("wav", "song3.wav");
        audioPlayer.play("avi", "song4.avi");
    }
}
