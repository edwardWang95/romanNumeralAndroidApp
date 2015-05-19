package com.iheartraddio.festivalApp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;


public class MainActivity  extends ActionBarActivity {

    public static final String IHEART_FESTIVAL_LABEL = "iHeartRadio Music Festival";
    private final RomanNumeralsUtil mRomanNumeralUtil = new RomanNumeralsUtil();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.list_event);
        List<String> list = getEventLabels();
        listView.setAdapter(new EventAdapter(this, list));
    }

    /**
     * Function:Creates labels to be placed into list view.
     * @return
     */
    private List<String> getEventLabels() {
        return Arrays.asList(
                formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 12),
                formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 2244),
                formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 1243),
                formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 772),
                formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 123));
    }

    /**
     * Function:Returns a label of the new string.
     * @param label
     * @param number
     * @return
     */
    private String formatWithRomanNumeral(String label, int number) {
        final String possibleRomanNumeral = mRomanNumeralUtil.convertToRomanNumeral(number);
        if(!mRomanNumeralUtil.isValidRomanNumeral(possibleRomanNumeral)) {
            return "";
        }
        return label + " " + possibleRomanNumeral;
    }
}
