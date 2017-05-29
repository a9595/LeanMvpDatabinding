package com.tieorange.leanmvpdatabinding.presentation.application.di;


import com.infullmobile.neuca.domain.usecases.UiThreadSchedule;
import com.tieorange.leanmvpdatabinding.domain.usecases.AsyncUseCaseSchedule;
import com.tieorange.leanmvpdatabinding.domain.usecases.UseCaseSchedule;
import com.tieorange.leanmvpdatabinding.domain.usecases.order.AppLoadsAllOrders;
import com.tieorange.leanmvpdatabinding.repository.OrdersRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    UseCaseSchedule providesUseCaseSchedule() {
        return new AsyncUseCaseSchedule();
    }

    @Provides
    UiThreadSchedule providesUiThreadSchedule() {
        return new UiThreadSchedule();
    }


    @Provides
    AppLoadsAllOrders providesUserLoadsAllOrders(UseCaseSchedule useCaseSchedule,
            OrdersRepository ordersRepository){
        return new AppLoadsAllOrders(useCaseSchedule, ordersRepository);
    }

    /*@Provides
    AppLoadsNextCategoryDrugsPage providesAppLoadsNextCategoryDrugsPage(
            UseCaseSchedule useCaseSchedule,
            NeucaRepository neucaRepository,
            ReservationsRepository reservationsRepository
    ) {
        return new AppLoadsNextCategoryDrugsPage(useCaseSchedule, neucaRepository, reservationsRepository);
    }*/
}