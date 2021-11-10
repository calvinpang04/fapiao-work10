package com.example.fapiao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    String[][] InvoiceNum = {{"08378923","23945023","23475478","10298725","12357893"},
            {"09823435","80740977","36822639","38786238","87204837"},
            {"82888991","02142605","21240109","78323535","18549847"},
            {"23985761","22315462","91903003","16228722","03270598"},
            {"23024453","99083726","23455252","98829035","45984442"},
            {"88515559","29017652","12339754","24000986","45263735"}};
    private TextView num,textView6;
    private EditText mynum;
    String Num;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        num = (TextView)findViewById(R.id.num);
        mynum = (EditText)findViewById(R.id.mynum);
        Intent intent =this.getIntent();
        Num = intent.getStringExtra("Num");
        switch(Num){
            case "JanFeb":
                num.setText(InvoiceNum[0][0]+"\n"+InvoiceNum[0][1]+"\n"+InvoiceNum[0][2]+"\n"+InvoiceNum[0][3]+"\n"+InvoiceNum[0][4]);
                count = 0;
                break;
            case "MarApr":
                num.setText(InvoiceNum[1][0]+"\n"+InvoiceNum[1][1]+"\n"+InvoiceNum[1][2]+"\n"+InvoiceNum[1][3]+"\n"+InvoiceNum[1][4]);
                count = 1;
                break;
            case "MayJun":
                num.setText(InvoiceNum[2][0]+"\n"+InvoiceNum[2][1]+"\n"+InvoiceNum[2][2]+"\n"+InvoiceNum[2][3]+"\n"+InvoiceNum[2][4]);
                count = 2;
                break;
            case "JulAug":
                num.setText(InvoiceNum[3][0]+"\n"+InvoiceNum[3][1]+"\n"+InvoiceNum[3][2]+"\n"+InvoiceNum[3][3]+"\n"+InvoiceNum[3][4]);
                count = 3;
                break;
            case "SepOct":
                num.setText(InvoiceNum[4][0]+"\n"+InvoiceNum[4][1]+"\n"+InvoiceNum[4][2]+"\n"+InvoiceNum[4][3]+"\n"+InvoiceNum[4][4]);
                count = 4;
                break;
            case "NovDec":
                num.setText(InvoiceNum[5][0]+"\n"+InvoiceNum[5][1]+"\n"+InvoiceNum[5][2]+"\n"+InvoiceNum[5][3]+"\n"+InvoiceNum[5][4]);
                count = 5;
                break;
        }

    }

    public void back(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity2.this, MainActivity.class);
        MainActivity2.this.finish();
    }

    public void result(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity2.this,MainActivity3.class);
        for(int j=2;j<5;j++) {
            if (mynum.getEditableText().toString().equals(InvoiceNum[count][0])) {
                intent.putExtra("Money", "1000萬元");
                intent.putExtra("Num", Num);
                startActivity(intent);
                MainActivity2.this.finish();
                break;
            }
            else if (mynum.getEditableText().toString().equals(InvoiceNum[count][1])) {
                intent.putExtra("Money", "200萬元");
                intent.putExtra("Num", Num);
                startActivity(intent);
                MainActivity2.this.finish();
                break;
            }
            else if (compares(mynum.getEditableText().toString(), 0, 8).equals(compares(InvoiceNum[count][j], 0, 8))) {
                intent.putExtra("Money", "20萬元");
                intent.putExtra("Num", Num);
                startActivity(intent);
                MainActivity2.this.finish();
                break;
            }
            else if (compares(mynum.getEditableText().toString(), 1, 8).equals(compares(InvoiceNum[count][j], 1, 8))) {
                intent.putExtra("Money", "4萬元");
                intent.putExtra("Num", Num);
                startActivity(intent);
                MainActivity2.this.finish();
                break;
            }
            else if (compares(mynum.getEditableText().toString(), 2, 8).equals(compares(InvoiceNum[count][j], 2, 8))) {
                intent.putExtra("Money", "1萬元");
                intent.putExtra("Num", Num);
                startActivity(intent);
                MainActivity2.this.finish();
                break;
            }
            else if (compares(mynum.getEditableText().toString(), 3, 8).equals(compares(InvoiceNum[count][j], 3, 8))) {
                intent.putExtra("Money", "4千元");
                intent.putExtra("Num", Num);
                startActivity(intent);
                MainActivity2.this.finish();
                break;
            }
            else if (compares(mynum.getEditableText().toString(), 4, 8).equals(compares(InvoiceNum[count][j], 4, 8))) {
                intent.putExtra("Money", "1千元");
                intent.putExtra("Num", Num);
                startActivity(intent);
                MainActivity2.this.finish();
                break;
            }
            else if (compares(mynum.getEditableText().toString(), 5, 8).equals(compares(InvoiceNum[count][j], 5, 8))) {
                intent.putExtra("Money", "2百元");
                intent.putExtra("Num", Num);
                startActivity(intent);
                MainActivity2.this.finish();
                break;
            }
            else if(j==4 && compares(mynum.getEditableText().toString(), 0, 8).equals(compares(InvoiceNum[count][j], 0, 8))==false){
                intent.putExtra("Money","再接再厲");
                intent.putExtra("Num",Num);
                startActivity(intent);
                MainActivity2.this.finish();
                break;
            }
        }
    }

    public String compares(String num, int i, int j){
        return num.substring(i,j);
    }
}