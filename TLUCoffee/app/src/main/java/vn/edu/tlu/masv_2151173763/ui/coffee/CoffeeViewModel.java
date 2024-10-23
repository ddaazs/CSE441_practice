package vn.edu.tlu.masv_2151173763.ui.coffee;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CoffeeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CoffeeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}