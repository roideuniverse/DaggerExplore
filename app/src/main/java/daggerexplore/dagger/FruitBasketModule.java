package daggerexplore.dagger;

import daggerexplore.ExploreApplication;
import daggerexplore.models.Apple;
import daggerexplore.models.Banana;
import dagger.Provides;

/**
 * Created by kaushiksaurabh on 10/1/15.
 */
@dagger.Module
public class FruitBasketModule
{
    private final ExploreApplication mApplication;

    public FruitBasketModule(ExploreApplication application)
    {
        mApplication = application;
    }

    @Provides
    Apple providesApples()
    {
        return new Apple();
    }

    @Provides
    Banana providesBanana()
    {
        return new Banana();
    }
}
