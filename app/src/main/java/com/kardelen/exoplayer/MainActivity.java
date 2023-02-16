package com.kardelen.exoplayer;

import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.alexvas.rtsp.widget.RtspSurfaceView;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
public class MainActivity extends AppCompatActivity {
    private RtspSurfaceView svVideo;
    private SimpleExoPlayer player;
    private PlayerView playerView;
    public  Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        playerView = findViewById(R.id.player_view);
        svVideo = findViewById(R.id.svVideo);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        player = new SimpleExoPlayer.Builder(this).build();
//        playerView.setPlayer(player);
//        // RTSP video akışının URL'si
//        String videoUri = "rtsp://rtsp.stream/pattern";
//        MediaSource mediaSource = new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory(this, "exoplayer-codelab")).createMediaSource(MediaItem.fromUri(Uri.parse(videoUri)));
//        player.prepare(mediaSource);
//        player.setPlayWhenReady(true);
        uri = Uri.parse("rtsp://192.168.1.10:554/user=admin&password=&channel=1&stream=0.sdp?");
        svVideo.init(uri,"","");
        svVideo.start(true,true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        playerView.setPlayer(null);
        player.release();
        player = null;
    }
}