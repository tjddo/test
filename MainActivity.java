import android.os.Bundle;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.CompoundButton;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOK;
    ImageView imgPet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = findViewById(R.id.Text1);
        chkAgree = findViewById(R.id.chkAgree);

        text2 = findViewById(R.id.Text2);
        rGroup1 = findViewById(R.id.Rgroup1);
        rdoDog = findViewById(R.id.RdoDog);
        rdoCat = findViewById(R.id.RdoCat);
        rdoRabbit = findViewById(R.id.RdoRabbit);

        btnOK = findViewById(R.id.btnOK);
        imgPet = findViewById(R.id.imgPet);

        // 초기 상태에서는 라디오 버튼과 텍스트를 숨깁니다.
        text2.setVisibility(View.INVISIBLE);
        rGroup1.setVisibility(View.INVISIBLE);
        rdoDog.setVisibility(View.INVISIBLE);
        rdoCat.setVisibility(View.INVISIBLE);
        rdoRabbit.setVisibility(View.INVISIBLE);
        btnOK.setVisibility(View.INVISIBLE);
        imgPet.setVisibility(View.INVISIBLE);

        // 체크박스 이벤트 리스너 설정
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // 체크박스가 체크되면 라디오 버튼과 텍스트를 보이도록 설정합니다.
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    rdoDog.setVisibility(View.VISIBLE);
                    rdoCat.setVisibility(View.VISIBLE);
                    rdoRabbit.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else {
                    // 체크박스가 체크 해제되면 라디오 버튼과 텍스트를 숨깁니다.
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    rdoDog.setVisibility(View.INVISIBLE);
                    rdoCat.setVisibility(View.INVISIBLE);
                    rdoRabbit.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                int checkedRadio = rGroup1.getCheckedRadioButtonId();
                if (checkedRadio == -1) {
                    Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 선택된 라디오 버튼에 따라 이미지 설정
                if (checkedRadio == R.id.RdoDog)
                    imgPet.setImageResource(R.drawable.dog);
                else if (checkedRadio == R.id.RdoCat)
                    imgPet.setImageResource(R.drawable.cat);
                else if (checkedRadio == R.id.RdoRabbit)
                    imgPet.setImageResource(R.drawable.rabbit);
            }
        });
    }
}
