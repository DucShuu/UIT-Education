package com.example.ducdv.uiteducation.ui.contract;

import java.util.HashMap;
import java.util.List;

/**
 * Created by DucDV on 01/28/2018.
 */

public interface DSubjectView {

    void displayView(List<String> header, HashMap<String, List<String>> listChildContent);

    void showError(String message);

}
