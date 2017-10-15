package com.sureshjoshi.android.ndkexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.sureshjoshi.core.IntVector;
import com.sureshjoshi.core.SeePlusPlus;
import com.sureshjoshi.core.StringVector;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    static {
        // Use the same name as defined in app.gradle (do not add the 'lib' or the '.so')
        System.loadLibrary("SeePlusPlus");
    }

    private SeePlusPlus mCpp;

    @BindView(R.id.textview_multiply_int)
    TextView mTextviewMultiplyInt;

    @BindView(R.id.textview_multiply_double)
    TextView mTextviewMultiplyDouble;

    @BindView(R.id.textview_random_numbers)
    TextView mTextviewRandomNumbers;

    @BindView(R.id.textview_unsorted_strings)
    TextView mTextviewUnsortedStrings;

    @BindView(R.id.textview_sorted_strings)
    TextView mTextviewSortedStrings;

    @Bind(R.id.textview_android_studio_ndk_integration)
    TextView mTextviewAndroidStudioNdkIntegration;

    @OnClick(R.id.button_refresh)
    void onClick() {
        runNativeFunctions();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCpp = new SeePlusPlus();
        runNativeFunctions();
    }

    void runNativeFunctions() {
        mTextviewMultiplyInt.setText(runMultiplyInts());
        mTextviewMultiplyDouble.setText(runMultiplyDoubles());
        mTextviewRandomNumbers.setText(runRandomNumbers());
        mTextviewSortedStrings.setText(runSortString());
        mTextviewAndroidStudioNdkIntegration.setText(runAndroidStudioNativeString());
    }

    String runMultiplyInts() {
        // Generate two random ints in range 0..99
        Random randomGenerator = new Random();
        int x = randomGenerator.nextInt(100);
        int y = randomGenerator.nextInt(100);

        int result = mCpp.Multiply(x, y);

        return getString(R.string.multiply_int)
                + " " + Integer.toString(x)
                + " and " + Integer.toString(y) + " = " + Integer.toString(result);
    }

    String runMultiplyDoubles() {
        // Generate two random doubles in range 0..99
        double x = Math.random() * 100.0;
        double y = Math.random() * 100.0;

        double result = mCpp.Multiply(x, y);

        return getString(R.string.multiply_double)
                + " " + String.format("%.2f", x)
                + " and " + String.format("%.2f", y) + " = "
                + String.format("%.2f", result);
    }

    String runRandomNumbers() {
        // Print out random numbers
        Random randomGenerator = new Random();
        int size = randomGenerator.nextInt(10);
        IntVector numbers = mCpp.RandomNumbers(size);

        String message = getString(R.string.random_numbers) + " ";
        for (int i = 0; i < size; ++i) {
            message += numbers.get(i);
            message += " ";
        }
        return message;
    }

    String runSortString() {
        // Create an unsorted set of strings by splitting on commas
        String unsortedString = "lorem,ipsum,dolor,sit,amet,consectetur,adipiscing,elit";
        String[] unsortedStrings = unsortedString.split(",");

        StringVector unsortedStringVector = new StringVector();
        for (String value : unsortedStrings) {
            unsortedStringVector.add(value);
        }

        StringVector sortedStringVector = mCpp.Sort(unsortedStringVector);

        String message = getString(R.string.unsorted_strings) + " " + unsortedString;
        mTextviewUnsortedStrings.setText(message);

        StringBuilder sortedMessage = new StringBuilder();
        sortedMessage.append(getString(R.string.sorted_strings))
                .append(" ");
        int size = (int) sortedStringVector.size();
        for (int i = 0; i < size; ++i) {
            sortedMessage.append(sortedStringVector.get(i))
                    .append(",");
        }
        return sortedMessage.toString();
    }

    native String runAndroidStudioNativeString();

}
