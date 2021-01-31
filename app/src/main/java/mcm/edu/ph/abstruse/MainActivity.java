package mcm.edu.ph.abstruse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button computePay;

        computePay = findViewById(R.id.computePay);

        computePay.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {

        EditText workTimeInput;
        TextView totalPay;

        workTimeInput = findViewById(R.id.workTimeInput);
        totalPay = findViewById(R.id.totalPayText);

        double workingHours = 0.0;
        double regularPay = 0.0;
        double overtimePay = 0.0;
        double totalPayout = 0.0;
        double answer = 0.0;
        double max = 8;


        double regularPayFormula, overtimePayFormula1, overtimePayFormula2;

        workingHours = Double.parseDouble(workTimeInput.getText().toString());
        regularPay = 100;
        overtimePay = 130;

        regularPayFormula = workingHours * regularPay;
        overtimePayFormula1 = workingHours - max;
        overtimePayFormula2 = overtimePayFormula1 * overtimePay;

        if (workingHours < 8) {
            totalPayout = regularPayFormula;
        }

        if (workingHours == 8) {
            totalPayout = 800;
        }

        if (workingHours > 8) {
            totalPayout = 800 + overtimePayFormula2;
        }

        switch (v.getId()) {
            case R.id.computePay:
                answer = totalPayout;
                totalPay.setText("Total Wage: PHP "+Double.toString(answer)+
                        "\nHours Rendered: "+Double.toString(workingHours)+
                        "\nHours in Overtme: "+Double.toString(overtimePayFormula1)+
                        "\nWage in Overtime: PHP "+Double.toString(overtimePayFormula2));

                break;
        }
    }
}