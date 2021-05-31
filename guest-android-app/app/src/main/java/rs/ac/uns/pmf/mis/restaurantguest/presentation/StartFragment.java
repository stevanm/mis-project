package rs.ac.uns.pmf.mis.restaurantguest.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import rs.ac.uns.pmf.mis.restaurantguest.R;


public class StartFragment extends Fragment {

    public StartFragment() {
        // Required empty public constructor
    }

    public static StartFragment newInstance(String param1, String param2) {
        StartFragment fragment = new StartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        view.findViewById(R.id.guest).setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_startFragment_to_menuFragment));
        view.findViewById(R.id.waiter).setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_startFragment_to_loginFragment));
        return view;
    }
}