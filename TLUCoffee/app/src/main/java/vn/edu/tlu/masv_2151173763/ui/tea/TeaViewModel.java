package vn.edu.tlu.masv_2151173763.ui.tea;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TeaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TeaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}