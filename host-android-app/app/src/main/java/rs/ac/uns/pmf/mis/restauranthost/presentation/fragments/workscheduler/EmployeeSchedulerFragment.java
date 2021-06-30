package rs.ac.uns.pmf.mis.restauranthost.presentation.fragments.workscheduler;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import rs.ac.uns.pmf.mis.restauranthost.R;
import rs.ac.uns.pmf.mis.restauranthost.data.MainRepository;
import rs.ac.uns.pmf.mis.restauranthost.framework.HostApplication;
import rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels.MainViewModel;
import rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels.MainViewModelFactory;

public class EmployeeSchedulerFragment extends Fragment {

    private Context context;
    private MainViewModel viewModel;
    private EditText workSchedulerNotesEditText;
    private Button saveButton;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public EmployeeSchedulerFragment() {
        // Required empty public constructor
    }

    public static EmployeeSchedulerFragment newInstance() {
        EmployeeSchedulerFragment fragment = new EmployeeSchedulerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_scheduler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        MainRepository mainRepository = ((HostApplication) context.getApplicationContext()).getMainRepository();
        viewModel = new ViewModelProvider(requireActivity(),
                new MainViewModelFactory(((HostApplication) context.getApplicationContext()), mainRepository))
                .get(MainViewModel.class);

        workSchedulerNotesEditText = view.findViewById(R.id.work_scheduler_notes);
        saveButton = view.findViewById(R.id.save);
        saveButton.setOnClickListener(v ->
                {
                    Toast.makeText(v.getContext(), v.getResources().getString(R.string.please_wait), Toast.LENGTH_SHORT).show();
                    viewModel.saveWorkSchedulerNotes(workSchedulerNotesEditText.getText().toString().trim());
                    new Handler().postDelayed(() -> getParentFragmentManager().popBackStack(), 2000);
                }
        );
    }
}