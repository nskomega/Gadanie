package ru.nskom.gadanie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_ROWS = 3;
    private static final int NUM_COLS = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateButtons();

    }

    private void populateButtons() {
        String[][] bnt_name = {{"1", "2", "3", "4", "5", "6", "7", "8", "9"},
                {"1", "1", "1", "2", "1", "3", "1", "4", "1"},
                {"5", "1", "6", "1", "7", "1", "8", "1", "9"}};
        TableLayout table = (TableLayout) findViewById(R.id.tableForButtons);
        for (int row = 0; row < NUM_ROWS; row++) {
            TableRow tableRow = new TableRow(this);

            /* //раcтяжка на весь экран
            tableRow.setLayoutParams(new TableLayout.LayoutParams(

                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            */

            table.addView(tableRow);

            for (int col = 0; col < NUM_COLS; col++) {
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));

                button.setText(bnt_name[row][col]);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        gridButtonClicked();
                    }
                });

                tableRow.addView(button);
            }
        }
    }

    private void gridButtonClicked() {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
    }
}
