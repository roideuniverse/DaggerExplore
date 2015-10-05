package daggerexplore.dagger;

import daggerexplore.MainActivity;

/**
 * Created by kaushiksaurabh on 10/1/15.
 */
@dagger.Component(modules = FruitBasketModule.class)
public interface FruitSellerComponent
{
    void inject(MainActivity activity);

}
