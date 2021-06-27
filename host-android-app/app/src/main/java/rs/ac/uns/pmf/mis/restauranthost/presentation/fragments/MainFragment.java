package rs.ac.uns.pmf.mis.restauranthost.presentation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import rs.ac.uns.pmf.mis.restauranthost.R;
import rs.ac.uns.pmf.mis.restauranthost.presentation.fragments.manager.ManagerFragment;
import rs.ac.uns.pmf.mis.restauranthost.presentation.fragments.orders.OrderFragment;
import rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels.MainViewModel;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    private Button managerButton;
    private Button waiterButton;
    private Button chefButton;
    private Button bartenderButton;

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        managerButton = view.findViewById(R.id.manager);
        managerButton.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, ManagerFragment.newInstance())
                    .commit();
        });

        waiterButton = view.findViewById(R.id.waiter);
        waiterButton.setOnClickListener(v -> Toast.makeText(v.getContext(), "Konobar", Toast.LENGTH_SHORT).show());

        chefButton = view.findViewById(R.id.chef);
        chefButton.setOnClickListener(v -> Toast.makeText(v.getContext(), "Kuvar", Toast.LENGTH_SHORT).show());

        bartenderButton = view.findViewById(R.id.bartender);
        bartenderButton.setOnClickListener(v -> Toast.makeText(v.getContext(), "Sanker", Toast.LENGTH_SHORT).show());
    }

}