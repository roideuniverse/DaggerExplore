package daggerexplore;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import daggerexplore.models.Apple;
import daggerexplore.models.Banana;

public class MainActivity extends AppCompatActivity
{
    @Inject Apple mApple;
    @Inject Banana mBanana;

    private TextView mTextViewApple;
    private TextView mTextViewBanana;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mTextViewApple = (TextView) findViewById(R.id.apple);
        mTextViewBanana = (TextView) findViewById(R.id.banana);

        ((ExploreApplication)getApplication()).getExplorerComponent().inject(this);
        Toast.makeText(getApplicationContext(), ":" + mApple, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), ":" + mBanana, Toast.LENGTH_SHORT).show();

        mTextViewApple.setText(mApple.toString());
        mTextViewBanana.setText(mBanana.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
