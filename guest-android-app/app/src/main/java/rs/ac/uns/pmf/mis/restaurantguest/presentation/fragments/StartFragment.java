package rs.ac.uns.pmf.mis.restaurantguest.presentation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import org.jetbrains.annotations.NotNull;

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
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        EditText inputAddress = view.findViewById(R.id.address);
        View addressLayout = view.findViewById(R.id.addressLayout);
        RadioGroup radioGroup = view.findViewById(R.id.optionRadioGroup);
        RadioButton optionRestaurant = radioGroup.findViewById(R.id.optionRestaurant);
        RadioButton optionHome = radioGroup.findViewById(R.id.optionHome);

        view.findViewById(R.id.goToMenuButton).setOnClickListener(v ->
                {
                    if (!inputAddress.getText().toString().trim().isEmpty() || optionRestaurant.isChecked()) {
                        Navigation.findNavController(v).navigate(R.id.action_startFragment_to_menuCategoryFragment);
                    } else {
                        inputAddress.setError(getString(R.string.take_a_way_address));
                    }
                }
        );

        optionRestaurant.setOnClickListener(v -> {
            if (optionRestaurant.isChecked()) {
                addressLayout.setVisibility(View.GONE);
            }
        });

        optionHome.setOnClickListener(v -> {
            if (optionHome.isChecked()) {
                addressLayout.setVisibility(View.VISIBLE);
            }
        });

    }

}