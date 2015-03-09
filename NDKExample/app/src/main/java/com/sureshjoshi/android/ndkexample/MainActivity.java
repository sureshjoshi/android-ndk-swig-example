package com.sureshjoshi.android.ndkexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.sureshjoshi.core.IntVector;
import com.sureshjoshi.core.SeePlusPlus;
import com.sureshjoshi.core.StringVector;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    static {
        // Use the same name as defined in app.gradle (do not add the 'lib' or the '.so')
        System.loadLibrary("SeePlusPlus");
    }

    private SeePlusPlus _cpp;

    @InjectView(R.id.textview_multiply_int)
    TextView textviewMultiplyInt;

    @InjectView(R.id.textview_multiply_double)
    TextView textviewMultiplyDouble;

    @InjectView(R.id.textview_random_numbers)
    TextView textviewRandomNumbers;

    @InjectView(R.id.textview_unsorted_strings)
    TextView textviewUnsortedStrings;

    @InjectView(R.id.textview_sorted_strings)
    TextView textviewSortedStrings;

    @OnClick(R.id.button_refresh)
    void onClick() {
        runNativeFunctions();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        _cpp = new SeePlusPlus();
        runNativeFunctions();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void runNativeFunctions() {
        runMultiplyInts();
        runMultiplyDoubles();
        runRandomNumbers();
        runSortString();
    }

    private void runMultiplyInts() {
        // Generate two random ints in range 0..99
        Random randomGenerator = new Random();
        int x = randomGenerator.nextInt(100);
        int y = randomGenerator.nextInt(100);

        int result = _cpp.Multiply(x, y);

        String message = getString(R.string.multiply_int)
                + " " + Integer.toString(x)
                + " and " + Integer.toString(y) + " = " + Integer.toString(result);
        textviewMultiplyInt.setText(message);
    }

    private void runMultiplyDoubles() {
        // Generate two random doubles in range 0..99
        double x = Math.random() * 100.0;
        double y = Math.random() * 100.0;

        double result = _cpp.Multiply(x, y);

        String message = getString(R.string.multiply_double)
                + " " + String.format("%.2f", x)
                + " and " + String.format("%.2f", y) + " = "
                + String.format("%.2f", result);
        textviewMultiplyDouble.setText(message);
    }

    private void runRandomNumbers() {
        // Print out random numbers
        Random randomGenerator = new Random();
        int size = randomGenerator.nextInt(10);
        IntVector numbers = _cpp.RandomNumbers(size);

        String message = getString(R.string.random_numbers) + " ";
        for (int i = 0; i < size; ++i) {
            message += numbers.get(i);
            message += " ";
        }
        textviewRandomNumbers.setText(message);
    }

    private void runSortString() {
        // Create an unsorted set of strings by splitting on whitespace
        String unsortedString = "lorem,ipsum,dolor,sit,amet,consectetur,adipiscing,elit";
        String[] unsortedStrings = unsortedString.split(",");

        StringVector unsortedStringVector = new StringVector();
        for (String value : unsortedStrings) {
            unsortedStringVector.add(value);
        }

        StringVector sortedStringVector = _cpp.Sort(unsortedStringVector);

        String message = getString(R.string.unsorted_strings) + " " + unsortedString;
        textviewUnsortedStrings.setText(message);

        message = getString(R.string.sorted_strings) + " ";
        for (int i = 0; i < sortedStringVector.size(); ++i) {
            message += sortedStringVector.get(i);
            message += ",";
        }
        textviewSortedStrings.setText(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
