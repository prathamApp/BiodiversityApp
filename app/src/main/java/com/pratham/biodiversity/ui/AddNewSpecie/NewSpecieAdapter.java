package com.pratham.biodiversity.ui.AddNewSpecie;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class NewSpecieAdapter extends FragmentPagerAdapter {

    public NewSpecieAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Fragment_QuestionOne_(); //ChildFragment1 at position 0
            case 1:
                return new Fragment_QuestionTwo_();
            case 2:
                return new Fragment_QuestionThree_();
            case 3:
                return new Fragment_QuestionFour_();
            case 4:
                return new Fragment_QuestionFive_();
            case 5:
                return new Fragment_QuestionSix_();
            case 6:
                return new Fragment_QuestionSeven_();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 7;
    }
}
