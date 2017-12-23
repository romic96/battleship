package com.example.michal.battleship.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.michal.battleship.R;
import com.example.michal.battleship.auth.session.ISessionManager;
import com.example.michal.battleship.auth.session.SessionManagerSharedPreferences;
import com.example.michal.battleship.auth.session.SessionService;
import com.example.michal.battleship.views.gameView.GameActivity;
import com.example.michal.battleship.views.gameView.chooseGameType.ChooseGameTypeFragment;
import com.example.michal.battleship.views.settingsView.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    private Button startGameBtn;

    private Button settingsBtn;

    private Button exitBtn;

    private ISessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkLogin();
        initialize();
    }

    private void checkLogin() {
        SessionService sessionService = new SessionService();
        session = sessionService.getSessionManager(getApplicationContext());
        session.checkLogin();
    }

    private void initialize() {
        createPlayButton();
        createSettingsButton();
        createExitButton();
    }

    private void createPlayButton() {
        startGameBtn = findViewById(R.id.btnMenuPlay);
        startGameBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        });
    }

    private void createSettingsButton() {
        settingsBtn = findViewById(R.id.btnMenuSetting);
        settingsBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });
    }

    private void createExitButton() {
        exitBtn = findViewById(R.id.btnMenuExit);
        exitBtn.setOnClickListener(view -> {
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory(Intent.CATEGORY_HOME);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        });
    }
}
