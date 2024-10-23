package vn.edu.tlu.masv_2151173763.ui.tea;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import vn.edu.tlu.masv_2151173763.databinding.FragmentTeaBinding;

public class TeaFragment extends Fragment {

    private FragmentTeaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TeaViewModel teaViewModel =
                new ViewModelProvider(this).get(TeaViewModel.class);

        binding = FragmentTeaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.texttea;
        teaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}