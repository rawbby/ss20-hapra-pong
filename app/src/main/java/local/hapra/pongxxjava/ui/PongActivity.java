package local.hapra.pongxxjava.ui;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import local.hapra.pongxxjava.Pong;

/**
 * Activity des Spiels
 * aktualisiert von andbra im Feb2020
 * - savedInstanceState verwendet
 * @author Jan Bauerdick
 *
 */
public class PongActivity extends Activity {

    private Pong pongObj;
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onPause() {
        super.onPause();
        pongObj.onPause();
    }

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onResume() {
        super.onResume();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        pongObj = new Pong(this, getIntent());

        setContentView(pongObj);

        pongObj.onResume();
    }


}
