package com.example.jxie.fixturefollower20;

import java.util.ArrayList;

/**
 * Created by pragyanbaidya on 2017-03-20.
 */

interface CallBack{
    void OnSuccess(ArrayList<Fixture> fixtures);
    void OnFail(String msg);
}

