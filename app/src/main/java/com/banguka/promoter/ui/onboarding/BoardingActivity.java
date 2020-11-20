package com.banguka.promoter.ui.onboarding;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.banguka.promoter.BR;
import com.banguka.promoter.R;
import com.banguka.promoter.databinding.ActivityBoardingBinding;
import com.banguka.promoter.di.components.ActivityComponent;
import com.banguka.promoter.ui.auth.login.LoginActivity;
import com.banguka.promoter.ui.base.BaseActivity;
import com.banguka.promoter.ui.splash.SplashActivity;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class BoardingActivity extends BaseActivity<ActivityBoardingBinding, BoardingViewModel> implements BoardingNavigation {

    ActivityBoardingBinding activityBoardingBinding;

    public static Intent intent(Context context) {
        return new Intent(context, BoardingActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityBoardingBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        PaperOnboardingPage scr1 = new PaperOnboardingPage("Hotels",
                "All hotels and hostels are sorted by hospitality rating",
                Color.parseColor("#678FB4"), R.drawable.flag_aland_islands, R.drawable.flag_antarctica);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Banks",
                "We carefully verify all banks before add them into the app",
                Color.parseColor("#65B0B4"), R.drawable.flag_russian_federation, R.drawable.flag_afghanistan);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Stores",
                "All local stores are categorized for your convenience",
                Color.parseColor("#9B90BC"), R.drawable.flag_albania, R.drawable.flag_algeria);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);

        PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(elements);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(activityBoardingBinding.frameLayout.getId(), onBoardingFragment);
        fragmentTransaction.commit();

        onBoardingFragment.setOnRightOutListener(() -> viewModel.getNavigator().login());
    }

    @Override
    public int getBindingVariable() {
        return BR.BoardingViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_boarding;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void login() {
        startActivity(LoginActivity.newIntent(this));
    }

}