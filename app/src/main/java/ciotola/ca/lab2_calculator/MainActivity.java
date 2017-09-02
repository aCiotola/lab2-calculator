package ciotola.ca.lab2_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText etLoanAmount, etTermAmount, etInterestAmount;
    TextView monthlyResult, totalResult, interestResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLoanAmount = (EditText) findViewById(R.id.loanNum);
        etTermAmount = (EditText) findViewById(R.id.termNum);
        etInterestAmount = (EditText) findViewById(R.id.yearlyNum);
        monthlyResult = (TextView) findViewById(R.id.monthlyRes);
        totalResult = (TextView) findViewById(R.id.totalRes);
        interestResult = (TextView) findViewById(R.id.interestRes);
    }

    public void calculateLoan(View v)
    {
        double loanAmt = Double.parseDouble(etLoanAmount.getText().toString());
        int termAmt = Integer.parseInt(etTermAmount.getText().toString());
        double intAmt = Double.parseDouble(etInterestAmount.getText().toString());
        LoanCalculator lc = new LoanCalculator(loanAmt, termAmt, intAmt);

        double monthPay = lc.getMonthlyPayment();
        double totalCost = lc.getTotalCostOfLoan();
        double interest = lc.getTotalInterest();
        monthlyResult.setText(String.format("%.2f", monthPay));
        totalResult.setText(String.format("%.2f", totalCost));
        interestResult.setText(String.format("%.2f", interest));
    }

    public void clearNums(View v)
    {
        etLoanAmount.setText("");
        etTermAmount.setText("");
        etInterestAmount.setText("");
        monthlyResult.setText("");
        totalResult.setText("");
        interestResult.setText("");
    }
}
