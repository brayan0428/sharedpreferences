package brayan0428.appstudent.com.loginsp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    Button btnVerde,btnRojo,btnAmarillo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = findViewById(R.id.toolbar);
        btnVerde = findViewById(R.id.btnVerde);
        btnRojo = findViewById(R.id.btnRojo);
        btnAmarillo = findViewById(R.id.btnAmarillo);

        btnVerde.setOnClickListener(this);
        btnRojo.setOnClickListener(this);
        btnAmarillo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnVerde :
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                break;
            case R.id.btnRojo :
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorRed));
                break;
            case R.id.btnAmarillo :
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                break;
        }
    }

    private void guardarColor(int color){
        SharedPreferences sharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("color",color);
        editor.commit();
    }

    private int obtenerColor(){
        SharedPreferences sharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        return sharedPreferences.getInt("color",getResources().getColor(R.color.colorPrimaryDark));
    }
}
