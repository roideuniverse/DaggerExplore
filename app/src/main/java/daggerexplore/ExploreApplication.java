package daggerexplore;

import android.app.Application;

import daggerexplore.dagger.DaggerFruitSellerComponent;
import daggerexplore.dagger.FruitSellerComponent;
import daggerexplore.dagger.FruitBasketModule;

/**
 * Created by kaushiksaurabh on 10/1/15.
 */
public class ExploreApplication extends Application
{
    private FruitSellerComponent mFruitSellerComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mFruitSellerComponent = DaggerFruitSellerComponent
                .builder()
                .fruitBasketModule(new FruitBasketModule(this))
                .build();
    }

    public FruitSellerComponent getExplorerComponent()
    {
        return mFruitSellerComponent;
    }
}
