package com.fastburngames.fanmerchandise.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fastburngames.fanmerchandise.ApparelItemAdapter;
import com.fastburngames.fanmerchandise.R;

/**
 * The Fragment that contains the RecyclerView displaying the Articles in a
 * GridLayout.
 */
public class ApparelRecyclerGridFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    // Member variables.
    private RecyclerView mRecyclerView;
    private ApparelItemAdapter mApparelItemAdapter;

    static ApparelRecyclerGridFragment newInstance(int index) {
        ApparelRecyclerGridFragment fragment = new ApparelRecyclerGridFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Initialize the root view of the fragment.
        View root = inflater.inflate(R.layout.fragment_article_recycler_grid, container, false);

        // Initialize the number of columns in the GridView.
        int gridColumnCount = getResources()
                .getInteger(R.integer.grid_column_count);

        // RecyclerView setup.
        mRecyclerView = root.findViewById(R.id.recycler_view_main);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getContext(),
                gridColumnCount));

        // ApparelItemAdapter setup.
        initializeAdapter();


        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    /**
     * Method initializes adapter and sets it to the RecyclerView.
     */
    private void initializeAdapter() {
        mApparelItemAdapter = new ApparelItemAdapter(this.getActivity());
        mRecyclerView.setAdapter(mApparelItemAdapter);
    }
}