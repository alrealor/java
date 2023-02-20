package com.arao.challenges.topics.designpatterns.structural.adapter.players;

/**
 * Target Interface
 */
public interface MediaPlayer {

    public static final String MP3_FORMAT = "MP3";
    public static final String MP4_FORMAT = "MP4";
    public static final String WAV_FORMAT = "WAV";

    public void play(String format, String file);
}
