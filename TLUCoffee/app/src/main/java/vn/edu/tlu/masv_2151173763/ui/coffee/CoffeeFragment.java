package vn.edu.tlu.masv_2151173763.ui.coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import vn.edu.tlu.masv_2151173763.databinding.FragmentCoffeeBinding;

public class CoffeeFragment extends Fragment {

    private FragmentCoffeeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CoffeeViewModel coffeeViewModel =
                new ViewModelProvider(this).get(CoffeeViewModel.class);

        binding = FragmentCoffeeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        coffeeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}