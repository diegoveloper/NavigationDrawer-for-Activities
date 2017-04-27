package pe.diegoveloper.belatrix.desafiobelatrix5_2017.activities;

import android.os.Bundle;

import pe.diegoveloper.belatrix.desafiobelatrix5_2017.R;
import pe.diegoveloper.belatrix.desafiobelatrix5_2017.activities.base.AbstractDrawerActivity;

public class Page3Activity extends AbstractDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_page3;
    }

    @Override
    public String getCustomTitle() {
        return this.getClass().getSimpleName();
    }
}
