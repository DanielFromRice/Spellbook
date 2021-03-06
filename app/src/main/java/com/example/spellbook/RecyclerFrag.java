package com.example.spellbook;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import io.vavr.collection.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerFrag extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
//    private String[] myDataset = {"Hello 123", "1234 who's the spell that we adore", "Supercalifragalisticexpialidocious"};

    private List<String> myData = List.of("Hello123", "Who's the one that we adore", "supercalifrabridged", "Hydrogen Peroxide", "Supperman", "Illiterally", "Nope", "321goodbyE", "Goopy Goblet Goblin", "Commander Wharf", "Doppler Effect Fiddles Rome Burns", "Herp-Di-Derp-etology");

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public RecyclerFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * //@param param1 Parameter 1.
     * //@param param2 Parameter 2.
     * @return A new instance of fragment RecyclerView.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerFrag newInstance() {
        RecyclerFrag fragment = new RecyclerFrag();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
        //recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter<MyAdapter.MyViewHolder> mAdapter = new MyAdapter(myData);
        recyclerView.setAdapter(mAdapter);
    }
}