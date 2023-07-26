package com.nocountry.powerfit.service.abstraction;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.nocountry.powerfit.model.request.PreferenceRequest;

public interface PreferenceService {
    Preference createPreference(PreferenceRequest request) throws MPException, MPApiException;



}
