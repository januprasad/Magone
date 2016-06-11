package com.xoul.ru.magone.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.xoul.ru.magone.R;
import com.xoul.ru.magone.adapter.SpellAdapter;
import com.xoul.ru.magone.model.EffectType;
import com.xoul.ru.magone.model.Target;
import com.xoul.ru.magone.model.spells.SpellDescriptor;
import com.xoul.ru.magone.model.spells.SpellType;

import java.util.LinkedList;
import java.util.List;

public class SpellListFragment extends Fragment {
    // TODO replace with real data
    private static List<SpellDescriptor> spells;

    static {
        spells = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            spells.add(new SpellDescriptor(false, 0, 0, SpellType.Damage, EffectType.SHIELD, Target.NOONE,
                    "Title " + Integer.toString(i + 1), "Description",
            0));
        }
    }

    private View backButton;
    private View.OnClickListener backButtonClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spells, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        backButton = view.findViewById(R.id.backButton);
        if (backButtonClickListener != null) {
            backButton.setOnClickListener(backButtonClickListener);
        }
        listView.setAdapter(new SpellAdapter(getActivity(), spells));
        return view;
    }

    public void setBackButtonClickListener(View.OnClickListener listener) {
        backButtonClickListener = listener;
        if (backButton != null) {
            backButton.setOnClickListener(backButtonClickListener);
        }
    }
}
