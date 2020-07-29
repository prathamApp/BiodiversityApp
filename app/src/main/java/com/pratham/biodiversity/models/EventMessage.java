package com.pratham.biodiversity.models;

import android.os.Bundle;

public class EventMessage {
    private String message;
    private Bundle bundle;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
