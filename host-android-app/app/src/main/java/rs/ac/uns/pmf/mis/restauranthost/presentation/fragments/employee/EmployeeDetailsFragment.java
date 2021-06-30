package rs.ac.uns.pmf.mis.restauranthost.presentation.fragments.employee;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import rs.ac.uns.pmf.mis.restauranthost.R;
import rs.ac.uns.pmf.mis.restauranthost.data.MainRepository;
import rs.ac.uns.pmf.mis.restauranthost.domain.model.ManagerEmployeeItem;
import rs.ac.uns.pmf.mis.restauranthost.framework.HostApplication;
import rs.ac.uns.pmf.mis.restauranthost.presentation.adapters.ManagerEmployeesAdapter;
import rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels.MainViewModel;
import rs.ac.uns.pmf.mis.restauranthost.presentation.viewmodels.MainViewModelFactory;


public class EmployeeDetailsFragment extends Fragment {

    private Context context;
    private MainViewModel viewModel;
    private RecyclerView recyclerView;
    private ManagerEmployeesAdapter managerEmployeesAdapter;

    private AlertDialog.Builder builder;

    private ManagerEmployeeItem employee;

    public EmployeeDetailsFragment() {
        // Required empty public constructor
    }

    public static EmployeeDetailsFragment newInstance(ManagerEmployeeItem managerEmployeeItem) {
        EmployeeDetailsFragment fragment = new EmployeeDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("EMPLOYEE", managerEmployeeItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_details, container, false);
    }


    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != getArguments()) {
            employee = getArguments().getParcelable("EMPLOYEE");
        }
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        MainRepository mainRepository = ((HostApplication) context.getApplicationContext()).getMainRepository();
        viewModel = new ViewModelProvider(requireActivity(),
                new MainViewModelFactory(((HostApplication) context.getApplicationContext()), mainRepository))
                .get(MainViewModel.class);

        TextView idTextView = view.findViewById(R.id.employee_id);
        TextView firstNameTextView = view.findViewById(R.id.first_name);
        TextView secondNameTextView = view.findViewById(R.id.second_name);
        TextView workPositionTextView = view.findViewById(R.id.work_position);
        if (null != employee) {
            idTextView.setText(String.valueOf(employee.getEmployeeId()));
            firstNameTextView.setText(employee.getEmployeeFirstName());
            secondNameTextView.setText(employee.getEmployeeSecondName());
            workPositionTextView.setText(employee.getWorkPosition());
        }

        builder = new AlertDialog.Builder(view.getContext());
        View employeeEditableView = LayoutInflater.from(view.getContext()).inflate(R.layout.employee_item_editable, null);
        view.setOnClickListener(v -> {
            builder.setCancelable(false)
                    .setPositiveButton("Sačuvaj", (dialog, id) -> {
                        viewModel.saveEditedManagerEmployeeItems(
                                new ManagerEmployeeItem(
                                        Integer.parseInt(((EditText) employeeEditableView.findViewById(R.id.employee_id)).getText().toString().trim()),
                                        ((EditText) employeeEditableView.findViewById(R.id.first_name)).getText().toString().trim(),
                                        ((EditText) employeeEditableView.findViewById(R.id.second_name)).getText().toString().trim(),
                                        ((EditText) employeeEditableView.findViewById(R.id.work_position)).getText().toString().trim())
                        );
                        Toast.makeText(view.getContext(), "Novi podaci se salju na server...", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    });
            AlertDialog alert = builder.create();
            alert.setView(employeeEditableView);
            alert.setTitle("Ažuriranje podataka o zaposlenom");
            //setup dialog data
            ((EditText) employeeEditableView.findViewById(R.id.employee_id)).setText(idTextView.getText().toString().trim());
            ((EditText) employeeEditableView.findViewById(R.id.first_name)).setText(firstNameTextView.getText().toString().trim());
            ((EditText) employeeEditableView.findViewById(R.id.second_name)).setText(secondNameTextView.getText().toString().trim());
            ((EditText) employeeEditableView.findViewById(R.id.work_position)).setText(workPositionTextView.getText().toString().trim());
            alert.show();
        });

    }
}