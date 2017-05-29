package com.tieorange.leanmvpdatabinding.presentation.application.di;

import com.tieorange.leanmvpdatabinding.repository.cargo.CarGoService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrii.kovalchuk on 29/05/2017.
 */

@Module
public class ServiceModule {

    @Provides
    CarGoService providesCarGoService() {
        return new CarGoService();
    }

    /*
    * public OkHttpClient providesOkHttpClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient().newBuilder();
        if (BuildConfig.DEBUG) {
            final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(interceptor);
        }
        return clientBuilder
                .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
    }

    @Provides
    RxLocation providesRxLocation(Context context) {
        return new RxLocation(context);
    }*/
}
