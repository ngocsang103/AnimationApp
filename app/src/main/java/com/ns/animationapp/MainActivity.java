package com.ns.animationapp;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ns.animationapp.activtity.AutoTransitionSample;
import com.ns.animationapp.activtity.ChangeTextSample;
import com.ns.animationapp.activtity.CustomTransitionSample;
import com.ns.animationapp.activtity.ExplodeAndEpicenterExample;
import com.ns.animationapp.activtity.ImageTransformSample;
import com.ns.animationapp.activtity.InterpolatorDurationStartDelaySample;
import com.ns.animationapp.activtity.PathMotionSample;
import com.ns.animationapp.activtity.RecolorSample;
import com.ns.animationapp.activtity.RotateSample;
import com.ns.animationapp.activtity.ScaleSample;
import com.ns.animationapp.activtity.ScenesSample;
import com.ns.animationapp.activtity.SlideSample;
import com.ns.animationapp.activtity.TransitionNameSample;
import com.ns.animationapp.activtity.TwoBecomeOne;
import com.ns.animationapp.widget.ListFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.SampleProviderList{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListFragment listFragment = new ListFragment();
        listFragment.setSampleProviderList(this);
        getSupportFragmentManager()
                .beginTransaction()
                //add(R.id.container, listFragment)
                .replace(R.id.container, listFragment)
                .commit();
    }

    @Override
    public void selectedSample(int index) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out,
                        R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.container, createFragmentForPosition(index))
                .addToBackStack(String.valueOf(index))
                .commit();

    }

    private Fragment createFragmentForPosition(int index) {
        switch (index) {
            case 0: return new AutoTransitionSample();
            case 1: return new InterpolatorDurationStartDelaySample();
            case 2: return new PathMotionSample();
            case 3: return new SlideSample();
            case 4: return new ScaleSample();
            case 5: return new ExplodeAndEpicenterExample();
            case 6: return new TransitionNameSample();
            case 7: return new ImageTransformSample();
            case 8: return new RecolorSample();
            case 9: return new RotateSample();
            case 10: return new ChangeTextSample();
            case 11: return new CustomTransitionSample();
            case 12: return new ScenesSample();
            case 13: return new TwoBecomeOne();
        }
        return null;
    }

    @Override
    public String getTitleSample(int index) {
        switch (index) {
            case 0: return "Simple animations with AutoTransition";
            case 1: return "Interpolator, duration, start delay";
            case 2: return "Path motion";
            case 3: return "Slide transition";
            case 4: return "Scale transition";
            case 5: return "Explode transition and epicenter";
            case 6: return "Transition names";
            case 7: return "ChangeImageTransform transition";
            case 8: return "Recolor transition";
            case 9: return "Rotate transition";
            case 10: return "Change text transition";
            case 11: return "Custom transition";
            case 12: return "Scene to scene transitions";
            case 13: return "Two button become one";
        }
        return null;
    }

    @Override
    public int getSampleCount() {
        return 14;
    }
}
