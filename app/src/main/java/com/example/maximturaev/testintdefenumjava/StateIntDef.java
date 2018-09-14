package com.example.maximturaev.testintdefenumjava;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({StateIntDef.IDLE, StateIntDef.RUNNING, StateIntDef.FINISHED})
@Retention(RetentionPolicy.SOURCE)
@interface StateIntDef {
    int IDLE = 0;
    int RUNNING = 1;
    int FINISHED = 2;
}