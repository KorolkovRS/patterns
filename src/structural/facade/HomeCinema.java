package structural.facade;

class TV {
    public void turnOnTV() {
        System.out.println("TV turn on");
    }

    public void turnOffTV() {
        System.out.println("TV turn off");
    }
}

class AudioSystem {
    public void turnOnAudioSystem() {
        System.out.println("Audio system turn on");
    }

    public void turnOffAudioSystem() {
        System.out.println("Audio system turn off");
    }
}

class VideoPlayer {
    public void turnOnVideoPlayer() {
        System.out.println("Video player turn on");
    }

    public void turnOffVideoPlayer() {
        System.out.println("Video player turn off");
    }
}

class HomeCinema {
    private TV tv;
    private AudioSystem audioSystem;
    private VideoPlayer videoPlayer;

    public HomeCinema(TV tv, AudioSystem audioSystem, VideoPlayer videoPlayer) {
        this.tv = tv;
        this.audioSystem = audioSystem;
        this.videoPlayer = videoPlayer;
    }

    public void turnOnHomeCinema() {
        tv.turnOnTV();
        audioSystem.turnOnAudioSystem();
        videoPlayer.turnOnVideoPlayer();
        System.out.println("Hello user!");
    }

    public void turnOffHomeCinema() {
        tv.turnOffTV();
        audioSystem.turnOffAudioSystem();
        videoPlayer.turnOffVideoPlayer();
        System.out.println("Goodbye user!");
    }
}

class Solution {
    public static void main(String[] args) {
        HomeCinema homeCinema = new HomeCinema(new TV(), new AudioSystem(), new VideoPlayer());
        homeCinema.turnOnHomeCinema();
        homeCinema.turnOffHomeCinema();
    }
}


