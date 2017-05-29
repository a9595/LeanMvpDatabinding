package com.tieorange.leanmvpdatabinding.presentation.application.di;

import com.tieorange.leanmvpdatabinding.repository.OrdersRepository;
import com.tieorange.leanmvpdatabinding.repository.cargo.CarGoService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {


    @Provides
    @Singleton
    OrdersRepository providesOrdersRepository(CarGoService carGoService){
        return new OrdersRepository(carGoService);
    }

    /*@Provides
    NeucaRepository providesRestNeucaRepository(
            NeucaService neucaService,
            ReservationEntityFactory reservationEntityFactory,
            ReservationItemEntityFactory reservationItemEntityFactory) {
        return new RestNeucaRepository(
                neucaService,
                reservationEntityFactory,
                reservationItemEntityFactory
        );
    }

    @Provides
    @Singleton
    ReservationsRepository providesReservationsRepository() {
        return new LocalReservationsRepository();
    }

    @Provides
    @Singleton
    DrugCategoryRepository providesDrugCategoryRepository(NeucaRepository repository) {
        return new NeucaDrugCategoryRepository(repository);
    }

    @Provides
    @Singleton
    LocationRepository providesLocationRepository(LocationService locationService) {
        return new NeucaLocationRepository(locationService);
    }*/
}
