package com.arao.challenges.topics.designpatterns.structural.adapter;

import com.arao.challenges.topics.designpatterns.structural.adapter.players.AdvancedPlayer;
import com.arao.challenges.topics.designpatterns.structural.adapter.players.MediaPlayer;
import com.arao.challenges.topics.designpatterns.structural.adapter.players.Mp4Player;
import com.arao.challenges.topics.designpatterns.structural.adapter.players.WavPlayer;

/**
 * Adapter class which contains instance of Adaptee class/es
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedPlayer advancedPlayer;

    public MediaAdapter(String format) {
        if (format.equalsIgnoreCase(MediaPlayer.MP4_FORMAT)) {
            advancedPlayer = new Mp4Player();
        } else if (format.equalsIgnoreCase(MediaPlayer.WAV_FORMAT)) {
            advancedPlayer = new WavPlayer();
        }
    }

    @Override
    public void play(String format, String file) {
        if (format.equalsIgnoreCase(MediaPlayer.MP4_FORMAT)) {
            advancedPlayer.playMp4(file);
        }
        if (format.equalsIgnoreCase(MediaPlayer.WAV_FORMAT)) {
            advancedPlayer.playWav(file);
        }
    }
}
